package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryAnchorAllHistoryLoader;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryAnchorAllHistoryContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryAnchorAllHistoryContract.ViewCallback;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveAnchorAllLotteryHistoryUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class a
  extends UIComponent
{
  public FinderLotteryAnchorAllHistoryContract.Presenter zdy;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278294);
    AppMethodBeat.o(278294);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_lottery_history_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278292);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(278292);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    paramBundle.setMMTitle(b.j.finder_live_more_action_live_lottery_history_preference);
    paramBundle.setBackBtn((MenuItem.OnMenuItemClickListener)new a(paramBundle));
    this.zdy = new FinderLotteryAnchorAllHistoryContract.Presenter(new FinderLiveLotteryAnchorAllHistoryLoader());
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(278292);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    FinderLotteryAnchorAllHistoryContract.Presenter localPresenter = this.zdy;
    if (localPresenter == null) {
      p.bGy("presenter");
    }
    paramBundle = new FinderLotteryAnchorAllHistoryContract.ViewCallback(paramBundle, localPresenter);
    localPresenter = this.zdy;
    if (localPresenter == null) {
      p.bGy("presenter");
    }
    localPresenter.a((BaseFinderLotteryContract.ViewCallback)paramBundle);
    AppMethodBeat.o(278292);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(278293);
    super.onDestroy();
    if (((a)this).zdy != null)
    {
      FinderLotteryAnchorAllHistoryContract.Presenter localPresenter = this.zdy;
      if (localPresenter == null) {
        p.bGy("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(278293);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(MMActivity paramMMActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(281029);
      this.qbG.finish();
      AppMethodBeat.o(281029);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.a
 * JD-Core Version:    0.7.0.1
 */