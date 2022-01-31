package com.tencent.liteav.videoencoder;

import android.media.MediaFormat;
import com.tencent.liteav.basic.structs.TXSNALPacket;

public abstract interface d
{
  public abstract void a(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void a(MediaFormat paramMediaFormat);
  
  public abstract void a(TXSNALPacket paramTXSNALPacket, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.d
 * JD-Core Version:    0.7.0.1
 */