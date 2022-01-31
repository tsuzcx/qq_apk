package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KBankEditViewOnSeletBankCallback$CppProxy
  extends KBankEditViewOnSeletBankCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141272);
    if (!KBankEditViewOnSeletBankCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141272);
      return;
    }
  }
  
  private KBankEditViewOnSeletBankCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141268);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141268);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141268);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onSeletBank(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(141269);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141269);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141270);
    destroy();
    super.finalize();
    AppMethodBeat.o(141270);
  }
  
  public final void onSeletBank(String paramString)
  {
    AppMethodBeat.i(141271);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141271);
      throw paramString;
    }
    native_onSeletBank(this.nativeRef, paramString);
    AppMethodBeat.o(141271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KBankEditViewOnSeletBankCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */