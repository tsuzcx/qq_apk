package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandLauncherRecentsList$18
  implements k.a
{
  AppBrandLauncherRecentsList$18(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(133355);
    ab.d("MicroMsg.AppBrandLauncherRecentsList", "onContactUpdate %s", new Object[] { paramString });
    AppBrandLauncherRecentsList.a(this.iTl, false, -1L, false);
    AppMethodBeat.o(133355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.18
 * JD-Core Version:    0.7.0.1
 */