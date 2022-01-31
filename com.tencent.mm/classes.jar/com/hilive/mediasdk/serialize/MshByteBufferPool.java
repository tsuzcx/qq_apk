package com.hilive.mediasdk.serialize;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;

public class MshByteBufferPool
{
  static final int kSize16K = 16384;
  static final int kSize32K = 32768;
  static final int kSize4K = 4096;
  static final int kSize8K = 8192;
  private HashSet<ByteBuffer> mBigBuffers;
  private MshByteBufferPool.ByteBufferChunk mBuffer16K;
  private MshByteBufferPool.ByteBufferChunk mBuffer32K;
  private MshByteBufferPool.ByteBufferChunk mBuffer4K;
  private MshByteBufferPool.ByteBufferChunk mBuffer8K;
  
  public MshByteBufferPool()
  {
    AppMethodBeat.i(142924);
    this.mBuffer4K = null;
    this.mBuffer8K = null;
    this.mBuffer16K = null;
    this.mBuffer32K = null;
    this.mBigBuffers = null;
    this.mBuffer4K = new MshByteBufferPool.ByteBufferChunk(this, 4096, 8);
    this.mBuffer8K = new MshByteBufferPool.ByteBufferChunk(this, 8192, 6);
    this.mBuffer16K = new MshByteBufferPool.ByteBufferChunk(this, 16384, 4);
    this.mBuffer32K = new MshByteBufferPool.ByteBufferChunk(this, 32768, 2);
    this.mBigBuffers = new HashSet();
    AppMethodBeat.o(142924);
  }
  
  private MshByteBufferPool.ByteBufferChunk getBuffers(int paramInt)
  {
    if (paramInt < 0) {}
    do
    {
      return null;
      if (paramInt <= 4096) {
        return this.mBuffer4K;
      }
      if (paramInt <= 8192) {
        return this.mBuffer8K;
      }
      if (paramInt <= 16384) {
        return this.mBuffer16K;
      }
    } while (paramInt > 32768);
    return this.mBuffer32K;
  }
  
  public void clear()
  {
    AppMethodBeat.i(142927);
    try
    {
      this.mBigBuffers.clear();
      this.mBigBuffers = null;
      this.mBuffer4K.clear();
      this.mBuffer8K.clear();
      this.mBuffer16K.clear();
      this.mBuffer32K.clear();
      this.mBuffer4K = null;
      this.mBuffer8K = null;
      this.mBuffer16K = null;
      this.mBuffer32K = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(142927);
    }
  }
  
  public void freeBuffer(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(142926);
    try
    {
      MshByteBufferPool.ByteBufferChunk localByteBufferChunk = getBuffers(paramByteBuffer.capacity());
      if ((localByteBufferChunk == null) || (!localByteBufferChunk.freeBuffer(paramByteBuffer))) {
        this.mBigBuffers.remove(paramByteBuffer);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(142926);
    }
  }
  
  public ByteBuffer newBuffer(int paramInt)
  {
    AppMethodBeat.i(142925);
    try
    {
      Object localObject1 = getBuffers(paramInt);
      if ((localObject1 != null) && (((MshByteBufferPool.ByteBufferChunk)localObject1).mFreeCnt > 0))
      {
        localObject1 = ((MshByteBufferPool.ByteBufferChunk)localObject1).newBuffer();
        return localObject1;
      }
      localObject1 = ByteBuffer.allocate(paramInt).order(ByteOrder.LITTLE_ENDIAN);
      this.mBigBuffers.add(localObject1);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(142925);
    }
  }
  
  public int totalSize()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.hilive.mediasdk.serialize.MshByteBufferPool
 * JD-Core Version:    0.7.0.1
 */