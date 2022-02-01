package com.tencent.mm.plugin.finder.live.model.service;

import android.graphics.Point;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.live.core.mini.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/service/IFinderLiveCommonAdapter;", "", "canShowMiniWindow", "", "getLiveMiniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getLiveRoomPlayListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "getLiveStatus", "Lcom/tencent/mm/live/core/core/model/LiveStatus;", "getWindowSize", "Landroid/graphics/Point;", "isCdnMode", "markIsUserByDirector", "", "isUse", "notifyMiniWindowShow", "isFluentExit", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract i bch();
  
  public abstract boolean bfD();
  
  public abstract boolean enm();
  
  public abstract b enn();
  
  public abstract void eno();
  
  public abstract Point enp();
  
  public abstract void qL(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.service.a
 * JD-Core Version:    0.7.0.1
 */