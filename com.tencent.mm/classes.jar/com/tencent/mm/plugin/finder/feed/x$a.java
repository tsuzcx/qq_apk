package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.c;
import com.tencent.mm.view.recyclerview.d.b;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkAutoFlingToRefresh", "", "isHard", "", "isWithRefresh", "getFinderContextId", "", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getTabType", "", "loadMoreData", "onBackPressed", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "onUIPause", "onUIResume", "onUserVisibleFocused", "refreshMsgNotify", "requestInsert", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "centerFeed", "keepUnreadSize", "hasReadFeeds", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "requestRefresh", "plugin-finder_release"})
public abstract interface x$a
  extends g, a<x.b>
{
  public abstract void M(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed1, BaseFinderFeed paramBaseFinderFeed2, int paramInt, List<? extends BaseFinderFeed> paramList, boolean paramBoolean, ald paramald);
  
  public abstract void a(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract void aQh();
  
  public abstract void b(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract c cut();
  
  public abstract List<d.b> cvf();
  
  public abstract void cvg();
  
  public abstract String cvh();
  
  public abstract int cvi();
  
  public abstract void cvj();
  
  public abstract boolean onBackPressed();
  
  public abstract void onUIResume();
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.x.a
 * JD-Core Version:    0.7.0.1
 */