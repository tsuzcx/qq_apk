package com.hilive.mediasdk.serialize;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MshBuffer
{
  public ByteBuffer mByteBuffer;
  public MshByteBufferPool mBytePool;
  
  public MshBuffer(int paramInt, MshByteBufferPool paramMshByteBufferPool)
  {
    AppMethodBeat.i(142918);
    this.mByteBuffer = null;
    this.mBytePool = null;
    this.mBytePool = paramMshByteBufferPool;
    if (paramMshByteBufferPool == null)
    {
      this.mByteBuffer = ByteBuffer.allocate(paramInt);
      this.mByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      AppMethodBeat.o(142918);
      return;
    }
    this.mByteBuffer = paramMshByteBufferPool.newBuffer(paramInt);
    AppMethodBeat.o(142918);
  }
  
  public void freeBuffer()
  {
    AppMethodBeat.i(142919);
    if (this.mBytePool != null)
    {
      this.mBytePool.freeBuffer(this.mByteBuffer);
      this.mByteBuffer = null;
    }
    AppMethodBeat.o(142919);
  }
  
  public ByteBuffer getByteBuffer()
  {
    return this.mByteBuffer;
  }
  
  public int increase_capacity(int paramInt)
  {
    AppMethodBeat.i(142920);
    int j = this.mByteBuffer.capacity();
    if (j == 0)
    {
      AppMethodBeat.o(142920);
      return 0;
    }
    int i = j * 2;
    if (paramInt > j) {
      i = j + paramInt;
    }
    ByteBuffer localByteBuffer;
    if (this.mBytePool == null)
    {
      localByteBuffer = ByteBuffer.allocate(i);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      this.mByteBuffer.limit(this.mByteBuffer.position());
      this.mByteBuffer.position(0);
      localByteBuffer.put(this.mByteBuffer);
    }
    for (this.mByteBuffer = localByteBuffer;; this.mByteBuffer = localByteBuffer)
    {
      AppMethodBeat.o(142920);
      return i;
      localByteBuffer = this.mBytePool.newBuffer(i);
      this.mByteBuffer.limit(this.mByteBuffer.position());
      this.mByteBuffer.position(0);
      localByteBuffer.put(this.mByteBuffer);
      this.mBytePool.freeBuffer(this.mByteBuffer);
    }
  }
  
  public void wrap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(142921);
    if ((this.mByteBuffer != null) && (this.mBytePool != null)) {
      this.mBytePool.freeBuffer(this.mByteBuffer);
    }
    this.mByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    this.mByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    this.mBytePool = null;
    AppMethodBeat.o(142921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.hilive.mediasdk.serialize.MshBuffer
 * JD-Core Version:    0.7.0.1
 */