package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidCallback$CppProxy
  extends VoidCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141518);
    if (!VoidCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141518);
      return;
    }
  }
  
  private VoidCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141514);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141514);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141514);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong);
  
  public final void call()
  {
    AppMethodBeat.i(141517);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141517);
      throw localAssertionError;
    }
    native_call(this.nativeRef);
    AppMethodBeat.o(141517);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141515);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141515);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141516);
    destroy();
    super.finalize();
    AppMethodBeat.o(141516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */