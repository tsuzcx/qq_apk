package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import android.system.ErrnoException;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.n.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appcache.n.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.m.ab;
import com.tencent.mm.plugin.appbrand.m.ae;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class l
{
  private static final IListener<com.tencent.mm.g.a.d> kAj;
  
  static
  {
    AppMethodBeat.i(43798);
    kAj = new IListener() {};
    AppMethodBeat.o(43798);
  }
  
  public static void brc()
  {
    AppMethodBeat.i(226134);
    h.RTc.b(new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226133);
        if (!com.tencent.mm.kernel.g.aAf().hpY)
        {
          AppMethodBeat.o(226133);
          return;
        }
        long l1 = AppBrandGlobalSystemConfig.bzP().ldk.ldB;
        long l2 = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXL, Long.valueOf(0L))).longValue();
        long l3 = Util.nowSecond();
        if (l3 >= l2)
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NXL, Long.valueOf(l1 + l3));
          ((bp)com.tencent.mm.kernel.g.af(bp.class)).bvD();
          n.c.bvr().run();
          if (com.tencent.mm.plugin.appbrand.app.n.buy() == null)
          {
            Log.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
            ab.bMJ();
            ae.bMJ();
            com.tencent.mm.plugin.appbrand.appstorage.g.kSf.run();
            ((com.tencent.mm.plugin.appbrand.appcache.predownload.d.a)com.tencent.mm.plugin.appbrand.app.n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.d.a.class)).bwV();
            com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.bSG();
          }
        }
        else
        {
          AppMethodBeat.o(226133);
          return;
        }
        lq locallq = new lq();
        StatFs localStatFs = new StatFs(az.bwm());
        if (Build.VERSION.SDK_INT >= 18)
        {
          l1 = localStatFs.getBlockCountLong();
          label189:
          l3 = n.b.bvq();
          if (Build.VERSION.SDK_INT < 18) {
            break label351;
          }
          l2 = localStatFs.getBlockSizeLong();
          label209:
          double d = l3 / l2 / l1;
          locallq.eZm = l3;
          locallq.eZn = Math.round(d * 100.0D);
          localStatFs = new StatFs(b.aKB());
          if (Build.VERSION.SDK_INT < 18) {
            break label362;
          }
          l1 = localStatFs.getBlockCountLong();
          label265:
          if (Build.VERSION.SDK_INT < 18) {
            break label372;
          }
        }
        label351:
        label362:
        label372:
        for (l2 = localStatFs.getAvailableBlocksLong();; l2 = localStatFs.getAvailableBlocks())
        {
          locallq.eZo = Math.round(l2 / l1 * 100.0D);
          locallq.eZp = 1L;
          locallq.eZq = n.e.bvx();
          Log.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", new Object[] { locallq.abW() });
          locallq.bfK();
          break;
          l1 = localStatFs.getBlockCount();
          break label189;
          l2 = localStatFs.getBlockSize();
          break label209;
          l1 = localStatFs.getBlockCount();
          break label265;
        }
      }
    }), "MicroMsg.AppBrandPruner");
    AppMethodBeat.o(226134);
  }
  
  public static void release()
  {
    AppMethodBeat.i(43797);
    kAj.dead();
    AppMethodBeat.o(43797);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(43796);
    kAj.alive();
    AppMethodBeat.o(43796);
  }
  
  final class a
    implements com.tencent.mm.kernel.api.c, Runnable
  {
    private volatile boolean kAk;
    
    a()
    {
      AppMethodBeat.i(226131);
      this.kAk = false;
      com.tencent.mm.kernel.a.c.aAu().add(this);
      AppMethodBeat.o(226131);
    }
    
    public final void onAccountInitialized(e.c paramc) {}
    
    public final void onAccountRelease()
    {
      this.kAk = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(226132);
      try
      {
        l.this.run();
        AppMethodBeat.o(226132);
        return;
      }
      catch (Throwable localThrowable)
      {
        if ((localThrowable instanceof ErrnoException))
        {
          AppMethodBeat.o(226132);
          return;
        }
        Log.printErrStackTrace("MicroMsg.AppBrandPruner", localThrowable, "caught exception while prune", new Object[0]);
        if ((!com.tencent.mm.kernel.g.aAf().hpY) || (this.kAk))
        {
          AppMethodBeat.o(226132);
          return;
        }
        AppMethodBeat.o(226132);
        throw localThrowable;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l
 * JD-Core Version:    0.7.0.1
 */