package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBoolStringStringCallback
{
  public abstract void call(boolean paramBoolean, String paramString1, String paramString2);
  
  static final class CppProxy
    extends VoidBoolStringStringCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(220390);
      if (!VoidBoolStringStringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(220390);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(220380);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(220380);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(220380);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, String paramString1, String paramString2);
    
    public final void call(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(220388);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(220388);
        throw paramString1;
      }
      native_call(this.nativeRef, paramBoolean, paramString1, paramString2);
      AppMethodBeat.o(220388);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(220383);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(220383);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(220386);
      destroy();
      super.finalize();
      AppMethodBeat.o(220386);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolStringStringCallback
 * JD-Core Version:    0.7.0.1
 */