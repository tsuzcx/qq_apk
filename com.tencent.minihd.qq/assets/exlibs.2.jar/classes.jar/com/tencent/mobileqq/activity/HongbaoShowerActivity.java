package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.ResultData;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import edy;
import edz;
import eea;

public class HongbaoShowerActivity
  extends BaseActivity
{
  public static final int a = 1000;
  public static final String a = "a_hb_type";
  public static final int b = 0;
  public static final String b = "a_hg_url";
  public static final int c = 1;
  public static final String c = "a_hb_task_id";
  public static final String d = "a_hb_from";
  private static final String e = "PortalManager.HongbaoShowerActivity";
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private ImageView c;
  private int d;
  private String f;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296707));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296702));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296703));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296704));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296705));
    this.c = ((ImageView)findViewById(2131296706));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new edy(this));
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(5000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -0.7F, 2, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new HongbaoShowerActivity.BounceInterpolator(this));
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setStartOffset(200L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new edz(this));
  }
  
  private void a(View paramView)
  {
    paramView.setOnClickListener(new eea(this));
  }
  
  private void a(ImageView paramImageView)
  {
    Resources localResources = getResources();
    paramImageView.setImageDrawable(new StatableBitmapDrawable(localResources, BitmapFactory.decodeResource(localResources, 2130837546), true));
  }
  
  private void a(ImageView paramImageView, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      paramImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("PortalManager.HongbaoShowerActivity", 2, "HongbaoLogo == null");
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PortalManager.HongbaoShowerActivity", 2, paramString);
    }
    paramString = new Intent();
    paramString.putExtra("retCode", paramInt);
    setResult(0, paramString);
    finish();
  }
  
  @TargetApi(11)
  private void a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleX(0.9F);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleY(0.9F);
      this.c.setScaleX(0.9F);
      this.c.setScaleY(0.9F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleY(1.0F);
    this.c.setScaleX(1.0F);
    this.c.setScaleY(1.0F);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HongbaoShowerActivity", 2, "showHongbaoResult mGiftUrl " + this.f);
    }
    if (this.f == null) {
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", this.f);
    localIntent.putExtra("show_right_close_button", true);
    localIntent.putExtra("finish_animation_up_down", true);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    setResult(-1);
    finish();
    overridePendingTransition(2130968586, 0);
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void doOnBackPressed()
  {
    setResult(-1);
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      a("intent is null!", 1);
      finish();
      return false;
    }
    try
    {
      this.d = paramBundle.getIntExtra("a_hb_type", 0);
      this.f = getIntent().getStringExtra("a_hg_url");
      i = getIntent().getIntExtra("a_hb_task_id", -1);
      QLog.d("PortalManager.HongbaoShowerActivity", 1, 256 + i + ", " + this.d + ", " + this.f + ", " + getIntent().getIntExtra("a_hb_from", -1));
      if ((i < 0) || (this.d < 0) || (this.d > 1))
      {
        a("", 1);
        finish();
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      int i;
      for (;;)
      {
        QLog.e("PortalManager.HongbaoShowerActivity", 2, "getExtra Exception", paramBundle);
        finish();
        i = -1;
      }
      paramBundle = ((PortalManager)this.app.getManager(74)).a(this.d, i);
      if (paramBundle == null)
      {
        a("找不到对应的任务！相关信息", 2);
        finish();
        return false;
      }
      if (TextUtils.isEmpty(paramBundle.jdField_a_of_type_JavaLangString))
      {
        a("中奖提示为空！！相关信息", 3);
        finish();
        return false;
      }
      if (this.d != 1) {
        break label343;
      }
    }
    setContentView(2130903077);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131296702));
    this.c = ((ImageView)findViewById(2131296706));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296707));
    a(paramBundle.jdField_a_of_type_JavaLangString);
    a(this.c, paramBundle.jdField_a_of_type_AndroidGraphicsBitmap);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramBundle.jdField_a_of_type_JavaLangString);
    for (;;)
    {
      return true;
      label343:
      setContentView(2130903076);
      a();
      a(paramBundle.jdField_a_of_type_JavaLangString);
      a(this.c, paramBundle.jdField_a_of_type_AndroidGraphicsBitmap);
      a(this.jdField_b_of_type_AndroidWidgetImageView);
      c();
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramBundle.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity
 * JD-Core Version:    0.7.0.1
 */