package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.magicar.MagicAR;
import com.tencent.magicbrush.an;
import com.tencent.magicbrush.e.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.at;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k;
import com.tencent.mm.plugin.appbrand.n.aa;
import com.tencent.mm.plugin.appbrand.n.af;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.m.a;
import com.tencent.mm.plugin.appbrand.n.p.a;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.page.cf;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.skyline.jni.INativeHandler;
import com.tencent.skyline.jni.SkylineResourceLoader;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.sdk.b.a.d.c<c>
  implements com.tencent.luggage.game.d.a.a.c
{
  private com.tencent.mm.plugin.appbrand.v.b.a tTi;
  private com.tencent.luggage.game.a.c tTj;
  private MagicAR tTk;
  boolean tTl;
  private boolean tTm;
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(321544);
    this.tTi = null;
    this.tTj = null;
    this.tTk = null;
    this.tTl = false;
    this.tTm = false;
    b(com.tencent.luggage.game.d.a.a.c.class, this);
    AppMethodBeat.o(321544);
  }
  
  private void aga(String paramString)
  {
    AppMethodBeat.i(321547);
    cJp();
    if (!Util.isNullOrNil(paramString))
    {
      if (getMagicBrush() != null)
      {
        getMagicBrush().fV(paramString);
        AppMethodBeat.o(321547);
        return;
      }
      Log.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: create magicbrush failed! %s", new Object[] { paramString });
    }
    AppMethodBeat.o(321547);
  }
  
  private void cJp()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(321551);
        Log.printInfoStack("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: start create magicbrush", new Object[0]);
        if (this.tTj != null)
        {
          Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
          if (this.tTj != null) {
            AppMethodBeat.o(321551);
          }
        }
        else
        {
          bool = false;
          continue;
        }
        if (aqX() != null)
        {
          i locali = ((c)aqX()).getJsRuntime();
          com.tencent.magicbrush.a.b.loadLibraries();
          com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
          this.tTj = new com.tencent.luggage.game.a.c(((c)aqX()).getContext(), locali)
          {
            public final void a(com.tencent.magicbrush.e paramAnonymouse, long paramAnonymousLong)
            {
              AppMethodBeat.i(48252);
              com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
              com.tencent.mm.plugin.appbrand.report.quality.c.a(((c)b.this.aqX()).cdi(), ((c)b.this.aqX()).getAppId(), paramAnonymousLong);
              AppMethodBeat.o(48252);
            }
            
            public final void a(com.tencent.magicbrush.f paramAnonymousf)
            {
              AppMethodBeat.i(48251);
              super.a(paramAnonymousf);
              paramAnonymousf.bg(com.tencent.mm.plugin.appbrand.game.a.f.rpY.eB(((c)b.this.aqX()).getContext()));
              paramAnonymousf.dj(false);
              paramAnonymousf.dn(((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.rqu.boF()).booleanValue());
              if (((this.ekj instanceof com.tencent.mm.plugin.appbrand.n.x)) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.w.rqB.boF()).booleanValue())) {
                paramAnonymousf.b(com.tencent.magicbrush.ui.a.b.eKw);
              }
              paramAnonymousf.eHF = new e.e()
              {
                FrameLayout rpI;
                com.tencent.magicbrush.utils.e rpJ;
                
                public final void a(final MagicBrushView paramAnonymous2MagicBrushView, final int paramAnonymous2Int1, final int paramAnonymous2Int2, final int paramAnonymous2Int3, final int paramAnonymous2Int4, final int paramAnonymous2Int5)
                {
                  AppMethodBeat.i(321554);
                  if (b.this.aqZ() != null) {
                    b.this.aqZ().i(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(321565);
                        if (b.4.1.this.rpI == null)
                        {
                          b.4.1.this.rpI = new FrameLayout(((c)b.this.aqX()).getContext());
                          cf.a(((c)b.this.aqX()).ccK().txd, b.4.1.this.rpI);
                        }
                        int m = b.4.1.this.rpJ.a(b.4.1.this.rpI, paramAnonymous2MagicBrushView, paramAnonymous2Int5);
                        paramAnonymous2MagicBrushView.setOpaque(false);
                        int k = paramAnonymous2Int3;
                        int j = paramAnonymous2Int4;
                        int n = (int)((c)b.this.aqX()).getContext().getResources().getDisplayMetrics().density;
                        int i = k;
                        if (k <= 0) {
                          i = n * 100;
                        }
                        if (j <= 0) {
                          j = n * 100;
                        }
                        for (;;)
                        {
                          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, j);
                          localLayoutParams.setMargins(paramAnonymous2Int1, paramAnonymous2Int2, 0, 0);
                          b.4.1.this.rpI.addView(paramAnonymous2MagicBrushView, m, localLayoutParams);
                          paramAnonymous2MagicBrushView.setOpaque(false);
                          AppMethodBeat.o(321565);
                          return;
                        }
                      }
                    }, 0L);
                  }
                  AppMethodBeat.o(321554);
                }
                
                public final MagicBrushView avy()
                {
                  AppMethodBeat.i(321549);
                  MagicBrushView localMagicBrushView = new MagicBrushView(((c)b.this.aqX()).getContext(), MagicBrushView.h.eKZ);
                  localMagicBrushView.setMagicBrush(b.4.this.getMagicBrush());
                  localMagicBrushView.setUseRawAxisTouchEvent(true);
                  AppMethodBeat.o(321549);
                  return localMagicBrushView;
                }
                
                public final void b(final MagicBrushView paramAnonymous2MagicBrushView, final int paramAnonymous2Int1, final int paramAnonymous2Int2, final int paramAnonymous2Int3, final int paramAnonymous2Int4, final int paramAnonymous2Int5)
                {
                  AppMethodBeat.i(321560);
                  if (b.this.aqZ() != null) {
                    b.this.aqZ().i(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(321555);
                        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramAnonymous2Int3, paramAnonymous2Int4);
                        localLayoutParams.setMargins(paramAnonymous2Int1, paramAnonymous2Int2, 0, 0);
                        int i = b.4.1.this.rpJ.a(b.4.1.this.rpI, paramAnonymous2MagicBrushView, paramAnonymous2Int5);
                        if (i == -2)
                        {
                          paramAnonymous2MagicBrushView.setLayoutParams(localLayoutParams);
                          paramAnonymous2MagicBrushView.requestLayout();
                        }
                        for (;;)
                        {
                          paramAnonymous2MagicBrushView.setOpaque(false);
                          AppMethodBeat.o(321555);
                          return;
                          b.4.1.this.rpI.removeView(paramAnonymous2MagicBrushView);
                          b.4.1.this.rpI.addView(paramAnonymous2MagicBrushView, i, localLayoutParams);
                        }
                      }
                    }, 0L);
                  }
                  AppMethodBeat.o(321560);
                }
                
                public final void c(final MagicBrushView paramAnonymous2MagicBrushView)
                {
                  AppMethodBeat.i(321561);
                  if (b.this.aqZ() != null) {
                    b.this.aqZ().i(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(321550);
                        b.4.1.this.rpJ.cT(paramAnonymous2MagicBrushView);
                        b.4.1.this.rpI.removeView(paramAnonymous2MagicBrushView);
                        AppMethodBeat.o(321550);
                      }
                    }, 0L);
                  }
                  AppMethodBeat.o(321561);
                }
              };
              boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.g.rqh.boF()).booleanValue();
              boolean bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.s.rqx.boF()).booleanValue();
              boolean bool3 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.t.rqy.boF()).booleanValue();
              String str1;
              String str2;
              label154:
              String str3;
              if (bool2)
              {
                str1 = "yes";
                if (!bool1) {
                  break label324;
                }
                str2 = "yes";
                if (!bool3) {
                  break label331;
                }
                str3 = "yes";
                label163:
                Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
                if ((!bool2) || (!bool1)) {
                  break label338;
                }
                bool1 = true;
                label199:
                paramAnonymousf.dr(bool1);
                if ((!bool2) || (!bool3)) {
                  break label343;
                }
                bool1 = true;
                label215:
                paramAnonymousf.dq(bool1);
                paramAnonymousf.dt(((Boolean)com.tencent.mm.plugin.appbrand.game.a.e.rpX.boF()).booleanValue());
                paramAnonymousf.dy(b.this.arN().esf.getNativeHandle());
                bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.m.rqr.boF()).booleanValue();
                paramAnonymousf.ds(bool2);
                if (((Integer)com.tencent.mm.plugin.appbrand.game.a.x.rqC.boF()).intValue() == 0) {
                  break label348;
                }
              }
              label324:
              label331:
              label338:
              label343:
              label348:
              for (bool1 = true;; bool1 = false)
              {
                paramAnonymousf.dp(bool1);
                Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "dl: supportETC2ASTC[%b]", new Object[] { Boolean.valueOf(bool2) });
                AppMethodBeat.o(48251);
                return;
                str1 = "no";
                break;
                str2 = "no";
                break label154;
                str3 = "no";
                break label163;
                bool1 = false;
                break label199;
                bool1 = false;
                break label215;
              }
            }
          };
          this.tTj.aoP();
          Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: magicbrush create done");
          if (((c)aqX()).isRunning()) {
            this.tTj.b(((c)aqX()).getRuntime());
          }
          locali.addJavascriptInterface(new b((byte)0), "MagicBrushViewIdTransfer");
          locali.evaluateJavascript(com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/NativeGlobal-WAService.js"), new ValueCallback() {});
          AppMethodBeat.o(321551);
          continue;
        }
        Log.w("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: component lost");
      }
      finally {}
      AppMethodBeat.o(321551);
    }
  }
  
  public final void J(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48258);
    super.J(paramString1, paramString2);
    try
    {
      com.tencent.mm.plugin.appbrand.report.l.b((c)aqX(), paramString1, paramString2);
      return;
    }
    finally
    {
      AppMethodBeat.o(48258);
    }
  }
  
  public final com.tencent.luggage.sdk.b.a.d.b<c> a(i parami, com.tencent.mm.plugin.appbrand.n.t paramt)
  {
    AppMethodBeat.i(48259);
    boolean bool = parami instanceof com.tencent.mm.plugin.appbrand.n.x;
    if ((at.cdw()) || (bool))
    {
      parami = new a((c)Objects.requireNonNull((c)aqX()), paramt);
      AppMethodBeat.o(48259);
      return parami;
    }
    AppMethodBeat.o(48259);
    return null;
  }
  
  public final void apC()
  {
    AppMethodBeat.i(321576);
    super.apC();
    AppMethodBeat.o(321576);
  }
  
  public final void apD()
  {
    AppMethodBeat.i(321580);
    super.apD();
    AppMethodBeat.o(321580);
  }
  
  public final i apk()
  {
    Object localObject3 = null;
    AppMethodBeat.i(48257);
    final long l = System.currentTimeMillis();
    if (((c)Objects.requireNonNull((c)aqX())).getContext() == null) {
      MMApplicationContext.getContext();
    }
    if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMo, false)) {}
    for (Object localObject2 = com.tencent.mm.plugin.appbrand.n.ad.cpf();; localObject2 = null)
    {
      Object localObject1;
      if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMn, false)) {
        if (com.tencent.mm.compatible.deviceinfo.q.awm()) {
          localObject1 = com.tencent.mm.plugin.appbrand.af.d.agt("wxa_library/v8_snapshot64.bin");
        }
      }
      for (;;)
      {
        boolean bool1;
        label156:
        boolean bool2;
        if ((Boolean.parseBoolean(((ICommLibReader)Objects.requireNonNull(((c)Objects.requireNonNull((c)aqX())).cbl())).UX("delayedServiceCodeCache"))) && (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkk, false)))
        {
          bool1 = true;
          ((ICommLibReader)Objects.requireNonNull(((c)aqX()).cbl())).cfG();
          at.cdw();
          boolean bool3 = ((Boolean)r.rqw.boF()).booleanValue();
          if (((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.rqu.boF()).booleanValue()) {
            break label363;
          }
          bool2 = true;
          label214:
          localObject2 = com.tencent.mm.plugin.appbrand.n.w.a((String)localObject2, (byte[])localObject1, bool1, bool3, bool2, aa.r((y)aqX()), (com.tencent.mm.plugin.appbrand.jsapi.g)aqX());
          if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.n.x))
          {
            this.tTi = new com.tencent.mm.plugin.appbrand.v.a();
            this.tTi.a((y)aqX(), (i)localObject2);
          }
          localObject1 = (com.tencent.mm.plugin.appbrand.n.p)((i)localObject2).Z(com.tencent.mm.plugin.appbrand.n.p.class);
          if (localObject1 == null) {
            break label369;
          }
          ((com.tencent.mm.plugin.appbrand.n.p)localObject1).a(new p.a()
          {
            public final void coH()
            {
              AppMethodBeat.i(48248);
              com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
              if (this.rpG) {}
              for (com.tencent.mm.plugin.appbrand.task.l locall = com.tencent.mm.plugin.appbrand.task.l.tWw;; locall = null)
              {
                com.tencent.mm.plugin.appbrand.report.quality.c.a(locall, this.etl, l, com.tencent.mm.plugin.appbrand.report.e.f(this.esD));
                AppMethodBeat.o(48248);
                return;
              }
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(48257);
          return localObject2;
          localObject1 = com.tencent.mm.plugin.appbrand.af.d.agt("wxa_library/v8_snapshot.bin");
          break;
          bool1 = false;
          break label156;
          label363:
          bool2 = false;
          break label214;
          label369:
          com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
          localObject1 = localObject3;
          if (((c)aqX()).cdi()) {
            localObject1 = com.tencent.mm.plugin.appbrand.task.l.tWw;
          }
          com.tencent.mm.plugin.appbrand.report.quality.c.a((com.tencent.mm.plugin.appbrand.task.l)localObject1, ((c)aqX()).getAppId(), l, com.tencent.mm.plugin.appbrand.report.e.f((i)localObject2));
        }
        localObject1 = null;
      }
    }
  }
  
  public final void apl()
  {
    AppMethodBeat.i(48264);
    super.apl();
    if (aa.r((y)aqX()))
    {
      Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "service initNativeTransLogic");
      aa.a(((c)aqX()).getJsRuntime(), ((c)aqX()).getComponentId(), getAppId());
      aa.a(((c)aqX()).getJsRuntime(), ((c)aqX()).getComponentId(), ((c)aqX()).getComponentId(), getAppId());
    }
    com.tencent.luggage.h.a.b localb = com.tencent.luggage.h.a.b.ewj;
    if (com.tencent.luggage.h.a.b.a(((c)aqX()).cbl())) {
      ((c)aqX()).getJsRuntime().addJavascriptInterface(new a(), "SkylineGlobal");
    }
    AppMethodBeat.o(48264);
  }
  
  public final void apm()
  {
    AppMethodBeat.i(48262);
    super.apm();
    if (this.tTj != null)
    {
      if (this.tTk != null) {
        ((com.tencent.mm.plugin.appbrand.n.m)this.tTj.ekj.Z(com.tencent.mm.plugin.appbrand.n.m.class)).a(new m.a()
        {
          public final void onDestroy()
          {
            AppMethodBeat.i(321567);
            if (b.a(b.this) != null) {
              b.a(b.this).destroy();
            }
            b.b(b.this);
            AppMethodBeat.o(321567);
          }
        });
      }
      this.tTj.destroy();
    }
    AppMethodBeat.o(48262);
  }
  
  public final void apn()
  {
    AppMethodBeat.i(48263);
    super.apn();
    if (this.tTi != null) {
      this.tTi.cCZ();
    }
    AppMethodBeat.o(48263);
  }
  
  public final String apy()
  {
    AppMethodBeat.i(48260);
    String str2 = "" + super.apy();
    String str1 = str2;
    if (this.tTi != null) {
      str1 = str2 + this.tTi.cDa();
    }
    AppMethodBeat.o(48260);
    return str1;
  }
  
  public final int apz()
  {
    AppMethodBeat.i(48268);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkj, 0);
    AppMethodBeat.o(48268);
    return i;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> aqh()
  {
    AppMethodBeat.i(48261);
    if ((aqX() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      localMap = k.cBu();
      AppMethodBeat.o(48261);
      return localMap;
    }
    Map localMap = (Map)com.tencent.luggage.sdk.h.d.b("AppBrandMiniProgramServiceLogicImpWC.onCreateJsApiPool()", new kotlin.g.a.a() {});
    AppMethodBeat.o(48261);
    return localMap;
  }
  
  public final String arO()
  {
    AppMethodBeat.i(321586);
    String str = af.cpf();
    AppMethodBeat.o(321586);
    return str;
  }
  
  public final int arP()
  {
    AppMethodBeat.i(321587);
    if (MMApplicationContext.getToolsProcesstPreference() != null)
    {
      i = MMApplicationContext.getToolsProcesstPreference().getInt("appbrand_wasm_opt", -2);
      if (i != -2)
      {
        Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "wasm opt set to %d by cmd", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(321587);
        return i;
      }
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zmC, -2);
    if (i != -2)
    {
      Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "wasm opt set to %d by abtest", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(321587);
      return i;
    }
    AppMethodBeat.o(321587);
    return -2;
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48265);
    super.c(paramAppBrandRuntime);
    if (this.tTj != null) {
      this.tTj.b(paramAppBrandRuntime);
    }
    if (this.tTl) {
      SkylineResourceLoader.initResourceLoader(new com.tencent.luggage.h.a.e((com.tencent.mm.plugin.appbrand.w)paramAppBrandRuntime));
    }
    AppMethodBeat.o(48265);
  }
  
  public final boolean c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(321573);
    if ("MediaToolKit".equals(paramString))
    {
      aga(null);
      AppMethodBeat.o(321573);
      return true;
    }
    if ("Image".equals(paramString))
    {
      aga(null);
      AppMethodBeat.o(321573);
      return true;
    }
    if ("OffscreenCanvas".equals(paramString))
    {
      aga(null);
      AppMethodBeat.o(321573);
      return true;
    }
    if ("CpuProfiler".equals(paramString))
    {
      aga(null);
      AppMethodBeat.o(321573);
      return true;
    }
    if ("HeapProfiler".equals(paramString))
    {
      aga(null);
      AppMethodBeat.o(321573);
      return true;
    }
    if ("Profiler".equals(paramString))
    {
      aga(null);
      AppMethodBeat.o(321573);
      return true;
    }
    if ("ARSession".equals(paramString))
    {
      if (Build.VERSION.SDK_INT < 24)
      {
        Log.w("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "api version is " + Build.VERSION.SDK_INT + ", can't use ar");
        AppMethodBeat.o(321573);
        return true;
      }
      aga(null);
      if (this.tTk == null)
      {
        this.tTk = new MagicAR(MMApplicationContext.getContext());
        paramString = (an)getMagicBrush().eHA.eHO.invoke();
        this.tTk.bindTo(paramString.eIH, paramString.eII, paramString.eIJ);
        Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "lazy load magic-ar ok");
      }
      AppMethodBeat.o(321573);
      return true;
    }
    if ("Box2D".equals(paramString))
    {
      aga("mmbox2d");
      AppMethodBeat.o(321573);
      return true;
    }
    if ("Phys3D".equals(paramString))
    {
      aga("mmphysx");
      AppMethodBeat.o(321573);
      return true;
    }
    boolean bool = super.c(paramString, paramJSONObject);
    AppMethodBeat.o(321573);
    return bool;
  }
  
  public final void cJq()
  {
    AppMethodBeat.i(321663);
    if (this.tTm)
    {
      AppMethodBeat.o(321663);
      return;
    }
    Object localObject;
    v localv;
    final com.tencent.mm.plugin.appbrand.n.q localq;
    if ((aqX() != null) && (((c)aqX()).cbl() != null))
    {
      localObject = com.tencent.luggage.h.a.b.ewj;
      if (com.tencent.luggage.h.a.b.a(((c)aqX()).cbl()))
      {
        localObject = ((c)aqX()).getJsRuntime();
        if (localObject == null)
        {
          AppMethodBeat.o(321663);
          return;
        }
        localv = (v)((i)localObject).Z(v.class);
        localq = (com.tencent.mm.plugin.appbrand.n.q)((i)localObject).Z(com.tencent.mm.plugin.appbrand.n.q.class);
        if ((localv != null) && (localq != null))
        {
          this.tTl = true;
          if (aqZ() == null) {
            break label195;
          }
          SkylineResourceLoader.initResourceLoader(new com.tencent.luggage.h.a.e(aqZ()));
        }
      }
    }
    for (;;)
    {
      com.tencent.luggage.h.e.evY.initNativeHandler(new INativeHandler()
      {
        public final void checkAndPost(Runnable paramAnonymousRunnable)
        {
          AppMethodBeat.i(321556);
          if (paramAnonymousRunnable == null)
          {
            AppMethodBeat.o(321556);
            return;
          }
          if (localq.aoN())
          {
            paramAnonymousRunnable.run();
            AppMethodBeat.o(321556);
            return;
          }
          localq.post(paramAnonymousRunnable);
          AppMethodBeat.o(321556);
        }
      });
      localq.post(new b..ExternalSyntheticLambda0(localv));
      l(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(321553);
          String str = di.H("requireRenderContext", "", ((c)b.this.aqX()).getComponentId());
          this.esD.evaluateJavascript(str, null);
          AppMethodBeat.o(321553);
        }
      });
      this.tTm = true;
      AppMethodBeat.o(321663);
      return;
      label195:
      Log.w("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "skyline initResourceLoader waring. runtime is null");
    }
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48266);
    super.e(paramJSONObject);
    boolean bool = ac.h((c)Objects.requireNonNull((c)aqX()));
    try
    {
      paramJSONObject.put("exportBaseMethods", bool);
      paramJSONObject.put("supressOffscreenPatch", true);
      Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(48266);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods e:%s", new Object[] { paramJSONObject });
      }
    }
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(321599);
    super.f(paramJSONObject);
    try
    {
      paramJSONObject.put("clientVersion", com.tencent.mm.protocal.d.Yxh);
      paramJSONObject.put("JSEngineName", com.tencent.mm.plugin.appbrand.n.w.e(((c)aqX()).getJsRuntime()));
      com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTd(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTl(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTh(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTk(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTj(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTs(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTn(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTo(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.i(com.tencent.mm.plugin.appbrand.xweb_ext.e.cTq(), paramJSONObject);
      paramJSONObject.put("useXWebWebGLCanvas", com.tencent.mm.plugin.appbrand.xweb_ext.e.cTp());
      paramJSONObject.put("useSkiaCanvasRaf", com.tencent.mm.plugin.appbrand.xweb_ext.e.cTf());
      paramJSONObject.put("useNewXWebCanvasToTFP", com.tencent.mm.plugin.appbrand.xweb_ext.e.cTg());
      AppMethodBeat.o(321599);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", paramJSONObject, "attachCommonConfig error", new Object[0]);
      AppMethodBeat.o(321599);
    }
  }
  
  public final boolean g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(321646);
    if ((aqX() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(321646);
      return true;
    }
    if ((aqX() != null) && (((c)aqX()).tTr) && (com.tencent.mm.plugin.appbrand.ad.e.UH(paramString1)))
    {
      ((c)aqX()).cF(paramString1, paramString2);
      AppMethodBeat.o(321646);
      return true;
    }
    boolean bool = super.g(paramString1, paramString2, paramInt);
    AppMethodBeat.o(321646);
    return bool;
  }
  
  public final com.tencent.magicbrush.e getMagicBrush()
  {
    AppMethodBeat.i(321627);
    cJp();
    if (this.tTj != null)
    {
      com.tencent.magicbrush.e locale = this.tTj.getMagicBrush();
      AppMethodBeat.o(321627);
      return locale;
    }
    AppMethodBeat.o(321627);
    return null;
  }
  
  public final boolean k(int paramInt, String paramString)
  {
    AppMethodBeat.i(321652);
    if ((aqX() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(321652);
      return true;
    }
    boolean bool = super.k(paramInt, paramString);
    AppMethodBeat.o(321652);
    return bool;
  }
  
  public static final class a
  {
    @JavascriptInterface
    public final String foo()
    {
      return "bar";
    }
  }
  
  final class b
  {
    private b() {}
    
    @JavascriptInterface
    public final int exec(int paramInt)
    {
      AppMethodBeat.i(48256);
      try
      {
        Object localObject = com.tencent.mm.plugin.appbrand.jsapi.c.a.aau(((c)b.this.aqX()).getAppId()).evG.get(Integer.valueOf(paramInt));
        kotlin.g.b.s.checkNotNull(localObject);
        int i = ((com.tencent.mm.plugin.appbrand.jsapi.c.a.b)localObject).rRi.getVirtualElementId();
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", localException, "MagicBrushViewIdTransfer failed. [%d] [%s]", new Object[] { Integer.valueOf(paramInt), ((c)b.this.aqX()).getAppId() });
          paramInt = -1;
        }
      }
      AppMethodBeat.o(48256);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b
 * JD-Core Version:    0.7.0.1
 */