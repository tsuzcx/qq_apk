package com.tencent.common.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.format.Time;
import android.util.DisplayMetrics;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.dalvik.DalvikReplacer;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QzonePerformanceTracer;
import cooperation.qzone.util.TimeCostTrace;
import crt;
import cru;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class BaseApplicationImpl
  extends MobileQQ
{
  public static int a = 0;
  public static long a = 0L;
  public static Handler a;
  public static MQLruCache a;
  public static BaseApplicationImpl a;
  public static StartupDirector a;
  public static Object a;
  public static String a;
  public static boolean a = false;
  public static final int b = -1;
  public static long b = 0L;
  public static String b;
  public static boolean b = false;
  public static final int c = 1;
  public static long c = 0L;
  public static final String c = "com.tencent.mobileqq.broadcast.qq";
  public static boolean c = false;
  public static final int d = 2;
  public static final String d = "com.tencent.process.exit";
  private static boolean d = false;
  public static final int e = 3;
  public static final String e = "com.tencent.minihd.qq";
  private static final boolean e = true;
  public static final int f = 4;
  public static int g = 0;
  private static final int jdField_h_of_type_Int = 8388608;
  private Intent a;
  private Handler b;
  private String f = null;
  private String g;
  private String jdField_h_of_type_JavaLangString;
  private String i = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    d = false;
    if ((Build.MODEL.contains("Mate7")) || (Build.MODEL.contains("MT7"))) {
      d = true;
    }
    jdField_g_of_type_Int = -1;
  }
  
  public BaseApplicationImpl()
  {
    this.jdField_g_of_type_JavaLangString = null;
    this.h = null;
    this.jdField_a_of_type_AndroidContentIntent = null;
    this.jdField_b_of_type_AndroidOsHandler = new cru(this);
  }
  
  public static BaseApplicationImpl a()
  {
    return jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public static String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    int j;
    if (paramBoolean)
    {
      j = localTime.minute - 1;
      localStringBuilder.append(j);
      if (paramArrayList != null) {
        break label140;
      }
    }
    label140:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      j = localTime.minute;
      break;
    }
  }
  
  public static void b()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        localObject1 = Class.forName("android.app.ActivityThread");
        localObject3 = ((Class)localObject1).getDeclaredMethod("currentActivityThread", null);
        ((Method)localObject3).setAccessible(true);
        jdField_a_of_type_JavaLangObject = ((Method)localObject3).invoke(null, null);
        if (jdField_a_of_type_JavaLangObject == null)
        {
          if (Build.VERSION.SDK_INT > 17) {
            continue;
          }
          localObject1 = ((Class)localObject1).getDeclaredField("sThreadLocal");
          ((Field)localObject1).setAccessible(true);
          localObject1 = (ThreadLocal)((Field)localObject1).get(null);
          if (localObject1 != null) {
            jdField_a_of_type_JavaLangObject = ((ThreadLocal)localObject1).get();
          }
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = new StringBuilder().append("currentActivityThread succeed=");
        if (jdField_a_of_type_JavaLangObject == null) {
          continue;
        }
        bool1 = true;
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("LeakInspector", 2, "currentActivityThread", localThrowable);
        localThrowable.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("currentActivityThread succeed=");
        if (jdField_a_of_type_JavaLangObject == null) {
          continue;
        }
        QLog.d("LeakInspector", 2, bool1);
        return;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label255;
        }
      }
      QLog.d("LeakInspector", 2, bool1);
      return;
      localObject1 = ((Class)localObject1).getDeclaredField("sCurrentActivityThread");
      ((Field)localObject1).setAccessible(true);
      jdField_a_of_type_JavaLangObject = ((Field)localObject1).get(null);
    }
    Object localObject3 = new StringBuilder().append("currentActivityThread succeed=");
    if (jdField_a_of_type_JavaLangObject != null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      QLog.d("LeakInspector", 2, bool1);
      label255:
      throw localObject2;
    }
  }
  
  private void c()
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if ((localDisplayMetrics.widthPixels != 1080) || ((localDisplayMetrics.heightPixels != 1920) && (localDisplayMetrics.heightPixels != 1812))) {
      if (QLog.isColorLevel()) {
        QLog.d("density_test", 2, "widthPixels = " + localDisplayMetrics.widthPixels + "| heightPixels" + localDisplayMetrics.heightPixels);
      }
    }
    do
    {
      return;
      localDisplayMetrics.density = 2.6F;
      localDisplayMetrics.scaledDensity = 2.6F;
      localDisplayMetrics.densityDpi = 416;
    } while (Build.VERSION.SDK_INT < 21);
    getResources().getConfiguration().fontScale = 0.87F;
  }
  
  public Intent a()
  {
    if ((this.f != null) && (this.jdField_g_of_type_JavaLangString != null) && (this.h != null) && (this.i != null))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent("mqq.intent.action.PCACTIVE_TIPS");
      this.jdField_a_of_type_AndroidContentIntent.putExtra("Message", this.jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.f);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("lButton", this.h);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("rButton", this.i);
      this.jdField_a_of_type_AndroidContentIntent.addFlags(268435456);
      return this.jdField_a_of_type_AndroidContentIntent;
    }
    return null;
  }
  
  public String a()
  {
    return this.f;
  }
  
  public AppRuntime a()
  {
    return waitAppRuntime(null);
  }
  
  public void a()
  {
    super.onCreate();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.f = paramString1;
    this.jdField_g_of_type_JavaLangString = paramString2;
    this.h = paramString3;
    this.i = paramString4;
  }
  
  public boolean a()
  {
    if (DalvikReplacer.a(8388608)) {
      try
      {
        DalvikReplacer.a(this, 8388608);
        return false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("replaceDalvikMem", 2, "exception:", localThrowable);
          }
        }
      }
    }
    return true;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    if (d) {
      c();
    }
  }
  
  public AppRuntime createRuntime(String paramString)
  {
    return AppInterfaceFactory.a(this, paramString);
  }
  
  public int getAppId(String paramString)
  {
    return AppSetting.a;
  }
  
  public String getBootBroadcastName(String paramString)
  {
    if (paramString.equals("com.tencent.minihd.qq")) {
      return "com.tencent.mobileqq.broadcast.qq";
    }
    if (paramString.equals("com.tencent.minihd.qq:video")) {
      return "com.tencent.av.ui.VChatActivity";
    }
    return "";
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public SharedPreferences getSystemSharedPreferences(String paramString, int paramInt)
  {
    return super.getSharedPreferences(paramString, paramInt);
  }
  
  public boolean isNeedMSF(String paramString)
  {
    return !paramString.equals(getPackageName() + ":picture");
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    if (jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null) {
      return jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(paramObject, paramIntent);
    }
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null) {
      jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(paramAppActivity, paramBoolean);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (d) {
      c();
    }
  }
  
  public void onCreate()
  {
    if (jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {
      return;
    }
    jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = this;
    SharedPreferencesProxyManager.getInstance().init(this);
    Step.AmStepFactory.b(2, null, null).c();
    boolean bool;
    StringBuilder localStringBuilder;
    if (jdField_g_of_type_Int == 2)
    {
      StartupDirector.f = true;
      PerfTracer.a(null, "APP_readTraceConfig");
      bool = QzonePerformanceTracer.a().b();
      PerfTracer.a("APP_readTraceConfig", null);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("BaseApplicationImpl isTrace:");
        if (!bool) {
          break label166;
        }
      }
    }
    label166:
    for (String str = "true";; str = "false")
    {
      QLog.d("QzonePerformanceTracer", 2, str);
      if (bool)
      {
        QzonePerformanceTracer.a().a();
        QzonePerformanceTracer.a().b();
      }
      TimeCostTrace.a("qzone_launch").a();
      PerfTracer.a(null, "App_onCreate");
      SizeMeasure.a(getBaseContext());
      jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector = StartupDirector.a(jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      if (!StartupDirector.f) {
        break;
      }
      PerfTracer.a("App_onCreate", null);
      return;
    }
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    try
    {
      paramBroadcastReceiver = super.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
      return paramBroadcastReceiver;
    }
    catch (Exception paramBroadcastReceiver)
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "", paramBroadcastReceiver);
      }
    }
    return null;
  }
  
  public void reportPCActive(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_retryIndex", Integer.toString(paramInt));
    localHashMap.put("param_uin", paramString);
    StatisticCollector.a(a()).a(paramString, "PcActiveSucc", true, 0L, 0L, localHashMap, "", true);
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new crt(this, paramInt, paramString), 10000L);
    ReportController.b(null, "CliOper", "", "", "0X8004974", "0X8004974", 0, 0, "", "", "", "");
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      super.startActivity(paramIntent);
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    try
    {
      super.startActivity(paramIntent, paramBundle);
      return;
    }
    catch (Exception paramIntent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl
 * JD-Core Version:    0.7.0.1
 */