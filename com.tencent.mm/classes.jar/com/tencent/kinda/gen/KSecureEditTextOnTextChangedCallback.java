package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KSecureEditTextOnTextChangedCallback
{
  public abstract void onTextChanged(String paramString);
  
  static final class CppProxy
    extends KSecureEditTextOnTextChangedCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135898);
      if (!KSecureEditTextOnTextChangedCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135898);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135894);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135894);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135894);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onTextChanged(long paramLong, String paramString);
    
    public final void destroy()
    {
      AppMethodBeat.i(135895);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135895);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135896);
      destroy();
      super.finalize();
      AppMethodBeat.o(135896);
    }
    
    public final void onTextChanged(String paramString)
    {
      AppMethodBeat.i(135897);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135897);
        throw paramString;
      }
      native_onTextChanged(this.nativeRef, paramString);
      AppMethodBeat.o(135897);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KSecureEditTextOnTextChangedCallback
 * JD-Core Version:    0.7.0.1
 */