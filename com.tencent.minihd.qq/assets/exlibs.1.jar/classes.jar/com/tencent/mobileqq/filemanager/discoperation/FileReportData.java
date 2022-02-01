package com.tencent.mobileqq.filemanager.discoperation;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class FileReportData
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public String g;
  public long h;
  public String h;
  public long i;
  public String i;
  public long j;
  public String j;
  public long k;
  public String k;
  
  public FileReportData(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public HashMap a()
  {
    HashMap localHashMap = null;
    Object localObject = localHashMap;
    try
    {
      if (this.jdField_g_of_type_JavaLangString != null)
      {
        localObject = localHashMap;
        if (this.jdField_g_of_type_JavaLangString.length() > 0) {
          localObject = this.jdField_g_of_type_JavaLangString.substring(this.jdField_g_of_type_JavaLangString.indexOf("://") + 3, this.jdField_g_of_type_JavaLangString.lastIndexOf(":"));
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = this.jdField_g_of_type_JavaLangString;
      }
    }
    localHashMap = new HashMap();
    localHashMap.put("param_serverip", String.valueOf(localObject));
    localHashMap.put("param_Server", String.valueOf(localObject));
    localHashMap.put("param_PeerUin", String.valueOf(this.jdField_h_of_type_JavaLangString));
    localHashMap.put("param_PeerType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_uuid", String.valueOf(this.jdField_i_of_type_JavaLangString));
    localHashMap.put("param_FailCode", Long.toString(this.jdField_a_of_type_Long));
    localHashMap.put("param_fsized", String.valueOf(this.jdField_i_of_type_Long));
    localHashMap.put("param_fsizeo", String.valueOf(this.jdField_k_of_type_Long));
    localHashMap.put("param_url", String.valueOf(this.jdField_g_of_type_JavaLangString));
    localHashMap.put("param_rspHeader", String.valueOf(this.jdField_j_of_type_JavaLangString));
    localHashMap.put("param_retry", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_errMsg", String.valueOf(this.c));
    localHashMap.put("param_nSessionId", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_CSDuration", String.valueOf(this.e - this.d));
    localHashMap.put("param_HttpDuration", String.valueOf(this.jdField_g_of_type_Long - this.f));
    localHashMap.put("param_AllDuration", String.valueOf(this.jdField_h_of_type_Long - this.d));
    return localHashMap;
  }
  
  public void a()
  {
    long l2 = System.currentTimeMillis() - this.jdField_g_of_type_Long;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = a();
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    String str1 = this.jdField_b_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_JavaLangString + "Detail";
    if (this.jdField_a_of_type_Long == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str1, str2, bool, l1, this.jdField_j_of_type_Long, localHashMap, this.jdField_k_of_type_JavaLangString);
      return;
    }
  }
  
  public void b()
  {
    long l2 = System.currentTimeMillis() - this.jdField_g_of_type_Long;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = a();
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    String str1 = this.jdField_b_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Long == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str1, str2, bool, l1, this.jdField_j_of_type_Long, localHashMap, this.jdField_k_of_type_JavaLangString);
      return;
    }
  }
  
  public void c()
  {
    long l2 = System.currentTimeMillis() - this.jdField_g_of_type_Long;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = a();
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    String str1 = this.jdField_b_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Long == 0L)
    {
      bool = true;
      localStatisticCollector.a(str1, str2, bool, l1, this.jdField_j_of_type_Long, localHashMap, this.jdField_k_of_type_JavaLangString);
      localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
      str1 = this.jdField_b_of_type_JavaLangString;
      str2 = this.jdField_a_of_type_JavaLangString + "Detail";
      if (this.jdField_a_of_type_Long != 0L) {
        break label165;
      }
    }
    label165:
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(str1, str2, bool, l1, this.jdField_j_of_type_Long, localHashMap, this.jdField_k_of_type_JavaLangString);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.discoperation.FileReportData
 * JD-Core Version:    0.7.0.1
 */