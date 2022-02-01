package com.danikula.videocache;

public abstract interface Source
{
  public abstract void close();
  
  public abstract long length();
  
  public abstract void open(long paramLong);
  
  public abstract int read(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.Source
 * JD-Core Version:    0.7.0.1
 */