package com.tencent.mobileqq.trick;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kbg;
import kbh;

public class TrickHelper
{
  private static TrickHelper jdField_a_of_type_ComTencentMobileqqTrickTrickHelper = null;
  private static final String jdField_a_of_type_JavaLangString = "TrickHelper";
  public static boolean a;
  public static boolean b = true;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = new kbg(this);
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static TrickHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTrickTrickHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTrickTrickHelper == null) {
        jdField_a_of_type_ComTencentMobileqqTrickTrickHelper = new TrickHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqTrickTrickHelper;
    }
    finally {}
  }
  
  private boolean a()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).topActivity.getClassName();
      if (QLog.isColorLevel()) {
        QLog.d("TrickHelper", 2, "top=" + (String)localObject);
      }
      if (ClassNameHelper.a().contains(localObject))
      {
        if (GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager.b())
        {
          c();
          GuardManager.jdField_a_of_type_ComTencentMobileqqAppGuardManager.d();
        }
        return true;
      }
      return false;
    }
    return false;
  }
  
  private void c()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if ((l1 > GuardManager.jdField_a_of_type_Long) && (GuardManager.jdField_a_of_type_Long != 0L))
      {
        long l2 = GuardManager.jdField_a_of_type_Long;
        long l3 = MemoryManager.a(Process.myPid()) / 1024L;
        long l4 = DeviceInfoUtil.e() / 1024L;
        long l5 = DeviceInfoUtil.c() / 1024L;
        StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
        HashMap localHashMap = new HashMap();
        localHashMap.put("osVersion", Build.VERSION.RELEASE);
        localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        localHashMap.put("time", String.valueOf((l1 - l2) / 1000L));
        localHashMap.put("qqUsedMemory", String.valueOf(l3));
        localHashMap.put("sysClassMemory", String.valueOf(l4));
        localHashMap.put("sysTotalMemory", String.valueOf(l5));
        localStatisticCollector.a("", "MemoryTrick", true, 0L, 0L, localHashMap, "");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TrickHelper", 2, "report err", localException);
    }
  }
  
  public void a()
  {
    IntentFilter localIntentFilter;
    if (!jdField_a_of_type_Boolean)
    {
      boolean bool = MemoryConfigs.a().jdField_a_of_type_Boolean;
      if (QLog.isColorLevel()) {
        QLog.d("TrickHelper", 2, "startTrick enable=" + bool);
      }
      if (bool)
      {
        b = true;
        ThreadManager.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = new kbh(this, null);
          localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
          localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        }
      }
    }
    try
    {
      BaseApplicationImpl.a.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      label130:
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label130;
    }
  }
  
  public void b()
  {
    if (jdField_a_of_type_Boolean)
    {
      boolean bool = MemoryConfigs.a().jdField_a_of_type_Boolean;
      if (QLog.isColorLevel()) {
        QLog.d("TrickHelper", 2, "stopTrick enable=" + bool);
      }
      if (bool)
      {
        b = false;
        ThreadManager.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {}
      }
    }
    try
    {
      BaseApplicationImpl.a.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label80:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.trick.TrickHelper
 * JD-Core Version:    0.7.0.1
 */