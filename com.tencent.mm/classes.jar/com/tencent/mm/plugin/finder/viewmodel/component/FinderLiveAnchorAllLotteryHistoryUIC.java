package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryAnchorAllHistoryLoader;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryAnchorAllHistoryContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryAnchorAllHistoryContract.ViewCallback;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveAnchorAllLotteryHistoryUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderLiveAnchorAllLotteryHistoryUIC
  extends UIComponent
{
  public FinderLotteryAnchorAllHistoryContract.Presenter wxZ;
  
  public FinderLiveAnchorAllLotteryHistoryUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255727);
    AppMethodBeat.o(255727);
  }
  
  public final int getLayoutId()
  {
    return 2131494428;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255725);
    super.onCreate(paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255725);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    paramBundle.setMMTitle(2131760105);
    paramBundle.setBackBtn((MenuItem.OnMenuItemClickListener)new a(paramBundle));
    this.wxZ = new FinderLotteryAnchorAllHistoryContract.Presenter(new FinderLiveLotteryAnchorAllHistoryLoader());
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255725);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    FinderLotteryAnchorAllHistoryContract.Presenter localPresenter = this.wxZ;
    if (localPresenter == null) {
      p.btv("presenter");
    }
    paramBundle = new FinderLotteryAnchorAllHistoryContract.ViewCallback(paramBundle, localPresenter);
    localPresenter = this.wxZ;
    if (localPresenter == null) {
      p.btv("presenter");
    }
    localPresenter.a((BaseFinderLotteryContract.ViewCallback)paramBundle);
    AppMethodBeat.o(255725);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255726);
    super.onDestroy();
    if (((FinderLiveAnchorAllLotteryHistoryUIC)this).wxZ != null)
    {
      FinderLotteryAnchorAllHistoryContract.Presenter localPresenter = this.wxZ;
      if (localPresenter == null) {
        p.btv("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(255726);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(MMActivity paramMMActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(255724);
      this.nbr.finish();
      AppMethodBeat.o(255724);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorAllLotteryHistoryUIC
 * JD-Core Version:    0.7.0.1
 */