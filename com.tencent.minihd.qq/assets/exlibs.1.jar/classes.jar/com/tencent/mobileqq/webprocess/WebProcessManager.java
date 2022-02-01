package com.tencent.mobileqq.webprocess;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kwo;
import kwp;
import kwq;
import mqq.manager.Manager;

public class WebProcessManager
  implements Manager
{
  protected static final int a = 512;
  protected static final String a = "WebProcessManager";
  public static HashMap a;
  protected static final int b = 1024;
  public static final String b = "com.tencent.minihd.qq:web";
  public static HashMap b;
  protected static boolean b = false;
  public static final String c = "com.tencent.mobileqq.webprocess.restart_web_process";
  public static final String d = "com.tencent.mobileqq.webprocess.report";
  public static final String e = "web_process_preload_file";
  public static final String f = "key_come_webview_time";
  public static final String g = "key_web_plugin_list";
  public static final String h = "key_web_plugin_click_num";
  public static final String i = "key_web_plugin_click_red_num";
  public static final String j = "key_preload_strategy";
  public static final String k = "key_preload_flag";
  public static final String l = "key_check_update_interval";
  public static final String m = "key_last_check_update_timestamp";
  public static final String n = "key_red_ram";
  public static final String o = "key_click_ram";
  public static final String p = "key_preload";
  public static final String q = "key_preload_web_process";
  protected long a;
  protected BroadcastReceiver a;
  protected QQAppInterface a;
  protected boolean a;
  
  static
  {
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public WebProcessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new kwq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    c();
    this.jdField_a_of_type_Long = (DeviceInfoUtil.c() / 1048576L);
  }
  
  public static void a(boolean paramBoolean)
  {
    BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload", paramBoolean).commit();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload", false);
  }
  
  public static void b(boolean paramBoolean)
  {
    BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload_web_process", paramBoolean).commit();
  }
  
  public static boolean b()
  {
    return BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4).getBoolean("key_preload_web_process", false);
  }
  
  public static void c(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean c()
  {
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
    if ((localObject == null) || (((List)localObject).size() <= 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ("com.tencent.minihd.qq:web".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessManager", 2, "QQBrowserProcess is exist");
        }
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4);
    Object localObject = SharedPreferencesHandler.a(localSharedPreferences, "key_web_plugin_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
    if ((localObject != null) && (!((Set)localObject).isEmpty()))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        jdField_b_of_type_JavaUtilHashMap.put(str, str);
      }
    }
    jdField_a_of_type_JavaUtilHashMap.put("key_preload_strategy", Integer.valueOf(localSharedPreferences.getInt("key_preload_strategy" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1)));
    localObject = jdField_a_of_type_JavaUtilHashMap;
    if (localSharedPreferences.getBoolean("key_preload_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false)) {}
    for (int i1 = 1;; i1 = 0)
    {
      ((HashMap)localObject).put("key_preload_flag", Integer.valueOf(i1));
      jdField_a_of_type_JavaUtilHashMap.put("key_red_ram", Integer.valueOf(localSharedPreferences.getInt("key_red_ram" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 512)));
      jdField_a_of_type_JavaUtilHashMap.put("key_click_ram", Integer.valueOf(localSharedPreferences.getInt("key_click_ram" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1024)));
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool1;
    if (jdField_b_of_type_JavaUtilHashMap.isEmpty())
    {
      Object localObject = SharedPreferencesHandler.a(BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4), "key_web_plugin_list" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null);
      boolean bool2 = false;
      bool1 = bool2;
      if (localObject == null) {
        break label136;
      }
      bool1 = bool2;
      if (((Set)localObject).isEmpty()) {
        break label136;
      }
      localObject = ((Set)localObject).iterator();
      bool1 = false;
      if (!((Iterator)localObject).hasNext()) {
        return bool1;
      }
      String str = (String)((Iterator)localObject).next();
      jdField_b_of_type_JavaUtilHashMap.put(str, str);
      if (!str.equals(paramString)) {
        break label138;
      }
      bool1 = true;
    }
    label136:
    label138:
    for (;;)
    {
      break;
      bool1 = jdField_b_of_type_JavaUtilHashMap.containsKey(paramString);
      return bool1;
    }
    return bool1;
  }
  
  public void b()
  {
    if ((jdField_b_of_type_Boolean) && (d())) {
      e();
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Boolean = true;
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.restart_web_process");
      localIntentFilter.addAction("com.tencent.mobileqq.webprocess.report");
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.jdField_a_of_type_Boolean)) {}
    try
    {
      this.jdField_a_of_type_Boolean = false;
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean d()
  {
    if ((f()) || (c())) {
      return false;
    }
    if ((jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_JavaUtilHashMap.get("key_preload_strategy") != null) && (((Integer)jdField_a_of_type_JavaUtilHashMap.get("key_preload_strategy")).intValue() == 2))
    {
      if ((jdField_a_of_type_JavaUtilHashMap.get("key_preload_flag") != null) && (((Integer)jdField_a_of_type_JavaUtilHashMap.get("key_preload_flag")).intValue() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessManager", 2, "is need prload, totalMemSize = " + this.jdField_a_of_type_Long + "M");
        }
        if ((jdField_a_of_type_JavaUtilHashMap.get("key_red_ram") != null) && (this.jdField_a_of_type_Long > ((Integer)jdField_a_of_type_JavaUtilHashMap.get("key_red_ram")).intValue())) {
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    else {
      return e();
    }
    return false;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "startWebProcess");
    }
    ThreadManager.b(new kwo(this));
  }
  
  protected boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "startLocalStrategy, totalMemSize = " + this.jdField_a_of_type_Long + "M");
    }
    if ((g()) && (jdField_a_of_type_JavaUtilHashMap.get("key_red_ram") != null) && (this.jdField_a_of_type_Long >= ((Integer)jdField_a_of_type_JavaUtilHashMap.get("key_red_ram")).intValue()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "isPluginHasRedPoint");
      }
      return true;
    }
    if ((jdField_a_of_type_JavaUtilHashMap.get("key_click_ram") != null) && (this.jdField_a_of_type_Long >= ((Integer)jdField_a_of_type_JavaUtilHashMap.get("key_click_ram")).intValue()))
    {
      long l1 = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4).getLong("key_come_webview_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0L);
      if (l1 == 0L) {
        return false;
      }
      if (System.currentTimeMillis() - l1 <= 86400000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessManager", 2, "time is in 24 hour");
        }
        return true;
      }
    }
    return false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "preloadWebProcess");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify2");
  }
  
  protected boolean f()
  {
    if (jdField_b_of_type_JavaUtilHashMap.isEmpty()) {
      return false;
    }
    try
    {
      List localList = LebaShowListManager.a().b();
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator1 = jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
        long l1;
        long l2;
        do
        {
          Iterator localIterator2;
          while (!localIterator2.hasNext())
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            l1 = Long.parseLong((String)localIterator1.next());
            localIterator2 = localList.iterator();
          }
          l2 = ((LebaViewItem)localIterator2.next()).a.uiResId;
        } while (l1 != l2);
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessManager", 2, "restartWebProcess");
    }
    new Handler().postDelayed(new kwp(this), 800L);
  }
  
  protected boolean g()
  {
    if (jdField_b_of_type_JavaUtilHashMap.isEmpty()) {
      return false;
    }
    try
    {
      GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
      if (localGameCenterManagerImp != null)
      {
        Iterator localIterator = jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          int i1 = localGameCenterManagerImp.a((String)localIterator.next());
          if (i1 != -1) {
            return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void h()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "isPreloadSucess");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip", "", "0X8004874", "0X8004874", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      a(false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessManager", 2, "isPreloadFail");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip", "", "0X8004875", "0X8004875", 0, 1, 0, "", "", "", "");
    }
  }
  
  public void onDestroy()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager
 * JD-Core Version:    0.7.0.1
 */