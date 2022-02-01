package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KCountPickerViewOnSelectCallback
{
  public abstract void onSelect(String paramString);
  
  static final class CppProxy
    extends KCountPickerViewOnSelectCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135812);
      if (!KCountPickerViewOnSelectCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135812);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135808);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135808);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135808);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onSelect(long paramLong, String paramString);
    
    public final void destroy()
    {
      AppMethodBeat.i(135809);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135809);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135810);
      destroy();
      super.finalize();
      AppMethodBeat.o(135810);
    }
    
    public final void onSelect(String paramString)
    {
      AppMethodBeat.i(135811);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135811);
        throw paramString;
      }
      native_onSelect(this.nativeRef, paramString);
      AppMethodBeat.o(135811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KCountPickerViewOnSelectCallback
 * JD-Core Version:    0.7.0.1
 */