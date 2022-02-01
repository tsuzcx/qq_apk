package com.tencent.mobileqq.activity.widget.qqmusic.utils;

public class MLog
{
  public static final boolean a = false;
  
  public static void a(String paramString, Error paramError)
  {
    if (paramError != null) {
      d(paramString, paramError.toString());
    }
  }
  
  public static void a(String paramString, Exception paramException)
  {
    if (paramException != null) {
      d(paramString, paramException.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2) {}
  
  public static void a(String paramString1, String paramString2, Error paramError)
  {
    if (paramError != null) {
      d(paramString1, paramString2 + "\n" + paramError.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2, Exception paramException)
  {
    if (paramException != null) {
      d(paramString1, paramString2 + "\n" + paramException.toString());
    }
  }
  
  public static void b(String paramString1, String paramString2) {}
  
  public static void c(String paramString1, String paramString2) {}
  
  public static void d(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog
 * JD-Core Version:    0.7.0.1
 */