package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KListViewOnScrollCallback
{
  public abstract void onScroll(float paramFloat1, float paramFloat2);
  
  static final class CppProxy
    extends KListViewOnScrollCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135847);
      if (!KListViewOnScrollCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135847);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135843);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135843);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135843);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onScroll(long paramLong, float paramFloat1, float paramFloat2);
    
    public final void destroy()
    {
      AppMethodBeat.i(135844);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135844);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135845);
      destroy();
      super.finalize();
      AppMethodBeat.o(135845);
    }
    
    public final void onScroll(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(135846);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135846);
        throw localAssertionError;
      }
      native_onScroll(this.nativeRef, paramFloat1, paramFloat2);
      AppMethodBeat.o(135846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KListViewOnScrollCallback
 * JD-Core Version:    0.7.0.1
 */