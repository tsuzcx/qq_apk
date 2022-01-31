package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KEditTextOnTextChangedCallback$CppProxy
  extends KEditTextOnTextChangedCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141320);
    if (!KEditTextOnTextChangedCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141320);
      return;
    }
  }
  
  private KEditTextOnTextChangedCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141316);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141316);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141316);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onTextChanged(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(141317);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141317);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141318);
    destroy();
    super.finalize();
    AppMethodBeat.o(141318);
  }
  
  public final void onTextChanged(String paramString)
  {
    AppMethodBeat.i(141319);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141319);
      throw paramString;
    }
    native_onTextChanged(this.nativeRef, paramString);
    AppMethodBeat.o(141319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KEditTextOnTextChangedCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */