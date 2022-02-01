package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import com.tencent.magicbrush.f.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.debugger.u;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.plugin.appbrand.game.a.k;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.jsruntime.p;
import com.tencent.mm.plugin.appbrand.jsruntime.p.a;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.b.1;
import com.tencent.mm.plugin.appbrand.report.b.2;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.game.d.a.a.a<com.tencent.mm.plugin.appbrand.service.c>
  implements b
{
  private com.tencent.mm.plugin.appbrand.r.a jpJ;
  private com.tencent.mm.plugin.appbrand.report.b jpK;
  private boolean jpL;
  private long jpM;
  
  public a(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(45054);
    this.jpJ = null;
    this.jpL = false;
    this.jpM = -1L;
    this.jpK = new com.tencent.mm.plugin.appbrand.report.b();
    AppMethodBeat.o(45054);
  }
  
  private static boolean aWw()
  {
    AppMethodBeat.i(45057);
    boolean bool1 = ((Boolean)k.jqo.ajp()).booleanValue();
    boolean bool2 = ((Boolean)l.jqp.ajp()).booleanValue();
    ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: isUseNodeFromConfig: %b, isUseSurfaceFromConfig: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(45057);
      return true;
    }
    AppMethodBeat.o(45057);
    return false;
  }
  
  public final void BG()
  {
    AppMethodBeat.i(45072);
    new com.tencent.mm.plugin.appbrand.game.c.c().Bu();
    AppMethodBeat.o(45072);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i BI()
  {
    AppMethodBeat.i(45055);
    this.jpM = System.currentTimeMillis();
    com.tencent.mm.plugin.appbrand.jsruntime.i locali = super.BI();
    p localp = (p)locali.P(p.class);
    if (localp != null)
    {
      this.jpL = true;
      localp.a(new p.a()
      {
        public final void onInitialized()
        {
          AppMethodBeat.i(45048);
          com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
          if (this.jpN) {}
          for (com.tencent.mm.plugin.appbrand.task.e locale = com.tencent.mm.plugin.appbrand.task.e.lwy;; locale = null)
          {
            com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, this.val$appId, a.a(a.this), com.tencent.mm.plugin.appbrand.report.c.loW);
            AppMethodBeat.o(45048);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(45055);
    return locali;
  }
  
  public final void BJ()
  {
    AppMethodBeat.i(45061);
    super.BJ();
    if (!this.jpL)
    {
      this.jpL = true;
      com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
      if (!((com.tencent.mm.plugin.appbrand.service.c)Dj()).aNv()) {
        break label69;
      }
    }
    label69:
    for (com.tencent.mm.plugin.appbrand.task.e locale = com.tencent.mm.plugin.appbrand.task.e.lwy;; locale = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, ((com.tencent.mm.plugin.appbrand.service.c)Dj()).getAppId(), this.jpM, com.tencent.mm.plugin.appbrand.report.c.loW);
      AppMethodBeat.o(45061);
      return;
    }
  }
  
  public final void BK()
  {
    AppMethodBeat.i(45071);
    super.BK();
    com.tencent.mm.plugin.appbrand.report.b localb = this.jpK;
    localb.jth.post(new b.2(localb));
    AppMethodBeat.o(45071);
  }
  
  public final void BL()
  {
    AppMethodBeat.i(45059);
    super.BL();
    if (this.jpJ != null) {
      this.jpJ.biK();
    }
    AppMethodBeat.o(45059);
  }
  
  public final String BM()
  {
    AppMethodBeat.i(45062);
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plN, false))
    {
      String str = com.tencent.mm.plugin.appbrand.jsruntime.ac.aWU();
      AppMethodBeat.o(45062);
      return str;
    }
    AppMethodBeat.o(45062);
    return null;
  }
  
  public final boolean BN()
  {
    AppMethodBeat.i(45064);
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plM, false))
    {
      AppMethodBeat.o(45064);
      return true;
    }
    AppMethodBeat.o(45064);
    return false;
  }
  
  public final boolean BP()
  {
    AppMethodBeat.i(45065);
    if (aj.eFF() != null)
    {
      int i = aj.eFF().getInt("appbrandgame_use_commandbuffer", -1);
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
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqT, false))
    {
      AppMethodBeat.o(45065);
      return true;
    }
    AppMethodBeat.o(45065);
    return false;
  }
  
  public final boolean BQ()
  {
    AppMethodBeat.i(45066);
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqU, false))
    {
      AppMethodBeat.o(45066);
      return true;
    }
    AppMethodBeat.o(45066);
    return false;
  }
  
  public final int BR()
  {
    AppMethodBeat.i(45067);
    if (aj.eFF() != null)
    {
      i = aj.eFF().getInt("appbrandgame_cmd_pool_type", -1);
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
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqV, 1);
    AppMethodBeat.o(45067);
    return i;
  }
  
  public final boolean BS()
  {
    AppMethodBeat.i(195764);
    boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqX, false);
    AppMethodBeat.o(195764);
    return bool;
  }
  
  public final String BW()
  {
    AppMethodBeat.i(45058);
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppf, true)) {}
    for (Object localObject = "" + "var openInvokeHandlerJsBinding = true;";; localObject = "")
    {
      String str = (String)localObject + super.BW();
      localObject = str;
      if (this.jpJ != null) {
        localObject = str + this.jpJ.biL();
      }
      AppMethodBeat.o(45058);
      return localObject;
    }
  }
  
  public final int BX()
  {
    AppMethodBeat.i(45068);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pul, 0);
    AppMethodBeat.o(45068);
    return i;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> CD()
  {
    AppMethodBeat.i(45060);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandGameServiceLogicImpWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(45060);
    return localMap;
  }
  
  public final com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(195765);
    a locala = new a(((com.tencent.mm.plugin.appbrand.service.c)Dj()).getContext(), ((com.tencent.mm.plugin.appbrand.service.c)Dj()).aOf(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    AppMethodBeat.o(195765);
    return locala;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.b aWx()
  {
    return this.jpK;
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45063);
    super.c(paramAppBrandRuntime);
    ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: wc post runtime ready");
    com.tencent.mm.plugin.appbrand.report.b localb = this.jpK;
    a.3 local3 = new a.3(this, paramAppBrandRuntime);
    localb.jth.post(new b.1(localb, paramAppBrandRuntime, local3));
    AppMethodBeat.o(45063);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195766);
    super.c(paramJSONObject);
    ((com.tencent.mm.plugin.appbrand.service.c)Dj()).c(paramJSONObject, "statusBarHeight", Integer.valueOf(com.tencent.luggage.game.g.a.b((com.tencent.luggage.sdk.b.a.c.c)Dj())));
    HashMap localHashMap = new HashMap(6);
    Object localObject = com.tencent.mm.plugin.appbrand.utils.ac.g((com.tencent.mm.plugin.appbrand.jsapi.h)Dj());
    int m = localObject[0];
    int k = localObject[1];
    localObject = ((com.tencent.mm.plugin.appbrand.service.c)Dj()).iGU.getSafeAreaInsets();
    if (localObject != null)
    {
      int i = com.tencent.mm.plugin.appbrand.aa.g.uk(((Rect)localObject).left);
      int j = com.tencent.mm.plugin.appbrand.aa.g.uk(((Rect)localObject).top);
      m = com.tencent.mm.plugin.appbrand.aa.g.uk(Math.min(((Rect)localObject).right, m));
      k = com.tencent.mm.plugin.appbrand.aa.g.uk(Math.min(((Rect)localObject).bottom, k));
      localHashMap.put("left", Integer.valueOf(i));
      localHashMap.put("top", Integer.valueOf(j));
      localHashMap.put("right", Integer.valueOf(m));
      localHashMap.put("bottom", Integer.valueOf(k));
      localHashMap.put("width", Integer.valueOf(m - i));
      localHashMap.put("height", Integer.valueOf(k - j));
      ((com.tencent.mm.plugin.appbrand.service.c)Dj()).c(paramJSONObject, "safeArea", localHashMap);
    }
    AppMethodBeat.o(195766);
  }
  
  public final String cw(String paramString)
  {
    AppMethodBeat.i(45070);
    if ((((com.tencent.mm.plugin.appbrand.service.c)Dj()).getRuntime() != null) && (((com.tencent.mm.plugin.appbrand.service.c)Dj()).getRuntime().Ec())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = u.a(paramString, ((com.tencent.mm.plugin.appbrand.service.c)Dj()).getRuntime());
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
    localConfig.cOX = paramString;
    localConfig.cOY = paramArrayOfByte;
    paramString = (String)com.tencent.mm.plugin.appbrand.game.a.f.jqf.ajp();
    ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use native buffer type: %s", new Object[] { paramString });
    localConfig.cOZ = paramString;
    localConfig.cPa = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppe, true);
    localConfig.cPc = ((Boolean)j.jqn.ajp()).booleanValue();
    boolean bool;
    if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.i.jqm.ajp()).booleanValue())
    {
      bool = true;
      localConfig.cPd = bool;
      localConfig.cPe = new WeakReference(Dj());
      bool = aWw();
      ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: should use node: %b, config is %s", new Object[] { Boolean.valueOf(bool), localConfig.toString() });
      if (!bool) {
        break label283;
      }
    }
    label283:
    for (paramString = new x(localConfig);; paramString = new com.tencent.mm.plugin.appbrand.jsruntime.b(localConfig))
    {
      if ((paramString instanceof x))
      {
        this.jpJ = new com.tencent.mm.plugin.appbrand.r.a();
        this.jpJ.a((com.tencent.mm.plugin.appbrand.q)Dj(), paramString);
      }
      paramArrayOfByte = (com.tencent.mm.plugin.appbrand.jsruntime.q)paramString.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (paramArrayOfByte != null)
      {
        bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.h.Hr("tracejstask").ajp()).booleanValue();
        ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: Trace Task Name in JSThread: ".concat(String.valueOf(bool)));
        paramArrayOfByte.cg(bool);
      }
      AppMethodBeat.o(45056);
      return paramString;
      bool = false;
      break;
    }
  }
  
  public final void gG(int paramInt)
  {
    AppMethodBeat.i(45069);
    super.gG(paramInt);
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.a.ME(((com.tencent.mm.plugin.appbrand.service.c)Dj()).getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 1)
    {
      ((QualitySessionRuntime)localObject).ltM.ltY = l.a.lua;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 2)
    {
      ((QualitySessionRuntime)localObject).ltM.ltY = l.a.lub;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 3)
    {
      ((QualitySessionRuntime)localObject).ltM.ltY = l.a.luc;
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
      com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
      com.tencent.mm.plugin.appbrand.report.quality.b.a(((com.tencent.mm.plugin.appbrand.service.c)a.this.Dj()).aNv(), ((com.tencent.mm.plugin.appbrand.service.c)a.this.Dj()).getAppId(), paramLong);
      AppMethodBeat.o(45052);
    }
    
    public final void a(com.tencent.magicbrush.e parame)
    {
      AppMethodBeat.i(45051);
      super.a(parame);
      boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poe, false);
      parame.cpy.a(com.tencent.magicbrush.f.$$delegatedProperties[6], Boolean.valueOf(bool));
      parame.Y(com.tencent.mm.plugin.appbrand.game.a.d.jqa.df(((com.tencent.mm.plugin.appbrand.service.c)a.this.Dj()).getContext()));
      parame.bO(com.tencent.mm.plugin.appbrand.game.a.m.aWF());
      bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.b.jpT.ajp()).booleanValue();
      parame.cpz.a(com.tencent.magicbrush.f.$$delegatedProperties[7], Boolean.valueOf(bool));
      if (!((Boolean)l.jqp.ajp()).booleanValue()) {
        parame.b(a.b.crQ);
      }
      for (;;)
      {
        bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.c.jpU.ajp()).booleanValue();
        parame.cpN.a(com.tencent.magicbrush.f.$$delegatedProperties[19], Boolean.valueOf(bool));
        parame.bQ(((Boolean)com.tencent.mm.plugin.appbrand.game.a.g.jqg.ajp()).booleanValue());
        parame.bR(((Boolean)com.tencent.mm.plugin.appbrand.game.a.i.jqm.ajp()).booleanValue());
        AppMethodBeat.o(45051);
        return;
        if (a.aWy()) {
          parame.b(a.b.crP);
        } else {
          parame.b(a.b.crO);
        }
      }
    }
    
    public final void a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(45053);
      super.a(paramAppBrandRuntime);
      com.tencent.mm.plugin.appbrand.game.c.a.jqx.a(getMagicBrush(), paramAppBrandRuntime);
      a.c(a.this);
      AppMethodBeat.o(45053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a
 * JD-Core Version:    0.7.0.1
 */