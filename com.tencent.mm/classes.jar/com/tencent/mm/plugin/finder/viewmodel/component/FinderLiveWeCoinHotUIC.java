package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract.ViewCallback;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveWeCoinHotUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-finder_release"})
public final class FinderLiveWeCoinHotUIC
  extends UIComponent
{
  public static final a wyG;
  public FinderLiveWeCoinHotConstract.Presenter uXX;
  
  static
  {
    AppMethodBeat.i(255829);
    wyG = new a((byte)0);
    AppMethodBeat.o(255829);
  }
  
  public FinderLiveWeCoinHotUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255828);
    AppMethodBeat.o(255828);
  }
  
  public final int getLayoutId()
  {
    return 2131494486;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255826);
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity))
    {
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255826);
        throw paramBundle;
      }
      ((MMActivity)paramBundle).setSelfNavigationBarVisible(8);
    }
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext().getWindow().clearFlags(67108864);
      paramBundle = getContext().getWindow();
      p.g(paramBundle, "context.window");
      paramBundle = paramBundle.getDecorView();
      p.g(paramBundle, "context.window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getContext().getWindow().addFlags(-2147483648);
      paramBundle = getContext().getWindow();
      p.g(paramBundle, "context.window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getContext().getWindow();
      p.g(paramBundle, "context.window");
      paramBundle.setNavigationBarColor(0);
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
    if ((l1 == 0L) || (l2 == 0L) || (Util.isNullOrNil(paramBundle)))
    {
      Log.e("SimpleUIComponent", "onCreate: error parameter liveId = " + l1 + ", objectId = " + l2 + ", objectNonceId = " + paramBundle + ", sessionId:" + (String)localObject);
      getActivity().finish();
      AppMethodBeat.o(255826);
      return;
    }
    this.uXX = new FinderLiveWeCoinHotConstract.Presenter(new FinderLiveWecoinHotLoader(l1, l2, paramBundle));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255826);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.uXX;
    if (localObject == null) {
      p.btv("presenter");
    }
    paramBundle = new FinderLiveWeCoinHotConstract.ViewCallback(paramBundle, (FinderLiveWeCoinHotConstract.Presenter)localObject);
    localObject = this.uXX;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((FinderLiveWeCoinHotConstract.Presenter)localObject).a(paramBundle);
    ((RelativeLayout)((FragmentActivity)getActivity()).findViewById(2131301337)).setBackgroundColor(getActivity().getResources().getColor(2131101424));
    AppMethodBeat.o(255826);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255827);
    super.onDestroy();
    if (((FinderLiveWeCoinHotUIC)this).uXX != null)
    {
      FinderLiveWeCoinHotConstract.Presenter localPresenter = this.uXX;
      if (localPresenter == null) {
        p.btv("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(255827);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveWeCoinHotUIC$Companion;", "", "()V", "KEY_LIVE_ID", "", "KEY_OBJECT_ID", "KEY_OBJECT_NONCE_ID", "KEY_SESSION_ID", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveWeCoinHotUIC
 * JD-Core Version:    0.7.0.1
 */