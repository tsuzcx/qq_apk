package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBoolStringStringCallback
{
  public abstract void call(boolean paramBoolean, String paramString1, String paramString2);
  
  static final class CppProxy
    extends VoidBoolStringStringCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(192980);
      if (!VoidBoolStringStringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(192980);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(192976);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(192976);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(192976);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, String paramString1, String paramString2);
    
    public final void call(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(192979);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(192979);
        throw paramString1;
      }
      native_call(this.nativeRef, paramBoolean, paramString1, paramString2);
      AppMethodBeat.o(192979);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(192977);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(192977);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(192978);
      destroy();
      super.finalize();
      AppMethodBeat.o(192978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolStringStringCallback
 * JD-Core Version:    0.7.0.1
 */