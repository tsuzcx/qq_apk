package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.plugin.appbrand.report.quality.i;
import com.tencent.mm.plugin.appbrand.service.aa;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.l;
import com.tencent.mm.plugin.expansions.e.b;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

final class p
  extends AppBrandRuntime.b
{
  private final AtomicBoolean qtA;
  com.tencent.mm.vending.g.e<com.tencent.mm.plugin.appbrand.service.c> qtB;
  com.tencent.mm.vending.g.e<com.tencent.mm.plugin.appbrand.page.ah> qtC;
  final w qts;
  private final com.tencent.luggage.sdk.h.b qtt;
  volatile boolean qtu;
  private volatile boolean qtv;
  private volatile p.a qtw;
  volatile com.tencent.mm.plugin.appbrand.page.ah qtx;
  volatile com.tencent.mm.plugin.appbrand.service.c qty;
  private final AtomicBoolean qtz;
  
  p(w paramw)
  {
    AppMethodBeat.i(43832);
    this.qtu = false;
    this.qtv = false;
    this.qtz = new AtomicBoolean(false);
    this.qtA = new AtomicBoolean(false);
    this.qts = paramw;
    this.qtt = new com.tencent.luggage.sdk.h.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(43799);
        if ((p.this.qtu) || (p.this.qtx == null)) {}
        try
        {
          com.tencent.mm.plugin.appbrand.report.quality.b.afZ(p.this.qts.mAppId).tSx = i.tRN;
          label44:
          p.this.m("countDown == 0, notify process ready", new Object[0]);
          p.this.ready();
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
  
  private String cbV()
  {
    AppMethodBeat.i(43835);
    String str = String.format(Locale.US, "Runtime[%s %d %s]~~%d~~ ", new Object[] { this.qts.mAppId, Integer.valueOf(this.qts.qsh.eul), l.kO(this.qts.aqJ()).name(), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(43835);
    return str;
  }
  
  final com.tencent.mm.cp.f<Void> Ur(final String paramString)
  {
    AppMethodBeat.i(316658);
    paramString = new com.tencent.mm.cp.f()
    {
      public final com.tencent.mm.vending.g.d a(d.b paramAnonymousb)
      {
        try
        {
          AppMethodBeat.i(316864);
          paramAnonymousb = a(com.tencent.mm.vending.h.d.current(), paramAnonymousb);
          AppMethodBeat.o(316864);
          return paramAnonymousb;
        }
        finally
        {
          paramAnonymousb = finally;
          throw paramAnonymousb;
        }
      }
      
      public final com.tencent.mm.vending.g.d a(com.tencent.mm.vending.h.d paramAnonymousd, final d.b paramAnonymousb)
      {
        try
        {
          AppMethodBeat.i(316868);
          paramAnonymousd = super.a(paramAnonymousd, new d.b()
          {
            public final void onTerminate(Object paramAnonymous2Object)
            {
              AppMethodBeat.i(317210);
              paramAnonymousb.onTerminate(paramAnonymous2Object);
              p.this.qts.a(jdField_this);
              AppMethodBeat.o(317210);
            }
          });
          AppMethodBeat.o(316868);
          return paramAnonymousd;
        }
        finally
        {
          paramAnonymousd = finally;
          throw paramAnonymousd;
        }
      }
      
      public final void dead()
      {
        AppMethodBeat.i(316859);
        p.this.m("pipeline(%s) will be stopped", new Object[] { paramString });
        super.dead();
        AppMethodBeat.o(316859);
      }
    }.a(this.qts).Q(new Object[0]);
    AppMethodBeat.o(316658);
    return paramString;
  }
  
  final void a(final p.a parama)
  {
    AppMethodBeat.i(43838);
    com.tencent.mm.plugin.appbrand.service.c localc = this.qty;
    if ((localc != null) && (!this.qts.aqJ()) && (this.qts.getInitConfig().aqD()))
    {
      com.tencent.luggage.h.a.b localb = com.tencent.luggage.h.a.b.ewj;
      if (com.tencent.luggage.h.a.b.atc())
      {
        localb = com.tencent.luggage.h.a.b.ewj;
        if (com.tencent.luggage.h.a.b.a(localc.cbl())) {
          localc.cJq();
        }
      }
    }
    if ((this.qtC == null) || (this.qtu))
    {
      m("tryPreloadBeforeResourceDone mPageViewPipeline null || mProcessExpired", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    if (this.qtv)
    {
      m("tryPreloadBeforeResourceDone function already appended by reason[%s]", new Object[] { this.qtw });
      AppMethodBeat.o(43838);
      return;
    }
    m("tryPreloadBeforeResourceDone tryDoAheadPreloadPageView by reason[%s]", new Object[] { parama });
    this.qtv = true;
    this.qtw = parama;
    if (this.qtC.aguF)
    {
      m("mPageViewPipeline has stopped", new Object[0]);
      AppMethodBeat.o(43838);
      return;
    }
    this.qtC.c(new a() {});
    AppMethodBeat.o(43838);
  }
  
  final void cbT()
  {
    AppMethodBeat.i(174647);
    if (!this.qtA.getAndSet(true)) {
      this.qtt.asP();
    }
    AppMethodBeat.o(174647);
  }
  
  final void cbU()
  {
    AppMethodBeat.i(174648);
    if (!this.qtz.getAndSet(true)) {
      this.qtt.asP();
    }
    AppMethodBeat.o(174648);
  }
  
  final com.tencent.mm.plugin.appbrand.service.c cbW()
  {
    com.tencent.mm.plugin.appbrand.service.c localc = this.qty;
    this.qty = null;
    return localc;
  }
  
  final com.tencent.mm.plugin.appbrand.page.ah cbX()
  {
    com.tencent.mm.plugin.appbrand.page.ah localah = this.qtx;
    this.qtx = null;
    return localah;
  }
  
  /* Error */
  public final void interrupt()
  {
    // Byte code:
    //   0: ldc_w 298
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 300
    //   10: iconst_0
    //   11: anewarray 157	java/lang/Object
    //   14: invokevirtual 303	com/tencent/mm/plugin/appbrand/p:n	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 101	com/tencent/mm/plugin/appbrand/p:qtu	Z
    //   22: aload_0
    //   23: invokevirtual 305	com/tencent/mm/plugin/appbrand/p:cbW	()Lcom/tencent/mm/plugin/appbrand/service/c;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +7 -> 35
    //   31: aload_1
    //   32: invokevirtual 308	com/tencent/mm/plugin/appbrand/service/c:cleanup	()V
    //   35: aload_0
    //   36: getfield 310	com/tencent/mm/plugin/appbrand/p:qtB	Lcom/tencent/mm/vending/g/e;
    //   39: ifnull +11 -> 50
    //   42: aload_0
    //   43: getfield 310	com/tencent/mm/plugin/appbrand/p:qtB	Lcom/tencent/mm/vending/g/e;
    //   46: iconst_1
    //   47: invokevirtual 313	com/tencent/mm/vending/g/e:NN	(Z)V
    //   50: aload_0
    //   51: invokevirtual 315	com/tencent/mm/plugin/appbrand/p:cbX	()Lcom/tencent/mm/plugin/appbrand/page/ah;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnull +7 -> 63
    //   59: aload_1
    //   60: invokevirtual 318	com/tencent/mm/plugin/appbrand/page/ah:cleanup	()V
    //   63: aload_0
    //   64: getfield 253	com/tencent/mm/plugin/appbrand/p:qtC	Lcom/tencent/mm/vending/g/e;
    //   67: ifnull +11 -> 78
    //   70: aload_0
    //   71: getfield 253	com/tencent/mm/plugin/appbrand/p:qtC	Lcom/tencent/mm/vending/g/e;
    //   74: iconst_1
    //   75: invokevirtual 313	com/tencent/mm/vending/g/e:NN	(Z)V
    //   78: ldc_w 298
    //   81: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: return
    //   85: astore_1
    //   86: aload_0
    //   87: ldc_w 320
    //   90: iconst_1
    //   91: anewarray 157	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_1
    //   97: aastore
    //   98: invokevirtual 303	com/tencent/mm/plugin/appbrand/p:n	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: goto -66 -> 35
    //   104: astore_1
    //   105: aload_0
    //   106: ldc_w 322
    //   109: iconst_1
    //   110: anewarray 157	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_1
    //   116: aastore
    //   117: invokevirtual 303	com/tencent/mm/plugin/appbrand/p:n	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: goto -57 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	p
    //   26	34	1	localObject1	Object
    //   85	12	1	localObject2	Object
    //   104	12	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   31	35	85	finally
    //   59	63	104	finally
  }
  
  final void m(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43833);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", cbV() + paramString, paramVarArgs);
    AppMethodBeat.o(43833);
  }
  
  final void n(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(43834);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.AppBrandRuntimeBoostStrategy[preload]", cbV() + paramString, paramVarArgs);
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
        if (!p.this.qtu)
        {
          p localp = p.this;
          if (localp.qts.arD())
          {
            localp.m("service countDown by remoteDebug", new Object[0]);
            localp.qtB = null;
            localp.cbT();
            if (!localp.qts.aqJ()) {
              break label324;
            }
            localp.m("tryPreloadPageView ignore for game, countdown", new Object[0]);
            localp.qtC = null;
            localp.cbU();
          }
          for (;;)
          {
            for (;;)
            {
              if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yPc, 0) <= 0) {
                break label493;
              }
              try
              {
                localp.a(p.a.qtX);
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
              if ((localp.qts.asA().epn.scene == 1030) && (DebuggerShell.cls()))
              {
                str1 = com.tencent.mm.plugin.appbrand.debugger.e.du(localp.qts.mAppId, "Needjs");
                if ((!TextUtils.isEmpty(str1)) && (y.ZC(str1))) {
                  try
                  {
                    str1 = y.bEn(str1);
                    if (!TextUtils.isEmpty(str1)) {
                      localp.qtB = ((com.tencent.mm.vending.g.e)localp.Ur("preloadMonkeyTestAppService").h(new p.21(localp, str1)).a(com.tencent.mm.vending.h.d.LOGIC, new p.20(localp)).a(com.tencent.mm.vending.h.d.LOGIC, new p.19(localp)));
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
            localp.qtB = ((com.tencent.mm.vending.g.e)localp.Ur("preloadAppService").h(new p.3(localp)).g(new p.2(localp)).a(com.tencent.mm.vending.h.d.LOGIC, new p.23(localp)).a(com.tencent.mm.vending.h.d.LOGIC, new p.22(localp)));
            break;
            label324:
            if ((localp.qts.asA().epn.scene == 1030) && (DebuggerShell.cls()))
            {
              str2 = com.tencent.mm.plugin.appbrand.debugger.e.du(localp.qts.mAppId, "Needwebviewjs");
              if ((!TextUtils.isEmpty(str2)) && (y.ZC(str2))) {
                try
                {
                  str2 = y.bEn(str2);
                  if (!TextUtils.isEmpty(str2)) {
                    localp.qtC = localp.Ur("tryPreloadMonkeyTestAppPageView").h(new p.5(localp)).b(new p.4(localp, str2));
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
            localp.qtC = localp.Ur("tryPreloadPageView").h(new p.7(localp)).g(new p.6(localp));
          }
        }
        label493:
        AppMethodBeat.o(43818);
      }
    }, 2);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.qts.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
    com.tencent.mm.plugin.expansions.e.install(new e.b()
    {
      public final void a(com.tencent.mm.toolkit.frontia.a.c.a paramAnonymousa)
      {
        AppMethodBeat.i(43819);
        localb.asP();
        com.tencent.mm.plugin.appbrand.keylogger.c.b(p.this.qts.mAppId, KSProcessWeAppLaunch.stepInstallLibraries);
        AppMethodBeat.o(43819);
      }
    });
    com.tencent.mm.plugin.appbrand.launching.h.a(this.qts, new kotlin.g.a.b() {});
    AppMethodBeat.o(43837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p
 * JD-Core Version:    0.7.0.1
 */