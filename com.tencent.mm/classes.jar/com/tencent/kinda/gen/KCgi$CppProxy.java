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
    AppMethodBeat.i(141295);
    if (!KCgi.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141295);
      return;
    }
  }
  
  private KCgi$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141283);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141283);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141283);
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
    AppMethodBeat.i(141284);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141284);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141285);
    destroy();
    super.finalize();
    AppMethodBeat.o(141285);
  }
  
  public final int getCgiId()
  {
    AppMethodBeat.i(141286);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141286);
      throw localAssertionError;
    }
    int i = native_getCgiId(this.nativeRef);
    AppMethodBeat.o(141286);
    return i;
  }
  
  public final String getCgiUrl()
  {
    AppMethodBeat.i(141287);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      localObject = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141287);
      throw ((Throwable)localObject);
    }
    Object localObject = native_getCgiUrl(this.nativeRef);
    AppMethodBeat.o(141287);
    return localObject;
  }
  
  public final int getChannelType()
  {
    AppMethodBeat.i(141288);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141288);
      throw localAssertionError;
    }
    int i = native_getChannelType(this.nativeRef);
    AppMethodBeat.o(141288);
    return i;
  }
  
  public final boolean getNeedNotify()
  {
    AppMethodBeat.i(141292);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141292);
      throw localAssertionError;
    }
    boolean bool = native_getNeedNotify(this.nativeRef);
    AppMethodBeat.o(141292);
    return bool;
  }
  
  public final byte[] getRequestData()
  {
    AppMethodBeat.i(141291);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      localObject = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141291);
      throw ((Throwable)localObject);
    }
    Object localObject = native_getRequestData(this.nativeRef);
    AppMethodBeat.o(141291);
    return localObject;
  }
  
  public final int getRetryCount()
  {
    AppMethodBeat.i(141290);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141290);
      throw localAssertionError;
    }
    int i = native_getRetryCount(this.nativeRef);
    AppMethodBeat.o(141290);
    return i;
  }
  
  public final String getRouteInfo()
  {
    AppMethodBeat.i(141293);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      localObject = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141293);
      throw ((Throwable)localObject);
    }
    Object localObject = native_getRouteInfo(this.nativeRef);
    AppMethodBeat.o(141293);
    return localObject;
  }
  
  public final int getTimeout()
  {
    AppMethodBeat.i(141289);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141289);
      throw localAssertionError;
    }
    int i = native_getTimeout(this.nativeRef);
    AppMethodBeat.o(141289);
    return i;
  }
  
  public final void onResp(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(141294);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramArrayOfByte = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141294);
      throw paramArrayOfByte;
    }
    native_onResp(this.nativeRef, paramInt, paramArrayOfByte);
    AppMethodBeat.o(141294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KCgi.CppProxy
 * JD-Core Version:    0.7.0.1
 */