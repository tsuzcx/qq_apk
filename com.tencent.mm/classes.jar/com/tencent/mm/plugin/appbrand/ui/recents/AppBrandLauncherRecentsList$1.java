package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandLauncherRecentsList$1
  implements Runnable
{
  AppBrandLauncherRecentsList$1(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void run()
  {
    AppMethodBeat.i(133329);
    int i = AppBrandLauncherRecentsList.a(this.iTl).size();
    if (i > 0)
    {
      AppBrandLauncherRecentsList.a(this.iTl).clear();
      AppBrandLauncherRecentsList.b(this.iTl).aq(0, i);
    }
    AppBrandLauncherRecentsList.c(this.iTl);
    AppMethodBeat.o(133329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.1
 * JD-Core Version:    0.7.0.1
 */