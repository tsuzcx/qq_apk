package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidKViewLayoutCallback
{
  public abstract void call(KViewLayout paramKViewLayout);
  
  static final class CppProxy
    extends VoidKViewLayoutCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136053);
      if (!VoidKViewLayoutCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136053);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136049);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136049);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136049);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, KViewLayout paramKViewLayout);
    
    public final void call(KViewLayout paramKViewLayout)
    {
      AppMethodBeat.i(136052);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKViewLayout = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136052);
        throw paramKViewLayout;
      }
      native_call(this.nativeRef, paramKViewLayout);
      AppMethodBeat.o(136052);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136050);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136050);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136051);
      destroy();
      super.finalize();
      AppMethodBeat.o(136051);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidKViewLayoutCallback
 * JD-Core Version:    0.7.0.1
 */