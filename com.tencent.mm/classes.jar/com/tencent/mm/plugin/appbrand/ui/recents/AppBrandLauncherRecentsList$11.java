package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.appusage.w.c;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.protocal.protobuf.asv;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

final class AppBrandLauncherRecentsList$11
  implements Runnable
{
  AppBrandLauncherRecentsList$11(AppBrandLauncherRecentsList paramAppBrandLauncherRecentsList) {}
  
  public final void run()
  {
    Object localObject3 = null;
    AppMethodBeat.i(133343);
    ArrayList localArrayList = AppBrandLauncherRecentsList.m(this.iTl).q(g.auK().hcp.hs(9223372036854775807L));
    AppBrandLauncherRecentsList.t(this.iTl);
    int m = this.iTl.mScene;
    String str = this.iTl.iMQ;
    Object localObject1;
    Object localObject2;
    int i;
    if ((localArrayList == null) || (localArrayList.size() <= 0))
    {
      localObject1 = null;
      localObject2 = "";
      asv localasv = q.axj();
      if (localasv == null) {
        break label346;
      }
      i = localasv.jAI;
      localObject2 = localasv.xhO;
    }
    for (;;)
    {
      e.a(m, "", (String)localObject1, i, (String)localObject2, str);
      if (AppBrandLauncherRecentsList.i(this.iTl)) {
        localObject1 = new ArrayList(0);
      }
      for (;;)
      {
        this.iTl.runOnUiThread(new AppBrandLauncherRecentsList.11.1(this, (ArrayList)localObject1, localArrayList));
        j.axa().a(AppBrandLauncherRecentsList.j(this.iTl).get(), true, AppBrandLauncherRecentsList.v(this.iTl), AppBrandLauncherRecentsList.w(this.iTl), AppBrandLauncherRecentsList.x(this.iTl));
        AppBrandLauncherRecentsList.y(this.iTl).set(true);
        AppMethodBeat.o(133343);
        return;
        localObject1 = new StringBuilder();
        i = 0;
        int k;
        for (int j = 0; i < localArrayList.size(); j = k)
        {
          localObject2 = localArrayList.get(i);
          k = j;
          if ((localObject2 instanceof AppBrandRecentTaskInfo))
          {
            localObject2 = (AppBrandRecentTaskInfo)localObject2;
            k = j + 1;
            ((StringBuilder)localObject1).append(((AppBrandRecentTaskInfo)localObject2).appId);
            if ((k == 20) || (k >= localArrayList.size())) {
              break;
            }
            ((StringBuilder)localObject1).append(":#:");
          }
          i += 1;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        localObject1 = localObject3;
        if (AppBrandLauncherRecentsList.n(this.iTl)) {
          localObject1 = ((s)g.w(s.class)).a(af.a.hcK);
        }
      }
      label346:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList.11
 * JD-Core Version:    0.7.0.1
 */