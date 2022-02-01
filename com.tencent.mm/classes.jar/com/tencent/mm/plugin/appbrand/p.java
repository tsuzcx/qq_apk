package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.j;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.h.b;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.plugin.expansions.a.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.toolkit.frontia.a.c.a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.x;

final class p
  extends AppBrandRuntime.b
{
  final t nuJ;
  private final com.tencent.luggage.sdk.h.b nuK;
  volatile boolean nuL;
  private volatile boolean nuM;
  private volatile p.a nuN;
  volatile ah nuO;
  volatile com.tencent.mm.plugin.appbrand.service.c nuP;
  private final AtomicBoolean nuQ;
  private final AtomicBoolean nuR;
  com.tencent.mm.vending.g.e<com.tencent.mm.plugin.appbrand.service.c> nuS;
  com.tencent.mm.vending.g.e<ah> nuT;
  
  p(t paramt)
  {
    AppMethodBeat.i(43832);
    this.nuL = false;
    this.nuM = false;
    this.nuQ = new AtomicBoolean(false);
    this.nuR = new AtomicBoolean(false);
    this.nuJ = paramt;
    this.nuK = new com.tencent.luggage.sdk.h.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43799);
        if ((p.this.nuL) || (p.this.nuO == null)) {}
        try
        {
          com.tencent.mm.plugin.appbrand.report.quality.b.amO(p.this.nuJ.mAppId).qNN = j.qNd;
          label44:
          p.this.m("countDown == 0, notify process ready", new Object[0]);
          p.this.NO();
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
  
  private String bCI()
  {
    AppMethodBeat.i(43835);
    String str = String.format(Locale.US, "Runtime[%s %d %s]~~%d~~ ", new Object[] { this.nuJ.mAppId, Integer.valueOf(this.nuJ.ntz.cBI), n.jA(this.nuJ.Qv()).name(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43835);
    return str;
  }
  
  final void a(final p.a parama)
  {
    AppMethodBeat.i(43838);
    if ((this.nuT == null) || (this.nuL))
    {
      m("tryPreloadBeforeResourceDone mPageViewPipeline null || mProcessExpired", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    if (this.nuM)
    {
      m("tryPreloadBeforeResourceDone function already appended by reason[%s]", new Object[] { this.nuN });
      AppMethodBeat.o(43838);
      return;
    }
    m("tryPreloadBeforeResourceDone tryDoAheadPreloadPageView by reason[%s]", new Object[] { parama });
    this.nuM = true;
    this.nuN = parama;
    if (this.nuT.YAh)
    {
      m("mPageViewPipeline has stopped", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    this.nuT.c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(43838);
  }
  
  final com.tencent.mm.cw.f<Void> abP(final String paramString)
  {
    AppMethodBeat.i(276853);
    paramString = new com.tencent.mm.cw.f()
    {
      public final com.tencent.mm.cw.f<Void> a(com.tencent.mm.vending.e.b paramAnonymousb)
      {
        AppMethodBeat.i(258213);
        paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
        {
          public final void dead()
          {
            AppMethodBeat.i(246313);
            p.this.m("pipeline(%s) will be stopped", new Object[] { p.16.this.cDG });
            AppMethodBeat.o(246313);
          }
        });
        paramAnonymousb = super.a(paramAnonymousb);
        AppMethodBeat.o(258213);
        return paramAnonymousb;
      }
    }.a(this.nuJ).M(new Object[0]);
    AppMethodBeat.o(276853);
    return paramString;
  }
  
  final void bCG()
  {
    AppMethodBeat.i(174647);
    if (!this.nuR.getAndSet(true)) {
      this.nuK.Sz();
    }
    AppMethodBeat.o(174647);
  }
  
  final void bCH()
  {
    AppMethodBeat.i(174648);
    if (!this.nuQ.getAndSet(true)) {
      this.nuK.Sz();
    }
    AppMethodBeat.o(174648);
  }
  
  final com.tencent.mm.plugin.appbrand.service.c bCJ()
  {
    com.tencent.mm.plugin.appbrand.service.c localc = this.nuP;
    this.nuP = null;
    return localc;
  }
  
  final ah bCK()
  {
    ah localah = this.nuO;
    this.nuO = null;
    return localah;
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(43836);
    n("interrupt()", new Object[0]);
    this.nuL = true;
    Object localObject = bCJ();
    if (localObject != null) {}
    try
    {
      ((com.tencent.mm.plugin.appbrand.service.c)localObject).cleanup();
      if (this.nuS != null) {
        this.nuS.HS(true);
      }
      localObject = bCK();
      if (localObject == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        ((ah)localObject).cleanup();
        if (this.nuT != null) {
          this.nuT.HS(true);
        }
        AppMethodBeat.o(43836);
        return;
        localThrowable1 = localThrowable1;
        n("interrupt() cleanup service e=%s", new Object[] { localThrowable1 });
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          n("interrupt() cleanup page e=%s", new Object[] { localThrowable2 });
        }
      }
    }
  }
  
  final void m(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43833);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", bCI() + paramString, paramVarArgs);
    AppMethodBeat.o(43833);
  }
  
  final void n(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43834);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", bCI() + paramString, paramVarArgs);
    AppMethodBeat.o(43834);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(43837);
    final com.tencent.luggage.sdk.h.b localb = new com.tencent.luggage.sdk.h.b(new Runnable()
    {
      public final void run()
      {
        Object localObject2 = null;
        AppMethodBeat.i(43818);
        if (!p.this.nuL)
        {
          p localp = p.this;
          if (localp.nuJ.Rp())
          {
            localp.m("service countDown by remoteDebug", new Object[0]);
            localp.nuS = null;
            localp.bCG();
            if (!localp.nuJ.Qv()) {
              break label324;
            }
            localp.m("tryPreloadPageView ignore for game, countdown", new Object[0]);
            localp.nuT = null;
            localp.bCH();
          }
          for (;;)
          {
            for (;;)
            {
              if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vBk, 0) <= 0) {
                break label493;
              }
              try
              {
                localp.a(p.a.nvm);
                AppMethodBeat.o(43818);
                return;
              }
              catch (e.c localc)
              {
                String str1;
                String str2;
                Object localObject1;
                com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", localc, "tryPreloadBeforeResourceDone(PreloadReason.X_CONFIG)", new Object[0]);
              }
              if ((localp.nuJ.Sk().cxf.scene == 1030) && (DebuggerShell.bLS()))
              {
                str1 = com.tencent.mm.plugin.appbrand.debugger.e.dd(localp.nuJ.mAppId, "Needjs");
                if ((!TextUtils.isEmpty(str1)) && (u.agG(str1))) {
                  try
                  {
                    str1 = u.bBS(str1);
                    if (!TextUtils.isEmpty(str1)) {
                      localp.nuS = ((com.tencent.mm.vending.g.e)localp.abP("preloadMonkeyTestAppService").h(new p.21(localp, str1)).a(com.tencent.mm.vending.h.d.LOGIC, new p.20(localp)).a(com.tencent.mm.vending.h.d.LOGIC, new p.19(localp)));
                    }
                  }
                  catch (IOException localIOException1)
                  {
                    for (;;)
                    {
                      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "beforeEvaluateScriptFile, try read WAAutoService.js, exception=%s", new Object[] { localIOException1 });
                      str2 = null;
                    }
                  }
                }
              }
            }
            localp.nuS = ((com.tencent.mm.vending.g.e)localp.abP("preloadAppService").h(new p.3(localp)).g(new p.2(localp)).a(com.tencent.mm.vending.h.d.LOGIC, new p.23(localp)).a(com.tencent.mm.vending.h.d.LOGIC, new p.22(localp)));
            break;
            label324:
            if ((localp.nuJ.Sk().cxf.scene == 1030) && (DebuggerShell.bLS()))
            {
              str2 = com.tencent.mm.plugin.appbrand.debugger.e.dd(localp.nuJ.mAppId, "Needwebviewjs");
              if ((!TextUtils.isEmpty(str2)) && (u.agG(str2))) {
                try
                {
                  str2 = u.bBS(str2);
                  if (!TextUtils.isEmpty(str2)) {
                    localp.nuT = localp.abP("tryPreloadMonkeyTestAppPageView").h(new p.5(localp)).b(new p.4(localp, str2));
                  }
                }
                catch (IOException localIOException2)
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", "beforeEvaluateScriptFile, try read WAAutoWebView.js, exception=%s", new Object[] { localIOException2 });
                    localObject1 = localObject2;
                  }
                }
              }
            }
            localp.nuT = localp.abP("tryPreloadPageView").h(new p.7(localp)).g(new p.6(localp));
          }
        }
        label493:
        AppMethodBeat.o(43818);
      }
    }, 2);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.nuJ.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
    com.tencent.mm.plugin.expansions.a.a(new a.b()
    {
      public final void a(c.a paramAnonymousa)
      {
        AppMethodBeat.i(43819);
        localb.Sz();
        com.tencent.mm.plugin.appbrand.keylogger.c.b(p.this.nuJ.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
        AppMethodBeat.o(43819);
      }
    });
    com.tencent.mm.plugin.appbrand.launching.f.a(this.nuJ, new kotlin.g.a.b() {});
    AppMethodBeat.o(43837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p
 * JD-Core Version:    0.7.0.1
 */