package com.tencent.mm.plugin.finder.viewmodel.component;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.view.c;
import com.tencent.mm.plugin.finder.live.view.j;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveAnchorSecDeviceUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveAnchorUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "onStop", "", "setWindowStyle", "plugin-finder_release"})
public final class FinderLiveAnchorSecDeviceUIC
  extends FinderLiveAnchorUIC
{
  public FinderLiveAnchorSecDeviceUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255731);
    AppMethodBeat.o(255731);
  }
  
  public final FinderBaseLivePluginLayout dIk()
  {
    AppMethodBeat.i(255728);
    Object localObject = getActivity();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255728);
      throw ((Throwable)localObject);
    }
    localObject = (FinderBaseLivePluginLayout)new c((MMActivity)localObject);
    AppMethodBeat.o(255728);
    return localObject;
  }
  
  public final void dIl()
  {
    AppMethodBeat.i(255729);
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(255729);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).setSelfNavigationBarVisible(8);
    }
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getContext().getWindow();
      p.g(localObject, "context.window");
      localObject = ((Window)localObject).getDecorView();
      p.g(localObject, "context.window.decorView");
      ((View)localObject).setSystemUiVisibility(1792);
      getContext().getWindow().clearFlags(67108864);
      getContext().getWindow().addFlags(-2147483648);
      localObject = getContext().getWindow();
      p.g(localObject, "context.window");
      ((Window)localObject).setStatusBarColor(0);
      localObject = getContext().getWindow();
      p.g(localObject, "context.window");
      ((Window)localObject).setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
    AppMethodBeat.o(255729);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(255730);
    Log.i(this.TAG, "[LiveLifecycler]onStop ".concat(String.valueOf(this)));
    Object localObject = this.wya;
    if (localObject != null) {
      ((FinderBaseLivePluginLayout)localObject).stop();
    }
    localObject = o.ujN;
    localObject = o.dfZ();
    if (localObject != null)
    {
      if (((g)localObject).uDS == true)
      {
        localObject = this.ubm;
        if (localObject != null) {
          ((j)localObject).aGj();
        }
        f.cji();
      }
      AppMethodBeat.o(255730);
      return;
    }
    AppMethodBeat.o(255730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveAnchorSecDeviceUIC
 * JD-Core Version:    0.7.0.1
 */