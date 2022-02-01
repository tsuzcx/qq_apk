package com.tencent.mobileqq.activity.specialcare;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareHandler;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QvipSpecialCareManager
{
  public static final int a = 13568;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "specialcare_sound_setting_src";
  public static HashMap a;
  private static boolean jdField_a_of_type_Boolean = true;
  public static final int b = 13572;
  public static final String b = "specialcare_sound_setting_src_manage";
  public static final int c = 13573;
  private static final String c = "SpecialCareManager";
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return 10000;
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getInt("special_sound_type" + paramQQAppInterface.a() + paramString, 1);
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getLong("key_get_special_sound_quota_time" + paramQQAppInterface.a(), 0L);
  }
  
  public static Set a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramQQAppInterface = SharedPreferencesHandler.a(localSharedPreferences, "special_sound" + paramQQAppInterface.a(), null);
      return paramQQAppInterface;
    }
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putInt("special_sound_quota" + paramQQAppInterface.a(), paramInt);
    localEditor.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    Object localObject = SharedPreferencesHandler.a(paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4), "special_sound" + paramQQAppInterface.a(), null);
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        jdField_a_of_type_JavaUtilHashMap.put(paramQQAppInterface.a() + str, str);
      }
    }
    a(false);
  }
  
  public static void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putInt("special_sound_type" + paramQQAppInterface.a() + paramString, paramInt);
    localEditor.commit();
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    Object localObject2 = paramQQAppInterface.a() + paramString;
    if (!jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {
      jdField_a_of_type_JavaUtilHashMap.put(localObject2, paramString);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "special_sound" + paramQQAppInterface.a(), null);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new HashSet();
      }
      if (((Set)localObject1).contains(paramString)) {
        return;
      }
      ((Set)localObject1).add(paramString);
      paramString = ((Set)localObject1).toArray();
      SharedPreferencesHandler.a(localEditor, "special_sound" + paramQQAppInterface.a(), paramString).commit();
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      if (a(paramString1, paramQQAppInterface)) {
        b(paramString1, paramQQAppInterface);
      }
      if (b(paramString1, paramQQAppInterface)) {
        c(paramString1, paramQQAppInterface);
      }
    }
    do
    {
      return;
      try
      {
        int i = Integer.parseInt(paramString2);
        if (!a(paramString1, paramQQAppInterface)) {
          a(paramString1, paramQQAppInterface);
        }
        a(paramString1, i, paramQQAppInterface);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.i("SpecialCareManager", 2, "dealWithRespSound|exception = " + paramString1.toString());
  }
  
  public static void a(List paramList1, int paramInt, List paramList2, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (QvipSpecialCareHandler)paramQQAppInterface.a(14);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramList1, paramInt, paramList2);
    }
  }
  
  public static void a(List paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject1 = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    label224:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject1 = SharedPreferencesHandler.a((SharedPreferences)localObject1, "special_sound" + paramQQAppInterface.a(), null);
        if (localObject1 != null) {
          break label224;
        }
        localObject1 = new HashSet();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          String str1 = (String)paramList.next();
          String str2 = paramQQAppInterface.a() + str1;
          if (!jdField_a_of_type_JavaUtilHashMap.containsKey(str2)) {
            jdField_a_of_type_JavaUtilHashMap.put(str2, str1);
          }
          if (((Set)localObject1).contains(str1)) {
            continue;
          }
          ((Set)localObject1).add(str1);
        }
      }
      paramList = ((Set)localObject1).toArray();
      SharedPreferencesHandler.a(localEditor, "special_sound" + paramQQAppInterface.a(), paramList).commit();
      return;
    }
  }
  
  public static void a(Map paramMap, QQAppInterface paramQQAppInterface)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      int i = ((Integer)localEntry.getValue()).intValue();
      localEditor.putInt("special_sound_type" + paramQQAppInterface.a() + str, i);
    }
    localEditor.commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return a();
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramQQAppInterface = SharedPreferencesHandler.a(localSharedPreferences, "special_sound" + paramQQAppInterface.a(), null);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()) && (paramQQAppInterface.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    return 10000;
  }
  
  public static void b(int paramInt, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putInt("special_sound_svip_quota" + paramQQAppInterface.a(), paramInt);
    localEditor.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putLong("key_get_special_sound_quota_time" + paramQQAppInterface.a(), System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    ??? = paramQQAppInterface.a() + paramString;
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(???)) {
      jdField_a_of_type_JavaUtilHashMap.remove(???);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject2, "special_sound" + paramQQAppInterface.a(), null);
      if (localObject2 != null)
      {
        if (!((Set)localObject2).contains(paramString)) {
          return;
        }
        ((Set)localObject2).remove(paramString);
        paramString = ((Set)localObject2).toArray();
        SharedPreferencesHandler.a(localEditor, "special_sound" + paramQQAppInterface.a(), paramString).commit();
      }
      return;
    }
  }
  
  public static void b(List paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject2 = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = SharedPreferencesHandler.a((SharedPreferences)localObject2, "special_sound" + paramQQAppInterface.a(), null);
      if (localObject2 == null) {
        break label217;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str1 = (String)paramList.next();
        String str2 = paramQQAppInterface.a() + str1;
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(str2)) {
          jdField_a_of_type_JavaUtilHashMap.remove(str2);
        }
        if (((Set)localObject2).contains(str1)) {
          ((Set)localObject2).remove(str1);
        }
      }
    }
    paramList = ((Set)localObject2).toArray();
    SharedPreferencesHandler.a(localEditor, "special_sound" + paramQQAppInterface.a(), paramList).commit();
    label217:
  }
  
  public static boolean b(String paramString, QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).contains("special_sound_type" + paramQQAppInterface.a() + paramString);
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramQQAppInterface = SharedPreferencesHandler.a(localSharedPreferences, "special_sound" + paramQQAppInterface.a(), null);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.size();
      }
    }
    return 0;
  }
  
  public static void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.remove("special_sound_type" + paramQQAppInterface.a() + paramString);
    localEditor.commit();
  }
  
  public static void c(List paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localEditor.remove("special_sound_type" + paramQQAppInterface.a() + str);
    }
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager
 * JD-Core Version:    0.7.0.1
 */