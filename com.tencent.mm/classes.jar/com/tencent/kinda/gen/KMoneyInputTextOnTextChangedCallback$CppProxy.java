package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KMoneyInputTextOnTextChangedCallback$CppProxy
  extends KMoneyInputTextOnTextChangedCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141340);
    if (!KMoneyInputTextOnTextChangedCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141340);
      return;
    }
  }
  
  private KMoneyInputTextOnTextChangedCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141336);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141336);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141336);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onTextChanged(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(141337);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141337);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141338);
    destroy();
    super.finalize();
    AppMethodBeat.o(141338);
  }
  
  public final void onTextChanged(String paramString)
  {
    AppMethodBeat.i(141339);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141339);
      throw paramString;
    }
    native_onTextChanged(this.nativeRef, paramString);
    AppMethodBeat.o(141339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KMoneyInputTextOnTextChangedCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */