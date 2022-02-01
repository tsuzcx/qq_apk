package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;

final class AppBrandLauncherRecentsList$20
  implements k.a
{
  AppBrandLauncherRecentsList$20(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(49077);
    ad.d("MicroMsg.AppBrandLauncherRecentsList", "onContactUpdate %s", new Object[] { paramString });
    AppBrandLauncherRecentsList.a(this.lId, false, -1L, false);
    AppMethodBeat.o(49077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.20
 * JD-Core Version:    0.7.0.1
 */