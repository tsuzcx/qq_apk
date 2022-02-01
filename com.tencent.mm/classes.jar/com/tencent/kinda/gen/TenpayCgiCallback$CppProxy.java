package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class TenpayCgiCallback$CppProxy
  extends TenpayCgiCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(135988);
    if (!TenpayCgiCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(135988);
      return;
    }
  }
  
  private TenpayCgiCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(135983);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(135983);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(135983);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onError(long paramLong, int paramInt, String paramString);
  
  private native void native_onSuccess(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(135984);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(135984);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(135985);
    destroy();
    super.finalize();
    AppMethodBeat.o(135985);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(135986);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135986);
      throw paramString;
    }
    native_onError(this.nativeRef, paramInt, paramString);
    AppMethodBeat.o(135986);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(135987);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(135987);
      throw paramString;
    }
    native_onSuccess(this.nativeRef, paramString);
    AppMethodBeat.o(135987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.TenpayCgiCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */