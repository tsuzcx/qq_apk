package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.k;
import com.tencent.mm.plugin.appbrand.report.model.k.a;
import com.tencent.mm.plugin.appbrand.report.model.k.b;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.protocal.c.ayr;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class i$4
  implements Runnable
{
  i$4(i parami) {}
  
  public final void run()
  {
    int j = 0;
    if (i.e(this.hiZ) == null) {}
    do
    {
      return;
      localObject1 = q.ade();
    } while (localObject1 == null);
    int i;
    if (((ang)localObject1).tjo == 1) {
      i = 1;
    }
    Object localObject2;
    while (i != 0)
    {
      localObject2 = ((ang)localObject1).tjp;
      if (localObject2 == null)
      {
        y.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram but invalid appInfo, just return");
        return;
        i = 0;
      }
      else
      {
        if (b.cqk()) {
          j = ((ayr)localObject2).type;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1001;
        com.tencent.mm.plugin.appbrand.launching.precondition.g.gMF.a(i.e(this.hiZ), ((ayr)localObject2).username, null, ((ayr)localObject2).path, j, ((ayr)localObject2).sEs, localAppBrandStatObject, null, null);
        i.f(this.hiZ);
        localObject2 = new k();
        ((k)localObject2).gZc = k.b.gZp;
        ((k)localObject2).gZd = ((ang)localObject1).hHm;
        ((k)localObject2).gZe = ((ang)localObject1).tjb;
        if (i == 0) {
          break label232;
        }
      }
    }
    label232:
    for (Object localObject1 = k.a.gZk;; localObject1 = k.a.gZh)
    {
      ((k)localObject2).gZg = ((k.a)localObject1);
      ((k)localObject2).wn();
      return;
      if (!bk.bl(((ang)localObject1).tjd))
      {
        ((a)com.tencent.mm.kernel.g.r(a.class)).Q(i.e(this.hiZ), ((ang)localObject1).tjd);
        break;
      }
      y.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram false, url empty, just return");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.i.4
 * JD-Core Version:    0.7.0.1
 */