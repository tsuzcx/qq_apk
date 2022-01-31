package com.tencent.liteav.audio;

import com.tencent.liteav.basic.f.a;

public abstract interface d
{
  public abstract void onPlayAudioInfoChanged(a parama1, a parama2);
  
  public abstract void onPlayError(int paramInt, String paramString);
  
  public abstract void onPlayJitterStateNotify(int paramInt);
  
  public abstract void onPlayPcmData(byte[] paramArrayOfByte, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.audio.d
 * JD-Core Version:    0.7.0.1
 */