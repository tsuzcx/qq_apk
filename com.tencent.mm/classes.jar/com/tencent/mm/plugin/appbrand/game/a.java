package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.s;
import com.tencent.mm.plugin.appbrand.game.a.t;
import com.tencent.mm.plugin.appbrand.game.a.u;
import com.tencent.mm.plugin.appbrand.game.a.v;
import com.tencent.mm.plugin.appbrand.n.af;
import com.tencent.mm.plugin.appbrand.n.p.a;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.page.cf;
import com.tencent.mm.plugin.appbrand.report.b.1;
import com.tencent.mm.plugin.appbrand.report.b.2;
import com.tencent.mm.plugin.appbrand.report.b.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.l.a;
import com.tencent.mm.plugin.appbrand.utils.aq;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.glk;
import com.tencent.mm.protocal.protobuf.gln;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.game.d.a.a.a<com.tencent.mm.plugin.appbrand.service.c>
  implements b
{
  private com.tencent.mm.plugin.appbrand.v.a rpB;
  private com.tencent.mm.plugin.appbrand.report.b rpC;
  private com.tencent.luggage.game.b.b rpD;
  private boolean rpE;
  private long rpF;
  
  public a(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(45054);
    this.rpB = null;
    this.rpE = false;
    this.rpF = -1L;
    this.rpC = new com.tencent.mm.plugin.appbrand.report.b();
    AppMethodBeat.o(45054);
  }
  
  private static boolean coE()
  {
    AppMethodBeat.i(45057);
    boolean bool1 = ((Boolean)u.rqz.boF()).booleanValue();
    boolean bool2 = ((Boolean)v.rqA.boF()).booleanValue();
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: isUseNodeFromConfig: %b, isUseSurfaceFromConfig: %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if ((bool1) && (!bool2))
    {
      AppMethodBeat.o(45057);
      return true;
    }
    AppMethodBeat.o(45057);
    return false;
  }
  
  public final com.tencent.luggage.game.a.b a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(318433);
    a locala = new a(((com.tencent.mm.plugin.appbrand.service.c)aqX()).getContext(), ((com.tencent.mm.plugin.appbrand.service.c)aqX()).getJsRuntime(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    AppMethodBeat.o(318433);
    return locala;
  }
  
  public final void api()
  {
    AppMethodBeat.i(45072);
    new com.tencent.mm.plugin.appbrand.game.c.c().aoW();
    AppMethodBeat.o(45072);
  }
  
  public final com.tencent.mm.plugin.appbrand.n.i apk()
  {
    AppMethodBeat.i(45055);
    this.rpF = System.currentTimeMillis();
    com.tencent.mm.plugin.appbrand.n.i locali = super.apk();
    com.tencent.mm.plugin.appbrand.n.p localp = (com.tencent.mm.plugin.appbrand.n.p)locali.Z(com.tencent.mm.plugin.appbrand.n.p.class);
    if (localp != null)
    {
      this.rpE = true;
      localp.a(new p.a()
      {
        public final void coH()
        {
          AppMethodBeat.i(45048);
          com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
          if (this.rpG) {}
          for (com.tencent.mm.plugin.appbrand.task.l locall = com.tencent.mm.plugin.appbrand.task.l.tWx;; locall = null)
          {
            com.tencent.mm.plugin.appbrand.report.quality.c.a(locall, this.etl, a.a(a.this), com.tencent.mm.plugin.appbrand.report.e.tNw);
            AppMethodBeat.o(45048);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(45055);
    return locali;
  }
  
  public final void apl()
  {
    AppMethodBeat.i(45061);
    super.apl();
    if (!this.rpE)
    {
      this.rpE = true;
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      if (!((com.tencent.mm.plugin.appbrand.service.c)aqX()).cdi()) {
        break label69;
      }
    }
    label69:
    for (com.tencent.mm.plugin.appbrand.task.l locall = com.tencent.mm.plugin.appbrand.task.l.tWx;; locall = null)
    {
      com.tencent.mm.plugin.appbrand.report.quality.c.a(locall, ((com.tencent.mm.plugin.appbrand.service.c)aqX()).getAppId(), this.rpF, com.tencent.mm.plugin.appbrand.report.e.tNw);
      AppMethodBeat.o(45061);
      return;
    }
  }
  
  public final void apm()
  {
    AppMethodBeat.i(45071);
    super.apm();
    com.tencent.mm.plugin.appbrand.report.b localb = this.rpC;
    localb.rtv.post(new b.2(localb));
    AppMethodBeat.o(45071);
  }
  
  public final void apn()
  {
    AppMethodBeat.i(45059);
    super.apn();
    if (this.rpB != null) {
      this.rpB.cCZ();
    }
    if (this.rpD != null)
    {
      com.tencent.luggage.game.b.b localb = this.rpD;
      localb.ekv.removeDecodeEventListener(localb);
      Log.i("MicroMsg.MBImageDecodeRegistry", "MBImageDecodeRegistry unregister appid:%s,game:%b", new Object[] { localb.appId, Boolean.valueOf(localb.ekt) });
    }
    AppMethodBeat.o(45059);
  }
  
  public final String apo()
  {
    AppMethodBeat.i(45062);
    if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMo, false))
    {
      String str = com.tencent.mm.plugin.appbrand.n.ad.cpf();
      AppMethodBeat.o(45062);
      return str;
    }
    AppMethodBeat.o(45062);
    return null;
  }
  
  public final boolean app()
  {
    AppMethodBeat.i(45064);
    if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yMn, false))
    {
      AppMethodBeat.o(45064);
      return true;
    }
    AppMethodBeat.o(45064);
    return false;
  }
  
  public final boolean apr()
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
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWB, false))
    {
      Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "command buffer enabled false by abtest");
      AppMethodBeat.o(45065);
      return false;
    }
    if ((aqX() != null) && (((com.tencent.mm.plugin.appbrand.service.c)aqX()).getRuntime() != null))
    {
      com.tencent.mm.plugin.appbrand.config.b localb = ((com.tencent.mm.plugin.appbrand.service.c)aqX()).getRuntime().getAppConfig();
      if ((localb != null) && (localb.qVJ != null))
      {
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "command buffer enabled %b by app.config", new Object[] { localb.qVJ });
        bool = localb.qVJ.booleanValue();
        AppMethodBeat.o(45065);
        return bool;
      }
    }
    AppMethodBeat.o(45065);
    return true;
  }
  
  public final boolean aps()
  {
    AppMethodBeat.i(45066);
    if (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWC, false))
    {
      AppMethodBeat.o(45066);
      return true;
    }
    AppMethodBeat.o(45066);
    return false;
  }
  
  public final int apt()
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
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWD, 1);
    AppMethodBeat.o(45067);
    return i;
  }
  
  public final boolean apu()
  {
    AppMethodBeat.i(318424);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWG, false);
    AppMethodBeat.o(318424);
    return bool;
  }
  
  public final void apw()
  {
    AppMethodBeat.i(318421);
    super.apw();
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "virl: runtime resume");
    AppMethodBeat.o(318421);
  }
  
  public final String apy()
  {
    AppMethodBeat.i(45058);
    String str2 = super.apy();
    String str1 = str2;
    if (this.rpB != null) {
      str1 = str2 + this.rpB.cDa();
    }
    AppMethodBeat.o(45058);
    return str1;
  }
  
  public final int apz()
  {
    AppMethodBeat.i(45068);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkj, 0);
    AppMethodBeat.o(45068);
    return i;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> aqh()
  {
    AppMethodBeat.i(45060);
    Map localMap = (Map)com.tencent.luggage.sdk.h.d.b("AppBrandGameServiceLogicImpWC.onCreateJsApiPool()", new kotlin.g.a.a() {});
    AppMethodBeat.o(45060);
    return localMap;
  }
  
  public final boolean arD()
  {
    AppMethodBeat.i(174723);
    if ((((com.tencent.mm.plugin.appbrand.service.c)aqX()).getRuntime() != null) && (((com.tencent.mm.plugin.appbrand.service.c)aqX()).getRuntime().arD()))
    {
      AppMethodBeat.o(174723);
      return true;
    }
    AppMethodBeat.o(174723);
    return false;
  }
  
  public final String arO()
  {
    AppMethodBeat.i(318425);
    String str = af.cpf();
    AppMethodBeat.o(318425);
    return str;
  }
  
  public final int arP()
  {
    AppMethodBeat.i(318427);
    if (MMApplicationContext.getToolsProcesstPreference() != null)
    {
      i = MMApplicationContext.getToolsProcesstPreference().getInt("appbrand_wasm_opt", -2);
      if (i != -2)
      {
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "wasm opt set to %d by cmd", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(318427);
        return i;
      }
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zmC, -2);
    if (i != -2)
    {
      Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "wasm opt set to %d by abtest", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(318427);
      return i;
    }
    AppMethodBeat.o(318427);
    return -2;
  }
  
  public final void b(com.tencent.mm.plugin.music.b.a parama)
  {
    AppMethodBeat.i(318439);
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "setWxAudioOutputListener %s", new Object[] { parama });
    if (parama != null)
    {
      this.emq.a(parama);
      AppMethodBeat.o(318439);
      return;
    }
    this.emq.arQ();
    AppMethodBeat.o(318439);
  }
  
  public final void c(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45063);
    super.c(paramAppBrandRuntime);
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: wc post runtime ready");
    com.tencent.mm.plugin.appbrand.report.b localb = this.rpC;
    b.a local3 = new b.a()
    {
      public final void fo(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(45050);
        if (paramAppBrandRuntime == null)
        {
          Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: can not get runtime!");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAppBrandRuntime.qsE.get()) || (paramAppBrandRuntime.ccV))
        {
          Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: runtime finished. abort");
          AppMethodBeat.o(45050);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          Object localObject1 = paramAppBrandRuntime.mAppId;
          Object localObject2 = a.b(a.this);
          paramAppBrandRuntime.asG();
          com.tencent.mm.plugin.appbrand.report.quality.b.a((String)localObject1, (com.tencent.mm.plugin.appbrand.report.b)localObject2);
          a.a(a.this, new com.tencent.luggage.game.b.b());
          localObject2 = a.c(a.this);
          com.tencent.magicbrush.e locale = a.this.eml.getMagicBrush();
          localObject1 = a.this.aqZ();
          ((com.tencent.luggage.game.b.b)localObject2).appId = ((AppBrandRuntime)localObject1).mAppId;
          Log.i("MicroMsg.MBImageDecodeRegistry", "MBImageDecodeRegistry register appid:%s,game:%b", new Object[] { ((com.tencent.luggage.game.b.b)localObject2).appId, Boolean.TRUE });
          ((com.tencent.luggage.game.b.b)localObject2).ekw = new ArrayList();
          ((com.tencent.luggage.game.b.b)localObject2).ekA = 1004;
          ((com.tencent.luggage.game.b.b)localObject2).ekt = true;
          if ((localObject1 != null) && ((((AppBrandRuntime)localObject1).ari() instanceof com.tencent.luggage.sdk.b.a.d.d))) {
            localObject1 = (com.tencent.luggage.game.d.a.a.b)((com.tencent.luggage.sdk.b.a.d.d)((AppBrandRuntime)localObject1).ari()).aa(com.tencent.luggage.game.d.a.a.b.class);
          }
          for (;;)
          {
            ((com.tencent.luggage.game.b.b)localObject2).eku = new WeakReference(localObject1);
            ((com.tencent.luggage.game.b.b)localObject2).ekv = locale.avq();
            ((com.tencent.luggage.game.b.b)localObject2).ekv.addDecodeEventListener((IImageDecodeService.b)localObject2);
            localObject1 = a.c(a.this);
            boolean bool = a.b(a.this).tMX.acgV;
            paramAnonymousInt1 = a.b(a.this).tMX.acgW;
            double d = a.b(a.this).tMX.acgX;
            try
            {
              Log.i("MicroMsg.MBImageDecodeRegistry", "setConfig shouldDoSample:%b,maxSampleNum:%d,sampleRate:%f", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymousInt1), Double.valueOf(d) });
              ((com.tencent.luggage.game.b.b)localObject1).ekx = bool;
              ((com.tencent.luggage.game.b.b)localObject1).eky = paramAnonymousInt1;
              ((com.tencent.luggage.game.b.b)localObject1).ekz = d;
              localObject1 = ((com.tencent.mm.plugin.appbrand.service.c)a.this.aqX()).ccK();
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
              localObject1 = (com.tencent.mm.plugin.appbrand.game.f.a)((com.tencent.mm.plugin.appbrand.page.ad)localObject1).aa(com.tencent.mm.plugin.appbrand.game.f.a.class);
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.appbrand.game.f.a)localObject1).a(a.b(a.this));
              }
              for (;;)
              {
                localObject1 = a.b(a.this).tMV;
                if ((localObject1 == null) || (((gln)localObject1).acgZ == 0) || (((gln)localObject1).achb == 0) || (((gln)localObject1).achc == 0) || (((gln)localObject1).achd == 0) || (((gln)localObject1).acha == 0)) {
                  break;
                }
                a.this.eml.getMagicBrush().eod.a(((gln)localObject1).achb, ((gln)localObject1).achc, ((gln)localObject1).achd, ((gln)localObject1).acha, false);
                AppMethodBeat.o(45050);
                return;
                Log.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: not game renderer!");
              }
              if (DebuggerShell.cls()) {
                a.this.eml.getMagicBrush().eod.a(5, 10, 10.0F, 60, true);
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
    localb.rtv.post(new b.1(localb, paramAppBrandRuntime, local3));
    AppMethodBeat.o(45063);
  }
  
  public final com.tencent.mm.plugin.appbrand.report.b coF()
  {
    return this.rpC;
  }
  
  public final com.tencent.mm.plugin.appbrand.n.i e(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(45056);
    IJSRuntime.Config localConfig = new IJSRuntime.Config();
    localConfig.hmb = paramString;
    localConfig.hmc = paramArrayOfByte;
    paramString = (String)com.tencent.mm.plugin.appbrand.game.a.i.rqj.boF();
    Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use native buffer type: %s", new Object[] { paramString });
    localConfig.hmd = paramString;
    localConfig.hme = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTO, true);
    localConfig.hmg = ((Boolean)r.rqw.boF()).booleanValue();
    boolean bool;
    if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.rqu.boF()).booleanValue())
    {
      bool = true;
      localConfig.hmh = bool;
      localConfig.hml = new WeakReference((com.tencent.mm.plugin.appbrand.jsapi.g)aqX());
      if ((!Boolean.parseBoolean(((ICommLibReader)Objects.requireNonNull(((com.tencent.mm.plugin.appbrand.service.c)Objects.requireNonNull((com.tencent.mm.plugin.appbrand.service.c)aqX())).cbl())).UX("delayedServiceCodeCache"))) || (!((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkk, false))) {
        break label352;
      }
      bool = true;
      label200:
      localConfig.hmk = bool;
      bool = coE();
      Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: should use node: %b, config is %s", new Object[] { Boolean.valueOf(bool), localConfig.toString() });
      if (!bool) {
        break label357;
      }
    }
    label352:
    label357:
    for (paramString = new com.tencent.mm.plugin.appbrand.n.x(localConfig);; paramString = new com.tencent.mm.plugin.appbrand.n.b(localConfig))
    {
      if ((paramString instanceof com.tencent.mm.plugin.appbrand.n.x))
      {
        this.rpB = new com.tencent.mm.plugin.appbrand.v.a();
        this.rpB.a((com.tencent.mm.plugin.appbrand.y)aqX(), paramString);
      }
      paramArrayOfByte = (q)paramString.Z(q.class);
      if (paramArrayOfByte != null)
      {
        bool = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.k.Zr("tracejstask").boF()).booleanValue();
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: Trace Task Name in JSThread: ".concat(String.valueOf(bool)));
        paramArrayOfByte.eb(bool);
      }
      AppMethodBeat.o(45056);
      return paramString;
      bool = false;
      break;
      bool = false;
      break label200;
    }
  }
  
  public final void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(318434);
    super.e(paramJSONObject);
    ((com.tencent.mm.plugin.appbrand.service.c)aqX()).d(paramJSONObject, "statusBarHeight", Integer.valueOf(com.tencent.luggage.game.g.a.b((com.tencent.luggage.sdk.b.a.d.d)aqX())));
    HashMap localHashMap = new HashMap(6);
    Object localObject = aq.d((com.tencent.mm.plugin.appbrand.jsapi.k)aqX());
    int m = localObject[0];
    int k = localObject[1];
    localObject = ((com.tencent.mm.plugin.appbrand.service.c)aqX()).qwF.getSafeAreaInsets();
    if (localObject != null)
    {
      int i = com.tencent.mm.plugin.appbrand.af.i.DA(((Rect)localObject).left);
      int j = com.tencent.mm.plugin.appbrand.af.i.DA(((Rect)localObject).top);
      m = com.tencent.mm.plugin.appbrand.af.i.DA(Math.min(((Rect)localObject).right, m));
      k = com.tencent.mm.plugin.appbrand.af.i.DA(Math.min(((Rect)localObject).bottom, k));
      localHashMap.put("left", Integer.valueOf(i));
      localHashMap.put("top", Integer.valueOf(j));
      localHashMap.put("right", Integer.valueOf(m));
      localHashMap.put("bottom", Integer.valueOf(k));
      localHashMap.put("width", Integer.valueOf(m - i));
      localHashMap.put("height", Integer.valueOf(k - j));
      ((com.tencent.mm.plugin.appbrand.service.c)aqX()).d(paramJSONObject, "safeArea", localHashMap);
    }
    AppMethodBeat.o(318434);
  }
  
  public final void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(318400);
    super.f(paramJSONObject);
    try
    {
      paramJSONObject.put("clientVersion", com.tencent.mm.protocal.d.Yxh);
      paramJSONObject.put("JSEngineName", com.tencent.mm.plugin.appbrand.n.w.e(((com.tencent.mm.plugin.appbrand.service.c)aqX()).getJsRuntime()));
      AppMethodBeat.o(318400);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandGameServiceLogicImpWC", paramJSONObject, "attachCommonConfig error", new Object[0]);
      AppMethodBeat.o(318400);
    }
  }
  
  public final String fs(String paramString)
  {
    AppMethodBeat.i(45070);
    if (arD())
    {
      paramString = com.tencent.mm.plugin.appbrand.debugger.x.a(paramString, ((com.tencent.mm.plugin.appbrand.service.c)aqX()).getRuntime());
      AppMethodBeat.o(45070);
      return paramString;
    }
    AppMethodBeat.o(45070);
    return "";
  }
  
  public final boolean g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(318437);
    if ((aqX() != null) && (((com.tencent.mm.plugin.appbrand.service.c)aqX()).tTr) && (com.tencent.mm.plugin.appbrand.ad.e.UH(paramString1)))
    {
      ((com.tencent.mm.plugin.appbrand.service.c)aqX()).cF(paramString1, paramString2);
      AppMethodBeat.o(318437);
      return true;
    }
    boolean bool = super.g(paramString1, paramString2, paramInt);
    AppMethodBeat.o(318437);
    return bool;
  }
  
  public final void ml(int paramInt)
  {
    AppMethodBeat.i(45069);
    super.ml(paramInt);
    Object localObject = com.tencent.mm.plugin.appbrand.report.quality.b.afZ(((com.tencent.mm.plugin.appbrand.service.c)aqX()).getAppId());
    if (localObject == null)
    {
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 1)
    {
      ((QualitySessionRuntime)localObject).tSv.tSH = l.a.tSJ;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 2)
    {
      ((QualitySessionRuntime)localObject).tSv.tSH = l.a.tSK;
      AppMethodBeat.o(45069);
      return;
    }
    if (paramInt == 3)
    {
      ((QualitySessionRuntime)localObject).tSv.tSH = l.a.tSL;
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
    public a(Context paramContext, com.tencent.mm.plugin.appbrand.n.i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
    {
      super(parami, paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
    }
    
    public final void a(com.tencent.magicbrush.e parame, long paramLong)
    {
      AppMethodBeat.i(45052);
      com.tencent.mm.plugin.appbrand.report.quality.b.cJb();
      com.tencent.mm.plugin.appbrand.report.quality.c.a(((com.tencent.mm.plugin.appbrand.service.c)a.this.aqX()).cdi(), ((com.tencent.mm.plugin.appbrand.service.c)a.this.aqX()).getAppId(), paramLong);
      AppMethodBeat.o(45052);
    }
    
    public final void a(com.tencent.magicbrush.f paramf)
    {
      boolean bool2 = true;
      AppMethodBeat.i(45051);
      super.a(paramf);
      boolean bool1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yQN, false);
      paramf.eHX.a(com.tencent.magicbrush.g.aYe[6], Boolean.valueOf(bool1));
      paramf.bg(com.tencent.mm.plugin.appbrand.game.a.f.rpY.eB(((com.tencent.mm.plugin.appbrand.service.c)a.this.aqX()).getContext()));
      paramf.dj(com.tencent.mm.plugin.appbrand.game.a.y.coP());
      bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.b.rpU.boF()).booleanValue();
      paramf.eHY.a(com.tencent.magicbrush.g.aYe[7], Boolean.valueOf(bool1));
      bool1 = ((Boolean)v.rqA.boF()).booleanValue();
      String str1;
      label210:
      String str2;
      label218:
      String str3;
      if ((a.coG()) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.w.rqB.boF()).booleanValue()))
      {
        paramf.b(a.b.eKw);
        paramf.eHF = new e.e()
        {
          FrameLayout rpI;
          com.tencent.magicbrush.utils.e rpJ;
          
          public final void a(final MagicBrushView paramAnonymousMagicBrushView, final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3, final int paramAnonymousInt4, final int paramAnonymousInt5)
          {
            AppMethodBeat.i(318350);
            if (a.this.aqZ() != null) {
              a.this.aqZ().i(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(318361);
                  if (a.a.1.this.rpI == null)
                  {
                    a.a.1.this.rpI = new FrameLayout(((com.tencent.mm.plugin.appbrand.service.c)a.this.aqX()).getContext());
                    cf.a(((com.tencent.mm.plugin.appbrand.service.c)a.this.aqX()).ccK().txd, a.a.1.this.rpI);
                  }
                  int m = a.a.1.this.rpJ.a(a.a.1.this.rpI, paramAnonymousMagicBrushView, paramAnonymousInt5);
                  paramAnonymousMagicBrushView.setOpaque(false);
                  int k = paramAnonymousInt3;
                  int j = paramAnonymousInt4;
                  int n = (int)((com.tencent.mm.plugin.appbrand.service.c)a.this.aqX()).getContext().getResources().getDisplayMetrics().density;
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
                    a.a.1.this.rpI.addView(paramAnonymousMagicBrushView, m, localLayoutParams);
                    paramAnonymousMagicBrushView.setOpaque(false);
                    AppMethodBeat.o(318361);
                    return;
                  }
                }
              }, 0L);
            }
            AppMethodBeat.o(318350);
          }
          
          public final MagicBrushView avy()
          {
            AppMethodBeat.i(318347);
            MagicBrushView localMagicBrushView = new MagicBrushView(((com.tencent.mm.plugin.appbrand.service.c)a.this.aqX()).getContext(), MagicBrushView.h.eKZ);
            localMagicBrushView.setContentDescription("ScreenCanvasMagicBrushView");
            localMagicBrushView.setMagicBrush(a.a.this.getMagicBrush());
            localMagicBrushView.setUseRawAxisTouchEvent(true);
            AppMethodBeat.o(318347);
            return localMagicBrushView;
          }
          
          public final void b(final MagicBrushView paramAnonymousMagicBrushView, final int paramAnonymousInt1, final int paramAnonymousInt2, final int paramAnonymousInt3, final int paramAnonymousInt4, final int paramAnonymousInt5)
          {
            AppMethodBeat.i(318354);
            if (a.this.aqZ() != null) {
              a.this.aqZ().i(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(318357);
                  FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramAnonymousInt3, paramAnonymousInt4);
                  localLayoutParams.setMargins(paramAnonymousInt1, paramAnonymousInt2, 0, 0);
                  int i = a.a.1.this.rpJ.a(a.a.1.this.rpI, paramAnonymousMagicBrushView, paramAnonymousInt5);
                  if (i == -2)
                  {
                    paramAnonymousMagicBrushView.setLayoutParams(localLayoutParams);
                    paramAnonymousMagicBrushView.requestLayout();
                  }
                  for (;;)
                  {
                    paramAnonymousMagicBrushView.setOpaque(false);
                    AppMethodBeat.o(318357);
                    return;
                    a.a.1.this.rpI.removeView(paramAnonymousMagicBrushView);
                    a.a.1.this.rpI.addView(paramAnonymousMagicBrushView, i, localLayoutParams);
                  }
                }
              }, 0L);
            }
            AppMethodBeat.o(318354);
          }
          
          public final void c(final MagicBrushView paramAnonymousMagicBrushView)
          {
            AppMethodBeat.i(318356);
            if (a.this.aqZ() != null) {
              a.this.aqZ().i(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(318362);
                  a.a.1.this.rpJ.cT(paramAnonymousMagicBrushView);
                  a.a.1.this.rpI.removeView(paramAnonymousMagicBrushView);
                  AppMethodBeat.o(318362);
                }
              }, 0L);
            }
            AppMethodBeat.o(318356);
          }
        };
        boolean bool3 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.g.rqh.boF()).booleanValue();
        bool1 = ((Boolean)s.rqx.boF()).booleanValue();
        boolean bool4 = ((Boolean)t.rqy.boF()).booleanValue();
        if (!bool3) {
          break label522;
        }
        str1 = "yes";
        if (!bool1) {
          break label530;
        }
        str2 = "yes";
        if (!bool4) {
          break label538;
        }
        str3 = "yes";
        label227:
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
        if ((!bool3) || (!bool1)) {
          break label546;
        }
        bool1 = true;
        label264:
        paramf.dr(bool1);
        if ((!bool3) || (!bool4)) {
          break label551;
        }
        bool1 = true;
        label281:
        paramf.dq(bool1);
        bool1 = ((Boolean)m.rqr.boF()).booleanValue();
        paramf.ds(bool1);
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "dl: supportETC2ASTC[%b]", new Object[] { Boolean.valueOf(bool1) });
        Log.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use animation handler: %s", new Object[] { paramf.avD().toString() });
        paramf.dm(((Boolean)com.tencent.mm.plugin.appbrand.game.a.d.rpW.boF()).booleanValue());
        paramf.dn(((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.rqu.boF()).booleanValue());
        bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.c.rpV.boF()).booleanValue();
        paramf.eIr.a(com.tencent.magicbrush.g.aYe[24], Boolean.valueOf(bool1));
        if (((Integer)com.tencent.mm.plugin.appbrand.game.a.x.rqC.boF()).intValue() == 0) {
          break label556;
        }
      }
      label522:
      label530:
      label538:
      label546:
      label551:
      label556:
      for (bool1 = bool2;; bool1 = false)
      {
        paramf.dp(bool1);
        paramf.jdMethod_do(((Boolean)com.tencent.mm.plugin.appbrand.game.a.l.rqq.boF()).booleanValue());
        paramf.dt(((Boolean)com.tencent.mm.plugin.appbrand.game.a.e.rpX.boF()).booleanValue());
        paramf.dy(a.this.arN().esf.getNativeHandle());
        AppMethodBeat.o(45051);
        return;
        if (!bool1)
        {
          paramf.b(a.b.eKu);
          break;
        }
        if (a.coG())
        {
          paramf.b(a.b.eKt);
          break;
        }
        paramf.b(a.b.eKs);
        break;
        str1 = "no";
        break label210;
        str2 = "no";
        break label218;
        str3 = "no";
        break label227;
        bool1 = false;
        break label264;
        bool1 = false;
        break label281;
      }
    }
    
    public final void a(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(45053);
      super.a(paramAppBrandRuntime);
      com.tencent.mm.plugin.appbrand.game.c.a.rqJ.a(getMagicBrush(), paramAppBrandRuntime);
      a.d(a.this);
      AppMethodBeat.o(45053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a
 * JD-Core Version:    0.7.0.1
 */