package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.g.b;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "plugin-finder_release"})
public abstract interface aq$a
  extends a<aq.b>
{
  public abstract List<g.b> getHeaderInfo();
  
  public abstract void onLoadMore();
  
  public abstract void onRefresh();
  
  public abstract void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aq.a
 * JD-Core Version:    0.7.0.1
 */