package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidITransmitKvDataCallback
{
  public abstract void call(ITransmitKvData paramITransmitKvData);
  
  static final class CppProxy
    extends VoidITransmitKvDataCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136048);
      if (!VoidITransmitKvDataCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136048);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136044);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136044);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136044);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, ITransmitKvData paramITransmitKvData);
    
    public final void call(ITransmitKvData paramITransmitKvData)
    {
      AppMethodBeat.i(136047);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramITransmitKvData = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136047);
        throw paramITransmitKvData;
      }
      native_call(this.nativeRef, paramITransmitKvData);
      AppMethodBeat.o(136047);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136045);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136045);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136046);
      destroy();
      super.finalize();
      AppMethodBeat.o(136046);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidITransmitKvDataCallback
 * JD-Core Version:    0.7.0.1
 */