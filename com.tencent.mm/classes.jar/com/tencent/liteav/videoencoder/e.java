package com.tencent.liteav.videoencoder;

import android.media.MediaFormat;
import com.tencent.liteav.basic.structs.TXSNALPacket;

public abstract interface e
{
  public abstract void a(int paramInt, long paramLong1, long paramLong2);
  
  public abstract void a(MediaFormat paramMediaFormat);
  
  public abstract void a(TXSNALPacket paramTXSNALPacket, int paramInt);
  
  public abstract void l(int paramInt);
  
  public abstract void m(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.e
 * JD-Core Version:    0.7.0.1
 */