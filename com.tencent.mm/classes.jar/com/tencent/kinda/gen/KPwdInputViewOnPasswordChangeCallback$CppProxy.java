package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KPwdInputViewOnPasswordChangeCallback$CppProxy
  extends KPwdInputViewOnPasswordChangeCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141369);
    if (!KPwdInputViewOnPasswordChangeCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141369);
      return;
    }
  }
  
  private KPwdInputViewOnPasswordChangeCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141365);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141365);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141365);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onPasswordChange(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public final void destroy()
  {
    AppMethodBeat.i(141366);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141366);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141367);
    destroy();
    super.finalize();
    AppMethodBeat.o(141367);
  }
  
  public final void onPasswordChange(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(141368);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString1 = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141368);
      throw paramString1;
    }
    native_onPasswordChange(this.nativeRef, paramInt, paramString1, paramString2);
    AppMethodBeat.o(141368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.KPwdInputViewOnPasswordChangeCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */