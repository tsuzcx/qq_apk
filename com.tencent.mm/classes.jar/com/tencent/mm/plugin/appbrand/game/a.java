package com.tencent.mm.plugin.appbrand.game;

import android.content.SharedPreferences;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsruntime.ac;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.b.1;
import com.tencent.mm.plugin.appbrand.report.b.2;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.expt.b.b.a;
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
  private com.tencent.mm.plugin.appbrand.q.a kkk;
  private com.tencent.mm.plugin.appbrand.report.b kkl;
  private boolean kkm;
  private long kkn;
  
  public a(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(45054);
    this.kkk = null;
    this.kkm = false;
    this.kkn = -1L;
    this.kkl = new com.tencent.mm.plugin.appbrand.report.b();
    AppMethodBeat.o(45054);
  }
  
  private static boolean bgY()
  {
    AppMethodBeat.i(45057);
    boolean bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.kkU.ate()).booleanValue();
    boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.q.kkV.ate()).booleanValue();
    ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: isUseNodeFromConfig: %b, isUseSurfaceFromConfig: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(45057);
      return true;
    }
    AppMethodBeat.o(45057);
    return false;
  }
  
  public final void CJ()
  {
    AppMethodBeat.i(45072);
    new com.tencent.mm.plugin.appbrand.game.c.c().Cx();
    AppMethodBeat.o(45072);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i CL()
  {
    AppMethodBeat.i(45055);
    this.kkn = System.currentTimeMillis();
    com.tencent.mm.plugin.appbrand.jsruntime.i locali = super.CL();
    com.tencent.mm.plugin.appbrand.jsruntime.p localp = (com.tencent.mm.plugin.appbrand.jsruntime.p)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.p.class);
    if (localp != null)
    {
      this.kkm = true;
      localp.a(new a.1(this, ((com.tencent.mm.plugin.appbrand.service.c)El()).aXu(), ((com.tencent.mm.plugin.appbrand.service.c)El()).getAppId()));
    }
    AppMethodBeat.o(45055);
    return locali;
  }
  
  public final void CM()
  {
    AppMethodBeat.i(45061);
    super.CM();
    if (!this.kkm)
    {
      this.kkm = true;
      com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
      if (!((com.tencent.mm.plugin.appbrand.service.c)El()).aXu()) {
        break label69;
      }
    }
    label69:
    for (e locale = e.myh;; locale = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, ((com.tencent.mm.plugin.appbrand.service.c)El()).getAppId(), this.kkn, d.mqM);
      AppMethodBeat.o(45061);
      return;
    }
  }
  
  public final void CN()
  {
    AppMethodBeat.i(45071);
    super.CN();
    com.tencent.mm.plugin.appbrand.report.b localb = this.kkl;
    localb.knP.post(new b.2(localb));
    AppMethodBeat.o(45071);
  }
  
  public final void CO()
  {
    AppMethodBeat.i(45059);
    super.CO();
    if (this.kkk != null) {
      this.kkk.btE();
    }
    AppMethodBeat.o(45059);
  }
  
  public final String CP()
  {
    AppMethodBeat.i(45062);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qti, false))
    {
      String str = ac.bhw();
      AppMethodBeat.o(45062);
      return str;
    }
    AppMethodBeat.o(45062);
    return null;
  }
  
  public final boolean CQ()
  {
    AppMethodBeat.i(45064);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qth, false))
    {
      AppMethodBeat.o(45064);
      return true;
    }
    AppMethodBeat.o(45064);
    return false;
  }
  
  public final boolean CS()
  {
    AppMethodBeat.i(45065);
    if (aj.fkE() != null)
    {
      int i = aj.fkE().getInt("appbrandgame_use_commandbuffer", -1);
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
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzm, false))
    {
      AppMethodBeat.o(45065);
      return true;
    }
    AppMethodBeat.o(45065);
    return false;
  }
  
  public final boolean CT()
  {
    AppMethodBeat.i(45066);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzn, false))
    {
      AppMethodBeat.o(45066);
      return true;
    }
    AppMethodBeat.o(45066);
    return false;
  }
  
  public final int CU()
  {
    AppMethodBeat.i(45067);
    if (aj.fkE() != null)
    {
      i = aj.fkE().getInt("appbrandgame_cmd_pool_type", -1);
      if (i != -1)
      {
        AppMethodBeat.o(45067);
        return i;
      }
    }
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG))
    {
      AppMethodBeat.o(45067);
      return 1;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzo, 1);
    AppMethodBeat.o(45067);
    return i;
  }
  
  public final boolean CV()
  {
    AppMethodBeat.i(188215);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzq, false);
    AppMethodBeat.o(188215);
    return bool;
  }
  
  public final String CZ()
  {
    AppMethodBeat.i(45058);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxu, true)) {}
    for (Object localObject = "" + "var openInvokeHandlerJsBinding = true;";; localObject = "")
    {
      String str = (String)localObject + super.CZ();
      localObject = str;
      if (this.kkk != null) {
        localObject = str + this.kkk.btF();
      }
      AppMethodBeat.o(45058);
      return localObject;
    }
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DG()
  {
    AppMethodBeat.i(45060);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandGameServiceLogicImpWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(45060);
    return localMap;
  }
  
  public final int Da()
  {
    AppMethodBeat.i(45068);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDK, 0);
    AppMethodBeat.o(45068);
    return i;
  }
  
  public final com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(188216);
    a.a locala = new a.a(this, ((com.tencent.mm.plugin.appbrand.service.c)El()).getContext(), ((com.tencent.mm.plugin.appbrand.service.c)El()).aYh(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    AppMethodBeat.o(188216);
    return locala;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.b bgZ()
  {
    return this.kkl;
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45063);
    super.c(paramAppBrandRuntime);
    ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: wc post runtime ready");
    com.tencent.mm.plugin.appbrand.report.b localb = this.kkl;
    a.3 local3 = new a.3(this, paramAppBrandRuntime);
    localb.knP.post(new b.1(localb, paramAppBrandRuntime, local3));
    AppMethodBeat.o(45063);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(188217);
    super.c(paramJSONObject);
    ((com.tencent.mm.plugin.appbrand.service.c)El()).c(paramJSONObject, "statusBarHeight", Integer.valueOf(com.tencent.luggage.game.g.a.b((com.tencent.luggage.sdk.b.a.c.c)El())));
    HashMap localHashMap = new HashMap(6);
    Object localObject = af.f((h)El());
    int m = localObject[0];
    int k = localObject[1];
    localObject = ((com.tencent.mm.plugin.appbrand.service.c)El()).jzX.getSafeAreaInsets();
    if (localObject != null)
    {
      int i = com.tencent.mm.plugin.appbrand.z.g.vH(((Rect)localObject).left);
      int j = com.tencent.mm.plugin.appbrand.z.g.vH(((Rect)localObject).top);
      m = com.tencent.mm.plugin.appbrand.z.g.vH(Math.min(((Rect)localObject).right, m));
      k = com.tencent.mm.plugin.appbrand.z.g.vH(Math.min(((Rect)localObject).bottom, k));
      localHashMap.put("left", Integer.valueOf(i));
      localHashMap.put("top", Integer.valueOf(j));
      localHashMap.put("right", Integer.valueOf(m));
      localHashMap.put("bottom", Integer.valueOf(k));
      localHashMap.put("width", Integer.valueOf(m - i));
      localHashMap.put("height", Integer.valueOf(k - j));
      ((com.tencent.mm.plugin.appbrand.service.c)El()).c(paramJSONObject, "safeArea", localHashMap);
    }
    AppMethodBeat.o(188217);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(45056);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.cXH = paramString;
    localConfig.cXI = paramArrayOfByte;
    paramString = (String)com.tencent.mm.plugin.appbrand.game.a.g.kkH.ate();
    ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use native buffer type: %s", new Object[] { paramString });
    localConfig.cXJ = paramString;
    localConfig.cXK = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxt, true);
    localConfig.cXM = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.m.kkR.ate()).booleanValue();
    boolean bool;
    if (!((Boolean)l.kkQ.ate()).booleanValue())
    {
      bool = true;
      localConfig.cXN = bool;
      localConfig.cXP = new WeakReference(El());
      bool = bgY();
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
        this.kkk = new com.tencent.mm.plugin.appbrand.q.a();
        this.kkk.a((com.tencent.mm.plugin.appbrand.q)El(), paramString);
      }
      paramArrayOfByte = (com.tencent.mm.plugin.appbrand.jsruntime.q)paramString.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (paramArrayOfByte != null)
      {
        bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.i.OP("tracejstask").ate()).booleanValue();
        ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: Trace Task Name in JSThread: ".concat(String.valueOf(bool)));
        paramArrayOfByte.cj(bool);
      }
      AppMethodBeat.o(45056);
      return paramString;
      bool = false;
      break;
    }
  }
  
  public final String dn(String paramString)
  {
    AppMethodBeat.i(45070);
    if ((((com.tencent.mm.plugin.appbrand.service.c)El()).getRuntime() != null) && (((com.tencent.mm.plugin.appbrand.service.c)El()).getRuntime().Fe())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = v.a(paramString, ((com.tencent.mm.plugin.appbrand.service.c)El()).getRuntime());
      AppMethodBeat.o(45070);
      return paramString;
    }
    AppMethodBeat.o(45070);
    return "";
  }
  
  public final void gt(int paramInt)
  {
    AppMethodBeat.i(45069);
    super.gt(paramInt);
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.a.Ut(((com.tencent.mm.plugin.appbrand.service.c)El()).getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 1)
    {
      ((QualitySessionRuntime)localObject).mvw.mvH = l.a.mvJ;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 2)
    {
      ((QualitySessionRuntime)localObject).mvw.mvH = l.a.mvK;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 3)
    {
      ((QualitySessionRuntime)localObject).mvw.mvH = l.a.mvL;
      AppMethodBeat.o(45069);
      return;
    }
    localObject = new RuntimeException("MainCanvasType invalid type == ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(45069);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a
 * JD-Core Version:    0.7.0.1
 */