package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class I64Callback
{
  public abstract long call();
  
  static final class CppProxy
    extends I64Callback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135680);
      if (!I64Callback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135680);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135676);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135676);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135676);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native long native_call(long paramLong);
    
    public final long call()
    {
      AppMethodBeat.i(135679);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135679);
        throw localAssertionError;
      }
      long l = native_call(this.nativeRef);
      AppMethodBeat.o(135679);
      return l;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(135677);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135677);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135678);
      destroy();
      super.finalize();
      AppMethodBeat.o(135678);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.I64Callback
 * JD-Core Version:    0.7.0.1
 */