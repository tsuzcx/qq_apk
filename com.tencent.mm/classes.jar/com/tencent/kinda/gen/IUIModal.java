package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IUIModal
{
  public abstract void keyboadWillHide();
  
  public abstract void keyboadWillShow(float paramFloat);
  
  public abstract void onClickAndroidBack();
  
  public abstract void onCreateLayout(KViewLayout paramKViewLayout);
  
  public abstract void onModalEnterBackground();
  
  public abstract void onModalEnterForeground();
  
  public abstract void setPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
  
  static final class CppProxy
    extends IUIModal
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(141244);
      if (!IUIModal.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(141244);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(141234);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(141234);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(141234);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_keyboadWillHide(long paramLong);
    
    private native void native_keyboadWillShow(long paramLong, float paramFloat);
    
    private native void native_onClickAndroidBack(long paramLong);
    
    private native void native_onCreateLayout(long paramLong, KViewLayout paramKViewLayout);
    
    private native void native_onModalEnterBackground(long paramLong);
    
    private native void native_onModalEnterForeground(long paramLong);
    
    private native void native_setPlatformDelegate(long paramLong, IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
    
    public final void destroy()
    {
      AppMethodBeat.i(141235);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(141235);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(141236);
      destroy();
      super.finalize();
      AppMethodBeat.o(141236);
    }
    
    public final void keyboadWillHide()
    {
      AppMethodBeat.i(141240);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141240);
        throw localAssertionError;
      }
      native_keyboadWillHide(this.nativeRef);
      AppMethodBeat.o(141240);
    }
    
    public final void keyboadWillShow(float paramFloat)
    {
      AppMethodBeat.i(141239);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141239);
        throw localAssertionError;
      }
      native_keyboadWillShow(this.nativeRef, paramFloat);
      AppMethodBeat.o(141239);
    }
    
    public final void onClickAndroidBack()
    {
      AppMethodBeat.i(141243);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141243);
        throw localAssertionError;
      }
      native_onClickAndroidBack(this.nativeRef);
      AppMethodBeat.o(141243);
    }
    
    public final void onCreateLayout(KViewLayout paramKViewLayout)
    {
      AppMethodBeat.i(141237);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKViewLayout = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141237);
        throw paramKViewLayout;
      }
      native_onCreateLayout(this.nativeRef, paramKViewLayout);
      AppMethodBeat.o(141237);
    }
    
    public final void onModalEnterBackground()
    {
      AppMethodBeat.i(141241);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141241);
        throw localAssertionError;
      }
      native_onModalEnterBackground(this.nativeRef);
      AppMethodBeat.o(141241);
    }
    
    public final void onModalEnterForeground()
    {
      AppMethodBeat.i(141242);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141242);
        throw localAssertionError;
      }
      native_onModalEnterForeground(this.nativeRef);
      AppMethodBeat.o(141242);
    }
    
    public final void setPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate)
    {
      AppMethodBeat.i(141238);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramIUIPagePlatformDelegate = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141238);
        throw paramIUIPagePlatformDelegate;
      }
      native_setPlatformDelegate(this.nativeRef, paramIUIPagePlatformDelegate);
      AppMethodBeat.o(141238);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.IUIModal
 * JD-Core Version:    0.7.0.1
 */