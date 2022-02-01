package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KEditTextOnTextBeginChangeCallback
{
  public abstract void onTextBeginChange(String paramString);
  
  static final class CppProxy
    extends KEditTextOnTextBeginChangeCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135827);
      if (!KEditTextOnTextBeginChangeCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135827);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135823);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135823);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135823);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onTextBeginChange(long paramLong, String paramString);
    
    public final void destroy()
    {
      AppMethodBeat.i(135824);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135824);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135825);
      destroy();
      super.finalize();
      AppMethodBeat.o(135825);
    }
    
    public final void onTextBeginChange(String paramString)
    {
      AppMethodBeat.i(135826);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135826);
        throw paramString;
      }
      native_onTextBeginChange(this.nativeRef, paramString);
      AppMethodBeat.o(135826);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KEditTextOnTextBeginChangeCallback
 * JD-Core Version:    0.7.0.1
 */