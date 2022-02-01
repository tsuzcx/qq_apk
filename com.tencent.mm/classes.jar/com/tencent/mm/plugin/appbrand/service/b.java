package com.tencent.mm.plugin.appbrand.service;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.jsapi.a.a.b;
import com.tencent.mm.plugin.appbrand.jsruntime.ac;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.w;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.jsruntime.z;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends com.tencent.luggage.sdk.b.a.c.b<c>
{
  private com.tencent.mm.plugin.appbrand.q.b.a mwj = null;
  com.tencent.luggage.game.a.c mwk = null;
  
  public b(c paramc)
  {
    super(paramc);
  }
  
  public final i CL()
  {
    Object localObject3 = null;
    AppMethodBeat.i(48257);
    long l = System.currentTimeMillis();
    if (((c)El()).getContext() == null) {
      aj.getContext();
    }
    if (!((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qti, false)) {}
    for (Object localObject2 = ac.bhw();; localObject2 = null)
    {
      Object localObject1;
      if (!((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qth, false)) {
        if (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
          localObject1 = com.tencent.mm.plugin.appbrand.z.d.UU("wxa_library/v8_snapshot64.bin");
        }
      }
      for (;;)
      {
        int i = ((c)El()).aVF().aZp();
        ak.aXO();
        boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.m.kkR.ate()).booleanValue();
        boolean bool1;
        if (!((Boolean)l.kkQ.ate()).booleanValue())
        {
          bool1 = true;
          label139:
          localObject2 = w.a(i, (String)localObject2, (byte[])localObject1, bool2, bool1, z.o((com.tencent.mm.plugin.appbrand.q)El()), (com.tencent.mm.plugin.appbrand.jsapi.d)El());
          if ((localObject2 instanceof x))
          {
            this.mwj = new com.tencent.mm.plugin.appbrand.q.a();
            this.mwj.a((com.tencent.mm.plugin.appbrand.q)El(), (i)localObject2);
          }
          localObject1 = (com.tencent.mm.plugin.appbrand.jsruntime.p)((i)localObject2).P(com.tencent.mm.plugin.appbrand.jsruntime.p.class);
          if (localObject1 == null) {
            break label286;
          }
          ((com.tencent.mm.plugin.appbrand.jsruntime.p)localObject1).a(new b.1(this, ((c)El()).aXu(), ((c)El()).getAppId(), l, (i)localObject2));
        }
        for (;;)
        {
          AppMethodBeat.o(48257);
          return localObject2;
          localObject1 = com.tencent.mm.plugin.appbrand.z.d.UU("wxa_library/v8_snapshot.bin");
          break;
          bool1 = false;
          break label139;
          label286:
          com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
          localObject1 = localObject3;
          if (((c)El()).aXu()) {
            localObject1 = com.tencent.mm.plugin.appbrand.task.e.myg;
          }
          com.tencent.mm.plugin.appbrand.report.quality.b.a((com.tencent.mm.plugin.appbrand.task.e)localObject1, ((c)El()).getAppId(), l, com.tencent.mm.plugin.appbrand.report.d.d((i)localObject2));
        }
        localObject1 = null;
      }
    }
  }
  
  public final void CM()
  {
    AppMethodBeat.i(48264);
    super.CM();
    if (z.o((com.tencent.mm.plugin.appbrand.q)El()))
    {
      ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "service initNativeTransLogic");
      z.a(((c)El()).aYh(), ((c)El()).aXC(), getAppId());
      z.a(((c)El()).aYh(), ((c)El()).aXC(), ((c)El()).aXC(), getAppId());
    }
    i locali = ((c)El()).aYh();
    if (this.mwk != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
      if (this.mwk == null) {
        break;
      }
      AppMethodBeat.o(48264);
      return;
    }
    if ((El() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e)) {}
    for (bool = false;; bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwa, true))
    {
      if (bool)
      {
        com.tencent.magicbrush.a.b.loadLibraries();
        com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
        this.mwk = new b.3(this, ((c)El()).getContext(), locali);
        this.mwk.Cv();
        this.mwk.getMagicBrush().cwu = new b.4(this);
        if (((c)El()).isRunning()) {
          this.mwk.b(((c)El()).getRuntime());
        }
        locali.addJavascriptInterface(new a((byte)0), "MagicBrushViewIdTransfer");
      }
      AppMethodBeat.o(48264);
      return;
    }
  }
  
  public final void CN()
  {
    AppMethodBeat.i(48262);
    super.CN();
    if (this.mwk != null) {
      this.mwk.destroy();
    }
    AppMethodBeat.o(48262);
  }
  
  public final void CO()
  {
    AppMethodBeat.i(48263);
    if (this.mwj != null) {
      this.mwj.btE();
    }
    AppMethodBeat.o(48263);
  }
  
  public final String CZ()
  {
    AppMethodBeat.i(48260);
    if ((this.mwk != null) && (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxu, true))) {}
    for (Object localObject = "" + "var openInvokeHandlerJsBinding = true;";; localObject = "")
    {
      String str = (String)localObject + super.CZ();
      localObject = str;
      if (this.mwj != null) {
        localObject = str + this.mwj.btF();
      }
      if (this.mwk != null) {}
      for (localObject = (String)localObject + com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/NativeGlobal-WAService.js");; localObject = (String)localObject + com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/NativeGlobal-Dummy.js"))
      {
        AppMethodBeat.o(48260);
        return localObject;
      }
    }
  }
  
  public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> DG()
  {
    AppMethodBeat.i(48261);
    if ((El() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      localMap = com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.j.bst();
      AppMethodBeat.o(48261);
      return localMap;
    }
    Map localMap = (Map)com.tencent.luggage.sdk.g.c.a("AppBrandMiniProgramServiceLogicImpWC.onCreateJsApiPool()", new d.g.a.a() {});
    AppMethodBeat.o(48261);
    return localMap;
  }
  
  public final int Da()
  {
    AppMethodBeat.i(48268);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDK, 0);
    AppMethodBeat.o(48268);
    return i;
  }
  
  public final void Dd()
  {
    AppMethodBeat.i(188751);
    super.Dd();
    AppMethodBeat.o(188751);
  }
  
  public final void De()
  {
    AppMethodBeat.i(188752);
    super.De();
    AppMethodBeat.o(188752);
  }
  
  public final void EH()
  {
    AppMethodBeat.i(48267);
    Object localObject1 = t.mwv;
    if (t.d((c)El()))
    {
      final long l = System.currentTimeMillis();
      localObject1 = t.mwv;
      localObject1 = t.byh();
      Object localObject2 = t.mwv;
      localObject2 = t.byi();
      Object localObject3 = t.mwv;
      localObject3 = t.byj();
      ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript name:%s", new Object[] { localObject1 });
      ad.v("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript jsSource:%s", new Object[] { localObject2 });
      final d.a locala = new d.a();
      locala.scriptName = ((String)localObject1);
      locala.cnv = ((String)localObject2);
      locala.cnw = ((String)localObject2).length();
      com.tencent.mm.plugin.appbrand.utils.q.a(((c)El()).aYh(), "https://lib/" + (String)localObject1, "", "", 0, (String)localObject2, (String)localObject3, new q.a()
      {
        public final void cT(String paramAnonymousString)
        {
          AppMethodBeat.i(188750);
          ((c)b.this.El()).a(locala, false, l, System.currentTimeMillis(), null);
          ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onFailure ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(188750);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(188749);
          ((c)b.this.El()).a(locala, true, l, System.currentTimeMillis(), null);
          ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onSuccess ret:%s", new Object[] { paramAnonymousString });
          AppMethodBeat.o(188749);
        }
      });
    }
    AppMethodBeat.o(48267);
  }
  
  public final com.tencent.luggage.sdk.b.a.c.a a(com.tencent.mm.plugin.appbrand.jsruntime.t paramt)
  {
    AppMethodBeat.i(160614);
    ak.aXO();
    paramt = new a((c)El(), paramt);
    AppMethodBeat.o(160614);
    return paramt;
  }
  
  public final void c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48265);
    super.c(paramAppBrandRuntime);
    if (this.mwk != null) {
      this.mwk.b(paramAppBrandRuntime);
    }
    AppMethodBeat.o(48265);
  }
  
  public final void c(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48266);
    super.c(paramJSONObject);
    t localt = t.mwv;
    boolean bool = t.d((c)El());
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
    AppMethodBeat.i(188753);
    if ((El() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(188753);
      return true;
    }
    boolean bool = super.d(paramString1, paramString2, paramInt);
    AppMethodBeat.o(188753);
    return bool;
  }
  
  public final boolean i(int paramInt, String paramString)
  {
    AppMethodBeat.i(188754);
    if ((El() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e))
    {
      AppMethodBeat.o(188754);
      return true;
    }
    boolean bool = super.i(paramInt, paramString);
    AppMethodBeat.o(188754);
    return bool;
  }
  
  public final void z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48258);
    super.z(paramString1, paramString2);
    try
    {
      com.tencent.mm.plugin.appbrand.report.j.b((c)El(), paramString1, paramString2);
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
        Object localObject = com.tencent.mm.plugin.appbrand.jsapi.a.a.PA(((c)b.this.El()).getAppId()).cpF.get(Integer.valueOf(paramInt));
        if (localObject == null) {
          d.g.b.p.gfZ();
        }
        int i = ((a.b)localObject).kIP.getVirtualElementId();
        paramInt = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", localException, "MagicBrushViewIdTransfer failed. [%d] [%s]", new Object[] { Integer.valueOf(paramInt), ((c)b.this.El()).getAppId() });
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