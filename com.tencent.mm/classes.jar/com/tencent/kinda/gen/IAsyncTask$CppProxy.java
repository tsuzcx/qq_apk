package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class IAsyncTask$CppProxy
  extends IAsyncTask
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141206);
    if (!IAsyncTask.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141206);
      return;
    }
  }
  
  private IAsyncTask$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141202);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141202);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141202);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_execute(long paramLong);
  
  public final void destroy()
  {
    AppMethodBeat.i(141203);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141203);
  }
  
  public final void execute()
  {
    AppMethodBeat.i(141205);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      AssertionError localAssertionError = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141205);
      throw localAssertionError;
    }
    native_execute(this.nativeRef);
    AppMethodBeat.o(141205);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141204);
    destroy();
    super.finalize();
    AppMethodBeat.o(141204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.IAsyncTask.CppProxy
 * JD-Core Version:    0.7.0.1
 */