package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IUIModal
{
  public abstract boolean IsShowAndroidCenterPadding();
  
  public abstract boolean forceShowInLightMode();
  
  public abstract IUIModalPlatformFuncDelegate getFuncDelegate();
  
  public abstract void keyboadWillHide();
  
  public abstract void keyboadWillShow(float paramFloat);
  
  public abstract void onClickAndroidBack();
  
  public abstract void onCreateLayout(KViewLayout paramKViewLayout);
  
  public abstract void onFirstRenderFinish();
  
  public abstract void onModalEnterBackground();
  
  public abstract void onModalEnterForeground();
  
  public abstract void setFuncDelegate(IUIModalPlatformFuncDelegate paramIUIModalPlatformFuncDelegate);
  
  public abstract void setPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
  
  public abstract DynamicColor statusbarColor();
  
  public abstract boolean useKeyboardCoverMode();
  
  public abstract boolean usePanelModalMode();
  
  public abstract void viewDidTransitionToNewSize();
  
  static final class CppProxy
    extends IUIModal
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135748);
      if (!IUIModal.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135748);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135736);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135736);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135736);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native boolean native_IsShowAndroidCenterPadding(long paramLong);
    
    private native boolean native_forceShowInLightMode(long paramLong);
    
    private native IUIModalPlatformFuncDelegate native_getFuncDelegate(long paramLong);
    
    private native void native_keyboadWillHide(long paramLong);
    
    private native void native_keyboadWillShow(long paramLong, float paramFloat);
    
    private native void native_onClickAndroidBack(long paramLong);
    
    private native void native_onCreateLayout(long paramLong, KViewLayout paramKViewLayout);
    
    private native void native_onFirstRenderFinish(long paramLong);
    
    private native void native_onModalEnterBackground(long paramLong);
    
    private native void native_onModalEnterForeground(long paramLong);
    
    private native void native_setFuncDelegate(long paramLong, IUIModalPlatformFuncDelegate paramIUIModalPlatformFuncDelegate);
    
    private native void native_setPlatformDelegate(long paramLong, IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
    
    private native DynamicColor native_statusbarColor(long paramLong);
    
    private native boolean native_useKeyboardCoverMode(long paramLong);
    
    private native boolean native_usePanelModalMode(long paramLong);
    
    private native void native_viewDidTransitionToNewSize(long paramLong);
    
    public final boolean IsShowAndroidCenterPadding()
    {
      AppMethodBeat.i(135747);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135747);
        throw localAssertionError;
      }
      boolean bool = native_IsShowAndroidCenterPadding(this.nativeRef);
      AppMethodBeat.o(135747);
      return bool;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(135737);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135737);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135738);
      destroy();
      super.finalize();
      AppMethodBeat.o(135738);
    }
    
    public final boolean forceShowInLightMode()
    {
      AppMethodBeat.i(219574);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219574);
        throw localAssertionError;
      }
      boolean bool = native_forceShowInLightMode(this.nativeRef);
      AppMethodBeat.o(219574);
      return bool;
    }
    
    public final IUIModalPlatformFuncDelegate getFuncDelegate()
    {
      AppMethodBeat.i(219544);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219544);
        throw ((Throwable)localObject);
      }
      Object localObject = native_getFuncDelegate(this.nativeRef);
      AppMethodBeat.o(219544);
      return localObject;
    }
    
    public final void keyboadWillHide()
    {
      AppMethodBeat.i(135742);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135742);
        throw localAssertionError;
      }
      native_keyboadWillHide(this.nativeRef);
      AppMethodBeat.o(135742);
    }
    
    public final void keyboadWillShow(float paramFloat)
    {
      AppMethodBeat.i(135741);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135741);
        throw localAssertionError;
      }
      native_keyboadWillShow(this.nativeRef, paramFloat);
      AppMethodBeat.o(135741);
    }
    
    public final void onClickAndroidBack()
    {
      AppMethodBeat.i(135746);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135746);
        throw localAssertionError;
      }
      native_onClickAndroidBack(this.nativeRef);
      AppMethodBeat.o(135746);
    }
    
    public final void onCreateLayout(KViewLayout paramKViewLayout)
    {
      AppMethodBeat.i(135739);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKViewLayout = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135739);
        throw paramKViewLayout;
      }
      native_onCreateLayout(this.nativeRef, paramKViewLayout);
      AppMethodBeat.o(135739);
    }
    
    public final void onFirstRenderFinish()
    {
      AppMethodBeat.i(219566);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219566);
        throw localAssertionError;
      }
      native_onFirstRenderFinish(this.nativeRef);
      AppMethodBeat.o(219566);
    }
    
    public final void onModalEnterBackground()
    {
      AppMethodBeat.i(135744);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135744);
        throw localAssertionError;
      }
      native_onModalEnterBackground(this.nativeRef);
      AppMethodBeat.o(135744);
    }
    
    public final void onModalEnterForeground()
    {
      AppMethodBeat.i(135745);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135745);
        throw localAssertionError;
      }
      native_onModalEnterForeground(this.nativeRef);
      AppMethodBeat.o(135745);
    }
    
    public final void setFuncDelegate(IUIModalPlatformFuncDelegate paramIUIModalPlatformFuncDelegate)
    {
      AppMethodBeat.i(219542);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramIUIModalPlatformFuncDelegate = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219542);
        throw paramIUIModalPlatformFuncDelegate;
      }
      native_setFuncDelegate(this.nativeRef, paramIUIModalPlatformFuncDelegate);
      AppMethodBeat.o(219542);
    }
    
    public final void setPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate)
    {
      AppMethodBeat.i(135740);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramIUIPagePlatformDelegate = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135740);
        throw paramIUIPagePlatformDelegate;
      }
      native_setPlatformDelegate(this.nativeRef, paramIUIPagePlatformDelegate);
      AppMethodBeat.o(135740);
    }
    
    public final DynamicColor statusbarColor()
    {
      AppMethodBeat.i(219563);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219563);
        throw ((Throwable)localObject);
      }
      Object localObject = native_statusbarColor(this.nativeRef);
      AppMethodBeat.o(219563);
      return localObject;
    }
    
    public final boolean useKeyboardCoverMode()
    {
      AppMethodBeat.i(219572);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219572);
        throw localAssertionError;
      }
      boolean bool = native_useKeyboardCoverMode(this.nativeRef);
      AppMethodBeat.o(219572);
      return bool;
    }
    
    public final boolean usePanelModalMode()
    {
      AppMethodBeat.i(219570);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219570);
        throw localAssertionError;
      }
      boolean bool = native_usePanelModalMode(this.nativeRef);
      AppMethodBeat.o(219570);
      return bool;
    }
    
    public final void viewDidTransitionToNewSize()
    {
      AppMethodBeat.i(135743);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135743);
        throw localAssertionError;
      }
      native_viewDidTransitionToNewSize(this.nativeRef);
      AppMethodBeat.o(135743);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.IUIModal
 * JD-Core Version:    0.7.0.1
 */