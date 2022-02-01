package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KCgi$CppProxy
  extends KCgi
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(135807);
    if (!KCgi.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(135807);
      return;
    }
  }
  
  private KCgi$CppProxy(long paramLong)
  {
    AppMethodBeat.i(135795);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(135795);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(135795);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native int native_getCgiId(long paramLong);
  
  private native String native_getCgiUrl(long paramLong);
  
  private native int native_getChannelType(long paramLong);
  
  private native boolean native_getNeedNotify(long paramLong);
  
  private native byte[] native_getRequestData(long paramLong);
  
  private native int native_getRetryCount(long paramLong);
  
  private native String native_getRouteInfo(long paramLong);
  
  private native int native_getTimeout(long paramLong);
  
  private native void native_onResp(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  public final void destroy()
  {
    AppMethodBeat.i(135796);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(135796);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(135797);
    destroy();
    super.finalize();
    AppMethodBeat.o(135797);
  }
  
  public final int getCgiId()
  {
    AppMethodBeat.i(135798);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135798);
      throw localAssertionError;
    }
    int i = native_getCgiId(this.nativeRef);
    AppMethodBeat.o(135798);
    return i;
  }
  
  public final String getCgiUrl()
  {
    AppMethodBeat.i(135799);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      localObject = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135799);
      throw ((Throwable)localObject);
    }
    Object localObject = native_getCgiUrl(this.nativeRef);
    AppMethodBeat.o(135799);
    return localObject;
  }
  
  public final int getChannelType()
  {
    AppMethodBeat.i(135800);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135800);
      throw localAssertionError;
    }
    int i = native_getChannelType(this.nativeRef);
    AppMethodBeat.o(135800);
    return i;
  }
  
  public final boolean getNeedNotify()
  {
    AppMethodBeat.i(135804);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135804);
      throw localAssertionError;
    }
    boolean bool = native_getNeedNotify(this.nativeRef);
    AppMethodBeat.o(135804);
    return bool;
  }
  
  public final byte[] getRequestData()
  {
    AppMethodBeat.i(135803);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      localObject = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135803);
      throw ((Throwable)localObject);
    }
    Object localObject = native_getRequestData(this.nativeRef);
    AppMethodBeat.o(135803);
    return localObject;
  }
  
  public final int getRetryCount()
  {
    AppMethodBeat.i(135802);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135802);
      throw localAssertionError;
    }
    int i = native_getRetryCount(this.nativeRef);
    AppMethodBeat.o(135802);
    return i;
  }
  
  public final String getRouteInfo()
  {
    AppMethodBeat.i(135805);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      localObject = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135805);
      throw ((Throwable)localObject);
    }
    Object localObject = native_getRouteInfo(this.nativeRef);
    AppMethodBeat.o(135805);
    return localObject;
  }
  
  public final int getTimeout()
  {
    AppMethodBeat.i(135801);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135801);
      throw localAssertionError;
    }
    int i = native_getTimeout(this.nativeRef);
    AppMethodBeat.o(135801);
    return i;
  }
  
  public final void onResp(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135806);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramArrayOfByte = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135806);
      throw paramArrayOfByte;
    }
    native_onResp(this.nativeRef, paramInt, paramArrayOfByte);
    AppMethodBeat.o(135806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KCgi.CppProxy
 * JD-Core Version:    0.7.0.1
 */