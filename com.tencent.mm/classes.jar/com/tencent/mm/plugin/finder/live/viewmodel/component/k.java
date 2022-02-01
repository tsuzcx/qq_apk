package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.ViewCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveWinLotteryListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends UIComponent
{
  public static final a Ebg;
  public FinderLotteryListContract.Presenter ALe;
  
  static
  {
    AppMethodBeat.i(356916);
    Ebg = new a((byte)0);
    AppMethodBeat.o(356916);
  }
  
  public k(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356896);
    AppMethodBeat.o(356896);
  }
  
  private static final boolean a(k paramk, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(356908);
    s.u(paramk, "this$0");
    paramk.getActivity().finish();
    AppMethodBeat.o(356908);
    return true;
  }
  
  private FinderLotteryListContract.Presenter exU()
  {
    AppMethodBeat.i(356902);
    FinderLotteryListContract.Presenter localPresenter = this.ALe;
    if (localPresenter != null)
    {
      AppMethodBeat.o(356902);
      return localPresenter;
    }
    s.bIx("presenter");
    AppMethodBeat.o(356902);
    return null;
  }
  
  public final int getLayoutId()
  {
    return p.f.Ceu;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356959);
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
      AppMethodBeat.o(356959);
      return;
    }
    paramBundle = new FinderLotteryListContract.Presenter(new FinderLiveLotteryListLoader((String)localObject, l1, l2, paramBundle, i));
    s.u(paramBundle, "<set-?>");
    this.ALe = paramBundle;
    paramBundle = new FinderLotteryListContract.ViewCallback((MMActivity)getActivity(), exU());
    exU().a((BaseFinderLotteryContract.ViewCallback)paramBundle);
    boolean bool = getIntent().getBooleanExtra("KEY_SHOW_SETTING_TITLE", false);
    paramBundle = (MMActivity)getActivity();
    if (bool) {}
    for (i = p.h.Con;; i = p.h.Col)
    {
      paramBundle.setMMTitle(i);
      ((MMActivity)getActivity()).setBackBtn(new k..ExternalSyntheticLambda0(this));
      getActivity().findViewById(p.e.container_layout).setBackgroundColor(getActivity().getResources().getColor(p.b.white));
      AppMethodBeat.o(356959);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(356970);
    super.onDestroy();
    if (this.ALe != null) {
      exU().onDetach();
    }
    AppMethodBeat.o(356970);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveWinLotteryListUIC$Companion;", "", "()V", "KEY_LOTTERY_ID", "", "KEY_SCENE", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.k
 * JD-Core Version:    0.7.0.1
 */