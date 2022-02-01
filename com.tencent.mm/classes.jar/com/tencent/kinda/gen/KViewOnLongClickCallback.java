package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KViewOnLongClickCallback
{
  public abstract void onLongClick(KView paramKView);
  
  static final class CppProxy
    extends KViewOnLongClickCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135936);
      if (!KViewOnLongClickCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135936);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135932);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135932);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135932);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onLongClick(long paramLong, KView paramKView);
    
    public final void destroy()
    {
      AppMethodBeat.i(135933);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135933);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135934);
      destroy();
      super.finalize();
      AppMethodBeat.o(135934);
    }
    
    public final void onLongClick(KView paramKView)
    {
      AppMethodBeat.i(135935);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKView = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135935);
        throw paramKView;
      }
      native_onLongClick(this.nativeRef, paramKView);
      AppMethodBeat.o(135935);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KViewOnLongClickCallback
 * JD-Core Version:    0.7.0.1
 */