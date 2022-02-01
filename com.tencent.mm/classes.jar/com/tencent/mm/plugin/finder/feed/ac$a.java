package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d.b;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkAutoFlingToRefresh", "", "isHard", "", "isWithRefresh", "getFinderContextId", "", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getTabType", "", "loadMoreData", "onAutoToLoadMore", "onBackPressed", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "onUIPause", "onUIResume", "onUserVisibleFocused", "refreshMsgNotify", "requestInsert", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "centerFeed", "keepUnreadSize", "hasReadFeeds", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "requestRefresh", "plugin-finder_release"})
public abstract interface ac$a
  extends h, a<ac.b>
{
  public abstract void N(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed1, BaseFinderFeed paramBaseFinderFeed2, int paramInt, List<? extends BaseFinderFeed> paramList, boolean paramBoolean, aov paramaov);
  
  public abstract void a(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract void aTS();
  
  public abstract void b(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract c cCq();
  
  public abstract List<d.b> cDj();
  
  public abstract void cDk();
  
  public abstract int cDl();
  
  public abstract void cDm();
  
  public abstract String cpk();
  
  public abstract boolean onBackPressed();
  
  public abstract void onUIPause();
  
  public abstract void onUIResume();
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ac.a
 * JD-Core Version:    0.7.0.1
 */