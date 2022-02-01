package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KRegionEditViewOnRegionSelectedCallback
{
  public abstract void onRegionSelected();
  
  static final class CppProxy
    extends KRegionEditViewOnRegionSelectedCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135888);
      if (!KRegionEditViewOnRegionSelectedCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135888);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135884);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135884);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135884);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onRegionSelected(long paramLong);
    
    public final void destroy()
    {
      AppMethodBeat.i(135885);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135885);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135886);
      destroy();
      super.finalize();
      AppMethodBeat.o(135886);
    }
    
    public final void onRegionSelected()
    {
      AppMethodBeat.i(135887);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135887);
        throw localAssertionError;
      }
      native_onRegionSelected(this.nativeRef);
      AppMethodBeat.o(135887);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KRegionEditViewOnRegionSelectedCallback
 * JD-Core Version:    0.7.0.1
 */