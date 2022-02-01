package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KPwdInputViewOnEndEnterPasswordCallback
{
  public abstract void onEndEnterPassword(String paramString1, String paramString2);
  
  static final class CppProxy
    extends KPwdInputViewOnEndEnterPasswordCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135876);
      if (!KPwdInputViewOnEndEnterPasswordCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135876);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135872);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135872);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135872);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onEndEnterPassword(long paramLong, String paramString1, String paramString2);
    
    public final void destroy()
    {
      AppMethodBeat.i(135873);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135873);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135874);
      destroy();
      super.finalize();
      AppMethodBeat.o(135874);
    }
    
    public final void onEndEnterPassword(String paramString1, String paramString2)
    {
      AppMethodBeat.i(135875);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135875);
        throw paramString1;
      }
      native_onEndEnterPassword(this.nativeRef, paramString1, paramString2);
      AppMethodBeat.o(135875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KPwdInputViewOnEndEnterPasswordCallback
 * JD-Core Version:    0.7.0.1
 */