package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract.ViewCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveSingleLotteryHistoryUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderLiveSingleLotteryHistoryUIC
  extends UIComponent
{
  public static final a wyx;
  public FinderLotteryHistoryContract.Presenter wyw;
  
  static
  {
    AppMethodBeat.i(255787);
    wyx = new a((byte)0);
    AppMethodBeat.o(255787);
  }
  
  public FinderLiveSingleLotteryHistoryUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255786);
    AppMethodBeat.o(255786);
  }
  
  public final int getLayoutId()
  {
    return 2131494428;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255784);
    super.onCreate(paramBundle);
    int i = getActivity().getIntent().getIntExtra("KEY_LOTTERY_HISTORY_SCENE", 0);
    long l1 = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_LIVE_ID", 0L);
    long l2 = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", 0L);
    Object localObject = getActivity().getIntent().getStringExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    String str = getActivity().getIntent().getStringExtra("KEY_LIVE_ANCHOR_USERNAME");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    if ((i == 0) || (l1 == 0L) || (l2 == 0L) || (Util.isNullOrNil((String)localObject)))
    {
      new StringBuilder("onCreate: error parameter scene = ").append(i).append(", liveId = ").append(l1).append(", objectId = ").append(l2).append(", objectNonceId = ").append(paramBundle).append(", anchorUsername = ").append((String)localObject);
      getActivity().finish();
      AppMethodBeat.o(255784);
      return;
    }
    this.wyw = new FinderLotteryHistoryContract.Presenter(i, l1, l2, paramBundle, (String)localObject, new FinderLiveLotteryHistoryLoader(i, l1, l2, paramBundle));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255784);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.wyw;
    if (localObject == null) {
      p.btv("presenter");
    }
    paramBundle = new FinderLotteryHistoryContract.ViewCallback(paramBundle, (FinderLotteryHistoryContract.Presenter)localObject);
    localObject = this.wyw;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((FinderLotteryHistoryContract.Presenter)localObject).a((BaseFinderLotteryContract.ViewCallback)paramBundle);
    int j;
    if (i == 1)
    {
      boolean bool = getIntent().getBooleanExtra("KEY_SHOW_SETTING_TITLE", false);
      if (!bool) {}
      for (i = 1;; i = 0)
      {
        paramBundle = getActivity();
        if (paramBundle != null) {
          break;
        }
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255784);
        throw paramBundle;
      }
      paramBundle = (MMActivity)paramBundle;
      if (bool)
      {
        j = 2131760105;
        paramBundle.setMMTitle(j);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramBundle = getActivity();
        if (paramBundle == null)
        {
          paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(255784);
          throw paramBundle;
          j = 2131760104;
          break;
          paramBundle = getActivity();
          if (paramBundle == null)
          {
            paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255784);
            throw paramBundle;
          }
          ((MMActivity)paramBundle).setMMTitle(2131760119);
          i = 1;
          continue;
        }
        ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new b(this), 2131690514);
        AppMethodBeat.o(255784);
        return;
      }
    }
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255784);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    AppMethodBeat.o(255784);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255785);
    super.onDestroy();
    if (((FinderLiveSingleLotteryHistoryUIC)this).wyw != null)
    {
      FinderLotteryHistoryContract.Presenter localPresenter = this.wyw;
      if (localPresenter == null) {
        p.btv("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(255785);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveSingleLotteryHistoryUIC$Companion;", "", "()V", "KEY_LIVE_ANCHOR_USERNAME", "", "KEY_LOTTERY_HISTORY_LIVE_ID", "KEY_LOTTERY_HISTORY_OBJECT_ID", "KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", "KEY_LOTTERY_HISTORY_SCENE", "KEY_SHOW_SETTING_TITLE", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderLiveSingleLotteryHistoryUIC paramFinderLiveSingleLotteryHistoryUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(255782);
      this.wyy.getActivity().finish();
      AppMethodBeat.o(255782);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderLiveSingleLotteryHistoryUIC paramFinderLiveSingleLotteryHistoryUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(255783);
      this.wyy.getActivity().finish();
      AppMethodBeat.o(255783);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveSingleLotteryHistoryUIC
 * JD-Core Version:    0.7.0.1
 */