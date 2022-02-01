package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e.e;
import com.tencent.magicbrush.g.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.MagicBrushView.h;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.game.a.k;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.s;
import com.tencent.mm.plugin.appbrand.game.a.u;
import com.tencent.mm.plugin.appbrand.m.af;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.p;
import com.tencent.mm.plugin.appbrand.m.p.a;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.report.b.1;
import com.tencent.mm.plugin.appbrand.report.b.2;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.m.a;
import com.tencent.mm.plugin.appbrand.task.n;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.protocal.protobuf.fol;
import com.tencent.mm.protocal.protobuf.fon;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.game.d.a.a.a<com.tencent.mm.plugin.appbrand.service.c>
  implements b
{
  private com.tencent.mm.plugin.appbrand.u.a olS;
  private com.tencent.mm.plugin.appbrand.report.b olT;
  private com.tencent.luggage.game.b.b olU;
  private boolean olV;
  private long olW;
  
  public a(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(45054);
    this.olS = null;
    this.olV = false;
    this.olW = -1L;
    this.olT = new com.tencent.mm.plugin.appbrand.report.b();
    AppMethodBeat.o(45054);
  }
  
  private static boolean bOp()
  {
    AppMethodBeat.i(45057);
    boolean bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.t.omP.aUb()).booleanValue();
    boolean bool2 = ((Boolean)u.omQ.aUb()).booleanValue();
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: isUseNodeFromConfig: %b, isUseSurfaceFromConfig: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(45057);
      return true;
    }
    AppMethodBeat.o(45057);
    return false;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.o> PX()
  {
    AppMethodBeat.i(45060);
    Map localMap = (Map)com.tencent.luggage.sdk.h.d.a("AppBrandGameServiceLogicImpWC.onCreateJsApiPool()", new kotlin.g.a.a() {});
    AppMethodBeat.o(45060);
    return localMap;
  }
  
  public final void Pa()
  {
    AppMethodBeat.i(45072);
    new com.tencent.mm.plugin.appbrand.game.c.c().OO();
    AppMethodBeat.o(45072);
  }
  
  public final i Pc()
  {
    AppMethodBeat.i(45055);
    this.olW = System.currentTimeMillis();
    i locali = super.Pc();
    p localp = (p)locali.Q(p.class);
    if (localp != null)
    {
      this.olV = true;
      localp.a(new p.a()
      {
        public final void onInitialized()
        {
          AppMethodBeat.i(45048);
          com.tencent.mm.plugin.appbrand.report.quality.b.cik();
          if (this.olX) {}
          for (n localn = n.qRT;; localn = null)
          {
            com.tencent.mm.plugin.appbrand.report.quality.c.a(localn, this.val$appId, a.a(a.this), com.tencent.mm.plugin.appbrand.report.e.qIT);
            AppMethodBeat.o(45048);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(45055);
    return locali;
  }
  
  public final void Pd()
  {
    AppMethodBeat.i(45061);
    super.Pd();
    if (!this.olV)
    {
      this.olV = true;
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      if (!((com.tencent.mm.plugin.appbrand.service.c)QK()).bDU()) {
        break label69;
      }
    }
    label69:
    for (n localn = n.qRT;; localn = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.c.a(localn, ((com.tencent.mm.plugin.appbrand.service.c)QK()).getAppId(), this.olW, com.tencent.mm.plugin.appbrand.report.e.qIT);
      AppMethodBeat.o(45061);
      return;
    }
  }
  
  public final void Pe()
  {
    AppMethodBeat.i(45071);
    super.Pe();
    com.tencent.mm.plugin.appbrand.report.b localb = this.olT;
    localb.opL.post(new b.2(localb));
    AppMethodBeat.o(45071);
  }
  
  public final void Pf()
  {
    AppMethodBeat.i(45059);
    super.Pf();
    if (this.olS != null) {
      this.olS.ccD();
    }
    if (this.olU != null)
    {
      com.tencent.luggage.game.b.b localb = this.olU;
      localb.csB.removeDecodeEventListener(localb);
      Log.i("MicroMsg.MBImageDecodeRegistry", "MBImageDecodeRegistry unregister appid:%s,game:%b", new Object[] { localb.appId, Boolean.valueOf(localb.csz) });
    }
    AppMethodBeat.o(45059);
  }
  
  public final String Pg()
  {
    AppMethodBeat.i(45062);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vyH, false))
    {
      String str = com.tencent.mm.plugin.appbrand.m.ad.bOR();
      AppMethodBeat.o(45062);
      return str;
    }
    AppMethodBeat.o(45062);
    return null;
  }
  
  public final boolean Ph()
  {
    AppMethodBeat.i(45064);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vyG, false))
    {
      AppMethodBeat.o(45064);
      return true;
    }
    AppMethodBeat.o(45064);
    return false;
  }
  
  public final boolean Pj()
  {
    AppMethodBeat.i(45065);
    boolean bool;
    if (MMApplicationContext.getToolsProcesstPreference() != null)
    {
      int i = MMApplicationContext.getToolsProcesstPreference().getInt("appbrandgame_use_commandbuffer", -1);
      if (i != -1)
      {
        if (i != 0) {}
        for (bool = true;; bool = false)
        {
          Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "command buffer enabled %b by cmd", new Object[] { Boolean.valueOf(bool) });
          if (i == 0) {
            break;
          }
          AppMethodBeat.o(45065);
          return true;
        }
        AppMethodBeat.o(45065);
        return false;
      }
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGG, false))
    {
      Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "command buffer enabled false by abtest");
      AppMethodBeat.o(45065);
      return false;
    }
    if ((QK() != null) && (((com.tencent.mm.plugin.appbrand.service.c)QK()).getRuntime() != null))
    {
      com.tencent.mm.plugin.appbrand.config.b localb = ((com.tencent.mm.plugin.appbrand.service.c)QK()).getRuntime().getAppConfig();
      if ((localb != null) && (localb.nVZ != null))
      {
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "command buffer enabled %b by app.config", new Object[] { localb.nVZ });
        bool = localb.nVZ.booleanValue();
        AppMethodBeat.o(45065);
        return bool;
      }
    }
    AppMethodBeat.o(45065);
    return true;
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(45066);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGH, false))
    {
      AppMethodBeat.o(45066);
      return true;
    }
    AppMethodBeat.o(45066);
    return false;
  }
  
  public final int Pl()
  {
    AppMethodBeat.i(45067);
    if (MMApplicationContext.getToolsProcesstPreference() != null)
    {
      i = MMApplicationContext.getToolsProcesstPreference().getInt("appbrandgame_cmd_pool_type", -1);
      if (i != -1)
      {
        AppMethodBeat.o(45067);
        return i;
      }
    }
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
    {
      AppMethodBeat.o(45067);
      return 1;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGI, 1);
    AppMethodBeat.o(45067);
    return i;
  }
  
  public final boolean Pm()
  {
    AppMethodBeat.i(282014);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vGL, false);
    AppMethodBeat.o(282014);
    return bool;
  }
  
  public final void Po()
  {
    AppMethodBeat.i(282012);
    super.Po();
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "virl: runtime resume");
    AppMethodBeat.o(282012);
  }
  
  public final String Pq()
  {
    AppMethodBeat.i(45058);
    String str2 = super.Pq();
    String str1 = str2;
    if (this.olS != null) {
      str1 = str2 + this.olS.ccE();
    }
    AppMethodBeat.o(45058);
    return str1;
  }
  
  public final int Pr()
  {
    AppMethodBeat.i(45068);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vRD, 0);
    AppMethodBeat.o(45068);
    return i;
  }
  
  public final String RA()
  {
    AppMethodBeat.i(282017);
    String str = af.bOR();
    AppMethodBeat.o(282017);
    return str;
  }
  
  public final int RB()
  {
    AppMethodBeat.i(282018);
    if (MMApplicationContext.getToolsProcesstPreference() != null)
    {
      i = MMApplicationContext.getToolsProcesstPreference().getInt("appbrand_wasm_opt", -2);
      if (i != -2)
      {
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "wasm opt set to %d by cmd", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(282018);
        return i;
      }
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vTY, -2);
    if (i != -2)
    {
      Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "wasm opt set to %d by abtest", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(282018);
      return i;
    }
    AppMethodBeat.o(282018);
    return -2;
  }
  
  public final boolean Rp()
  {
    AppMethodBeat.i(174723);
    if ((((com.tencent.mm.plugin.appbrand.service.c)QK()).getRuntime() != null) && (((com.tencent.mm.plugin.appbrand.service.c)QK()).getRuntime().Rp()))
    {
      AppMethodBeat.o(174723);
      return true;
    }
    AppMethodBeat.o(174723);
    return false;
  }
  
  public final com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(282019);
    a locala = new a(((com.tencent.mm.plugin.appbrand.service.c)QK()).getContext(), ((com.tencent.mm.plugin.appbrand.service.c)QK()).getJsRuntime(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    AppMethodBeat.o(282019);
    return locala;
  }
  
  public final void b(com.tencent.mm.plugin.music.b.a parama)
  {
    AppMethodBeat.i(282023);
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "setWxAudioOutputListener %s", new Object[] { parama });
    if (parama != null)
    {
      this.cuy.a(parama);
      AppMethodBeat.o(282023);
      return;
    }
    this.cuy.RC();
    AppMethodBeat.o(282023);
  }
  
  public final com.tencent.mm.plugin.appbrand.report.b bOq()
  {
    return this.olT;
  }
  
  public final void c(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45063);
    super.c(paramAppBrandRuntime);
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: wc post runtime ready");
    com.tencent.mm.plugin.appbrand.report.b localb = this.olT;
    com.tencent.mm.plugin.appbrand.report.b.a local3 = new com.tencent.mm.plugin.appbrand.report.b.a()
    {
      public final void ev(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(45050);
        if (paramAppBrandRuntime == null)
        {
          Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: can not get runtime!");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAppBrandRuntime.ntU.get()) || (paramAppBrandRuntime.aol))
        {
          Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: runtime finished. abort");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Object localObject1 = paramAppBrandRuntime.mAppId;
          Object localObject2 = a.b(a.this);
          paramAppBrandRuntime.Sp();
          com.tencent.mm.plugin.appbrand.report.quality.b.a((String)localObject1, (com.tencent.mm.plugin.appbrand.report.b)localObject2);
          a.a(a.this, new com.tencent.luggage.game.b.b());
          localObject2 = a.c(a.this);
          com.tencent.magicbrush.e locale = a.this.cut.getMagicBrush();
          localObject1 = a.this.QM();
          ((com.tencent.luggage.game.b.b)localObject2).appId = ((AppBrandRuntime)localObject1).mAppId;
          Log.i("MicroMsg.MBImageDecodeRegistry", "MBImageDecodeRegistry register appid:%s,game:%b", new Object[] { ((com.tencent.luggage.game.b.b)localObject2).appId, Boolean.TRUE });
          ((com.tencent.luggage.game.b.b)localObject2).csC = new ArrayList();
          ((com.tencent.luggage.game.b.b)localObject2).csG = 1004;
          ((com.tencent.luggage.game.b.b)localObject2).csz = true;
          if ((localObject1 != null) && ((((AppBrandRuntime)localObject1).QW() instanceof com.tencent.luggage.sdk.b.a.c.d))) {
            localObject1 = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.c.d)((AppBrandRuntime)localObject1).QW()).R(com.tencent.luggage.game.d.a.a.b.class);
          }
          for (;;)
          {
            ((com.tencent.luggage.game.b.b)localObject2).csA = new WeakReference(localObject1);
            ((com.tencent.luggage.game.b.b)localObject2).csB = locale.UN();
            ((com.tencent.luggage.game.b.b)localObject2).csB.addDecodeEventListener((IImageDecodeService.b)localObject2);
            localObject1 = a.c(a.this);
            boolean bool = a.b(a.this).qIr.UMB;
            paramAnonymousInt1 = a.b(a.this).qIr.UMC;
            double d = a.b(a.this).qIr.UMD;
            try
            {
              Log.i("MicroMsg.MBImageDecodeRegistry", "setConfig shouldDoSample:%b,maxSampleNum:%d,sampleRate:%f", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt1), Double.valueOf(d) });
              ((com.tencent.luggage.game.b.b)localObject1).csD = bool;
              ((com.tencent.luggage.game.b.b)localObject1).csE = paramAnonymousInt1;
              ((com.tencent.luggage.game.b.b)localObject1).csF = d;
              localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)a.this.QK()).bDv();
              if (localObject1 == null)
              {
                Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: no game renderer!");
                AppMethodBeat.o(45050);
                return;
                localObject1 = null;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.MBImageDecodeRegistry", localException, "setConfig Exception", new Object[0]);
              }
              localObject1 = (com.tencent.mm.plugin.appbrand.game.f.a)((com.tencent.mm.plugin.appbrand.page.ad)localObject1).R(com.tencent.mm.plugin.appbrand.game.f.a.class);
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).a(a.b(a.this));
              }
              for (;;)
              {
                localObject1 = a.b(a.this).qIp;
                if ((localObject1 == null) || (((fon)localObject1).UME == 0) || (((fon)localObject1).UMG == 0) || (((fon)localObject1).UMH == 0) || (((fon)localObject1).UMI == 0) || (((fon)localObject1).UMF == 0)) {
                  break;
                }
                a.this.cut.getMagicBrush().cwf.a(((fon)localObject1).UMG, ((fon)localObject1).UMH, ((fon)localObject1).UMI, ((fon)localObject1).UMF, false);
                AppMethodBeat.o(45050);
                return;
                Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: not game renderer!");
              }
              if (DebuggerShell.bLS()) {
                a.this.cut.getMagicBrush().cwf.a(5, 10, 10.0F, 60, true);
              }
              AppMethodBeat.o(45050);
              return;
            }
          }
        }
        Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: get sampling failed!");
        AppMethodBeat.o(45050);
      }
    };
    localb.opL.post(new b.1(localb, paramAppBrandRuntime, local3));
    AppMethodBeat.o(45063);
  }
  
  public final i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(45056);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.fhP = paramString;
    localConfig.fhQ = paramArrayOfByte;
    paramString = (String)com.tencent.mm.plugin.appbrand.game.a.h.omz.aUb();
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use native buffer type: %s", new Object[] { paramString });
    localConfig.fhR = paramString;
    localConfig.fhS = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vEz, true);
    localConfig.fhU = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.q.omM.aUb()).booleanValue();
    boolean bool;
    if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.o.omK.aUb()).booleanValue())
    {
      bool = true;
      localConfig.fhV = bool;
      localConfig.fhY = new WeakReference(QK());
      bool = bOp();
      Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: should use node: %b, config is %s", new Object[] { Boolean.valueOf(bool), localConfig.toString() });
      if (!bool) {
        break label284;
      }
    }
    label284:
    for (paramString = new com.tencent.mm.plugin.appbrand.m.x(localConfig);; paramString = new com.tencent.mm.plugin.appbrand.m.b(localConfig))
    {
      if ((paramString instanceof com.tencent.mm.plugin.appbrand.m.x))
      {
        this.olS = new com.tencent.mm.plugin.appbrand.u.a();
        this.olS.a((com.tencent.mm.plugin.appbrand.v)QK(), paramString);
      }
      paramArrayOfByte = (com.tencent.mm.plugin.appbrand.m.q)paramString.Q(com.tencent.mm.plugin.appbrand.m.q.class);
      if (paramArrayOfByte != null)
      {
        bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.j.agw("tracejstask").aUb()).booleanValue();
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: Trace Task Name in JSThread: ".concat(String.valueOf(bool)));
        paramArrayOfByte.dp(bool);
      }
      AppMethodBeat.o(45056);
      return paramString;
      bool = false;
      break;
    }
  }
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(282022);
    if ((QK() != null) && (((com.tencent.mm.plugin.appbrand.service.c)QK()).qOE) && (com.tencent.mm.plugin.appbrand.ad.e.ach(paramString1)))
    {
      ((com.tencent.mm.plugin.appbrand.service.c)QK()).cp(paramString1, paramString2);
      AppMethodBeat.o(282022);
      return true;
    }
    boolean bool = super.d(paramString1, paramString2, paramInt);
    AppMethodBeat.o(282022);
    return bool;
  }
  
  public final String dZ(String paramString)
  {
    AppMethodBeat.i(45070);
    if (Rp())
    {
      paramString = com.tencent.mm.plugin.appbrand.debugger.x.a(paramString, ((com.tencent.mm.plugin.appbrand.service.c)QK()).getRuntime());
      AppMethodBeat.o(45070);
      return paramString;
    }
    AppMethodBeat.o(45070);
    return "";
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(282021);
    super.f(paramJSONObject);
    ((com.tencent.mm.plugin.appbrand.service.c)QK()).c(paramJSONObject, "statusBarHeight", Integer.valueOf(com.tencent.luggage.game.g.a.b((com.tencent.luggage.sdk.b.a.c.d)QK())));
    HashMap localHashMap = new HashMap(6);
    Object localObject = ak.f((com.tencent.mm.plugin.appbrand.jsapi.j)QK());
    int m = localObject[0];
    int k = localObject[1];
    localObject = ((com.tencent.mm.plugin.appbrand.service.c)QK()).nxr.getSafeAreaInsets();
    if (localObject != null)
    {
      int i = com.tencent.mm.plugin.appbrand.ac.g.Dg(((Rect)localObject).left);
      int j = com.tencent.mm.plugin.appbrand.ac.g.Dg(((Rect)localObject).top);
      m = com.tencent.mm.plugin.appbrand.ac.g.Dg(Math.min(((Rect)localObject).right, m));
      k = com.tencent.mm.plugin.appbrand.ac.g.Dg(Math.min(((Rect)localObject).bottom, k));
      localHashMap.put("left", Integer.valueOf(i));
      localHashMap.put("top", Integer.valueOf(j));
      localHashMap.put("right", Integer.valueOf(m));
      localHashMap.put("bottom", Integer.valueOf(k));
      localHashMap.put("width", Integer.valueOf(m - i));
      localHashMap.put("height", Integer.valueOf(k - j));
      ((com.tencent.mm.plugin.appbrand.service.c)QK()).c(paramJSONObject, "safeArea", localHashMap);
    }
    AppMethodBeat.o(282021);
  }
  
  public final void g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(282010);
    super.g(paramJSONObject);
    try
    {
      paramJSONObject.put("clientVersion", com.tencent.mm.protocal.d.RAD);
      paramJSONObject.put("JSEngineName", com.tencent.mm.plugin.appbrand.m.w.e(((com.tencent.mm.plugin.appbrand.service.c)QK()).getJsRuntime()));
      AppMethodBeat.o(282010);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandGameServiceLogicImpWC", paramJSONObject, "attachCommonConfig error", new Object[0]);
      AppMethodBeat.o(282010);
    }
  }
  
  public final void iH(int paramInt)
  {
    AppMethodBeat.i(45069);
    super.iH(paramInt);
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.b.amO(((com.tencent.mm.plugin.appbrand.service.c)QK()).getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 1)
    {
      ((QualitySessionRuntime)localObject).qNL.qNX = m.a.qNZ;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 2)
    {
      ((QualitySessionRuntime)localObject).qNL.qNX = m.a.qOa;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 3)
    {
      ((QualitySessionRuntime)localObject).qNL.qNX = m.a.qOb;
      AppMethodBeat.o(45069);
      return;
    }
    localObject = new RuntimeException("MainCanvasType invalid type == ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(45069);
    throw ((Throwable)localObject);
  }
  
  final class a
    extends com.tencent.luggage.game.a.b
  {
    public a(Context paramContext, i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
    {
      super(parami, paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    }
    
    public final void a(com.tencent.magicbrush.e parame, long paramLong)
    {
      AppMethodBeat.i(45052);
      com.tencent.mm.plugin.appbrand.report.quality.b.cik();
      com.tencent.mm.plugin.appbrand.report.quality.c.a(((com.tencent.mm.plugin.appbrand.service.c)a.this.QK()).bDU(), ((com.tencent.mm.plugin.appbrand.service.c)a.this.QK()).getAppId(), paramLong);
      AppMethodBeat.o(45052);
    }
    
    public final void a(com.tencent.magicbrush.f paramf)
    {
      AppMethodBeat.i(45051);
      super.a(paramf);
      boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vCt, false);
      paramf.cME.a(com.tencent.magicbrush.g.cMt[6], Boolean.valueOf(bool1));
      paramf.ae(com.tencent.mm.plugin.appbrand.game.a.e.omt.dI(((com.tencent.mm.plugin.appbrand.service.c)a.this.QK()).getContext()));
      paramf.cD(com.tencent.mm.plugin.appbrand.game.a.w.bOA());
      bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.b.oml.aUb()).booleanValue();
      paramf.cMF.a(com.tencent.magicbrush.g.cMt[7], Boolean.valueOf(bool1));
      bool1 = ((Boolean)u.omQ.aUb()).booleanValue();
      String str1;
      label206:
      String str2;
      label214:
      String str3;
      if ((a.bOr()) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.v.omR.aUb()).booleanValue()))
      {
        paramf.b(a.b.cPr);
        paramf.cMl = new e.e()
        {
          FrameLayout olZ;
          com.tencent.magicbrush.utils.e oma;
          
          public final MagicBrushView UV()
          {
            AppMethodBeat.i(256143);
            MagicBrushView localMagicBrushView = new MagicBrushView(((com.tencent.mm.plugin.appbrand.service.c)a.this.QK()).getContext(), MagicBrushView.h.cPU);
            localMagicBrushView.setContentDescription("ScreenCanvasMagicBrushView");
            localMagicBrushView.setMagicBrush(a.a.this.getMagicBrush());
            localMagicBrushView.setUseRawAxisTouchEvent(true);
            AppMethodBeat.o(256143);
            return localMagicBrushView;
          }
          
          public final void a(final MagicBrushView paramAnonymousMagicBrushView, final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3, final int paramAnonymousInt4, final int paramAnonymousInt5)
          {
            AppMethodBeat.i(256145);
            if (a.this.QM() != null) {
              a.this.QM().h(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(273777);
                  if (a.a.1.this.olZ == null)
                  {
                    a.a.1.this.olZ = new FrameLayout(((com.tencent.mm.plugin.appbrand.service.c)a.this.QK()).getContext());
                    ((com.tencent.mm.plugin.appbrand.service.c)a.this.QK()).bDv().qsz.bPF().addView(a.a.1.this.olZ, 0, new ViewGroup.LayoutParams(-1, -1));
                  }
                  int m = a.a.1.this.oma.a(a.a.1.this.olZ, paramAnonymousMagicBrushView, paramAnonymousInt5);
                  paramAnonymousMagicBrushView.setOpaque(false);
                  int k = paramAnonymousInt3;
                  int j = paramAnonymousInt4;
                  int n = (int)((com.tencent.mm.plugin.appbrand.service.c)a.this.QK()).getContext().getResources().getDisplayMetrics().density;
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
                    localLayoutParams.setMargins(paramAnonymousInt1, paramAnonymousInt2, 0, 0);
                    a.a.1.this.olZ.addView(paramAnonymousMagicBrushView, m, localLayoutParams);
                    paramAnonymousMagicBrushView.setOpaque(false);
                    AppMethodBeat.o(273777);
                    return;
                  }
                }
              }, 0L);
            }
            AppMethodBeat.o(256145);
          }
          
          public final void b(final MagicBrushView paramAnonymousMagicBrushView, final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3, final int paramAnonymousInt4, final int paramAnonymousInt5)
          {
            AppMethodBeat.i(256147);
            if (a.this.QM() != null) {
              a.this.QM().h(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(243093);
                  FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramAnonymousInt3, paramAnonymousInt4);
                  localLayoutParams.setMargins(paramAnonymousInt1, paramAnonymousInt2, 0, 0);
                  int i = a.a.1.this.oma.a(a.a.1.this.olZ, paramAnonymousMagicBrushView, paramAnonymousInt5);
                  if (i == -2)
                  {
                    paramAnonymousMagicBrushView.setLayoutParams(localLayoutParams);
                    paramAnonymousMagicBrushView.requestLayout();
                  }
                  for (;;)
                  {
                    paramAnonymousMagicBrushView.setOpaque(false);
                    AppMethodBeat.o(243093);
                    return;
                    a.a.1.this.olZ.removeView(paramAnonymousMagicBrushView);
                    a.a.1.this.olZ.addView(paramAnonymousMagicBrushView, i, localLayoutParams);
                  }
                }
              }, 0L);
            }
            AppMethodBeat.o(256147);
          }
          
          public final void c(final MagicBrushView paramAnonymousMagicBrushView)
          {
            AppMethodBeat.i(256148);
            if (a.this.QM() != null) {
              a.this.QM().h(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(270587);
                  a.a.1.this.oma.cz(paramAnonymousMagicBrushView);
                  a.a.1.this.olZ.removeView(paramAnonymousMagicBrushView);
                  AppMethodBeat.o(270587);
                }
              }, 0L);
            }
            AppMethodBeat.o(256148);
          }
        };
        boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.f.omx.aUb()).booleanValue();
        bool1 = ((Boolean)r.omN.aUb()).booleanValue();
        boolean bool3 = ((Boolean)s.omO.aUb()).booleanValue();
        if (!bool2) {
          break label464;
        }
        str1 = "yes";
        if (!bool1) {
          break label472;
        }
        str2 = "yes";
        if (!bool3) {
          break label480;
        }
        str3 = "yes";
        label223:
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
        if ((!bool2) || (!bool1)) {
          break label488;
        }
        bool1 = true;
        label259:
        paramf.cK(bool1);
        if ((!bool2) || (!bool3)) {
          break label493;
        }
      }
      label464:
      label472:
      label480:
      label488:
      label493:
      for (bool1 = true;; bool1 = false)
      {
        paramf.cJ(bool1);
        bool1 = ((Boolean)l.omH.aUb()).booleanValue();
        paramf.cL(bool1);
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: supportETC2ASTC[%b]", new Object[] { Boolean.valueOf(bool1) });
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use animation handler: %s", new Object[] { paramf.Va().toString() });
        paramf.cG(((Boolean)com.tencent.mm.plugin.appbrand.game.a.c.omm.aUb()).booleanValue());
        paramf.cH(((Boolean)com.tencent.mm.plugin.appbrand.game.a.o.omK.aUb()).booleanValue());
        paramf.cI(((Boolean)k.omG.aUb()).booleanValue());
        paramf.cM(((Boolean)com.tencent.mm.plugin.appbrand.game.a.d.omn.aUb()).booleanValue());
        paramf.bg(a.this.Rz().czK.getNativeHandle());
        AppMethodBeat.o(45051);
        return;
        if (!bool1)
        {
          paramf.b(a.b.cPp);
          break;
        }
        if (a.bOr())
        {
          paramf.b(a.b.cPo);
          break;
        }
        paramf.b(a.b.cPn);
        break;
        str1 = "no";
        break label206;
        str2 = "no";
        break label214;
        str3 = "no";
        break label223;
        bool1 = false;
        break label259;
      }
    }
    
    public final void a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(45053);
      super.a(paramAppBrandRuntime);
      com.tencent.mm.plugin.appbrand.game.c.a.omZ.a(getMagicBrush(), paramAppBrandRuntime);
      a.d(a.this);
      AppMethodBeat.o(45053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a
 * JD-Core Version:    0.7.0.1
 */