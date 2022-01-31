package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class StringCallback$CppProxy
  extends StringCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141462);
    if (!StringCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141462);
      return;
    }
  }
  
  private StringCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141458);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141458);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141458);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native String native_call(long paramLong);
  
  public final String call()
  {
    AppMethodBeat.i(141461);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      localObject = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141461);
      throw ((Throwable)localObject);
    }
    Object localObject = native_call(this.nativeRef);
    AppMethodBeat.o(141461);
    return localObject;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141459);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141459);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141460);
    destroy();
    super.finalize();
    AppMethodBeat.o(141460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.StringCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */