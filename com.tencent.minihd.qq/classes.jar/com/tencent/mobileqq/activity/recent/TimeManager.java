package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photopreview.CountDownTimer;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;

public class TimeManager
{
  private static TimeManager jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private long jdField_a_of_type_Long;
  public CountDownTimer a;
  private final String jdField_a_of_type_JavaLangString = TimeManager.class.getName();
  private StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer(25);
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private String jdField_b_of_type_JavaLangString = "yyyy-MM-dd";
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  private TimeManager()
  {
    b(BaseApplicationImpl.a);
  }
  
  public static TimeManager a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager = new TimeManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRecentTimeManager;
    }
  }
  
  private boolean a()
  {
    if (System.currentTimeMillis() >= this.jdField_a_of_type_Long)
    {
      f();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return false;
    }
    return true;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    f();
    a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer = new CountDownTimer(paramContext.getMainLooper());
  }
  
  private void f()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(10, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    this.jdField_a_of_type_Long = localCalendar.getTimeInMillis();
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(String arg1, long paramLong)
  {
    HashMap localHashMap = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(???);
    if ((localHashMap == null) || (!a()))
    {
      localHashMap = new HashMap();
      this.jdField_a_of_type_JavaUtilHashMap.put(???, localHashMap);
      ??? = null;
    }
    for (;;)
    {
      String str = ???;
      if (??? == null) {}
      synchronized (this.jdField_a_of_type_JavaLangStringBuffer)
      {
        str = TimeFormatterUtils.a(this.jdField_a_of_type_JavaLangStringBuffer, 1000L * paramLong, true, this.jdField_b_of_type_JavaLangString);
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "getMsgDisplayTime, " + this.jdField_a_of_type_JavaLangStringBuffer.toString() + "," + str);
        }
        localHashMap.put(String.valueOf(paramLong), str);
        return str;
        ??? = (String)localHashMap.get(String.valueOf(paramLong));
        if (??? == null) {
          localHashMap.clear();
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramContext != null) {
      paramContext = paramContext.getContentResolver();
    }
    try
    {
      localObject1 = Settings.System.getString(paramContext, "date_format");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_b_of_type_JavaLangString = ((String)localObject1);
        return;
      }
      this.jdField_b_of_type_JavaLangString = "yyyy-MM-dd";
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.g();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.f();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotopreviewCountDownTimer.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TimeManager
 * JD-Core Version:    0.7.0.1
 */