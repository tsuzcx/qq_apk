package com.tencent.liteav.videodecoder;

import com.tencent.liteav.basic.structs.TXSVideoFrame;

public abstract interface c
{
  public abstract void onDecodeFailed(int paramInt);
  
  public abstract void onDecodeFrame(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3);
  
  public abstract void onVideoSizeChange(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.c
 * JD-Core Version:    0.7.0.1
 */