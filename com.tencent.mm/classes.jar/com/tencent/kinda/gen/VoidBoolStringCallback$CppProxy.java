package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidBoolStringCallback$CppProxy
  extends VoidBoolStringCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141513);
    if (!VoidBoolStringCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141513);
      return;
    }
  }
  
  private VoidBoolStringCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141509);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141509);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141509);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong, boolean paramBoolean, String paramString);
  
  public final void call(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(141512);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141512);
      throw paramString;
    }
    native_call(this.nativeRef, paramBoolean, paramString);
    AppMethodBeat.o(141512);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141510);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141510);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141511);
    destroy();
    super.finalize();
    AppMethodBeat.o(141511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolStringCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */