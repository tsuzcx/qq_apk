package com.tencent.mm.plugin.appbrand;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.n;
import com.tencent.mm.plugin.appbrand.report.quality.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.plugin.expansions.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import d.z;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

final class k
  extends AppBrandRuntime.b
{
  final o jxG;
  private final j jxH;
  volatile boolean jxI;
  private volatile boolean jxJ;
  private volatile k.a jxK;
  volatile ae jxL;
  volatile com.tencent.mm.plugin.appbrand.service.c jxM;
  private final AtomicBoolean jxN;
  private final AtomicBoolean jxO;
  com.tencent.mm.vending.g.e<com.tencent.mm.plugin.appbrand.service.c> jxP;
  com.tencent.mm.vending.g.e<ae> jxQ;
  
  k(o paramo)
  {
    AppMethodBeat.i(43832);
    this.jxI = false;
    this.jxJ = false;
    this.jxN = new AtomicBoolean(false);
    this.jxO = new AtomicBoolean(false);
    this.jxG = paramo;
    this.jxH = new j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43799);
        if ((k.this.jxI) || (k.this.jxL == null)) {}
        try
        {
          com.tencent.mm.plugin.appbrand.report.quality.a.Ut(k.this.jxG.mAppId).mvy = i.muP;
          label44:
          k.this.n("countDown == 0, notify process ready", new Object[0]);
          k.this.BI();
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
  
  private String aWs()
  {
    AppMethodBeat.i(43835);
    String str = String.format(Locale.US, "Runtime[%s %d %s]~~%d~~ ", new Object[] { this.jxG.mAppId, Integer.valueOf(this.jxG.jwG.dPf), com.tencent.mm.plugin.appbrand.task.e.hA(this.jxG.Eb()).name(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43835);
    return str;
  }
  
  final f<Void> Kz(final String paramString)
  {
    AppMethodBeat.i(187877);
    paramString = new f()
    {
      public final f<Void> a(com.tencent.mm.vending.e.b paramAnonymousb)
      {
        AppMethodBeat.i(187875);
        paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
        {
          public final void dead()
          {
            AppMethodBeat.i(187874);
            k.this.n("pipeline(%s) will be stopped", new Object[] { k.9.this.cqe });
            AppMethodBeat.o(187874);
          }
        });
        paramAnonymousb = super.a(paramAnonymousb);
        AppMethodBeat.o(187875);
        return paramAnonymousb;
      }
    }.a(this.jxG).L(new Object[0]);
    AppMethodBeat.o(187877);
    return paramString;
  }
  
  final void a(k.a parama)
  {
    AppMethodBeat.i(43838);
    if ((this.jxQ == null) || (this.jxI))
    {
      n("tryPreloadBeforeResourceDone mPageViewPipeline null || mProcessExpired", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    if (this.jxJ)
    {
      n("tryPreloadBeforeResourceDone function already appended by reason[%s]", new Object[] { this.jxK });
      AppMethodBeat.o(43838);
      return;
    }
    n("tryPreloadBeforeResourceDone tryDoAheadPreloadPageView by reason[%s]", new Object[] { parama });
    this.jxJ = true;
    this.jxK = parama;
    if (this.jxQ.LhW)
    {
      n("mPageViewPipeline has stopped", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    this.jxQ.c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(43838);
  }
  
  final void aWq()
  {
    AppMethodBeat.i(174647);
    if (!this.jxO.getAndSet(true)) {
      this.jxH.countDown();
    }
    AppMethodBeat.o(174647);
  }
  
  final void aWr()
  {
    AppMethodBeat.i(174648);
    if (!this.jxN.getAndSet(true)) {
      this.jxH.countDown();
    }
    AppMethodBeat.o(174648);
  }
  
  final com.tencent.mm.plugin.appbrand.service.c aWt()
  {
    com.tencent.mm.plugin.appbrand.service.c localc = this.jxM;
    this.jxM = null;
    return localc;
  }
  
  final ae aWu()
  {
    ae localae = this.jxL;
    this.jxL = null;
    return localae;
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(43836);
    o("interrupt()", new Object[0]);
    this.jxI = true;
    Object localObject = aWt();
    if (localObject != null) {}
    try
    {
      ((com.tencent.mm.plugin.appbrand.service.c)localObject).cleanup();
      if (this.jxP != null) {
        this.jxP.yY(true);
      }
      localObject = aWu();
      if (localObject == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        ((ae)localObject).cleanup();
        if (this.jxQ != null) {
          this.jxQ.yY(true);
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
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", aWs() + paramString, paramVarArgs);
    AppMethodBeat.o(43833);
  }
  
  final void o(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43834);
    ad.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", aWs() + paramString, paramVarArgs);
    AppMethodBeat.o(43834);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(43837);
    final j localj = new j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43818);
        if (!k.this.jxI)
        {
          k localk = k.this;
          if (localk.jxG.Fe())
          {
            localk.n("service countDown by remoteDebug", new Object[0]);
            localk.jxP = null;
            localk.aWq();
          }
          while (localk.jxG.Eb())
          {
            localk.n("tryPreloadPageView ignore for game, countdown", new Object[0]);
            localk.jxQ = null;
            localk.aWr();
            AppMethodBeat.o(43818);
            return;
            localk.jxP = ((com.tencent.mm.vending.g.e)localk.Kz("preloadAppService").h(new k.16(localk)).g(new k.15(localk)).a(com.tencent.mm.vending.h.d.LiM, new k.14(localk)).a(com.tencent.mm.vending.h.d.LiM, new k.13(localk)));
          }
          localk.jxQ = localk.Kz("tryPreloadPageView").h(new k.2(localk)).g(new k.17(localk));
        }
        AppMethodBeat.o(43818);
      }
    }, 2);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.jxG.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
    com.tencent.mm.plugin.expansions.a.a(new a.b()
    {
      public final void a(com.tencent.mm.toolkit.frontia.a.c.a paramAnonymousa)
      {
        AppMethodBeat.i(43819);
        localj.countDown();
        com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.jxG.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
        AppMethodBeat.o(43819);
      }
    });
    com.tencent.mm.plugin.appbrand.launching.g.a(this.jxG, new d.g.a.b() {});
    AppMethodBeat.o(43837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k
 * JD-Core Version:    0.7.0.1
 */