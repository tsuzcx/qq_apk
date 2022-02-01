package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KEditTextOnTextChangedCallback
{
  public abstract void onTextChanged(String paramString);
  
  static final class CppProxy
    extends KEditTextOnTextChangedCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135832);
      if (!KEditTextOnTextChangedCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135832);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135828);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135828);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135828);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onTextChanged(long paramLong, String paramString);
    
    public final void destroy()
    {
      AppMethodBeat.i(135829);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135829);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135830);
      destroy();
      super.finalize();
      AppMethodBeat.o(135830);
    }
    
    public final void onTextChanged(String paramString)
    {
      AppMethodBeat.i(135831);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135831);
        throw paramString;
      }
      native_onTextChanged(this.nativeRef, paramString);
      AppMethodBeat.o(135831);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KEditTextOnTextChangedCallback
 * JD-Core Version:    0.7.0.1
 */