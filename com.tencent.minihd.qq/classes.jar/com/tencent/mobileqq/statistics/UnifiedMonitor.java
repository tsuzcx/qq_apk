package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import jwt;
import jwu;
import jwv;

public class UnifiedMonitor
{
  public static final int a = 0;
  private static UnifiedMonitor jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor = null;
  private static final String jdField_a_of_type_JavaLangString = "unifiedMonitor";
  public static final int b = 1;
  private static final String b = "UnifiedMonitor";
  public static final boolean b = true;
  public static final int c = 2;
  private static final String jdField_c_of_type_JavaLangString = "com.tencent.rdm.uuid";
  private static final String d = "unified_monitor";
  public static final int e = 0;
  private static final String e = "last_collected_";
  public static final int f = 1;
  private static String f = null;
  public static final int g = 2;
  private static final String i = "user_ratio_";
  private static final String j = "max_report_";
  private static final String k = "num_thresh_";
  private static final String l = "event_ratio_";
  private static final String m = "report_stack";
  private static final String n = "max_stackdep";
  private volatile long jdField_a_of_type_Long = 0L;
  private jwu jdField_a_of_type_Jwu = null;
  private jwv jdField_a_of_type_Jwv = null;
  public boolean a;
  private jwt[] jdField_a_of_type_ArrayOfJwt = { new jwt(), new jwt() };
  boolean jdField_c_of_type_Boolean;
  public int d;
  public boolean d;
  private String g = null;
  private String h = null;
  
