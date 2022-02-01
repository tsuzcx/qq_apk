package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBoolCallback
{
  public abstract void call(boolean paramBoolean);
  
  static final class CppProxy
    extends VoidBoolCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136018);
      if (!VoidBoolCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136018);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136014);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136014);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136014);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean);
    
    public final void call(boolean paramBoolean)
    {
      AppMethodBeat.i(136017);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136017);
        throw localAssertionError;
      }
      native_call(this.nativeRef, paramBoolean);
      AppMethodBeat.o(136017);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136015);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136015);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136016);
      destroy();
      super.finalize();
      AppMethodBeat.o(136016);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolCallback
 * JD-Core Version:    0.7.0.1
 */