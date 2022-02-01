package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bs;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.j;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.e.b;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.plugin.expansions.a.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.toolkit.frontia.a.c.a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e.c;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.x;

final class m
  extends AppBrandRuntime.b
{
  private volatile a kBA;
  volatile ag kBB;
  volatile com.tencent.mm.plugin.appbrand.service.c kBC;
  private final AtomicBoolean kBD;
  private final AtomicBoolean kBE;
  com.tencent.mm.vending.g.e<com.tencent.mm.plugin.appbrand.service.c> kBF;
  com.tencent.mm.vending.g.e<ag> kBG;
  final q kBw;
  private final k kBx;
  volatile boolean kBy;
  private volatile boolean kBz;
  
  m(q paramq)
  {
    AppMethodBeat.i(43832);
    this.kBy = false;
    this.kBz = false;
    this.kBD = new AtomicBoolean(false);
    this.kBE = new AtomicBoolean(false);
    this.kBw = paramq;
    this.kBx = new k(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43799);
        if ((m.this.kBy) || (m.this.kBB == null)) {}
        try
        {
          com.tencent.mm.plugin.appbrand.report.quality.b.aeU(m.this.kBw.mAppId).nLA = j.nKR;
          label44:
          m.this.n("countDown == 0, notify process ready", new Object[0]);
          m.this.KY();
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
  
  private String brS()
  {
    AppMethodBeat.i(43835);
    String str = String.format(Locale.US, "Runtime[%s %d %s]~~%d~~ ", new Object[] { this.kBw.mAppId, Integer.valueOf(this.kBw.kAq.eix), com.tencent.mm.plugin.appbrand.task.g.iD(this.kBw.NA()).name(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43835);
    return str;
  }
  
  final f<Void> Ug(final String paramString)
  {
    AppMethodBeat.i(226162);
    paramString = new f()
    {
      public final f<Void> a(com.tencent.mm.vending.e.b paramAnonymousb)
      {
        AppMethodBeat.i(226158);
        paramAnonymousb.keep(new com.tencent.mm.vending.e.a()
        {
          public final void dead()
          {
            AppMethodBeat.i(226157);
            m.this.n("pipeline(%s) will be stopped", new Object[] { m.16.this.cCZ });
            AppMethodBeat.o(226157);
          }
        });
        paramAnonymousb = super.a(paramAnonymousb);
        AppMethodBeat.o(226158);
        return paramAnonymousb;
      }
    }.a(this.kBw).L(new Object[0]);
    AppMethodBeat.o(226162);
    return paramString;
  }
  
  final void a(final a parama)
  {
    AppMethodBeat.i(43838);
    if ((this.kBG == null) || (this.kBy))
    {
      n("tryPreloadBeforeResourceDone mPageViewPipeline null || mProcessExpired", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    if (this.kBz)
    {
      n("tryPreloadBeforeResourceDone function already appended by reason[%s]", new Object[] { this.kBA });
      AppMethodBeat.o(43838);
      return;
    }
    n("tryPreloadBeforeResourceDone tryDoAheadPreloadPageView by reason[%s]", new Object[] { parama });
    this.kBz = true;
    this.kBA = parama;
    if (this.kBG.QZR)
    {
      n("mPageViewPipeline has stopped", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    this.kBG.c(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(43838);
  }
  
  final void brQ()
  {
    AppMethodBeat.i(174647);
    if (!this.kBE.getAndSet(true)) {
      this.kBx.countDown();
    }
    AppMethodBeat.o(174647);
  }
  
  final void brR()
  {
    AppMethodBeat.i(174648);
    if (!this.kBD.getAndSet(true)) {
      this.kBx.countDown();
    }
    AppMethodBeat.o(174648);
  }
  
  final com.tencent.mm.plugin.appbrand.service.c brT()
  {
    com.tencent.mm.plugin.appbrand.service.c localc = this.kBC;
    this.kBC = null;
    return localc;
  }
  
  final ag brU()
  {
    ag localag = this.kBB;
    this.kBB = null;
    return localag;
  }
  
  public final void interrupt()
  {
    AppMethodBeat.i(43836);
    o("interrupt()", new Object[0]);
    this.kBy = true;
    Object localObject = brT();
    if (localObject != null) {}
    try
    {
      ((com.tencent.mm.plugin.appbrand.service.c)localObject).cleanup();
      if (this.kBF != null) {
        this.kBF.Dv(true);
      }
      localObject = brU();
      if (localObject == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        ((ag)localObject).cleanup();
        if (this.kBG != null) {
          this.kBG.Dv(true);
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
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", brS() + paramString, paramVarArgs);
    AppMethodBeat.o(43833);
  }
  
  final void o(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43834);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", brS() + paramString, paramVarArgs);
    AppMethodBeat.o(43834);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(43837);
    final k localk = new k(new Runnable()
    {
      public final void run()
      {
        Object localObject2 = null;
        AppMethodBeat.i(43818);
        if (!m.this.kBy)
        {
          m localm = m.this;
          if (localm.kBw.OQ())
          {
            localm.n("service countDown by remoteDebug", new Object[0]);
            localm.kBF = null;
            localm.brQ();
            if (!localm.kBw.NA()) {
              break label324;
            }
            localm.n("tryPreloadPageView ignore for game, countdown", new Object[0]);
            localm.kBG = null;
            localm.brR();
          }
          for (;;)
          {
            for (;;)
            {
              if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUA, 0) <= 0) {
                break label493;
              }
              try
              {
                localm.a(m.a.kBZ);
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
              if ((localm.kBw.ON().cyA.scene == 1030) && (DebuggerShell.bAx()))
              {
                str1 = com.tencent.mm.plugin.appbrand.debugger.e.cU(localm.kBw.mAppId, "Needjs");
                if ((!TextUtils.isEmpty(str1)) && (s.YS(str1))) {
                  try
                  {
                    str1 = s.boY(str1);
                    if (!TextUtils.isEmpty(str1)) {
                      localm.kBF = ((com.tencent.mm.vending.g.e)localm.Ug("preloadMonkeyTestAppService").h(new m.21(localm, str1)).a(com.tencent.mm.vending.h.d.LOGIC, new m.20(localm)).a(com.tencent.mm.vending.h.d.LOGIC, new m.19(localm)));
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
            localm.kBF = ((com.tencent.mm.vending.g.e)localm.Ug("preloadAppService").h(new m.3(localm)).g(new m.2(localm)).a(com.tencent.mm.vending.h.d.LOGIC, new m.23(localm)).a(com.tencent.mm.vending.h.d.LOGIC, new m.22(localm)));
            break;
            label324:
            if ((localm.kBw.ON().cyA.scene == 1030) && (DebuggerShell.bAx()))
            {
              str2 = com.tencent.mm.plugin.appbrand.debugger.e.cU(localm.kBw.mAppId, "Needwebviewjs");
              if ((!TextUtils.isEmpty(str2)) && (s.YS(str2))) {
                try
                {
                  str2 = s.boY(str2);
                  if (!TextUtils.isEmpty(str2)) {
                    localm.kBG = localm.Ug("tryPreloadMonkeyTestAppPageView").h(new m.5(localm)).b(new m.4(localm, str2));
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
            localm.kBG = localm.Ug("tryPreloadPageView").h(new m.7(localm)).g(new m.6(localm));
          }
        }
        label493:
        AppMethodBeat.o(43818);
      }
    }, 2);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.kBw.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
    com.tencent.mm.plugin.expansions.a.a(new a.b()
    {
      public final void a(c.a paramAnonymousa)
      {
        AppMethodBeat.i(43819);
        localk.countDown();
        com.tencent.mm.plugin.appbrand.keylogger.c.b(m.this.kBw.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
        AppMethodBeat.o(43819);
      }
    });
    com.tencent.mm.plugin.appbrand.launching.g.a(this.kBw, new kotlin.g.a.b() {});
    AppMethodBeat.o(43837);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(43831);
      kBW = new a("SYNC_LAUNCH", 0);
      kBX = new a("SYNC_GET_CODE", 1);
      kBY = new a("SYNC_JSAPIINFO", 2);
      kBZ = new a("X_CONFIG", 3);
      kCa = new a[] { kBW, kBX, kBY, kBZ };
      AppMethodBeat.o(43831);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m
 * JD-Core Version:    0.7.0.1
 */