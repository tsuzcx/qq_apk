package com.tencent.mm.plugin.appbrand;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.quality.i;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.plugin.expansions.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import d.y;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

final class k
  extends AppBrandRuntime.b
{
  private final j jeA;
  volatile boolean jeB;
  private volatile boolean jeC;
  private volatile a jeD;
  volatile ae jeE;
  volatile com.tencent.mm.plugin.appbrand.service.c jeF;
  private final AtomicBoolean jeG;
  private final AtomicBoolean jeH;
  com.tencent.mm.vending.g.e<com.tencent.mm.plugin.appbrand.service.c> jeI;
  com.tencent.mm.vending.g.e<ae> jeJ;
  final o jez;
  
  k(o paramo)
  {
    AppMethodBeat.i(43832);
    this.jeB = false;
    this.jeC = false;
    this.jeG = new AtomicBoolean(false);
    this.jeH = new AtomicBoolean(false);
    this.jez = paramo;
    this.jeA = new j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43799);
        if ((k.this.jeB) || (k.this.jeE == null)) {}
        try
        {
          com.tencent.mm.plugin.appbrand.report.quality.a.QN(k.this.jez.mAppId).lVI = i.lUZ;
          label44:
          k.this.l("countDown == 0, notify process ready", new Object[0]);
          k.this.Al();
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
  
  private String aTk()
  {
    AppMethodBeat.i(43835);
    String str = String.format(Locale.US, "Runtime[%s %d %s]~~%d~~ ", new Object[] { this.jez.mAppId, Integer.valueOf(this.jez.jdx.joY), com.tencent.mm.plugin.appbrand.task.e.ht(this.jez.CC()).name(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43835);
    return str;
  }
  
  final f<Void> Hm(final String paramString)
  {
    AppMethodBeat.i(186222);
    paramString = new f()
    {
      public final f<Void> a(com.tencent.mm.vending.e.b paramAnonymousb)
      {
        AppMethodBeat.i(186220);
        paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
        {
          public final void dead()
          {
            AppMethodBeat.i(186219);
            k.this.l("pipeline(%s) will be stopped", new Object[] { k.9.this.cfO });
            AppMethodBeat.o(186219);
          }
        });
        paramAnonymousb = super.a(paramAnonymousb);
        AppMethodBeat.o(186220);
        return paramAnonymousb;
      }
    }.a(this.jez).K(new Object[0]);
    AppMethodBeat.o(186222);
    return paramString;
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(43838);
    if ((this.jeJ == null) || (this.jeB))
    {
      l("tryPreloadBeforeResourceDone mPageViewPipeline null || mProcessExpired", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    if (this.jeC)
    {
      l("tryPreloadBeforeResourceDone function already appended by reason[%s]", new Object[] { this.jeD });
      AppMethodBeat.o(43838);
      return;
    }
    l("tryPreloadBeforeResourceDone tryDoAheadPreloadPageView by reason[%s]", new Object[] { parama });
    this.jeC = true;
    this.jeD = parama;
    if (this.jeJ.Jqr)
    {
      l("mPageViewPipeline has stopped", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    this.jeJ.c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(43838);
  }
  
  final void aTi()
  {
    AppMethodBeat.i(174647);
    if (!this.jeH.getAndSet(true)) {
      this.jeA.countDown();
    }
    AppMethodBeat.o(174647);
  }
  
  final void aTj()
  {
    AppMethodBeat.i(174648);
    if (!this.jeG.getAndSet(true)) {
      this.jeA.countDown();
    }
    AppMethodBeat.o(174648);
  }
  
  final com.tencent.mm.plugin.appbrand.service.c aTl()
  {
    com.tencent.mm.plugin.appbrand.service.c localc = this.jeF;
    this.jeF = null;
    return localc;
  }
  
  final ae aTm()
  {
    ae localae = this.jeE;
    this.jeE = null;
    return localae;
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(43836);
    m("interrupt()", new Object[0]);
    this.jeB = true;
    Object localObject = aTl();
    if (localObject != null) {}
    try
    {
      ((com.tencent.mm.plugin.appbrand.service.c)localObject).cleanup();
      if (this.jeI != null) {
        this.jeI.ym(true);
      }
      localObject = aTm();
      if (localObject == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        ((ae)localObject).cleanup();
        if (this.jeJ != null) {
          this.jeJ.ym(true);
        }
        AppMethodBeat.o(43836);
        return;
        localThrowable1 = localThrowable1;
        m("interrupt() cleanup service e=%s", new Object[] { localThrowable1 });
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          m("interrupt() cleanup page e=%s", new Object[] { localThrowable2 });
        }
      }
    }
  }
  
  final void l(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43833);
    ac.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", aTk() + paramString, paramVarArgs);
    AppMethodBeat.o(43833);
  }
  
  final void m(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43834);
    ac.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", aTk() + paramString, paramVarArgs);
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
        if (!k.this.jeB)
        {
          k localk = k.this;
          if (localk.jez.DF())
          {
            localk.l("service countDown by remoteDebug", new Object[0]);
            localk.jeI = null;
            localk.aTi();
          }
          while (localk.jez.CC())
          {
            localk.l("tryPreloadPageView ignore for game, countdown", new Object[0]);
            localk.jeJ = null;
            localk.aTj();
            AppMethodBeat.o(43818);
            return;
            localk.jeI = ((com.tencent.mm.vending.g.e)localk.Hm("preloadAppService").h(new k.16(localk)).g(new k.15(localk)).a(com.tencent.mm.vending.h.d.Jrh, new k.14(localk)).a(com.tencent.mm.vending.h.d.Jrh, new k.13(localk)));
          }
          localk.jeJ = localk.Hm("tryPreloadPageView").h(new k.2(localk)).g(new k.17(localk));
        }
        AppMethodBeat.o(43818);
      }
    }, 2);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.jez.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
    com.tencent.mm.plugin.expansions.a.a(new a.b()
    {
      public final void a(com.tencent.mm.toolkit.frontia.a.c.a paramAnonymousa)
      {
        AppMethodBeat.i(43819);
        localj.countDown();
        com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.jez.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
        AppMethodBeat.o(43819);
      }
    });
    com.tencent.mm.plugin.appbrand.launching.g.a(this.jez, new d.g.a.b() {});
    AppMethodBeat.o(43837);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(43831);
      jeW = new a("SYNC_LAUNCH", 0);
      jeX = new a("SYNC_GET_CODE", 1);
      jeY = new a("SYNC_JSAPIINFO", 2);
      jeZ = new a[] { jeW, jeX, jeY };
      AppMethodBeat.o(43831);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k
 * JD-Core Version:    0.7.0.1
 */