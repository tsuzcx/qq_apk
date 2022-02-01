package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KSwitchViewOnChangeSwitchCallback
{
  public abstract void onChangeSwitch();
  
  static final class CppProxy
    extends KSwitchViewOnChangeSwitchCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135909);
      if (!KSwitchViewOnChangeSwitchCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135909);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135905);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135905);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135905);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onChangeSwitch(long paramLong);
    
    public final void destroy()
    {
      AppMethodBeat.i(135906);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135906);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135907);
      destroy();
      super.finalize();
      AppMethodBeat.o(135907);
    }
    
    public final void onChangeSwitch()
    {
      AppMethodBeat.i(135908);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135908);
        throw localAssertionError;
      }
      native_onChangeSwitch(this.nativeRef);
      AppMethodBeat.o(135908);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KSwitchViewOnChangeSwitchCallback
 * JD-Core Version:    0.7.0.1
 */