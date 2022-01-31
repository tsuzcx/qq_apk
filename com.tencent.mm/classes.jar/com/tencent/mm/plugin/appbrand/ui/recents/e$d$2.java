package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.sdk.platformtools.y;

final class e$d$2
  implements Runnable
{
  e$d$2(e.d paramd, AppBrandRecentTaskInfo paramAppBrandRecentTaskInfo, int paramInt, String paramString) {}
  
  public final void run()
  {
    if (!this.hii.fJl)
    {
      i = ((s)com.tencent.mm.plugin.appbrand.app.e.G(s.class)).au(this.hii.bFn, this.hii.fEL);
      if (i == -2)
      {
        this.hih.hhH.runOnUiThread(new e.d.2.1(this));
        return;
      }
      if (i == -1)
      {
        y.e("MicroMsg.AppBrandLauncherRecentsList", "addStarApp, username %s, type %d, fatal", new Object[] { this.hii.bFn, Integer.valueOf(this.hii.fEL) });
        return;
      }
    }
    for (int i = 6;; i = 7)
    {
      com.tencent.mm.plugin.appbrand.report.e.a(this.hii, i, this.hij, this.hik);
      return;
      ((s)com.tencent.mm.plugin.appbrand.app.e.G(s.class)).j(this.hii.bFn, this.hii.fEL, true);
      if ((!e.g(this.hih.hhH)) && (e.m(this.hih.hhH))) {
        com.tencent.mm.plugin.appbrand.app.e.aaZ().a(this.hii.bFn, this.hii.fEL, false, 0, 2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.d.2
 * JD-Core Version:    0.7.0.1
 */