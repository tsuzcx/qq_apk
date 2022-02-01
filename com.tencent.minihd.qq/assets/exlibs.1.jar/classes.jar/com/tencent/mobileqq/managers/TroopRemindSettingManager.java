package com.tencent.mobileqq.managers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopRemindSettingManager
{
  public static final int a = 0;
  private static TroopRemindSettingManager a;
  public static final String a = "init_troop_remind";
  public static boolean a = false;
  public static final int b = 1;
  
  public static TroopRemindSettingManager a()
  {
    if (a == null) {
      a = new TroopRemindSettingManager();
    }
    return a;
  }
  
  public static void a()
  {
    if (a != null) {
      a = null;
    }
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troop_remind", false).commit();
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
    localTroopRemindSettingData.troopUin = paramString;
    localTroopRemindSettingData.isOpenState = 1;
    paramQQAppInterface.b(localTroopRemindSettingData);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troop_remind", true);
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = (TroopRemindSettingData)paramQQAppInterface.a().createEntityManager().a(TroopRemindSettingData.class, paramString);
    return (paramString != null) && (paramString.isOpenState == 0);
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if ((TroopRemindSettingData)paramQQAppInterface.a(TroopRemindSettingData.class, paramString) == null)
    {
      TroopRemindSettingData localTroopRemindSettingData = new TroopRemindSettingData();
      localTroopRemindSettingData.troopUin = paramString;
      localTroopRemindSettingData.isOpenState = 0;
      paramQQAppInterface.b(localTroopRemindSettingData);
    }
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramString = (TroopRemindSettingData)paramQQAppInterface.a(TroopRemindSettingData.class, paramString);
    if (paramString != null) {
      paramQQAppInterface.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopRemindSettingManager
 * JD-Core Version:    0.7.0.1
 */