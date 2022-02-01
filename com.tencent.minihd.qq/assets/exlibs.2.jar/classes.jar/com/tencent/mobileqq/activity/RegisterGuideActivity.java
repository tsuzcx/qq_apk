package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SizeMeasure;
import exk;
import exl;
import mqq.app.AppActivity;

public class RegisterGuideActivity
  extends AppActivity
  implements View.OnClickListener
{
  private static final float jdField_a_of_type_Float = 0.95F;
  private static final int jdField_a_of_type_Int = 800;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public QQAppInterface a;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a()
  {
    int i = (int)(getResources().getDisplayMetrics().heightPixels * 0.15F);
    int j = getResources().getDimensionPixelSize(2131493405);
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = Math.max(i, j);
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (PrivacyPolicyHelper.a(0))
    {
      runOnUiThread(new exk(this));
      bool = true;
    }
    return bool;
  }
  
  private void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841964);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void c()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(1.0F, 0.95F, 1.0F, 0.95F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(800L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(this.jdField_a_of_type_AndroidViewView.getHeight() / 2));
    localTranslateAnimation.setDuration(800L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setFillAfter(true);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(800L);
    ((Animation)localObject).setFillBefore(true);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
  }
  
  protected void doOnBackPressed()
  {
    finish();
    if ((getAppRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)super.getAppRuntime()).b(false);
    }
  }
  
  protected void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    SizeMeasure.b(this);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    SizeMeasure.b(this);
    super.setContentView(2130903364);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297935));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297470);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    a();
    b();
    super.findViewById(2131297936).setOnClickListener(this);
    super.findViewById(2131297937).setOnClickListener(this);
    if ((getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    }
    a();
    return true;
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      new Handler().post(new exl(this));
    }
  }
  
  public void onClick(View paramView)
  {
    if (a()) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297936: 
      paramView = getIntent();
      paramView.setClass(this, LoginActivity.class);
      paramView.addFlags(67108864);
      paramView.putExtra("from_register_guide", true);
      super.startActivity(paramView);
      finish();
      return;
    }
    paramView = new Intent(this, RegisterPhoneNumActivity.class);
    paramView.putExtra("leftViewText", super.getString(2131366374));
    paramView.addFlags(67108864);
    super.startActivity(paramView);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    Activity localActivity = getActivity();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();; str = "") {
      return PrivacyPolicyHelper.a(localActivity, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterGuideActivity
 * JD-Core Version:    0.7.0.1
 */