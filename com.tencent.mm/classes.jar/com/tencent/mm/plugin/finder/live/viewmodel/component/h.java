package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveWinLotteryListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class h
  extends UIComponent
{
  public static final a zeq;
  public FinderLotteryListContract.Presenter xng;
  
  static
  {
    AppMethodBeat.i(277834);
    zeq = new a((byte)0);
    AppMethodBeat.o(277834);
  }
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(277833);
    AppMethodBeat.o(277833);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_lottery_history_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277831);
    super.onCreate(paramBundle);
    long l1 = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_LIVE_ID", 0L);
    long l2 = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", 0L);
    Object localObject = getActivity().getIntent().getStringExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    int i = getActivity().getIntent().getIntExtra("KEY_SCENE", 0);
    String str = getActivity().getIntent().getStringExtra("KEY_LOTTERY_ID");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    if ((l1 == 0L) || (l2 == 0L) || (Util.isNullOrNil((String)localObject)))
    {
      new StringBuilder("onCreate: error parameter lotteryId = ").append((String)localObject).append(", liveId = ").append(l1).append(", objectId = ").append(l2).append(", objectNonceId = ").append(paramBundle);
      getActivity().finish();
      AppMethodBeat.o(277831);
      return;
    }
    this.xng = new FinderLotteryListContract.Presenter(new FinderLiveLotteryListLoader((String)localObject, l1, l2, paramBundle, i));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(277831);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.xng;
    if (localObject == null) {
      p.bGy("presenter");
    }
    paramBundle = new FinderLotteryListContract.ViewCallback(paramBundle, (FinderLotteryListContract.Presenter)localObject);
    localObject = this.xng;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((FinderLotteryListContract.Presenter)localObject).a((BaseFinderLotteryContract.ViewCallback)paramBundle);
    boolean bool = getIntent().getBooleanExtra("KEY_SHOW_SETTING_TITLE", false);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(277831);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    if (bool) {}
    for (i = b.j.finder_live_more_action_live_lottery_history_preference_detail;; i = b.j.finder_live_more_action_live_lottery_history_detail_title)
    {
      paramBundle.setMMTitle(i);
      paramBundle = getActivity();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(277831);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    ((FrameLayout)((FragmentActivity)getActivity()).findViewById(b.f.container_layout)).setBackgroundColor(getActivity().getResources().getColor(b.c.white));
    AppMethodBeat.o(277831);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(277832);
    super.onDestroy();
    if (((h)this).xng != null)
    {
      FinderLotteryListContract.Presenter localPresenter = this.xng;
      if (localPresenter == null) {
        p.bGy("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(277832);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveWinLotteryListUIC$Companion;", "", "()V", "KEY_LOTTERY_ID", "", "KEY_SCENE", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(h paramh) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(222633);
      this.zer.getActivity().finish();
      AppMethodBeat.o(222633);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.h
 * JD-Core Version:    0.7.0.1
 */