package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KSwitchViewOnChangeSwitchCallback$CppProxy
  extends KSwitchViewOnChangeSwitchCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141397);
    if (!KSwitchViewOnChangeSwitchCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141397);
      return;
    }
  }
  
  private KSwitchViewOnChangeSwitchCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141393);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141393);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141393);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onChangeSwitch(long paramLong);
  
  public final void destroy()
  {
    AppMethodBeat.i(141394);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141394);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141395);
    destroy();
    super.finalize();
    AppMethodBeat.o(141395);
  }
  
  public final void onChangeSwitch()
  {
    AppMethodBeat.i(141396);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141396);
      throw localAssertionError;
    }
    native_onChangeSwitch(this.nativeRef);
    AppMethodBeat.o(141396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.KSwitchViewOnChangeSwitchCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */