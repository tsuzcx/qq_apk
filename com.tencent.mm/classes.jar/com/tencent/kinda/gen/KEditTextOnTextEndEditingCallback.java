package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KEditTextOnTextEndEditingCallback
{
  public abstract void onTextEndEditing(String paramString);
  
  static final class CppProxy
    extends KEditTextOnTextEndEditingCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(175907);
      if (!KEditTextOnTextEndEditingCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(175907);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(175903);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(175903);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(175903);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onTextEndEditing(long paramLong, String paramString);
    
    public final void destroy()
    {
      AppMethodBeat.i(175904);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(175904);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(175905);
      destroy();
      super.finalize();
      AppMethodBeat.o(175905);
    }
    
    public final void onTextEndEditing(String paramString)
    {
      AppMethodBeat.i(175906);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(175906);
        throw paramString;
      }
      native_onTextEndEditing(this.nativeRef, paramString);
      AppMethodBeat.o(175906);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KEditTextOnTextEndEditingCallback
 * JD-Core Version:    0.7.0.1
 */