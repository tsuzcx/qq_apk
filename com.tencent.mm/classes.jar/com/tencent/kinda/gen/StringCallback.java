package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class StringCallback
{
  public abstract String call();
  
  static final class CppProxy
    extends StringCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135982);
      if (!StringCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135982);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135978);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135978);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135978);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native String native_call(long paramLong);
    
    public final String call()
    {
      AppMethodBeat.i(135981);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135981);
        throw ((Throwable)localObject);
      }
      Object localObject = native_call(this.nativeRef);
      AppMethodBeat.o(135981);
      return localObject;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(135979);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135979);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135980);
      destroy();
      super.finalize();
      AppMethodBeat.o(135980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.StringCallback
 * JD-Core Version:    0.7.0.1
 */