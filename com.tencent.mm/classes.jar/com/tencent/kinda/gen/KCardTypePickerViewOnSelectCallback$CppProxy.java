package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KCardTypePickerViewOnSelectCallback$CppProxy
  extends KCardTypePickerViewOnSelectCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141282);
    if (!KCardTypePickerViewOnSelectCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141282);
      return;
    }
  }
  
  private KCardTypePickerViewOnSelectCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141278);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141278);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141278);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onSelect(long paramLong, int paramInt);
  
  public final void destroy()
  {
    AppMethodBeat.i(141279);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141279);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141280);
    destroy();
    super.finalize();
    AppMethodBeat.o(141280);
  }
  
  public final void onSelect(int paramInt)
  {
    AppMethodBeat.i(141281);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141281);
      throw localAssertionError;
    }
    native_onSelect(this.nativeRef, paramInt);
    AppMethodBeat.o(141281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KCardTypePickerViewOnSelectCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */