package com.tencent.mm.appbrand.commonjni;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Keep
public class AppBrandJsBridgeBinding
{
  private long mJsRuntimeInst = 0L;
  
  private native long nativeCreateRuntime(long paramLong1, long paramLong2);
  
  private native void nativeDestroyRuntime(long paramLong);
  
  private native void nativeInvokeCallbackHandler(long paramLong, int paramInt, String paramString);
  
  private native void nativeSubscribeHandler(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public void createRuntime(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(246817);
    this.mJsRuntimeInst = nativeCreateRuntime(paramLong1, paramLong2);
    AppMethodBeat.o(246817);
  }
  
  public void destroyRuntime()
  {
    AppMethodBeat.i(246818);
    nativeDestroyRuntime(this.mJsRuntimeInst);
    AppMethodBeat.o(246818);
  }
  
  public void invokeCallbackHandler(int paramInt, String paramString)
  {
    AppMethodBeat.i(246820);
    nativeInvokeCallbackHandler(this.mJsRuntimeInst, paramInt, paramString);
    AppMethodBeat.o(246820);
  }
  
  public void subscribeHandler(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(246821);
    nativeSubscribeHandler(this.mJsRuntimeInst, paramString1, paramString2, paramInt, paramString3);
    AppMethodBeat.o(246821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.AppBrandJsBridgeBinding
 * JD-Core Version:    0.7.0.1
 */