package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.particle.ParticleView;
import com.tencent.mobileqq.activity.particle.ParticleView.ParticleLauncher;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import fmv;
import fmw;
import fmx;
import fmz;
import fna;
import fnb;
import fnc;
import fnd;
import java.util.Random;

public class UserguideFaceMaskActivity
  extends UserguideBaseActivity
{
  public static final int a = 1;
  public static final int b = 2;
  private static final String jdField_b_of_type_JavaLangString = "UserguideFaceMaskActivity";
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  private float jdField_a_of_type_Float;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private View jdField_a_of_type_AndroidViewView = null;
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private ParticleView jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private ParticleView jdField_b_of_type_ComTencentMobileqqActivityParticleParticleView;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  
  public UserguideFaceMaskActivity()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void c()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 232, "未成功开启摄像头", " 欢迎进入QQ，体验 “ 视频美颜 ” 功能", new fmz(this), null);
    localQQCustomDialog.setOnKeyListener(new fna(this));
    localQQCustomDialog.show();
  }
  
  private void c(View paramView)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968714);
    localAnimation.setAnimationListener(new fnc(this, paramView));
    paramView.startAnimation(localAnimation);
  }
  
  private void d()
  {
    e();
    f();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView = new ParticleView(this);
    Object localObject2 = SkinUtils.a(getResources().getDrawable(2130840613));
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView.a();
    ((ParticleView.ParticleLauncher)localObject1).a((Bitmap)localObject2, new Random(100510L));
    localObject2 = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Int = ((DisplayMetrics)localObject2).widthPixels;
    this.jdField_d_of_type_Int = ((DisplayMetrics)localObject2).heightPixels;
    ((ParticleView.ParticleLauncher)localObject1).jdField_c_of_type_Float = (this.jdField_c_of_type_Int / 2);
    ((ParticleView.ParticleLauncher)localObject1).jdField_d_of_type_Float = (this.jdField_d_of_type_Int / 2);
    ((ParticleView.ParticleLauncher)localObject1).e = -1000.0F;
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityParticleParticleView, (ViewGroup.LayoutParams)localObject1);
  }
  
  private void f()
  {
    View localView = findViewById(2131300650);
    ((TextView)localView.findViewById(2131300652)).setText(new Random(System.currentTimeMillis()).nextInt() % 5 + 25 + "%");
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968714);
    localAnimation.setAnimationListener(new fnb(this, localView));
    localView.startAnimation(localAnimation);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840610);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = (getResources().getDisplayMetrics().widthPixels * 8 / 100);
    localLayoutParams.bottomMargin = 30;
    localLayoutParams.addRule(2, 2131298291);
    localLayoutParams.addRule(9);
    ((RelativeLayout)findViewById(2131298290)).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  private void h()
  {
    this.jdField_d_of_type_Boolean = true;
    startActivity(new Intent(this, UserguideThirdActivity.class));
    finish();
    overridePendingTransition(2130968593, 2130968594);
  }
  
  private void i()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityParticleParticleView = new ParticleView(this);
    Object localObject = SkinUtils.a(getResources().getDrawable(2130840613));
    ParticleView.ParticleLauncher localParticleLauncher = this.jdField_b_of_type_ComTencentMobileqqActivityParticleParticleView.a();
    localParticleLauncher.a((Bitmap)localObject, new Random(100510L));
    localObject = findViewById(2131300654);
    int i = ((View)localObject).getMeasuredWidth();
    int j = ((View)localObject).getMeasuredHeight();
    localParticleLauncher.a = 10;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localParticleLauncher.jdField_d_of_type_Int = 3;
    localParticleLauncher.jdField_b_of_type_Int = 8;
    localParticleLauncher.jdField_c_of_type_Int = 8;
    QLog.d("UserguideFaceMaskActivity", 2, "bauty.left:" + ((View)localObject).getLeft() + "  top:" + findViewById(2131300653).getTop());
    localParticleLauncher.jdField_c_of_type_Float = (((View)localObject).getLeft() + (i + 60));
    localParticleLauncher.jdField_d_of_type_Float = (findViewById(2131300653).getTop() + (j + 40) / 2);
    localParticleLauncher.e = -1000.0F;
    localParticleLauncher.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_ComTencentMobileqqActivityParticleParticleView, localLayoutParams);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideFaceMaskActivity", 2, "onClickSeekBar:" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    a(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904058);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131300647));
    this.jdField_a_of_type_AndroidOsHandler = new fnd(this);
    findViewById(2131300657).setOnClickListener(new fmv(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298289);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new fmw(this));
    g();
    this.jdField_a_of_type_AndroidWidgetButton.setText("确认效果");
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new fmx(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    UserguideActivity.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(5)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(4)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      }
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      }
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    label100:
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      continue;
      float f2 = paramMotionEvent.getX() - this.jdField_a_of_type_Float;
      if (f2 > 0.0F) {}
      for (float f1 = f2;; f1 = -f2)
      {
        if ((f1 <= this.jdField_b_of_type_Float) || (f2 >= 0.0F) || (!this.jdField_a_of_type_Boolean)) {
          break label100;
        }
        h();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UserguideFaceMaskActivity
 * JD-Core Version:    0.7.0.1
 */