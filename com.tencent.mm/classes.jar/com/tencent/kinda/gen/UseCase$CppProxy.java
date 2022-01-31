package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class UseCase$CppProxy
  extends UseCase
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141485);
    if (!UseCase.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141485);
      return;
    }
  }
  
  private UseCase$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141480);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141480);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141480);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_notify(long paramLong, ITransmitKvData paramITransmitKvData);
  
  private native void native_preStepDidDestory(long paramLong);
  
  public final void destroy()
  {
    AppMethodBeat.i(141481);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141481);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141482);
    destroy();
    super.finalize();
    AppMethodBeat.o(141482);
  }
  
  public final void notify(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(141483);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramITransmitKvData = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141483);
      throw paramITransmitKvData;
    }
    native_notify(this.nativeRef, paramITransmitKvData);
    AppMethodBeat.o(141483);
  }
  
  public final void preStepDidDestory()
  {
    AppMethodBeat.i(141484);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141484);
      throw localAssertionError;
    }
    native_preStepDidDestory(this.nativeRef);
    AppMethodBeat.o(141484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.UseCase.CppProxy
 * JD-Core Version:    0.7.0.1
 */