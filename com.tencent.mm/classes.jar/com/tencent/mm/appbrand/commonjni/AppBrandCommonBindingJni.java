package com.tencent.mm.appbrand.commonjni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.a.a;
import com.tencent.mm.appbrand.commonjni.a.a.b;
import com.tencent.mm.appbrand.commonjni.a.b;
import com.tencent.mm.appbrand.commonjni.a.c.c;
import java.nio.ByteBuffer;

@Keep
public class AppBrandCommonBindingJni
{
  private static final String TAG = "MicroMsg.AppBrandRuntimeJni";
  private a.b mAppBrandDelegate;
  private long mNativeHandle;
  
  static
  {
    AppMethodBeat.i(201232);
    b.loadLibrary("wxa-runtime-binding");
    AppMethodBeat.o(201232);
  }
  
  public AppBrandCommonBindingJni(a.b paramb)
  {
    AppMethodBeat.i(201218);
    this.mNativeHandle = 0L;
    this.mAppBrandDelegate = new a.a();
    if (paramb != null)
    {
      this.mAppBrandDelegate = paramb;
      AppMethodBeat.o(201218);
      return;
    }
    c.c.w("MicroMsg.AppBrandRuntimeJni", "hy: not specify delegate, use default", new Object[0]);
    AppMethodBeat.o(201218);
  }
  
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
    AppMethodBeat.i(201230);
    boolean bool = this.mAppBrandDelegate.doInnerLoopTask();
    AppMethodBeat.o(201230);
    return bool;
  }
  
  @Keep
  protected String[] getAsyncableJsApis()
  {
    AppMethodBeat.i(201227);
    String[] arrayOfString = this.mAppBrandDelegate.getAsyncableJsApis();
    AppMethodBeat.o(201227);
    return arrayOfString;
  }
  
  @Keep
  protected String nativeInvokeHandler(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201226);
    paramString1 = this.mAppBrandDelegate.nativeInvokeHandler(paramString1, paramString2, paramInt, paramBoolean);
    AppMethodBeat.o(201226);
    return paramString1;
  }
  
  public void notifyCreate(AppBrandCommonBindingJniParams paramAppBrandCommonBindingJniParams)
  {
    AppMethodBeat.i(201219);
    this.mNativeHandle = nativeCreate(paramAppBrandCommonBindingJniParams);
    c.c.i("MicroMsg.AppBrandRuntimeJni", "hy: created with %d", new Object[] { Long.valueOf(this.mNativeHandle) });
    AppMethodBeat.o(201219);
  }
  
  public void notifyDestroy()
  {
    AppMethodBeat.i(201223);
    if (this.mNativeHandle > 0L)
    {
      nativeDestroy(this.mNativeHandle);
      this.mNativeHandle = 0L;
    }
    AppMethodBeat.o(201223);
  }
  
  public void notifyPause()
  {
    AppMethodBeat.i(201222);
    if (this.mNativeHandle > 0L) {
      nativePause(this.mNativeHandle);
    }
    AppMethodBeat.o(201222);
  }
  
  public void notifyResume()
  {
    AppMethodBeat.i(201221);
    if (this.mNativeHandle > 0L) {
      nativeResume(this.mNativeHandle);
    }
    AppMethodBeat.o(201221);
  }
  
  public void notifyRuntimeReady(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201220);
    if (this.mNativeHandle > 0L) {
      nativeRuntimeReady(this.mNativeHandle, paramString1, paramString2);
    }
    AppMethodBeat.o(201220);
  }
  
  public void notifySuspend()
  {
    AppMethodBeat.i(201224);
    if (this.mNativeHandle > 0L) {
      nativeSuspend(this.mNativeHandle);
    }
    AppMethodBeat.o(201224);
  }
  
  @Keep
  ByteBuffer readWeAppFile(String paramString)
  {
    AppMethodBeat.i(201228);
    paramString = this.mAppBrandDelegate.readWeAppFile(paramString);
    AppMethodBeat.o(201228);
    return paramString;
  }
  
  public void requestV8GarbageCollectionForTest()
  {
    AppMethodBeat.i(201225);
    if (this.mNativeHandle > 0L) {
      nativeRequestV8GarbageCollectionForTest(this.mNativeHandle);
    }
    AppMethodBeat.o(201225);
  }
  
  @Keep
  protected void resumeLoopTasks()
  {
    AppMethodBeat.i(201229);
    this.mAppBrandDelegate.resumeLoopTasks();
    AppMethodBeat.o(201229);
  }
  
  @Keep
  protected boolean syncInitModule(String paramString1, String paramString2)
  {
    AppMethodBeat.i(201231);
    c.c.i("MicroMsg.AppBrandRuntimeJni", "hy: request init %s with params %s", new Object[] { paramString1, paramString2 });
    boolean bool = this.mAppBrandDelegate.syncInitModule(paramString1, paramString2);
    AppMethodBeat.o(201231);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni
 * JD-Core Version:    0.7.0.1
 */