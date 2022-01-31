package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KSecureEditTextOnTextChangedCallback$CppProxy
  extends KSecureEditTextOnTextChangedCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141386);
    if (!KSecureEditTextOnTextChangedCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141386);
      return;
    }
  }
  
  private KSecureEditTextOnTextChangedCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141382);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141382);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141382);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onTextChanged(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(141383);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141383);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141384);
    destroy();
    super.finalize();
    AppMethodBeat.o(141384);
  }
  
  public final void onTextChanged(String paramString)
  {
    AppMethodBeat.i(141385);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141385);
      throw paramString;
    }
    native_onTextChanged(this.nativeRef, paramString);
    AppMethodBeat.o(141385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.KSecureEditTextOnTextChangedCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */