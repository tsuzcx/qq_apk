package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidCallback
{
  public abstract void call();
  
  static final class CppProxy
    extends VoidCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136038);
      if (!VoidCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136038);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136034);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136034);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136034);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong);
    
    public final void call()
    {
      AppMethodBeat.i(136037);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136037);
        throw localAssertionError;
      }
      native_call(this.nativeRef);
      AppMethodBeat.o(136037);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136035);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136035);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136036);
      destroy();
      super.finalize();
      AppMethodBeat.o(136036);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidCallback
 * JD-Core Version:    0.7.0.1
 */