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
      AppMethodBeat.i(135904);
      if (!KSizeCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135904);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135900);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135900);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135900);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native KSize native_call(long paramLong);
    
    public final KSize call()
    {
      AppMethodBeat.i(135903);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135903);
        throw ((Throwable)localObject);
      }
      Object localObject = native_call(this.nativeRef);
      AppMethodBeat.o(135903);
      return localObject;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(135901);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135901);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135902);
      destroy();
      super.finalize();
      AppMethodBeat.o(135902);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KSizeCallback
 * JD-Core Version:    0.7.0.1
 */