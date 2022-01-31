package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KProfessionEditViewOnSelectProfessionCallback$CppProxy
  extends KProfessionEditViewOnSelectProfessionCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141359);
    if (!KProfessionEditViewOnSelectProfessionCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141359);
      return;
    }
  }
  
  private KProfessionEditViewOnSelectProfessionCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141355);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141355);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141355);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onSelectProfession(long paramLong, String paramString, int paramInt);
  
  public final void destroy()
  {
    AppMethodBeat.i(141356);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141356);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141357);
    destroy();
    super.finalize();
    AppMethodBeat.o(141357);
  }
  
  public final void onSelectProfession(String paramString, int paramInt)
  {
    AppMethodBeat.i(141358);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141358);
      throw paramString;
    }
    native_onSelectProfession(this.nativeRef, paramString, paramInt);
    AppMethodBeat.o(141358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.gen.KProfessionEditViewOnSelectProfessionCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */