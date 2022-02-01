package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import android.system.ErrnoException;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.n.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appcache.n.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.jsruntime.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class j
{
  private static final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d> jdr;
  
  static
  {
    AppMethodBeat.i(43798);
    jdr = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(43798);
  }
  
  public static void aSw()
  {
    AppMethodBeat.i(186218);
    h.JZN.f(new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186217);
        if (!com.tencent.mm.kernel.g.agP().ggT)
        {
          AppMethodBeat.o(186217);
          return;
        }
        long l1 = AppBrandGlobalSystemConfig.bat().jCW.jDm;
        long l2 = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIU, Long.valueOf(0L))).longValue();
        long l3 = bs.aNx();
        if (l3 >= l2)
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GIU, Long.valueOf(l1 + l3));
          n.c.aWi().run();
          if (com.tencent.mm.plugin.appbrand.app.j.aVq() == null)
          {
            ac.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
            aa.bmC();
            com.tencent.mm.plugin.appbrand.appstorage.g.jsr.run();
            ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)com.tencent.mm.plugin.appbrand.app.j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).aXF();
            com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.brD();
          }
        }
        else
        {
          AppMethodBeat.o(186217);
          return;
        }
        gq localgq = new gq();
        StatFs localStatFs = new StatFs(ax.aXb());
        if (Build.VERSION.SDK_INT >= 18)
        {
          l1 = localStatFs.getBlockCountLong();
          label173:
          l3 = n.b.aWh();
          if (Build.VERSION.SDK_INT < 18) {
            break label335;
          }
          l2 = localStatFs.getBlockSizeLong();
          label193:
          double d = l3 / l2 / l1;
          localgq.ecE = l3;
          localgq.ecF = Math.round(d * 100.0D);
          localStatFs = new StatFs(b.aoZ());
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
          localgq.ecG = Math.round(l2 / l1 * 100.0D);
          localgq.ecH = 1L;
          localgq.ecI = n.e.aWo();
          ac.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", new Object[] { localgq.PS() });
          localgq.aHZ();
          break;
          l1 = localStatFs.getBlockCount();
          break label173;
          l2 = localStatFs.getBlockSize();
          break label193;
          l1 = localStatFs.getBlockCount();
          break label249;
        }
      }
    }), "MicroMsg.AppBrandPruner");
    AppMethodBeat.o(186218);
  }
  
  public static void release()
  {
    AppMethodBeat.i(43797);
    jdr.dead();
    AppMethodBeat.o(43797);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(43796);
    jdr.alive();
    AppMethodBeat.o(43796);
  }
  
  final class a
    implements com.tencent.mm.kernel.api.c, Runnable
  {
    private volatile boolean jds;
    
    a()
    {
      AppMethodBeat.i(186215);
      this.jds = false;
      com.tencent.mm.kernel.a.c.ahe().add(this);
      AppMethodBeat.o(186215);
    }
    
    public final void onAccountInitialized(e.c paramc) {}
    
    public final void onAccountRelease()
    {
      this.jds = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(186216);
      try
      {
        j.this.run();
        AppMethodBeat.o(186216);
        return;
      }
      catch (Throwable localThrowable)
      {
        if ((localThrowable instanceof ErrnoException))
        {
          AppMethodBeat.o(186216);
          return;
        }
        ac.printErrStackTrace("MicroMsg.AppBrandPruner", localThrowable, "caught exception while prune", new Object[0]);
        if (!this.jds)
        {
          AppMethodBeat.o(186216);
          throw localThrowable;
        }
        AppMethodBeat.o(186216);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j
 * JD-Core Version:    0.7.0.1
 */