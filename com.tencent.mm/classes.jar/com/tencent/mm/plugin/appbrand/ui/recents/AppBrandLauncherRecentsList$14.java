package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.sdk.platformtools.al;

final class AppBrandLauncherRecentsList$14
  implements Runnable
{
  AppBrandLauncherRecentsList$14(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList, m paramm, c.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(133347);
    if ((AppBrandLauncherRecentsList.d(this.iTl) == null) || (!AppBrandLauncherRecentsList.d(this.iTl).isAttachedToWindow()))
    {
      AppMethodBeat.o(133347);
      return;
    }
    if (AppBrandLauncherRecentsList.d(this.iTl).jd())
    {
      AppBrandLauncherRecentsList.e(this.iTl).sendMessage(AppBrandLauncherRecentsList.e(this.iTl).obtainMessage(2, this));
      AppMethodBeat.o(133347);
      return;
    }
    AppBrandLauncherRecentsList.a(this.iTl).clear();
    AppBrandLauncherRecentsList.a(this.iTl).addAll(this.iTt);
    al.Nf(-8);
    this.iTw.a(AppBrandLauncherRecentsList.f(this.iTl));
    AppMethodBeat.o(133347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.14
 * JD-Core Version:    0.7.0.1
 */