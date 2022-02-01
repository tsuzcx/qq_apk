package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidStringBinaryCallback
{
  public abstract void call(String paramString, byte[] paramArrayOfByte);
  
  static final class CppProxy
    extends VoidStringBinaryCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(226772);
      if (!VoidStringBinaryCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(226772);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(226771);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(226771);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(226771);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, String paramString, byte[] paramArrayOfByte);
    
    public final void call(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(226775);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(226775);
        throw paramString;
      }
      native_call(this.nativeRef, paramString, paramArrayOfByte);
      AppMethodBeat.o(226775);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(226773);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(226773);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(226774);
      destroy();
      super.finalize();
      AppMethodBeat.o(226774);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidStringBinaryCallback
 * JD-Core Version:    0.7.0.1
 */