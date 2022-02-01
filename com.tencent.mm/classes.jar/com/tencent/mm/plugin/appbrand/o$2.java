package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.oo;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bw;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.n.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appcache.n.e;
import com.tencent.mm.plugin.appbrand.appcache.predownload.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.m.ab;
import com.tencent.mm.plugin.appbrand.m.ae;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class o$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(277145);
    if (!com.tencent.mm.kernel.h.aHE().kbT)
    {
      AppMethodBeat.o(277145);
      return;
    }
    long l1 = AppBrandGlobalSystemConfig.bLe().nXt.nXO;
    long l2 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlL, Long.valueOf(0L))).longValue();
    long l3 = Util.nowSecond();
    if (l3 >= l2)
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlL, Long.valueOf(l1 + l3));
      n.c.bGx().run();
      if (m.bFB() == null)
      {
        Log.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
        ((bw)com.tencent.mm.kernel.h.ae(bw.class)).bGK();
        ab.bZa();
        ae.bZa();
        ((a)m.W(a.class)).bId();
        d.cfJ();
        com.tencent.mm.plugin.appbrand.appstorage.h.bIC();
        AppMethodBeat.o(277145);
        return;
      }
      oo localoo = new oo();
      StatFs localStatFs = new StatFs(bc.bHt());
      if (Build.VERSION.SDK_INT >= 18)
      {
        l1 = localStatFs.getBlockCountLong();
        label184:
        l3 = n.b.bGw();
        if (Build.VERSION.SDK_INT < 18) {
          break label346;
        }
        l2 = localStatFs.getBlockSizeLong();
        label204:
        double d = l3 / l2 / l1;
        localoo.hcd = l3;
        localoo.hce = Math.round(d * 100.0D);
        localStatFs = new StatFs(com.tencent.mm.loader.j.b.aSD());
        if (Build.VERSION.SDK_INT < 18) {
          break label357;
        }
        l1 = localStatFs.getBlockCountLong();
        label260:
        if (Build.VERSION.SDK_INT < 18) {
          break label367;
        }
      }
      label346:
      label357:
      label367:
      for (l2 = localStatFs.getAvailableBlocksLong();; l2 = localStatFs.getAvailableBlocks())
      {
        localoo.hcf = Math.round(l2 / l1 * 100.0D);
        localoo.hcg = 1L;
        localoo.hch = n.e.bGE();
        Log.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", new Object[] { localoo.agI() });
        localoo.bpa();
        break;
        l1 = localStatFs.getBlockCount();
        break label184;
        l2 = localStatFs.getBlockSize();
        break label204;
        l1 = localStatFs.getBlockCount();
        break label260;
      }
    }
    if (l3 + l1 < l2)
    {
      Log.e("MicroMsg.AppBrandPruner", "AccountScopedRunnable.run() invalid freq control mark, next:%d, now:%d, interval:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VlL, Long.valueOf(l1 + l3));
    }
    AppMethodBeat.o(277145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.2
 * JD-Core Version:    0.7.0.1
 */