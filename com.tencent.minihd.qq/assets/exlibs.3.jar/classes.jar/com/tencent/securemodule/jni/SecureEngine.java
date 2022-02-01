package com.tencent.securemodule.jni;

import android.content.Context;

public class SecureEngine
{
  private int object;
  
  public SecureEngine(Context paramContext)
  {
    try
    {
      this.object = newObject(paramContext);
      if (this.object == 0) {
        throw new VerifyError();
      }
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean checkSecureStatus(Context paramContext)
  {
    try
    {
      boolean bool = nativeCheckSecureStatus(paramContext);
      return bool;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  private static native void deleteObject(int paramInt);
  
  public static String getEngineVersion(Context paramContext)
  {
    try
    {
      paramContext = nativeGetEngineVersion(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  private static native boolean nativeCheckSecureStatus(Context paramContext);
  
  private static native String nativeGetEngineVersion(Context paramContext);
  
  private static native int newObject(Context paramContext);
  
  private static native int scanThreatens(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  protected void finalize()
  {
    if (this.object != 0) {
      deleteObject(this.object);
    }
  }
  
  public int scanThreatens(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      paramInt = scanThreatens(this.object, paramInt, paramArrayOfByte);
      return paramInt;
    }
    catch (Throwable paramArrayOfByte) {}
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.securemodule.jni.SecureEngine
 * JD-Core Version:    0.7.0.1
 */