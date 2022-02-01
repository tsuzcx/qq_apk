package com.tencent.mm.plugin.finder.presenter.contract;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.view.View;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.presenter.base.c;
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
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;)V", "TAG", "", "context", "mEmptyView", "Landroid/view/View;", "getMEmptyView", "()Landroid/view/View;", "setMEmptyView", "(Landroid/view/View;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getActivity", "getEmptyView", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getRecyclerView", "getTouchPhotoLayout", "initView", "", "onUIAttach", "onUIDestroy", "plugin-finder_release"})
public final class FinderLikedFeedContract$LikedTimelineViewCallback
  implements c<FinderLikedFeedContract.LikedTimelinePresenter>
{
  public View GG;
  private final String TAG;
  public final MMActivity fLP;
  public RecyclerView gmV;
  public RefreshLoadMoreLayout rTF;
  public TouchMediaPreviewLayout rTJ;
  public final FinderLikedFeedContract.LikedTimelinePresenter smv;
  
  public FinderLikedFeedContract$LikedTimelineViewCallback(MMActivity paramMMActivity, FinderLikedFeedContract.LikedTimelinePresenter paramLikedTimelinePresenter)
  {
    AppMethodBeat.i(166530);
    this.TAG = "Finder.FinderProfileContract.LikedTimelineViewCallback";
    this.smv = paramLikedTimelinePresenter;
    this.fLP = paramMMActivity;
    AppMethodBeat.o(166530);
  }
  
  public final TouchMediaPreviewLayout cBB()
  {
    AppMethodBeat.i(166528);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = this.rTJ;
    if (localTouchMediaPreviewLayout == null) {
      p.bcb("touchPhotoLayout");
    }
    AppMethodBeat.o(166528);
    return localTouchMediaPreviewLayout;
  }
  
  public final RefreshLoadMoreLayout cDf()
  {
    AppMethodBeat.i(166527);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.rTF;
    if (localRefreshLoadMoreLayout == null) {
      p.bcb("rlLayout");
    }
    AppMethodBeat.o(166527);
    return localRefreshLoadMoreLayout;
  }
  
  public final MMActivity getActivity()
  {
    return this.fLP;
  }
  
  public final BaseFinderFeedLoader getModel()
  {
    return (BaseFinderFeedLoader)this.smv.sfj;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(166529);
    RecyclerView localRecyclerView = this.gmV;
    if (localRecyclerView == null) {
      p.bcb("recyclerView");
    }
    AppMethodBeat.o(166529);
    return localRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback
 * JD-Core Version:    0.7.0.1
 */