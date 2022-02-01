package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.e;
import com.tencent.mm.autogen.mmdata.rpt.sh;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bv;
import com.tencent.mm.plugin.appbrand.appcache.o.c;
import com.tencent.mm.plugin.appbrand.appcache.o.d;
import com.tencent.mm.plugin.appbrand.appcache.o.g;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.n.ab;
import com.tencent.mm.plugin.appbrand.n.ae;
import com.tencent.mm.plugin.appbrand.page.web_renderingcache.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;

public final class o
{
  private static final IListener<e> qsb;
  
  static
  {
    AppMethodBeat.i(43798);
    qsb = new AppBrandPruner.1(com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(43798);
  }
  
  public static void cbp()
  {
    AppMethodBeat.i(316602);
    com.tencent.threadpool.h.ahAA.i(new com.tencent.mm.plugin.appbrand.utils.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(317610);
        if (!com.tencent.mm.kernel.h.baC().mBZ)
        {
          AppMethodBeat.o(317610);
          return;
        }
        long l1 = AppBrandGlobalSystemConfig.ckD().qXj.qXI;
        long l2 = ((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNg, Long.valueOf(0L))).longValue();
        long l3 = Util.nowSecond();
        if (l3 >= l2)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acNg, Long.valueOf(l1 + l3));
          o.d.cfX().run();
          if (n.ceY() == null)
          {
            Log.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
            ((bv)com.tencent.mm.kernel.h.ax(bv.class)).cgi();
            ab.czn();
            ae.czn();
            ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)n.ag(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class)).chz();
            d.cGw();
            m.cid();
            AppMethodBeat.o(317610);
            return;
          }
          sh localsh = new sh();
          StatFs localStatFs = new StatFs(bd.cgP());
          if (Build.VERSION.SDK_INT >= 18)
          {
            l1 = localStatFs.getBlockCountLong();
            label184:
            l3 = o.c.cfW();
            if (Build.VERSION.SDK_INT < 18) {
              break label346;
            }
            l2 = localStatFs.getBlockSizeLong();
            label204:
            double d = l3 / l2 / l1;
            localsh.jxR = l3;
            localsh.jxS = Math.round(d * 100.0D);
            localStatFs = new StatFs(com.tencent.mm.loader.i.b.bmr());
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
            localsh.jxT = Math.round(l2 / l1 * 100.0D);
            localsh.jxU = 1L;
            localsh.jxV = o.g.cgd();
            Log.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", new Object[] { localsh.aIF() });
            localsh.bMH();
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
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acNg, Long.valueOf(l1 + l3));
        }
        AppMethodBeat.o(317610);
      }
    }), "MicroMsg.AppBrandPruner");
    AppMethodBeat.o(316602);
  }
  
  public static void release()
  {
    AppMethodBeat.i(43797);
    qsb.dead();
    AppMethodBeat.o(43797);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(43796);
    qsb.alive();
    AppMethodBeat.o(43796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o
 * JD-Core Version:    0.7.0.1
 */