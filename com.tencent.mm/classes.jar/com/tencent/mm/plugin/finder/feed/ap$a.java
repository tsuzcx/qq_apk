package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.b;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkAutoFlingToRefresh", "", "isHard", "", "isWithRefresh", "getFinderContextId", "", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getTabType", "", "loadMoreData", "onAutoToLoadMore", "onBackPressed", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "onUIPause", "onUIResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshMsgNotify", "requestRefresh", "plugin-finder_release"})
public abstract interface ap$a
  extends i, a<ap.b>
{
  public abstract void R(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract void byN();
  
  public abstract String dcv();
  
  public abstract f dsu();
  
  public abstract void dto();
  
  public abstract List<h.b> getHeaderInfo();
  
  public abstract int getTabType();
  
  public abstract boolean onBackPressed();
  
  public abstract void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract void onUIPause();
  
  public abstract void onUIResume();
  
  public abstract void onUserVisibleFocused();
  
  public abstract void onUserVisibleUnFocused();
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ap.a
 * JD-Core Version:    0.7.0.1
 */