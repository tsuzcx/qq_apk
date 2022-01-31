package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KPwdInputViewOnEndEnterPasswordCallback$CppProxy
  extends KPwdInputViewOnEndEnterPasswordCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141364);
    if (!KPwdInputViewOnEndEnterPasswordCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141364);
      return;
    }
  }
  
  private KPwdInputViewOnEndEnterPasswordCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141360);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141360);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141360);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onEndEnterPassword(long paramLong, String paramString1, String paramString2);
  
  public final void destroy()
  {
    AppMethodBeat.i(141361);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141361);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141362);
    destroy();
    super.finalize();
    AppMethodBeat.o(141362);
  }
  
  public final void onEndEnterPassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(141363);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString1 = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141363);
      throw paramString1;
    }
    native_onEndEnterPassword(this.nativeRef, paramString1, paramString2);
    AppMethodBeat.o(141363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KPwdInputViewOnEndEnterPasswordCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */