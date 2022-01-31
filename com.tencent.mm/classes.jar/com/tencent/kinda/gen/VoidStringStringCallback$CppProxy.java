package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidStringStringCallback$CppProxy
  extends VoidStringStringCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141543);
    if (!VoidStringStringCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141543);
      return;
    }
  }
  
  private VoidStringStringCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141539);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141539);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141539);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong, String paramString1, String paramString2);
  
  public final void call(String paramString1, String paramString2)
  {
    AppMethodBeat.i(141542);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString1 = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141542);
      throw paramString1;
    }
    native_call(this.nativeRef, paramString1, paramString2);
    AppMethodBeat.o(141542);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141540);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141540);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141541);
    destroy();
    super.finalize();
    AppMethodBeat.o(141541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidStringStringCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */