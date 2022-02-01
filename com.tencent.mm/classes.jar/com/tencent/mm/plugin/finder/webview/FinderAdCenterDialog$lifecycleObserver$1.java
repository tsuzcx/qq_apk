package com.tencent.mm.plugin.finder.webview;

import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.webview.ad.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/webview/FinderAdCenterDialog$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "onPause", "", "onResume", "onStop", "plugin-finder_release"})
public final class FinderAdCenterDialog$lifecycleObserver$1
  implements k
{
  @t(jl=h.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(287751);
    Log.i("Finder.AdCenterDialog", "OnLifecycleEvent onPause");
    g localg = this.Brs;
    Log.d("Finder.AdCenterDialog", "dismissDialog isShowing: %b, isAttachedToWindow: %b, exitType: %s", new Object[] { Boolean.valueOf(localg.Brl.isShowing()), Boolean.valueOf(localg.isAttachedToWindow), Integer.valueOf(1) });
    localg.Brl.dismiss();
    AppMethodBeat.o(287751);
  }
  
  @t(jl=h.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(287750);
    Log.i("Finder.AdCenterDialog", "OnLifecycleEvent onResume");
    AppMethodBeat.o(287750);
  }
  
  @t(jl=h.a.ON_STOP)
  public final void onStop()
  {
    AppMethodBeat.i(287752);
    Log.i("Finder.AdCenterDialog", "OnLifecycleEvent onStop");
    AppMethodBeat.o(287752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.FinderAdCenterDialog.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */