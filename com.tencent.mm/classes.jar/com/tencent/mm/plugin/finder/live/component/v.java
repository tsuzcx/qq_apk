package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveChargeIncomeContract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveChargeIncomeContract.ViewCallback;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveChargeAnchorIncomeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveChargeIncomeContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends UIComponent
{
  public FinderLiveChargeIncomeContract.Presenter Cyk;
  private final String TAG;
  
  public v(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(352869);
    this.TAG = "FinderLiveChargeAnchorIncomeUIC";
    AppMethodBeat.o(352869);
  }
  
  private FinderLiveChargeIncomeContract.Presenter ehZ()
  {
    AppMethodBeat.i(352872);
    FinderLiveChargeIncomeContract.Presenter localPresenter = this.Cyk;
    if (localPresenter != null)
    {
      AppMethodBeat.o(352872);
      return localPresenter;
    }
    s.bIx("presenter");
    AppMethodBeat.o(352872);
    return null;
  }
  
  public final int getLayoutId()
  {
    return p.f.Cdn;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(352885);
    Log.i(this.TAG, "onCreate");
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity)) {
      ((MMActivity)getActivity()).setSelfNavigationBarVisible(8);
    }
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext().getWindow().clearFlags(67108864);
      getContext().getWindow().getDecorView().setSystemUiVisibility(1792);
      getContext().getWindow().addFlags(-2147483648);
      getContext().getWindow().setStatusBarColor(0);
      getContext().getWindow().setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
    long l1 = getActivity().getIntent().getLongExtra("KEY_LIVE_ID", 0L);
    long l2 = getActivity().getIntent().getLongExtra("KEY_OBJECT_ID", 0L);
    Object localObject = getActivity().getIntent().getStringExtra("KEY_OBJECT_NONCE_ID");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    String str = getActivity().getIntent().getStringExtra("KEY_SESSION_ID");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    boolean bool = getActivity().getIntent().getBooleanExtra("KEY_IF_USE_NEW_VALUE", false);
    if ((l1 == 0L) || (l2 == 0L) || (Util.isNullOrNil(paramBundle)))
    {
      Log.e(this.TAG, "onCreate: error parameter liveId = " + l1 + ", objectId = " + l2 + ", objectNonceId = " + paramBundle + ", sessionId:" + (String)localObject);
      getActivity().finish();
      AppMethodBeat.o(352885);
      return;
    }
    paramBundle = new FinderLiveChargeIncomeContract.Presenter(new FinderLiveWecoinHotLoader(l1, l2, paramBundle, 1, Boolean.valueOf(bool)));
    s.u(paramBundle, "<set-?>");
    this.Cyk = paramBundle;
    paramBundle = new FinderLiveChargeIncomeContract.ViewCallback((MMActivity)getActivity(), ehZ());
    ehZ().a(paramBundle);
    AppMethodBeat.o(352885);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(352896);
    Log.i(this.TAG, "onDestroy");
    super.onDestroy();
    if (this.Cyk != null) {
      ehZ().onDetach();
    }
    AppMethodBeat.o(352896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.v
 * JD-Core Version:    0.7.0.1
 */