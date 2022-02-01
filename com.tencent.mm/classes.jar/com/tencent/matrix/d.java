package com.tencent.matrix;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.SystemClock;
import com.tencent.e.i;
import com.tencent.matrix.a.c.a.a.1;
import com.tencent.matrix.a.c.a.c;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.report.h.a;
import com.tencent.matrix.report.h.b;
import com.tencent.matrix.resource.analyzer.model.d.a;
import com.tencent.matrix.resource.e.b.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.q;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public enum d
  implements c.a
{
  private Application application;
  public com.tencent.matrix.report.h cte = null;
  private volatile boolean ctf = false;
  private final ax ctg = ax.aFC("MatrixDelegate");
  public com.tencent.matrix.strategy.a cth;
  private boolean cti = false;
  private volatile boolean ctj = false;
  public volatile boolean isInitialized = false;
  
  private d() {}
  
  private static com.tencent.matrix.resource.analyzer.model.a a(com.tencent.mm.vfs.e parame, String paramString)
  {
    com.tencent.matrix.resource.analyzer.model.d locald = com.tencent.matrix.resource.analyzer.model.c.l(Build.VERSION.SDK_INT, Build.MANUFACTURER).Hw();
    try
    {
      parame = new com.tencent.matrix.resource.analyzer.model.g(parame);
      parame = new com.tencent.matrix.resource.analyzer.a(paramString, locald).a(parame);
      return parame;
    }
    catch (IOException parame) {}
    return com.tencent.matrix.resource.analyzer.model.a.a(parame, 0L);
  }
  
  private void bS(boolean paramBoolean)
  {
    if (!this.isInitialized)
    {
      ad.w("MatrixDelegate", "[onAppForeground] but matrix is never initialized, delay to notify!");
      this.ctf = true;
      return;
    }
    if (aj.cbe())
    {
      MrsLogic.onForeground(paramBoolean);
      if (!paramBoolean) {
        com.tencent.e.h.Iye.f(new d.4(this), "MatrixDelegate");
      }
    }
    Iterator localIterator = b.GF().ctc.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.matrix.e.b localb = (com.tencent.matrix.e.b)localIterator.next();
      if (!(localb instanceof com.tencent.matrix.trace.a)) {
        localb.onForeground(paramBoolean);
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.ctj = paramBoolean;
      return;
    }
  }
  
  public final com.tencent.matrix.g.c.a GG()
  {
    return new d.1(this);
  }
  
  public final com.tencent.matrix.report.h GH()
  {
    long l2 = 5L;
    h.a locala = new h.a(aj.getContext());
    locala.cxd = Long.valueOf(com.tencent.mm.protocal.d.CpK);
    locala.cxm = Boolean.valueOf(bu.eEO());
    locala.cxe = com.tencent.mm.sdk.platformtools.h.REV;
    long l1 = l2;
    if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)
    {
      l1 = l2;
      if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)
      {
        if (!com.tencent.mm.sdk.platformtools.h.DEBUG) {
          break label188;
        }
        l1 = l2;
      }
    }
    for (;;)
    {
      locala.cxg = Long.valueOf(l1);
      Objects.requireNonNull(locala.context, "matrix report init, context is null");
      Objects.requireNonNull(locala.cxd, "matrix report init, clientVersion is null");
      Objects.requireNonNull(locala.cxe, "matrix report init, revision is null");
      Objects.requireNonNull(locala.cxg, "matrix report init, publishType is null");
      this.cte = new com.tencent.matrix.report.h(locala.context, locala.cxd, locala.cxe, locala.cxm, locala.cxg);
      ad.i("MatrixDelegate", "init matrix reporter. %s", new Object[] { this.cte });
      return this.cte;
      label188:
      l1 = l2;
      if (!com.tencent.mm.protocal.d.CpN) {
        if (com.tencent.mm.protocal.d.CpL) {
          l1 = 3L;
        } else if (com.tencent.mm.protocal.d.CpM) {
          l1 = 4L;
        } else {
          l1 = -1L;
        }
      }
    }
  }
  
  public final f GI()
  {
    return new f();
  }
  
  public final h.b GJ()
  {
    return new com.tencent.matrix.report.g();
  }
  
  public final n GK()
  {
    return new d.2(this);
  }
  
  public final void a(Application paramApplication)
  {
    this.application = paramApplication;
    this.cth = new com.tencent.matrix.strategy.d();
  }
  
  public final void a(Application paramApplication, b.a parama, f paramf)
  {
    boolean bool;
    if ((aj.cbe()) || (aj.eFJ()) || (aj.isAppBrandProcess())) {
      bool = true;
    }
    for (;;)
    {
      ad.i("MatrixDelegate", "[isEnableTracePlugin] isEnable=%s", new Object[] { Boolean.valueOf(bool) });
      Object localObject2;
      int i;
      label96:
      Object localObject1;
      if (bool)
      {
        com.tencent.matrix.trace.a.a.HS().cBy = true;
        localObject2 = new com.tencent.matrix.trace.a.b.a();
        ((com.tencent.matrix.trace.a.b.a)localObject2).cBH.cwi = paramf;
        i = this.ctg.getInt(com.tencent.c.a.a.a.IgX.name(), 0);
        if (i == 1)
        {
          bool = true;
          ad.i("MatrixDelegate", "[isEnableFPS] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          ((com.tencent.matrix.trace.a.b.a)localObject2).cBH.cBz = bool;
          i = this.ctg.getInt(com.tencent.c.a.a.a.Ihf.name(), 0);
          if (i != 1) {
            break label981;
          }
          bool = true;
          label159:
          ad.i("MatrixDelegate", "[isEnableEvilMethod] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          ((com.tencent.matrix.trace.a.b.a)localObject2).cBH.cBA = bool;
          i = this.ctg.getInt(com.tencent.c.a.a.a.Ihh.name(), 0);
          if (i != 1) {
            break label1017;
          }
          bool = true;
          label222:
          ad.i("MatrixDelegate", "[isEnableStartUp] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          ((com.tencent.matrix.trace.a.b.a)localObject2).cBH.cBB = bool;
          i = this.ctg.getInt(com.tencent.c.a.a.a.Ihg.name(), 0);
          if (i != 1) {
            break label1053;
          }
          bool = true;
          label285:
          ad.i("MatrixDelegate", "[isEnableAnr] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
          ((com.tencent.matrix.trace.a.b.a)localObject2).cBH.cBC = bool;
          if (!aj.cbe()) {
            break label1095;
          }
          localObject1 = "com.tencent.mm.app.WeChatSplashActivity;com.tencent.mm.plugin.account.ui.WelcomeActivity;";
          label334:
          ((com.tencent.matrix.trace.a.b.a)localObject2).cBH.cBE = ((String)localObject1);
          ((com.tencent.matrix.trace.a.b.a)localObject2).cBH.cxf = true;
          ((com.tencent.matrix.trace.a.b.a)localObject2).cBH.cBD = false;
          parama.a(new com.tencent.matrix.trace.a(((com.tencent.matrix.trace.a.b.a)localObject2).cBH));
          com.tencent.mm.sdk.b.a.ESL.b(new com.tencent.mm.sdk.b.c()
          {
            private static boolean GL()
            {
              try
              {
                boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pxt, true);
                ax.eGd().encode("clicfg_anr_report_all", bool);
                bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pxu, false);
                ax.eGd().encode("clicfg_normal_report", bool);
                return true;
              }
              catch (Exception localException)
              {
                ad.printErrStackTrace("MatrixDelegate", localException, "Cannot load A/B test", new Object[0]);
              }
              return true;
            }
          });
          this.cte.a(new com.tencent.matrix.b.a());
        }
      }
      else
      {
        i = this.ctg.getInt("ENABLE_BATTERY", 0);
        ad.i("MatrixDelegate", "[isEnableBatteryMonitor] value=%s", new Object[] { Integer.valueOf(i) });
        if (i != 1) {
          break label1103;
        }
        bool = true;
        label449:
        ad.i("MatrixDelegate", "[isEnableFPS] isEnable=%s value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (bool)
        {
          localObject1 = new com.tencent.matrix.a.c.a.a().X(com.tencent.matrix.a.c.a.b.class);
          ((com.tencent.matrix.a.c.a.a)localObject1).cuU.cvb = true;
          localObject2 = new com.tencent.matrix.report.a();
          ((com.tencent.matrix.a.c.a.a)localObject1).cuU.cuW = ((a.c)localObject2);
          ((com.tencent.matrix.a.c.a.a)localObject1).cuU.cuX = 120000L;
          ((com.tencent.matrix.a.c.a.a)localObject1).cuU.cuY = 30000L;
          ((com.tencent.matrix.a.c.a.a)localObject1).cuU.cva = true;
          ((com.tencent.matrix.a.c.a.a)localObject1).cuU.cuZ = 1200000L;
          Collections.sort(((com.tencent.matrix.a.c.a.a)localObject1).cuU.cvc, new a.a.1((com.tencent.matrix.a.c.a.a)localObject1));
          parama.a(new com.tencent.matrix.a.c.a(((com.tencent.matrix.a.c.a.a)localObject1).cuU));
        }
        if ((!aj.cbe()) && (!aj.eFJ()) && (!aj.isAppBrandProcess())) {
          break label1151;
        }
        bool = true;
        label625:
        ad.i("MatrixDelegate", "[isEnableActivityLeak] isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          localObject2 = new Intent();
          if (!bu.eEO()) {
            break label1157;
          }
          localObject1 = com.tencent.matrix.resource.b.a.b.czy;
          label670:
          ad.i("MatrixDelegate", "Dump Activity Leak Mode=%s", new Object[] { localObject1 });
          ((Intent)localObject2).setClassName(aj.getPackageName(), "com.tencent.mm.ui.matrix.ManualDumpActivity");
          com.tencent.matrix.resource.b.a.a locala = new com.tencent.matrix.resource.b.a.a();
          locala.cwi = paramf;
          locala.czw = ((com.tencent.matrix.resource.b.a.b)localObject1);
          locala.czv = ((Intent)localObject2);
          parama.a(new com.tencent.matrix.resource.b(new com.tencent.matrix.resource.b.a(locala.cwi, locala.czw, locala.czu, locala.czv, (byte)0)));
          com.tencent.matrix.resource.b.b(paramApplication);
        }
        ad.i("MatrixDelegate", "[isEnableIOCanary] isEnable=%s", new Object[] { Boolean.TRUE });
        paramApplication = new com.tencent.matrix.iocanary.a.a.a();
        paramApplication.cty = paramf;
        parama.a(new com.tencent.matrix.iocanary.a(new com.tencent.matrix.iocanary.a.a(paramApplication.cty, (byte)0)));
        bool = bu.eEO();
        ad.i("MatrixDelegate", "[isEnableSQLiteLint] isEnable=%s", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {}
      }
      try
      {
        paramApplication = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
        parama.a(new SQLiteLintPlugin(paramApplication));
        if (aj.cbe())
        {
          paramApplication = new com.tencent.matrix.d.a.a.a();
          paramApplication.cwi = paramf;
          parama.a(new com.tencent.matrix.d.a(new com.tencent.matrix.d.a.a(paramApplication.cwi, (byte)0)));
        }
        this.cte.a(new com.tencent.matrix.b.c());
        return;
        bool = false;
        continue;
        if ((i != -1) && ((aj.cbe()) || (aj.eFJ()) || (aj.isAppBrandProcess())))
        {
          bool = true;
          break label96;
        }
        bool = false;
        break label96;
        label981:
        if ((i != -1) && ((aj.cbe()) || (aj.eFJ()) || (aj.isAppBrandProcess())))
        {
          bool = true;
          break label159;
        }
        bool = false;
        break label159;
        label1017:
        if ((i != -1) && ((aj.cbe()) || (aj.eFJ()) || (aj.isAppBrandProcess())))
        {
          bool = true;
          break label222;
        }
        bool = false;
        break label222;
        label1053:
        if ((i != -1) && ((aj.cbe()) || (aj.eFJ()) || (aj.eFK()) || (aj.isAppBrandProcess())))
        {
          bool = true;
          break label285;
        }
        bool = false;
        break label285;
        label1095:
        localObject1 = "";
        break label334;
        label1103:
        if ((i != -1) && ((aj.cbe()) || (aj.eFJ()) || (aj.eFK()) || (aj.isAppBrandProcess()) || (aj.eFH())))
        {
          bool = true;
          break label449;
        }
        bool = false;
        break label449;
        label1151:
        bool = false;
        break label625;
        label1157:
        if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED))
        {
          localObject1 = com.tencent.matrix.resource.b.a.b.czA;
          break label670;
        }
        if (com.tencent.mm.protocal.d.CpN)
        {
          localObject1 = com.tencent.matrix.resource.b.a.b.czA;
          break label670;
        }
        localObject1 = com.tencent.matrix.resource.b.a.b.czx;
      }
      catch (Throwable paramApplication)
      {
        for (;;)
        {
          paramApplication = new SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode.CUSTOM_NOTIFY);
        }
      }
    }
  }
  
  public final void b(b paramb)
  {
    int i = 0;
    ad.i("MatrixDelegate", "onFinalJob");
    int j = this.ctg.getInt("ENABLE_FPS_FLOAT", 0);
    boolean bool;
    if (j == 1) {
      bool = true;
    }
    for (;;)
    {
      ad.i("MatrixDelegate", "[isEnableFpsFloat] enable=%s, value=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if (j == 1) {
        i = 1;
      }
      if ((i != 0) && (e.GM())) {
        aq.f(new d.3(this));
      }
      Application localApplication = this.application;
      paramb = (com.tencent.matrix.resource.b)paramb.V(com.tencent.matrix.resource.b.class);
      BroadcastReceiver local6;
      if (paramb != null)
      {
        paramb.cxF.cAC = new b.b()
        {
          final HashSet<String> ctm = new HashSet();
          private final Set<String> ctn = new HashSet();
          
          public final boolean C(final String paramAnonymousString1, final String paramAnonymousString2)
          {
            final long l1 = SystemClock.uptimeMillis();
            ad.i("MatrixDelegate", "[onLeak] activity=%s isEnableDump=%s isSilence=%s", new Object[] { paramAnonymousString1, Boolean.valueOf(d.b(d.this)), Boolean.valueOf(d.c(d.this)) });
            ad.i("MatrixDelegate", "[onLeak] Activity dump [%s]", new Object[] { com.tencent.mm.ae.a.agO() });
            if (!this.ctn.contains(paramAnonymousString2))
            {
              ad.i("MatrixDelegate", "[onLeak] Activity report: %s", new Object[] { paramAnonymousString2 });
              com.tencent.mm.plugin.report.service.h.vKh.f(18573, new Object[] { paramAnonymousString1, String.format("isEnableDump=%s isSilence=%s", new Object[] { Boolean.valueOf(d.b(d.this)), Boolean.valueOf(d.c(d.this)) }), Integer.valueOf(0), Integer.valueOf(5), Long.valueOf(l1) });
              this.ctn.add(paramAnonymousString2);
            }
            if ((d.b(d.this)) && (d.c(d.this)))
            {
              d.b(d.this, false);
              synchronized (this.ctm)
              {
                if (this.ctm.contains(paramAnonymousString1))
                {
                  ad.i("MatrixDelegate", "this activity has dumped! %s", new Object[] { paramAnonymousString1 });
                  return true;
                }
                ??? = (com.tencent.matrix.resource.b)b.GF().V(com.tencent.matrix.resource.b.class);
                if (??? == null)
                {
                  ad.e("MatrixDelegate", "ResourcePlugin not found!");
                  return false;
                }
              }
              if (((com.tencent.matrix.resource.b)???).cxF == null)
              {
                ad.e("MatrixDelegate", "ActivityRefWatcher not found!");
                return false;
              }
              long l2 = System.currentTimeMillis();
              ??? = com.tencent.mm.vfs.e.R(new com.tencent.matrix.resource.e.d(aj.getContext()).HH());
              if (??? == null) {
                return true;
              }
              try
              {
                Debug.dumpHprofData(q.B(((com.tencent.mm.vfs.e)???).fhU()));
                if (((com.tencent.mm.vfs.e)???).length() <= 0L)
                {
                  com.tencent.mm.plugin.report.service.h.vKh.f(18573, new Object[] { paramAnonymousString1, "file is null!", Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l1) });
                  ad.e("MatrixDelegate", "file is null!");
                  return true;
                }
              }
              catch (IOException localIOException)
              {
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.h.vKh.f(18573, new Object[] { paramAnonymousString1, "dump file error!", Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l1) });
                  ad.printErrStackTrace("MatrixDelegate", localIOException, "dump file error!", new Object[0]);
                }
                ad.i("MatrixDelegate", String.format("dump cost=%sms refString=%s path=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), paramAnonymousString2, q.B(((com.tencent.mm.vfs.e)???).fhU()) }));
                com.tencent.e.h.Iye.aP(new Runnable()
                {
                  /* Error */
                  public final void run()
                  {
                    // Byte code:
                    //   0: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   3: lstore_1
                    //   4: aload_0
                    //   5: getfield 26	com/tencent/matrix/d$5$1:cto	Lcom/tencent/mm/vfs/e;
                    //   8: aload_0
                    //   9: getfield 28	com/tencent/matrix/d$5$1:ctp	Ljava/lang/String;
                    //   12: invokestatic 51	com/tencent/matrix/d:b	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)Lcom/tencent/matrix/resource/analyzer/model/a;
                    //   15: astore_3
                    //   16: ldc 53
                    //   18: ldc 55
                    //   20: iconst_2
                    //   21: anewarray 4	java/lang/Object
                    //   24: dup
                    //   25: iconst_0
                    //   26: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   29: lload_1
                    //   30: lsub
                    //   31: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   34: aastore
                    //   35: dup
                    //   36: iconst_1
                    //   37: aload_0
                    //   38: getfield 28	com/tencent/matrix/d$5$1:ctp	Ljava/lang/String;
                    //   41: aastore
                    //   42: invokestatic 67	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
                    //   45: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
                    //   48: aload_3
                    //   49: invokevirtual 79	com/tencent/matrix/resource/analyzer/model/a:toString	()Ljava/lang/String;
                    //   52: astore 4
                    //   54: aload_3
                    //   55: getfield 83	com/tencent/matrix/resource/analyzer/model/a:cxI	Z
                    //   58: ifeq +57 -> 115
                    //   61: getstatic 89	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
                    //   64: sipush 18573
                    //   67: iconst_5
                    //   68: anewarray 4	java/lang/Object
                    //   71: dup
                    //   72: iconst_0
                    //   73: aload_0
                    //   74: getfield 30	com/tencent/matrix/d$5$1:ctq	Ljava/lang/String;
                    //   77: aastore
                    //   78: dup
                    //   79: iconst_1
                    //   80: aload 4
                    //   82: aastore
                    //   83: dup
                    //   84: iconst_2
                    //   85: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   88: lload_1
                    //   89: lsub
                    //   90: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   93: aastore
                    //   94: dup
                    //   95: iconst_3
                    //   96: bipush 7
                    //   98: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                    //   101: aastore
                    //   102: dup
                    //   103: iconst_4
                    //   104: aload_0
                    //   105: getfield 32	com/tencent/matrix/d$5$1:ctr	J
                    //   108: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   111: aastore
                    //   112: invokevirtual 98	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
                    //   115: ldc 53
                    //   117: aload 4
                    //   119: invokestatic 73	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
                    //   122: aload_0
                    //   123: getfield 24	com/tencent/matrix/d$5$1:cts	Lcom/tencent/matrix/d$5;
                    //   126: getfield 102	com/tencent/matrix/d$5:ctm	Ljava/util/HashSet;
                    //   129: astore_3
                    //   130: aload_3
                    //   131: monitorenter
                    //   132: aload_0
                    //   133: getfield 24	com/tencent/matrix/d$5$1:cts	Lcom/tencent/matrix/d$5;
                    //   136: getfield 102	com/tencent/matrix/d$5:ctm	Ljava/util/HashSet;
                    //   139: aload_0
                    //   140: getfield 30	com/tencent/matrix/d$5$1:ctq	Ljava/lang/String;
                    //   143: invokevirtual 108	java/util/HashSet:add	(Ljava/lang/Object;)Z
                    //   146: pop
                    //   147: aload_3
                    //   148: monitorexit
                    //   149: aload_0
                    //   150: getfield 26	com/tencent/matrix/d$5$1:cto	Lcom/tencent/mm/vfs/e;
                    //   153: invokevirtual 114	com/tencent/mm/vfs/e:delete	()Z
                    //   156: pop
                    //   157: return
                    //   158: astore 4
                    //   160: aload_3
                    //   161: monitorexit
                    //   162: aload 4
                    //   164: athrow
                    //   165: astore_3
                    //   166: getstatic 89	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
                    //   169: sipush 18573
                    //   172: iconst_5
                    //   173: anewarray 4	java/lang/Object
                    //   176: dup
                    //   177: iconst_0
                    //   178: aload_0
                    //   179: getfield 30	com/tencent/matrix/d$5$1:ctq	Ljava/lang/String;
                    //   182: aastore
                    //   183: dup
                    //   184: iconst_1
                    //   185: ldc 116
                    //   187: aastore
                    //   188: dup
                    //   189: iconst_2
                    //   190: invokestatic 45	java/lang/System:currentTimeMillis	()J
                    //   193: lload_1
                    //   194: lsub
                    //   195: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   198: aastore
                    //   199: dup
                    //   200: iconst_3
                    //   201: iconst_3
                    //   202: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
                    //   205: aastore
                    //   206: dup
                    //   207: iconst_4
                    //   208: aload_0
                    //   209: getfield 32	com/tencent/matrix/d$5$1:ctr	J
                    //   212: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
                    //   215: aastore
                    //   216: invokevirtual 98	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
                    //   219: ldc 53
                    //   221: aload_3
                    //   222: invokevirtual 120	java/lang/OutOfMemoryError:getCause	()Ljava/lang/Throwable;
                    //   225: ldc 122
                    //   227: iconst_0
                    //   228: anewarray 4	java/lang/Object
                    //   231: invokestatic 126	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
                    //   234: aload_0
                    //   235: getfield 26	com/tencent/matrix/d$5$1:cto	Lcom/tencent/mm/vfs/e;
                    //   238: invokevirtual 114	com/tencent/mm/vfs/e:delete	()Z
                    //   241: pop
                    //   242: return
                    //   243: astore_3
                    //   244: aload_0
                    //   245: getfield 26	com/tencent/matrix/d$5$1:cto	Lcom/tencent/mm/vfs/e;
                    //   248: invokevirtual 114	com/tencent/mm/vfs/e:delete	()Z
                    //   251: pop
                    //   252: aload_3
                    //   253: athrow
                    // Local variable table:
                    //   start	length	slot	name	signature
                    //   0	254	0	this	1
                    //   3	191	1	l	long
                    //   165	57	3	localOutOfMemoryError	java.lang.OutOfMemoryError
                    //   243	10	3	localObject2	Object
                    //   52	66	4	str	String
                    //   158	5	4	localObject3	Object
                    // Exception table:
                    //   from	to	target	type
                    //   132	149	158	finally
                    //   160	162	158	finally
                    //   4	115	165	java/lang/OutOfMemoryError
                    //   115	132	165	java/lang/OutOfMemoryError
                    //   162	165	165	java/lang/OutOfMemoryError
                    //   4	115	243	finally
                    //   115	132	243	finally
                    //   162	165	243	finally
                    //   166	234	243	finally
                  }
                });
                return true;
              }
            }
            return false;
          }
        };
        paramb = new IntentFilter();
        paramb.addAction("android.intent.action.SCREEN_OFF");
        local6 = new BroadcastReceiver()
        {
          public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
          {
            if (Objects.equals(paramAnonymousIntent.getAction(), "android.intent.action.SCREEN_OFF"))
            {
              d.b(d.this, true);
              paramAnonymousContext = d.this;
              if ((!com.tencent.mm.sdk.platformtools.h.DEBUG) && (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plp, false))) {
                break label85;
              }
            }
            label85:
            for (boolean bool = true;; bool = false)
            {
              d.c(paramAnonymousContext, bool);
              ad.i("MatrixDelegate", "[ACTION_SCREEN_OFF] isEnableDump=%s", new Object[] { Boolean.valueOf(d.b(d.this)) });
              return;
            }
          }
        };
      }
      try
      {
        localApplication.getApplicationContext().registerReceiver(local6, paramb);
        this.isInitialized = true;
        if (this.ctf) {
          bS(AppForegroundDelegate.cKE.csU);
        }
        return;
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localApplication.getApplicationContext().unregisterReceiver(local6);
          localApplication.getApplicationContext().registerReceiver(local6, paramb);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.d
 * JD-Core Version:    0.7.0.1
 */