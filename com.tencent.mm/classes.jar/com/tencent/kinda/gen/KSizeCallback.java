package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KSizeCallback
{
  public abstract KSize call();
  
  static final class CppProxy
    extends KSizeCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(141392);
      if (!KSizeCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(141392);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(141388);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(141388);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(141388);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native KSize native_call(long paramLong);
    
    public final KSize call()
    {
      AppMethodBeat.i(141391);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141391);
        throw ((Throwable)localObject);
      }
      Object localObject = native_call(this.nativeRef);
      AppMethodBeat.o(141391);
      return localObject;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(141389);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(141389);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(141390);
      destroy();
      super.finalize();
      AppMethodBeat.o(141390);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.KSizeCallback
 * JD-Core Version:    0.7.0.1
 */