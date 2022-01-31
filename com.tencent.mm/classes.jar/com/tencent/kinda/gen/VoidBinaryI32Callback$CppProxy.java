package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class VoidBinaryI32Callback$CppProxy
  extends VoidBinaryI32Callback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141493);
    if (!VoidBinaryI32Callback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141493);
      return;
    }
  }
  
  private VoidBinaryI32Callback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141489);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141489);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141489);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_call(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  public final void call(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(141492);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramArrayOfByte = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141492);
      throw paramArrayOfByte;
    }
    native_call(this.nativeRef, paramArrayOfByte, paramInt);
    AppMethodBeat.o(141492);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141490);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141490);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141491);
    destroy();
    super.finalize();
    AppMethodBeat.o(141491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.VoidBinaryI32Callback.CppProxy
 * JD-Core Version:    0.7.0.1
 */