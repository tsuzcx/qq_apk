package com.tencent.mobileqq.transfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kau;

public class PttInfoCollector
{
  public static int a;
  public static String a;
  public static HashMap a;
  public static int b;
  public static String b;
  public static int c;
  public static String c;
  public static int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "downloading";
    jdField_b_of_type_JavaLangString = "succeeded";
    jdField_c_of_type_JavaLangString = "failed";
    jdField_a_of_type_Int = 100;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    d = -1;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          jdField_b_of_type_Int += 1;
        } while (jdField_b_of_type_Int % jdField_a_of_type_Int != 0);
        b(0);
        return;
        jdField_c_of_type_Int += 1;
      } while (jdField_c_of_type_Int % jdField_a_of_type_Int != 0);
      b(1);
      return;
      d += 1;
    } while (d % jdField_a_of_type_Int != 0);
    b(2);
  }
  
  public static void a(long paramLong, String paramString)
  {
    kau localkau = new kau();
    localkau.a();
    jdField_a_of_type_JavaUtilHashMap.put(paramString + paramLong, localkau);
  }
  
  public static void a(SharedPreferences paramSharedPreferences)
  {
    jdField_b_of_type_Int = paramSharedPreferences.getInt(jdField_a_of_type_JavaLangString, 0);
    jdField_c_of_type_Int = paramSharedPreferences.getInt(jdField_b_of_type_JavaLangString, 0);
    d = paramSharedPreferences.getInt(jdField_c_of_type_JavaLangString, 0);
  }
  
  public static void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttDownloadStream2Offline", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == 1000L) || (paramLong1 == 1001L) || (paramLong1 == 1002L) || (paramLong1 == 1003L) || (paramLong1 == 1004L) || (paramLong1 == 1005L) || (paramLong1 == 1006L) || (paramLong1 == 1008L) || (paramLong1 == 1009L) || (paramLong1 == 1010L) || (paramLong1 == 1011L) || (paramLong1 == 1020L) || (paramLong1 == 1021L) || (paramLong1 == 1022L) || (paramLong1 == 1023L) || (paramLong1 == 1024L) || (paramLong1 == 1025L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramLong1));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actAllC2CPttUp", paramBoolean, paramLong2, paramLong3, localHashMap, "");
    }
  }
  
  public static boolean a()
  {
    return (jdField_b_of_type_Int == -1) || (jdField_c_of_type_Int == -1) || (d == -1);
  }
  
  private static void b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttStatus", false, 0L, 0L, localHashMap, "");
  }
  
  public static void b(long paramLong, String paramString)
  {
    paramString = (kau)jdField_a_of_type_JavaUtilHashMap.get(paramString + paramLong);
    if ((paramString != null) && (paramString.c == 0L)) {
      paramString.c();
    }
  }
  
  public static void b(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    paramSharedPreferences.putInt(jdField_a_of_type_JavaLangString, jdField_b_of_type_Int);
    paramSharedPreferences.putInt(jdField_b_of_type_JavaLangString, jdField_c_of_type_Int);
    paramSharedPreferences.putInt(jdField_c_of_type_JavaLangString, d);
    paramSharedPreferences.commit();
  }
  
  public static void c(long paramLong, String paramString)
  {
    paramString = paramString + paramLong;
    kau localkau = (kau)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localkau != null)
    {
      localkau.b();
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttShowDownloading", localkau.a, localkau.a() / 1000000L, localkau.d, null, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttUserWaiting", localkau.a(), localkau.b() / 1000000L, localkau.d, null, "");
      jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PttInfoCollector
 * JD-Core Version:    0.7.0.1
 */