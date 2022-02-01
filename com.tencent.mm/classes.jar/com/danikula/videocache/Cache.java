package com.danikula.videocache;

public abstract interface Cache
{
  public abstract void append(byte[] paramArrayOfByte, int paramInt);
  
  public abstract long available();
  
  public abstract void close();
  
  public abstract void complete();
  
  public abstract boolean isCompleted();
  
  public abstract int read(byte[] paramArrayOfByte, long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.Cache
 * JD-Core Version:    0.7.0.1
 */