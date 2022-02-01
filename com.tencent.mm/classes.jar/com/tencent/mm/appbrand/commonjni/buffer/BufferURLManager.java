package com.tencent.mm.appbrand.commonjni.buffer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.c.c;
import java.nio.ByteBuffer;

public class BufferURLManager
{
  private volatile long doL;
  
  public BufferURLManager()
  {
    AppMethodBeat.i(201237);
    this.doL = 0L;
    this.doL = nativeCreate();
    c.c.i("BufferURLManager", "BufferURLManager created %d", new Object[] { Long.valueOf(this.doL) });
    AppMethodBeat.o(201237);
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
    AppMethodBeat.i(201239);
    c.c.i("BufferURLManager", "BufferURLManager %d %d %d", new Object[] { Long.valueOf(this.doL), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    nativeBindTo(this.doL, paramLong1, paramLong2);
    AppMethodBeat.o(201239);
  }
  
  public final ByteBuffer dI(String paramString)
  {
    AppMethodBeat.i(201240);
    if (paramString == null)
    {
      c.c.e("BufferURLManager", "BufferURLManager getBuffer but url is null", new Object[0]);
      AppMethodBeat.o(201240);
      return null;
    }
    paramString = nativeGetBuffer(this.doL, paramString);
    AppMethodBeat.o(201240);
    return paramString;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(201238);
    c.c.i("BufferURLManager", "BufferURLManager destroying %d", new Object[] { Long.valueOf(this.doL) });
    nativeDestroy(this.doL);
    this.doL = 0L;
    c.c.i("BufferURLManager", "BufferURLManager destroyed %d", new Object[] { Long.valueOf(this.doL) });
    AppMethodBeat.o(201238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager
 * JD-Core Version:    0.7.0.1
 */