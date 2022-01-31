package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidStringCallback$CppProxy
  extends VoidStringCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141538);
    if (!VoidStringCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141538);
      return;
    }
  }
  
  private VoidStringCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141534);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141534);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141534);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong, String paramString);
  
  public final void call(String paramString)
  {
    AppMethodBeat.i(141537);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141537);
      throw paramString;
    }
    native_call(this.nativeRef, paramString);
    AppMethodBeat.o(141537);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141535);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141535);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141536);
    destroy();
    super.finalize();
    AppMethodBeat.o(141536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidStringCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */