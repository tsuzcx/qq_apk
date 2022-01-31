package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KCardNumberEditViewOnTextChangedCallback$CppProxy
  extends KCardNumberEditViewOnTextChangedCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141277);
    if (!KCardNumberEditViewOnTextChangedCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141277);
      return;
    }
  }
  
  private KCardNumberEditViewOnTextChangedCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141273);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141273);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141273);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onTextChanged(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(141274);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141274);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141275);
    destroy();
    super.finalize();
    AppMethodBeat.o(141275);
  }
  
  public final void onTextChanged(String paramString)
  {
    AppMethodBeat.i(141276);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141276);
      throw paramString;
    }
    native_onTextChanged(this.nativeRef, paramString);
    AppMethodBeat.o(141276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KCardNumberEditViewOnTextChangedCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */