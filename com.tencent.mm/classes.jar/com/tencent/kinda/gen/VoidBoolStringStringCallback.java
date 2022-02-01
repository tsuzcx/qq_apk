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
      AppMethodBeat.i(226744);
      if (!VoidBoolStringStringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(226744);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(226742);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(226742);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(226742);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, String paramString1, String paramString2);
    
    public final void call(boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(226750);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226750);
        throw paramString1;
      }
      native_call(this.nativeRef, paramBoolean, paramString1, paramString2);
      AppMethodBeat.o(226750);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(226746);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(226746);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(226748);
      destroy();
      super.finalize();
      AppMethodBeat.o(226748);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolStringStringCallback
 * JD-Core Version:    0.7.0.1
 */