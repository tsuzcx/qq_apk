package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KMoneyInputTextOnkeyBoardVisibleAnchorCallback
{
  public abstract KView onkeyBoardVisibleAnchor();
  
  static final class CppProxy
    extends KMoneyInputTextOnkeyBoardVisibleAnchorCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135857);
      if (!KMoneyInputTextOnkeyBoardVisibleAnchorCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135857);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135853);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135853);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135853);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native KView native_onkeyBoardVisibleAnchor(long paramLong);
    
    public final void destroy()
    {
      AppMethodBeat.i(135854);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135854);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135855);
      destroy();
      super.finalize();
      AppMethodBeat.o(135855);
    }
    
    public final KView onkeyBoardVisibleAnchor()
    {
      AppMethodBeat.i(135856);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        localObject = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135856);
        throw ((Throwable)localObject);
      }
      Object localObject = native_onkeyBoardVisibleAnchor(this.nativeRef);
      AppMethodBeat.o(135856);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KMoneyInputTextOnkeyBoardVisibleAnchorCallback
 * JD-Core Version:    0.7.0.1
 */