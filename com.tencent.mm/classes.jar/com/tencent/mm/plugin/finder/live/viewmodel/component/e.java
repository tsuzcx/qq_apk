package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveSingleLotteryHistoryUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class e
  extends UIComponent
{
  public static final a zei;
  public FinderLotteryHistoryContract.Presenter zeh;
  
  static
  {
    AppMethodBeat.i(282553);
    zei = new a((byte)0);
    AppMethodBeat.o(282553);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(282552);
    AppMethodBeat.o(282552);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_lottery_history_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(282550);
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
      AppMethodBeat.o(282550);
      return;
    }
    this.zeh = new FinderLotteryHistoryContract.Presenter(i, l1, l2, paramBundle, (String)localObject, new FinderLiveLotteryHistoryLoader(i, l1, l2, paramBundle));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(282550);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.zeh;
    if (localObject == null) {
      p.bGy("presenter");
    }
    paramBundle = new FinderLotteryHistoryContract.ViewCallback(paramBundle, (FinderLotteryHistoryContract.Presenter)localObject);
    localObject = this.zeh;
    if (localObject == null) {
      p.bGy("presenter");
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
        AppMethodBeat.o(282550);
        throw paramBundle;
      }
      paramBundle = (MMActivity)paramBundle;
      if (bool)
      {
        j = b.j.finder_live_more_action_live_lottery_history_preference;
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
          AppMethodBeat.o(282550);
          throw paramBundle;
          j = b.j.finder_live_more_action_live_lottery_history_list_title;
          break;
          paramBundle = getActivity();
          if (paramBundle == null)
          {
            paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(282550);
            throw paramBundle;
          }
          ((MMActivity)paramBundle).setMMTitle(b.j.finder_live_more_action_win_lottery_record);
          i = 1;
          continue;
        }
        ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new b(this), b.i.icons_filled_close);
        AppMethodBeat.o(282550);
        return;
      }
    }
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(282550);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    AppMethodBeat.o(282550);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(282551);
    super.onDestroy();
    if (((e)this).zeh != null)
    {
      FinderLotteryHistoryContract.Presenter localPresenter = this.zeh;
      if (localPresenter == null) {
        p.bGy("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(282551);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveSingleLotteryHistoryUIC$Companion;", "", "()V", "KEY_LIVE_ANCHOR_USERNAME", "", "KEY_LOTTERY_HISTORY_LIVE_ID", "KEY_LOTTERY_HISTORY_OBJECT_ID", "KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", "KEY_LOTTERY_HISTORY_SCENE", "KEY_SHOW_SETTING_TITLE", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(285648);
      this.zej.getActivity().finish();
      AppMethodBeat.o(285648);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(291174);
      this.zej.getActivity().finish();
      AppMethodBeat.o(291174);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.e
 * JD-Core Version:    0.7.0.1
 */