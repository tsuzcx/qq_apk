package com.tencent.mm.plugin.finder.live.fluent.director;

import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.plugin.finder.live.fluent.h;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/director/ISwitchOutDirector;", "", "isDetach", "", "setOutParams", "", "switchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "stopSwitchOut", "switchInLiveRoom", "renderView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "onFirstFrameRenderCallback", "Lkotlin/Function0;", "switchOut", "onAnimationEndCallback", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void a(LiveVideoView paramLiveVideoView, a<ah> parama);
  
  public abstract void a(h paramh);
  
  public abstract boolean aFA();
  
  public abstract void aX(a<ah> parama);
  
  public abstract void ejn();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.b
 * JD-Core Version:    0.7.0.1
 */