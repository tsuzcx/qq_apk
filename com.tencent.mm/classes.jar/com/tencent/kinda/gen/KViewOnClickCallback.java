package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KViewOnClickCallback
{
  public abstract void onClick(KView paramKView);
  
  static final class CppProxy
    extends KViewOnClickCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135931);
      if (!KViewOnClickCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135931);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135927);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135927);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135927);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onClick(long paramLong, KView paramKView);
    
    public final void destroy()
    {
      AppMethodBeat.i(135928);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135928);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135929);
      destroy();
      super.finalize();
      AppMethodBeat.o(135929);
    }
    
    public final void onClick(KView paramKView)
    {
      AppMethodBeat.i(135930);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKView = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135930);
        throw paramKView;
      }
      native_onClick(this.nativeRef, paramKView);
      AppMethodBeat.o(135930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KViewOnClickCallback
 * JD-Core Version:    0.7.0.1
 */