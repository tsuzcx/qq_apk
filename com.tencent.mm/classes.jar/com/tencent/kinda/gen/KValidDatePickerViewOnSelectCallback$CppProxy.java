package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KValidDatePickerViewOnSelectCallback$CppProxy
  extends KValidDatePickerViewOnSelectCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141402);
    if (!KValidDatePickerViewOnSelectCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141402);
      return;
    }
  }
  
  private KValidDatePickerViewOnSelectCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141398);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141398);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141398);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onSelect(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(141399);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141399);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141400);
    destroy();
    super.finalize();
    AppMethodBeat.o(141400);
  }
  
  public final void onSelect(String paramString)
  {
    AppMethodBeat.i(141401);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141401);
      throw paramString;
    }
    native_onSelect(this.nativeRef, paramString);
    AppMethodBeat.o(141401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KValidDatePickerViewOnSelectCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */