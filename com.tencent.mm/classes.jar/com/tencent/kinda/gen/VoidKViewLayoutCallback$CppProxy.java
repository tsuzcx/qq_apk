package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidKViewLayoutCallback$CppProxy
  extends VoidKViewLayoutCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141533);
    if (!VoidKViewLayoutCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141533);
      return;
    }
  }
  
  private VoidKViewLayoutCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141529);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141529);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141529);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong, KViewLayout paramKViewLayout);
  
  public final void call(KViewLayout paramKViewLayout)
  {
    AppMethodBeat.i(141532);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramKViewLayout = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141532);
      throw paramKViewLayout;
    }
    native_call(this.nativeRef, paramKViewLayout);
    AppMethodBeat.o(141532);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141530);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141530);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141531);
    destroy();
    super.finalize();
    AppMethodBeat.o(141531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidKViewLayoutCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */