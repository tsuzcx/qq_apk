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
      AppMethodBeat.i(141376);
      if (!KRegionEditViewOnRegionSelectedCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(141376);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(141372);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(141372);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(141372);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onRegionSelected(long paramLong);
    
    public final void destroy()
    {
      AppMethodBeat.i(141373);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(141373);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(141374);
      destroy();
      super.finalize();
      AppMethodBeat.o(141374);
    }
    
    public final void onRegionSelected()
    {
      AppMethodBeat.i(141375);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(141375);
        throw localAssertionError;
      }
      native_onRegionSelected(this.nativeRef);
      AppMethodBeat.o(141375);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KRegionEditViewOnRegionSelectedCallback
 * JD-Core Version:    0.7.0.1
 */