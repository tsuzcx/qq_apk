package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class IAppKinda$CppProxy
  extends IAppKinda
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141201);
    if (!IAppKinda.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141201);
      return;
    }
  }
  
  private IAppKinda$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141186);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141186);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141186);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_applicationBecomeActive(long paramLong);
  
  private native void native_applicationEnterBackground(long paramLong);
  
  private native void native_applicationEnterForeground(long paramLong);
  
  private native void native_applicationReceiveMemoryWarning(long paramLong);
  
  private native void native_applicationResignActive(long paramLong);
  
  private native void native_applicationWillTerminate(long paramLong);
  
  private native boolean native_getIsPaying(long paramLong);
  
  private native boolean native_isInAnyUseCase(long paramLong);
  
  private native void native_networkChange(long paramLong, ITransmitKvData paramITransmitKvData);
  
  private native void native_notifyAllUseCases(long paramLong, ITransmitKvData paramITransmitKvData);
  
  private native UseCase native_startUseCase(long paramLong, String paramString, ITransmitKvData paramITransmitKvData, UseCaseCallback paramUseCaseCallback);
  
  private native void native_stopUseCase(long paramLong, String paramString);
  
  public final void applicationBecomeActive()
  {
    AppMethodBeat.i(141196);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141196);
      throw localAssertionError;
    }
    native_applicationBecomeActive(this.nativeRef);
    AppMethodBeat.o(141196);
  }
  
  public final void applicationEnterBackground()
  {
    AppMethodBeat.i(141194);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141194);
      throw localAssertionError;
    }
    native_applicationEnterBackground(this.nativeRef);
    AppMethodBeat.o(141194);
  }
  
  public final void applicationEnterForeground()
  {
    AppMethodBeat.i(141195);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141195);
      throw localAssertionError;
    }
    native_applicationEnterForeground(this.nativeRef);
    AppMethodBeat.o(141195);
  }
  
  public final void applicationReceiveMemoryWarning()
  {
    AppMethodBeat.i(141198);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141198);
      throw localAssertionError;
    }
    native_applicationReceiveMemoryWarning(this.nativeRef);
    AppMethodBeat.o(141198);
  }
  
  public final void applicationResignActive()
  {
    AppMethodBeat.i(141197);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141197);
      throw localAssertionError;
    }
    native_applicationResignActive(this.nativeRef);
    AppMethodBeat.o(141197);
  }
  
  public final void applicationWillTerminate()
  {
    AppMethodBeat.i(141199);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141199);
      throw localAssertionError;
    }
    native_applicationWillTerminate(this.nativeRef);
    AppMethodBeat.o(141199);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141187);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141187);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141188);
    destroy();
    super.finalize();
    AppMethodBeat.o(141188);
  }
  
  public final boolean getIsPaying()
  {
    AppMethodBeat.i(141192);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141192);
      throw localAssertionError;
    }
    boolean bool = native_getIsPaying(this.nativeRef);
    AppMethodBeat.o(141192);
    return bool;
  }
  
  public final boolean isInAnyUseCase()
  {
    AppMethodBeat.i(141191);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141191);
      throw localAssertionError;
    }
    boolean bool = native_isInAnyUseCase(this.nativeRef);
    AppMethodBeat.o(141191);
    return bool;
  }
  
  public final void networkChange(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(141200);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramITransmitKvData = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141200);
      throw paramITransmitKvData;
    }
    native_networkChange(this.nativeRef, paramITransmitKvData);
    AppMethodBeat.o(141200);
  }
  
  public final void notifyAllUseCases(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(141193);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramITransmitKvData = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141193);
      throw paramITransmitKvData;
    }
    native_notifyAllUseCases(this.nativeRef, paramITransmitKvData);
    AppMethodBeat.o(141193);
  }
  
  public final UseCase startUseCase(String paramString, ITransmitKvData paramITransmitKvData, UseCaseCallback paramUseCaseCallback)
  {
    AppMethodBeat.i(141189);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141189);
      throw paramString;
    }
    paramString = native_startUseCase(this.nativeRef, paramString, paramITransmitKvData, paramUseCaseCallback);
    AppMethodBeat.o(141189);
    return paramString;
  }
  
  public final void stopUseCase(String paramString)
  {
    AppMethodBeat.i(141190);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141190);
      throw paramString;
    }
    native_stopUseCase(this.nativeRef, paramString);
    AppMethodBeat.o(141190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.IAppKinda.CppProxy
 * JD-Core Version:    0.7.0.1
 */