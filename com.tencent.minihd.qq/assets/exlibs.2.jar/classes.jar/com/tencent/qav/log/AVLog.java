package com.tencent.qav.log;

public class AVLog
{
  private static AVLogBase sImpl = new AVLogBase();
  
  public static void d(String paramString1, String paramString2)
  {
    sImpl.d(paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    sImpl.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    sImpl.e(paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    sImpl.e(paramString1, paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    sImpl.i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    sImpl.i(paramString1, paramString2, paramThrowable);
  }
  
  public static void setAVLogImpl(AVLogBase paramAVLogBase)
  {
    if (paramAVLogBase != null)
    {
      sImpl = paramAVLogBase;
      return;
    }
    sImpl = new AVLogBase();
  }
  
  public static void w(String paramString1, String paramString2)
  {
    sImpl.w(paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    sImpl.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.log.AVLog
 * JD-Core Version:    0.7.0.1
 */