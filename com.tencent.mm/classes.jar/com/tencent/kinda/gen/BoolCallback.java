package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BoolCallback
{
  public abstract boolean call();
  
  static final class CppProxy
    extends BoolCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135659);
      if (!BoolCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135659);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135655);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135655);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135655);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native boolean native_call(long paramLong);
    
    public final boolean call()
    {
      AppMethodBeat.i(135658);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135658);
        throw localAssertionError;
      }
      boolean bool = native_call(this.nativeRef);
      AppMethodBeat.o(135658);
      return bool;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(135656);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135656);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135657);
      destroy();
      super.finalize();
      AppMethodBeat.o(135657);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.BoolCallback
 * JD-Core Version:    0.7.0.1
 */