package com.qcloud.qvb;

public abstract class LoggerCallback
{
  private static LoggerCallback logger;
  
  public static void debug(String paramString1, String paramString2)
  {
    LoggerCallback localLoggerCallback = logger;
    if (localLoggerCallback != null) {
      localLoggerCallback.d(paramString1, paramString2);
    }
  }
  
  public static void error(String paramString1, String paramString2)
  {
    LoggerCallback localLoggerCallback = logger;
    if (localLoggerCallback != null) {
      localLoggerCallback.e(paramString1, paramString2);
    }
  }
  
  public static void info(String paramString1, String paramString2)
  {
    LoggerCallback localLoggerCallback = logger;
    if (localLoggerCallback != null) {
      localLoggerCallback.i(paramString1, paramString2);
    }
  }
  
  public static void setLoggerCallback(LoggerCallback paramLoggerCallback)
  {
    logger = paramLoggerCallback;
  }
  
  public static void verbose(String paramString1, String paramString2)
  {
    LoggerCallback localLoggerCallback = logger;
    if (localLoggerCallback != null) {
      localLoggerCallback.v(paramString1, paramString2);
    }
  }
  
  public static void warn(String paramString1, String paramString2)
  {
    LoggerCallback localLoggerCallback = logger;
    if (localLoggerCallback != null) {
      localLoggerCallback.w(paramString1, paramString2);
    }
  }
  
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void v(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.qcloud.qvb.LoggerCallback
 * JD-Core Version:    0.7.0.1
 */