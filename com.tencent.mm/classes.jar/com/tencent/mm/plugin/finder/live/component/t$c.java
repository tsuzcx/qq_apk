package com.tencent.mm.plugin.finder.live.component;

import android.graphics.PointF;
import com.tencent.mm.plugin.finder.live.plugin.bk.b;
import com.tencent.mm.plugin.finder.presenter.base.c;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$Presenter;", "getBottomLocation", "", "initView", "", "release", "reset", "updateLotteryStatus", "showingLocation", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryBubblePlugin$ShowingLocation;", "updateLuckyMoneyCount", "count", "", "updateRefPoint", "point", "Landroid/graphics/PointF;", "plugin-finder_release"})
public abstract interface t$c
  extends c<t.b>
{
  public abstract void Nk(int paramInt);
  
  public abstract void a(bk.b paramb);
  
  public abstract void c(PointF paramPointF);
  
  public abstract float dxG();
  
  public abstract void initView();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.t.c
 * JD-Core Version:    0.7.0.1
 */