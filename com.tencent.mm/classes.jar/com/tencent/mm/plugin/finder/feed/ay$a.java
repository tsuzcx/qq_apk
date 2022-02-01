package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.autogen.mmdata.rpt.ef;
import com.tencent.mm.plugin.finder.storage.q;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "T", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onClickReport", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ay$a<T extends com.tencent.mm.view.recyclerview.a>
  extends com.tencent.mm.plugin.finder.presenter.base.a<ay.b<T>>
{
  public abstract void a(ef paramef, q paramq, int paramInt);
  
  public abstract void onLoadMore();
  
  public abstract void onRefresh();
  
  public abstract void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ay.a
 * JD-Core Version:    0.7.0.1
 */