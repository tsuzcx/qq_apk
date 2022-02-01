package com.tencent.mm.audio.mix.h;

import com.tencent.mm.ai.b;

public abstract interface c
{
  public abstract b ZU();
  
  public abstract String ZV();
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract long getSize();
  
  public abstract int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.c
 * JD-Core Version:    0.7.0.1
 */