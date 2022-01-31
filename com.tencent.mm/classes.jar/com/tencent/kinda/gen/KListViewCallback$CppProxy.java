package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KListViewCallback$CppProxy
  extends KListViewCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141330);
    if (!KListViewCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141330);
      return;
    }
  }
  
  private KListViewCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141323);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141323);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141323);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native KView native_fillData(long paramLong, int paramInt, KViewLayout paramKViewLayout);
  
  private native int native_getCount(long paramLong);
  
  private native int native_getViewType(long paramLong, int paramInt);
  
  private native int native_getViewTypeCount(long paramLong);
  
  public final void destroy()
  {
    AppMethodBeat.i(141324);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141324);
  }
  
  public final KView fillData(int paramInt, KViewLayout paramKViewLayout)
  {
    AppMethodBeat.i(141329);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramKViewLayout = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141329);
      throw paramKViewLayout;
    }
    paramKViewLayout = native_fillData(this.nativeRef, paramInt, paramKViewLayout);
    AppMethodBeat.o(141329);
    return paramKViewLayout;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141325);
    destroy();
    super.finalize();
    AppMethodBeat.o(141325);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(141326);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141326);
      throw localAssertionError;
    }
    int i = native_getCount(this.nativeRef);
    AppMethodBeat.o(141326);
    return i;
  }
  
  public final int getViewType(int paramInt)
  {
    AppMethodBeat.i(141327);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141327);
      throw localAssertionError;
    }
    paramInt = native_getViewType(this.nativeRef, paramInt);
    AppMethodBeat.o(141327);
    return paramInt;
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(141328);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141328);
      throw localAssertionError;
    }
    int i = native_getViewTypeCount(this.nativeRef);
    AppMethodBeat.o(141328);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KListViewCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */