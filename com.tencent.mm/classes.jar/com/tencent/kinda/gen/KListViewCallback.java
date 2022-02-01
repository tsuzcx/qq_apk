package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KListViewCallback
{
  public abstract KView fillData(int paramInt, KViewLayout paramKViewLayout);
  
  public abstract int getCount();
  
  public abstract int getViewType(int paramInt);
  
  public abstract int getViewTypeCount();
  
  static final class CppProxy
    extends KListViewCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135842);
      if (!KListViewCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135842);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135835);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135835);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135835);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native KView native_fillData(long paramLong, int paramInt, KViewLayout paramKViewLayout);
    
    private native int native_getCount(long paramLong);
    
    private native int native_getViewType(long paramLong, int paramInt);
    
    private native int native_getViewTypeCount(long paramLong);
    
    public final void destroy()
    {
      AppMethodBeat.i(135836);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135836);
    }
    
    public final KView fillData(int paramInt, KViewLayout paramKViewLayout)
    {
      AppMethodBeat.i(135841);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKViewLayout = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135841);
        throw paramKViewLayout;
      }
      paramKViewLayout = native_fillData(this.nativeRef, paramInt, paramKViewLayout);
      AppMethodBeat.o(135841);
      return paramKViewLayout;
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135837);
      destroy();
      super.finalize();
      AppMethodBeat.o(135837);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(135838);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135838);
        throw localAssertionError;
      }
      int i = native_getCount(this.nativeRef);
      AppMethodBeat.o(135838);
      return i;
    }
    
    public final int getViewType(int paramInt)
    {
      AppMethodBeat.i(135839);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135839);
        throw localAssertionError;
      }
      paramInt = native_getViewType(this.nativeRef, paramInt);
      AppMethodBeat.o(135839);
      return paramInt;
    }
    
    public final int getViewTypeCount()
    {
      AppMethodBeat.i(135840);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135840);
        throw localAssertionError;
      }
      int i = native_getViewTypeCount(this.nativeRef);
      AppMethodBeat.o(135840);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KListViewCallback
 * JD-Core Version:    0.7.0.1
 */