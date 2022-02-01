package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBoolStringCallback
{
  public abstract void call(boolean paramBoolean, String paramString);
  
  static final class CppProxy
    extends VoidBoolStringCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136033);
      if (!VoidBoolStringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136033);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136029);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136029);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136029);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, String paramString);
    
    public final void call(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(136032);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136032);
        throw paramString;
      }
      native_call(this.nativeRef, paramBoolean, paramString);
      AppMethodBeat.o(136032);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136030);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136030);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136031);
      destroy();
      super.finalize();
      AppMethodBeat.o(136031);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolStringCallback
 * JD-Core Version:    0.7.0.1
 */