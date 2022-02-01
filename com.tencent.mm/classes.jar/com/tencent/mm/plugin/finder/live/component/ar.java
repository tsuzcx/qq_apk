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
import com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract.Presenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract.ViewCallback;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveWeCoinHotUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
  extends UIComponent
{
  public static final a CAV;
  public FinderLiveWeCoinHotConstract.Presenter CAW;
  
  static
  {
    AppMethodBeat.i(352739);
    CAV = new a((byte)0);
    AppMethodBeat.o(352739);
  }
  
  public ar(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(352721);
    AppMethodBeat.o(352721);
  }
  
  private FinderLiveWeCoinHotConstract.Presenter eiT()
  {
    AppMethodBeat.i(352731);
    FinderLiveWeCoinHotConstract.Presenter localPresenter = this.CAW;
    if (localPresenter != null)
    {
      AppMethodBeat.o(352731);
      return localPresenter;
    }
    s.bIx("presenter");
    AppMethodBeat.o(352731);
    return null;
  }
  
  public final int getLayoutId()
  {
    return p.f.Cgi;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(352757);
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
      Log.e("SimpleUIComponent", "onCreate: error parameter liveId = " + l1 + ", objectId = " + l2 + ", objectNonceId = " + paramBundle + ", sessionId:" + (String)localObject);
      getActivity().finish();
      AppMethodBeat.o(352757);
      return;
    }
    paramBundle = new FinderLiveWeCoinHotConstract.Presenter(new FinderLiveWecoinHotLoader(l1, l2, paramBundle, 0, Boolean.valueOf(bool)));
    s.u(paramBundle, "<set-?>");
    this.CAW = paramBundle;
    paramBundle = new FinderLiveWeCoinHotConstract.ViewCallback((MMActivity)getActivity(), eiT());
    eiT().a(paramBundle);
    AppMethodBeat.o(352757);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(352766);
    super.onDestroy();
    if (this.CAW != null) {
      eiT().onDetach();
    }
    AppMethodBeat.o(352766);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveWeCoinHotUIC$Companion;", "", "()V", "KEY_IF_USE_NEW_VALUE", "", "KEY_LIVE_ID", "KEY_OBJECT_ID", "KEY_OBJECT_NONCE_ID", "KEY_SESSION_ID", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ar
 * JD-Core Version:    0.7.0.1
 */