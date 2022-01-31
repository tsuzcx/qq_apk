package com.tencent.liteav.audio;

public abstract interface c
{
  public abstract void onPlayError(int paramInt, String paramString);
  
  public abstract void onPlayJitterStateNotify(int paramInt);
  
  public abstract void onPlayPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.audio.c
 * JD-Core Version:    0.7.0.1
 */