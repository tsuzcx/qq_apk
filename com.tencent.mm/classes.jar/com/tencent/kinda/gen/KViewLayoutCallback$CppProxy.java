package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KViewLayoutCallback$CppProxy
  extends KViewLayoutCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141407);
    if (!KViewLayoutCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141407);
      return;
    }
  }
  
  private KViewLayoutCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141403);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141403);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141403);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native KViewLayout native_call(long paramLong);
  
  public final KViewLayout call()
  {
    AppMethodBeat.i(141406);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      localObject = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141406);
      throw ((Throwable)localObject);
    }
    Object localObject = native_call(this.nativeRef);
    AppMethodBeat.o(141406);
    return localObject;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(141404);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141404);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141405);
    destroy();
    super.finalize();
    AppMethodBeat.o(141405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KViewLayoutCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */