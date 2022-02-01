package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidStringStringBinaryCallback
{
  public abstract void call(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  static final class CppProxy
    extends VoidStringStringBinaryCallback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136063);
      if (!VoidStringStringBinaryCallback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136063);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136059);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136059);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136059);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte);
    
    public final void call(String paramString1, String paramString2, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(136062);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString1 = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136062);
        throw paramString1;
      }
      native_call(this.nativeRef, paramString1, paramString2, paramArrayOfByte);
      AppMethodBeat.o(136062);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136060);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136060);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136061);
      destroy();
      super.finalize();
      AppMethodBeat.o(136061);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidStringStringBinaryCallback
 * JD-Core Version:    0.7.0.1
 */