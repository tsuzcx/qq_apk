package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KViewLayoutCallback
{
  public abstract KViewLayout call();
  
  static final class CppProxy
    extends KViewLayoutCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135926);
      if (!KViewLayoutCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135926);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135922);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135922);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135922);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native KViewLayout native_call(long paramLong);
    
    public final KViewLayout call()
    {
      AppMethodBeat.i(135925);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135925);
        throw ((Throwable)localObject);
      }
      Object localObject = native_call(this.nativeRef);
      AppMethodBeat.o(135925);
      return localObject;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(135923);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135923);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135924);
      destroy();
      super.finalize();
      AppMethodBeat.o(135924);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KViewLayoutCallback
 * JD-Core Version:    0.7.0.1
 */