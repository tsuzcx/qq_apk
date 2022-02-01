package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IUIModal
{
  public abstract boolean IsShowAndroidCenterPadding();
  
  public abstract boolean forceShowInLightMode();
  
  public abstract IUIModalPlatformFuncDelegate getFuncDelegate();
  
  public abstract String getReportUrl();
  
  public abstract void keyboardWillHide();
  
  public abstract void keyboardWillShow(float paramFloat);
  
  public abstract void onClickAndroidBack();
  
  public abstract void onCreateLayout(KViewLayout paramKViewLayout);
  
  public abstract void onDestroy();
  
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
    
    private native String native_getReportUrl(long paramLong);
    
    private native void native_keyboardWillHide(long paramLong);
    
    private native void native_keyboardWillShow(long paramLong, float paramFloat);
    
    private native void native_onClickAndroidBack(long paramLong);
    
    private native void native_onCreateLayout(long paramLong, KViewLayout paramKViewLayout);
    
    private native void native_onDestroy(long paramLong);
    
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
      AppMethodBeat.i(226802);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226802);
        throw localAssertionError;
      }
      boolean bool = native_forceShowInLightMode(this.nativeRef);
      AppMethodBeat.o(226802);
      return bool;
    }
    
    public final IUIModalPlatformFuncDelegate getFuncDelegate()
    {
      AppMethodBeat.i(226782);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226782);
        throw ((Throwable)localObject);
      }
      Object localObject = native_getFuncDelegate(this.nativeRef);
      AppMethodBeat.o(226782);
      return localObject;
    }
    
    public final String getReportUrl()
    {
      AppMethodBeat.i(226793);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226793);
        throw ((Throwable)localObject);
      }
      Object localObject = native_getReportUrl(this.nativeRef);
      AppMethodBeat.o(226793);
      return localObject;
    }
    
    public final void keyboardWillHide()
    {
      AppMethodBeat.i(226786);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226786);
        throw localAssertionError;
      }
      native_keyboardWillHide(this.nativeRef);
      AppMethodBeat.o(226786);
    }
    
    public final void keyboardWillShow(float paramFloat)
    {
      AppMethodBeat.i(226785);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226785);
        throw localAssertionError;
      }
      native_keyboardWillShow(this.nativeRef, paramFloat);
      AppMethodBeat.o(226785);
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
    
    public final void onDestroy()
    {
      AppMethodBeat.i(226788);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226788);
        throw localAssertionError;
      }
      native_onDestroy(this.nativeRef);
      AppMethodBeat.o(226788);
    }
    
    public final void onFirstRenderFinish()
    {
      AppMethodBeat.i(226797);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226797);
        throw localAssertionError;
      }
      native_onFirstRenderFinish(this.nativeRef);
      AppMethodBeat.o(226797);
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
      AppMethodBeat.i(226780);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramIUIModalPlatformFuncDelegate = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226780);
        throw paramIUIModalPlatformFuncDelegate;
      }
      native_setFuncDelegate(this.nativeRef, paramIUIModalPlatformFuncDelegate);
      AppMethodBeat.o(226780);
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
      AppMethodBeat.i(226795);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226795);
        throw ((Throwable)localObject);
      }
      Object localObject = native_statusbarColor(this.nativeRef);
      AppMethodBeat.o(226795);
      return localObject;
    }
    
    public final boolean useKeyboardCoverMode()
    {
      AppMethodBeat.i(226801);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226801);
        throw localAssertionError;
      }
      boolean bool = native_useKeyboardCoverMode(this.nativeRef);
      AppMethodBeat.o(226801);
      return bool;
    }
    
    public final boolean usePanelModalMode()
    {
      AppMethodBeat.i(226799);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226799);
        throw localAssertionError;
      }
      boolean bool = native_usePanelModalMode(this.nativeRef);
      AppMethodBeat.o(226799);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.gen.IUIModal
 * JD-Core Version:    0.7.0.1
 */