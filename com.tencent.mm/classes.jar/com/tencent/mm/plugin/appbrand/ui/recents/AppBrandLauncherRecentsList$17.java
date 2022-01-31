package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandLauncherRecentsList$17
  implements k.a
{
  AppBrandLauncherRecentsList$17(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(133354);
    if (("single".equals(paramString)) && ((3 == paramm.htj) || (2 == paramm.htj)))
    {
      this.iTl.runOnUiThread(new AppBrandLauncherRecentsList.17.1(this));
      ab.d("MicroMsg.AppBrandLauncherRecentsList", "onHistoryRecordModified");
      AppBrandLauncherRecentsList.a(this.iTl, true, 9223372036854775807L, false);
    }
    AppMethodBeat.o(133354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.17
 * JD-Core Version:    0.7.0.1
 */