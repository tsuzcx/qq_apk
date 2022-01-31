package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

final class KNetworkMockManager$CppProxy
  extends KNetworkMockManager
{
  private final AtomicBoolean destroyed;
  private final long nativeRef;
  
  static
  {
    AppMethodBeat.i(141353);
    if (!KNetworkMockManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(141353);
      return;
    }
  }
  
  private KNetworkMockManager$CppProxy(long paramLong)
  {
    AppMethodBeat.i(141346);
    this.destroyed = new AtomicBoolean(false);
    if (paramLong == 0L)
    {
      RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
      AppMethodBeat.o(141346);
      throw localRuntimeException;
    }
    this.nativeRef = paramLong;
    AppMethodBeat.o(141346);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native byte[] native_jsonToRequestData(long paramLong, String paramString);
  
  private native byte[] native_jsonToResponseData(long paramLong, String paramString);
  
  private native String native_requestDataToJson(long paramLong, byte[] paramArrayOfByte);
  
  private native String native_responseDataToJson(long paramLong, byte[] paramArrayOfByte);
  
  public final void destroy()
  {
    AppMethodBeat.i(141347);
    if (!this.destroyed.getAndSet(true)) {
      nativeDestroy(this.nativeRef);
    }
    AppMethodBeat.o(141347);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(141348);
    destroy();
    super.finalize();
    AppMethodBeat.o(141348);
  }
  
  public final byte[] jsonToRequestData(String paramString)
  {
    AppMethodBeat.i(141352);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141352);
      throw paramString;
    }
    paramString = native_jsonToRequestData(this.nativeRef, paramString);
    AppMethodBeat.o(141352);
    return paramString;
  }
  
  public final byte[] jsonToResponseData(String paramString)
  {
    AppMethodBeat.i(141351);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramString = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141351);
      throw paramString;
    }
    paramString = native_jsonToResponseData(this.nativeRef, paramString);
    AppMethodBeat.o(141351);
    return paramString;
  }
  
  public final String requestDataToJson(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(141349);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramArrayOfByte = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141349);
      throw paramArrayOfByte;
    }
    paramArrayOfByte = native_requestDataToJson(this.nativeRef, paramArrayOfByte);
    AppMethodBeat.o(141349);
    return paramArrayOfByte;
  }
  
  public final String responseDataToJson(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(141350);
    if ((!$assertionsDisabled) && (this.destroyed.get()))
    {
      paramArrayOfByte = new AssertionError("trying to use a destroyed object");
      AppMethodBeat.o(141350);
      throw paramArrayOfByte;
    }
    paramArrayOfByte = native_responseDataToJson(this.nativeRef, paramArrayOfByte);
    AppMethodBeat.o(141350);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KNetworkMockManager.CppProxy
 * JD-Core Version:    0.7.0.1
 */