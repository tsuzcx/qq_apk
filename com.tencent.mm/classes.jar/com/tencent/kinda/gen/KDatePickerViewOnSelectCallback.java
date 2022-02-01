package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KDatePickerViewOnSelectCallback
{
  public abstract void onSelect(String paramString);
  
  static final class CppProxy
    extends KDatePickerViewOnSelectCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135822);
      if (!KDatePickerViewOnSelectCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135822);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135818);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135818);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135818);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onSelect(long paramLong, String paramString);
    
    public final void destroy()
    {
      AppMethodBeat.i(135819);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135819);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135820);
      destroy();
      super.finalize();
      AppMethodBeat.o(135820);
    }
    
    public final void onSelect(String paramString)
    {
      AppMethodBeat.i(135821);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135821);
        throw paramString;
      }
      native_onSelect(this.nativeRef, paramString);
      AppMethodBeat.o(135821);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KDatePickerViewOnSelectCallback
 * JD-Core Version:    0.7.0.1
 */