package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KPwdInputViewOnPasswordChangeCallback
{
  public abstract void onPasswordChange(int paramInt, String paramString1, String paramString2);
  
  static final class CppProxy
    extends KPwdInputViewOnPasswordChangeCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135881);
      if (!KPwdInputViewOnPasswordChangeCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135881);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135877);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135877);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135877);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onPasswordChange(long paramLong, int paramInt, String paramString1, String paramString2);
    
    public final void destroy()
    {
      AppMethodBeat.i(135878);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135878);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135879);
      destroy();
      super.finalize();
      AppMethodBeat.o(135879);
    }
    
    public final void onPasswordChange(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(135880);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135880);
        throw paramString1;
      }
      native_onPasswordChange(this.nativeRef, paramInt, paramString1, paramString2);
      AppMethodBeat.o(135880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KPwdInputViewOnPasswordChangeCallback
 * JD-Core Version:    0.7.0.1
 */