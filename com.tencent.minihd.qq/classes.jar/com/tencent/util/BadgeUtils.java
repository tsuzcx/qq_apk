package com.tencent.util;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;
import lqd;
import lqe;

public class BadgeUtils
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static BadgeUtils jdField_a_of_type_ComTencentUtilBadgeUtils = null;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new lqe();
  
  public static BadgeUtils a()
  {
    if (jdField_a_of_type_ComTencentUtilBadgeUtils == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentUtilBadgeUtils == null) {
        jdField_a_of_type_ComTencentUtilBadgeUtils = new BadgeUtils();
      }
      return jdField_a_of_type_ComTencentUtilBadgeUtils;
    }
    finally {}
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtilImpl", 2, "enableBadge mobileqq");
    }
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    BadgeUtilImpl.enableBadge(BaseApplicationImpl.a);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (!a()) {
      return;
    }
    ThreadManager.b(new lqd(paramContext, paramInt));
  }
  
  public static void a(Context paramContext, int paramInt, Notification paramNotification)
  {
    if (!BadgeUtilImpl.isMIUI6()) {
      return;
    }
    BadgeUtilImpl.setMIUI6Badge(paramContext, paramInt, paramNotification);
  }
  
  public static boolean a()
  {
    return BadgeUtilImpl.isSupportBadge();
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtilImpl", 2, "disableBadge mobileqq");
    }
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    BadgeUtilImpl.disableBadge(BaseApplicationImpl.a);
    jdField_a_of_type_AndroidOsHandler.postDelayed(jdField_a_of_type_JavaLangRunnable, 2000L);
  }
  
  public static void c()
  {
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.util.BadgeUtils
 * JD-Core Version:    0.7.0.1
 */