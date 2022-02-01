package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class KNetworkMockManager
{
  public static native HashMap<Integer, String> getCgiList();
  
  public abstract byte[] jsonToRequestData(String paramString);
  
  public abstract byte[] jsonToResponseData(String paramString);
  
  public abstract String requestDataToJson(byte[] paramArrayOfByte);
  
  public abstract String responseDataToJson(byte[] paramArrayOfByte);
  
  static final class CppProxy
    extends KNetworkMockManager
  {
    private final AtomicBoolean destroyed;
    private final long nativeRef;
    
    static
    {
      AppMethodBeat.i(135865);
      if (!KNetworkMockManager.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(135865);
        return;
      }
    }
    
    private CppProxy(long paramLong)
    {
      AppMethodBeat.i(135858);
      this.destroyed = new AtomicBoolean(false);
      if (paramLong == 0L)
      {
        RuntimeException localRuntimeException = new RuntimeException("nativeRef is zero");
        AppMethodBeat.o(135858);
        throw localRuntimeException;
      }
      this.nativeRef = paramLong;
      AppMethodBeat.o(135858);
    }
    
    private native void nativeDestroy(long paramLong);
    
    private native byte[] native_jsonToRequestData(long paramLong, String paramString);
    
    private native byte[] native_jsonToResponseData(long paramLong, String paramString);
    
    private native String native_requestDataToJson(long paramLong, byte[] paramArrayOfByte);
    
    private native String native_responseDataToJson(long paramLong, byte[] paramArrayOfByte);
    
    public final void destroy()
    {
      AppMethodBeat.i(135859);
      if (!this.destroyed.getAndSet(true)) {
        nativeDestroy(this.nativeRef);
      }
      AppMethodBeat.o(135859);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(135860);
      destroy();
      super.finalize();
      AppMethodBeat.o(135860);
    }
    
    public final byte[] jsonToRequestData(String paramString)
    {
      AppMethodBeat.i(135864);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135864);
        throw paramString;
      }
      paramString = native_jsonToRequestData(this.nativeRef, paramString);
      AppMethodBeat.o(135864);
      return paramString;
    }
    
    public final byte[] jsonToResponseData(String paramString)
    {
      AppMethodBeat.i(135863);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramString = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135863);
        throw paramString;
      }
      paramString = native_jsonToResponseData(this.nativeRef, paramString);
      AppMethodBeat.o(135863);
      return paramString;
    }
    
    public final String requestDataToJson(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(135861);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramArrayOfByte = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135861);
        throw paramArrayOfByte;
      }
      paramArrayOfByte = native_requestDataToJson(this.nativeRef, paramArrayOfByte);
      AppMethodBeat.o(135861);
      return paramArrayOfByte;
    }
    
    public final String responseDataToJson(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(135862);
      if ((!$assertionsDisabled) && (this.destroyed.get()))
      {
        paramArrayOfByte = new AssertionError("trying to use a destroyed object");
        AppMethodBeat.o(135862);
        throw paramArrayOfByte;
      }
      paramArrayOfByte = native_responseDataToJson(this.nativeRef, paramArrayOfByte);
      AppMethodBeat.o(135862);
      return paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.KNetworkMockManager
 * JD-Core Version:    0.7.0.1
 */