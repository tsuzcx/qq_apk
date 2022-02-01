package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m.b;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class a
  extends b
{
  public static final int CTRL_INDEX = 467;
  public static final String NAME = "createLoadSubPackageTask";
  
  private static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(194935);
    a.a.a(paramc, paramString1, "fail", paramString2);
    AppMethodBeat.o(194935);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, final JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(182227);
    final h localh = (h)paramc;
    paramc = paramc.getAppId();
    paramJSONObject = paramJSONObject.optString("moduleName");
    if (bt.isNullOrNil(paramJSONObject))
    {
      ad.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
      a(localh, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    Object localObject = localh.getRuntime();
    if ((localObject == null) || (((AppBrandRuntime)localObject).isDestroyed()))
    {
      ad.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
      a(localh, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    localObject = ((AppBrandRuntime)localObject).jwT;
    if (localObject == null)
    {
      ad.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
      a(localh, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    if ((!((com.tencent.mm.plugin.appbrand.m.a)localObject).btb()) && (!paramJSONObject.equals("__APP__")))
    {
      ad.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
      a(localh, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    try
    {
      ((com.tencent.mm.plugin.appbrand.m.a)localObject).a(paramJSONObject, new a.b()new com.tencent.mm.plugin.appbrand.m.a.a
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(139888);
          ad.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s, with appId[%s] moduleName[%s]", new Object[] { paramAnonymousd.toString(), paramc, paramJSONObject });
          switch (a.3.kWz[paramAnonymousd.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(139888);
            return;
            a.a.a(localh, paramString, "success", paramJSONObject);
            AppMethodBeat.o(139888);
            return;
            a.a.a(localh, paramString, "fail", paramJSONObject);
            AppMethodBeat.o(139888);
            return;
            ad.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
            a.a.a(localh, paramString, "fail", paramJSONObject);
          }
        }
      }, new com.tencent.mm.plugin.appbrand.m.a.a()
      {
        public final void b(com.tencent.mm.plugin.appbrand.m.c paramAnonymousc)
        {
          AppMethodBeat.i(139889);
          ad.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", new Object[] { paramJSONObject, paramAnonymousc.toString() });
          a.a.a(localh, paramString, "progressUpdate", paramJSONObject, paramAnonymousc.getProgress(), paramAnonymousc.baJ(), paramAnonymousc.baK());
          AppMethodBeat.o(139889);
        }
      });
      AppMethodBeat.o(182227);
      return;
    }
    catch (IllegalAccessError paramc)
    {
      ad.printErrStackTrace("MicroMsg.JsApiCreateLoadSubPackageTask", paramc, "loadModule(%s)", new Object[] { paramJSONObject });
      a(localh, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
    }
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(139893);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.o.c.btf();
    localObject = com.tencent.mm.plugin.appbrand.o.c.bte();
    AppMethodBeat.o(139893);
    return localObject;
  }
  
  public final String aeJ()
  {
    return "loadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a
 * JD-Core Version:    0.7.0.1
 */