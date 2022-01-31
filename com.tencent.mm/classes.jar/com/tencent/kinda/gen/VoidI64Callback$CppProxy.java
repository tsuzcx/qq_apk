package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidI64Callback$CppProxy
  extends VoidI64Callback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141523);
    if (!VoidI64Callback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141523);
      return;
    }
  }
  
  private VoidI64Callback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141519);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141519);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141519);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong1, long paramLong2);
  
  public final void call(long paramLong)
  {
    AppMethodBeat.i(141522);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141522);
      throw localAssertionError;
    }
    native_call(this.nativeRef, paramLong);
    AppMethodBeat.o(141522);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141520);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141520);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141521);
    destroy();
    super.finalize();
    AppMethodBeat.o(141521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidI64Callback.CppProxy
 * JD-Core Version:    0.7.0.1
 */