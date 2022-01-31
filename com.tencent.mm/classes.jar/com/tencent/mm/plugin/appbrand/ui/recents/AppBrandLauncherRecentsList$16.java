package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.atomic.AtomicLong;

final class AppBrandLauncherRecentsList$16
  implements k.a
{
  AppBrandLauncherRecentsList$16(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(133352);
    if ("single".equals(paramString))
    {
      if (((5 == paramm.htj) && (AppBrandLauncherRecentsList.i(this.iTl))) || (2 == paramm.htj) || (3 == paramm.htj))
      {
        ab.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, event %d", new Object[] { Integer.valueOf(paramm.htj) });
        AppBrandLauncherRecentsList.a(this.iTl, false, -1L, true);
        AppMethodBeat.o(133352);
      }
    }
    else if (("batch".equals(paramString)) && (3 == paramm.htj))
    {
      paramString = paramm.obj;
      if (((paramString instanceof Long)) && (((Long)paramString).longValue() == AppBrandLauncherRecentsList.j(this.iTl).get()))
      {
        AppMethodBeat.o(133352);
        return;
      }
      ab.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, batch update");
      AppBrandLauncherRecentsList.a(this.iTl, false, 9223372036854775807L, true);
    }
    AppMethodBeat.o(133352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.16
 * JD-Core Version:    0.7.0.1
 */