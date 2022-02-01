package com.tencent.mm.live;

import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.live.model.c.c;

public abstract interface a
  extends d
{
  public abstract long curLiveId();
  
  public abstract void forceStopCurLive(Context paramContext);
  
  public abstract c getLiveTipsBarStorage();
  
  public abstract String getLivingRoomId();
  
  public abstract boolean isAnchorLiving();
  
  public abstract boolean isVisitorLiving();
  
  public abstract com.tencent.mm.live.api.a liveEntranceJumper();
  
  public abstract void refreshLiveStatus(long paramLong, String paramString, a.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.a
 * JD-Core Version:    0.7.0.1
 */