package com.tencent.mobileqq.activity.aio.photo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.qphone.base.util.QLog;
import fxu;
import fxz;

public class AIOGalleryActivity
  extends PeakActivity
{
  int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  GalleryManager jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = new fxu(this, null);
  public IAIOImageProvider a;
  private DCAIOPreview jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview;
  private DCAIOPreviewProgressive jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive;
  boolean jdField_a_of_type_Boolean = false;
  
  public DCAIOPreview a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview = new DCAIOPreview(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview;
  }
  
  public DCAIOPreviewProgressive a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive = new DCAIOPreviewProgressive(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AIOConstants.a = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview = new DCAIOPreview(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive = new DCAIOPreviewProgressive(this);
    try
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(this);
      paramBundle = getWindow();
      paramBundle.addFlags(1024);
      if (Build.VERSION.SDK_INT >= 14) {
        paramBundle.getAttributes().systemUiVisibility = 1;
      }
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e(g, 2, "", paramBundle);
      }
      finish();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a();
      label20:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.c(this);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview.b(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive.a();
      }
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(g, 2, localException.getMessage());
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new fxz(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */