package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidBoolCallback$CppProxy
  extends VoidBoolCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141498);
    if (!VoidBoolCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141498);
      return;
    }
  }
  
  private VoidBoolCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141494);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141494);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141494);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong, boolean paramBoolean);
  
  public final void call(boolean paramBoolean)
  {
    AppMethodBeat.i(141497);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141497);
      throw localAssertionError;
    }
    native_call(this.nativeRef, paramBoolean);
    AppMethodBeat.o(141497);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141495);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141495);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141496);
    destroy();
    super.finalize();
    AppMethodBeat.o(141496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */