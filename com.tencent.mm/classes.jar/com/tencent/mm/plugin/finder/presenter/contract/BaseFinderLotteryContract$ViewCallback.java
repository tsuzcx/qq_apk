package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.view.animation.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getActivity", "getPresenter", "getRefreshLoadMoreLayout", "initView", "", "showEmptyView", "showProgress", "ifShow", "", "plugin-finder_release"})
public class BaseFinderLotteryContract$ViewCallback
  implements c<BaseFinderLotteryContract.Presenter>
{
  final MMActivity activity;
  public RefreshLoadMoreLayout tLS;
  final BaseFinderLotteryContract.Presenter uWj;
  
  public BaseFinderLotteryContract$ViewCallback(MMActivity paramMMActivity, BaseFinderLotteryContract.Presenter paramPresenter)
  {
    AppMethodBeat.i(249679);
    this.activity = paramMMActivity;
    this.uWj = paramPresenter;
    AppMethodBeat.o(249679);
  }
  
  public final RefreshLoadMoreLayout dcQ()
  {
    AppMethodBeat.i(249677);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tLS;
    if (localRefreshLoadMoreLayout == null) {
      p.btv("rlLayout");
    }
    AppMethodBeat.o(249677);
    return localRefreshLoadMoreLayout;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(249676);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tLS;
    if (localRefreshLoadMoreLayout == null) {
      p.btv("rlLayout");
    }
    AppMethodBeat.o(249676);
    return localRefreshLoadMoreLayout;
  }
  
  public final void nK(boolean paramBoolean)
  {
    AppMethodBeat.i(249678);
    View localView = this.activity.findViewById(2131303853);
    if (localView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(249678);
        return;
      }
    }
    AppMethodBeat.o(249678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */