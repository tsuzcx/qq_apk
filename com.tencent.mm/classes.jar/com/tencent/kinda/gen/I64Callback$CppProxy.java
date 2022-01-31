package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class I64Callback$CppProxy
  extends I64Callback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141185);
    if (!I64Callback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141185);
      return;
    }
  }
  
  private I64Callback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141181);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141181);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141181);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native long native_call(long paramLong);
  
  public final long call()
  {
    AppMethodBeat.i(141184);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141184);
      throw localAssertionError;
    }
    long l = native_call(this.nativeRef);
    AppMethodBeat.o(141184);
    return l;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141182);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141182);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141183);
    destroy();
    super.finalize();
    AppMethodBeat.o(141183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.I64Callback.CppProxy
 * JD-Core Version:    0.7.0.1
 */