package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBoolI32Callback
{
  public abstract void call(boolean paramBoolean, int paramInt);
  
  static final class CppProxy
    extends VoidBoolI32Callback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136023);
      if (!VoidBoolI32Callback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136023);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136019);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136019);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136019);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, int paramInt);
    
    public final void call(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(136022);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136022);
        throw localAssertionError;
      }
      native_call(this.nativeRef, paramBoolean, paramInt);
      AppMethodBeat.o(136022);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136020);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136020);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136021);
      destroy();
      super.finalize();
      AppMethodBeat.o(136021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolI32Callback
 * JD-Core Version:    0.7.0.1
 */