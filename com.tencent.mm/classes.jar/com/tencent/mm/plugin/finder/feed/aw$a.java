package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.b;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkAutoFlingToRefresh", "", "isHard", "isWithRefresh", "delayStartMs", "", "getFinderContextId", "", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getTabType", "", "getTimelineFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "loadMoreData", "", "isAuto", "onAutoToLoadMore", "onBackPressed", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "onUIPause", "onUIResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshMsgNotify", "requestRefresh", "setCanAutoPreloadMore", "canAutoPreloadMore", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface aw$a
  extends i, a<aw.b>
{
  public abstract void a(RefreshLoadMoreLayout.d<Object> paramd);
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, long paramLong);
  
  public abstract String bys();
  
  public abstract g dUK();
  
  public abstract void ecA();
  
  public abstract FinderTimelineFeedLoader ecB();
  
  public abstract List<i.b> getHeaderInfo();
  
  public abstract int getTabType();
  
  public abstract void oi(boolean paramBoolean);
  
  public abstract boolean onBackPressed();
  
  public abstract void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd);
  
  public abstract void onUIPause();
  
  public abstract void onUIResume();
  
  public abstract void onUserVisibleFocused();
  
  public abstract void onUserVisibleUnFocused();
  
  public abstract void pY(boolean paramBoolean);
  
  public abstract void requestRefresh();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aw.a
 * JD-Core Version:    0.7.0.1
 */