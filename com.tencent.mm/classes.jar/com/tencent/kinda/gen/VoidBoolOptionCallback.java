package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBoolOptionCallback
{
  public abstract void call(boolean paramBoolean, Option paramOption);
  
  static final class CppProxy
    extends VoidBoolOptionCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136028);
      if (!VoidBoolOptionCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136028);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136024);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136024);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136024);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, boolean paramBoolean, Option paramOption);
    
    public final void call(boolean paramBoolean, Option paramOption)
    {
      AppMethodBeat.i(136027);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramOption = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136027);
        throw paramOption;
      }
      native_call(this.nativeRef, paramBoolean, paramOption);
      AppMethodBeat.o(136027);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136025);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136025);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136026);
      destroy();
      super.finalize();
      AppMethodBeat.o(136026);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBoolOptionCallback
 * JD-Core Version:    0.7.0.1
 */