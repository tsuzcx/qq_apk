package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidITransmitKvDataCallback$CppProxy
  extends VoidITransmitKvDataCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141528);
    if (!VoidITransmitKvDataCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141528);
      return;
    }
  }
  
  private VoidITransmitKvDataCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141524);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141524);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141524);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong, ITransmitKvData paramITransmitKvData);
  
  public final void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(141527);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramITransmitKvData = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141527);
      throw paramITransmitKvData;
    }
    native_call(this.nativeRef, paramITransmitKvData);
    AppMethodBeat.o(141527);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141525);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141525);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141526);
    destroy();
    super.finalize();
    AppMethodBeat.o(141526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidITransmitKvDataCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */