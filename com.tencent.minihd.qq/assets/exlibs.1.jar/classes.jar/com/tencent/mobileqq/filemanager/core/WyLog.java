package com.tencent.mobileqq.filemanager.core;

import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.log.ILogger;

public class WyLog
  implements ILogger
{
  private static WyLog a;
  
  public static WyLog a()
  {
    if (a == null) {
      a = new WyLog();
    }
    return a;
  }
  
  public void d(String paramString1, String paramString2)
  {
    QLog.d(paramString1, 2, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, 2, paramString2, paramThrowable);
  }
  
  public void d(String paramString, Throwable paramThrowable)
  {
    QLog.d(paramString, 2, paramThrowable.getLocalizedMessage());
  }
  
  public void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    QLog.e(paramString, 1, paramThrowable.getLocalizedMessage());
  }
  
  public void i(String paramString1, String paramString2)
  {
    QLog.i(paramString1, 1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void i(String paramString, Throwable paramThrowable)
  {
    QLog.i(paramString, 1, paramThrowable.getLocalizedMessage());
  }
  
  public void v(String paramString1, String paramString2) {}
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable) {}
  
  public void v(String paramString, Throwable paramThrowable) {}
  
  public void w(String paramString1, String paramString2)
  {
    QLog.w(paramString1, 1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void w(String paramString, Throwable paramThrowable)
  {
    QLog.w(paramString, 1, paramThrowable.getLocalizedMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.WyLog
 * JD-Core Version:    0.7.0.1
 */