package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import hgn;
import hgo;
import mqq.app.BaseActivity;

public class BaseActivity2
  extends BaseActivity
  implements SkinnableActivityProcesser.Callback
{
  private static final int jdField_a_of_type_Int = 2;
  public static BaseActivity2 a;
  private static ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener;
  private static boolean jdField_a_of_type_Boolean;
  protected static final String g;
  public static boolean h;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  public ScreenShot a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  protected int f;
  public boolean f;
  protected boolean g;
  protected String h;
  
  static
  {
    jdField_g_of_type_JavaLangString = BaseActivity2.class.getSimpleName();
    jdField_h_of_type_Boolean = true;
  }
  
  public BaseActivity2()
  {
    this.jdField_f_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Boolean = true;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (jdField_a_of_type_ComTencentMobileqqAppShakeListener == null) {
        new hgn(this).start();
      }
    }
    while (jdField_a_of_type_ComTencentMobileqqAppShakeListener == null) {
      return;
    }
    ((SensorManager)getSystemService("sensor")).unregisterListener(jdField_a_of_type_ComTencentMobileqqAppShakeListener);
    jdField_a_of_type_ComTencentMobileqqAppShakeListener = null;
  }
  
  private boolean a(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while (((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT"))) || ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.PICK"))));
        paramIntent = paramIntent.getComponent();
        if (paramIntent == null) {
          break;
        }
        str = paramIntent.getPackageName();
      } while ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone")));
      paramIntent = paramIntent.getClassName();
    } while ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")));
    return false;
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (!this.bActivityToFragment) {
      bool = true;
    }
    return bool;
  }
  
  private final boolean b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    label198:
    do
    {
      return false;
      Object localObject = paramIntent.getComponent();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((ComponentName)localObject).getClassName())
      {
        if (localObject == null) {
          break label198;
        }
        if ((((this instanceof PhotoPreviewActivity)) && ((((String)localObject).endsWith("QzoneGPUPluginProxyActivity")) || (((String)localObject).endsWith("SendPhotoActivity")))) || (((this instanceof PhotoListActivity)) && (((String)localObject).endsWith("QzoneGPUPluginProxyActivity"))) || (((String)localObject).endsWith("SplashActivity")) || (((String)localObject).endsWith("LoginActivity")) || (((String)localObject).endsWith("Conversation")) || (((String)localObject).endsWith("Call")) || (((String)localObject).endsWith("Contacts")) || (((String)localObject).endsWith("Leba")) || (((String)localObject).endsWith("UpgradeActivity")) || (((String)localObject).endsWith("UserguideActivity")) || (((String)localObject).endsWith("InstallActivity")) || (((String)localObject).endsWith("RegisterGuideActivity")) || (((String)localObject).endsWith("QlinkBridgeActivity")) || (((String)localObject).endsWith("AVActivity"))) {
          break;
        }
        if ((!((String)localObject).endsWith("ChatActivity")) && (!((String)localObject).endsWith("LiteActivity"))) {
          break label198;
        }
        return true;
      }
      paramIntent = paramIntent.getAction();
    } while ((paramIntent != null) && (paramIntent.length() > 0));
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.a();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot = null;
    }
  }
  
  private boolean c(Intent paramIntent)
  {
    paramIntent = paramIntent.getComponent();
    if (paramIntent == null) {}
    for (paramIntent = null; (paramIntent != null) && ((paramIntent.endsWith("QQBrowserDelegationActivity")) || (paramIntent.endsWith("PayBridgeActivity")) || (paramIntent.endsWith("TroopAvatarWallPreviewActivity")) || (paramIntent.endsWith("PhotoListActivity")) || (paramIntent.endsWith("PhotoCropActivity")) || (paramIntent.endsWith("UniformDownloadActivity"))); paramIntent = paramIntent.getClassName()) {
      return true;
    }
    return false;
  }
  
  protected void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 4, "startUnlockActivity..." + this.jdField_a_of_type_JavaLangString);
    }
    startActivity(new Intent(this, GesturePWDUnlockActivity.class));
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 4, "checkUnlockForSpecial. flag=,AbsAppInter.visibleActCnt=?,stopflag" + this.jdField_f_of_type_Int);
    }
  }
  
  public void onBackPressed()
  {
    try
    {
      super.onBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_g_of_type_JavaLangString, 2, Log.getStackTraceString(localThrowable));
      }
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onConfigurationChanged(paramConfiguration);
    }
    SizeMeasure.b(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onCreate task : " + getTaskId());
    }
    SizeMeasure.b(this);
    try
    {
      paramBundle = BaseApplicationImpl.a;
      if (Build.VERSION.SDK_INT <= 10) {
        break label289;
      }
      i = 4;
    }
    catch (IllegalStateException paramBundle)
    {
      try
      {
        for (;;)
        {
          registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
          return;
          int i = 0;
          continue;
          paramBundle = paramBundle;
          this.jdField_h_of_type_JavaLangString = null;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_g_of_type_JavaLangString, 2, "Get lastLoginUin error", paramBundle);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingGestureHandler(this);
      }
      catch (Exception paramBundle)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(jdField_g_of_type_JavaLangString, 2, "registerReceiver error", paramBundle);
      }
    }
    this.jdField_h_of_type_JavaLangString = paramBundle.getSharedPreferences("Last_Login", i).getString("uin", null);
    if ((this.jdField_h_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d(jdField_g_of_type_JavaLangString, 1, "last uin is null.. has porblem?");
    }
    StatisticCollector.a(this).a(this);
    if (InitSkin.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      i = paramBundle.getInt("fling_action_key");
      if ((i != 0) && (a()))
      {
        if (1 != i) {
          break label320;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = new FlingTrackerHandler(this);
      }
    }
    if (!jdField_a_of_type_Boolean)
    {
      if (SettingCloneUtil.readValue(this, null, getString(2131366269), "qqsetting_screenshot_key", false)) {
        a(true);
      }
      jdField_a_of_type_Boolean = true;
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new hgo(this, null);
    label289:
    label320:
    return;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " process id =" + Process.myPid() + " onDestroy task : " + getTaskId());
    }
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = null;
    StatisticCollector.a(this).d(this);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label105:
      if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
        this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
      }
      return;
    }
    catch (Exception localException)
    {
      break label105;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onPause");
    }
    this.jdField_f_of_type_Boolean = true;
    StatisticCollector.a(this).c(this);
    c();
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  @TargetApi(9)
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onResume ");
    }
    this.jdField_f_of_type_Boolean = false;
    StatisticCollector.a(this).b(this);
    jdField_a_of_type_ComTencentMobileqqAppBaseActivity2 = this;
    int i;
    SharedPreferences.Editor localEditor;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      localEditor = getSharedPreferences("screen_shot", i).edit();
      localEditor.putString("currentactivity", getClass().getName());
      if (Build.VERSION.SDK_INT <= 8) {
        break label254;
      }
      localEditor.apply();
      label131:
      jdField_h_of_type_Boolean = GesturePWDUtils.getAppForground(this);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_g_of_type_JavaLangString, 4, "onResume.mAppForground = " + jdField_h_of_type_Boolean + ",mCanLock=" + this.jdField_g_of_type_Boolean);
      }
      if ((jdField_h_of_type_Boolean) || (!this.jdField_g_of_type_Boolean) || (this.jdField_h_of_type_JavaLangString == null) || (!GesturePWDUtils.getJumpLock(this, this.jdField_h_of_type_JavaLangString))) {
        break label264;
      }
      a();
    }
    for (;;)
    {
      if (!jdField_h_of_type_Boolean)
      {
        jdField_h_of_type_Boolean = true;
        GesturePWDUtils.setAppForground(this, jdField_h_of_type_Boolean);
      }
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Boolean = true;
      return;
      i = 0;
      break;
      label254:
      localEditor.commit();
      break label131;
      label264:
      if ((!jdField_h_of_type_Boolean) && (this.jdField_g_of_type_Boolean)) {
        b();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStart");
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "[" + hashCode() + "]" + this.jdField_a_of_type_JavaLangString + " onStop");
    }
    this.jdField_f_of_type_Int = 1;
    jdField_h_of_type_Boolean = GesturePWDUtils.isAppOnForeground(this);
    if (!jdField_h_of_type_Boolean) {
      GesturePWDUtils.setAppForground(this, jdField_h_of_type_Boolean);
    }
    if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler.onStop();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_g_of_type_JavaLangString, 2, "zsw subaccount onStop stop get sub msg AbsAppInter.visibleActCnt = ?");
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.jdField_f_of_type_Int = 2;
    if (a(paramIntent)) {
      this.jdField_g_of_type_Boolean = false;
    }
    switch (2)
    {
    }
    try
    {
      super.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (Exception paramIntent)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d(jdField_g_of_type_JavaLangString, 2, "startActivity failed with: ", paramIntent);
      return;
      paramIntent.putExtra("fling_action_key", 2);
      paramIntent.putExtra("fling_code_key", hashCode());
      super.startActivityForResult(paramIntent, paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
    return;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    paramIntent.putExtra("from_activity", getClass().getName());
    int i;
    if (getActivity().getParent() != null)
    {
      i = 1;
      if (!paramIntent.getExtras().containsKey("is_activity_to_fragment")) {
        if ((!b(paramIntent)) || (i == 0)) {
          break label132;
        }
      }
    }
    for (;;)
    {
      paramIntent.putExtra("is_activity_to_fragment", bool);
      if (!paramIntent.getExtras().containsKey("clear_fragment_stack")) {
        paramIntent.putExtra("clear_fragment_stack", b());
      }
      if (!paramIntent.getExtras().containsKey("fragment_no_anim")) {
        paramIntent.putExtra("fragment_no_anim", c(paramIntent));
      }
      super.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
      i = 0;
      break;
      label132:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2
 * JD-Core Version:    0.7.0.1
 */