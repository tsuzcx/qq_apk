package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KMoneyInputTextOnTextChangedCallback
{
  public abstract void onTextChanged(String paramString);
  
  static final class CppProxy
    extends KMoneyInputTextOnTextChangedCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135852);
      if (!KMoneyInputTextOnTextChangedCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135852);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135848);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135848);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135848);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onTextChanged(long paramLong, String paramString);
    
    public final void destroy()
    {
      AppMethodBeat.i(135849);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135849);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135850);
      destroy();
      super.finalize();
      AppMethodBeat.o(135850);
    }
    
    public final void onTextChanged(String paramString)
    {
      AppMethodBeat.i(135851);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135851);
        throw paramString;
      }
      native_onTextChanged(this.nativeRef, paramString);
      AppMethodBeat.o(135851);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KMoneyInputTextOnTextChangedCallback
 * JD-Core Version:    0.7.0.1
 */