package com.tencent.maas.camerafun;

import java.nio.ByteBuffer;

public class MJVideoFrame
{
  private final ByteBuffer buffer;
  private final int frameCWAngle;
  private final int height;
  private final int pixelStride;
  private final int rowStride;
  private final long timestamp;
  private final int width;
  
  public MJVideoFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer, int paramInt5, long paramLong)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.rowStride = paramInt3;
    this.pixelStride = paramInt4;
    this.buffer = paramByteBuffer;
    this.frameCWAngle = paramInt5;
    this.timestamp = paramLong;
  }
  
  public ByteBuffer getBuffer()
  {
    return this.buffer;
  }
  
  public int getFrameCWAngle()
  {
    return this.frameCWAngle;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getPixelStride()
  {
    return this.pixelStride;
  }
  
  public int getRowStride()
  {
    return this.rowStride;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public int getWidth()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.camerafun.MJVideoFrame
 * JD-Core Version:    0.7.0.1
 */