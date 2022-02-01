package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidStringCallback
{
  public abstract void call(String paramString);
  
  static final class CppProxy
    extends VoidStringCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136058);
      if (!VoidStringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136058);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136054);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136054);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136054);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, String paramString);
    
    public final void call(String paramString)
    {
      AppMethodBeat.i(136057);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136057);
        throw paramString;
      }
      native_call(this.nativeRef, paramString);
      AppMethodBeat.o(136057);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136055);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136055);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136056);
      destroy();
      super.finalize();
      AppMethodBeat.o(136056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidStringCallback
 * JD-Core Version:    0.7.0.1
 */