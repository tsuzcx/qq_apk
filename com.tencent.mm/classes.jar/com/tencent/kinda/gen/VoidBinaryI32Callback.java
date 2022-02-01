package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class VoidBinaryI32Callback
{
  public abstract void call(byte[] paramArrayOfByte, int paramInt);
  
  static final class CppProxy
    extends VoidBinaryI32Callback
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(136013);
      if (!VoidBinaryI32Callback.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(136013);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(136009);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(136009);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(136009);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native void native_call(long paramLong, byte[] paramArrayOfByte, int paramInt);
    
    public final void call(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(136012);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramArrayOfByte = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(136012);
        throw paramArrayOfByte;
      }
      native_call(this.nativeRef, paramArrayOfByte, paramInt);
      AppMethodBeat.o(136012);
    }
    
    public final void destroy()
    {
      AppMethodBeat.i(136010);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(136010);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(136011);
      destroy();
      super.finalize();
      AppMethodBeat.o(136011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBinaryI32Callback
 * JD-Core Version:    0.7.0.1
 */