package com.tencent.mm.plugin.finder.webview;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.webview.ad.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/FinderWebViewDialogWrapper$lifecycleObserver$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "onPause", "onResume", "onStop", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderWebViewDialogWrapper$lifecycleObserver$1
  implements p
{
  FinderWebViewDialogWrapper$lifecycleObserver$1(i parami) {}
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(334429);
    Log.i("Finder.AdCenterDialog", "OnLifecycleEvent onDestroy");
    i locali = this.GXS;
    Log.d("Finder.AdCenterDialog", "dismissDialog isShowing: %b, isAttachedToWindow: %b, exitType: %s", new Object[] { Boolean.valueOf(locali.GXK.isShowing()), Boolean.valueOf(locali.isAttachedToWindow), Integer.valueOf(1) });
    locali.GXK.dismiss();
    AppMethodBeat.o(334429);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public final void onPause()
  {
    AppMethodBeat.i(334414);
    Log.i("Finder.AdCenterDialog", "OnLifecycleEvent onPause");
    AppMethodBeat.o(334414);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(334406);
    Log.i("Finder.AdCenterDialog", "OnLifecycleEvent onResume");
    AppMethodBeat.o(334406);
  }
  
  @z(Ho=j.a.ON_STOP)
  public final void onStop()
  {
    AppMethodBeat.i(334421);
    Log.i("Finder.AdCenterDialog", "OnLifecycleEvent onStop");
    AppMethodBeat.o(334421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.FinderWebViewDialogWrapper.lifecycleObserver.1
 * JD-Core Version:    0.7.0.1
 */