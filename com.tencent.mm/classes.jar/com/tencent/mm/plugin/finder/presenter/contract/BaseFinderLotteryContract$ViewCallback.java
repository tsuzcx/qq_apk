package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getActivity", "getPresenter", "getRefreshLoadMoreLayout", "initView", "", "showEmptyView", "showProgress", "ifShow", "", "plugin-finder_release"})
public class BaseFinderLotteryContract$ViewCallback
  implements c<BaseFinderLotteryContract.Presenter>
{
  final MMActivity activity;
  public RefreshLoadMoreLayout xvJ;
  final BaseFinderLotteryContract.Presenter zMz;
  
  public BaseFinderLotteryContract$ViewCallback(MMActivity paramMMActivity, BaseFinderLotteryContract.Presenter paramPresenter)
  {
    AppMethodBeat.i(287198);
    this.activity = paramMMActivity;
    this.zMz = paramPresenter;
    AppMethodBeat.o(287198);
  }
  
  public final RefreshLoadMoreLayout dtq()
  {
    AppMethodBeat.i(287196);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xvJ;
    if (localRefreshLoadMoreLayout == null) {
      p.bGy("rlLayout");
    }
    AppMethodBeat.o(287196);
    return localRefreshLoadMoreLayout;
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(287195);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xvJ;
    if (localRefreshLoadMoreLayout == null) {
      p.bGy("rlLayout");
    }
    AppMethodBeat.o(287195);
    return localRefreshLoadMoreLayout;
  }
  
  public final void pW(boolean paramBoolean)
  {
    AppMethodBeat.i(287197);
    View localView = this.activity.findViewById(b.f.lottery_history_progress);
    if (localView != null)
    {
      if (paramBoolean) {}
      for (int i = 0;; i = 8)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(287197);
        return;
      }
    }
    AppMethodBeat.o(287197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */