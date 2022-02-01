package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IAppKinda
{
  public static native IAppKinda getInstance();
  
  public abstract void applicationBecomeActive();
  
  public abstract void applicationEnterBackground();
  
  public abstract void applicationEnterForeground();
  
  public abstract void applicationReceiveMemoryWarning(ITransmitKvData paramITransmitKvData);
  
  public abstract void applicationResignActive();
  
  public abstract void applicationRestart();
  
  public abstract void applicationWillTerminate(ITransmitKvData paramITransmitKvData);
  
  public abstract boolean checkOfflineReady();
  
  public abstract boolean getIsPaying();
  
  public abstract boolean isInAnyUseCase();
  
  public abstract boolean isUseCaseAlive(String paramString);
  
  public abstract void networkChange(ITransmitKvData paramITransmitKvData);
  
  public abstract void notifyAllUseCases(ITransmitKvData paramITransmitKvData);
  
  public abstract void popToUseCase(String paramString);
  
  public abstract UseCase startUseCase(String paramString, ITransmitKvData paramITransmitKvData, UseCaseCallback paramUseCaseCallback);
  
  public abstract void stopUseCase(String paramString);
  
  public abstract void takeScreenshot();
  
  static final class CppProxy
    extends IAppKinda
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135700);
      if (!IAppKinda.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135700);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135681);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135681);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135681);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_applicationBecomeActive(long paramLong);
    
    private native void native_applicationEnterBackground(long paramLong);
    
    private native void native_applicationEnterForeground(long paramLong);
    
    private native void native_applicationReceiveMemoryWarning(long paramLong, ITransmitKvData paramITransmitKvData);
    
    private native void native_applicationResignActive(long paramLong);
    
    private native void native_applicationRestart(long paramLong);
    
    private native void native_applicationWillTerminate(long paramLong, ITransmitKvData paramITransmitKvData);
    
    private native boolean native_checkOfflineReady(long paramLong);
    
    private native boolean native_getIsPaying(long paramLong);
    
    private native boolean native_isInAnyUseCase(long paramLong);
    
    private native boolean native_isUseCaseAlive(long paramLong, String paramString);
    
    private native void native_networkChange(long paramLong, ITransmitKvData paramITransmitKvData);
    
    private native void native_notifyAllUseCases(long paramLong, ITransmitKvData paramITransmitKvData);
    
    private native void native_popToUseCase(long paramLong, String paramString);
    
    private native UseCase native_startUseCase(long paramLong, String paramString, ITransmitKvData paramITransmitKvData, UseCaseCallback paramUseCaseCallback);
    
    private native void native_stopUseCase(long paramLong, String paramString);
    
    private native void native_takeScreenshot(long paramLong);
    
    public final void applicationBecomeActive()
    {
      AppMethodBeat.i(135694);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135694);
        throw localAssertionError;
      }
      native_applicationBecomeActive(this.nativeRef);
      AppMethodBeat.o(135694);
    }
    
    public final void applicationEnterBackground()
    {
      AppMethodBeat.i(135692);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135692);
        throw localAssertionError;
      }
      native_applicationEnterBackground(this.nativeRef);
      AppMethodBeat.o(135692);
    }
    
    public final void applicationEnterForeground()
    {
      AppMethodBeat.i(135693);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135693);
        throw localAssertionError;
      }
      native_applicationEnterForeground(this.nativeRef);
      AppMethodBeat.o(135693);
    }
    
    public final void applicationReceiveMemoryWarning(ITransmitKvData paramITransmitKvData)
    {
      AppMethodBeat.i(219408);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramITransmitKvData = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219408);
        throw paramITransmitKvData;
      }
      native_applicationReceiveMemoryWarning(this.nativeRef, paramITransmitKvData);
      AppMethodBeat.o(219408);
    }
    
    public final void applicationResignActive()
    {
      AppMethodBeat.i(135695);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135695);
        throw localAssertionError;
      }
      native_applicationResignActive(this.nativeRef);
      AppMethodBeat.o(135695);
    }
    
    public final void applicationRestart()
    {
      AppMethodBeat.i(219424);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219424);
        throw localAssertionError;
      }
      native_applicationRestart(this.nativeRef);
      AppMethodBeat.o(219424);
    }
    
    public final void applicationWillTerminate(ITransmitKvData paramITransmitKvData)
    {
      AppMethodBeat.i(219412);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramITransmitKvData = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219412);
        throw paramITransmitKvData;
      }
      native_applicationWillTerminate(this.nativeRef, paramITransmitKvData);
      AppMethodBeat.o(219412);
    }
    
    public final boolean checkOfflineReady()
    {
      AppMethodBeat.i(219396);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219396);
        throw localAssertionError;
      }
      boolean bool = native_checkOfflineReady(this.nativeRef);
      AppMethodBeat.o(219396);
      return bool;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(135682);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135682);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135683);
      destroy();
      super.finalize();
      AppMethodBeat.o(135683);
    }
    
    public final boolean getIsPaying()
    {
      AppMethodBeat.i(135689);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135689);
        throw localAssertionError;
      }
      boolean bool = native_getIsPaying(this.nativeRef);
      AppMethodBeat.o(135689);
      return bool;
    }
    
    public final boolean isInAnyUseCase()
    {
      AppMethodBeat.i(135686);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135686);
        throw localAssertionError;
      }
      boolean bool = native_isInAnyUseCase(this.nativeRef);
      AppMethodBeat.o(135686);
      return bool;
    }
    
    public final boolean isUseCaseAlive(String paramString)
    {
      AppMethodBeat.i(135687);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135687);
        throw paramString;
      }
      boolean bool = native_isUseCaseAlive(this.nativeRef, paramString);
      AppMethodBeat.o(135687);
      return bool;
    }
    
    public final void networkChange(ITransmitKvData paramITransmitKvData)
    {
      AppMethodBeat.i(135698);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramITransmitKvData = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135698);
        throw paramITransmitKvData;
      }
      native_networkChange(this.nativeRef, paramITransmitKvData);
      AppMethodBeat.o(135698);
    }
    
    public final void notifyAllUseCases(ITransmitKvData paramITransmitKvData)
    {
      AppMethodBeat.i(135690);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramITransmitKvData = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135690);
        throw paramITransmitKvData;
      }
      native_notifyAllUseCases(this.nativeRef, paramITransmitKvData);
      AppMethodBeat.o(135690);
    }
    
    public final void popToUseCase(String paramString)
    {
      AppMethodBeat.i(135688);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135688);
        throw paramString;
      }
      native_popToUseCase(this.nativeRef, paramString);
      AppMethodBeat.o(135688);
    }
    
    public final UseCase startUseCase(String paramString, ITransmitKvData paramITransmitKvData, UseCaseCallback paramUseCaseCallback)
    {
      AppMethodBeat.i(135684);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135684);
        throw paramString;
      }
      paramString = native_startUseCase(this.nativeRef, paramString, paramITransmitKvData, paramUseCaseCallback);
      AppMethodBeat.o(135684);
      return paramString;
    }
    
    public final void stopUseCase(String paramString)
    {
      AppMethodBeat.i(135685);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135685);
        throw paramString;
      }
      native_stopUseCase(this.nativeRef, paramString);
      AppMethodBeat.o(135685);
    }
    
    public final void takeScreenshot()
    {
      AppMethodBeat.i(135699);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135699);
        throw localAssertionError;
      }
      native_takeScreenshot(this.nativeRef);
      AppMethodBeat.o(135699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.IAppKinda
 * JD-Core Version:    0.7.0.1
 */