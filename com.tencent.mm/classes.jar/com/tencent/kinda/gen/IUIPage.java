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
  
  public abstract void onBack();
  
  public abstract void onClickAndroidBack();
  
  public abstract void onCreate();
  
  public abstract void onCreateLayout(KViewLayout paramKViewLayout);
  
  public abstract void onDestroy();
  
  public abstract void onFirstLayoutFinished();
  
  public abstract void onInvisible();
  
  public abstract void onVisible();
  
  public abstract void setPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
  
  public abstract void setPlatformFuncDelegate(IUIPagePlatformFuncDelegate paramIUIPagePlatformFuncDelegate);
  
  public abstract void startLoading(String paramString, boolean paramBoolean);
  
  public abstract void stopLoading();
  
  public abstract void viewDidTransitionToNewSize();
  
  static final class CppProxy
    extends IUIPage
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135771);
      if (!IUIPage.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135771);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135749);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135749);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135749);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native NavigationBarConfig native_defaultNavigationBarConfig(long paramLong);
    
    private native boolean native_enableInteractivePop(long paramLong);
    
    private native boolean native_fullPageMode(long paramLong);
    
    private native String native_getReportUrl(long paramLong);
    
    private native KView native_keyboardTopView(long paramLong);
    
    private native float native_keyboardTopViewBottomMargin(long paramLong);
    
    private native void native_onBack(long paramLong);
    
    private native void native_onClickAndroidBack(long paramLong);
    
    private native void native_onCreate(long paramLong);
    
    private native void native_onCreateLayout(long paramLong, KViewLayout paramKViewLayout);
    
    private native void native_onDestroy(long paramLong);
    
    private native void native_onFirstLayoutFinished(long paramLong);
    
    private native void native_onInvisible(long paramLong);
    
    private native void native_onVisible(long paramLong);
    
    private native void native_setPlatformDelegate(long paramLong, IUIPagePlatformDelegate paramIUIPagePlatformDelegate);
    
    private native void native_setPlatformFuncDelegate(long paramLong, IUIPagePlatformFuncDelegate paramIUIPagePlatformFuncDelegate);
    
    private native void native_startLoading(long paramLong, String paramString, boolean paramBoolean);
    
    private native void native_stopLoading(long paramLong);
    
    private native void native_viewDidTransitionToNewSize(long paramLong);
    
    public final NavigationBarConfig defaultNavigationBarConfig()
    {
      AppMethodBeat.i(135762);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135762);
        throw ((Throwable)localObject);
      }
      Object localObject = native_defaultNavigationBarConfig(this.nativeRef);
      AppMethodBeat.o(135762);
      return localObject;
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(135750);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135750);
    }
    
    public final boolean enableInteractivePop()
    {
      AppMethodBeat.i(135766);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135766);
        throw localAssertionError;
      }
      boolean bool = native_enableInteractivePop(this.nativeRef);
      AppMethodBeat.o(135766);
      return bool;
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135751);
      destroy();
      super.finalize();
      AppMethodBeat.o(135751);
    }
    
    public final boolean fullPageMode()
    {
      AppMethodBeat.i(135765);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135765);
        throw localAssertionError;
      }
      boolean bool = native_fullPageMode(this.nativeRef);
      AppMethodBeat.o(135765);
      return bool;
    }
    
    public final String getReportUrl()
    {
      AppMethodBeat.i(135767);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135767);
        throw ((Throwable)localObject);
      }
      Object localObject = native_getReportUrl(this.nativeRef);
      AppMethodBeat.o(135767);
      return localObject;
    }
    
    public final KView keyboardTopView()
    {
      AppMethodBeat.i(135763);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135763);
        throw ((Throwable)localObject);
      }
      Object localObject = native_keyboardTopView(this.nativeRef);
      AppMethodBeat.o(135763);
      return localObject;
    }
    
    public final float keyboardTopViewBottomMargin()
    {
      AppMethodBeat.i(135764);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135764);
        throw localAssertionError;
      }
      float f = native_keyboardTopViewBottomMargin(this.nativeRef);
      AppMethodBeat.o(135764);
      return f;
    }
    
    public final void onBack()
    {
      AppMethodBeat.i(135760);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135760);
        throw localAssertionError;
      }
      native_onBack(this.nativeRef);
      AppMethodBeat.o(135760);
    }
    
    public final void onClickAndroidBack()
    {
      AppMethodBeat.i(135768);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135768);
        throw localAssertionError;
      }
      native_onClickAndroidBack(this.nativeRef);
      AppMethodBeat.o(135768);
    }
    
    public final void onCreate()
    {
      AppMethodBeat.i(135755);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135755);
        throw localAssertionError;
      }
      native_onCreate(this.nativeRef);
      AppMethodBeat.o(135755);
    }
    
    public final void onCreateLayout(KViewLayout paramKViewLayout)
    {
      AppMethodBeat.i(135754);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKViewLayout = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135754);
        throw paramKViewLayout;
      }
      native_onCreateLayout(this.nativeRef, paramKViewLayout);
      AppMethodBeat.o(135754);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(135757);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135757);
        throw localAssertionError;
      }
      native_onDestroy(this.nativeRef);
      AppMethodBeat.o(135757);
    }
    
    public final void onFirstLayoutFinished()
    {
      AppMethodBeat.i(135756);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135756);
        throw localAssertionError;
      }
      native_onFirstLayoutFinished(this.nativeRef);
      AppMethodBeat.o(135756);
    }
    
    public final void onInvisible()
    {
      AppMethodBeat.i(135759);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135759);
        throw localAssertionError;
      }
      native_onInvisible(this.nativeRef);
      AppMethodBeat.o(135759);
    }
    
    public final void onVisible()
    {
      AppMethodBeat.i(135758);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135758);
        throw localAssertionError;
      }
      native_onVisible(this.nativeRef);
      AppMethodBeat.o(135758);
    }
    
    public final void setPlatformDelegate(IUIPagePlatformDelegate paramIUIPagePlatformDelegate)
    {
      AppMethodBeat.i(135753);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramIUIPagePlatformDelegate = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135753);
        throw paramIUIPagePlatformDelegate;
      }
      native_setPlatformDelegate(this.nativeRef, paramIUIPagePlatformDelegate);
      AppMethodBeat.o(135753);
    }
    
    public final void setPlatformFuncDelegate(IUIPagePlatformFuncDelegate paramIUIPagePlatformFuncDelegate)
    {
      AppMethodBeat.i(135752);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramIUIPagePlatformFuncDelegate = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135752);
        throw paramIUIPagePlatformFuncDelegate;
      }
      native_setPlatformFuncDelegate(this.nativeRef, paramIUIPagePlatformFuncDelegate);
      AppMethodBeat.o(135752);
    }
    
    public final void startLoading(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(135769);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135769);
        throw paramString;
      }
      native_startLoading(this.nativeRef, paramString, paramBoolean);
      AppMethodBeat.o(135769);
    }
    
    public final void stopLoading()
    {
      AppMethodBeat.i(135770);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135770);
        throw localAssertionError;
      }
      native_stopLoading(this.nativeRef);
      AppMethodBeat.o(135770);
    }
    
    public final void viewDidTransitionToNewSize()
    {
      AppMethodBeat.i(135761);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135761);
        throw localAssertionError;
      }
      native_viewDidTransitionToNewSize(this.nativeRef);
      AppMethodBeat.o(135761);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.IUIPage
 * JD-Core Version:    0.7.0.1
 */