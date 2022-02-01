package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KCardTypePickerViewOnSelectCallback
{
  public abstract void onSelect(int paramInt);
  
  static final class CppProxy
    extends KCardTypePickerViewOnSelectCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135794);
      if (!KCardTypePickerViewOnSelectCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135794);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135790);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135790);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135790);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onSelect(long paramLong, int paramInt);
    
    public final void destroy()
    {
      AppMethodBeat.i(135791);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135791);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135792);
      destroy();
      super.finalize();
      AppMethodBeat.o(135792);
    }
    
    public final void onSelect(int paramInt)
    {
      AppMethodBeat.i(135793);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135793);
        throw localAssertionError;
      }
      native_onSelect(this.nativeRef, paramInt);
      AppMethodBeat.o(135793);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KCardTypePickerViewOnSelectCallback
 * JD-Core Version:    0.7.0.1
 */