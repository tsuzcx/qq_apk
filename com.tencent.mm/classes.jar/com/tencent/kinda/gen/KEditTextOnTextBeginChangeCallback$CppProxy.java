package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KEditTextOnTextBeginChangeCallback$CppProxy
  extends KEditTextOnTextBeginChangeCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141315);
    if (!KEditTextOnTextBeginChangeCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141315);
      return;
    }
  }
  
  private KEditTextOnTextBeginChangeCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141311);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141311);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141311);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onTextBeginChange(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(141312);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141312);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141313);
    destroy();
    super.finalize();
    AppMethodBeat.o(141313);
  }
  
  public final void onTextBeginChange(String paramString)
  {
    AppMethodBeat.i(141314);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141314);
      throw paramString;
    }
    native_onTextBeginChange(this.nativeRef, paramString);
    AppMethodBeat.o(141314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KEditTextOnTextBeginChangeCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */