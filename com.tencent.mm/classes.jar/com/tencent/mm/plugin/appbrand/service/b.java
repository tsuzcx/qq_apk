package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.ac;
import com.tencent.mm.plugin.appbrand.jsruntime.p;
import com.tencent.mm.plugin.appbrand.jsruntime.p.a;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.jsruntime.w;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.jsruntime.z;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.sdk.b.a.c.b<c>
{
  private com.tencent.mm.plugin.appbrand.r.b.a luB = null;
  com.tencent.luggage.game.a.c luC = null;
  
  public b(c paramc)
  {
    super(paramc);
  }
  
  public final com.tencent.mm.plugin.appbrand.jsruntime.i BI()
  {
    Object localObject3 = null;
    AppMethodBeat.i(48257);
    final long l = System.currentTimeMillis();
    if (((c)Dj()).getContext() == null) {
      aj.getContext();
    }
    if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plN, false)) {}
    for (Object localObject2 = ac.aWU();; localObject2 = null)
    {
      Object localObject1;
      if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.plM, false)) {
        if (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
          localObject1 = com.tencent.mm.plugin.appbrand.aa.d.Nf("wxa_library/v8_snapshot64.bin");
        }
      }
      for (;;)
      {
        int i = ((c)Dj()).aLC().aPc();
        ak.aNM();
        boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.j.jqn.ajp()).booleanValue();
        boolean bool1;
        if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.i.jqm.ajp()).booleanValue())
        {
          bool1 = true;
          label139:
          localObject2 = w.a(i, (String)localObject2, (byte[])localObject1, bool2, bool1, z.o((com.tencent.mm.plugin.appbrand.q)Dj()), (com.tencent.mm.plugin.appbrand.jsapi.d)Dj());
          if ((localObject2 instanceof x))
          {
            this.luB = new com.tencent.mm.plugin.appbrand.r.a();
            this.luB.a((com.tencent.mm.plugin.appbrand.q)Dj(), (com.tencent.mm.plugin.appbrand.jsruntime.i)localObject2);
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
              com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
              if (this.jpN) {}
              for (com.tencent.mm.plugin.appbrand.task.e locale = com.tencent.mm.plugin.appbrand.task.e.lwx;; locale = null)
              {
                com.tencent.mm.plugin.appbrand.report.quality.b.a(locale, this.val$appId, l, com.tencent.mm.plugin.appbrand.report.c.d(this.chy));
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
          localObject1 = com.tencent.mm.plugin.appbrand.aa.d.Nf("wxa_library/v8_snapshot.bin");
          break;
          bool1 = false;
          break label139;
          label286:
          com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
          localObject1 = localObject3;
          if (((c)Dj()).aNv()) {
            localObject1 = com.tencent.mm.plugin.appbrand.task.e.lwx;
          }
          com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.task.e)localObject1, ((c)Dj()).getAppId(), l, com.tencent.mm.plugin.appbrand.report.c.d((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject2));
        }
        localObject1 = null;
      }
    }
  }
  
  public final void BJ()
  {
    AppMethodBeat.i(48264);
    super.BJ();
    if (z.o((com.tencent.mm.plugin.appbrand.q)Dj()))
    {
      ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "service initNativeTransLogic");
      z.a(((c)Dj()).aOf(), ((c)Dj()).aOd(), getAppId());
      z.a(((c)Dj()).aOf(), ((c)Dj()).aOd(), ((c)Dj()).aOd(), getAppId());
    }
    Object localObject = ((c)Dj()).aOf();
    if (this.luC != null)
    {
      bool = true;
      ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.luC == null) {
        if (!(Dj() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d)) {
          break label311;
        }
      }
    }
    label311:
    for (boolean bool = false;; bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pod, true))
    {
      if (bool)
      {
        com.tencent.magicbrush.a.b.loadLibraries();
        com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
        this.luC = new com.tencent.luggage.game.a.c(((c)Dj()).getContext(), (com.tencent.mm.plugin.appbrand.jsruntime.i)localObject)
        {
          public final void a(com.tencent.magicbrush.d paramAnonymousd, long paramAnonymousLong)
          {
            AppMethodBeat.i(175070);
            com.tencent.mm.plugin.appbrand.report.quality.a.bmM();
            com.tencent.mm.plugin.appbrand.report.quality.b.a(((c)b.this.Dj()).aNv(), ((c)b.this.Dj()).getAppId(), paramAnonymousLong);
            AppMethodBeat.o(175070);
          }
          
          public final void a(com.tencent.magicbrush.e paramAnonymouse)
          {
            AppMethodBeat.i(175069);
            super.a(paramAnonymouse);
            paramAnonymouse.Y(com.tencent.mm.plugin.appbrand.game.a.d.jqa.df(((c)b.this.Dj()).getContext()));
            paramAnonymouse.bO(false);
            paramAnonymouse.bQ(((Boolean)com.tencent.mm.plugin.appbrand.game.a.g.jqg.ajp()).booleanValue());
            paramAnonymouse.bR(((Boolean)com.tencent.mm.plugin.appbrand.game.a.i.jqm.ajp()).booleanValue());
            AppMethodBeat.o(175069);
          }
        };
        this.luC.Bs();
        this.luC.getMagicBrush().coN = new com.tencent.magicbrush.handler.b()
        {
          public final String a(final String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(180360);
            if (b.this.Dj() == null)
            {
              AppMethodBeat.o(180360);
              return "";
            }
            try
            {
              paramAnonymousString1 = ((c)b.this.Dj()).b(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt, paramAnonymousBoolean);
              AppMethodBeat.o(180360);
              return paramAnonymousString1;
            }
            catch (Throwable paramAnonymousString1)
            {
              ad.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", paramAnonymousString1, "IMBInvokeHandler.invoke", new Object[0]);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  throw paramAnonymousString1;
                }
              });
              AppMethodBeat.o(180360);
            }
            return "";
          }
          
          public final String[] getAsyncableJsApis()
          {
            AppMethodBeat.i(180361);
            if (b.this.Dj() == null)
            {
              AppMethodBeat.o(180361);
              return null;
            }
            String[] arrayOfString = ((c)b.this.Dj()).getAsyncableJsApis();
            AppMethodBeat.o(180361);
            return arrayOfString;
          }
        };
        if (((c)Dj()).isRunning()) {
          this.luC.b(((c)Dj()).getRuntime());
        }
        ((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject).addJavascriptInterface(new a((byte)0), "MagicBrushViewIdTransfer");
      }
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((c)Dj()).aOf().P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175068);
            if (((c)b.this.Dj()).aOf() == null)
            {
              ad.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "jsruntime is null, return");
              AppMethodBeat.o(175068);
              return;
            }
            v localv = (v)((c)b.this.Dj()).aOf().P(v.class);
            com.tencent.mm.plugin.appbrand.jsapi.aa.b.c.H(localv.getIsolatePtr(), localv.LU());
            AppMethodBeat.o(175068);
          }
        });
      }
      AppMethodBeat.o(48264);
      return;
      bool = false;
      break;
    }
  }
  
  public final void BK()
  {
    AppMethodBeat.i(48262);
    super.BK();
    if (this.luC != null) {
      this.luC.destroy();
    }
    AppMethodBeat.o(48262);
  }
  
  public final void BL()
  {
    AppMethodBeat.i(48263);
    if (this.luB != null) {
      this.luB.biK();
    }
    AppMethodBeat.o(48263);
  }
  
  public final String BW()
  {
    AppMethodBeat.i(48260);
    if ((this.luC != null) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.ppf, true))) {}
    for (Object localObject = "" + "var openInvokeHandlerJsBinding = true;";; localObject = "")
    {
      String str = (String)localObject + super.BW();
      localObject = str;
      if (this.luB != null) {
        localObject = str + this.luB.biL();
      }
      localObject = (String)localObject + com.tencent.mm.plugin.appbrand.jsapi.aa.b.c.bff();
      if (this.luC != null) {}
      for (localObject = (String)localObject + com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/NativeGlobal-WAService.js");; localObject = (String)localObject + com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/NativeGlobal-Dummy.js"))
      {
        AppMethodBeat.o(48260);
        return localObject;
      }
    }
  }
  
  public final int BX()
  {
    AppMethodBeat.i(48268);
    int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pul, 0);
    AppMethodBeat.o(48268);
    return i;
  }
  
  public final Map<String, m> CD()
  {
    AppMethodBeat.i(48261);
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandMiniProgramServiceLogicImpWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(48261);
    return localMap;
  }
  
  public final void Ca()
  {
    AppMethodBeat.i(196106);
    super.Ca();
    AppMethodBeat.o(196106);
  }
  
  public final void Cb()
  {
    AppMethodBeat.i(196107);
    super.Cb();
    AppMethodBeat.o(196107);
  }
  
  public final void DF()
  {
    AppMethodBeat.i(48267);
    Object localObject1 = s.luM;
    if (s.c((c)Dj()))
    {
      final long l = System.currentTimeMillis();
      localObject1 = s.luM;
      localObject1 = s.bng();
      Object localObject2 = s.luM;
      localObject2 = s.bnh();
      Object localObject3 = s.luM;
      localObject3 = s.bni();
      ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript name:%s", new Object[] { localObject1 });
      ad.v("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript jsSource:%s", new Object[] { localObject2 });
      final d.a locala = new d.a();
      locala.scriptName = ((String)localObject1);
      locala.cgh = ((String)localObject2);
      locala.cgj = ((String)localObject2).length();
      com.tencent.mm.plugin.appbrand.utils.q.a(((c)Dj()).aOf(), "https://lib/" + (String)localObject1, "", "", 0, (String)localObject2, (String)localObject3, new q.a()
      {
        public final void cj(String paramAnonymousString)
        {
          AppMethodBeat.i(175073);
          ((c)b.this.Dj()).a(locala, false, l, System.currentTimeMillis(), null);
          ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onFailure ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(175073);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(175072);
          ((c)b.this.Dj()).a(locala, true, l, System.currentTimeMillis(), null);
          ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onSuccess ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(175072);
        }
      });
    }
    AppMethodBeat.o(48267);
  }
  
  public final com.tencent.luggage.sdk.b.a.c.a a(t paramt)
  {
    AppMethodBeat.i(160614);
    ak.aNM();
    paramt = new a((c)Dj(), paramt);
    AppMethodBeat.o(160614);
    return paramt;
  }
  
  public final void bw(boolean paramBoolean)
  {
    AppMethodBeat.i(175074);
    if (!paramBoolean)
    {
      String str = com.tencent.mm.plugin.appbrand.jsapi.aa.b.c.JS(((c)Dj()).getAppId());
      com.tencent.mm.plugin.appbrand.utils.q.a(((c)Dj()).aOf(), str, new q.a()
      {
        public final void cj(String paramAnonymousString)
        {
          AppMethodBeat.i(175066);
          ad.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "Inject skiaCanvasUpdateScript Script Failed");
          AppMethodBeat.o(175066);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(175065);
          ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "Inject skiaCanvasUpdateScript Script Success");
          AppMethodBeat.o(175065);
        }
      });
    }
    AppMethodBeat.o(175074);
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48265);
    super.c(paramAppBrandRuntime);
    if (this.luC != null) {
      this.luC.b(paramAppBrandRuntime);
    }
    AppMethodBeat.o(48265);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48266);
    super.c(paramJSONObject);
    s locals = s.luM;
    boolean bool = s.c((c)Dj());
    try
    {
      paramJSONObject.put("exportBaseMethods", bool);
      paramJSONObject.put("supressOffscreenPatch", true);
      ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods:%b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(48266);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods e:%s", new Object[] { paramJSONObject });
      }
    }
  }
  
  public final boolean d(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(196108);
    if ((Dj() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d))
    {
      AppMethodBeat.o(196108);
      return true;
    }
    boolean bool = super.d(paramString1, paramString2, paramInt);
    AppMethodBeat.o(196108);
    return bool;
  }
  
  public final boolean i(int paramInt, String paramString)
  {
    AppMethodBeat.i(196109);
    if ((Dj() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.d))
    {
      AppMethodBeat.o(196109);
      return true;
    }
    boolean bool = super.i(paramInt, paramString);
    AppMethodBeat.o(196109);
    return bool;
  }
  
  public final void y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48258);
    super.y(paramString1, paramString2);
    try
    {
      com.tencent.mm.plugin.appbrand.report.j.b((c)Dj(), paramString1, paramString2);
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
        Object localObject = com.tencent.mm.plugin.appbrand.jsapi.b.a.HZ(((c)b.this.Dj()).getAppId()).cit.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          k.fvU();
        }
        int i = ((a.b)localObject).jNo.getVirtualElementId();
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", localException, "MagicBrushViewIdTransfer failed. [%d] [%s]", new Object[] { Integer.valueOf(paramInt), ((c)b.this.Dj()).getAppId() });
          paramInt = -1;
        }
      }
      AppMethodBeat.o(48256);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b
 * JD-Core Version:    0.7.0.1
 */