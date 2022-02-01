package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.an;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.appbrand.m.af;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.p.a;
import com.tencent.mm.plugin.appbrand.m.w;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.sdk.b.a.c.c<c>
  implements com.tencent.luggage.game.d.a.a.c
{
  private com.tencent.mm.plugin.appbrand.u.b.a nMl;
  private com.tencent.luggage.game.a.c nMm;
  
  public b(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(227420);
    this.nMl = null;
    this.nMm = null;
    b(com.tencent.luggage.game.d.a.a.c.class, this);
    AppMethodBeat.o(227420);
  }
  
  private void aeW(String paramString)
  {
    AppMethodBeat.i(227422);
    bVp();
    if (!Util.isNullOrNil(paramString))
    {
      if (getMagicBrush() != null)
      {
        getMagicBrush().dX(paramString);
        AppMethodBeat.o(227422);
        return;
      }
      Log.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: create magicbrush failed! %s", new Object[] { paramString });
    }
    AppMethodBeat.o(227422);
  }
  
  private void bVp()
  {
    boolean bool = true;
    AppMethodBeat.i(227428);
    Log.printInfoStack("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: start create magicbrush", new Object[0]);
    if (this.nMm != null) {}
    for (;;)
    {
      Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.nMm == null) {
        break;
      }
      AppMethodBeat.o(227428);
      return;
      bool = false;
    }
    if (NN() != null)
    {
      i locali = ((c)NN()).getJsRuntime();
      com.tencent.magicbrush.a.b.loadLibraries();
      com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
      this.nMm = new com.tencent.luggage.game.a.c(((c)NN()).getContext(), locali)
      {
        public final void a(com.tencent.magicbrush.e paramAnonymouse, long paramAnonymousLong)
        {
          AppMethodBeat.i(227416);
          com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
          com.tencent.mm.plugin.appbrand.report.quality.c.a(((c)b.this.NN()).bsW(), ((c)b.this.NN()).getAppId(), paramAnonymousLong);
          AppMethodBeat.o(227416);
        }
        
        public final void a(com.tencent.magicbrush.f paramAnonymousf)
        {
          boolean bool2 = true;
          AppMethodBeat.i(227415);
          super.a(paramAnonymousf);
          paramAnonymousf.af(com.tencent.mm.plugin.appbrand.game.a.e.lry.dJ(((c)b.this.NN()).getContext()));
          paramAnonymousf.cp(false);
          paramAnonymousf.ct(((Boolean)m.lrN.aLT()).booleanValue());
          if (((this.cum instanceof x)) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.t.lrU.aLT()).booleanValue())) {
            paramAnonymousf.b(com.tencent.magicbrush.ui.a.b.cOC);
          }
          boolean bool3 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.f.lrC.aLT()).booleanValue();
          boolean bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.lrQ.aLT()).booleanValue();
          boolean bool4 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.q.lrR.aLT()).booleanValue();
          String str1;
          String str2;
          label146:
          String str3;
          if (bool3)
          {
            str1 = "yes";
            if (!bool1) {
              break label243;
            }
            str2 = "yes";
            if (!bool4) {
              break label250;
            }
            str3 = "yes";
            label155:
            Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
            if ((!bool3) || (!bool1)) {
              break label257;
            }
            bool1 = true;
            label192:
            paramAnonymousf.cw(bool1);
            if ((!bool3) || (!bool4)) {
              break label262;
            }
          }
          label257:
          label262:
          for (bool1 = bool2;; bool1 = false)
          {
            paramAnonymousf.cv(bool1);
            paramAnonymousf.cx(((Boolean)com.tencent.mm.plugin.appbrand.game.a.d.lrs.aLT()).booleanValue());
            AppMethodBeat.o(227415);
            return;
            str1 = "no";
            break;
            label243:
            str2 = "no";
            break label146;
            label250:
            str3 = "no";
            break label155;
            bool1 = false;
            break label192;
          }
        }
      };
      this.nMm.LQ();
      if (((c)NN()).isRunning()) {
        this.nMm.b(((c)NN()).getRuntime());
      }
      locali.addJavascriptInterface(new a((byte)0), "MagicBrushViewIdTransfer");
      locali.evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/NativeGlobal-WAService.js"), new ValueCallback() {});
      AppMethodBeat.o(227428);
      return;
    }
    Log.w("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: component lost");
    AppMethodBeat.o(227428);
  }
  
  public final void MC()
  {
    AppMethodBeat.i(227423);
    super.MC();
    AppMethodBeat.o(227423);
  }
  
  public final void MD()
  {
    AppMethodBeat.i(227424);
    super.MD();
    AppMethodBeat.o(227424);
  }
  
  public final i Mk()
  {
    Object localObject3 = null;
    AppMethodBeat.i(48257);
    final long l = System.currentTimeMillis();
    if (((c)NN()).getContext() == null) {
      MMApplicationContext.getContext();
    }
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSi, false)) {}
    for (Object localObject2 = ad.bDt();; localObject2 = null)
    {
      Object localObject1;
      if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rSh, false)) {
        if (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
          localObject1 = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot64.bin");
        }
      }
      for (;;)
      {
        int i = ((c)NN()).bqZ().bvd();
        an.btp();
        boolean bool2 = ((Boolean)o.lrP.aLT()).booleanValue();
        boolean bool1;
        if (!((Boolean)m.lrN.aLT()).booleanValue())
        {
          bool1 = true;
          label139:
          localObject2 = w.a(i, (String)localObject2, (byte[])localObject1, bool2, bool1, com.tencent.mm.plugin.appbrand.m.aa.q((com.tencent.mm.plugin.appbrand.s)NN()), (com.tencent.mm.plugin.appbrand.jsapi.g)NN());
          if ((localObject2 instanceof x))
          {
            this.nMl = new com.tencent.mm.plugin.appbrand.u.a();
            this.nMl.a((com.tencent.mm.plugin.appbrand.s)NN(), (i)localObject2);
          }
          localObject1 = (com.tencent.mm.plugin.appbrand.m.p)((i)localObject2).R(com.tencent.mm.plugin.appbrand.m.p.class);
          if (localObject1 == null) {
            break label288;
          }
          ((com.tencent.mm.plugin.appbrand.m.p)localObject1).a(new p.a()
          {
            public final void onInitialized()
            {
              AppMethodBeat.i(48248);
              com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
              if (this.lrm) {}
              for (com.tencent.mm.plugin.appbrand.task.g localg = com.tencent.mm.plugin.appbrand.task.g.nPD;; localg = null)
              {
                com.tencent.mm.plugin.appbrand.report.quality.c.a(localg, this.val$appId, l, com.tencent.mm.plugin.appbrand.report.e.d(this.cAZ));
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
          localObject1 = com.tencent.mm.plugin.appbrand.ac.d.afB("wxa_library/v8_snapshot.bin");
          break;
          bool1 = false;
          break label139;
          label288:
          com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
          localObject1 = localObject3;
          if (((c)NN()).bsW()) {
            localObject1 = com.tencent.mm.plugin.appbrand.task.g.nPD;
          }
          com.tencent.mm.plugin.appbrand.report.quality.c.a((com.tencent.mm.plugin.appbrand.task.g)localObject1, ((c)NN()).getAppId(), l, com.tencent.mm.plugin.appbrand.report.e.d((i)localObject2));
        }
        localObject1 = null;
      }
    }
  }
  
  public final void Ml()
  {
    AppMethodBeat.i(48264);
    super.Ml();
    if (com.tencent.mm.plugin.appbrand.m.aa.q((com.tencent.mm.plugin.appbrand.s)NN()))
    {
      Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "service initNativeTransLogic");
      com.tencent.mm.plugin.appbrand.m.aa.a(((c)NN()).getJsRuntime(), ((c)NN()).getComponentId(), getAppId());
      com.tencent.mm.plugin.appbrand.m.aa.a(((c)NN()).getJsRuntime(), ((c)NN()).getComponentId(), ((c)NN()).getComponentId(), getAppId());
    }
    AppMethodBeat.o(48264);
  }
  
  public final void Mm()
  {
    AppMethodBeat.i(48262);
    super.Mm();
    if (this.nMm != null) {
      this.nMm.destroy();
    }
    AppMethodBeat.o(48262);
  }
  
  public final void Mn()
  {
    AppMethodBeat.i(48263);
    super.Mn();
    if (this.nMl != null) {
      this.nMl.bPW();
    }
    AppMethodBeat.o(48263);
  }
  
  public final String My()
  {
    AppMethodBeat.i(48260);
    String str2 = "" + super.My();
    String str1 = str2;
    if (this.nMl != null) {
      str1 = str2 + this.nMl.bPX();
    }
    AppMethodBeat.o(48260);
    return str1;
  }
  
  public final int Mz()
  {
    AppMethodBeat.i(48268);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.shG, 0);
    AppMethodBeat.o(48268);
    return i;
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Nf()
  {
    AppMethodBeat.i(48261);
    if ((NN() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      localMap = com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k.bOL();
      AppMethodBeat.o(48261);
      return localMap;
    }
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandMiniProgramServiceLogicImpWC.onCreateJsApiPool()", new kotlin.g.a.a() {});
    AppMethodBeat.o(48261);
    return localMap;
  }
  
  public final String OB()
  {
    AppMethodBeat.i(227425);
    String str = af.bDt();
    AppMethodBeat.o(227425);
    return str;
  }
  
  public final void Ok()
  {
    AppMethodBeat.i(48267);
    Object localObject1 = aa.nMY;
    if (aa.f((c)NN()))
    {
      final long l = System.currentTimeMillis();
      localObject1 = aa.nMY;
      localObject1 = aa.bVu();
      Object localObject2 = aa.nMY;
      localObject2 = aa.bVv();
      Object localObject3 = aa.nMY;
      localObject3 = aa.bVw();
      Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript name:%s", new Object[] { localObject1 });
      Log.v("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript jsSource:%s", new Object[] { localObject2 });
      final d.a locala = new d.a();
      locala.scriptName = ((String)localObject1);
      locala.czz = ((String)localObject2);
      locala.czA = ((String)localObject2).length();
      com.tencent.mm.plugin.appbrand.utils.s.a(((c)NN()).getJsRuntime(), "https://lib/" + (String)localObject1, "", "", 0, (String)localObject2, (String)localObject3, new s.a()
      {
        public final void du(String paramAnonymousString)
        {
          AppMethodBeat.i(227419);
          ((c)b.this.NN()).a(locala, false, l, System.currentTimeMillis(), null);
          Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onFailure ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(227419);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(227418);
          ((c)b.this.NN()).a(locala, true, l, System.currentTimeMillis(), null);
          Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onSuccess ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(227418);
        }
      });
    }
    AppMethodBeat.o(48267);
  }
  
  public final com.tencent.luggage.sdk.b.a.c.b a(com.tencent.mm.plugin.appbrand.m.t paramt)
  {
    AppMethodBeat.i(160614);
    an.btp();
    paramt = new a((c)NN(), paramt);
    AppMethodBeat.o(160614);
    return paramt;
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48265);
    super.c(paramAppBrandRuntime);
    if (this.nMm != null) {
      this.nMm.b(paramAppBrandRuntime);
    }
    AppMethodBeat.o(48265);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48266);
    super.c(paramJSONObject);
    aa localaa = aa.nMY;
    boolean bool = aa.f((c)NN());
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
  
  public final void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(227426);
    super.d(paramJSONObject);
    try
    {
      paramJSONObject.put("clientVersion", com.tencent.mm.protocal.d.KyO);
      paramJSONObject.put("JSEngineName", w.c(((c)NN()).getJsRuntime()));
      com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdk(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.cds(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdo(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdr(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdq(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdz(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdu(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdv(), paramJSONObject);
      com.tencent.mm.plugin.appbrand.h.a.i(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdx(), paramJSONObject);
      paramJSONObject.put("useXWebWebGLCanvas", com.tencent.mm.plugin.appbrand.xweb_ext.c.cdw());
      paramJSONObject.put("useSkiaCanvasRaf", com.tencent.mm.plugin.appbrand.xweb_ext.c.cdm());
      paramJSONObject.put("useNewXWebCanvasToTFP", com.tencent.mm.plugin.appbrand.xweb_ext.c.cdn());
      AppMethodBeat.o(227426);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", paramJSONObject, "attachCommonConfig error", new Object[0]);
      AppMethodBeat.o(227426);
    }
  }
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(227429);
    if ((NN() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(227429);
      return true;
    }
    boolean bool = super.d(paramString1, paramString2, paramInt);
    AppMethodBeat.o(227429);
    return bool;
  }
  
  public final boolean d(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(227421);
    if ("MediaToolKit".equals(paramString))
    {
      aeW(null);
      AppMethodBeat.o(227421);
      return true;
    }
    if ("Image".equals(paramString))
    {
      aeW(null);
      AppMethodBeat.o(227421);
      return true;
    }
    if ("OffscreenCanvas".equals(paramString))
    {
      aeW(null);
      AppMethodBeat.o(227421);
      return true;
    }
    if ("CpuProfiler".equals(paramString))
    {
      aeW(null);
      AppMethodBeat.o(227421);
      return true;
    }
    if ("HeapProfiler".equals(paramString))
    {
      aeW(null);
      AppMethodBeat.o(227421);
      return true;
    }
    if ("Box2D".equals(paramString))
    {
      aeW("mmbox2d");
      AppMethodBeat.o(227421);
      return true;
    }
    if ("Phys3D".equals(paramString))
    {
      aeW("mmphysx");
      AppMethodBeat.o(227421);
      return true;
    }
    boolean bool = super.d(paramString, paramJSONObject);
    AppMethodBeat.o(227421);
    return bool;
  }
  
  public final com.tencent.magicbrush.e getMagicBrush()
  {
    AppMethodBeat.i(227427);
    bVp();
    if (this.nMm != null)
    {
      com.tencent.magicbrush.e locale = this.nMm.getMagicBrush();
      AppMethodBeat.o(227427);
      return locale;
    }
    AppMethodBeat.o(227427);
    return null;
  }
  
  public final boolean j(int paramInt, String paramString)
  {
    AppMethodBeat.i(227430);
    if ((NN() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(227430);
      return true;
    }
    boolean bool = super.j(paramInt, paramString);
    AppMethodBeat.o(227430);
    return bool;
  }
  
  public final void z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48258);
    super.z(paramString1, paramString2);
    try
    {
      com.tencent.mm.plugin.appbrand.report.k.b((c)NN(), paramString1, paramString2);
      AppMethodBeat.o(48258);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(48258);
    }
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
        Object localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.ZJ(((c)b.this.NN()).getAppId()).cCB.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        int i = ((com.tencent.mm.plugin.appbrand.jsapi.b.a.b)localObject).lQQ.getVirtualElementId();
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", localException, "MagicBrushViewIdTransfer failed. [%d] [%s]", new Object[] { Integer.valueOf(paramInt), ((c)b.this.NN()).getAppId() });
          paramInt = -1;
        }
      }
      AppMethodBeat.o(48256);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b
 * JD-Core Version:    0.7.0.1
 */