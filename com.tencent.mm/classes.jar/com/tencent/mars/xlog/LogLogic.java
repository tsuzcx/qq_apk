package com.tencent.mars.xlog;

public class LogLogic
{
  public static native int getAppenderModeFromCfg();
  
  public static native int getIPxxLogLevel();
  
  public static native int getLogLevelFromCfg();
  
  public static native void initIPxxLogInfo();
  
  public static native void setIPxxLogML(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.xlog.LogLogic
 * JD-Core Version:    0.7.0.1
 */