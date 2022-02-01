package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidI64Callback
{
  public abstract void call(long paramLong);
  
  static final class CppProxy
    extends VoidI64Callback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136043);
      if (!VoidI64Callback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136043);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136039);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136039);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136039);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong1, long paramLong2);
    
    public final void call(long paramLong)
    {
      AppMethodBeat.i(136042);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136042);
        throw localAssertionError;
      }
      native_call(this.nativeRef, paramLong);
      AppMethodBeat.o(136042);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136040);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136040);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136041);
      destroy();
      super.finalize();
      AppMethodBeat.o(136041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidI64Callback
 * JD-Core Version:    0.7.0.1
 */