package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.g.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.game.a.h;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.t;
import com.tencent.mm.plugin.appbrand.game.a.u;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.appbrand.m.af;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.p.a;
import com.tencent.mm.plugin.appbrand.m.w;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.b.1;
import com.tencent.mm.plugin.appbrand.report.b.2;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.m.a;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.protocal.protobuf.fdm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.game.d.a.a.a<com.tencent.mm.plugin.appbrand.service.c>
  implements b
{
  private com.tencent.mm.plugin.appbrand.u.a lri;
  private com.tencent.mm.plugin.appbrand.report.b lrj;
  private boolean lrk;
  private long lrl;
  
  public a(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(45054);
    this.lri = null;
    this.lrk = false;
    this.lrl = -1L;
    this.lrj = new com.tencent.mm.plugin.appbrand.report.b();
    AppMethodBeat.o(45054);
  }
  
  private static boolean bCU()
  {
    AppMethodBeat.i(45057);
    boolean bool1 = ((Boolean)r.lrS.aLT()).booleanValue();
    boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.s.lrT.aLT()).booleanValue();
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: isUseNodeFromConfig: %b, isUseSurfaceFromConfig: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(45057);
      return true;
    }
    AppMethodBeat.o(45057);
    return false;
  }
  
  public final void Mi()
  {
    AppMethodBeat.i(45072);
    new com.tencent.mm.plugin.appbrand.game.c.c().LW();
    AppMethodBeat.o(45072);
  }
  
  public final i Mk()
  {
    AppMethodBeat.i(45055);
    this.lrl = System.currentTimeMillis();
    i locali = super.Mk();
    com.tencent.mm.plugin.appbrand.m.p localp = (com.tencent.mm.plugin.appbrand.m.p)locali.R(com.tencent.mm.plugin.appbrand.m.p.class);
    if (localp != null)
    {
      this.lrk = true;
      localp.a(new p.a()
      {
        public final void onInitialized()
        {
          AppMethodBeat.i(45048);
          com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
          if (this.lrm) {}
          for (com.tencent.mm.plugin.appbrand.task.g localg = com.tencent.mm.plugin.appbrand.task.g.nPE;; localg = null)
          {
            com.tencent.mm.plugin.appbrand.report.quality.c.a(localg, this.val$appId, a.a(a.this), com.tencent.mm.plugin.appbrand.report.e.nGI);
            AppMethodBeat.o(45048);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(45055);
    return locali;
  }
  
  public final void Ml()
  {
    AppMethodBeat.i(45061);
    super.Ml();
    if (!this.lrk)
    {
      this.lrk = true;
      com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
      if (!((com.tencent.mm.plugin.appbrand.service.c)NN()).bsW()) {
        break label69;
      }
    }
    label69:
    for (com.tencent.mm.plugin.appbrand.task.g localg = com.tencent.mm.plugin.appbrand.task.g.nPE;; localg = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.c.a(localg, ((com.tencent.mm.plugin.appbrand.service.c)NN()).getAppId(), this.lrl, com.tencent.mm.plugin.appbrand.report.e.nGI);
      AppMethodBeat.o(45061);
      return;
    }
  }
  
  public final void Mm()
  {
    AppMethodBeat.i(45071);
    super.Mm();
    com.tencent.mm.plugin.appbrand.report.b localb = this.lrj;
    localb.luO.post(new b.2(localb));
    AppMethodBeat.o(45071);
  }
  
  public final void Mn()
  {
    AppMethodBeat.i(45059);
    super.Mn();
    if (this.lri != null) {
      this.lri.bPW();
    }
    AppMethodBeat.o(45059);
  }
  
  public final String Mo()
  {
    AppMethodBeat.i(45062);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSi, false))
    {
      String str = ad.bDt();
      AppMethodBeat.o(45062);
      return str;
    }
    AppMethodBeat.o(45062);
    return null;
  }
  
  public final boolean Mp()
  {
    AppMethodBeat.i(45064);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSh, false))
    {
      AppMethodBeat.o(45064);
      return true;
    }
    AppMethodBeat.o(45064);
    return false;
  }
  
  public final boolean Mr()
  {
    AppMethodBeat.i(45065);
    if (MMApplicationContext.getToolsProcesstPreference() != null)
    {
      int i = MMApplicationContext.getToolsProcesstPreference().getInt("appbrandgame_use_commandbuffer", -1);
      if (i != -1)
      {
        if (i != 0)
        {
          AppMethodBeat.o(45065);
          return true;
        }
        AppMethodBeat.o(45065);
        return false;
      }
    }
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rZG, false))
    {
      AppMethodBeat.o(45065);
      return true;
    }
    AppMethodBeat.o(45065);
    return false;
  }
  
  public final boolean Ms()
  {
    AppMethodBeat.i(45066);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rZH, false))
    {
      AppMethodBeat.o(45066);
      return true;
    }
    AppMethodBeat.o(45066);
    return false;
  }
  
  public final int Mt()
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
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rZI, 1);
    AppMethodBeat.o(45067);
    return i;
  }
  
  public final boolean Mu()
  {
    AppMethodBeat.i(226610);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rZL, false);
    AppMethodBeat.o(226610);
    return bool;
  }
  
  public final String My()
  {
    AppMethodBeat.i(45058);
    String str2 = super.My();
    String str1 = str2;
    if (this.lri != null) {
      str1 = str2 + this.lri.bPX();
    }
    AppMethodBeat.o(45058);
    return str1;
  }
  
  public final int Mz()
  {
    AppMethodBeat.i(45068);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.shG, 0);
    AppMethodBeat.o(45068);
    return i;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Nf()
  {
    AppMethodBeat.i(45060);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandGameServiceLogicImpWC.onCreateJsApiPool()", new kotlin.g.a.a() {});
    AppMethodBeat.o(45060);
    return localMap;
  }
  
  public final String OB()
  {
    AppMethodBeat.i(226611);
    String str = af.bDt();
    AppMethodBeat.o(226611);
    return str;
  }
  
  public final com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(226612);
    a locala = new a(((com.tencent.mm.plugin.appbrand.service.c)NN()).getContext(), ((com.tencent.mm.plugin.appbrand.service.c)NN()).getJsRuntime(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    AppMethodBeat.o(226612);
    return locala;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.b bCV()
  {
    return this.lrj;
  }
  
  public final void c(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45063);
    super.c(paramAppBrandRuntime);
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: wc post runtime ready");
    com.tencent.mm.plugin.appbrand.report.b localb = this.lrj;
    com.tencent.mm.plugin.appbrand.report.b.a local3 = new com.tencent.mm.plugin.appbrand.report.b.a()
    {
      public final void dW(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(45050);
        if (paramAppBrandRuntime == null)
        {
          Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: can not get runtime!");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAppBrandRuntime.isDestroyed()) || (paramAppBrandRuntime.SO))
        {
          Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: runtime finished. abort");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Object localObject = paramAppBrandRuntime.mAppId;
          com.tencent.mm.plugin.appbrand.report.b localb = a.b(a.this);
          paramAppBrandRuntime.OT();
          com.tencent.mm.plugin.appbrand.report.quality.b.a((String)localObject, localb);
          localObject = ((com.tencent.mm.plugin.appbrand.service.c)a.this.NN()).bsz();
          if (localObject == null)
          {
            Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: no game renderer!");
            AppMethodBeat.o(45050);
            return;
          }
          localObject = (com.tencent.mm.plugin.appbrand.game.f.a)((ac)localObject).S(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if (localObject != null) {
            ((com.tencent.mm.plugin.appbrand.game.f.a)localObject).a(a.b(a.this));
          }
          for (;;)
          {
            localObject = a.b(a.this).nGd;
            if ((localObject == null) || (((fdm)localObject).Nza == 0) || (((fdm)localObject).Nzc == 0) || (((fdm)localObject).Nzd == 0) || (((fdm)localObject).Nze == 0) || (((fdm)localObject).Nzb == 0)) {
              break;
            }
            a.this.cwa.getMagicBrush().cxx.a(((fdm)localObject).Nzc, ((fdm)localObject).Nzd, ((fdm)localObject).Nze, ((fdm)localObject).Nzb, false);
            AppMethodBeat.o(45050);
            return;
            Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: not game renderer!");
          }
          if (DebuggerShell.bAx()) {
            a.this.cwa.getMagicBrush().cxx.a(5, 10, 10.0F, 60, true);
          }
          AppMethodBeat.o(45050);
          return;
        }
        Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: get sampling failed!");
        AppMethodBeat.o(45050);
      }
    };
    localb.luO.post(new b.1(localb, paramAppBrandRuntime, local3));
    AppMethodBeat.o(45063);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(226613);
    super.c(paramJSONObject);
    ((com.tencent.mm.plugin.appbrand.service.c)NN()).c(paramJSONObject, "statusBarHeight", Integer.valueOf(com.tencent.luggage.game.g.a.b((com.tencent.luggage.sdk.b.a.c.d)NN())));
    HashMap localHashMap = new HashMap(6);
    Object localObject = ai.f((com.tencent.mm.plugin.appbrand.jsapi.k)NN());
    int m = localObject[0];
    int k = localObject[1];
    localObject = ((com.tencent.mm.plugin.appbrand.service.c)NN()).kEb.getSafeAreaInsets();
    if (localObject != null)
    {
      int i = com.tencent.mm.plugin.appbrand.ac.g.zB(((Rect)localObject).left);
      int j = com.tencent.mm.plugin.appbrand.ac.g.zB(((Rect)localObject).top);
      m = com.tencent.mm.plugin.appbrand.ac.g.zB(Math.min(((Rect)localObject).right, m));
      k = com.tencent.mm.plugin.appbrand.ac.g.zB(Math.min(((Rect)localObject).bottom, k));
      localHashMap.put("left", Integer.valueOf(i));
      localHashMap.put("top", Integer.valueOf(j));
      localHashMap.put("right", Integer.valueOf(m));
      localHashMap.put("bottom", Integer.valueOf(k));
      localHashMap.put("width", Integer.valueOf(m - i));
      localHashMap.put("height", Integer.valueOf(k - j));
      ((com.tencent.mm.plugin.appbrand.service.c)NN()).c(paramJSONObject, "safeArea", localHashMap);
    }
    AppMethodBeat.o(226613);
  }
  
  public final i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(45056);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.dpj = paramString;
    localConfig.dpk = paramArrayOfByte;
    paramString = (String)h.lrE.aLT();
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use native buffer type: %s", new Object[] { paramString });
    localConfig.dpl = paramString;
    localConfig.dpm = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rXG, true);
    localConfig.dpo = ((Boolean)o.lrP.aLT()).booleanValue();
    boolean bool;
    if (!((Boolean)m.lrN.aLT()).booleanValue())
    {
      bool = true;
      localConfig.dpp = bool;
      localConfig.dps = new WeakReference(NN());
      bool = bCU();
      Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: should use node: %b, config is %s", new Object[] { Boolean.valueOf(bool), localConfig.toString() });
      if (!bool) {
        break label283;
      }
    }
    label283:
    for (paramString = new x(localConfig);; paramString = new com.tencent.mm.plugin.appbrand.m.b(localConfig))
    {
      if ((paramString instanceof x))
      {
        this.lri = new com.tencent.mm.plugin.appbrand.u.a();
        this.lri.a((com.tencent.mm.plugin.appbrand.s)NN(), paramString);
      }
      paramArrayOfByte = (com.tencent.mm.plugin.appbrand.m.q)paramString.R(com.tencent.mm.plugin.appbrand.m.q.class);
      if (paramArrayOfByte != null)
      {
        bool = ((Boolean)j.YI("tracejstask").aLT()).booleanValue();
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: Trace Task Name in JSThread: ".concat(String.valueOf(bool)));
        paramArrayOfByte.cS(bool);
      }
      AppMethodBeat.o(45056);
      return paramString;
      bool = false;
      break;
    }
  }
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(226609);
    super.d(paramJSONObject);
    try
    {
      paramJSONObject.put("clientVersion", com.tencent.mm.protocal.d.KyO);
      paramJSONObject.put("JSEngineName", w.c(((com.tencent.mm.plugin.appbrand.service.c)NN()).getJsRuntime()));
      AppMethodBeat.o(226609);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandGameServiceLogicImpWC", paramJSONObject, "attachCommonConfig error", new Object[0]);
      AppMethodBeat.o(226609);
    }
  }
  
  public final String dH(String paramString)
  {
    AppMethodBeat.i(45070);
    if ((((com.tencent.mm.plugin.appbrand.service.c)NN()).getRuntime() != null) && (((com.tencent.mm.plugin.appbrand.service.c)NN()).getRuntime().OQ())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = v.a(paramString, ((com.tencent.mm.plugin.appbrand.service.c)NN()).getRuntime());
      AppMethodBeat.o(45070);
      return paramString;
    }
    AppMethodBeat.o(45070);
    return "";
  }
  
  public final void hH(int paramInt)
  {
    AppMethodBeat.i(45069);
    super.hH(paramInt);
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(((com.tencent.mm.plugin.appbrand.service.c)NN()).getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 1)
    {
      ((QualitySessionRuntime)localObject).nLy.nLJ = m.a.nLL;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 2)
    {
      ((QualitySessionRuntime)localObject).nLy.nLJ = m.a.nLM;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 3)
    {
      ((QualitySessionRuntime)localObject).nLy.nLJ = m.a.nLN;
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
      com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
      com.tencent.mm.plugin.appbrand.report.quality.c.a(((com.tencent.mm.plugin.appbrand.service.c)a.this.NN()).bsW(), ((com.tencent.mm.plugin.appbrand.service.c)a.this.NN()).getAppId(), paramLong);
      AppMethodBeat.o(45052);
    }
    
    public final void a(com.tencent.magicbrush.f paramf)
    {
      AppMethodBeat.i(45051);
      super.a(paramf);
      boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rVT, false);
      paramf.cLT.a(com.tencent.magicbrush.g.cLI[6], Boolean.valueOf(bool1));
      paramf.af(com.tencent.mm.plugin.appbrand.game.a.e.lry.dJ(((com.tencent.mm.plugin.appbrand.service.c)a.this.NN()).getContext()));
      paramf.cp(u.bDe());
      bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.b.lrq.aLT()).booleanValue();
      paramf.cLU.a(com.tencent.magicbrush.g.cLI[7], Boolean.valueOf(bool1));
      bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.s.lrT.aLT()).booleanValue();
      String str1;
      label194:
      String str2;
      label202:
      String str3;
      if ((a.bCW()) && (((Boolean)t.lrU.aLT()).booleanValue()))
      {
        paramf.b(a.b.cOC);
        boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.f.lrC.aLT()).booleanValue();
        bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.lrQ.aLT()).booleanValue();
        boolean bool3 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.q.lrR.aLT()).booleanValue();
        if (!bool2) {
          break label399;
        }
        str1 = "yes";
        if (!bool1) {
          break label407;
        }
        str2 = "yes";
        if (!bool3) {
          break label415;
        }
        str3 = "yes";
        label211:
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
        if ((!bool2) || (!bool1)) {
          break label423;
        }
        bool1 = true;
        label247:
        paramf.cw(bool1);
        if ((!bool2) || (!bool3)) {
          break label428;
        }
      }
      label399:
      label407:
      label415:
      label423:
      label428:
      for (bool1 = true;; bool1 = false)
      {
        paramf.cv(bool1);
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use animation handler: %s", new Object[] { paramf.Rq().toString() });
        paramf.cs(((Boolean)com.tencent.mm.plugin.appbrand.game.a.c.lrr.aLT()).booleanValue());
        paramf.ct(((Boolean)m.lrN.aLT()).booleanValue());
        paramf.cu(((Boolean)com.tencent.mm.plugin.appbrand.game.a.k.lrL.aLT()).booleanValue());
        paramf.cx(((Boolean)com.tencent.mm.plugin.appbrand.game.a.d.lrs.aLT()).booleanValue());
        AppMethodBeat.o(45051);
        return;
        if (!bool1)
        {
          paramf.b(a.b.cOA);
          break;
        }
        if (a.bCW())
        {
          paramf.b(a.b.cOz);
          break;
        }
        paramf.b(a.b.cOy);
        break;
        str1 = "no";
        break label194;
        str2 = "no";
        break label202;
        str3 = "no";
        break label211;
        bool1 = false;
        break label247;
      }
    }
    
    public final void a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(45053);
      super.a(paramAppBrandRuntime);
      com.tencent.mm.plugin.appbrand.game.c.a.lsc.a(getMagicBrush(), paramAppBrandRuntime);
      a.c(a.this);
      AppMethodBeat.o(45053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a
 * JD-Core Version:    0.7.0.1
 */