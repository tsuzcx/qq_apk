package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.magicbrush.e.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ao;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.s;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k;
import com.tencent.mm.plugin.appbrand.m.af;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.p.a;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.m.w;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.sdk.b.a.c.c<c>
  implements com.tencent.luggage.game.d.a.a.c
{
  private com.tencent.luggage.game.a.c qOA;
  private com.tencent.mm.plugin.appbrand.u.b.a qOz;
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(276946);
    this.qOz = null;
    this.qOA = null;
    b(com.tencent.luggage.game.d.a.a.c.class, this);
    AppMethodBeat.o(276946);
  }
  
  private void amQ(String paramString)
  {
    AppMethodBeat.i(276949);
    ciA();
    if (!Util.isNullOrNil(paramString))
    {
      if (getMagicBrush() != null)
      {
        getMagicBrush().ey(paramString);
        AppMethodBeat.o(276949);
        return;
      }
      Log.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: create magicbrush failed! %s", new Object[] { paramString });
    }
    AppMethodBeat.o(276949);
  }
  
  private void ciA()
  {
    boolean bool = true;
    AppMethodBeat.i(276957);
    Log.printInfoStack("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: start create magicbrush", new Object[0]);
    if (this.qOA != null) {}
    for (;;)
    {
      Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.qOA == null) {
        break;
      }
      AppMethodBeat.o(276957);
      return;
      bool = false;
    }
    if (QK() != null)
    {
      i locali = ((c)QK()).getJsRuntime();
      com.tencent.magicbrush.a.b.loadLibraries();
      com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
      this.qOA = new com.tencent.luggage.game.a.c(((c)QK()).getContext(), locali)
      {
        public final void a(com.tencent.magicbrush.e paramAnonymouse, long paramAnonymousLong)
        {
          AppMethodBeat.i(272101);
          com.tencent.mm.plugin.appbrand.report.quality.b.cik();
          com.tencent.mm.plugin.appbrand.report.quality.c.a(((c)b.this.QK()).bDU(), ((c)b.this.QK()).getAppId(), paramAnonymousLong);
          AppMethodBeat.o(272101);
        }
        
        public final void a(com.tencent.magicbrush.f paramAnonymousf)
        {
          AppMethodBeat.i(272099);
          super.a(paramAnonymousf);
          paramAnonymousf.ae(com.tencent.mm.plugin.appbrand.game.a.e.omt.dI(((c)b.this.QK()).getContext()));
          paramAnonymousf.cD(false);
          paramAnonymousf.cH(((Boolean)com.tencent.mm.plugin.appbrand.game.a.o.omK.aUb()).booleanValue());
          if (((getJsRuntime() instanceof x)) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.v.omR.aUb()).booleanValue())) {
            paramAnonymousf.b(com.tencent.magicbrush.ui.a.b.cPr);
          }
          paramAnonymousf.cMl = new e.e()
          {
            FrameLayout olZ;
            com.tencent.magicbrush.utils.e oma;
            
            public final MagicBrushView UV()
            {
              AppMethodBeat.i(264390);
              MagicBrushView localMagicBrushView = new MagicBrushView(((c)b.this.QK()).getContext(), MagicBrushView.h.cPU);
              localMagicBrushView.setMagicBrush(b.3.this.getMagicBrush());
              localMagicBrushView.setUseRawAxisTouchEvent(true);
              AppMethodBeat.o(264390);
              return localMagicBrushView;
            }
            
            public final void a(final MagicBrushView paramAnonymous2MagicBrushView, final int paramAnonymous2Int1, final int paramAnonymous2Int2, final int paramAnonymous2Int3, final int paramAnonymous2Int4, final int paramAnonymous2Int5)
            {
              AppMethodBeat.i(264392);
              if (b.this.QM() != null) {
                b.this.QM().h(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(271025);
                    if (b.3.1.this.olZ == null)
                    {
                      b.3.1.this.olZ = new FrameLayout(((c)b.this.QK()).getContext());
                      ((c)b.this.QK()).bDv().qsz.bPF().addView(b.3.1.this.olZ, 0, new ViewGroup.LayoutParams(-1, -1));
                    }
                    int m = b.3.1.this.oma.a(b.3.1.this.olZ, paramAnonymous2MagicBrushView, paramAnonymous2Int5);
                    paramAnonymous2MagicBrushView.setOpaque(false);
                    int k = paramAnonymous2Int3;
                    int j = paramAnonymous2Int4;
                    int n = (int)((c)b.this.QK()).getContext().getResources().getDisplayMetrics().density;
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
                      b.3.1.this.olZ.addView(paramAnonymous2MagicBrushView, m, localLayoutParams);
                      paramAnonymous2MagicBrushView.setOpaque(false);
                      AppMethodBeat.o(271025);
                      return;
                    }
                  }
                }, 0L);
              }
              AppMethodBeat.o(264392);
            }
            
            public final void b(final MagicBrushView paramAnonymous2MagicBrushView, final int paramAnonymous2Int1, final int paramAnonymous2Int2, final int paramAnonymous2Int3, final int paramAnonymous2Int4, final int paramAnonymous2Int5)
            {
              AppMethodBeat.i(264394);
              if (b.this.QM() != null) {
                b.this.QM().h(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(245129);
                    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramAnonymous2Int3, paramAnonymous2Int4);
                    localLayoutParams.setMargins(paramAnonymous2Int1, paramAnonymous2Int2, 0, 0);
                    int i = b.3.1.this.oma.a(b.3.1.this.olZ, paramAnonymous2MagicBrushView, paramAnonymous2Int5);
                    if (i == -2)
                    {
                      paramAnonymous2MagicBrushView.setLayoutParams(localLayoutParams);
                      paramAnonymous2MagicBrushView.requestLayout();
                    }
                    for (;;)
                    {
                      paramAnonymous2MagicBrushView.setOpaque(false);
                      AppMethodBeat.o(245129);
                      return;
                      b.3.1.this.olZ.removeView(paramAnonymous2MagicBrushView);
                      b.3.1.this.olZ.addView(paramAnonymous2MagicBrushView, i, localLayoutParams);
                    }
                  }
                }, 0L);
              }
              AppMethodBeat.o(264394);
            }
            
            public final void c(final MagicBrushView paramAnonymous2MagicBrushView)
            {
              AppMethodBeat.i(264396);
              if (b.this.QM() != null) {
                b.this.QM().h(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(271391);
                    b.3.1.this.oma.cz(paramAnonymous2MagicBrushView);
                    b.3.1.this.olZ.removeView(paramAnonymous2MagicBrushView);
                    AppMethodBeat.o(271391);
                  }
                }, 0L);
              }
              AppMethodBeat.o(264396);
            }
          };
          boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.f.omx.aUb()).booleanValue();
          boolean bool1 = ((Boolean)r.omN.aUb()).booleanValue();
          boolean bool3 = ((Boolean)s.omO.aUb()).booleanValue();
          String str1;
          String str2;
          label154:
          String str3;
          if (bool2)
          {
            str1 = "yes";
            if (!bool1) {
              break label302;
            }
            str2 = "yes";
            if (!bool3) {
              break label309;
            }
            str3 = "yes";
            label163:
            Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
            if ((!bool2) || (!bool1)) {
              break label316;
            }
            bool1 = true;
            label199:
            paramAnonymousf.cK(bool1);
            if ((!bool2) || (!bool3)) {
              break label321;
            }
          }
          label302:
          label309:
          label316:
          label321:
          for (bool1 = true;; bool1 = false)
          {
            paramAnonymousf.cJ(bool1);
            paramAnonymousf.cM(((Boolean)com.tencent.mm.plugin.appbrand.game.a.d.omn.aUb()).booleanValue());
            paramAnonymousf.bg(b.this.Rz().czK.getNativeHandle());
            bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.l.omH.aUb()).booleanValue();
            paramAnonymousf.cL(bool1);
            Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "dl: supportETC2ASTC[%b]", new Object[] { Boolean.valueOf(bool1) });
            AppMethodBeat.o(272099);
            return;
            str1 = "no";
            break;
            str2 = "no";
            break label154;
            str3 = "no";
            break label163;
            bool1 = false;
            break label199;
          }
        }
      };
      this.qOA.OH();
      if (((c)QK()).isRunning()) {
        this.qOA.b(((c)QK()).getRuntime());
      }
      locali.addJavascriptInterface(new a((byte)0), "MagicBrushViewIdTransfer");
      locali.evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/NativeGlobal-WAService.js"), new ValueCallback() {});
      AppMethodBeat.o(276957);
      return;
    }
    Log.w("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: component lost");
    AppMethodBeat.o(276957);
  }
  
  public final void F(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48258);
    super.F(paramString1, paramString2);
    try
    {
      com.tencent.mm.plugin.appbrand.report.l.b((c)QK(), paramString1, paramString2);
      AppMethodBeat.o(48258);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(48258);
    }
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.o> PX()
  {
    AppMethodBeat.i(48261);
    if ((QK() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      localMap = k.cbb();
      AppMethodBeat.o(48261);
      return localMap;
    }
    Map localMap = (Map)com.tencent.luggage.sdk.h.d.a("AppBrandMiniProgramServiceLogicImpWC.onCreateJsApiPool()", new kotlin.g.a.a() {});
    AppMethodBeat.o(48261);
    return localMap;
  }
  
  public final i Pc()
  {
    Object localObject3 = null;
    AppMethodBeat.i(48257);
    final long l = System.currentTimeMillis();
    if (((c)Objects.requireNonNull(QK())).getContext() == null) {
      MMApplicationContext.getContext();
    }
    if (!((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vyH, false)) {}
    for (Object localObject2 = com.tencent.mm.plugin.appbrand.m.ad.bOR();; localObject2 = null)
    {
      Object localObject1;
      if (!((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vyG, false)) {
        if (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
          localObject1 = com.tencent.mm.plugin.appbrand.ac.d.and("wxa_library/v8_snapshot64.bin");
        }
      }
      for (;;)
      {
        ((ICommLibReader)Objects.requireNonNull(((c)QK()).bBP())).bGi();
        ao.bEm();
        boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.q.omM.aUb()).booleanValue();
        boolean bool1;
        if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.o.omK.aUb()).booleanValue())
        {
          bool1 = true;
          label148:
          localObject2 = w.a((String)localObject2, (byte[])localObject1, bool2, bool1, com.tencent.mm.plugin.appbrand.m.aa.r((com.tencent.mm.plugin.appbrand.v)QK()), (com.tencent.mm.plugin.appbrand.jsapi.f)QK());
          this.qOz = new com.tencent.mm.plugin.appbrand.u.a();
          this.qOz.a((com.tencent.mm.plugin.appbrand.v)QK(), (i)localObject2);
          localObject1 = (com.tencent.mm.plugin.appbrand.m.p)((i)localObject2).Q(com.tencent.mm.plugin.appbrand.m.p.class);
          if (localObject1 == null) {
            break label286;
          }
          ((com.tencent.mm.plugin.appbrand.m.p)localObject1).a(new p.a()
          {
            public final void onInitialized()
            {
              AppMethodBeat.i(48248);
              com.tencent.mm.plugin.appbrand.report.quality.b.cik();
              if (this.olX) {}
              for (n localn = n.qRS;; localn = null)
              {
                com.tencent.mm.plugin.appbrand.report.quality.c.a(localn, this.val$appId, l, com.tencent.mm.plugin.appbrand.report.e.f(this.cAh));
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
          localObject1 = com.tencent.mm.plugin.appbrand.ac.d.and("wxa_library/v8_snapshot.bin");
          break;
          bool1 = false;
          break label148;
          label286:
          com.tencent.mm.plugin.appbrand.report.quality.b.cik();
          localObject1 = localObject3;
          if (((c)QK()).bDU()) {
            localObject1 = n.qRS;
          }
          com.tencent.mm.plugin.appbrand.report.quality.c.a((n)localObject1, ((c)QK()).getAppId(), l, com.tencent.mm.plugin.appbrand.report.e.f((i)localObject2));
        }
        localObject1 = null;
      }
    }
  }
  
  public final void Pd()
  {
    AppMethodBeat.i(48264);
    super.Pd();
    if (com.tencent.mm.plugin.appbrand.m.aa.r((com.tencent.mm.plugin.appbrand.v)QK()))
    {
      Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "service initNativeTransLogic");
      com.tencent.mm.plugin.appbrand.m.aa.a(((c)QK()).getJsRuntime(), ((c)QK()).getComponentId(), getAppId());
      com.tencent.mm.plugin.appbrand.m.aa.a(((c)QK()).getJsRuntime(), ((c)QK()).getComponentId(), ((c)QK()).getComponentId(), getAppId());
    }
    AppMethodBeat.o(48264);
  }
  
  public final void Pe()
  {
    AppMethodBeat.i(48262);
    super.Pe();
    if (this.qOA != null) {
      this.qOA.destroy();
    }
    AppMethodBeat.o(48262);
  }
  
  public final void Pf()
  {
    AppMethodBeat.i(48263);
    super.Pf();
    if (this.qOz != null) {
      this.qOz.ccD();
    }
    AppMethodBeat.o(48263);
  }
  
  public final String Pq()
  {
    AppMethodBeat.i(48260);
    String str2 = "" + super.Pq();
    String str1 = str2;
    if (this.qOz != null) {
      str1 = str2 + this.qOz.ccE();
    }
    AppMethodBeat.o(48260);
    return str1;
  }
  
  public final int Pr()
  {
    AppMethodBeat.i(48268);
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRD, 0);
    AppMethodBeat.o(48268);
    return i;
  }
  
  public final void Pu()
  {
    AppMethodBeat.i(276950);
    super.Pu();
    AppMethodBeat.o(276950);
  }
  
  public final void Pv()
  {
    AppMethodBeat.i(276951);
    super.Pv();
    AppMethodBeat.o(276951);
  }
  
  public final String RA()
  {
    AppMethodBeat.i(276952);
    String str = af.bOR();
    AppMethodBeat.o(276952);
    return str;
  }
  
  public final int RB()
  {
    AppMethodBeat.i(276953);
    if (MMApplicationContext.getToolsProcesstPreference() != null)
    {
      i = MMApplicationContext.getToolsProcesstPreference().getInt("appbrand_wasm_opt", -2);
      if (i != -2)
      {
        Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "wasm opt set to %d by cmd", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(276953);
        return i;
      }
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vTY, -2);
    if (i != -2)
    {
      Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "wasm opt set to %d by abtest", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(276953);
      return i;
    }
    AppMethodBeat.o(276953);
    return -2;
  }
  
  public final com.tencent.luggage.sdk.b.a.c.b<c> a(t paramt)
  {
    AppMethodBeat.i(160614);
    ao.bEm();
    paramt = new a((c)Objects.requireNonNull(QK()), paramt);
    AppMethodBeat.o(160614);
    return paramt;
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48265);
    super.c(paramAppBrandRuntime);
    if (this.qOA != null) {
      this.qOA.b(paramAppBrandRuntime);
    }
    AppMethodBeat.o(48265);
  }
  
  public final boolean c(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(276948);
    if ("MediaToolKit".equals(paramString))
    {
      amQ(null);
      AppMethodBeat.o(276948);
      return true;
    }
    if ("Image".equals(paramString))
    {
      amQ(null);
      AppMethodBeat.o(276948);
      return true;
    }
    if ("OffscreenCanvas".equals(paramString))
    {
      amQ(null);
      AppMethodBeat.o(276948);
      return true;
    }
    if ("CpuProfiler".equals(paramString))
    {
      amQ(null);
      AppMethodBeat.o(276948);
      return true;
    }
    if ("HeapProfiler".equals(paramString))
    {
      amQ(null);
      AppMethodBeat.o(276948);
      return true;
    }
    if ("Profiler".equals(paramString))
    {
      amQ(null);
      AppMethodBeat.o(276948);
      return true;
    }
    if ("Box2D".equals(paramString))
    {
      amQ("mmbox2d");
      AppMethodBeat.o(276948);
      return true;
    }
    if ("Phys3D".equals(paramString))
    {
      amQ("mmphysx");
      AppMethodBeat.o(276948);
      return true;
    }
    boolean bool = super.c(paramString, paramJSONObject);
    AppMethodBeat.o(276948);
    return bool;
  }
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(276960);
    if ((QK() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(276960);
      return true;
    }
    if ((QK() != null) && (((c)QK()).qOE) && (com.tencent.mm.plugin.appbrand.ad.e.ach(paramString1)))
    {
      ((c)QK()).cp(paramString1, paramString2);
      AppMethodBeat.o(276960);
      return true;
    }
    boolean bool = super.d(paramString1, paramString2, paramInt);
    AppMethodBeat.o(276960);
    return bool;
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48266);
    super.f(paramJSONObject);
    boolean bool = aa.g((c)Objects.requireNonNull(QK()));
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
  
  public final void g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(276954);
    super.g(paramJSONObject);
    try
    {
      paramJSONObject.put("clientVersion", com.tencent.mm.protocal.d.RAD);
      paramJSONObject.put("JSEngineName", w.e(((c)QK()).getJsRuntime()));
      com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqw(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqE(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqA(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqD(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqC(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqL(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqG(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqH(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.i(com.tencent.mm.plugin.appbrand.xweb_ext.e.cqJ(), paramJSONObject);
      paramJSONObject.put("useXWebWebGLCanvas", com.tencent.mm.plugin.appbrand.xweb_ext.e.cqI());
      paramJSONObject.put("useSkiaCanvasRaf", com.tencent.mm.plugin.appbrand.xweb_ext.e.cqy());
      paramJSONObject.put("useNewXWebCanvasToTFP", com.tencent.mm.plugin.appbrand.xweb_ext.e.cqz());
      AppMethodBeat.o(276954);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", paramJSONObject, "attachCommonConfig error", new Object[0]);
      AppMethodBeat.o(276954);
    }
  }
  
  public final com.tencent.magicbrush.e getMagicBrush()
  {
    AppMethodBeat.i(276955);
    ciA();
    if (this.qOA != null)
    {
      com.tencent.magicbrush.e locale = this.qOA.getMagicBrush();
      AppMethodBeat.o(276955);
      return locale;
    }
    AppMethodBeat.o(276955);
    return null;
  }
  
  public final boolean k(int paramInt, String paramString)
  {
    AppMethodBeat.i(276962);
    if ((QK() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(276962);
      return true;
    }
    boolean bool = super.k(paramInt, paramString);
    AppMethodBeat.o(276962);
    return bool;
  }
  
  final class a
  {
    private a() {}
    
    @JavascriptInterface
    public final int exec(int paramInt)
    {
      AppMethodBeat.i(48256);
      try
      {
        Object localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.ahx(((c)b.this.QK()).getAppId()).cDe.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        int i = ((com.tencent.mm.plugin.appbrand.jsapi.b.a.b)localObject).oNl.getVirtualElementId();
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", localException, "MagicBrushViewIdTransfer failed. [%d] [%s]", new Object[] { Integer.valueOf(paramInt), ((c)b.this.QK()).getAppId() });
          paramInt = -1;
        }
      }
      AppMethodBeat.o(48256);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b
 * JD-Core Version:    0.7.0.1
 */