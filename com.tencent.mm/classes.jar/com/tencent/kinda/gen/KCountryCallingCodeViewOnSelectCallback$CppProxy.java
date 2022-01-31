package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KCountryCallingCodeViewOnSelectCallback$CppProxy
  extends KCountryCallingCodeViewOnSelectCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141305);
    if (!KCountryCallingCodeViewOnSelectCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141305);
      return;
    }
  }
  
  private KCountryCallingCodeViewOnSelectCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141301);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141301);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141301);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onSelect(long paramLong, String paramString1, String paramString2);
  
  public final void destroy()
  {
    AppMethodBeat.i(141302);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141302);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141303);
    destroy();
    super.finalize();
    AppMethodBeat.o(141303);
  }
  
  public final void onSelect(String paramString1, String paramString2)
  {
    AppMethodBeat.i(141304);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString1 = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141304);
      throw paramString1;
    }
    native_onSelect(this.nativeRef, paramString1, paramString2);
    AppMethodBeat.o(141304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KCountryCallingCodeViewOnSelectCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */