package com.tencent.mars.zstd;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZstdDictTrainer
{
  private final int allocatedSize;
  private final int dictSize;
  private long filledSize;
  private final List<Integer> sampleSizes;
  private final ByteBuffer trainingSamples;
  
  public ZstdDictTrainer(int paramInt1, int paramInt2)
  {
    this.trainingSamples = ByteBuffer.allocateDirect(paramInt1);
    this.sampleSizes = new ArrayList();
    this.allocatedSize = paramInt1;
    this.dictSize = paramInt2;
  }
  
  private int[] copyToIntArray(List<Integer> paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      arrayOfInt[i] = ((Integer)paramList.next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public boolean addSample(byte[] paramArrayOfByte)
  {
    if (this.filledSize + paramArrayOfByte.length > this.allocatedSize) {
      return false;
    }
    this.trainingSamples.put(paramArrayOfByte);
    this.sampleSizes.add(Integer.valueOf(paramArrayOfByte.length));
    this.filledSize += paramArrayOfByte.length;
    return true;
  }
  
  public byte[] trainSamples()
  {
    return trainSamples(false);
  }
  
  public byte[] trainSamples(boolean paramBoolean)
  {
    ByteBuffer localByteBuffer = trainSamplesDirect(paramBoolean);
    byte[] arrayOfByte = new byte[localByteBuffer.remaining()];
    localByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
  
  public ByteBuffer trainSamplesDirect()
  {
    return trainSamplesDirect(false);
  }
  
  public ByteBuffer trainSamplesDirect(boolean paramBoolean)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.dictSize);
    long l = Zstd.trainFromBufferDirect(this.trainingSamples, copyToIntArray(this.sampleSizes), localByteBuffer, paramBoolean);
    if (Zstd.isError(l))
    {
      localByteBuffer.limit(0);
      return null;
    }
    localByteBuffer.limit(Long.valueOf(l).intValue());
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mars.zstd.ZstdDictTrainer
 * JD-Core Version:    0.7.0.1
 */