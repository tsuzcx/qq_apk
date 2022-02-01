package com.tencent.mm.appbrand.commonjni.buffer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.c.c;
import java.nio.ByteBuffer;

public class BufferURLManager
{
  private volatile long fhr;
  
  public BufferURLManager()
  {
    AppMethodBeat.i(246824);
    this.fhr = 0L;
    this.fhr = nativeCreate();
    c.c.i("BufferURLManager", "BufferURLManager created %d", new Object[] { Long.valueOf(this.fhr) });
    AppMethodBeat.o(246824);
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
    AppMethodBeat.i(246827);
    c.c.i("BufferURLManager", "BufferURLManager %d %d %d", new Object[] { Long.valueOf(this.fhr), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    nativeBindTo(this.fhr, paramLong1, paramLong2);
    AppMethodBeat.o(246827);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(246826);
    c.c.i("BufferURLManager", "BufferURLManager destroying %d", new Object[] { Long.valueOf(this.fhr) });
    nativeDestroy(this.fhr);
    this.fhr = 0L;
    c.c.i("BufferURLManager", "BufferURLManager destroyed %d", new Object[] { Long.valueOf(this.fhr) });
    AppMethodBeat.o(246826);
  }
  
  public final ByteBuffer eb(String paramString)
  {
    AppMethodBeat.i(246828);
    if (paramString == null)
    {
      c.c.e("BufferURLManager", "BufferURLManager getBuffer but url is null", new Object[0]);
      AppMethodBeat.o(246828);
      return null;
    }
    paramString = nativeGetBuffer(this.fhr, paramString);
    AppMethodBeat.o(246828);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager
 * JD-Core Version:    0.7.0.1
 */