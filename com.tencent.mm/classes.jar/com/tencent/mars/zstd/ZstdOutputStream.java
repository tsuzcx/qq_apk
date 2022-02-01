package com.tencent.mars.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ZstdOutputStream
  extends FilterOutputStream
{
  private static final int dstSize = (int)recommendedCOutSize();
  private boolean closeFrameOnFlush;
  private byte[] dict = null;
  private byte[] dst = null;
  private long dstPos = 0L;
  private ZstdDictCompress fastDict = null;
  private boolean frameClosed = true;
  private boolean isClosed = false;
  private int level;
  private long srcPos = 0L;
  private long stream;
  private boolean useChecksum;
  
  public ZstdOutputStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 3, false);
  }
  
  public ZstdOutputStream(OutputStream paramOutputStream, int paramInt)
  {
    this(paramOutputStream, paramInt, false);
  }
  
  public ZstdOutputStream(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
  {
    this(paramOutputStream, paramInt, paramBoolean, false);
  }
  
  public ZstdOutputStream(OutputStream paramOutputStream, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramOutputStream);
    this.closeFrameOnFlush = paramBoolean1;
    this.level = paramInt;
    this.useChecksum = paramBoolean2;
    this.stream = createCStream();
    this.dst = new byte[dstSize];
  }
  
  private native int compressStream(long paramLong, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2);
  
  private static native long createCStream();
  
  private native int endStream(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native int flushStream(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private static native int freeCStream(long paramLong);
  
  private native int initCStream(long paramLong, int paramInt1, int paramInt2);
  
  private native int initCStreamWithDict(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  private native int initCStreamWithFastDict(long paramLong, ZstdDictCompress paramZstdDictCompress, int paramInt);
  
  private static native long recommendedCOutSize();
  
  public void close()
  {
    if (this.isClosed) {
      return;
    }
    if (!this.frameClosed)
    {
      int i = endStream(this.stream, this.dst, dstSize);
      if (Zstd.isError(i)) {
        throw new IOException("Compression error: " + Zstd.getErrorName(i));
      }
      this.out.write(this.dst, 0, (int)this.dstPos);
    }
    freeCStream(this.stream);
    this.out.close();
    this.isClosed = true;
  }
  
  protected void finalize()
  {
    close();
  }
  
  public void flush()
  {
    if (this.isClosed) {
      throw new IOException("Stream closed");
    }
    int i;
    if (!this.frameClosed)
    {
      if (!this.closeFrameOnFlush) {
        break label113;
      }
      i = endStream(this.stream, this.dst, dstSize);
      if (Zstd.isError(i)) {
        throw new IOException("Compression error: " + Zstd.getErrorName(i));
      }
      this.frameClosed = true;
    }
    label113:
    do
    {
      this.out.write(this.dst, 0, (int)this.dstPos);
      this.out.flush();
      return;
      i = flushStream(this.stream, this.dst, dstSize);
    } while (!Zstd.isError(i));
    throw new IOException("Compression error: " + Zstd.getErrorName(i));
  }
  
  public ZstdOutputStream setChecksum(boolean paramBoolean)
  {
    if (!this.frameClosed) {
      throw new IOException("Change of parameter on initialized stream");
    }
    this.useChecksum = paramBoolean;
    return this;
  }
  
  public ZstdOutputStream setDict(ZstdDictCompress paramZstdDictCompress)
  {
    if (!this.frameClosed) {
      throw new IOException("Change of parameter on initialized stream");
    }
    this.dict = null;
    this.fastDict = paramZstdDictCompress;
    return this;
  }
  
  public ZstdOutputStream setDict(byte[] paramArrayOfByte)
  {
    if (!this.frameClosed) {
      throw new IOException("Change of parameter on initialized stream");
    }
    this.fastDict = null;
    this.dict = paramArrayOfByte;
    return this;
  }
  
  public void write(int paramInt)
  {
    write(new byte[] { (byte)paramInt }, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    if (this.isClosed) {
      throw new IOException("Stream closed");
    }
    if (this.frameClosed)
    {
      Object localObject;
      if (this.fastDict != null)
      {
        l = this.stream;
        localObject = this.fastDict;
        if (this.useChecksum) {}
        for (i = j;; i = 0)
        {
          i = initCStreamWithFastDict(l, (ZstdDictCompress)localObject, i);
          if (!Zstd.isError(i)) {
            break;
          }
          throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(i));
        }
      }
      if (this.dict != null)
      {
        l = this.stream;
        localObject = this.dict;
        j = this.dict.length;
        int k = this.level;
        if (this.useChecksum) {}
        for (i = 1;; i = 0)
        {
          i = initCStreamWithDict(l, (byte[])localObject, j, k, i);
          break;
        }
      }
      long l = this.stream;
      j = this.level;
      if (this.useChecksum) {}
      for (;;)
      {
        i = initCStream(l, j, i);
        break;
        i = 0;
      }
      this.frameClosed = false;
    }
    paramInt2 = paramInt1 + paramInt2;
    this.srcPos = paramInt1;
    while (this.srcPos < paramInt2)
    {
      paramInt1 = compressStream(this.stream, this.dst, dstSize, paramArrayOfByte, paramInt2);
      if (Zstd.isError(paramInt1)) {
        throw new IOException("Compression error: " + Zstd.getErrorName(paramInt1));
      }
      if (this.dstPos > 0L) {
        this.out.write(this.dst, 0, (int)this.dstPos);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.zstd.ZstdOutputStream
 * JD-Core Version:    0.7.0.1
 */