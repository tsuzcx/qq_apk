package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.live.report.d;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.RefreshLoadMoreLayout.d<Ljava.lang.Object;>;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;)V", "TAG", "", "context", "mEmptyView", "Landroid/view/View;", "getMEmptyView", "()Landroid/view/View;", "setMEmptyView", "(Landroid/view/View;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getActivity", "getEmptyView", "getModel", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getRecyclerView", "initView", "", "onUIAttach", "onUIDestroy", "smoothScrollToNextPosition", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLikedFeedContract$LikedTimelineViewCallback
  implements com.tencent.mm.plugin.finder.presenter.base.c<FinderLikedFeedContract.LikedTimelinePresenter>
{
  public RefreshLoadMoreLayout ATx;
  public final FinderLikedFeedContract.LikedTimelinePresenter EYf;
  private final String TAG;
  public View bEx;
  public final MMActivity lzt;
  public RecyclerView mkw;
  
  public FinderLikedFeedContract$LikedTimelineViewCallback(MMActivity paramMMActivity, FinderLikedFeedContract.LikedTimelinePresenter paramLikedTimelinePresenter)
  {
    AppMethodBeat.i(166530);
    this.TAG = "Finder.FinderProfileContract.LikedTimelineViewCallback";
    this.EYf = paramLikedTimelinePresenter;
    this.lzt = paramMMActivity;
    AppMethodBeat.o(166530);
  }
  
  private static final void l(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(343707);
    s.u(paramRecyclerView, "$recyclerView");
    com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback", "smoothScrollToNextPosition$lambda-2", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback", "smoothScrollToNextPosition$lambda-2", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(343707);
  }
  
  public final BaseFinderFeedLoader eeh()
  {
    return (BaseFinderFeedLoader)this.EYf.EXX;
  }
  
  public final View epE()
  {
    AppMethodBeat.i(343764);
    View localView = this.bEx;
    if (localView != null)
    {
      AppMethodBeat.o(343764);
      return localView;
    }
    s.bIx("mEmptyView");
    AppMethodBeat.o(343764);
    return null;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(343775);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView == null)
    {
      s.bIx("recyclerView");
      AppMethodBeat.o(343775);
      return null;
    }
    AppMethodBeat.o(343775);
    return localRecyclerView;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(166527);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    if (localRefreshLoadMoreLayout != null)
    {
      AppMethodBeat.o(166527);
      return localRefreshLoadMoreLayout;
    }
    s.bIx("rlLayout");
    AppMethodBeat.o(166527);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract.LikedTimelineViewCallback
 * JD-Core Version:    0.7.0.1
 */