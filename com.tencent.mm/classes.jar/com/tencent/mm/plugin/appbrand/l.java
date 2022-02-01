package com.tencent.mm.plugin.appbrand;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.quality.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.plugin.expansions.a.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import d.z;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

final class l
  extends AppBrandRuntime.b
{
  final p jAF;
  private final k jAG;
  volatile boolean jAH;
  private volatile boolean jAI;
  private volatile a jAJ;
  volatile ad jAK;
  volatile com.tencent.mm.plugin.appbrand.service.c jAL;
  private final AtomicBoolean jAM;
  private final AtomicBoolean jAN;
  com.tencent.mm.vending.g.e<com.tencent.mm.plugin.appbrand.service.c> jAO;
  com.tencent.mm.vending.g.e<ad> jAP;
  
  l(p paramp)
  {
    AppMethodBeat.i(43832);
    this.jAH = false;
    this.jAI = false;
    this.jAM = new AtomicBoolean(false);
    this.jAN = new AtomicBoolean(false);
    this.jAF = paramp;
    this.jAG = new k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43799);
        if ((l.this.jAH) || (l.this.jAK == null)) {}
        try
        {
          com.tencent.mm.plugin.appbrand.report.quality.a.Ve(l.this.jAF.mAppId).mAv = i.mzM;
          label44:
          l.this.n("countDown == 0, notify process ready", new Object[0]);
          l.this.BJ();
          AppMethodBeat.o(43799);
          return;
        }
        catch (Exception localException)
        {
          break label44;
        }
      }
    }, 2);
    AppMethodBeat.o(43832);
  }
  
  private String aWU()
  {
    AppMethodBeat.i(43835);
    String str = String.format(Locale.US, "Runtime[%s %d %s]~~%d~~ ", new Object[] { this.jAF.mAppId, Integer.valueOf(this.jAF.jzC.dQv), com.tencent.mm.plugin.appbrand.task.e.hB(this.jAF.Ee()).name(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43835);
    return str;
  }
  
  final f<Void> KX(final String paramString)
  {
    AppMethodBeat.i(221986);
    paramString = new f()
    {
      public final f<Void> a(com.tencent.mm.vending.e.b paramAnonymousb)
      {
        AppMethodBeat.i(221984);
        paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
        {
          public final void dead()
          {
            AppMethodBeat.i(221983);
            l.this.n("pipeline(%s) will be stopped", new Object[] { l.9.this.cqH });
            AppMethodBeat.o(221983);
          }
        });
        paramAnonymousb = super.a(paramAnonymousb);
        AppMethodBeat.o(221984);
        return paramAnonymousb;
      }
    }.a(this.jAF).K(new Object[0]);
    AppMethodBeat.o(221986);
    return paramString;
  }
  
  final void a(final a parama)
  {
    AppMethodBeat.i(43838);
    if ((this.jAP == null) || (this.jAH))
    {
      n("tryPreloadBeforeResourceDone mPageViewPipeline null || mProcessExpired", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    if (this.jAI)
    {
      n("tryPreloadBeforeResourceDone function already appended by reason[%s]", new Object[] { this.jAJ });
      AppMethodBeat.o(43838);
      return;
    }
    n("tryPreloadBeforeResourceDone tryDoAheadPreloadPageView by reason[%s]", new Object[] { parama });
    this.jAI = true;
    this.jAJ = parama;
    if (this.jAP.LEy)
    {
      n("mPageViewPipeline has stopped", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    this.jAP.c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(43838);
  }
  
  final void aWS()
  {
    AppMethodBeat.i(174647);
    if (!this.jAN.getAndSet(true)) {
      this.jAG.countDown();
    }
    AppMethodBeat.o(174647);
  }
  
  final void aWT()
  {
    AppMethodBeat.i(174648);
    if (!this.jAM.getAndSet(true)) {
      this.jAG.countDown();
    }
    AppMethodBeat.o(174648);
  }
  
  final com.tencent.mm.plugin.appbrand.service.c aWV()
  {
    com.tencent.mm.plugin.appbrand.service.c localc = this.jAL;
    this.jAL = null;
    return localc;
  }
  
  final ad aWW()
  {
    ad localad = this.jAK;
    this.jAK = null;
    return localad;
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(43836);
    o("interrupt()", new Object[0]);
    this.jAH = true;
    Object localObject = aWV();
    if (localObject != null) {}
    try
    {
      ((com.tencent.mm.plugin.appbrand.service.c)localObject).cleanup();
      if (this.jAO != null) {
        this.jAO.zm(true);
      }
      localObject = aWW();
      if (localObject == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        ((ad)localObject).cleanup();
        if (this.jAP != null) {
          this.jAP.zm(true);
        }
        AppMethodBeat.o(43836);
        return;
        localThrowable1 = localThrowable1;
        o("interrupt() cleanup service e=%s", new Object[] { localThrowable1 });
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          o("interrupt() cleanup page e=%s", new Object[] { localThrowable2 });
        }
      }
    }
  }
  
  final void n(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43833);
    ae.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", aWU() + paramString, paramVarArgs);
    AppMethodBeat.o(43833);
  }
  
  final void o(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43834);
    ae.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", aWU() + paramString, paramVarArgs);
    AppMethodBeat.o(43834);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(43837);
    final k localk = new k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43818);
        l locall;
        if (!l.this.jAH)
        {
          locall = l.this;
          if (!locall.jAF.Fj()) {
            break label111;
          }
          locall.n("service countDown by remoteDebug", new Object[0]);
          locall.jAO = null;
          locall.aWS();
          if (!locall.jAF.Ee()) {
            break label179;
          }
          locall.n("tryPreloadPageView ignore for game, countdown", new Object[0]);
          locall.jAP = null;
          locall.aWT();
        }
        for (;;)
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBO, 0) > 0) {
            locall.a(l.a.jBg);
          }
          AppMethodBeat.o(43818);
          return;
          label111:
          locall.jAO = ((com.tencent.mm.vending.g.e)locall.KX("preloadAppService").h(new l.16(locall)).g(new l.15(locall)).a(com.tencent.mm.vending.h.d.LFo, new l.14(locall)).a(com.tencent.mm.vending.h.d.LFo, new l.13(locall)));
          break;
          label179:
          locall.jAP = locall.KX("tryPreloadPageView").h(new l.2(locall)).g(new l.17(locall));
        }
      }
    }, 2);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.jAF.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
    com.tencent.mm.plugin.expansions.a.a(new a.b()
    {
      public final void a(com.tencent.mm.toolkit.frontia.a.c.a paramAnonymousa)
      {
        AppMethodBeat.i(43819);
        localk.countDown();
        com.tencent.mm.plugin.appbrand.keylogger.c.b(l.this.jAF.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
        AppMethodBeat.o(43819);
      }
    });
    com.tencent.mm.plugin.appbrand.launching.g.a(this.jAF, new d.g.a.b() {});
    AppMethodBeat.o(43837);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(43831);
      jBd = new a("SYNC_LAUNCH", 0);
      jBe = new a("SYNC_GET_CODE", 1);
      jBf = new a("SYNC_JSAPIINFO", 2);
      jBg = new a("X_CONFIG", 3);
      jBh = new a[] { jBd, jBe, jBf, jBg };
      AppMethodBeat.o(43831);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l
 * JD-Core Version:    0.7.0.1
 */