  public UnifiedMonitor()
  {
    this.jdField_a_of_type_Boolean = false;
    this.c = true;
    this.jdField_d_of_type_Int = 5;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static UnifiedMonitor a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor != null) {
      return jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor = new UnifiedMonitor();
      }
      UnifiedMonitor localUnifiedMonitor = jdField_a_of_type_ComTencentMobileqqStatisticsUnifiedMonitor;
      return localUnifiedMonitor;
    }
    finally {}
  }
  
  private static String a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext.metaData != null)
      {
        if (paramBoolean) {
          return Long.toString(paramContext.metaData.getLong(paramString));
        }
        paramContext = paramContext.metaData.getString(paramString);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  private void d()
  {
    int i1;
    String[] arrayOfString2;
    int i3;
    label152:
    String str2;
    try
    {
      String str1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.unified_monitor_params.name());
      if (QLog.isDevelopLevel()) {
        QLog.d("UnifiedMonitor", 4, "dpc string " + str1);
      }
      if (str1 == null) {
        break label489;
      }
      String[] arrayOfString1 = str1.split("\\|");
      if (arrayOfString1 == null) {
        return;
      }
      int i2 = arrayOfString1.length;
      i1 = 0;
      if (i1 >= i2) {
        break label489;
      }
      str1 = arrayOfString1[i1];
      try
      {
        arrayOfString2 = str1.split("=");
        if ((arrayOfString2 == null) || (arrayOfString2.length != 2) || (TextUtils.isEmpty(arrayOfString2[0])) || (TextUtils.isEmpty(arrayOfString2[1]))) {
          break label585;
        }
        i3 = arrayOfString2[0].lastIndexOf('_');
        if (i3 == -1) {
          break label592;
        }
        str1 = arrayOfString2[0].substring(0, i3 + 1);
        if ((i3 == -1) || (i3 >= arrayOfString2[0].length() - 1)) {
          break label598;
        }
        str2 = arrayOfString2[0].substring(i3 + 1);
        label182:
        if ((str1 == null) || (i3 == -1) || (str2 == null)) {
          break label423;
        }
        i3 = Integer.valueOf(str2).intValue();
        if (QLog.isDevelopLevel()) {
          QLog.d("UnifiedMonitor", 4, "reading config item from dpc string, family_no=" + i3 + ", config-prefix=" + str1 + ", value=" + arrayOfString2[1]);
        }
        if (i3 >= 2) {
          break label585;
        }
        if ("user_ratio_".equals(str1)) {
          this.jdField_a_of_type_ArrayOfJwt[i3].jdField_a_of_type_Float = Float.valueOf(arrayOfString2[1]).floatValue();
        } else if ("max_report_".equals(str1)) {
          this.jdField_a_of_type_ArrayOfJwt[i3].jdField_b_of_type_Int = Integer.valueOf(arrayOfString2[1]).intValue();
        }
      }
      catch (Throwable localThrowable1)
      {
        if (!QLog.isDevelopLevel()) {
          break label585;
        }
      }
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable2)
    {
      if (!QLog.isDevelopLevel()) {
        break label584;
      }
    }
    localThrowable2.printStackTrace();
    return;
    label423:
    label451:
    label489:
    jwt localjwt;
    if ("num_thresh_".equals(localThrowable2))
    {
      this.jdField_a_of_type_ArrayOfJwt[i3].jdField_a_of_type_Int = Integer.valueOf(arrayOfString2[1]).intValue();
    }
    else if ("event_ratio_".equals(localThrowable2))
    {
      this.jdField_a_of_type_ArrayOfJwt[i3].jdField_b_of_type_Float = Integer.valueOf(arrayOfString2[1]).intValue();
      break label585;
      if ("report_stack".equals(arrayOfString2[0]))
      {
        if (Integer.valueOf(arrayOfString2[1]).intValue() != 0) {
          break label604;
        }
        bool = false;
        this.c = bool;
      }
      else if ("max_stackdep".equals(arrayOfString2[0]))
      {
        this.jdField_d_of_type_Int = Integer.valueOf(arrayOfString2[1]).intValue();
        break label585;
        i1 = 0;
        while (i1 < this.jdField_a_of_type_ArrayOfJwt.length)
        {
          localjwt = this.jdField_a_of_type_ArrayOfJwt[i1];
          if (Math.random() > this.jdField_a_of_type_ArrayOfJwt[i1].jdField_a_of_type_Float) {
            break label610;
          }
          bool = true;
          label528:
          localjwt.jdField_a_of_type_Boolean = bool;
          i1 += 1;
        }
        if (Build.VERSION.SDK_INT != 17) {
          if ((!this.c) || (!this.jdField_a_of_type_ArrayOfJwt[0].jdField_a_of_type_Boolean)) {
            break label616;
          }
        }
      }
    }
    label584:
    label585:
    label592:
    label598:
    label604:
    label610:
    label616:
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      return;
      this.c = false;
      return;
      i1 += 1;
      break;
      localjwt = null;
      break label152;
      str2 = null;
      break label182;
      bool = true;
      break label451;
      bool = false;
      break label528;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 >= 2) {}
    do
    {
      return paramInt3;
      switch (paramInt1)
      {
      default: 
        return paramInt3;
      }
      try
      {
        return this.jdField_a_of_type_ArrayOfJwt[paramInt2].jdField_b_of_type_Int;
      }
      catch (Throwable localThrowable) {}
      paramInt1 = this.jdField_a_of_type_ArrayOfJwt[paramInt2].jdField_a_of_type_Int;
      return paramInt1;
    } while (!QLog.isColorLevel());
    localThrowable.printStackTrace();
    return paramInt3;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (f == null) {
        f = a(BaseApplicationImpl.getContext(), "com.tencent.rdm.uuid", false);
      }
      d();
      Object localObject = new HandlerThread("unified-monitor");
      ((HandlerThread)localObject).start();
      localObject = ((HandlerThread)localObject).getLooper();
      if (localObject != null)
      {
        this.jdField_a_of_type_Jwu = new jwu(this, (Looper)localObject);
        this.jdField_a_of_type_Boolean = true;
      }
      if (this.c)
      {
        this.jdField_a_of_type_Jwv = new jwv(this, null);
        this.jdField_a_of_type_Jwv.start();
        this.jdField_d_of_type_Boolean = true;
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!b(paramInt1))) {
      return;
    }
    HashMap localHashMap = new HashMap(6);
    localHashMap.put("family", String.valueOf(paramInt1));
    localHashMap.put("event", paramString);
    localHashMap.put("revision", "2cb8ec");
    localHashMap.put("uuid", f);
    if (this.h == null)
    {
      this.h = "dbg";
      this.h = "pub";
    }
    localHashMap.put("build_type", this.h);
    localHashMap.put("not_reported", String.valueOf(paramInt3));
    paramString = this.g;
    if (paramString != null) {
      localHashMap.put("stack", paramString);
    }
    this.jdField_a_of_type_Jwu.sendMessage(Message.obtain(this.jdField_a_of_type_Jwu, 0, paramInt2, 0, localHashMap));
    paramString = this.jdField_a_of_type_ArrayOfJwt[paramInt1];
    paramString.c += 1;
  }
  
  public boolean a(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ArrayOfJwt[paramInt].jdField_a_of_type_Boolean)) {}
    float f1;
    do
    {
      return false;
      f1 = this.jdField_a_of_type_ArrayOfJwt[paramInt].jdField_b_of_type_Float;
    } while ((this.jdField_a_of_type_ArrayOfJwt[paramInt].c >= this.jdField_a_of_type_ArrayOfJwt[paramInt].jdField_b_of_type_Int) || (Math.random() > f1));
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.g = null;
  }
  
  public boolean b(int paramInt)
  {
    if (paramInt >= 2) {
      return false;
    }
    return this.jdField_a_of_type_ArrayOfJwt[paramInt].jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = 0L;
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UnifiedMonitor
 * JD-Core Version:    0.7.0.1
 */