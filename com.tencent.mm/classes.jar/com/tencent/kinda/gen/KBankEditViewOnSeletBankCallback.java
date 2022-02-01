package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KBankEditViewOnSeletBankCallback
{
  public abstract void onSeletBank(String paramString);
  
  static final class CppProxy
    extends KBankEditViewOnSeletBankCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135784);
      if (!KBankEditViewOnSeletBankCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135784);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135780);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135780);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135780);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onSeletBank(long paramLong, String paramString);
    
    public final void destroy()
    {
      AppMethodBeat.i(135781);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135781);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135782);
      destroy();
      super.finalize();
      AppMethodBeat.o(135782);
    }
    
    public final void onSeletBank(String paramString)
    {
      AppMethodBeat.i(135783);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135783);
        throw paramString;
      }
      native_onSeletBank(this.nativeRef, paramString);
      AppMethodBeat.o(135783);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KBankEditViewOnSeletBankCallback
 * JD-Core Version:    0.7.0.1
 */