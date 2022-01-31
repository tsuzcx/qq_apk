package com.tencent.mm.ag;

import java.io.Closeable;

public abstract interface e
  extends Closeable
{
  public abstract int acP();
  
  public abstract long getSize();
  
  public abstract boolean isOpen();
  
  public abstract void open();
  
  public abstract int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ag.e
 * JD-Core Version:    0.7.0.1
 */