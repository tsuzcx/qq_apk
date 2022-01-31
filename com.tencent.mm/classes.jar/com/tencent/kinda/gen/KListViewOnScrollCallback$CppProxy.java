package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KListViewOnScrollCallback$CppProxy
  extends KListViewOnScrollCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141335);
    if (!KListViewOnScrollCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141335);
      return;
    }
  }
  
  private KListViewOnScrollCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141331);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141331);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141331);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onScroll(long paramLong, float paramFloat1, float paramFloat2);
  
  public final void destroy()
  {
    AppMethodBeat.i(141332);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141332);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141333);
    destroy();
    super.finalize();
    AppMethodBeat.o(141333);
  }
  
  public final void onScroll(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(141334);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141334);
      throw localAssertionError;
    }
    native_onScroll(this.nativeRef, paramFloat1, paramFloat2);
    AppMethodBeat.o(141334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KListViewOnScrollCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */