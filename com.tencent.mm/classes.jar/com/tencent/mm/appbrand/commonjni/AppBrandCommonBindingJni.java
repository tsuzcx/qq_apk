package com.tencent.mm.appbrand.commonjni;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.a.a;
import com.tencent.mm.appbrand.commonjni.a.b;
import com.tencent.mm.appbrand.commonjni.a.c.c;
import java.nio.ByteBuffer;
import java.util.Objects;

@Keep
public class AppBrandCommonBindingJni
{
  private static final String TAG = "MicroMsg.AppBrandRuntimeJni";
  private a.a mAppBrandDelegate;
  private long mNativeHandle;
  
  static
  {
    AppMethodBeat.i(246811);
    b.loadLibrary("wxa-runtime-binding");
    AppMethodBeat.o(246811);
  }
  
  public AppBrandCommonBindingJni(a.a parama)
  {
    AppMethodBeat.i(246792);
    this.mNativeHandle = 0L;
    this.mAppBrandDelegate = ((a.a)Objects.requireNonNull(parama));
    AppMethodBeat.o(246792);
  }
  
  private native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  public static native boolean nativeBrotliDecompress(String paramString1, String paramString2);
  
  private native long nativeCreate(AppBrandCommonBindingJniParams paramAppBrandCommonBindingJniParams);
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativePause(long paramLong);
  
  private native void nativeRequestV8GarbageCollectionForTest(long paramLong);
  
  private native void nativeResume(long paramLong);
  
  private native void nativeRuntimeReady(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSuspend(long paramLong);
  
  @Keep
  protected boolean doInnerLoopTask()
  {
    AppMethodBeat.i(246809);
    boolean bool = this.mAppBrandDelegate.doInnerLoopTask();
    AppMethodBeat.o(246809);
    return bool;
  }
  
  @Keep
  protected String[] getAsyncableJsApis()
  {
    AppMethodBeat.i(246806);
    String[] arrayOfString = this.mAppBrandDelegate.getAsyncableJsApis();
    AppMethodBeat.o(246806);
    return arrayOfString;
  }
  
  public long getNativeHandle()
  {
    return this.mNativeHandle;
  }
  
  @Keep
  protected String nativeInvokeHandler(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(246804);
    paramString1 = this.mAppBrandDelegate.nativeInvokeHandler(paramString1, paramString2, paramInt, paramBoolean);
    AppMethodBeat.o(246804);
    return paramString1;
  }
  
  public void notifyBindTo(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(246795);
    if (this.mNativeHandle > 0L) {
      nativeBindTo(this.mNativeHandle, paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(246795);
  }
  
  public void notifyCreate(AppBrandCommonBindingJniParams paramAppBrandCommonBindingJniParams)
  {
    AppMethodBeat.i(246794);
    this.mNativeHandle = nativeCreate(paramAppBrandCommonBindingJniParams);
    c.c.i("MicroMsg.AppBrandRuntimeJni", "hy: created with %d", new Object[] { Long.valueOf(this.mNativeHandle) });
    AppMethodBeat.o(246794);
  }
  
  public void notifyDestroy()
  {
    AppMethodBeat.i(246799);
    if (this.mNativeHandle > 0L)
    {
      nativeDestroy(this.mNativeHandle);
      this.mNativeHandle = 0L;
      this.mAppBrandDelegate = null;
    }
    AppMethodBeat.o(246799);
  }
  
  public void notifyPause()
  {
    AppMethodBeat.i(246798);
    if (this.mNativeHandle > 0L) {
      nativePause(this.mNativeHandle);
    }
    AppMethodBeat.o(246798);
  }
  
  public void notifyResume()
  {
    AppMethodBeat.i(246797);
    if (this.mNativeHandle > 0L) {
      nativeResume(this.mNativeHandle);
    }
    AppMethodBeat.o(246797);
  }
  
  public void notifyRuntimeReady(String paramString1, String paramString2)
  {
    AppMethodBeat.i(246796);
    if (this.mNativeHandle > 0L) {
      nativeRuntimeReady(this.mNativeHandle, paramString1, paramString2);
    }
    AppMethodBeat.o(246796);
  }
  
  public void notifySuspend()
  {
    AppMethodBeat.i(246800);
    if (this.mNativeHandle > 0L) {
      nativeSuspend(this.mNativeHandle);
    }
    AppMethodBeat.o(246800);
  }
  
  @Keep
  ByteBuffer readWeAppFile(String paramString)
  {
    AppMethodBeat.i(246807);
    paramString = this.mAppBrandDelegate.readWeAppFile(paramString);
    AppMethodBeat.o(246807);
    return paramString;
  }
  
  public void requestV8GarbageCollectionForTest()
  {
    AppMethodBeat.i(246802);
    if (this.mNativeHandle > 0L) {
      nativeRequestV8GarbageCollectionForTest(this.mNativeHandle);
    }
    AppMethodBeat.o(246802);
  }
  
  @Keep
  protected void resumeLoopTasks()
  {
    AppMethodBeat.i(246808);
    this.mAppBrandDelegate.resumeLoopTasks();
    AppMethodBeat.o(246808);
  }
  
  @Keep
  protected boolean syncInitModule(String paramString1, String paramString2)
  {
    AppMethodBeat.i(246810);
    c.c.i("MicroMsg.AppBrandRuntimeJni", "hy: request init %s with params %s", new Object[] { paramString1, paramString2 });
    boolean bool = this.mAppBrandDelegate.syncInitModule(paramString1, paramString2);
    AppMethodBeat.o(246810);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni
 * JD-Core Version:    0.7.0.1
 */