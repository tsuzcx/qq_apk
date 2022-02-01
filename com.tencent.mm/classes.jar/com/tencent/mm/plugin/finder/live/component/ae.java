package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveWeCoinHotUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-finder_release"})
public final class ae
  extends UIComponent
{
  public static final a ycK;
  public FinderLiveWeCoinHotConstract.Presenter ycJ;
  
  static
  {
    AppMethodBeat.i(276145);
    ycK = new a((byte)0);
    AppMethodBeat.o(276145);
  }
  
  public ae(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(276144);
    AppMethodBeat.o(276144);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_wecoin_hot_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(276142);
    super.onCreate(paramBundle);
    if ((getActivity() instanceof MMActivity))
    {
      paramBundle = getActivity();
      if (paramBundle == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(276142);
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
      p.j(paramBundle, "context.window");
      paramBundle = paramBundle.getDecorView();
      p.j(paramBundle, "context.window.decorView");
      paramBundle.setSystemUiVisibility(1792);
      getContext().getWindow().addFlags(-2147483648);
      paramBundle = getContext().getWindow();
      p.j(paramBundle, "context.window");
      paramBundle.setStatusBarColor(0);
      paramBundle = getContext().getWindow();
      p.j(paramBundle, "context.window");
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
    long l3 = getActivity().getIntent().getLongExtra("TYPE_MEMBER_ONLINE", 0L);
    if ((l1 == 0L) || (l2 == 0L) || (Util.isNullOrNil(paramBundle)))
    {
      Log.e("SimpleUIComponent", "onCreate: error parameter liveId = " + l1 + ", objectId = " + l2 + ", objectNonceId = " + paramBundle + ", sessionId:" + (String)localObject);
      getActivity().finish();
      AppMethodBeat.o(276142);
      return;
    }
    this.ycJ = new FinderLiveWeCoinHotConstract.Presenter(new FinderLiveWecoinHotLoader(l1, l2, paramBundle));
    paramBundle = this.ycJ;
    if (paramBundle == null) {
      p.bGy("presenter");
    }
    paramBundle.zOa = l3;
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(276142);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    localObject = this.ycJ;
    if (localObject == null) {
      p.bGy("presenter");
    }
    paramBundle = new FinderLiveWeCoinHotConstract.ViewCallback(paramBundle, (FinderLiveWeCoinHotConstract.Presenter)localObject);
    localObject = this.ycJ;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((FinderLiveWeCoinHotConstract.Presenter)localObject).a(paramBundle);
    AppMethodBeat.o(276142);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(276143);
    super.onDestroy();
    if (((ae)this).ycJ != null)
    {
      FinderLiveWeCoinHotConstract.Presenter localPresenter = this.ycJ;
      if (localPresenter == null) {
        p.bGy("presenter");
      }
      localPresenter.onDetach();
    }
    AppMethodBeat.o(276143);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveWeCoinHotUIC$Companion;", "", "()V", "KEY_LIVE_ID", "", "KEY_OBJECT_ID", "KEY_OBJECT_NONCE_ID", "KEY_SESSION_ID", "TYPE_MEMBER_ONLINE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ae
 * JD-Core Version:    0.7.0.1
 */