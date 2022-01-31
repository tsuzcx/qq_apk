package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KViewOnTouchCallback$CppProxy
  extends KViewOnTouchCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141422);
    if (!KViewOnTouchCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141422);
      return;
    }
  }
  
  private KViewOnTouchCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141418);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141418);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141418);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onTouch(long paramLong, TouchEvent paramTouchEvent);
  
  public final void destroy()
  {
    AppMethodBeat.i(141419);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141419);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141420);
    destroy();
    super.finalize();
    AppMethodBeat.o(141420);
  }
  
  public final void onTouch(TouchEvent paramTouchEvent)
  {
    AppMethodBeat.i(141421);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramTouchEvent = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141421);
      throw paramTouchEvent;
    }
    native_onTouch(this.nativeRef, paramTouchEvent);
    AppMethodBeat.o(141421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KViewOnTouchCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */