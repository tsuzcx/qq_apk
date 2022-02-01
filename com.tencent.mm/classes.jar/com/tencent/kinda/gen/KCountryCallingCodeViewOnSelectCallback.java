package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KCountryCallingCodeViewOnSelectCallback
{
  public abstract void onSelect(String paramString1, String paramString2);
  
  static final class CppProxy
    extends KCountryCallingCodeViewOnSelectCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135817);
      if (!KCountryCallingCodeViewOnSelectCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135817);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135813);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135813);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135813);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onSelect(long paramLong, String paramString1, String paramString2);
    
    public final void destroy()
    {
      AppMethodBeat.i(135814);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135814);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135815);
      destroy();
      super.finalize();
      AppMethodBeat.o(135815);
    }
    
    public final void onSelect(String paramString1, String paramString2)
    {
      AppMethodBeat.i(135816);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135816);
        throw paramString1;
      }
      native_onSelect(this.nativeRef, paramString1, paramString2);
      AppMethodBeat.o(135816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KCountryCallingCodeViewOnSelectCallback
 * JD-Core Version:    0.7.0.1
 */