package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KProfessionEditViewOnSelectProfessionCallback
{
  public abstract void onSelectProfession(String paramString, int paramInt);
  
  static final class CppProxy
    extends KProfessionEditViewOnSelectProfessionCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135871);
      if (!KProfessionEditViewOnSelectProfessionCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135871);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135867);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135867);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135867);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_onSelectProfession(long paramLong, String paramString, int paramInt);
    
    public final void destroy()
    {
      AppMethodBeat.i(135868);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135868);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135869);
      destroy();
      super.finalize();
      AppMethodBeat.o(135869);
    }
    
    public final void onSelectProfession(String paramString, int paramInt)
    {
      AppMethodBeat.i(135870);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135870);
        throw paramString;
      }
      native_onSelectProfession(this.nativeRef, paramString, paramInt);
      AppMethodBeat.o(135870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KProfessionEditViewOnSelectProfessionCallback
 * JD-Core Version:    0.7.0.1
 */