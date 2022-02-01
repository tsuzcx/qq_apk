package com.tencent.mm.appbrand.commonjni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.a.a;
import com.tencent.mm.appbrand.commonjni.a.b;
import com.tencent.mm.appbrand.commonjni.a.c.c;
import java.nio.ByteBuffer;
import java.util.Objects;

public class AppBrandCommonBindingJni
{
  private static final String TAG = "MicroMsg.AppBrandCommonBindingJni";
  private a.a mAppBrandDelegate;
  private long mNativeHandle;
  
  static
  {
    AppMethodBeat.i(238577);
    b.loadLibrary("wxa-runtime-binding");
    AppMethodBeat.o(238577);
  }
  
  public AppBrandCommonBindingJni(a.a parama)
  {
    AppMethodBeat.i(238535);
    this.mNativeHandle = 0L;
    this.mAppBrandDelegate = ((a.a)Objects.requireNonNull(parama));
    AppMethodBeat.o(238535);
  }
  
  private native void nativeBindConsoleTo(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  private native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  public static native boolean nativeBrotliDecompress(String paramString1, String paramString2);
  
  private native long nativeCreate(AppBrandCommonBindingJniParams paramAppBrandCommonBindingJniParams);
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativePause(long paramLong);
  
  private native void nativeRequestV8GarbageCollectionForTest(long paramLong);
  
  private native void nativeResume(long paramLong);
  
  private native void nativeRuntimeReady(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSuspend(long paramLong);
  
  protected boolean doInnerLoopTask()
  {
    AppMethodBeat.i(238623);
    boolean bool = this.mAppBrandDelegate.doInnerLoopTask();
    AppMethodBeat.o(238623);
    return bool;
  }
  
  protected String[] getAsyncableJsApis()
  {
    AppMethodBeat.i(238611);
    String[] arrayOfString = this.mAppBrandDelegate.getAsyncableJsApis();
    AppMethodBeat.o(238611);
    return arrayOfString;
  }
  
  public long getNativeHandle()
  {
    return this.mNativeHandle;
  }
  
  protected String nativeInvokeHandler(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(238607);
    paramString1 = this.mAppBrandDelegate.nativeInvokeHandler(paramString1, paramString2, paramString3, paramInt, paramBoolean);
    AppMethodBeat.o(238607);
    return paramString1;
  }
  
  public void notifyBindConsoleTo(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(238586);
    if (this.mNativeHandle != 0L) {
      nativeBindConsoleTo(this.mNativeHandle, paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(238586);
  }
  
  public void notifyBindTo(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(238583);
    if (this.mNativeHandle != 0L) {
      nativeBindTo(this.mNativeHandle, paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(238583);
  }
  
  public void notifyCreate(AppBrandCommonBindingJniParams paramAppBrandCommonBindingJniParams)
  {
    AppMethodBeat.i(238581);
    this.mNativeHandle = nativeCreate(paramAppBrandCommonBindingJniParams);
    c.c.i("MicroMsg.AppBrandCommonBindingJni", "hy: created with %d", new Object[] { Long.valueOf(this.mNativeHandle) });
    AppMethodBeat.o(238581);
  }
  
  public void notifyDestroy()
  {
    AppMethodBeat.i(238596);
    if (this.mNativeHandle != 0L)
    {
      nativeDestroy(this.mNativeHandle);
      this.mNativeHandle = 0L;
      this.mAppBrandDelegate = null;
    }
    AppMethodBeat.o(238596);
  }
  
  public void notifyPause()
  {
    AppMethodBeat.i(238594);
    if (this.mNativeHandle != 0L) {
      nativePause(this.mNativeHandle);
    }
    AppMethodBeat.o(238594);
  }
  
  public void notifyResume()
  {
    AppMethodBeat.i(238591);
    if (this.mNativeHandle != 0L) {
      nativeResume(this.mNativeHandle);
    }
    AppMethodBeat.o(238591);
  }
  
  public void notifyRuntimeReady(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238589);
    if (this.mNativeHandle != 0L) {
      nativeRuntimeReady(this.mNativeHandle, paramString1, paramString2);
    }
    AppMethodBeat.o(238589);
  }
  
  public void notifySuspend()
  {
    AppMethodBeat.i(238599);
    if (this.mNativeHandle != 0L) {
      nativeSuspend(this.mNativeHandle);
    }
    AppMethodBeat.o(238599);
  }
  
  ByteBuffer readWeAppFile(String paramString)
  {
    AppMethodBeat.i(238618);
    paramString = this.mAppBrandDelegate.readWeAppFile(paramString);
    AppMethodBeat.o(238618);
    return paramString;
  }
  
  protected void reportIDKey(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(238626);
    this.mAppBrandDelegate.W(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(238626);
  }
  
  protected void reportKV(int paramInt, String paramString)
  {
    AppMethodBeat.i(238629);
    this.mAppBrandDelegate.reportKV(paramInt, paramString);
    AppMethodBeat.o(238629);
  }
  
  public void requestV8GarbageCollectionForTest()
  {
    AppMethodBeat.i(238602);
    if (this.mNativeHandle != 0L) {
      nativeRequestV8GarbageCollectionForTest(this.mNativeHandle);
    }
    AppMethodBeat.o(238602);
  }
  
  protected void resumeLoopTasks()
  {
    AppMethodBeat.i(238621);
    this.mAppBrandDelegate.resumeLoopTasks();
    AppMethodBeat.o(238621);
  }
  
  protected boolean syncInitModule(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238630);
    c.c.i("MicroMsg.AppBrandCommonBindingJni", "hy: request init %s with params %s", new Object[] { paramString1, paramString2 });
    try
    {
      boolean bool = this.mAppBrandDelegate.syncInitModule(paramString1, paramString2);
      AppMethodBeat.o(238630);
      return bool;
    }
    finally
    {
      paramString1 = String.format("hy: syncInitModule %s crashed!!", new Object[] { paramString1 });
      c.c.printStackTrace("MicroMsg.AppBrandCommonBindingJni", paramString2, paramString1, new Object[0]);
      this.mAppBrandDelegate.fr(paramString1);
      AppMethodBeat.o(238630);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni
 * JD-Core Version:    0.7.0.1
 */