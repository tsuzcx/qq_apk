package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.b;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkAutoFlingToRefresh", "", "isHard", "", "isWithRefresh", "getFinderContextId", "", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getTabType", "", "loadMoreData", "onAutoToLoadMore", "onBackPressed", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "onUIPause", "onUIResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshMsgNotify", "requestInsert", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "centerFeed", "keepUnreadSize", "hasReadFeeds", "isPrefetch", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "requestRefresh", "plugin-finder_release"})
public abstract interface ai$a
  extends i, a<ai.b>
{
  public abstract void M(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed1, BaseFinderFeed paramBaseFinderFeed2, int paramInt, List<? extends BaseFinderFeed> paramList, boolean paramBoolean, atn paramatn);
  
  public abstract void a(RefreshLoadMoreLayout.c<Object> paramc);
  
  public abstract void boE();
  
  public abstract String cND();
  
  public abstract void dcO();
  
  public abstract f dce();
  
  public abstract List<g.b> getHeaderInfo();
  
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
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ai.a
 * JD-Core Version:    0.7.0.1
 */