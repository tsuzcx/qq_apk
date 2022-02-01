package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IAsyncTask
{
  public abstract void execute();
  
  static final class CppProxy
    extends IAsyncTask
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135705);
      if (!IAsyncTask.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135705);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135701);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135701);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135701);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_execute(long paramLong);
    
    public final void destroy()
    {
      AppMethodBeat.i(135702);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135702);
    }
    
    public final void execute()
    {
      AppMethodBeat.i(135704);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135704);
        throw localAssertionError;
      }
      native_execute(this.nativeRef);
      AppMethodBeat.o(135704);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135703);
      destroy();
      super.finalize();
      AppMethodBeat.o(135703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.IAsyncTask
 * JD-Core Version:    0.7.0.1
 */