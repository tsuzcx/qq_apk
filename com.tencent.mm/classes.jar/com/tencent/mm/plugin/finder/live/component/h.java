package com.tencent.mm.plugin.finder.live.component;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.view.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorSecDeviceUIC;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorUIC;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "onStop", "", "setWindowStyle", "tryShowFloatBallWhenExitPage", "plugin-finder_release"})
public final class h
  extends i
{
  public h(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(282670);
    AppMethodBeat.o(282670);
  }
  
  public final com.tencent.mm.plugin.finder.live.view.a dxf()
  {
    AppMethodBeat.i(282666);
    Object localObject = getActivity();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(282666);
      throw ((Throwable)localObject);
    }
    localObject = (com.tencent.mm.plugin.finder.live.view.a)new c((MMActivity)localObject, getFragment());
    AppMethodBeat.o(282666);
    return localObject;
  }
  
  public final void dxg()
  {
    AppMethodBeat.i(282667);
    Object localObject;
    if ((getActivity() instanceof MMActivity))
    {
      localObject = getActivity();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(282667);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).setSelfNavigationBarVisible(8);
    }
    getContext().getWindow().addFlags(2097280);
    getContext().getWindow().addFlags(67108864);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getContext().getWindow();
      p.j(localObject, "context.window");
      localObject = ((Window)localObject).getDecorView();
      p.j(localObject, "context.window.decorView");
      ((View)localObject).setSystemUiVisibility(1792);
      getContext().getWindow().clearFlags(67108864);
      getContext().getWindow().addFlags(-2147483648);
      localObject = getContext().getWindow();
      p.j(localObject, "context.window");
      ((Window)localObject).setStatusBarColor(0);
      localObject = getContext().getWindow();
      p.j(localObject, "context.window");
      ((Window)localObject).setNavigationBarColor(0);
    }
    getContext().getWindow().setFormat(-3);
    getContext().getWindow().setSoftInputMode(51);
    AppMethodBeat.o(282667);
  }
  
  public final void dxh()
  {
    AppMethodBeat.i(282669);
    Object localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject != null)
    {
      localObject = (b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(b.class);
      if (localObject != null)
      {
        if (((b)localObject).zfn == true)
        {
          localObject = dxj();
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.live.view.f)localObject).aOj();
          }
          com.tencent.mm.plugin.ball.f.f.cwA();
        }
        AppMethodBeat.o(282669);
        return;
      }
    }
    AppMethodBeat.o(282669);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(282668);
    Log.i(this.TAG, "[LiveLifecycler]onStop ".concat(String.valueOf(this)));
    Object localObject = dxi();
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).stop();
    }
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject != null)
    {
      localObject = (b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(b.class);
      if (localObject != null)
      {
        if (((b)localObject).zfn == true)
        {
          localObject = dxj();
          if (localObject != null) {
            ((com.tencent.mm.plugin.finder.live.view.f)localObject).aOj();
          }
          com.tencent.mm.plugin.ball.f.f.cwA();
        }
        AppMethodBeat.o(282668);
        return;
      }
    }
    AppMethodBeat.o(282668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.h
 * JD-Core Version:    0.7.0.1
 */