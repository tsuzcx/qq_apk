package com.tencent.mobileqq.equipmentlock;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import ihn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;

public class EquipmentLockImpl
  implements EquipmentLockInterface
{
  static final int jdField_a_of_type_Int = 10103;
  private static EquipmentLockImpl jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl = null;
  public static final String a = "com.tencent.mobileqq.EQLOCK_QUICKLOGIN";
  static final int jdField_b_of_type_Int = 20140414;
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private static final String e = "EquipmentLockImpl";
  private static final String f = "devlock_sharedpref";
  private static final String g = "devlock_status";
  Handler jdField_a_of_type_AndroidOsHandler = new ihn(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = true;
  String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  String d = null;
  private String h = null;
  private String i = null;
  private int m = -1;
  
  public static EquipmentLockImpl a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl == null) {}
    synchronized (jdField_b_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl == null) {
        jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl = new EquipmentLockImpl();
      }
      return jdField_a_of_type_ComTencentMobileqqEquipmentlockEquipmentLockImpl;
    }
  }
  
  public int a(AppInterface paramAppInterface, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    int j = AppSetting.a;
    paramAppInterface = (WtloginManager)paramAppInterface.getManager(1);
    if (paramAppInterface == null) {
      return -1;
    }
    return paramAppInterface.CheckDevLockStatus(paramString, j, paramWtloginObserver);
  }
  
  public int a(AppInterface paramAppInterface, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramAppInterface == null) {
      return -1;
    }
    paramAppInterface = (VerifyDevLockManager)paramAppInterface.getManager(7);
    if (paramAppInterface == null) {
      return -1;
    }
    paramAppInterface.cancelVerify(paramVerifyDevLockObserver);
    return 0;
  }
  
  public int a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramContext == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        return -1;
        paramQQAppInterface = paramQQAppInterface.a();
      } while (TextUtils.isEmpty(paramQQAppInterface));
      if ((!TextUtils.isEmpty(this.h)) && (!this.h.equalsIgnoreCase(paramQQAppInterface)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.m = -1;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
      paramContext = paramContext.getSharedPreferences("devlock_sharedpref", 0);
    } while (paramContext == null);
    this.m = paramContext.getInt("devlock_status" + paramQQAppInterface, -1);
    this.h = paramQQAppInterface;
    return this.m;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    if (paramQQAppInterface == null) {
      return -1;
    }
    return paramQQAppInterface.CloseDevLock(paramString, AppSetting.a, paramWtloginObserver);
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    if (paramQQAppInterface == null) {
      return -1;
    }
    return paramQQAppInterface.CheckSMSAndGetSt(paramString, paramArrayOfByte, paramWtloginObserver);
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    this.i = paramString;
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramContext == null) || (paramAppRuntime == null)) {}
    do
    {
      do
      {
        return -1;
      } while (TextUtils.isEmpty(paramString));
      paramContext = paramContext.getSharedPreferences("devlock_sharedpref", 0);
    } while (paramContext == null);
    paramAppRuntime = paramAppRuntime.getAccount();
    if (paramBoolean)
    {
      paramContext.edit().putInt("devlock_status" + paramString, 0).commit();
      if (paramString.equalsIgnoreCase(paramAppRuntime)) {
        this.m = 0;
      }
    }
    for (;;)
    {
      return 0;
      paramContext.edit().putInt("devlock_status" + paramString, 1).commit();
      if (paramString.equalsIgnoreCase(paramAppRuntime)) {
        this.m = 1;
      }
    }
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString1, String paramString2, byte[] paramArrayOfByte, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString1))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.CheckDevLockSms(paramString1, AppSetting.a, paramString2, paramArrayOfByte, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
    if (paramAppRuntime == null) {
      return -1;
    }
    return paramAppRuntime.AskDevLockSms(paramString, paramWtloginObserver);
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.refreshDevLockSms(paramVerifyDevLockObserver);
    return 0;
  }
  
  public int a(AppRuntime paramAppRuntime, VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString)
  {
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime = (VerifyDevLockManager)paramAppRuntime.getManager(7);
    if (paramAppRuntime == null) {
      return -1;
    }
    paramAppRuntime.submitSms(paramVerifyDevLockObserver, paramString);
    return 0;
  }
  
  public Handler a(Integer paramInteger)
  {
    return (Handler)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
  }
  
  public String a()
  {
    return this.i;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), DevlockQuickLoginActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("qrcode", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("maintip", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("smalltip", this.d);
      localIntent.putExtra("loginConfig", this.jdField_a_of_type_ArrayOfByte);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.d = null;
      this.jdField_a_of_type_ArrayOfByte = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    boolean bool;
    label22:
    Object localObject2;
    Object localObject1;
    if ((paramQQAppInterface.isBackground_Pause) || (paramQQAppInterface.isBackground_Stop))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "handleQuickloginPush isInBackground=" + bool + " app.isBackground_Pause=" + paramQQAppInterface.isBackground_Pause + " app.isBackground_Stop=" + paramQQAppInterface.isBackground_Stop);
      }
      if (!bool) {
        break label418;
      }
      paramQQAppInterface = BaseApplicationImpl.getContext();
      localObject2 = paramQQAppInterface.getString(2131368895);
      String str1 = paramQQAppInterface.getString(2131368895);
      String str2 = paramString2 + "\n" + paramString3;
      localObject1 = BitmapManager.a(paramQQAppInterface.getResources(), 2130839616);
      localObject2 = new NotificationCompat.Builder(paramQQAppInterface).setContentTitle(str1).setContentText(str2).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker((CharSequence)localObject2).setWhen(System.currentTimeMillis());
      if (localObject1 == null) {
        break label399;
      }
      ((NotificationCompat.Builder)localObject2).setLargeIcon((Bitmap)localObject1);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject2).setSmallIcon(2130839616);
      }
      localObject1 = new Intent(paramQQAppInterface, DevlockQuickLoginActivity.class);
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).putExtra("qrcode", paramString1);
      ((Intent)localObject1).putExtra("maintip", paramString2);
      ((Intent)localObject1).putExtra("smalltip", paramString3);
      ((Intent)localObject1).putExtra("loginConfig", paramArrayOfByte);
      ((NotificationCompat.Builder)localObject2).setContentIntent(PendingIntent.getActivity(paramQQAppInterface, 0, (Intent)localObject1, 134217728));
      localObject1 = ((NotificationCompat.Builder)localObject2).build();
      paramQQAppInterface = (NotificationManager)paramQQAppInterface.getSystemService("notification");
      if (paramQQAppInterface == null) {
        break;
      }
      paramQQAppInterface.cancel(10103);
      paramQQAppInterface.notify(10103, (Notification)localObject1);
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.d = paramString3;
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.length);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(20140414);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(20140414, 120000L);
      return;
      bool = false;
      break label22;
      label399:
      ((NotificationCompat.Builder)localObject2).setLargeIcon(BitmapManager.a(paramQQAppInterface.getResources(), 2130839616));
    }
    label418:
    paramQQAppInterface = new Intent(BaseApplicationImpl.getContext(), DevlockQuickLoginActivity.class);
    paramQQAppInterface.addFlags(268435456);
    paramQQAppInterface.putExtra("qrcode", paramString1);
    paramQQAppInterface.putExtra("maintip", paramString2);
    paramQQAppInterface.putExtra("smalltip", paramString3);
    paramQQAppInterface.putExtra("loginConfig", paramArrayOfByte);
    BaseApplicationImpl.getContext().startActivity(paramQQAppInterface);
  }
  
  public void a(Integer paramInteger)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramInteger);
  }
  
  public void a(Integer paramInteger, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramInteger, paramHandler);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime != null)
    {
      paramAppRuntime = (WtloginManager)paramAppRuntime.getManager(1);
      if (paramAppRuntime != null) {
        paramAppRuntime.SetDevlockMobileType(paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    long l = Long.parseLong(paramQQAppInterface.getAccount());
    String str = null;
    int j = AppSetting.a;
    paramQQAppInterface.getApplication();
    Context localContext = MobileQQ.getContext();
    if (localContext != null) {
      str = localContext.getPackageName();
    }
    if ((str == null) || (str.length() < 1)) {
      str = "com.tencent.minihd.qq";
    }
    for (;;)
    {
      paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.a(l, str, j);
        return true;
      }
      return false;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(paramLong, paramByte, paramArrayOfByte, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(paramString, paramArrayList, paramInt);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(paramString, paramArrayList, paramInt, paramBoolean, paramLong);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    if ((paramQQAppInterface == null) || (paramArrayList == null)) {
      return false;
    }
    long l = Long.parseLong(paramQQAppInterface.getAccount());
    String str = null;
    int j = AppSetting.a;
    paramQQAppInterface.getApplication();
    Object localObject = MobileQQ.getContext();
    if (localObject != null) {
      str = ((Context)localObject).getPackageName();
    }
    if (str != null)
    {
      localObject = str;
      if (str.length() >= 1) {}
    }
    else
    {
      localObject = "com.tencent.minihd.qq";
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.a(l, j, (String)localObject, 1000, paramArrayList);
      return true;
    }
    return false;
  }
  
  public int b(QQAppInterface paramQQAppInterface, String paramString, WtloginObserver paramWtloginObserver)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return -1;
    }
    paramQQAppInterface = (WtloginManager)paramQQAppInterface.getManager(1);
    if (paramQQAppInterface == null) {
      return -1;
    }
    return paramQQAppInterface.RefreshSMSData(paramString, paramWtloginObserver);
  }
  
  public void b()
  {
    NotificationManager localNotificationManager = (NotificationManager)BaseApplicationImpl.getContext().getSystemService("notification");
    if (localNotificationManager != null) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(20140414);
      localNotificationManager.cancel(10103);
      label33:
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.d = null;
      this.jdField_a_of_type_ArrayOfByte = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label33;
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.b(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.c(paramLong, paramString, 0L);
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.equipmentlock.EquipmentLockImpl
 * JD-Core Version:    0.7.0.1
 */