package com.tencent.mm.appbrand.v8;

import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class BufferURLManager
{
  private volatile long cYE;
  
  public BufferURLManager()
  {
    AppMethodBeat.i(213319);
    this.cYE = 0L;
    this.cYE = nativeCreate();
    c.c.i("BufferURLManager", "BufferURLManager created %d", new Object[] { Long.valueOf(this.cYE) });
    AppMethodBeat.o(213319);
  }
  
  private static native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3);
  
  private static native long nativeCreate();
  
  private static native String nativeCreateBufferURLWithDirectBuffer(long paramLong, ByteBuffer paramByteBuffer);
  
  private static native String nativeCreateBufferURLWithLegacyArrayBuffer(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private static native void nativeDestroy(long paramLong);
  
  private static native ByteBuffer nativeGetBuffer(long paramLong, String paramString);
  
  private static native void nativeRevokeBufferURL(long paramLong, String paramString);
  
  public final void bindTo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(213321);
    c.c.i("BufferURLManager", "BufferURLManager %d %d %d", new Object[] { Long.valueOf(this.cYE), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    nativeBindTo(this.cYE, paramLong1, paramLong2);
    AppMethodBeat.o(213321);
  }
  
  public final ByteBuffer cK(String paramString)
  {
    AppMethodBeat.i(213322);
    if (paramString == null)
    {
      c.c.e("BufferURLManager", "BufferURLManager getBuffer but url is null", new Object[0]);
      AppMethodBeat.o(213322);
      return null;
    }
    paramString = nativeGetBuffer(this.cYE, paramString);
    AppMethodBeat.o(213322);
    return paramString;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(213320);
    c.c.i("BufferURLManager", "BufferURLManager destroying %d", new Object[] { Long.valueOf(this.cYE) });
    nativeDestroy(this.cYE);
    this.cYE = 0L;
    c.c.i("BufferURLManager", "BufferURLManager destroyed %d", new Object[] { Long.valueOf(this.cYE) });
    AppMethodBeat.o(213320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.BufferURLManager
 * JD-Core Version:    0.7.0.1
 */