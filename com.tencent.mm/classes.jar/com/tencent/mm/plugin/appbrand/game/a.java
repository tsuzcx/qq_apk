package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.v;
import com.tencent.mm.plugin.appbrand.game.a.k;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.game.a.n;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.game.a.s;
import com.tencent.mm.plugin.appbrand.jsruntime.ad;
import com.tencent.mm.plugin.appbrand.jsruntime.p.a;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.report.b.1;
import com.tencent.mm.plugin.appbrand.report.b.2;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.protocal.protobuf.eiu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.game.d.a.a.a<com.tencent.mm.plugin.appbrand.service.c>
  implements b
{
  private com.tencent.mm.plugin.appbrand.q.a knA;
  private com.tencent.mm.plugin.appbrand.report.b knB;
  private boolean knC;
  private long knD;
  
  public a(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(45054);
    this.knA = null;
    this.knC = false;
    this.knD = -1L;
    this.knB = new com.tencent.mm.plugin.appbrand.report.b();
    AppMethodBeat.o(45054);
  }
  
  private static boolean bhG()
  {
    AppMethodBeat.i(45057);
    boolean bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.kok.att()).booleanValue();
    boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.q.kol.att()).booleanValue();
    ae.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: isUseNodeFromConfig: %b, isUseSurfaceFromConfig: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(45057);
      return true;
    }
    AppMethodBeat.o(45057);
    return false;
  }
  
  public final void CM()
  {
    AppMethodBeat.i(45072);
    new com.tencent.mm.plugin.appbrand.game.c.c().CA();
    AppMethodBeat.o(45072);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i CO()
  {
    AppMethodBeat.i(45055);
    this.knD = System.currentTimeMillis();
    com.tencent.mm.plugin.appbrand.jsruntime.i locali = super.CO();
    com.tencent.mm.plugin.appbrand.jsruntime.p localp = (com.tencent.mm.plugin.appbrand.jsruntime.p)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.p.class);
    if (localp != null)
    {
      this.knC = true;
      localp.a(new p.a()
      {
        public final void onInitialized()
        {
          AppMethodBeat.i(45048);
          com.tencent.mm.plugin.appbrand.report.quality.a.byG();
          if (this.knE) {}
          for (com.tencent.mm.plugin.appbrand.task.e locale = com.tencent.mm.plugin.appbrand.task.e.mDf;; locale = null)
          {
            com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, this.val$appId, a.a(a.this), com.tencent.mm.plugin.appbrand.report.d.mvK);
            AppMethodBeat.o(45048);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(45055);
    return locali;
  }
  
  public final void CP()
  {
    AppMethodBeat.i(45061);
    super.CP();
    if (!this.knC)
    {
      this.knC = true;
      com.tencent.mm.plugin.appbrand.report.quality.a.byG();
      if (!((com.tencent.mm.plugin.appbrand.service.c)Eo()).aXP()) {
        break label69;
      }
    }
    label69:
    for (com.tencent.mm.plugin.appbrand.task.e locale = com.tencent.mm.plugin.appbrand.task.e.mDf;; locale = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, ((com.tencent.mm.plugin.appbrand.service.c)Eo()).getAppId(), this.knD, com.tencent.mm.plugin.appbrand.report.d.mvK);
      AppMethodBeat.o(45061);
      return;
    }
  }
  
  public final void CQ()
  {
    AppMethodBeat.i(45071);
    super.CQ();
    com.tencent.mm.plugin.appbrand.report.b localb = this.knB;
    localb.krf.post(new b.2(localb));
    AppMethodBeat.o(45071);
  }
  
  public final void CR()
  {
    AppMethodBeat.i(45059);
    super.CR();
    if (this.knA != null) {
      this.knA.bup();
    }
    AppMethodBeat.o(45059);
  }
  
  public final String CS()
  {
    AppMethodBeat.i(45062);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzX, false))
    {
      String str = ad.bie();
      AppMethodBeat.o(45062);
      return str;
    }
    AppMethodBeat.o(45062);
    return null;
  }
  
  public final boolean CT()
  {
    AppMethodBeat.i(45064);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qzW, false))
    {
      AppMethodBeat.o(45064);
      return true;
    }
    AppMethodBeat.o(45064);
    return false;
  }
  
  public final boolean CV()
  {
    AppMethodBeat.i(45065);
    if (ak.foy() != null)
    {
      int i = ak.foy().getInt("appbrandgame_use_commandbuffer", -1);
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
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGs, false))
    {
      AppMethodBeat.o(45065);
      return true;
    }
    AppMethodBeat.o(45065);
    return false;
  }
  
  public final boolean CW()
  {
    AppMethodBeat.i(45066);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGt, false))
    {
      AppMethodBeat.o(45066);
      return true;
    }
    AppMethodBeat.o(45066);
    return false;
  }
  
  public final int CX()
  {
    AppMethodBeat.i(45067);
    if (ak.foy() != null)
    {
      i = ak.foy().getInt("appbrandgame_cmd_pool_type", -1);
      if (i != -1)
      {
        AppMethodBeat.o(45067);
        return i;
      }
    }
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.DEBUG))
    {
      AppMethodBeat.o(45067);
      return 1;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGu, 1);
    AppMethodBeat.o(45067);
    return i;
  }
  
  public final boolean CY()
  {
    AppMethodBeat.i(222341);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGw, false);
    AppMethodBeat.o(222341);
    return bool;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DJ()
  {
    AppMethodBeat.i(45060);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandGameServiceLogicImpWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(45060);
    return localMap;
  }
  
  public final String Dc()
  {
    AppMethodBeat.i(45058);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEA, true)) {}
    for (Object localObject = "" + "var openInvokeHandlerJsBinding = true;";; localObject = "")
    {
      String str = (String)localObject + super.Dc();
      localObject = str;
      if (this.knA != null) {
        localObject = str + this.knA.buq();
      }
      AppMethodBeat.o(45058);
      return localObject;
    }
  }
  
  public final int Dd()
  {
    AppMethodBeat.i(45068);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qLp, 0);
    AppMethodBeat.o(45068);
    return i;
  }
  
  public final com.tencent.luggage.game.a.d a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(222342);
    a locala = new a(((com.tencent.mm.plugin.appbrand.service.c)Eo()).getContext(), ((com.tencent.mm.plugin.appbrand.service.c)Eo()).aYB(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    AppMethodBeat.o(222342);
    return locala;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.b bhH()
  {
    return this.knB;
  }
  
  public final void c(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45063);
    super.c(paramAppBrandRuntime);
    ae.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: wc post runtime ready");
    com.tencent.mm.plugin.appbrand.report.b localb = this.knB;
    com.tencent.mm.plugin.appbrand.report.b.a local3 = new com.tencent.mm.plugin.appbrand.report.b.a()
    {
      public final void dL(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(45050);
        if (paramAppBrandRuntime == null)
        {
          ae.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: can not get runtime!");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAppBrandRuntime.isDestroyed()) || (paramAppBrandRuntime.SB))
        {
          ae.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: runtime finished. abort");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Object localObject = paramAppBrandRuntime.mAppId;
          com.tencent.mm.plugin.appbrand.report.b localb = a.b(a.this);
          paramAppBrandRuntime.Fm();
          com.tencent.mm.plugin.appbrand.report.quality.a.a((String)localObject, localb);
          localObject = ((com.tencent.mm.plugin.appbrand.service.c)a.this.Eo()).aXu();
          if (localObject == null)
          {
            ae.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: no game renderer!");
            AppMethodBeat.o(45050);
            return;
          }
          localObject = (com.tencent.mm.plugin.appbrand.game.f.a)((z)localObject).Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
          if (localObject != null) {
            ((com.tencent.mm.plugin.appbrand.game.f.a)localObject).a(a.b(a.this));
          }
          for (;;)
          {
            localObject = a.b(a.this).mvp;
            if ((localObject == null) || (((eiu)localObject).IlX == 0) || (((eiu)localObject).IlZ == 0) || (((eiu)localObject).Ima == 0) || (((eiu)localObject).Imb == 0) || (((eiu)localObject).IlY == 0)) {
              break;
            }
            a.this.ckd.getMagicBrush().clC.a(((eiu)localObject).IlZ, ((eiu)localObject).Ima, ((eiu)localObject).Imb, ((eiu)localObject).IlY, false);
            AppMethodBeat.o(45050);
            return;
            ae.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: not game renderer!");
          }
          if (DebuggerShell.bfe()) {
            a.this.ckd.getMagicBrush().clC.a(5, 10, 10.0F, 60, true);
          }
          AppMethodBeat.o(45050);
          return;
        }
        ae.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: get sampling failed!");
        AppMethodBeat.o(45050);
      }
    };
    localb.krf.post(new b.1(localb, paramAppBrandRuntime, local3));
    AppMethodBeat.o(45063);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222343);
    super.c(paramJSONObject);
    ((com.tencent.mm.plugin.appbrand.service.c)Eo()).c(paramJSONObject, "statusBarHeight", Integer.valueOf(com.tencent.luggage.game.g.a.b((com.tencent.luggage.sdk.b.a.c.c)Eo())));
    HashMap localHashMap = new HashMap(6);
    Object localObject = ai.f((com.tencent.mm.plugin.appbrand.jsapi.h)Eo());
    int m = localObject[0];
    int k = localObject[1];
    localObject = ((com.tencent.mm.plugin.appbrand.service.c)Eo()).jDa.getSafeAreaInsets();
    if (localObject != null)
    {
      int i = com.tencent.mm.plugin.appbrand.y.g.vM(((Rect)localObject).left);
      int j = com.tencent.mm.plugin.appbrand.y.g.vM(((Rect)localObject).top);
      m = com.tencent.mm.plugin.appbrand.y.g.vM(Math.min(((Rect)localObject).right, m));
      k = com.tencent.mm.plugin.appbrand.y.g.vM(Math.min(((Rect)localObject).bottom, k));
      localHashMap.put("left", Integer.valueOf(i));
      localHashMap.put("top", Integer.valueOf(j));
      localHashMap.put("right", Integer.valueOf(m));
      localHashMap.put("bottom", Integer.valueOf(k));
      localHashMap.put("width", Integer.valueOf(m - i));
      localHashMap.put("height", Integer.valueOf(k - j));
      ((com.tencent.mm.plugin.appbrand.service.c)Eo()).c(paramJSONObject, "safeArea", localHashMap);
    }
    AppMethodBeat.o(222343);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i d(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(45056);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.cYF = paramString;
    localConfig.cYG = paramArrayOfByte;
    paramString = (String)com.tencent.mm.plugin.appbrand.game.a.g.knX.att();
    ae.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use native buffer type: %s", new Object[] { paramString });
    localConfig.cYH = paramString;
    localConfig.cYI = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qEz, true);
    localConfig.cYK = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.m.koh.att()).booleanValue();
    boolean bool;
    if (!((Boolean)l.kog.att()).booleanValue())
    {
      bool = true;
      localConfig.cYL = bool;
      localConfig.cYN = new WeakReference(Eo());
      bool = bhG();
      ae.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: should use node: %b, config is %s", new Object[] { Boolean.valueOf(bool), localConfig.toString() });
      if (!bool) {
        break label283;
      }
    }
    label283:
    for (paramString = new x(localConfig);; paramString = new com.tencent.mm.plugin.appbrand.jsruntime.b(localConfig))
    {
      if ((paramString instanceof x))
      {
        this.knA = new com.tencent.mm.plugin.appbrand.q.a();
        this.knA.a((com.tencent.mm.plugin.appbrand.r)Eo(), paramString);
      }
      paramArrayOfByte = (com.tencent.mm.plugin.appbrand.jsruntime.q)paramString.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (paramArrayOfByte != null)
      {
        bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.i.Px("tracejstask").att()).booleanValue();
        ae.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: Trace Task Name in JSThread: ".concat(String.valueOf(bool)));
        paramArrayOfByte.cj(bool);
      }
      AppMethodBeat.o(45056);
      return paramString;
      bool = false;
      break;
    }
  }
  
  public final String dp(String paramString)
  {
    AppMethodBeat.i(45070);
    if ((((com.tencent.mm.plugin.appbrand.service.c)Eo()).getRuntime() != null) && (((com.tencent.mm.plugin.appbrand.service.c)Eo()).getRuntime().Fj())) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = v.a(paramString, ((com.tencent.mm.plugin.appbrand.service.c)Eo()).getRuntime());
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
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.a.Ve(((com.tencent.mm.plugin.appbrand.service.c)Eo()).getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 1)
    {
      ((QualitySessionRuntime)localObject).mAt.mAE = l.a.mAG;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 2)
    {
      ((QualitySessionRuntime)localObject).mAt.mAE = l.a.mAH;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 3)
    {
      ((QualitySessionRuntime)localObject).mAt.mAE = l.a.mAI;
      AppMethodBeat.o(45069);
      return;
    }
    localObject = new RuntimeException("MainCanvasType invalid type == ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(45069);
    throw ((Throwable)localObject);
  }
  
  final class a
    extends com.tencent.luggage.game.a.d
  {
    public a(Context paramContext, com.tencent.mm.plugin.appbrand.jsruntime.i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
    {
      super(parami, paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    }
    
    public final void a(com.tencent.magicbrush.d paramd, long paramLong)
    {
      AppMethodBeat.i(45052);
      com.tencent.mm.plugin.appbrand.report.quality.a.byG();
      com.tencent.mm.plugin.appbrand.report.quality.b.a(((com.tencent.mm.plugin.appbrand.service.c)a.this.Eo()).aXP(), ((com.tencent.mm.plugin.appbrand.service.c)a.this.Eo()).getAppId(), paramLong);
      AppMethodBeat.o(45052);
    }
    
    public final void a(com.tencent.magicbrush.e parame)
    {
      AppMethodBeat.i(45051);
      super.a(parame);
      boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDa, false);
      parame.cxL.a(f.cxA[6], Boolean.valueOf(bool1));
      parame.ae(com.tencent.mm.plugin.appbrand.game.a.d.knR.jdMethod_do(((com.tencent.mm.plugin.appbrand.service.c)a.this.Eo()).getContext()));
      parame.bP(s.bhP());
      bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.b.knK.att()).booleanValue();
      parame.cxM.a(f.cxA[7], Boolean.valueOf(bool1));
      bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.q.kol.att()).booleanValue();
      String str1;
      label194:
      String str2;
      label202:
      String str3;
      if ((a.bhI()) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.r.kom.att()).booleanValue()))
      {
        parame.b(a.b.cAw);
        boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.e.knV.att()).booleanValue();
        bool1 = ((Boolean)n.koi.att()).booleanValue();
        boolean bool3 = ((Boolean)o.koj.att()).booleanValue();
        if (!bool2) {
          break label457;
        }
        str1 = "yes";
        if (!bool1) {
          break label465;
        }
        str2 = "yes";
        if (!bool3) {
          break label473;
        }
        str3 = "yes";
        label211:
        ae.i("MicroMsg.AppBrandGameServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
        if ((!bool2) || (!bool1)) {
          break label481;
        }
        bool1 = true;
        label247:
        parame.bU(bool1);
        if ((!bool2) || (!bool3)) {
          break label486;
        }
      }
      label457:
      label465:
      label473:
      label481:
      label486:
      for (bool1 = true;; bool1 = false)
      {
        parame.bT(bool1);
        ae.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use animation handler: %s", new Object[] { parame.Hy().toString() });
        bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.c.knL.att()).booleanValue();
        parame.cya.a(f.cxA[19], Boolean.valueOf(bool1));
        parame.bR(((Boolean)com.tencent.mm.plugin.appbrand.game.a.h.knY.att()).booleanValue());
        parame.bS(((Boolean)l.kog.att()).booleanValue());
        bool1 = ((Boolean)k.kof.att()).booleanValue();
        parame.cye.a(f.cxA[23], Boolean.valueOf(bool1));
        bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.j.koe.att()).booleanValue();
        parame.cyf.a(f.cxA[24], Boolean.valueOf(bool1));
        AppMethodBeat.o(45051);
        return;
        if (!bool1)
        {
          parame.b(a.b.cAu);
          break;
        }
        if (a.bhI())
        {
          parame.b(a.b.cAt);
          break;
        }
        parame.b(a.b.cAs);
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
      com.tencent.mm.plugin.appbrand.game.c.a.kou.a(getMagicBrush(), paramAppBrandRuntime);
      a.c(a.this);
      AppMethodBeat.o(45053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a
 * JD-Core Version:    0.7.0.1
 */