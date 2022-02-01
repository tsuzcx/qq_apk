package com.tencent.mm.plugin.finder.live;

import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "canFlingUp", "", "canLoadMore", "getLiveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "isEnableNestedScroll", "lastPlayItemPos", "", "loadMoreData", "onLoadMoreInvalid", "", "onLoadMoreResult", "data", "oriDataSize", "incrementSize", "incrementList", "", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "onOrderResult", "notifyPos", "upIncrementSize", "downIncrementSize", "onPreloadResult", "lastItemPos", "onSideBarStateChanged", "show", "preloadData", "newPos", "dataSize", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "refreshData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c$a
  extends com.tencent.mm.plugin.finder.presenter.base.a<c.b>
{
  public abstract void a(g paramg, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(g paramg, int paramInt1, int paramInt2, List<f> paramList);
  
  public abstract boolean a(int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.live.model.context.a parama);
  
  public abstract void b(g paramg, int paramInt1, int paramInt2, List<f> paramList);
  
  public abstract boolean dcT();
  
  public abstract boolean egA();
  
  public abstract boolean egB();
  
  public abstract boolean egC();
  
  public abstract g egD();
  
  public abstract int egE();
  
  public abstract void egF();
  
  public abstract void qi(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.c.a
 * JD-Core Version:    0.7.0.1
 */