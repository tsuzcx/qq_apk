package com.tencent.mm.plugin.appbrand;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
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
import d.y;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

final class k
  extends AppBrandRuntime.b
{
  private volatile boolean iEA;
  private volatile k.a iEB;
  volatile ae iEC;
  volatile com.tencent.mm.plugin.appbrand.service.c iED;
  private final AtomicBoolean iEE;
  private final AtomicBoolean iEF;
  com.tencent.mm.vending.g.e<com.tencent.mm.plugin.appbrand.service.c> iEG;
  com.tencent.mm.vending.g.e<ae> iEH;
  final o iEx;
  private final j iEy;
  volatile boolean iEz;
  
  k(o paramo)
  {
    AppMethodBeat.i(43832);
    this.iEz = false;
    this.iEA = false;
    this.iEE = new AtomicBoolean(false);
    this.iEF = new AtomicBoolean(false);
    this.iEx = paramo;
    this.iEy = new j(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43799);
        if ((k.this.iEz) || (k.this.iEC == null)) {}
        try
        {
          com.tencent.mm.plugin.appbrand.report.quality.a.ME(k.this.iEx.mAppId).ltO = i.ltf;
          label44:
          k.this.l("countDown == 0, notify process ready", new Object[0]);
          k.this.AH();
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
  
  private String aMu()
  {
    AppMethodBeat.i(43835);
    String str = String.format(Locale.US, "Runtime[%s %d %s]~~%d~~ ", new Object[] { this.iEx.mAppId, Integer.valueOf(this.iEx.iDx.iOP), com.tencent.mm.plugin.appbrand.task.e.gW(this.iEx.CZ()).name(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43835);
    return str;
  }
  
  final f<Void> Dj(final String paramString)
  {
    AppMethodBeat.i(195523);
    paramString = new f()
    {
      public final f<Void> a(com.tencent.mm.vending.e.b paramAnonymousb)
      {
        AppMethodBeat.i(195521);
        paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
        {
          public final void dead()
          {
            AppMethodBeat.i(195520);
            k.this.l("pipeline(%s) will be stopped", new Object[] { k.9.this.ciS });
            AppMethodBeat.o(195520);
          }
        });
        paramAnonymousb = super.a(paramAnonymousb);
        AppMethodBeat.o(195521);
        return paramAnonymousb;
      }
    }.a(this.iEx).I(new Object[0]);
    AppMethodBeat.o(195523);
    return paramString;
  }
  
  final void a(k.a parama)
  {
    AppMethodBeat.i(43838);
    if ((this.iEH == null) || (this.iEz))
    {
      l("tryPreloadBeforeResourceDone mPageViewPipeline null || mProcessExpired", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    if (this.iEA)
    {
      l("tryPreloadBeforeResourceDone function already appended by reason[%s]", new Object[] { this.iEB });
      AppMethodBeat.o(43838);
      return;
    }
    l("tryPreloadBeforeResourceDone tryDoAheadPreloadPageView by reason[%s]", new Object[] { parama });
    this.iEA = true;
    this.iEB = parama;
    if (this.iEH.HPW)
    {
      l("mPageViewPipeline has stopped", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    this.iEH.c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(43838);
  }
  
  final void aMs()
  {
    AppMethodBeat.i(174647);
    if (!this.iEF.getAndSet(true)) {
      this.iEy.countDown();
    }
    AppMethodBeat.o(174647);
  }
  
  final void aMt()
  {
    AppMethodBeat.i(174648);
    if (!this.iEE.getAndSet(true)) {
      this.iEy.countDown();
    }
    AppMethodBeat.o(174648);
  }
  
  final com.tencent.mm.plugin.appbrand.service.c aMv()
  {
    com.tencent.mm.plugin.appbrand.service.c localc = this.iED;
    this.iED = null;
    return localc;
  }
  
  final ae aMw()
  {
    ae localae = this.iEC;
    this.iEC = null;
    return localae;
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(43836);
    m("interrupt()", new Object[0]);
    this.iEz = true;
    Object localObject = aMv();
    if (localObject != null) {}
    try
    {
      ((com.tencent.mm.plugin.appbrand.service.c)localObject).cleanup();
      if (this.iEG != null) {
        this.iEG.xd(true);
      }
      localObject = aMw();
      if (localObject == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        ((ae)localObject).cleanup();
        if (this.iEH != null) {
          this.iEH.xd(true);
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
    ad.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", aMu() + paramString, paramVarArgs);
    AppMethodBeat.o(43833);
  }
  
  final void m(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43834);
    ad.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", aMu() + paramString, paramVarArgs);
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
        if (!k.this.iEz)
        {
          k localk = k.this;
          if (localk.iEx.Ec())
          {
            localk.l("service countDown by remoteDebug", new Object[0]);
            localk.iEG = null;
            localk.aMs();
          }
          while (localk.iEx.CZ())
          {
            localk.l("tryPreloadPageView ignore for game, countdown", new Object[0]);
            localk.iEH = null;
            localk.aMt();
            AppMethodBeat.o(43818);
            return;
            localk.iEG = ((com.tencent.mm.vending.g.e)localk.Dj("preloadAppService").h(new k.16(localk)).g(new k.15(localk)).a(com.tencent.mm.vending.h.d.HQM, new k.14(localk)).a(com.tencent.mm.vending.h.d.HQM, new k.13(localk)));
          }
          localk.iEH = localk.Dj("tryPreloadPageView").h(new k.2(localk)).g(new k.17(localk));
        }
        AppMethodBeat.o(43818);
      }
    }, 2);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.iEx.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
    com.tencent.mm.plugin.expansions.a.a(new a.b()
    {
      public final void a(com.tencent.mm.toolkit.frontia.a.c.a paramAnonymousa)
      {
        AppMethodBeat.i(43819);
        localj.countDown();
        com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.iEx.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
        AppMethodBeat.o(43819);
      }
    });
    com.tencent.mm.plugin.appbrand.launching.g.a(this.iEx, new d.g.a.b() {});
    AppMethodBeat.o(43837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k
 * JD-Core Version:    0.7.0.1
 */