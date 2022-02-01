package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getReportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onActionbarClick", "isDouble", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
public abstract interface b$a<T extends com.tencent.mm.view.recyclerview.a>
  extends com.tencent.mm.plugin.finder.presenter.base.a<b.b<T>>
{
  public abstract int getCommentScene();
  
  public abstract void onLoadMore();
  
  public abstract void onRefresh();
  
  public abstract void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.b.a
 * JD-Core Version:    0.7.0.1
 */