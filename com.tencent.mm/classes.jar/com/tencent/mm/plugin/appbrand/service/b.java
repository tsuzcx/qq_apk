package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.p;
import com.tencent.mm.plugin.appbrand.jsruntime.p.a;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.jsruntime.w;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.jsruntime.z;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.sdk.b.a.c.b<c>
{
  private com.tencent.mm.plugin.appbrand.q.b.a lWu = null;
  com.tencent.luggage.game.a.c lWv = null;
  
  public b(c paramc)
  {
    super(paramc);
  }
  
  public final String BA()
  {
    AppMethodBeat.i(48260);
    if ((this.lWv != null) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSQ, true))) {}
    for (Object localObject = "" + "var openInvokeHandlerJsBinding = true;";; localObject = "")
    {
      String str = (String)localObject + super.BA();
      localObject = str;
      if (this.lWu != null) {
        localObject = str + this.lWu.bpE();
      }
      if (this.lWv != null) {}
      for (localObject = (String)localObject + com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/NativeGlobal-WAService.js");; localObject = (String)localObject + com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/NativeGlobal-Dummy.js"))
      {
        AppMethodBeat.o(48260);
        return localObject;
      }
    }
  }
  
  public final int BB()
  {
    AppMethodBeat.i(48268);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pYz, 0);
    AppMethodBeat.o(48268);
    return i;
  }
  
  public final void BE()
  {
    AppMethodBeat.i(186950);
    super.BE();
    AppMethodBeat.o(186950);
  }
  
  public final void BF()
  {
    AppMethodBeat.i(186951);
    super.BF();
    AppMethodBeat.o(186951);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i Bm()
  {
    Object localObject3 = null;
    AppMethodBeat.i(48257);
    final long l = System.currentTimeMillis();
    if (((c)CM()).getContext() == null) {
      ai.getContext();
    }
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPj, false)) {}
    for (Object localObject2 = com.tencent.mm.plugin.appbrand.jsruntime.ac.bdS();; localObject2 = null)
    {
      Object localObject1;
      if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pPi, false)) {
        if (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
          localObject1 = com.tencent.mm.plugin.appbrand.z.d.Ro("wxa_library/v8_snapshot64.bin");
        }
      }
      for (;;)
      {
        int i = ((c)CM()).aSt().aVU();
        ak.aUC();
        boolean bool2 = ((Boolean)l.jQE.aqp()).booleanValue();
        boolean bool1;
        if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.k.jQD.aqp()).booleanValue())
        {
          bool1 = true;
          label139:
          localObject2 = w.a(i, (String)localObject2, (byte[])localObject1, bool2, bool1, z.o((com.tencent.mm.plugin.appbrand.q)CM()), (com.tencent.mm.plugin.appbrand.jsapi.d)CM());
          if ((localObject2 instanceof x))
          {
            this.lWu = new com.tencent.mm.plugin.appbrand.q.a();
            this.lWu.a((com.tencent.mm.plugin.appbrand.q)CM(), (com.tencent.mm.plugin.appbrand.jsruntime.i)localObject2);
          }
          localObject1 = (p)((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject2).P(p.class);
          if (localObject1 == null) {
            break label286;
          }
          ((p)localObject1).a(new p.a()
          {
            public final void onInitialized()
            {
              AppMethodBeat.i(48248);
              com.tencent.mm.plugin.appbrand.report.quality.a.btI();
              if (this.jQc) {}
              for (com.tencent.mm.plugin.appbrand.task.e locale = com.tencent.mm.plugin.appbrand.task.e.lYr;; locale = null)
              {
                com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, this.val$appId, l, com.tencent.mm.plugin.appbrand.report.c.d(this.cet));
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
          localObject1 = com.tencent.mm.plugin.appbrand.z.d.Ro("wxa_library/v8_snapshot.bin");
          break;
          bool1 = false;
          break label139;
          label286:
          com.tencent.mm.plugin.appbrand.report.quality.a.btI();
          localObject1 = localObject3;
          if (((c)CM()).aUl()) {
            localObject1 = com.tencent.mm.plugin.appbrand.task.e.lYr;
          }
          com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.task.e)localObject1, ((c)CM()).getAppId(), l, com.tencent.mm.plugin.appbrand.report.c.d((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject2));
        }
        localObject1 = null;
      }
    }
  }
  
  public final void Bn()
  {
    AppMethodBeat.i(48264);
    super.Bn();
    if (z.o((com.tencent.mm.plugin.appbrand.q)CM()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "service initNativeTransLogic");
      z.a(((c)CM()).aUV(), ((c)CM()).aUT(), getAppId());
      z.a(((c)CM()).aUV(), ((c)CM()).aUT(), ((c)CM()).aUT(), getAppId());
    }
    Object localObject = ((c)CM()).aUV();
    if (this.lWv != null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.lWv == null) {
        if (!(CM() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d)) {
          break label317;
        }
      }
    }
    label317:
    for (boolean bool = false;; bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pRD, true))
    {
      if (bool)
      {
        com.tencent.magicbrush.a.b.loadLibraries();
        com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
        this.lWv = new com.tencent.luggage.game.a.c(((c)CM()).getContext(), (com.tencent.mm.plugin.appbrand.jsruntime.i)localObject)
        {
          public final void a(com.tencent.magicbrush.d paramAnonymousd, long paramAnonymousLong)
          {
            AppMethodBeat.i(48252);
            com.tencent.mm.plugin.appbrand.report.quality.a.btI();
            com.tencent.mm.plugin.appbrand.report.quality.b.a(((c)b.this.CM()).aUl(), ((c)b.this.CM()).getAppId(), paramAnonymousLong);
            AppMethodBeat.o(48252);
          }
          
          public final void a(com.tencent.magicbrush.e paramAnonymouse)
          {
            AppMethodBeat.i(48251);
            super.a(paramAnonymouse);
            paramAnonymouse.ac(com.tencent.mm.plugin.appbrand.game.a.d.jQp.jdMethod_do(((c)b.this.CM()).getContext()));
            paramAnonymouse.bP(false);
            paramAnonymouse.bR(((Boolean)com.tencent.mm.plugin.appbrand.game.a.g.jQv.aqp()).booleanValue());
            paramAnonymouse.bS(((Boolean)com.tencent.mm.plugin.appbrand.game.a.k.jQD.aqp()).booleanValue());
            if (((this.bXZ instanceof x)) && (((Boolean)o.jQH.aqp()).booleanValue())) {
              paramAnonymouse.b(com.tencent.magicbrush.ui.a.b.coY);
            }
            AppMethodBeat.o(48251);
          }
        };
        this.lWv.AW();
        this.lWv.getMagicBrush().clS = new com.tencent.magicbrush.handler.b()
        {
          public final String a(final String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(186948);
            if (b.this.CM() == null)
            {
              AppMethodBeat.o(186948);
              return "";
            }
            try
            {
              paramAnonymousString1 = ((c)b.this.CM()).b(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousBoolean);
              AppMethodBeat.o(186948);
              return paramAnonymousString1;
            }
            catch (Throwable paramAnonymousString1)
            {
              com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", paramAnonymousString1, "IMBInvokeHandler.invoke", new Object[0]);
              ap.f(new Runnable()
              {
                public final void run()
                {
                  throw paramAnonymousString1;
                }
              });
              AppMethodBeat.o(186948);
            }
            return "";
          }
          
          public final String[] getAsyncableJsApis()
          {
            AppMethodBeat.i(186949);
            if (b.this.CM() == null)
            {
              AppMethodBeat.o(186949);
              return null;
            }
            String[] arrayOfString = ((c)b.this.CM()).getAsyncableJsApis();
            AppMethodBeat.o(186949);
            return arrayOfString;
          }
        };
        if (((c)CM()).isRunning()) {
          this.lWv.b(((c)CM()).getRuntime());
        }
        ((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject).addJavascriptInterface(new a((byte)0), "MagicBrushViewIdTransfer");
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((c)CM()).aUV().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48250);
            if (((c)b.this.CM()).aUV() == null)
            {
              com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "jsruntime is null, return");
              AppMethodBeat.o(48250);
              return;
            }
            v localv = (v)((c)b.this.CM()).aUV().P(v.class);
            com.tencent.mm.plugin.appbrand.jsapi.z.b.c.D(localv.getIsolatePtr(), localv.LS());
            AppMethodBeat.o(48250);
          }
        });
      }
      AppMethodBeat.o(48264);
      return;
      bool = false;
      break;
    }
  }
  
  public final void Bo()
  {
    AppMethodBeat.i(48262);
    super.Bo();
    if (this.lWv != null) {
      this.lWv.destroy();
    }
    AppMethodBeat.o(48262);
  }
  
  public final void Bp()
  {
    AppMethodBeat.i(48263);
    if (this.lWu != null) {
      this.lWu.bpD();
    }
    AppMethodBeat.o(48263);
  }
  
  public final Map<String, m> Ch()
  {
    AppMethodBeat.i(48261);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandMiniProgramServiceLogicImpWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(48261);
    return localMap;
  }
  
  public final void Di()
  {
    AppMethodBeat.i(48267);
    Object localObject1 = s.lWG;
    if (s.d((c)CM()))
    {
      final long l = System.currentTimeMillis();
      localObject1 = s.lWG;
      localObject1 = s.buc();
      Object localObject2 = s.lWG;
      localObject2 = s.bud();
      Object localObject3 = s.lWG;
      localObject3 = s.bue();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript name:%s", new Object[] { localObject1 });
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript jsSource:%s", new Object[] { localObject2 });
      final d.a locala = new d.a();
      locala.scriptName = ((String)localObject1);
      locala.cde = ((String)localObject2);
      locala.cdf = ((String)localObject2).length();
      com.tencent.mm.plugin.appbrand.utils.q.a(((c)CM()).aUV(), "https://lib/" + (String)localObject1, "", "", 0, (String)localObject2, (String)localObject3, new q.a()
      {
        public final void bZ(String paramAnonymousString)
        {
          AppMethodBeat.i(48255);
          ((c)b.this.CM()).a(locala, false, l, System.currentTimeMillis(), null);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onFailure ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(48255);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(48254);
          ((c)b.this.CM()).a(locala, true, l, System.currentTimeMillis(), null);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onSuccess ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(48254);
        }
      });
    }
    AppMethodBeat.o(48267);
  }
  
  public final com.tencent.luggage.sdk.b.a.c.a a(t paramt)
  {
    AppMethodBeat.i(160614);
    ak.aUC();
    paramt = new a((c)CM(), paramt);
    AppMethodBeat.o(160614);
    return paramt;
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48265);
    super.c(paramAppBrandRuntime);
    if (this.lWv != null) {
      this.lWv.b(paramAppBrandRuntime);
    }
    AppMethodBeat.o(48265);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48266);
    super.c(paramJSONObject);
    s locals = s.lWG;
    boolean bool = s.d((c)CM());
    try
    {
      paramJSONObject.put("exportBaseMethods", bool);
      paramJSONObject.put("supressOffscreenPatch", true);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(48266);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods e:%s", new Object[] { paramJSONObject });
      }
    }
  }
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(186952);
    if ((CM() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d))
    {
      AppMethodBeat.o(186952);
      return true;
    }
    boolean bool = super.d(paramString1, paramString2, paramInt);
    AppMethodBeat.o(186952);
    return bool;
  }
  
  public final boolean i(int paramInt, String paramString)
  {
    AppMethodBeat.i(186953);
    if ((CM() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d))
    {
      AppMethodBeat.o(186953);
      return true;
    }
    boolean bool = super.i(paramInt, paramString);
    AppMethodBeat.o(186953);
    return bool;
  }
  
  public final void z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48258);
    super.z(paramString1, paramString2);
    try
    {
      com.tencent.mm.plugin.appbrand.report.i.b((c)CM(), paramString1, paramString2);
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
        Object localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.Me(((c)b.this.CM()).getAppId()).cfp.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        int i = ((com.tencent.mm.plugin.appbrand.jsapi.a.a.b)localObject).knP.getVirtualElementId();
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", localException, "MagicBrushViewIdTransfer failed. [%d] [%s]", new Object[] { Integer.valueOf(paramInt), ((c)b.this.CM()).getAppId() });
          paramInt = -1;
        }
      }
      AppMethodBeat.o(48256);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b
 * JD-Core Version:    0.7.0.1
 */