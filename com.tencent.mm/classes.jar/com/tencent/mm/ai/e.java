package com.tencent.mm.ai;

import java.io.Closeable;

public abstract interface e
  extends Closeable
{
  public abstract int aYm();
  
  public abstract long getSize();
  
  public abstract boolean isOpen();
  
  public abstract void open();
  
  public abstract int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ai.e
 * JD-Core Version:    0.7.0.1
 */