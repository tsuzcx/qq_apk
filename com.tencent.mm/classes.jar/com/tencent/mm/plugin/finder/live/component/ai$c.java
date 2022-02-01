package com.tencent.mm.plugin.finder.live.component;

import android.graphics.PointF;
import com.tencent.mm.plugin.finder.live.plugin.ba.b;
import com.tencent.mm.plugin.finder.presenter.base.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "getBottomLocation", "", "initView", "", "release", "reset", "updateLotteryStatus", "showingLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "updateLuckyMoneyCount", "count", "", "updateRefPoint", "point", "Landroid/graphics/PointF;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ai$c
  extends c<ai.b>
{
  public abstract void OI(int paramInt);
  
  public abstract void a(ba.b paramb);
  
  public abstract void b(PointF paramPointF);
  
  public abstract float eiI();
  
  public abstract void initView();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ai.c
 * JD-Core Version:    0.7.0.1
 */