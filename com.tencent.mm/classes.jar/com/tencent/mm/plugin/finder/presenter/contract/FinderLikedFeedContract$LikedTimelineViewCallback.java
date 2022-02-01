package com.tencent.mm.plugin.finder.presenter.contract;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.c<Ljava.lang.Object;>;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.d;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;)V", "TAG", "", "context", "mEmptyView", "Landroid/view/View;", "getMEmptyView", "()Landroid/view/View;", "setMEmptyView", "(Landroid/view/View;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getActivity", "getEmptyView", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getRecyclerView", "getTouchPhotoLayout", "initView", "", "onUIAttach", "onUIDestroy", "plugin-finder_release"})
public final class FinderLikedFeedContract$LikedTimelineViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.b<FinderLikedFeedContract.LikedTimelinePresenter>
{
  public View DR;
  private final String TAG;
  public RecyclerView fPw;
  public final MMActivity imP;
  public final FinderLikedFeedContract.LikedTimelinePresenter qET;
  public RefreshLoadMoreLayout quj;
  public TouchMediaPreviewLayout qum;
  
  public FinderLikedFeedContract$LikedTimelineViewCallback(MMActivity paramMMActivity, FinderLikedFeedContract.LikedTimelinePresenter paramLikedTimelinePresenter)
  {
    AppMethodBeat.i(166530);
    this.TAG = "Finder.FinderProfileContract.LikedTimelineViewCallback";
    this.qET = paramLikedTimelinePresenter;
    this.imP = paramMMActivity;
    AppMethodBeat.o(166530);
  }
  
  public final TouchMediaPreviewLayout cmo()
  {
    AppMethodBeat.i(166528);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = this.qum;
    if (localTouchMediaPreviewLayout == null) {
      k.aPZ("touchPhotoLayout");
    }
    AppMethodBeat.o(166528);
    return localTouchMediaPreviewLayout;
  }
  
  public final RefreshLoadMoreLayout cny()
  {
    AppMethodBeat.i(166527);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.quj;
    if (localRefreshLoadMoreLayout == null) {
      k.aPZ("rlLayout");
    }
    AppMethodBeat.o(166527);
    return localRefreshLoadMoreLayout;
  }
  
  public final MMActivity getActivity()
  {
    return this.imP;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(166529);
    RecyclerView localRecyclerView = this.fPw;
    if (localRecyclerView == null) {
      k.aPZ("recyclerView");
    }
    AppMethodBeat.o(166529);
    return localRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback
 * JD-Core Version:    0.7.0.1
 */