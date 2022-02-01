package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidStringStringCallback
{
  public abstract void call(String paramString1, String paramString2);
  
  static final class CppProxy
    extends VoidStringStringCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136068);
      if (!VoidStringStringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136068);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136064);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136064);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136064);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, String paramString1, String paramString2);
    
    public final void call(String paramString1, String paramString2)
    {
      AppMethodBeat.i(136067);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136067);
        throw paramString1;
      }
      native_call(this.nativeRef, paramString1, paramString2);
      AppMethodBeat.o(136067);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136065);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136065);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136066);
      destroy();
      super.finalize();
      AppMethodBeat.o(136066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidStringStringCallback
 * JD-Core Version:    0.7.0.1
 */