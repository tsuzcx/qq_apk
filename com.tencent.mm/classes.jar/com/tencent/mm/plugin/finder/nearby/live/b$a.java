package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.plugin.finder.nearby.live.play.e;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "fetchSubTabFeeds", "subTabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getAutoPlayManager", "Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLiveAutoPlayManager;", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getReportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onActionbarClick", "isDouble", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "targetPageForceRefreshFlag", "targetTabPageLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onFinishing", "onLoadMore", "onLoadMoreFollowFeed", "finderStreamCard", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b$a<T extends com.tencent.mm.view.recyclerview.a>
  extends com.tencent.mm.plugin.finder.presenter.base.a<b.b<T>>
{
  public abstract void a(bnn parambnn);
  
  public abstract void b(au paramau);
  
  public abstract e eEx();
  
  public abstract int getCommentScene();
  
  public abstract void onLoadMore();
  
  public abstract void onRefresh();
  
  public abstract void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.b.a
 * JD-Core Version:    0.7.0.1
 */