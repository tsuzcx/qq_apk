package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class BoolCallback$CppProxy
  extends BoolCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141165);
    if (!BoolCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141165);
      return;
    }
  }
  
  private BoolCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141161);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141161);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141161);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native boolean native_call(long paramLong);
  
  public final boolean call()
  {
    AppMethodBeat.i(141164);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141164);
      throw localAssertionError;
    }
    boolean bool = native_call(this.nativeRef);
    AppMethodBeat.o(141164);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141162);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141162);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141163);
    destroy();
    super.finalize();
    AppMethodBeat.o(141163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.BoolCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */