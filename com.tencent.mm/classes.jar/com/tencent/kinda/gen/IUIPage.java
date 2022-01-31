package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IUIPage
{
  public static native IUIPage createAppUipage(String paramString);
  
  public abstract NavigationBarConfig defaultNavigationBarConfig();
  
  public abstract boolean enableInteractivePop();
  
  public abstract boolean fullPageMode();
  
  public abstract String getReportUrl();
  
  public abstract KView keyboardTopView();
  
  public abstract float keyboardTopViewBottomMargin();
  
  public abstract void onClickAndroidBack();
  
  public abstract void onCreate();
  
  public abstract void onCreateLayout(KViewLayout paramKViewLayout);
  
  public abstract void onDestroy();
  
  public abstract void onFirstLayoutFinished();
  
  public abstract void onInvisible();
  
  public abstract void onVisible();
  
  public abstract void setPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
  
  public abstract void setPlatformFuncDelegate(IUIPagePlatformFuncDelegate paramIUIPagePlatformFuncDelegate);
  
  public abstract void viewDidTransitionToNewSize();
  
  static final class CppProxy
    extends IUIPage
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(141264);
      if (!IUIPage.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(141264);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(141245);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(141245);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(141245);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native NavigationBarConfig native_defaultNavigationBarConfig(long paramLong);
    
    private native boolean native_enableInteractivePop(long paramLong);
    
    private native boolean native_fullPageMode(long paramLong);
    
    private native String native_getReportUrl(long paramLong);
    
    private native KView native_keyboardTopView(long paramLong);
    
    private native float native_keyboardTopViewBottomMargin(long paramLong);
    
    private native void native_onClickAndroidBack(long paramLong);
    
    private native void native_onCreate(long paramLong);
    
    private native void native_onCreateLayout(long paramLong, KViewLayout paramKViewLayout);
    
    private native void native_onDestroy(long paramLong);
    
    private native void native_onFirstLayoutFinished(long paramLong);
    
    private native void native_onInvisible(long paramLong);
    
    private native void native_onVisible(long paramLong);
    
    private native void native_setPlatformDelegate(long paramLong, IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
    
    private native void native_setPlatformFuncDelegate(long paramLong, IUIPagePlatformFuncDelegate paramIUIPagePlatformFuncDelegate);
    
    private native void native_viewDidTransitionToNewSize(long paramLong);
    
    public final NavigationBarConfig defaultNavigationBarConfig()
    {
      AppMethodBeat.i(141257);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141257);
        throw ((Throwable)localObject);
      }
      Object localObject = native_defaultNavigationBarConfig(this.nativeRef);
      AppMethodBeat.o(141257);
      return localObject;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(141246);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(141246);
    }
    
    public final boolean enableInteractivePop()
    {
      AppMethodBeat.i(141261);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141261);
        throw localAssertionError;
      }
      boolean bool = native_enableInteractivePop(this.nativeRef);
      AppMethodBeat.o(141261);
      return bool;
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(141247);
      destroy();
      super.finalize();
      AppMethodBeat.o(141247);
    }
    
    public final boolean fullPageMode()
    {
      AppMethodBeat.i(141260);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141260);
        throw localAssertionError;
      }
      boolean bool = native_fullPageMode(this.nativeRef);
      AppMethodBeat.o(141260);
      return bool;
    }
    
    public final String getReportUrl()
    {
      AppMethodBeat.i(141262);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141262);
        throw ((Throwable)localObject);
      }
      Object localObject = native_getReportUrl(this.nativeRef);
      AppMethodBeat.o(141262);
      return localObject;
    }
    
    public final KView keyboardTopView()
    {
      AppMethodBeat.i(141258);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141258);
        throw ((Throwable)localObject);
      }
      Object localObject = native_keyboardTopView(this.nativeRef);
      AppMethodBeat.o(141258);
      return localObject;
    }
    
    public final float keyboardTopViewBottomMargin()
    {
      AppMethodBeat.i(141259);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141259);
        throw localAssertionError;
      }
      float f = native_keyboardTopViewBottomMargin(this.nativeRef);
      AppMethodBeat.o(141259);
      return f;
    }
    
    public final void onClickAndroidBack()
    {
      AppMethodBeat.i(141263);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141263);
        throw localAssertionError;
      }
      native_onClickAndroidBack(this.nativeRef);
      AppMethodBeat.o(141263);
    }
    
    public final void onCreate()
    {
      AppMethodBeat.i(141251);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141251);
        throw localAssertionError;
      }
      native_onCreate(this.nativeRef);
      AppMethodBeat.o(141251);
    }
    
    public final void onCreateLayout(KViewLayout paramKViewLayout)
    {
      AppMethodBeat.i(141250);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKViewLayout = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141250);
        throw paramKViewLayout;
      }
      native_onCreateLayout(this.nativeRef, paramKViewLayout);
      AppMethodBeat.o(141250);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(141253);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141253);
        throw localAssertionError;
      }
      native_onDestroy(this.nativeRef);
      AppMethodBeat.o(141253);
    }
    
    public final void onFirstLayoutFinished()
    {
      AppMethodBeat.i(141252);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141252);
        throw localAssertionError;
      }
      native_onFirstLayoutFinished(this.nativeRef);
      AppMethodBeat.o(141252);
    }
    
    public final void onInvisible()
    {
      AppMethodBeat.i(141255);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141255);
        throw localAssertionError;
      }
      native_onInvisible(this.nativeRef);
      AppMethodBeat.o(141255);
    }
    
    public final void onVisible()
    {
      AppMethodBeat.i(141254);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141254);
        throw localAssertionError;
      }
      native_onVisible(this.nativeRef);
      AppMethodBeat.o(141254);
    }
    
    public final void setPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate)
    {
      AppMethodBeat.i(141249);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramIUIPagePlatformDelegate = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141249);
        throw paramIUIPagePlatformDelegate;
      }
      native_setPlatformDelegate(this.nativeRef, paramIUIPagePlatformDelegate);
      AppMethodBeat.o(141249);
    }
    
    public final void setPlatformFuncDelegate(IUIPagePlatformFuncDelegate paramIUIPagePlatformFuncDelegate)
    {
      AppMethodBeat.i(141248);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramIUIPagePlatformFuncDelegate = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141248);
        throw paramIUIPagePlatformFuncDelegate;
      }
      native_setPlatformFuncDelegate(this.nativeRef, paramIUIPagePlatformFuncDelegate);
      AppMethodBeat.o(141248);
    }
    
    public final void viewDidTransitionToNewSize()
    {
      AppMethodBeat.i(141256);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141256);
        throw localAssertionError;
      }
      native_viewDidTransitionToNewSize(this.nativeRef);
      AppMethodBeat.o(141256);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.IUIPage
 * JD-Core Version:    0.7.0.1
 */