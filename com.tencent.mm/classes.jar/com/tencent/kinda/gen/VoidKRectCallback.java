package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidKRectCallback
{
  public abstract void call(KRect paramKRect);
  
  static final class CppProxy
    extends VoidKRectCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(220437);
      if (!VoidKRectCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(220437);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(220427);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(220427);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(220427);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, KRect paramKRect);
    
    public final void call(KRect paramKRect)
    {
      AppMethodBeat.i(220435);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKRect = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(220435);
        throw paramKRect;
      }
      native_call(this.nativeRef, paramKRect);
      AppMethodBeat.o(220435);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(220429);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(220429);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(220431);
      destroy();
      super.finalize();
      AppMethodBeat.o(220431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidKRectCallback
 * JD-Core Version:    0.7.0.1
 */