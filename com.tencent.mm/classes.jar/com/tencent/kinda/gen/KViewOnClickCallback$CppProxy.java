package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KViewOnClickCallback$CppProxy
  extends KViewOnClickCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141412);
    if (!KViewOnClickCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141412);
      return;
    }
  }
  
  private KViewOnClickCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141408);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141408);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141408);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onClick(long paramLong, KView paramKView);
  
  public final void destroy()
  {
    AppMethodBeat.i(141409);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141409);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141410);
    destroy();
    super.finalize();
    AppMethodBeat.o(141410);
  }
  
  public final void onClick(KView paramKView)
  {
    AppMethodBeat.i(141411);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramKView = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141411);
      throw paramKView;
    }
    native_onClick(this.nativeRef, paramKView);
    AppMethodBeat.o(141411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.gen.KViewOnClickCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */