package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryAnchorAllHistoryLoader;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.ViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryAnchorAllHistoryContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryAnchorAllHistoryContract.ViewCallback;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveAnchorAllLotteryHistoryUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  public FinderLotteryAnchorAllHistoryContract.Presenter DZX;
  private final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356898);
    this.TAG = "Finder.FinderLiveAnchorAllLotteryHistoryUIC";
    AppMethodBeat.o(356898);
  }
  
  private static final boolean a(MMActivity paramMMActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(356913);
    s.u(paramMMActivity, "$it");
    paramMMActivity.finish();
    AppMethodBeat.o(356913);
    return true;
  }
  
  private FinderLotteryAnchorAllHistoryContract.Presenter exC()
  {
    AppMethodBeat.i(356906);
    FinderLotteryAnchorAllHistoryContract.Presenter localPresenter = this.DZX;
    if (localPresenter != null)
    {
      AppMethodBeat.o(356906);
      return localPresenter;
    }
    s.bIx("presenter");
    AppMethodBeat.o(356906);
    return null;
  }
  
  public final int getLayoutId()
  {
    return p.f.Ceu;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(356943);
    super.onCreate(paramBundle);
    paramBundle = (MMActivity)getActivity();
    paramBundle.setMMTitle(p.h.finder_live_more_action_live_lottery_history_preference);
    paramBundle.setBackBtn(new a..ExternalSyntheticLambda0(paramBundle));
    long l1 = getIntent().getLongExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", 0L);
    long l2 = getIntent().getLongExtra("KEY_LOTTERY_HISTORY_LIVE_ID", 0L);
    Object localObject = getIntent().getStringExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    int j = getIntent().getIntExtra("KEY_LOTTERY_HISTORY_SCENE", 1);
    if (j == 0) {}
    for (;;)
    {
      localObject = new FinderLotteryAnchorAllHistoryContract.Presenter(new FinderLiveLotteryAnchorAllHistoryLoader(l1, l2, paramBundle, i), i);
      s.u(localObject, "<set-?>");
      this.DZX = ((FinderLotteryAnchorAllHistoryContract.Presenter)localObject);
      localObject = new FinderLotteryAnchorAllHistoryContract.ViewCallback((MMActivity)getActivity(), exC());
      exC().a((BaseFinderLotteryContract.ViewCallback)localObject);
      Log.i(this.TAG, "objectId：" + d.hF(l1) + ", scene:" + i + ", liveId:" + d.hF(l2) + ", nonceId:" + paramBundle);
      AppMethodBeat.o(356943);
      return;
      i = j;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(356949);
    super.onDestroy();
    if (this.DZX != null) {
      exC().onDetach();
    }
    AppMethodBeat.o(356949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.a
 * JD-Core Version:    0.7.0.1
 */