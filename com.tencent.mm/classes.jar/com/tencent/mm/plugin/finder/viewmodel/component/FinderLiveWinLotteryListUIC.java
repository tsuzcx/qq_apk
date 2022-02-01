package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.ViewCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveWinLotteryListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderLiveWinLotteryListUIC
  extends UIComponent
{
  public static final a wyH;
  public FinderLotteryListContract.Presenter tEE;
  
  static
  {
    AppMethodBeat.i(255834);
    wyH = new a((byte)0);
    AppMethodBeat.o(255834);
  }
  
  public FinderLiveWinLotteryListUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255833);
    AppMethodBeat.o(255833);
  }
  
  public final int getLayoutId()
  {
    return 2131494428;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255831);
    super.onCreate(paramBundle);
    long l1 = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_LIVE_ID", 0L);
    long l2 = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", 0L);
    Object localObject = getActivity().getIntent().getStringExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    String str = getActivity().getIntent().getStringExtra("KEY_LOTTERY_ID");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    if ((l1 == 0L) || (l2 == 0L) || (Util.isNullOrNil((String)localObject)))
    {
      new StringBuilder("onCreate: error parameter lotteryId = ").append((String)localObject).append(", liveId = ").append(l1).append(", objectId = ").append(l2).append(", objectNonceId = ").append(paramBundle);
      getActivity().finish();
      AppMethodBeat.o(255831);
      return;
    }
    this.tEE = new FinderLotteryListContract.Presenter(new FinderLiveLotteryListLoader((String)localObject, l1, l2, paramBundle));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255831);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.tEE;
    if (localObject == null) {
      p.btv("presenter");
    }
    paramBundle = new FinderLotteryListContract.ViewCallback(paramBundle, (FinderLotteryListContract.Presenter)localObject);
    localObject = this.tEE;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((FinderLotteryListContract.Presenter)localObject).a((BaseFinderLotteryContract.ViewCallback)paramBundle);
    boolean bool = getIntent().getBooleanExtra("KEY_SHOW_SETTING_TITLE", false);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255831);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    if (bool) {}
    for (int i = 2131760106;; i = 2131760103)
    {
      paramBundle.setMMTitle(i);
      paramBundle = getActivity();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255831);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    ((FrameLayout)((FragmentActivity)getActivity()).findViewById(2131299178)).setBackgroundColor(getActivity().getResources().getColor(2131101424));
    AppMethodBeat.o(255831);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255832);
    super.onDestroy();
    if (((FinderLiveWinLotteryListUIC)this).tEE != null)
    {
      FinderLotteryListContract.Presenter localPresenter = this.tEE;
      if (localPresenter == null) {
        p.btv("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(255832);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveWinLotteryListUIC$Companion;", "", "()V", "KEY_LOTTERY_ID", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderLiveWinLotteryListUIC paramFinderLiveWinLotteryListUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(255830);
      this.wyI.getActivity().finish();
      AppMethodBeat.o(255830);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveWinLotteryListUIC
 * JD-Core Version:    0.7.0.1
 */