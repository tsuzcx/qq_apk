package com.tencent.matrix.xlog;

import androidx.annotation.Keep;

public class XLogNative
{
  public static void fP(String paramString)
  {
    setXLoggerNative(paramString);
  }
  
  @Keep
  private static native void setXLoggerNative(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.xlog.XLogNative
 * JD-Core Version:    0.7.0.1
 */