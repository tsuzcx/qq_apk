package com.tencent.util.notification;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class QQNotificationManager
{
  private static QQNotificationManager jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager;
  private static final CharSequence jdField_a_of_type_JavaLangCharSequence = "消息通知";
  public static final String a = "QQNotification";
  private static final CharSequence b = "通知栏显示QQ图标";
  public static final String b = "CHANNEL_ID_HIDE_BADGE";
  private static final CharSequence c = "扩列消息";
  public static final String c = "CHANNEL_ID_LIMIT_CHAT";
  private static final CharSequence d = "普通消息";
  public static final String d = "CHANNEL_ID_SHOW_BADGE";
  private static final String e = "checkOpNoThrow";
  private static final String f = "OP_POST_NOTIFICATION";
  private static final String g = "GROUP_ID_TOP";
  private NotificationManager jdField_a_of_type_AndroidAppNotificationManager = null;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private QQNotificationManager()
  {
    a();
  }
  
  public static QQNotificationManager a()
  {
    if (jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager == null) {
      jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager = new QQNotificationManager();
    }
    return jdField_a_of_type_ComTencentUtilNotificationQQNotificationManager;
  }
  
  public static void a(Notification paramNotification, String paramString)
  {
    if ((a()) && (b()) && (paramNotification.getChannelId() == null)) {}
    try
    {
      a(paramNotification, Notification.class, "mChannelId", paramString);
      return;
    }
    catch (Exception paramNotification)
    {
      paramNotification.printStackTrace();
    }
  }
  
  public static void a(Object paramObject1, Class paramClass, String paramString, Object paramObject2)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  @Deprecated
  private void a(String paramString, CharSequence paramCharSequence)
  {
    if (a())
    {
      paramString = new NotificationChannelGroup(paramString, paramCharSequence);
      this.jdField_a_of_type_JavaUtilHashMap.put("GROUP_ID_TOP", paramString);
      this.jdField_a_of_type_AndroidAppNotificationManager.createNotificationChannelGroup(paramString);
    }
  }
  
  @Deprecated
  private void a(String paramString1, CharSequence paramCharSequence, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (!a()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidAppNotificationManager.getNotificationChannelGroups();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        ((NotificationChannelGroup)((Iterator)localObject).next()).getId().equals(paramString2);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (QLog.isColorLevel())) {
        QLog.i("QQNotification", 2, "please create NotificationChannelGroup First, create NotificationChannelGroup with id " + paramString2);
      }
      if (this.jdField_a_of_type_AndroidAppNotificationManager.getNotificationChannel(paramString1) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQNotification", 2, "NotificationChannel " + paramString1 + " has been create");
        }
        this.jdField_a_of_type_AndroidAppNotificationManager.deleteNotificationChannel(paramString1);
      }
      paramCharSequence = new NotificationChannel(paramString1, paramCharSequence, paramInt);
      paramCharSequence.setShowBadge(paramBoolean);
      paramCharSequence.setGroup(paramString2);
      if (paramInt > 3)
      {
        paramCharSequence.enableLights(true);
        paramCharSequence.enableVibration(true);
        paramCharSequence.setLightColor(-16711936);
        paramCharSequence.setLockscreenVisibility(0);
        paramCharSequence.setBypassDnd(true);
        paramCharSequence.setVibrationPattern(new long[] { 100L });
      }
      paramCharSequence.setSound(null, null);
      if (QLog.isColorLevel()) {
        QLog.i("QQNotification", 2, "NotificationChannel " + paramString1 + "canShowBadge " + paramCharSequence.canShowBadge());
      }
      this.jdField_a_of_type_AndroidAppNotificationManager.createNotificationChannel(paramCharSequence);
      return;
    }
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static boolean b()
  {
    return BaseApplicationImpl.a().getApplicationInfo().targetSdkVersion >= 26;
  }
  
  private void d()
  {
    a("CHANNEL_ID_HIDE_BADGE", b, 2, "GROUP_ID_TOP", false);
    if (b()) {
      a("CHANNEL_ID_SHOW_BADGE", d, 4, "GROUP_ID_TOP", true);
    }
  }
  
  private void e()
  {
    a("GROUP_ID_TOP", jdField_a_of_type_JavaLangCharSequence);
  }
  
  public NotificationManager a()
  {
    return this.jdField_a_of_type_AndroidAppNotificationManager;
  }
  
  public void a()
  {
    try
    {
      e();
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QNotification", 2, paramString + " cancel id:" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.cancel(paramInt);
    }
  }
  
  public void a(String paramString, int paramInt, Notification paramNotification)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QNotification", 2, paramString + " notify DontUseTag id:" + paramInt + " " + paramNotification);
    }
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.notify(paramInt, paramNotification);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QNotification", 2, paramString1 + " cancel UseTag:" + paramString2 + " id:" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.cancel(paramString2, paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, Notification paramNotification)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QNotification", 2, paramString1 + " notify UseTag:" + paramString2 + " id:" + paramInt + " " + paramNotification);
    }
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.notify(paramString2, paramInt, paramNotification);
    }
  }
  
  public boolean a(Context paramContext)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.jdField_a_of_type_AndroidAppNotificationManager.areNotificationsEnabled();
    }
    while (Build.VERSION.SDK_INT < 19) {
      return bool;
    }
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    Object localObject = paramContext.getApplicationInfo();
    paramContext = paramContext.getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject).uid;
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { (Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class), Integer.valueOf(i), paramContext })).intValue();
      if (i == 0) {}
      for (bool = true;; bool = false) {
        return bool;
      }
      return true;
    }
    catch (RuntimeException paramContext)
    {
      return true;
    }
    catch (IllegalAccessException paramContext)
    {
      return true;
    }
    catch (InvocationTargetException paramContext)
    {
      return true;
    }
    catch (NoSuchFieldException paramContext)
    {
      return true;
    }
    catch (NoSuchMethodException paramContext)
    {
      return true;
    }
    catch (ClassNotFoundException paramContext) {}
  }
  
  @Deprecated
  public void b()
  {
    if (!a()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidAppNotificationManager.getNotificationChannelGroups();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((NotificationChannelGroup)((Iterator)localObject).next()).getId().equals("GROUP_ID_TOP"));
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (QLog.isColorLevel())) {
        QLog.i("QQNotification", 2, "please create NotificationChannelGroup First, create NotificationChannelGroup with id GROUP_ID_TOP");
      }
      if (this.jdField_a_of_type_AndroidAppNotificationManager.getNotificationChannel("CHANNEL_ID_LIMIT_CHAT") != null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QQNotification", 2, "NotificationChannel CHANNEL_ID_LIMIT_CHAT has been create");
        return;
      }
      localObject = new NotificationChannel("CHANNEL_ID_LIMIT_CHAT", c, 4);
      ((NotificationChannel)localObject).setShowBadge(false);
      ((NotificationChannel)localObject).setGroup("GROUP_ID_TOP");
      ((NotificationChannel)localObject).enableLights(true);
      ((NotificationChannel)localObject).enableVibration(true);
      ((NotificationChannel)localObject).setLightColor(-16711936);
      ((NotificationChannel)localObject).setLockscreenVisibility(0);
      ((NotificationChannel)localObject).setBypassDnd(true);
      if (QLog.isColorLevel()) {
        QLog.i("QQNotification", 2, "NotificationChannel CHANNEL_ID_LIMIT_CHATcanShowBadge " + ((NotificationChannel)localObject).canShowBadge());
      }
      this.jdField_a_of_type_AndroidAppNotificationManager.createNotificationChannel((NotificationChannel)localObject);
      return;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QNotification", 2, "clearAll");
    }
    if (this.jdField_a_of_type_AndroidAppNotificationManager != null) {
      this.jdField_a_of_type_AndroidAppNotificationManager.cancelAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.notification.QQNotificationManager
 * JD-Core Version:    0.7.0.1
 */