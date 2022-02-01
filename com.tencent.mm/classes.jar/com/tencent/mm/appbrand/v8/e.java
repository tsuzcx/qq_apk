package com.tencent.mm.appbrand.v8;

import java.nio.ByteBuffer;

public abstract interface e
{
  public abstract void bufferStoreBindTo(long paramLong1, long paramLong2);
  
  public abstract int generateId();
  
  public abstract ByteBuffer getBuffer(int paramInt);
  
  public abstract void setBuffer(int paramInt, ByteBuffer paramByteBuffer);
  
  public abstract boolean supportBufferStoreBindTo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.e
 * JD-Core Version:    0.7.0.1
 */