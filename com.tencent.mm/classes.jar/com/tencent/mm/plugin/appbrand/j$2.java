package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ey;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.n.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appcache.n.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.jsruntime.aa;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

final class j$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(195518);
    if (!com.tencent.mm.kernel.g.afz().gcn)
    {
      AppMethodBeat.o(195518);
      return;
    }
    long l1 = AppBrandGlobalSystemConfig.aTv().jcJ.jcZ;
    long l2 = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Flf, Long.valueOf(0L))).longValue();
    long l3 = bt.aGK();
    if (l3 >= l2)
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Flf, Long.valueOf(l1 + l3));
      n.c.aPq().run();
      if (j.aOy() == null)
      {
        ad.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
        aa.bfI();
        com.tencent.mm.plugin.appbrand.appstorage.g.iSg.run();
        ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).aQK();
        d.bkO();
      }
    }
    else
    {
      AppMethodBeat.o(195518);
      return;
    }
    ey localey = new ey();
    StatFs localStatFs = new StatFs(ax.aQj());
    if (Build.VERSION.SDK_INT >= 18)
    {
      l1 = localStatFs.getBlockCountLong();
      label173:
      l3 = n.b.aPp();
      if (Build.VERSION.SDK_INT < 18) {
        break label335;
      }
      l2 = localStatFs.getBlockSizeLong();
      label193:
      double d = l3 / l2 / l1;
      localey.eay = l3;
      localey.eaz = Math.round(d * 100.0D);
      localStatFs = new StatFs(b.ahZ());
      if (Build.VERSION.SDK_INT < 18) {
        break label346;
      }
      l1 = localStatFs.getBlockCountLong();
      label249:
      if (Build.VERSION.SDK_INT < 18) {
        break label356;
      }
    }
    label335:
    label346:
    label356:
    for (l2 = localStatFs.getAvailableBlocksLong();; l2 = localStatFs.getAvailableBlocks())
    {
      localey.eaA = Math.round(l2 / l1 * 100.0D);
      localey.eaB = 1L;
      localey.eaC = n.e.aPw();
      ad.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", new Object[] { localey.PW() });
      localey.aBj();
      break;
      l1 = localStatFs.getBlockCount();
      break label173;
      l2 = localStatFs.getBlockSize();
      break label193;
      l1 = localStatFs.getBlockCount();
      break label249;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.2
 * JD-Core Version:    0.7.0.1
 */