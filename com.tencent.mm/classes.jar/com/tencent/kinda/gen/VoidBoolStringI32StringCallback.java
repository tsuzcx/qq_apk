package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBoolStringI32StringCallback
{
  public abstract void call(boolean paramBoolean, String paramString1, int paramInt, String paramString2);
  
  static final class CppProxy
    extends VoidBoolStringI32StringCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(221812);
      if (!VoidBoolStringI32StringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(221812);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(221808);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(221808);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(221808);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2);
    
    public final void call(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(221811);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(221811);
        throw paramString1;
      }
      native_call(this.nativeRef, paramBoolean, paramString1, paramInt, paramString2);
      AppMethodBeat.o(221811);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(221809);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(221809);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(221810);
      destroy();
      super.finalize();
      AppMethodBeat.o(221810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolStringI32StringCallback
 * JD-Core Version:    0.7.0.1
 */