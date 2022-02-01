package com.tencent.mars.zstd;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ZstdDirectBufferCompressingStream
  implements Closeable, Flushable
{
  private boolean closed = false;
  private int consumed = 0;
  private byte[] dict = null;
  private ZstdDictCompress fastDict = null;
  private boolean initialized = false;
  private int level = 3;
  private int produced = 0;
  private final long stream;
  private ByteBuffer target;
  
  public ZstdDirectBufferCompressingStream(ByteBuffer paramByteBuffer, int paramInt)
  {
    this.target = paramByteBuffer;
    this.level = paramInt;
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("Target buffer should be a direct buffer");
    }
    this.stream = createCStream();
  }
  
  private native int compressDirectByteBuffer(long paramLong, ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3, int paramInt4);
  
  private static native long createCStream();
  
  private native int endStream(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  private native int flushStream(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  private static native int freeCStream(long paramLong);
  
  private native int initCStream(long paramLong, int paramInt);
  
  private native int initCStreamWithDict(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native int initCStreamWithFastDict(long paramLong, ZstdDictCompress paramZstdDictCompress);
  
  private static native long recommendedCOutSize();
  
  public static int recommendedOutputBufferSize()
  {
    return (int)recommendedCOutSize();
  }
  
  public void close()
  {
    if (!this.closed)
    {
      int i;
      do
      {
        try
        {
          if (!this.initialized) {
            break;
          }
          i = endStream(this.stream, this.target, this.target.position(), this.target.remaining());
          if (Zstd.isError(i)) {
            throw new IOException("Compression error: " + Zstd.getErrorName(i));
          }
        }
        finally
        {
          freeCStream(this.stream);
          this.closed = true;
          this.initialized = false;
          this.target = null;
        }
        this.target.position(this.target.position() + this.produced);
        this.target = flushBuffer(this.target);
        if (!this.target.isDirect()) {
          throw new IllegalArgumentException("Target buffer should be a direct buffer");
        }
        if ((i > 0) && (!this.target.hasRemaining())) {
          throw new IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
        }
      } while (i > 0);
      freeCStream(this.stream);
      this.closed = true;
      this.initialized = false;
      this.target = null;
    }
  }
  
  public void compress(ByteBuffer paramByteBuffer)
  {
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("Source buffer should be a direct buffer");
    }
    if (this.closed) {
      throw new IOException("Stream closed");
    }
    int i;
    if (!this.initialized)
    {
      if (this.fastDict != null) {
        i = initCStreamWithFastDict(this.stream, this.fastDict);
      }
      while (Zstd.isError(i))
      {
        throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(i));
        if (this.dict != null) {
          i = initCStreamWithDict(this.stream, this.dict, this.dict.length, this.level);
        } else {
          i = initCStream(this.stream, this.level);
        }
      }
      this.initialized = true;
    }
    while (paramByteBuffer.hasRemaining())
    {
      if (!this.target.hasRemaining())
      {
        this.target = flushBuffer(this.target);
        if (!this.target.isDirect()) {
          throw new IllegalArgumentException("Target buffer should be a direct buffer");
        }
        if (!this.target.hasRemaining()) {
          throw new IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
        }
      }
      i = compressDirectByteBuffer(this.stream, this.target, this.target.position(), this.target.remaining(), paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining());
      if (Zstd.isError(i)) {
        throw new IOException("Compression error: " + Zstd.getErrorName(i));
      }
      this.target.position(this.target.position() + this.produced);
      paramByteBuffer.position(paramByteBuffer.position() + this.consumed);
    }
  }
  
  protected void finalize()
  {
    close();
  }
  
  public void flush()
  {
    if ((!this.closed) && (this.initialized))
    {
      int i;
      do
      {
        i = flushStream(this.stream, this.target, this.target.position(), this.target.remaining());
        if (Zstd.isError(i)) {
          throw new IOException("Compression error: " + Zstd.getErrorName(i));
        }
        this.target.position(this.target.position() + this.produced);
        this.target = flushBuffer(this.target);
        if (!this.target.isDirect()) {
          throw new IllegalArgumentException("Target buffer should be a direct buffer");
        }
        if ((i > 0) && (!this.target.hasRemaining())) {
          throw new IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
        }
      } while (i > 0);
    }
  }
  
  protected ByteBuffer flushBuffer(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer;
  }
  
  public ZstdDirectBufferCompressingStream setDict(ZstdDictCompress paramZstdDictCompress)
  {
    if (this.initialized) {
      throw new IOException("Change of parameter on initialized stream");
    }
    this.dict = null;
    this.fastDict = paramZstdDictCompress;
    return this;
  }
  
  public ZstdDirectBufferCompressingStream setDict(byte[] paramArrayOfByte)
  {
    if (this.initialized) {
      throw new IOException("Change of parameter on initialized stream");
    }
    this.dict = paramArrayOfByte;
    this.fastDict = null;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mars.zstd.ZstdDirectBufferCompressingStream
 * JD-Core Version:    0.7.0.1
 */