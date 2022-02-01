package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IUIModal
{
  public abstract boolean IsShowAndroidCenterPadding();
  
  public abstract void keyboadWillHide();
  
  public abstract void keyboadWillShow(float paramFloat);
  
  public abstract void onClickAndroidBack();
  
  public abstract void onCreateLayout(KViewLayout paramKViewLayout);
  
  public abstract void onModalEnterBackground();
  
  public abstract void onModalEnterForeground();
  
  public abstract void setPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
  
  public abstract DynamicColor statusbarColor();
  
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
    
    private native void native_keyboadWillHide(long paramLong);
    
    private native void native_keyboadWillShow(long paramLong, float paramFloat);
    
    private native void native_onClickAndroidBack(long paramLong);
    
    private native void native_onCreateLayout(long paramLong, KViewLayout paramKViewLayout);
    
    private native void native_onModalEnterBackground(long paramLong);
    
    private native void native_onModalEnterForeground(long paramLong);
    
    private native void native_setPlatformDelegate(long paramLong, IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
    
    private native DynamicColor native_statusbarColor(long paramLong);
    
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
      AppMethodBeat.i(190578);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(190578);
        throw ((Throwable)localObject);
      }
      Object localObject = native_statusbarColor(this.nativeRef);
      AppMethodBeat.o(190578);
      return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.IUIModal
 * JD-Core Version:    0.7.0.1
 */