package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KViewOnTouchCallback
{
  public abstract void onTouch(TouchEvent paramTouchEvent);
  
  static final class CppProxy
    extends KViewOnTouchCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135941);
      if (!KViewOnTouchCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135941);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135937);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135937);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135937);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onTouch(long paramLong, TouchEvent paramTouchEvent);
    
    public final void destroy()
    {
      AppMethodBeat.i(135938);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135938);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135939);
      destroy();
      super.finalize();
      AppMethodBeat.o(135939);
    }
    
    public final void onTouch(TouchEvent paramTouchEvent)
    {
      AppMethodBeat.i(135940);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramTouchEvent = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135940);
        throw paramTouchEvent;
      }
      native_onTouch(this.nativeRef, paramTouchEvent);
      AppMethodBeat.o(135940);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KViewOnTouchCallback
 * JD-Core Version:    0.7.0.1
 */