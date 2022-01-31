package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KMoneyInputTextOnkeyBoardVisibleAnchorCallback$CppProxy
  extends KMoneyInputTextOnkeyBoardVisibleAnchorCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141345);
    if (!KMoneyInputTextOnkeyBoardVisibleAnchorCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141345);
      return;
    }
  }
  
  private KMoneyInputTextOnkeyBoardVisibleAnchorCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141341);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141341);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141341);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native KView native_onkeyBoardVisibleAnchor(long paramLong);
  
  public final void destroy()
  {
    AppMethodBeat.i(141342);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141342);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141343);
    destroy();
    super.finalize();
    AppMethodBeat.o(141343);
  }
  
  public final KView onkeyBoardVisibleAnchor()
  {
    AppMethodBeat.i(141344);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      localObject = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141344);
      throw ((Throwable)localObject);
    }
    Object localObject = native_onkeyBoardVisibleAnchor(this.nativeRef);
    AppMethodBeat.o(141344);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KMoneyInputTextOnkeyBoardVisibleAnchorCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */