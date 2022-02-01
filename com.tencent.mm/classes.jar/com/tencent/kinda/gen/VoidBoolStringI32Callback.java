package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBoolStringI32Callback
{
  public abstract void call(boolean paramBoolean, String paramString, int paramInt);
  
  static final class CppProxy
    extends VoidBoolStringI32Callback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(190587);
      if (!VoidBoolStringI32Callback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(190587);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(190583);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(190583);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(190583);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, String paramString, int paramInt);
    
    public final void call(boolean paramBoolean, String paramString, int paramInt)
    {
      AppMethodBeat.i(190586);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(190586);
        throw paramString;
      }
      native_call(this.nativeRef, paramBoolean, paramString, paramInt);
      AppMethodBeat.o(190586);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(190584);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(190584);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(190585);
      destroy();
      super.finalize();
      AppMethodBeat.o(190585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolStringI32Callback
 * JD-Core Version:    0.7.0.1
 */