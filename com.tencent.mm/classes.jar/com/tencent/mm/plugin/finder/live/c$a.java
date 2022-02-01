package com.tencent.mm.plugin.finder.live;

import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.presenter.base.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "canFlingUp", "", "canLoadMore", "getLiveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "isEnableNestedScroll", "loadMoreData", "onLoadMoreResult", "", "pullType", "", "data", "oriDataSize", "incrementSize", "onPreloadResult", "preloadData", "newPos", "dataSize", "plugin-finder_release"})
public abstract interface c$a
  extends a<c.b>
{
  public abstract void a(int paramInt1, g paramg, int paramInt2);
  
  public abstract void a(int paramInt1, g paramg, int paramInt2, int paramInt3);
  
  public abstract boolean czZ();
  
  public abstract boolean dwe();
  
  public abstract boolean dwf();
  
  public abstract boolean dwg();
  
  public abstract g dwh();
  
  public abstract boolean gC(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.c.a
 * JD-Core Version:    0.7.0.1
 */