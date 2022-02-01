package com.tencent.mm.plugin.appbrand.jsruntime;

import android.support.annotation.Keep;

@Keep
public class JsBridgeBinding
{
  public static native long nativeCreateRuntime(long paramLong1, long paramLong2);
  
  public static native long nativeDestroyRuntime(long paramLong);
  
  public static native void nativeInvokeCallbackHandler(long paramLong, int paramInt, String paramString);
  
  public static native void nativeSubscribeHandler(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.JsBridgeBinding
 * JD-Core Version:    0.7.0.1
 */