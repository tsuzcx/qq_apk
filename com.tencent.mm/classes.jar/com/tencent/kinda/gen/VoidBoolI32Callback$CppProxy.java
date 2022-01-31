package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidBoolI32Callback$CppProxy
  extends VoidBoolI32Callback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141503);
    if (!VoidBoolI32Callback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141503);
      return;
    }
  }
  
  private VoidBoolI32Callback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141499);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141499);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141499);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong, boolean paramBoolean, int paramInt);
  
  public final void call(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(141502);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141502);
      throw localAssertionError;
    }
    native_call(this.nativeRef, paramBoolean, paramInt);
    AppMethodBeat.o(141502);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141500);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141500);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141501);
    destroy();
    super.finalize();
    AppMethodBeat.o(141501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolI32Callback.CppProxy
 * JD-Core Version:    0.7.0.1
 */