package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidBoolOptionCallback$CppProxy
  extends VoidBoolOptionCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141508);
    if (!VoidBoolOptionCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141508);
      return;
    }
  }
  
  private VoidBoolOptionCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141504);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141504);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141504);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong, boolean paramBoolean, Option paramOption);
  
  public final void call(boolean paramBoolean, Option paramOption)
  {
    AppMethodBeat.i(141507);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramOption = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141507);
      throw paramOption;
    }
    native_call(this.nativeRef, paramBoolean, paramOption);
    AppMethodBeat.o(141507);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141505);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141505);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141506);
    destroy();
    super.finalize();
    AppMethodBeat.o(141506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolOptionCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */