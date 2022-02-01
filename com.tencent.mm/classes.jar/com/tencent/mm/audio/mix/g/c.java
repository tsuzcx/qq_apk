package com.tencent.mm.audio.mix.g;

import com.tencent.mm.al.b;

public abstract interface c
{
  public abstract b aeD();
  
  public abstract String aeE();
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract long getSize();
  
  public abstract int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.g.c
 * JD-Core Version:    0.7.0.1
 */