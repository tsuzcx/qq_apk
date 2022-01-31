package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandLauncherRecentsList$3$1
  implements Runnable
{
  AppBrandLauncherRecentsList$3$1(AppBrandLauncherRecentsList.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(133331);
    try
    {
      AppBrandLauncherRecentsList.b(this.iTm.iTl).ajb.notifyChanged();
      AppMethodBeat.o(133331);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ab.w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren retry notifyDataSetChanged after scroll e=%s", new Object[] { localIllegalStateException });
      AppMethodBeat.o(133331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.3.1
 * JD-Core Version:    0.7.0.1
 */