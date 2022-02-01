package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.i.b;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bd$a
  extends a<bd.b>
{
  public abstract List<i.b> getHeaderInfo();
  
  public abstract void onLoadMore();
  
  public abstract void onRefresh();
  
  public abstract void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bd.a
 * JD-Core Version:    0.7.0.1
 */