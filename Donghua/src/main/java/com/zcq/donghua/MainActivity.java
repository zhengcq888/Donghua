package com.zcq.donghua;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tv;
    private ImageView iv;
    private Animation tvAnim;
    private Animation ivAnim;
    private Animation disappearAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.img);

        tvAnim = AnimationUtils.loadAnimation(this, R.anim.textanim);
        ivAnim = AnimationUtils.loadAnimation(this, R.anim.imganim);
        disappearAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.disappear);

        if(ivAnim == null) return;
        iv.startAnimation(ivAnim);

        ivAnim.setAnimationListener(ivanimListener);
        tvAnim.setAnimationListener(tvanimListener);

    }

    // 图片旋转的动画监听
    Animation.AnimationListener ivanimListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            tv.setVisibility(View.VISIBLE);
            tv.startAnimation(tvAnim);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    // 文字显示的动画监听
    Animation.AnimationListener tvanimListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(disappearAnim == null) return;
            tv.startAnimation(disappearAnim);
            iv.startAnimation(disappearAnim);
            disappearAnim.setAnimationListener(disapearListener);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    // 图片和文字消失的动画监听
    Animation.AnimationListener disapearListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            // 隐藏文字和图片
            tv.setVisibility(View.GONE);
            iv.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
