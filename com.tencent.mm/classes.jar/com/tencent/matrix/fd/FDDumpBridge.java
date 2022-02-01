package com.tencent.matrix.fd;

import androidx.annotation.Keep;
import com.tencent.matrix.e.c;

public class FDDumpBridge
{
  private static boolean initialized;
  
  static
  {
    try
    {
      System.loadLibrary("matrix-fd");
      initialized = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      c.printErrStackTrace("FDDumpBridge", localThrowable, "", new Object[0]);
      initialized = false;
    }
  }
  
  public static String fe(String paramString)
  {
    if (!initialized) {
      return paramString;
    }
    return getFdPathNameNative(paramString);
  }
  
  @Keep
  public static native int getFDLimit();
  
  @Keep
  public static native String getFdPathNameNative(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.fd.FDDumpBridge
 * JD-Core Version:    0.7.0.1
 */