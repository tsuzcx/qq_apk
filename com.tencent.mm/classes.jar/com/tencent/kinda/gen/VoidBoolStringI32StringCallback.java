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
      AppMethodBeat.i(190338);
      if (!VoidBoolStringI32StringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(190338);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(190334);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(190334);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(190334);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2);
    
    public final void call(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
    {
      AppMethodBeat.i(190337);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(190337);
        throw paramString1;
      }
      native_call(this.nativeRef, paramBoolean, paramString1, paramInt, paramString2);
      AppMethodBeat.o(190337);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(190335);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(190335);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(190336);
      destroy();
      super.finalize();
      AppMethodBeat.o(190336);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolStringI32StringCallback
 * JD-Core Version:    0.7.0.1
 */