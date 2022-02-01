package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.i;
import java.nio.ByteBuffer;

public class NativeBufferJNI
  implements e
{
  private long nativeInst;
  
  static
  {
    AppMethodBeat.i(144016);
    h.class.getClassLoader();
    j.vr("mmv8");
    h.class.getClassLoader();
    j.vr("mmnode");
    h.class.getClassLoader();
    j.vr("mmj2v8");
    AppMethodBeat.o(144016);
  }
  
  public NativeBufferJNI()
  {
    AppMethodBeat.i(144009);
    this.nativeInst = nativeCreate();
    AppMethodBeat.o(144009);
  }
  
  private native void nativeBindTo(long paramLong1, long paramLong2, long paramLong3);
  
  private native long nativeCreate();
  
  private native void nativeDestroy(long paramLong);
  
  private native int nativeGenerateId(long paramLong);
  
  private native byte[] nativeGetBuffer(long paramLong, int paramInt);
  
  private native ByteBuffer nativeGetDirectBuffer(long paramLong, int paramInt);
  
  private native void nativeReleaseDirectBuffer(ByteBuffer paramByteBuffer);
  
  private native void nativeSetBuffer(long paramLong, int paramInt, ByteBuffer paramByteBuffer);
  
  private native void nativeSetBufferForLegacyArray(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2);
  
  public void bindTo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(144010);
    nativeBindTo(this.nativeInst, paramLong1, paramLong2);
    AppMethodBeat.o(144010);
  }
  
  public void bufferStoreBindTo(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(144014);
    bindTo(paramLong1, paramLong2);
    AppMethodBeat.o(144014);
  }
  
  public void destroy() {}
  
  protected void finalize()
  {
    AppMethodBeat.i(144011);
    super.finalize();
    if (this.nativeInst != 0L)
    {
      nativeDestroy(this.nativeInst);
      this.nativeInst = 0L;
    }
    AppMethodBeat.o(144011);
  }
  
  public int generateId()
  {
    AppMethodBeat.i(144012);
    int i = nativeGenerateId(this.nativeInst);
    AppMethodBeat.o(144012);
    return i;
  }
  
  public ByteBuffer getBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221742);
    if (paramBoolean)
    {
      localObject = nativeGetDirectBuffer(this.nativeInst, paramInt);
      AppMethodBeat.o(221742);
      return localObject;
    }
    Object localObject = nativeGetBuffer(this.nativeInst, paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(221742);
      return null;
    }
    localObject = ByteBuffer.wrap((byte[])localObject);
    AppMethodBeat.o(221742);
    return localObject;
  }
  
  public void releaseDirectByteBuffer(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(221743);
    if ((paramByteBuffer != null) && (paramByteBuffer.isDirect()))
    {
      nativeReleaseDirectBuffer(paramByteBuffer);
      AppMethodBeat.o(221743);
      return;
    }
    if (i.DEBUG)
    {
      paramByteBuffer = new IllegalArgumentException("buffer is null or is not direct!");
      AppMethodBeat.o(221743);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(221743);
  }
  
  public void setBuffer(int paramInt, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(144015);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(144015);
      return;
    }
    if (paramByteBuffer.capacity() == 0)
    {
      AppMethodBeat.o(144015);
      return;
    }
    if (paramByteBuffer.isDirect())
    {
      nativeSetBuffer(this.nativeInst, paramInt, paramByteBuffer);
      AppMethodBeat.o(144015);
      return;
    }
    paramByteBuffer = paramByteBuffer.array();
    nativeSetBufferForLegacyArray(this.nativeInst, paramInt, paramByteBuffer, paramByteBuffer.length);
    AppMethodBeat.o(144015);
  }
  
  public boolean supportBufferStoreBindTo()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.NativeBufferJNI
 * JD-Core Version:    0.7.0.1
 */