package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getActivity", "getPresenter", "getRefreshLoadMoreLayout", "initView", "", "showEmptyView", "showProgress", "ifShow", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class BaseFinderLotteryContract$ViewCallback
  implements c<BaseFinderLotteryContract.Presenter>
{
  public RefreshLoadMoreLayout ATx;
  final BaseFinderLotteryContract.Presenter EXs;
  final MMActivity activity;
  
  public BaseFinderLotteryContract$ViewCallback(MMActivity paramMMActivity, BaseFinderLotteryContract.Presenter paramPresenter)
  {
    AppMethodBeat.i(343671);
    this.activity = paramMMActivity;
    this.EXs = paramPresenter;
    AppMethodBeat.o(343671);
  }
  
  public final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(343678);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    if (localRefreshLoadMoreLayout != null)
    {
      AppMethodBeat.o(343678);
      return localRefreshLoadMoreLayout;
    }
    s.bIx("rlLayout");
    AppMethodBeat.o(343678);
    return null;
  }
  
  public final void pZ(boolean paramBoolean)
  {
    AppMethodBeat.i(343684);
    View localView = this.activity.findViewById(p.e.BXG);
    if (localView != null) {
      if (!paramBoolean) {
        break label37;
      }
    }
    label37:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(343684);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback
 * JD-Core Version:    0.7.0.1
 */