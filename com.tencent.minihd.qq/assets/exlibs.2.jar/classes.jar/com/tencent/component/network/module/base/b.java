package com.tencent.component.network.module.base;

public class b
{
  private static com.tencent.component.network.module.base.inter.Log a;
  
  private static int a()
  {
    if (a != null) {
      return a.a();
    }
    return 1;
  }
  
  public static void a(com.tencent.component.network.module.base.inter.Log paramLog)
  {
    a = paramLog;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.a(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean a()
  {
    return 2 >= a();
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.c(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean b()
  {
    return 3 >= a();
  }
  
  public static void c(String paramString1, String paramString2)
  {
    c(paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.d(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.w(paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.b(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.base.b
 * JD-Core Version:    0.7.0.1
 */