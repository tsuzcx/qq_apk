package com.tencent.component.network.module.base;

import com.tencent.component.network.module.base.inter.IDownloadConfig;

public class a
{
  private static IDownloadConfig a = null;
  
  public static int a()
  {
    if (a != null) {
      return a.b();
    }
    return -1;
  }
  
  public static long a()
  {
    if (a != null) {
      return a.a();
    }
    return 0L;
  }
  
  public static String a()
  {
    if (a != null) {
      return a.c();
    }
    return "android";
  }
  
  public static void a(IDownloadConfig paramIDownloadConfig)
  {
    a = paramIDownloadConfig;
  }
  
  public static boolean a()
  {
    if (a != null) {
      return a.a();
    }
    return true;
  }
  
  public static int b()
  {
    if (a != null) {
      return a.c();
    }
    return -1;
  }
  
  public static String b()
  {
    if (a != null) {
      return a.e();
    }
    return "1.0";
  }
  
  public static int c()
  {
    if (a != null) {
      return a.a();
    }
    return 0;
  }
  
  public static String c()
  {
    if (a != null) {
      return a.b();
    }
    return "tencent";
  }
  
  public static int d()
  {
    if (a != null) {
      return a.d();
    }
    return 5;
  }
  
  public static String d()
  {
    if (a != null) {
      return a.d();
    }
    return "android-tencent";
  }
  
  public static String e()
  {
    if (a != null) {
      return a.a();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.base.a
 * JD-Core Version:    0.7.0.1
 */