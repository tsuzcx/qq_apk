package com.hilive.mediasdk.serialize;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MshByteBufferPool$ByteBufferChunk
{
  public static final int kFreeFlag = 1;
  public int[] mBlockFlags;
  public ByteBuffer[] mBufferBlocks;
  public int mFreeCnt;
  
  public MshByteBufferPool$ByteBufferChunk(MshByteBufferPool paramMshByteBufferPool, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142922);
    this.mBufferBlocks = null;
    this.mBlockFlags = null;
    this.mFreeCnt = 0;
    this.mBufferBlocks = new ByteBuffer[paramInt2];
    this.mBlockFlags = new int[paramInt2];
    this.mFreeCnt = paramInt2;
    while (i < paramInt2)
    {
      this.mBufferBlocks[i] = ByteBuffer.allocate(paramInt1).order(ByteOrder.LITTLE_ENDIAN);
      this.mBlockFlags[i] = 1;
      i += 1;
    }
    AppMethodBeat.o(142922);
  }
  
  public void clear()
  {
    int i = 0;
    while (i < this.mBufferBlocks.length)
    {
      this.mBufferBlocks[i] = null;
      i += 1;
    }
    this.mBufferBlocks = null;
    this.mBlockFlags = null;
  }
  
  public boolean freeBuffer(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(142923);
    int i = 0;
    while (i < this.mBufferBlocks.length)
    {
      if ((paramByteBuffer == this.mBufferBlocks[i]) && ((this.mBlockFlags[i] & 0x1) == 0))
      {
        paramByteBuffer = this.mBlockFlags;
        paramByteBuffer[i] |= 0x1;
        this.mBufferBlocks[i].clear();
        this.mFreeCnt += 1;
        AppMethodBeat.o(142923);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(142923);
    return false;
  }
  
  public ByteBuffer newBuffer()
  {
    int i = 0;
    while (i < this.mBufferBlocks.length)
    {
      if ((this.mBlockFlags[i] & 0x1) != 0)
      {
        int[] arrayOfInt = this.mBlockFlags;
        arrayOfInt[i] &= 0xFFFFFFFE;
        this.mFreeCnt -= 1;
        return this.mBufferBlocks[i];
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.hilive.mediasdk.serialize.MshByteBufferPool.ByteBufferChunk
 * JD-Core Version:    0.7.0.1
 */