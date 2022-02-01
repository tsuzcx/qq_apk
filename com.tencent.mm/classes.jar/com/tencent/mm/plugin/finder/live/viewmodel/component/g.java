package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract.ViewCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveSingleLotteryHistoryUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends UIComponent
{
  public static final a EaT;
  public FinderLotteryHistoryContract.Presenter EaU;
  
  static
  {
    AppMethodBeat.i(356945);
    EaT = new a((byte)0);
    AppMethodBeat.o(356945);
  }
  
  public g(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356912);
    AppMethodBeat.o(356912);
  }
  
  private static final boolean a(g paramg, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(356926);
    s.u(paramg, "this$0");
    paramg.getActivity().finish();
    AppMethodBeat.o(356926);
    return true;
  }
  
  private static final boolean b(g paramg, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(356934);
    s.u(paramg, "this$0");
    paramg.getActivity().finish();
    AppMethodBeat.o(356934);
    return true;
  }
  
  private FinderLotteryHistoryContract.Presenter exP()
  {
    AppMethodBeat.i(356920);
    FinderLotteryHistoryContract.Presenter localPresenter = this.EaU;
    if (localPresenter != null)
    {
      AppMethodBeat.o(356920);
      return localPresenter;
    }
    s.bIx("presenter");
    AppMethodBeat.o(356920);
    return null;
  }
  
  public final int getLayoutId()
  {
    return p.f.Ceu;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356987);
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
    if ((i == 0) || (l1 == 0L) || (l2 == 0L) || ((Util.isNullOrNil((String)localObject)) && (i == 2)))
    {
      new StringBuilder("onCreate: error parameter scene = ").append(i).append(", liveId = ").append(l1).append(", objectId = ").append(l2).append(", objectNonceId = ").append(paramBundle).append(", anchorUsername = ").append((String)localObject);
      getActivity().finish();
      AppMethodBeat.o(356987);
      return;
    }
    paramBundle = new FinderLotteryHistoryContract.Presenter(i, l1, l2, paramBundle, (String)localObject, new FinderLiveLotteryHistoryLoader(i, l1, l2, paramBundle));
    s.u(paramBundle, "<set-?>");
    this.EaU = paramBundle;
    paramBundle = new FinderLotteryHistoryContract.ViewCallback((MMActivity)getActivity(), exP());
    exP().a((BaseFinderLotteryContract.ViewCallback)paramBundle);
    int j;
    if (i == 1)
    {
      boolean bool = getIntent().getBooleanExtra("KEY_SHOW_SETTING_TITLE", false);
      if (!bool)
      {
        i = 1;
        paramBundle = (MMActivity)getActivity();
        if (!bool) {
          break label355;
        }
        j = p.h.finder_live_more_action_live_lottery_history_preference;
        label314:
        paramBundle.setMMTitle(j);
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label380;
      }
      ((MMActivity)getActivity()).setBackBtn(new g..ExternalSyntheticLambda1(this), p.g.icons_filled_close);
      AppMethodBeat.o(356987);
      return;
      i = 0;
      break;
      label355:
      j = p.h.Com;
      break label314;
      ((MMActivity)getActivity()).setMMTitle(p.h.Cow);
      i = 1;
    }
    label380:
    ((MMActivity)getActivity()).setBackBtn(new g..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(356987);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(356991);
    super.onDestroy();
    if (this.EaU != null) {
      exP().onDetach();
    }
    AppMethodBeat.o(356991);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveSingleLotteryHistoryUIC$Companion;", "", "()V", "KEY_LIVE_ANCHOR_USERNAME", "", "KEY_LOTTERY_HISTORY_LIVE_ID", "KEY_LOTTERY_HISTORY_OBJECT_ID", "KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", "KEY_LOTTERY_HISTORY_SCENE", "KEY_SHOW_SETTING_TITLE", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.g
 * JD-Core Version:    0.7.0.1
 */