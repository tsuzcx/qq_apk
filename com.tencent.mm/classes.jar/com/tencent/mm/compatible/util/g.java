package com.tencent.mm.compatible.util;

import android.os.SystemClock;

public final class g
{
  public static int getLine()
  {
    return new java.lang.Throwable().getStackTrace()[1].getLineNumber();
  }
  
  public static String zH()
  {
    return new java.lang.Throwable().getStackTrace()[1].toString();
  }
  
  public static String zI()
  {
    StackTraceElement localStackTraceElement = new java.lang.Throwable().getStackTrace()[1];
    int i = localStackTraceElement.getMethodName().lastIndexOf('.');
    return localStackTraceElement.getMethodName().substring(i + 1) + "(" + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + ")";
  }
  
  public static final class a
  {
    public long dzS = SystemClock.elapsedRealtime();
    
    public final long zJ()
    {
      return SystemClock.elapsedRealtime() - this.dzS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.g
 * JD-Core Version:    0.7.0.1
 */