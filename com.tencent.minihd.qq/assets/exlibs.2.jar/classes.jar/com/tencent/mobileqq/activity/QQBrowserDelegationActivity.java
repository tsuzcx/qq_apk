package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;
import esa;

public class QQBrowserDelegationActivity
  extends BaseActivity
{
  public static final int a = 10012120;
  public static final String a = "param_force_internal_browser";
  public static final int b = 10012121;
  public static final String b = "发现";
  public static final int c = 10012122;
  private static final String c = "QQBrowserDelegationActivity";
  private long jdField_a_of_type_Long = -1L;
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a()
  {
    Intent localIntent = new Intent(getIntent());
    localIntent.putExtra("needSkey", "true");
    localIntent.setClass(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.a());
    startActivity(localIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    if (this.jdField_a_of_type_AndroidContentIntent.getExtras() == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("appShareID", -1L);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isAppShare", false);
    return false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    runOnUiThread(new esa(this));
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    mAppForground = GesturePWDUtils.getAppForground(getActivity());
    if (QLog.isDevelopLevel()) {
      QLog.d("QQBrowserDelegationActivity", 4, "onResume.mAppForground = " + mAppForground + ",mCanLock=" + this.mCanLock);
    }
    if ((!mAppForground) && (this.mCanLock) && (this.app != null) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.a()))) {
      startUnlockActivity();
    }
    if (!mAppForground)
    {
      mAppForground = true;
      GesturePWDUtils.setAppForground(getActivity(), mAppForground);
    }
    this.mStopFlag = 0;
    this.mCanLock = true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserDelegationActivity
 * JD-Core Version:    0.7.0.1
 */