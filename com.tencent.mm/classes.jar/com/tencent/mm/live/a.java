package com.tencent.mm.live;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.live.b.c.b;

public abstract interface a
  extends d
{
  public abstract b getLiveTipsBarStorage();
  
  public abstract boolean isAnchorLiving();
  
  public abstract boolean isVisitorLiving();
  
  public abstract com.tencent.mm.live.api.a liveEntranceJumper();
  
  public abstract void refreshLiveStatus(long paramLong, String paramString, a parama);
  
  public static abstract interface a
  {
    public abstract void ak(long paramLong, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.a
 * JD-Core Version:    0.7.0.1
 */