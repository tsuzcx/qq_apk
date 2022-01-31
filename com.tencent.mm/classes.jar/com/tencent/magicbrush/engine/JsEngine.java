package com.tencent.magicbrush.engine;

import com.tencent.magicbrush.a.c;
import java.nio.ByteBuffer;

public class JsEngine
{
  static {}
  
  public static native void addJsInterface(long paramLong, Object paramObject, String paramString);
  
  static native long createVM(String paramString, byte[] paramArrayOfByte);
  
  static native long createVMContext(long paramLong, int paramInt);
  
  public static native String evaluateJavascript(long paramLong, String paramString);
  
  public static native String evaluateJavascriptCache(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static native String evaluateJavascriptDebug(long paramLong, String paramString1, String paramString2);
  
  public static native String evaluateJavascriptFile(long paramLong, String paramString1, String paramString2);
  
  static native ByteBuffer getNativeBuffer(int paramInt, long paramLong);
  
  public static native int getNativeBufferId();
  
  static native void pumpMessageLoop(long paramLong);
  
  public static native boolean pushObject(long paramLong1, long paramLong2, String paramString);
  
  static native void releaseVM(long paramLong);
  
  static native void releaseVMContext(long paramLong);
  
  static native boolean removeJsInterface(long paramLong, String paramString);
  
  static native boolean removeObject(long paramLong, String paramString);
  
  public static native void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer);
  
  public static native void waitForDebuger(long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.engine.JsEngine
 * JD-Core Version:    0.7.0.1
 */