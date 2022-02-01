package com.tencent.mobileqq.utils.kapalaiadapter;

import android.os.Build;

public class MobileIssueSettings
{
  public static int a;
  public static boolean a;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public static boolean i;
  public static boolean j;
  public static boolean k;
  public static boolean l;
  public static boolean m;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    b = true;
    c = true;
    d = true;
    e = true;
    f = true;
    g = true;
    h = true;
    i = true;
    j = true;
    k = true;
    l = false;
    m = false;
    jdField_a_of_type_Int = 0;
    String str1 = Build.MODEL;
    String str2 = Build.MANUFACTURER;
    if (str2.equalsIgnoreCase("htc")) {
      MoblieModelConfig.a().b(str1);
    }
    do
    {
      return;
      if ((str2.equalsIgnoreCase("samsung")) || (str2.equalsIgnoreCase("samsng")))
      {
        MoblieModelConfig.a().a(str1);
        return;
      }
      if (str2.equalsIgnoreCase("motorola"))
      {
        MoblieModelConfig.a().c(str1);
        return;
      }
      if (str2.equalsIgnoreCase("huawei"))
      {
        MoblieModelConfig.a().d(str1);
        return;
      }
      if (str2.equalsIgnoreCase("zte"))
      {
        MoblieModelConfig.a().e(str1);
        return;
      }
      if (str2.equalsIgnoreCase("meizu"))
      {
        MoblieModelConfig.a().f(str1);
        return;
      }
      if (str2.equalsIgnoreCase("alps"))
      {
        MoblieModelConfig.a().g(str1);
        return;
      }
      if ((str2.equalsIgnoreCase("k-touch")) || (str2.equalsIgnoreCase("sprd")))
      {
        MoblieModelConfig.a().h(str1);
        return;
      }
      if ((str2.equalsIgnoreCase("yulong")) || (str2.equalsIgnoreCase("coolpad")))
      {
        MoblieModelConfig.a().i(str1);
        return;
      }
      if (str2.equalsIgnoreCase("lenovo"))
      {
        MoblieModelConfig.a().j(str1);
        return;
      }
      if (str2.equalsIgnoreCase("bbk"))
      {
        MoblieModelConfig.a().k(str1);
        return;
      }
      if (str2.equalsIgnoreCase("gionee"))
      {
        MoblieModelConfig.a().l(str1);
        return;
      }
      if (str2.equalsIgnoreCase("eton"))
      {
        MoblieModelConfig.a().m(str1);
        return;
      }
      if (str2.equalsIgnoreCase("doov"))
      {
        MoblieModelConfig.a().n(str1);
        return;
      }
    } while (!str2.equalsIgnoreCase("sony ericsson"));
    MoblieModelConfig.a().o(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings
 * JD-Core Version:    0.7.0.1
 */