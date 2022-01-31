package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KCountPickerViewOnSelectCallback$CppProxy
  extends KCountPickerViewOnSelectCallback
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141300);
    if (!KCountPickerViewOnSelectCallback.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141300);
      return;
    }
  }
  
  private KCountPickerViewOnSelectCallback$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141296);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141296);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141296);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native void native_onSelect(long paramLong, String paramString);
  
  public final void destroy()
  {
    AppMethodBeat.i(141297);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141297);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141298);
    destroy();
    super.finalize();
    AppMethodBeat.o(141298);
  }
  
  public final void onSelect(String paramString)
  {
    AppMethodBeat.i(141299);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141299);
      throw paramString;
    }
    native_onSelect(this.nativeRef, paramString);
    AppMethodBeat.o(141299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.gen.KCountPickerViewOnSelectCallback.CppProxy
 * JD-Core Version:    0.7.0.1
 */