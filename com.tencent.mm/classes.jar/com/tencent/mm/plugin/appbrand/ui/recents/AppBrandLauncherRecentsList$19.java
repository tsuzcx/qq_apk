package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.appusage.w.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

final class AppBrandLauncherRecentsList$19
  implements k.a
{
  AppBrandLauncherRecentsList$19(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(133358);
    for (;;)
    {
      try
      {
        if ((paramm.obj != null) && ((paramm.obj instanceof Long)))
        {
          long l1 = AppBrandLauncherRecentsList.j(this.iTl).get();
          long l2 = AppBrandLauncherRecentsList.k(this.iTl).get();
          ab.d("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack ticket %d, mInitFetchTicket %d, mPagingFetchTicket %d", new Object[] { (Long)paramm.obj, Long.valueOf(l1), Long.valueOf(l2) });
          ArrayList localArrayList;
          if (paramm.obj.equals(Long.valueOf(l1)))
          {
            paramString = g.auK().hcp.hs(9223372036854775807L);
            if (!bo.es(paramString)) {
              AppBrandLauncherRecentsList.l(this.iTl).set(((AppBrandRecentTaskInfo)paramString.get(paramString.size() - 1)).updateTime);
            }
            localArrayList = AppBrandLauncherRecentsList.m(this.iTl).q(paramString);
            if (!paramm.obj.equals(Long.valueOf(l1))) {
              continue;
            }
            if (AppBrandLauncherRecentsList.i(this.iTl))
            {
              paramString = new ArrayList(0);
              this.iTl.runOnUiThread(new AppBrandLauncherRecentsList.19.1(this, paramString, localArrayList));
              AppMethodBeat.o(133358);
            }
          }
          else
          {
            paramString = g.auK().hcp.hs(AppBrandLauncherRecentsList.l(this.iTl).get());
            continue;
          }
          if (!AppBrandLauncherRecentsList.n(this.iTl)) {
            break label344;
          }
          paramString = g.auL().a(af.a.hcK);
          continue;
          if (paramm.obj.equals(Long.valueOf(l2)))
          {
            AppBrandLauncherRecentsList.a.a(AppBrandLauncherRecentsList.e(this.iTl));
            paramString = new AppBrandLauncherRecentsList.19.2(this, localArrayList);
            AppBrandLauncherRecentsList.e(this.iTl).sendMessage(AppBrandLauncherRecentsList.e(this.iTl).obtainMessage(1, paramString));
          }
        }
        AppMethodBeat.o(133358);
        return;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack e %s", new Object[] { paramString });
        AppMethodBeat.o(133358);
        return;
      }
      label344:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.19
 * JD-Core Version:    0.7.0.1
 */