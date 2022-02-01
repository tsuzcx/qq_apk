package com.tencent.mm.appbrand.commonjni.buffer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.c.c;
import java.nio.ByteBuffer;

public class BufferURLManager
{
  private volatile long mInst;
  
  public BufferURLManager()
  {
    AppMethodBeat.i(238534);
    this.mInst = 0L;
    this.mInst = nativeCreate();
    c.c.i("BufferURLManager", "BufferURLManager created %d", new Object[] { Long.valueOf(this.mInst) });
    AppMethodBeat.o(238534);
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
    AppMethodBeat.i(238573);
    c.c.i("BufferURLManager", "BufferURLManager %d %d %d", new Object[] { Long.valueOf(this.mInst), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    nativeBindTo(this.mInst, paramLong1, paramLong2);
    AppMethodBeat.o(238573);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(238569);
    c.c.i("BufferURLManager", "BufferURLManager destroying %d", new Object[] { Long.valueOf(this.mInst) });
    nativeDestroy(this.mInst);
    this.mInst = 0L;
    c.c.i("BufferURLManager", "BufferURLManager destroyed %d", new Object[] { Long.valueOf(this.mInst) });
    AppMethodBeat.o(238569);
  }
  
  public final ByteBuffer fu(String paramString)
  {
    AppMethodBeat.i(238576);
    if (paramString == null)
    {
      c.c.e("BufferURLManager", "BufferURLManager getBuffer but url is null", new Object[0]);
      AppMethodBeat.o(238576);
      return null;
    }
    paramString = nativeGetBuffer(this.mInst, paramString);
    AppMethodBeat.o(238576);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.appbrand.commonjni.buffer.BufferURLManager
 * JD-Core Version:    0.7.0.1
 */