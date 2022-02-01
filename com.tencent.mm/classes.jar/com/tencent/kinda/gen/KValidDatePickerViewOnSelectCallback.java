package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KValidDatePickerViewOnSelectCallback
{
  public abstract void onSelect(String paramString);
  
  static final class CppProxy
    extends KValidDatePickerViewOnSelectCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135921);
      if (!KValidDatePickerViewOnSelectCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135921);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135917);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135917);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135917);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onSelect(long paramLong, String paramString);
    
    public final void destroy()
    {
      AppMethodBeat.i(135918);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135918);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135919);
      destroy();
      super.finalize();
      AppMethodBeat.o(135919);
    }
    
    public final void onSelect(String paramString)
    {
      AppMethodBeat.i(135920);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135920);
        throw paramString;
      }
      native_onSelect(this.nativeRef, paramString);
      AppMethodBeat.o(135920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KValidDatePickerViewOnSelectCallback
 * JD-Core Version:    0.7.0.1
 */