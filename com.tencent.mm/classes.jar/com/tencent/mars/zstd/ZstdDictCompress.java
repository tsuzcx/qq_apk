package com.tencent.mars.zstd;

import java.io.Closeable;

public class ZstdDictCompress
  implements Closeable
{
  private long nativePtr = 0L;
  
  public ZstdDictCompress(byte[] paramArrayOfByte, int paramInt)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public ZstdDictCompress(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte.length - paramInt1 < 0) {
      throw new IllegalArgumentException("Dictionary buffer is to short");
    }
    init(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    if (0L == this.nativePtr) {
      throw new IllegalStateException("ZSTD_createCDict failed");
    }
  }
  
  private native void free();
  
  private native void init(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public void close()
  {
    free();
    this.nativePtr = 0L;
  }
  
  protected void finalize()
  {
    close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mars.zstd.ZstdDictCompress
 * JD-Core Version:    0.7.0.1
 */