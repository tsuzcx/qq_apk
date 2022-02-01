package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import android.system.ErrnoException;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.n.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appcache.n.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.jsruntime.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

public final class k
{
  private static final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d> jzw;
  
  static
  {
    AppMethodBeat.i(43798);
    jzw = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(43798);
  }
  
  public static void aWh()
  {
    AppMethodBeat.i(221982);
    h.MqF.f(new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221981);
        if (!com.tencent.mm.kernel.g.ajP().gDk)
        {
          AppMethodBeat.o(221981);
          return;
        }
        long l1 = AppBrandGlobalSystemConfig.bez().kah.kax;
        long l2 = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IPK, Long.valueOf(0L))).longValue();
        long l3 = bu.aRi();
        if (l3 >= l2)
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IPK, Long.valueOf(l1 + l3));
          ((bp)com.tencent.mm.kernel.g.ab(bp.class)).ban();
          n.c.baa().run();
          if (j.aZh() == null)
          {
            ae.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
            ab.bqX();
            com.tencent.mm.plugin.appbrand.appstorage.g.jPx.run();
            ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).bbF();
            com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.bwy();
          }
        }
        else
        {
          AppMethodBeat.o(221981);
          return;
        }
        hv localhv = new hv();
        StatFs localStatFs = new StatFs(az.baY());
        if (Build.VERSION.SDK_INT >= 18)
        {
          l1 = localStatFs.getBlockCountLong();
          label186:
          l3 = n.b.aZZ();
          if (Build.VERSION.SDK_INT < 18) {
            break label348;
          }
          l2 = localStatFs.getBlockSizeLong();
          label206:
          double d = l3 / l2 / l1;
          localhv.euQ = l3;
          localhv.euR = Math.round(d * 100.0D);
          localStatFs = new StatFs(b.asb());
          if (Build.VERSION.SDK_INT < 18) {
            break label359;
          }
          l1 = localStatFs.getBlockCountLong();
          label262:
          if (Build.VERSION.SDK_INT < 18) {
            break label369;
          }
        }
        label348:
        label359:
        label369:
        for (l2 = localStatFs.getAvailableBlocksLong();; l2 = localStatFs.getAvailableBlocks())
        {
          localhv.euS = Math.round(l2 / l1 * 100.0D);
          localhv.euT = 1L;
          localhv.euU = n.e.bag();
          ae.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", new Object[] { localhv.RD() });
          localhv.aLH();
          break;
          l1 = localStatFs.getBlockCount();
          break label186;
          l2 = localStatFs.getBlockSize();
          break label206;
          l1 = localStatFs.getBlockCount();
          break label262;
        }
      }
    }), "MicroMsg.AppBrandPruner");
    AppMethodBeat.o(221982);
  }
  
  public static void release()
  {
    AppMethodBeat.i(43797);
    jzw.dead();
    AppMethodBeat.o(43797);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(43796);
    jzw.alive();
    AppMethodBeat.o(43796);
  }
  
  final class a
    implements com.tencent.mm.kernel.api.c, Runnable
  {
    private volatile boolean jzx;
    
    a()
    {
      AppMethodBeat.i(221979);
      this.jzx = false;
      com.tencent.mm.kernel.a.c.ake().add(this);
      AppMethodBeat.o(221979);
    }
    
    public final void onAccountInitialized(e.c paramc) {}
    
    public final void onAccountRelease()
    {
      this.jzx = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(221980);
      try
      {
        k.this.run();
        AppMethodBeat.o(221980);
        return;
      }
      catch (Throwable localThrowable)
      {
        if ((localThrowable instanceof ErrnoException))
        {
          AppMethodBeat.o(221980);
          return;
        }
        ae.printErrStackTrace("MicroMsg.AppBrandPruner", localThrowable, "caught exception while prune", new Object[0]);
        if ((!com.tencent.mm.kernel.g.ajP().gDk) || (this.jzx))
        {
          AppMethodBeat.o(221980);
          return;
        }
        AppMethodBeat.o(221980);
        throw localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k
 * JD-Core Version:    0.7.0.1
 */