package com.tencent.mm.appbrand.commonjni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandJsBridgeBinding
{
  private long mJsRuntimeInst = 0L;
  
  private native long nativeCreateRuntime(long paramLong1, long paramLong2);
  
  private native void nativeDestroyRuntime(long paramLong);
  
  private native void nativeInvokeCallbackHandler(long paramLong, int paramInt, String paramString);
  
  private native void nativeSubscribeHandler(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public void createRuntime(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(238567);
    this.mJsRuntimeInst = nativeCreateRuntime(paramLong1, paramLong2);
    AppMethodBeat.o(238567);
  }
  
  public void destroyRuntime()
  {
    AppMethodBeat.i(238571);
    nativeDestroyRuntime(this.mJsRuntimeInst);
    AppMethodBeat.o(238571);
  }
  
  public void invokeCallbackHandler(int paramInt, String paramString)
  {
    AppMethodBeat.i(238575);
    nativeInvokeCallbackHandler(this.mJsRuntimeInst, paramInt, paramString);
    AppMethodBeat.o(238575);
  }
  
  public void subscribeHandler(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(238579);
    nativeSubscribeHandler(this.mJsRuntimeInst, paramString1, paramString2, paramInt, paramString3);
    AppMethodBeat.o(238579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.AppBrandJsBridgeBinding
 * JD-Core Version:    0.7.0.1
 */