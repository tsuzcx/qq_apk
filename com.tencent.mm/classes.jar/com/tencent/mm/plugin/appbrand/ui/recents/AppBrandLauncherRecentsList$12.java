package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandLauncherRecentsList$12
  implements Runnable
{
  AppBrandLauncherRecentsList$12(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList, m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(133344);
    if (!bo.es(AppBrandLauncherRecentsList.a(this.iTl)))
    {
      int i = AppBrandLauncherRecentsList.a(this.iTl).size();
      AppBrandLauncherRecentsList.a(this.iTl).clear();
      AppBrandLauncherRecentsList.b(this.iTl).aq(0, i);
    }
    AppBrandLauncherRecentsList.a(this.iTl).addAll(this.iTt);
    AppBrandLauncherRecentsList.b(this.iTl).ap(0, this.iTt.size());
    AppMethodBeat.o(133344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.12
 * JD-Core Version:    0.7.0.1
 */