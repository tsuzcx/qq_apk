package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.atomic.AtomicLong;

final class AppBrandLauncherRecentsList$18
  implements k.a
{
  AppBrandLauncherRecentsList$18(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(49074);
    if ("single".equals(paramString))
    {
      if (((5 == paramm.jqR) && (AppBrandLauncherRecentsList.i(this.lId))) || (2 == paramm.jqR) || (3 == paramm.jqR))
      {
        ad.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, event %d", new Object[] { Integer.valueOf(paramm.jqR) });
        AppBrandLauncherRecentsList.a(this.lId, false, -1L, true);
        AppMethodBeat.o(49074);
      }
    }
    else if (("batch".equals(paramString)) && (3 == paramm.jqR))
    {
      paramString = paramm.obj;
      if (((paramString instanceof Long)) && (((Long)paramString).longValue() == AppBrandLauncherRecentsList.j(this.lId).get()))
      {
        AppMethodBeat.o(49074);
        return;
      }
      ad.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, batch update");
      AppBrandLauncherRecentsList.a(this.lId, false, 9223372036854775807L, true);
    }
    AppMethodBeat.o(49074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.18
 * JD-Core Version:    0.7.0.1
 */