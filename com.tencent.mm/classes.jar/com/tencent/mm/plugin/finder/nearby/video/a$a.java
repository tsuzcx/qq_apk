package com.tencent.mm.plugin.finder.nearby.video;

import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getCommentScene", "", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a$a<T extends com.tencent.mm.view.recyclerview.a>
  extends com.tencent.mm.plugin.finder.presenter.base.a<a.b<T>>
{
  public abstract int getCommentScene();
  
  public abstract void onLoadMore();
  
  public abstract void onRefresh();
  
  public abstract void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.video.a.a
 * JD-Core Version:    0.7.0.1
 */