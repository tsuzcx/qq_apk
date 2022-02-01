package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class UseCase
{
  public abstract void notify(ITransmitKvData paramITransmitKvData);
  
  public abstract void preStepDidDestory();
  
  static final class CppProxy
    extends UseCase
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136005);
      if (!UseCase.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136005);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136000);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136000);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136000);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_notify(long paramLong, ITransmitKvData paramITransmitKvData);
    
    private native void native_preStepDidDestory(long paramLong);
    
    public final void destroy()
    {
      AppMethodBeat.i(136001);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136001);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136002);
      destroy();
      super.finalize();
      AppMethodBeat.o(136002);
    }
    
    public final void notify(ITransmitKvData paramITransmitKvData)
    {
      AppMethodBeat.i(136003);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramITransmitKvData = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136003);
        throw paramITransmitKvData;
      }
      native_notify(this.nativeRef, paramITransmitKvData);
      AppMethodBeat.o(136003);
    }
    
    public final void preStepDidDestory()
    {
      AppMethodBeat.i(136004);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136004);
        throw localAssertionError;
      }
      native_preStepDidDestory(this.nativeRef);
      AppMethodBeat.o(136004);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.UseCase
 * JD-Core Version:    0.7.0.1
 */