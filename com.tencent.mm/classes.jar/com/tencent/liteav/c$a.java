package com.tencent.liteav;

import android.media.MediaFormat;
import com.tencent.liteav.basic.f.b;

public abstract interface c$a
{
  public abstract void onEncAudio(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2);
  
  public abstract void onEncVideo(b paramb);
  
  public abstract void onEncVideoFormat(MediaFormat paramMediaFormat);
  
  public abstract void onRecordPcm(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onRecordRawPcm(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.c.a
 * JD-Core Version:    0.7.0.1
 */