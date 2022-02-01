package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KEditTextOnEditorActionCallback
{
  public abstract void onEditorAction(KeyEvent paramKeyEvent);
  
  static final class CppProxy
    extends KEditTextOnEditorActionCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(219715);
      if (!KEditTextOnEditorActionCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(219715);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(219707);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(219707);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(219707);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onEditorAction(long paramLong, KeyEvent paramKeyEvent);
    
    public final void destroy()
    {
      AppMethodBeat.i(219709);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(219709);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(219711);
      destroy();
      super.finalize();
      AppMethodBeat.o(219711);
    }
    
    public final void onEditorAction(KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(219713);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramKeyEvent = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(219713);
        throw paramKeyEvent;
      }
      native_onEditorAction(this.nativeRef, paramKeyEvent);
      AppMethodBeat.o(219713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KEditTextOnEditorActionCallback
 * JD-Core Version:    0.7.0.1
 */