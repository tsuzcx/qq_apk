package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.f.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.u;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.plugin.appbrand.game.a.k;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.game.a.n;
import com.tencent.mm.plugin.appbrand.jsruntime.p.a;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.b.1;
import com.tencent.mm.plugin.appbrand.report.b.2;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.game.d.a.a.a<com.tencent.mm.plugin.appbrand.service.c>
  implements b
{
  private com.tencent.mm.plugin.appbrand.q.a jPY;
  private com.tencent.mm.plugin.appbrand.report.b jPZ;
  private boolean jQa;
  private long jQb;
  
  public a(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(45054);
    this.jPY = null;
    this.jQa = false;
    this.jQb = -1L;
    this.jPZ = new com.tencent.mm.plugin.appbrand.report.b();
    AppMethodBeat.o(45054);
  }
  
  private static boolean bdu()
  {
    AppMethodBeat.i(45057);
    boolean bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.m.jQF.aqp()).booleanValue();
    boolean bool2 = ((Boolean)n.jQG.aqp()).booleanValue();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: isUseNodeFromConfig: %b, isUseSurfaceFromConfig: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(45057);
      return true;
    }
    AppMethodBeat.o(45057);
    return false;
  }
  
  public final String BA()
  {
    AppMethodBeat.i(45058);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSQ, true)) {}
    for (Object localObject = "" + "var openInvokeHandlerJsBinding = true;";; localObject = "")
    {
      String str = (String)localObject + super.BA();
      localObject = str;
      if (this.jPY != null) {
        localObject = str + this.jPY.bpE();
      }
      AppMethodBeat.o(45058);
      return localObject;
    }
  }
  
  public final int BB()
  {
    AppMethodBeat.i(45068);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pYz, 0);
    AppMethodBeat.o(45068);
    return i;
  }
  
  public final void Bk()
  {
    AppMethodBeat.i(45072);
    new com.tencent.mm.plugin.appbrand.game.c.c().AY();
    AppMethodBeat.o(45072);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i Bm()
  {
    AppMethodBeat.i(45055);
    this.jQb = System.currentTimeMillis();
    com.tencent.mm.plugin.appbrand.jsruntime.i locali = super.Bm();
    com.tencent.mm.plugin.appbrand.jsruntime.p localp = (com.tencent.mm.plugin.appbrand.jsruntime.p)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.p.class);
    if (localp != null)
    {
      this.jQa = true;
      localp.a(new p.a()
      {
        public final void onInitialized()
        {
          AppMethodBeat.i(45048);
          com.tencent.mm.plugin.appbrand.report.quality.a.btI();
          if (this.jQc) {}
          for (com.tencent.mm.plugin.appbrand.task.e locale = com.tencent.mm.plugin.appbrand.task.e.lYs;; locale = null)
          {
            com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, this.val$appId, a.a(a.this), com.tencent.mm.plugin.appbrand.report.c.lQW);
            AppMethodBeat.o(45048);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(45055);
    return locali;
  }
  
  public final void Bn()
  {
    AppMethodBeat.i(45061);
    super.Bn();
    if (!this.jQa)
    {
      this.jQa = true;
      com.tencent.mm.plugin.appbrand.report.quality.a.btI();
      if (!((com.tencent.mm.plugin.appbrand.service.c)CM()).aUl()) {
        break label69;
      }
    }
    label69:
    for (com.tencent.mm.plugin.appbrand.task.e locale = com.tencent.mm.plugin.appbrand.task.e.lYs;; locale = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, ((com.tencent.mm.plugin.appbrand.service.c)CM()).getAppId(), this.jQb, com.tencent.mm.plugin.appbrand.report.c.lQW);
      AppMethodBeat.o(45061);
      return;
    }
  }
  
  public final void Bo()
  {
    AppMethodBeat.i(45071);
    super.Bo();
    com.tencent.mm.plugin.appbrand.report.b localb = this.jPZ;
    localb.jTB.post(new b.2(localb));
    AppMethodBeat.o(45071);
  }
  
  public final void Bp()
  {
    AppMethodBeat.i(45059);
    super.Bp();
    if (this.jPY != null) {
      this.jPY.bpD();
    }
    AppMethodBeat.o(45059);
  }
  
  public final String Bq()
  {
    AppMethodBeat.i(45062);
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPj, false))
    {
      String str = com.tencent.mm.plugin.appbrand.jsruntime.ac.bdS();
      AppMethodBeat.o(45062);
      return str;
    }
    AppMethodBeat.o(45062);
    return null;
  }
  
  public final boolean Br()
  {
    AppMethodBeat.i(45064);
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPi, false))
    {
      AppMethodBeat.o(45064);
      return true;
    }
    AppMethodBeat.o(45064);
    return false;
  }
  
  public final boolean Bt()
  {
    AppMethodBeat.i(45065);
    if (ai.eUZ() != null)
    {
      int i = ai.eUZ().getInt("appbrandgame_use_commandbuffer", -1);
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
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUG, false))
    {
      AppMethodBeat.o(45065);
      return true;
    }
    AppMethodBeat.o(45065);
    return false;
  }
  
  public final boolean Bu()
  {
    AppMethodBeat.i(45066);
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUH, false))
    {
      AppMethodBeat.o(45066);
      return true;
    }
    AppMethodBeat.o(45066);
    return false;
  }
  
  public final int Bv()
  {
    AppMethodBeat.i(45067);
    if (ai.eUZ() != null)
    {
      i = ai.eUZ().getInt("appbrandgame_cmd_pool_type", -1);
      if (i != -1)
      {
        AppMethodBeat.o(45067);
        return i;
      }
    }
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG))
    {
      AppMethodBeat.o(45067);
      return 1;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUI, 1);
    AppMethodBeat.o(45067);
    return i;
  }
  
  public final boolean Bw()
  {
    AppMethodBeat.i(186516);
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUK, false);
    AppMethodBeat.o(186516);
    return bool;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> Ch()
  {
    AppMethodBeat.i(45060);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandGameServiceLogicImpWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(45060);
    return localMap;
  }
  
  public final com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(186517);
    a locala = new a(((com.tencent.mm.plugin.appbrand.service.c)CM()).getContext(), ((com.tencent.mm.plugin.appbrand.service.c)CM()).aUV(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    AppMethodBeat.o(186517);
    return locala;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.b bdv()
  {
    return this.jPZ;
  }
  
  public final void c(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45063);
    super.c(paramAppBrandRuntime);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: wc post runtime ready");
    com.tencent.mm.plugin.appbrand.report.b localb = this.jPZ;
    com.tencent.mm.plugin.appbrand.report.b.a local3 = new com.tencent.mm.plugin.appbrand.report.b.a()
    {
      public final void dJ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(45050);
        if (paramAppBrandRuntime == null)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: can not get runtime!");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAppBrandRuntime.isDestroyed()) || (paramAppBrandRuntime.QM))
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: runtime finished. abort");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Object localObject = paramAppBrandRuntime.mAppId;
          com.tencent.mm.plugin.appbrand.report.b localb = a.b(a.this);
          paramAppBrandRuntime.DI();
          com.tencent.mm.plugin.appbrand.report.quality.a.a((String)localObject, localb);
          localObject = ((com.tencent.mm.plugin.appbrand.service.c)a.this.CM()).aTP();
          if (localObject == null)
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: no game renderer!");
            AppMethodBeat.o(45050);
            return;
          }
          localObject = (com.tencent.mm.plugin.appbrand.game.f.a)((aa)localObject).Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if (localObject != null) {
            ((com.tencent.mm.plugin.appbrand.game.f.a)localObject).a(a.b(a.this));
          }
          for (;;)
          {
            localObject = a.b(a.this).lQB;
            if ((localObject == null) || (((eaz)localObject).GgD == 0) || (((eaz)localObject).GgF == 0) || (((eaz)localObject).GgG == 0) || (((eaz)localObject).GgH == 0) || (((eaz)localObject).GgE == 0)) {
              break;
            }
            a.this.bZJ.getMagicBrush().cbj.a(((eaz)localObject).GgF, ((eaz)localObject).GgG, ((eaz)localObject).GgH, ((eaz)localObject).GgE, false);
            AppMethodBeat.o(45050);
            return;
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: not game renderer!");
          }
          if (DebuggerShell.baW()) {
            a.this.bZJ.getMagicBrush().cbj.a(5, 10, 10.0F, 60, true);
          }
          AppMethodBeat.o(45050);
          return;
        }
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: get sampling failed!");
        AppMethodBeat.o(45050);
      }
    };
    localb.jTB.post(new b.1(localb, paramAppBrandRuntime, local3));
    AppMethodBeat.o(45063);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186518);
    super.c(paramJSONObject);
    ((com.tencent.mm.plugin.appbrand.service.c)CM()).c(paramJSONObject, "statusBarHeight", Integer.valueOf(com.tencent.luggage.game.g.a.b((com.tencent.luggage.sdk.b.a.c.c)CM())));
    HashMap localHashMap = new HashMap(6);
    Object localObject = ad.g((com.tencent.mm.plugin.appbrand.jsapi.h)CM());
    int m = localObject[0];
    int k = localObject[1];
    localObject = ((com.tencent.mm.plugin.appbrand.service.c)CM()).jgX.getSafeAreaInsets();
    if (localObject != null)
    {
      int i = com.tencent.mm.plugin.appbrand.z.g.vc(((Rect)localObject).left);
      int j = com.tencent.mm.plugin.appbrand.z.g.vc(((Rect)localObject).top);
      m = com.tencent.mm.plugin.appbrand.z.g.vc(Math.min(((Rect)localObject).right, m));
      k = com.tencent.mm.plugin.appbrand.z.g.vc(Math.min(((Rect)localObject).bottom, k));
      localHashMap.put("left", Integer.valueOf(i));
      localHashMap.put("top", Integer.valueOf(j));
      localHashMap.put("right", Integer.valueOf(m));
      localHashMap.put("bottom", Integer.valueOf(k));
      localHashMap.put("width", Integer.valueOf(m - i));
      localHashMap.put("height", Integer.valueOf(k - j));
      ((com.tencent.mm.plugin.appbrand.service.c)CM()).c(paramJSONObject, "safeArea", localHashMap);
    }
    AppMethodBeat.o(186518);
  }
  
  public final String cl(String paramString)
  {
    AppMethodBeat.i(45070);
    if ((((com.tencent.mm.plugin.appbrand.service.c)CM()).getRuntime() != null) && (((com.tencent.mm.plugin.appbrand.service.c)CM()).getRuntime().DF())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = u.a(paramString, ((com.tencent.mm.plugin.appbrand.service.c)CM()).getRuntime());
      AppMethodBeat.o(45070);
      return paramString;
    }
    AppMethodBeat.o(45070);
    return "";
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(45056);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.cMs = paramString;
    localConfig.cMt = paramArrayOfByte;
    paramString = (String)com.tencent.mm.plugin.appbrand.game.a.f.jQu.aqp();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use native buffer type: %s", new Object[] { paramString });
    localConfig.cMu = paramString;
    localConfig.cMv = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSP, true);
    localConfig.cMx = ((Boolean)l.jQE.aqp()).booleanValue();
    boolean bool;
    if (!((Boolean)k.jQD.aqp()).booleanValue())
    {
      bool = true;
      localConfig.cMy = bool;
      localConfig.cMz = new WeakReference(CM());
      bool = bdu();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: should use node: %b, config is %s", new Object[] { Boolean.valueOf(bool), localConfig.toString() });
      if (!bool) {
        break label283;
      }
    }
    label283:
    for (paramString = new x(localConfig);; paramString = new com.tencent.mm.plugin.appbrand.jsruntime.b(localConfig))
    {
      if ((paramString instanceof x))
      {
        this.jPY = new com.tencent.mm.plugin.appbrand.q.a();
        this.jPY.a((com.tencent.mm.plugin.appbrand.q)CM(), paramString);
      }
      paramArrayOfByte = (com.tencent.mm.plugin.appbrand.jsruntime.q)paramString.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (paramArrayOfByte != null)
      {
        bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.h.Lv("tracejstask").aqp()).booleanValue();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: Trace Task Name in JSThread: ".concat(String.valueOf(bool)));
        paramArrayOfByte.ci(bool);
      }
      AppMethodBeat.o(45056);
      return paramString;
      bool = false;
      break;
    }
  }
  
  public final void gq(int paramInt)
  {
    AppMethodBeat.i(45069);
    super.gq(paramInt);
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.a.QN(((com.tencent.mm.plugin.appbrand.service.c)CM()).getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 1)
    {
      ((QualitySessionRuntime)localObject).lVG.lVS = l.a.lVU;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 2)
    {
      ((QualitySessionRuntime)localObject).lVG.lVS = l.a.lVV;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 3)
    {
      ((QualitySessionRuntime)localObject).lVG.lVS = l.a.lVW;
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
    public a(Context paramContext, com.tencent.mm.plugin.appbrand.jsruntime.i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
    {
      super(parami, paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    }
    
    public final void a(com.tencent.magicbrush.d paramd, long paramLong)
    {
      AppMethodBeat.i(45052);
      com.tencent.mm.plugin.appbrand.report.quality.a.btI();
      com.tencent.mm.plugin.appbrand.report.quality.b.a(((com.tencent.mm.plugin.appbrand.service.c)a.this.CM()).aUl(), ((com.tencent.mm.plugin.appbrand.service.c)a.this.CM()).getAppId(), paramLong);
      AppMethodBeat.o(45052);
    }
    
    public final void a(com.tencent.magicbrush.e parame)
    {
      AppMethodBeat.i(45051);
      super.a(parame);
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pRE, false);
      parame.cmD.a(com.tencent.magicbrush.f.$$delegatedProperties[6], Boolean.valueOf(bool));
      parame.ac(com.tencent.mm.plugin.appbrand.game.a.d.jQp.jdMethod_do(((com.tencent.mm.plugin.appbrand.service.c)a.this.CM()).getContext()));
      parame.bP(com.tencent.mm.plugin.appbrand.game.a.p.bdD());
      bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.b.jQi.aqp()).booleanValue();
      parame.cmE.a(com.tencent.magicbrush.f.$$delegatedProperties[7], Boolean.valueOf(bool));
      bool = ((Boolean)n.jQG.aqp()).booleanValue();
      if ((a.bdw()) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.o.jQH.aqp()).booleanValue())) {
        parame.b(a.b.coY);
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use animation handler: %s", new Object[] { parame.FX().toString() });
        bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.c.jQj.aqp()).booleanValue();
        parame.cmS.a(com.tencent.magicbrush.f.$$delegatedProperties[19], Boolean.valueOf(bool));
        parame.bR(((Boolean)com.tencent.mm.plugin.appbrand.game.a.g.jQv.aqp()).booleanValue());
        parame.bS(((Boolean)k.jQD.aqp()).booleanValue());
        bool = ((Boolean)j.jQC.aqp()).booleanValue();
        parame.cmW.a(com.tencent.magicbrush.f.$$delegatedProperties[23], Boolean.valueOf(bool));
        bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.i.jQB.aqp()).booleanValue();
        parame.cmX.a(com.tencent.magicbrush.f.$$delegatedProperties[24], Boolean.valueOf(bool));
        AppMethodBeat.o(45051);
        return;
        if (!bool) {
          parame.b(a.b.coW);
        } else if (a.bdw()) {
          parame.b(a.b.coV);
        } else {
          parame.b(a.b.coU);
        }
      }
    }
    
    public final void a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(45053);
      super.a(paramAppBrandRuntime);
      com.tencent.mm.plugin.appbrand.game.c.a.jQP.a(getMagicBrush(), paramAppBrandRuntime);
      a.c(a.this);
      AppMethodBeat.o(45053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a
 * JD-Core Version:    0.7.0.1
 */