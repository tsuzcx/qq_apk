package com.tencent.mm.plugin.appbrand.jsruntime;

import java.nio.ByteBuffer;

public abstract interface k
  extends j
{
  public abstract void bufferStoreBindTo(long paramLong1, long paramLong2);
  
  public abstract ByteBuffer getNativeBuffer(int paramInt);
  
  public abstract int getNativeBufferId();
  
  public abstract void setNativeBuffer(int paramInt, ByteBuffer paramByteBuffer);
  
  public abstract boolean supportBufferStoreBindTo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.k
 * JD-Core Version:    0.7.0.1
 */