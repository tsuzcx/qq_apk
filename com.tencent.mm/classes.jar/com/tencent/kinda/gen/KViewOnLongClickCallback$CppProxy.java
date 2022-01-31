package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KViewOnLongClickCallback$CppProxy
  extends KViewOnLongClickCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141417);
    if (!KViewOnLongClickCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141417);
      return;
    }
  }
  
  private KViewOnLongClickCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141413);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141413);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141413);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onLongClick(long paramLong, KView paramKView);
  
  public final void destroy()
  {
    AppMethodBeat.i(141414);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141414);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141415);
    destroy();
    super.finalize();
    AppMethodBeat.o(141415);
  }
  
  public final void onLongClick(KView paramKView)
  {
    AppMethodBeat.i(141416);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramKView = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141416);
      throw paramKView;
    }
    native_onLongClick(this.nativeRef, paramKView);
    AppMethodBeat.o(141416);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KViewOnLongClickCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */