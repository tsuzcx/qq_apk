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
      AppMethodBeat.i(135893);
      if (!KScrollViewOnScrollCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135893);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135889);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135889);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135889);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onScroll(long paramLong, float paramFloat1, float paramFloat2);
    
    public final void destroy()
    {
      AppMethodBeat.i(135890);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135890);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135891);
      destroy();
      super.finalize();
      AppMethodBeat.o(135891);
    }
    
    public final void onScroll(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(135892);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135892);
        throw localAssertionError;
      }
      native_onScroll(this.nativeRef, paramFloat1, paramFloat2);
      AppMethodBeat.o(135892);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KScrollViewOnScrollCallback
 * JD-Core Version:    0.7.0.1
 */