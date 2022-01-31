package com.tencent.liteav.network;

import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;

public abstract interface f
{
  public abstract void onPullAudio(a parama);
  
  public abstract void onPullNAL(TXSNALPacket paramTXSNALPacket);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.f
 * JD-Core Version:    0.7.0.1
 */