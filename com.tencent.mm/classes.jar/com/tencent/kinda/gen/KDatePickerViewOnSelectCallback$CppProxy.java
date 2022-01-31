package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KDatePickerViewOnSelectCallback$CppProxy
  extends KDatePickerViewOnSelectCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141310);
    if (!KDatePickerViewOnSelectCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141310);
      return;
    }
  }
  
  private KDatePickerViewOnSelectCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141306);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141306);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141306);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onSelect(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(141307);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141307);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141308);
    destroy();
    super.finalize();
    AppMethodBeat.o(141308);
  }
  
  public final void onSelect(String paramString)
  {
    AppMethodBeat.i(141309);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141309);
      throw paramString;
    }
    native_onSelect(this.nativeRef, paramString);
    AppMethodBeat.o(141309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KDatePickerViewOnSelectCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */