package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KScrollViewOnScrollCallback
{
  public abstract void onScroll(float paramFloat1, float paramFloat2);
  
  static final class CppProxy
    extends KScrollViewOnScrollCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(141381);
      if (!KScrollViewOnScrollCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(141381);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(141377);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(141377);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(141377);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onScroll(long paramLong, float paramFloat1, float paramFloat2);
    
    public final void destroy()
    {
      AppMethodBeat.i(141378);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(141378);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(141379);
      destroy();
      super.finalize();
      AppMethodBeat.o(141379);
    }
    
    public final void onScroll(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(141380);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141380);
        throw localAssertionError;
      }
      native_onScroll(this.nativeRef, paramFloat1, paramFloat2);
      AppMethodBeat.o(141380);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KScrollViewOnScrollCallback
 * JD-Core Version:    0.7.0.1
 */