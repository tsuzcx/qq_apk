package com.tencent.matrix.xlog;

public class XLogNative
{
  public static void hs(String paramString)
  {
    setXLoggerNative(paramString);
  }
  
  private static native void setXLoggerNative(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.xlog.XLogNative
 * JD-Core Version:    0.7.0.1
 */