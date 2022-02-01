package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.d.b;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "plugin-finder_release"})
public abstract interface ad$a
  extends a<ad.b>
{
  public abstract void Xa();
  
  public abstract void b(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract void con();
  
  public abstract List<d.b> cvf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ad.a
 * JD-Core Version:    0.7.0.1
 */