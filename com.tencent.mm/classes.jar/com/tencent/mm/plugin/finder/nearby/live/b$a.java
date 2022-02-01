package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.mm.plugin.finder.nearby.live.play.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getAutoPlayManager", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getReportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onActionbarClick", "isDouble", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "targetPageForceRefreshFlag", "targetTabPageLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"})
public abstract interface b$a<T extends com.tencent.mm.view.recyclerview.a>
  extends com.tencent.mm.plugin.finder.presenter.base.a<b.b<T>>
{
  public abstract c dLx();
  
  public abstract int getCommentScene();
  
  public abstract void onLoadMore();
  
  public abstract void onRefresh();
  
  public abstract void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.b.a
 * JD-Core Version:    0.7.0.1
 */