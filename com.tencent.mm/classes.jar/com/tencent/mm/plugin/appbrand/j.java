package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import android.system.ErrnoException;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.n.b;
import com.tencent.mm.plugin.appbrand.appcache.n.c;
import com.tencent.mm.plugin.appbrand.appcache.n.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.PackageManager;
import com.tencent.mm.plugin.appbrand.jsruntime.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

public final class j
{
  private static final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d> jwA;
  
  static
  {
    AppMethodBeat.i(43798);
    jwA = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(43798);
  }
  
  public static void aVI()
  {
    AppMethodBeat.i(187873);
    h.LTJ.f(new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187872);
        if (!com.tencent.mm.kernel.g.ajA().gAD)
        {
          AppMethodBeat.o(187872);
          return;
        }
        long l1 = AppBrandGlobalSystemConfig.bdT().jWS.jXi;
        long l2 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Ivm, Long.valueOf(0L))).longValue();
        long l3 = bt.aQJ();
        if (l3 >= l2)
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Ivm, Long.valueOf(l1 + l3));
          n.c.aZD().run();
          if (com.tencent.mm.plugin.appbrand.app.j.aYL() == null)
          {
            ad.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
            aa.bqn();
            com.tencent.mm.plugin.appbrand.appstorage.g.jMl.run();
            ((com.tencent.mm.plugin.appbrand.appcache.b.d.a)com.tencent.mm.plugin.appbrand.app.j.T(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).bbd();
            com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.bvH();
          }
        }
        else
        {
          AppMethodBeat.o(187872);
          return;
        }
        ht localht = new ht();
        StatFs localStatFs = new StatFs(ay.baz());
        if (Build.VERSION.SDK_INT >= 18)
        {
          l1 = localStatFs.getBlockCountLong();
          label173:
          l3 = n.b.aZC();
          if (Build.VERSION.SDK_INT < 18) {
            break label335;
          }
          l2 = localStatFs.getBlockSizeLong();
          label193:
          double d = l3 / l2 / l1;
          localht.etj = l3;
          localht.etk = Math.round(d * 100.0D);
          localStatFs = new StatFs(b.arM());
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
          localht.etl = Math.round(l2 / l1 * 100.0D);
          localht.etm = 1L;
          localht.etn = n.e.aZJ();
          ad.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", new Object[] { localht.RE() });
          localht.aLk();
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
    AppMethodBeat.o(187873);
  }
  
  public static void release()
  {
    AppMethodBeat.i(43797);
    jwA.dead();
    AppMethodBeat.o(43797);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(43796);
    jwA.alive();
    AppMethodBeat.o(43796);
  }
  
  final class a
    implements com.tencent.mm.kernel.api.c, Runnable
  {
    private volatile boolean jwB;
    
    a()
    {
      AppMethodBeat.i(187870);
      this.jwB = false;
      com.tencent.mm.kernel.a.c.ajP().add(this);
      AppMethodBeat.o(187870);
    }
    
    public final void onAccountInitialized(e.c paramc) {}
    
    public final void onAccountRelease()
    {
      this.jwB = true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(187871);
      try
      {
        j.this.run();
        AppMethodBeat.o(187871);
        return;
      }
      catch (Throwable localThrowable)
      {
        if ((localThrowable instanceof ErrnoException))
        {
          AppMethodBeat.o(187871);
          return;
        }
        ad.printErrStackTrace("MicroMsg.AppBrandPruner", localThrowable, "caught exception while prune", new Object[0]);
        if (!this.jwB)
        {
          AppMethodBeat.o(187871);
          throw localThrowable;
        }
        AppMethodBeat.o(187871);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j
 * JD-Core Version:    0.7.0.1
 */