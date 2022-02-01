package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBoolStringI32StringCallback
{
  public abstract void call(boolean paramBoolean, String paramString1, int paramInt, String paramString2);
  
  static final class CppProxy
    extends VoidBoolStringI32StringCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(207080);
      if (!VoidBoolStringI32StringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(207080);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(207076);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(207076);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(207076);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2);
    
    public final void call(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(207079);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(207079);
        throw paramString1;
      }
      native_call(this.nativeRef, paramBoolean, paramString1, paramInt, paramString2);
      AppMethodBeat.o(207079);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(207077);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(207077);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(207078);
      destroy();
      super.finalize();
      AppMethodBeat.o(207078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolStringI32StringCallback
 * JD-Core Version:    0.7.0.1
 */