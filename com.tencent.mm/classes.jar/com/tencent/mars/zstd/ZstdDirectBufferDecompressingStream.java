package com.tencent.mars.zstd;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ZstdDirectBufferDecompressingStream
  implements Closeable
{
  private boolean closed = false;
  private int consumed;
  private byte[] dict = null;
  private ZstdDictDecompress fastDict = null;
  private boolean finishedFrame = false;
  private boolean initialized = false;
  private int produced;
  private ByteBuffer source;
  private final long stream;
  private boolean streamEnd = false;
  
  public ZstdDirectBufferDecompressingStream(ByteBuffer paramByteBuffer)
  {
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("Source buffer should be a direct buffer");
    }
    this.source = paramByteBuffer;
    this.stream = createDStream();
  }
  
  private static native long createDStream();
  
  private native long decompressStream(long paramLong, ByteBuffer paramByteBuffer1, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3, int paramInt4);
  
  private static native int freeDStream(long paramLong);
  
  private native int initDStream(long paramLong);
  
  private native int initDStreamWithDict(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native int initDStreamWithFastDict(long paramLong, ZstdDictDecompress paramZstdDictDecompress);
  
  private void initStream()
  {
    int i;
    if (this.fastDict != null) {
      i = initDStreamWithFastDict(this.stream, this.fastDict);
    }
    while (Zstd.isError(i))
    {
      throw new IOException("Decompression error: " + Zstd.getErrorName(i));
      if (this.dict != null) {
        i = initDStreamWithDict(this.stream, this.dict, this.dict.length);
      } else {
        i = initDStream(this.stream);
      }
    }
    this.initialized = true;
  }
  
  private static native int recommendedDOutSize();
  
  public static int recommendedTargetBufferSize()
  {
    return recommendedDOutSize();
  }
  
  public void close()
  {
    if (!this.closed) {}
    try
    {
      if (this.initialized) {
        freeDStream(this.stream);
      }
      return;
    }
    finally
    {
      this.closed = true;
      this.initialized = false;
    }
  }
  
  protected void finalize()
  {
    if ((!this.closed) && (this.initialized)) {
      freeDStream(this.stream);
    }
    this.source = null;
  }
  
  public boolean hasRemaining()
  {
    return (!this.streamEnd) && ((this.source.hasRemaining()) || (!this.finishedFrame));
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    boolean bool = false;
    if (!paramByteBuffer.isDirect()) {
      throw new IllegalArgumentException("Target buffer should be a direct buffer");
    }
    if (this.closed) {
      throw new IOException("Stream closed");
    }
    if (this.streamEnd) {
      return 0;
    }
    if (!this.initialized) {
      initStream();
    }
    long l = decompressStream(this.stream, paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining(), this.source, this.source.position(), this.source.remaining());
    if (Zstd.isError(l)) {
      throw new IOException(Zstd.getErrorName(l));
    }
    this.source.position(this.source.position() + this.consumed);
    paramByteBuffer.position(paramByteBuffer.position() + this.produced);
    if (!this.source.hasRemaining())
    {
      this.source = refill(this.source);
      if (!this.source.isDirect()) {
        throw new IllegalArgumentException("Source buffer should be a direct buffer");
      }
    }
    if (l == 0L) {
      bool = true;
    }
    this.finishedFrame = bool;
    if (this.finishedFrame)
    {
      if (!this.source.hasRemaining()) {
        break label226;
      }
      initStream();
    }
    for (;;)
    {
      return this.produced;
      label226:
      this.streamEnd = true;
    }
  }
  
  protected ByteBuffer refill(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer;
  }
  
  public ZstdDirectBufferDecompressingStream setDict(ZstdDictDecompress paramZstdDictDecompress)
  {
    if (this.initialized) {
      throw new IOException("Change of parameter on initialized stream");
    }
    this.fastDict = paramZstdDictDecompress;
    this.dict = null;
    return this;
  }
  
  public ZstdDirectBufferDecompressingStream setDict(byte[] paramArrayOfByte)
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
 * Qualified Name:     com.tencent.mars.zstd.ZstdDirectBufferDecompressingStream
 * JD-Core Version:    0.7.0.1
 */