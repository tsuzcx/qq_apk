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
      AppMethodBeat.i(226694);
      if (!VoidKRectCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(226694);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(226691);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(226691);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(226691);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, KRect paramKRect);
    
    public final void call(KRect paramKRect)
    {
      AppMethodBeat.i(226698);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKRect = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226698);
        throw paramKRect;
      }
      native_call(this.nativeRef, paramKRect);
      AppMethodBeat.o(226698);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(226695);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(226695);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(226697);
      destroy();
      super.finalize();
      AppMethodBeat.o(226697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidKRectCallback
 * JD-Core Version:    0.7.0.1
 */