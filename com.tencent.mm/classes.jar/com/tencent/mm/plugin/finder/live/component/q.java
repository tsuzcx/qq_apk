package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.view.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSecDeviceUIC;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "onStop", "", "setWindowStyle", "tryShowFloatBallWhenExitPage", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends r
{
  public q(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(352874);
    AppMethodBeat.o(352874);
  }
  
  public final com.tencent.mm.plugin.finder.live.view.a ehM()
  {
    AppMethodBeat.i(352878);
    com.tencent.mm.plugin.finder.live.view.a locala = (com.tencent.mm.plugin.finder.live.view.a)new c((MMActivity)getActivity(), getFragment());
    AppMethodBeat.o(352878);
    return locala;
  }
  
  public final void ehN()
  {
    AppMethodBeat.i(352890);
    if ((getActivity() instanceof MMActivity)) {
      ((MMActivity)getActivity()).setSelfNavigationBarVisible(8);
    }
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext().getWindow().getDecorView().setSystemUiVisibility(1792);
      getContext().getWindow().clearFlags(67108864);
      getContext().getWindow().addFlags(-2147483648);
      getContext().getWindow().setStatusBarColor(0);
      getContext().getWindow().setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
    AppMethodBeat.o(352890);
  }
  
  public final void ehO()
  {
    AppMethodBeat.i(352911);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject != null)
    {
      localObject = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class);
      if ((localObject == null) || (((e)localObject).EcI != true)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = ehQ();
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.f)localObject).bhW();
        }
        com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      }
      AppMethodBeat.o(352911);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(352901);
    Log.i(getTAG(), s.X("[LiveLifecycler]onStop ", this));
    Object localObject = ehP();
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).stop();
    }
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject != null)
    {
      localObject = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class);
      if ((localObject == null) || (((e)localObject).EcI != true)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = ehQ();
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.live.view.f)localObject).bhW();
        }
        com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      }
      AppMethodBeat.o(352901);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.q
 * JD-Core Version:    0.7.0.1
 */