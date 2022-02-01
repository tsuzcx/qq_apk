package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.plugin.appbrand.p.a.b;
import com.tencent.mm.plugin.appbrand.p.a.d;
import com.tencent.mm.plugin.appbrand.s.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a
  extends b
{
  public static final int CTRL_INDEX = 467;
  public static final String NAME = "createLoadSubPackageTask";
  
  private static void a(e parame, String paramString1, String paramString2)
  {
    AppMethodBeat.i(199240);
    a.a.a(parame, paramString1, "fail", paramString2);
    AppMethodBeat.o(199240);
  }
  
  public final void a(final e parame, final JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(182227);
    final j localj = (j)parame;
    parame = parame.getAppId();
    paramJSONObject = paramJSONObject.optString("moduleName");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
      a(localj, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    Object localObject = localj.getRuntime();
    if ((localObject == null) || (((AppBrandRuntime)localObject).ntU.get()))
    {
      Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
      a(localj, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    localObject = ((AppBrandRuntime)localObject).ntS;
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
      a(localj, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    if ((!((com.tencent.mm.plugin.appbrand.p.a)localObject).cbE()) && (!paramJSONObject.equals("__APP__")))
    {
      Log.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
      a(localj, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    try
    {
      ((com.tencent.mm.plugin.appbrand.p.a)localObject).a(paramJSONObject, new a.b()new com.tencent.mm.plugin.appbrand.p.a.a
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(139888);
          Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s, with appId[%s] moduleName[%s]", new Object[] { paramAnonymousd.toString(), parame, paramJSONObject });
          switch (a.3.pdA[paramAnonymousd.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(139888);
            return;
            a.a.a(localj, paramString, "success", paramJSONObject);
            AppMethodBeat.o(139888);
            return;
            a.a.a(localj, paramString, "fail", paramJSONObject);
            AppMethodBeat.o(139888);
            return;
            Log.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
            a.a.a(localj, paramString, "fail", paramJSONObject);
          }
        }
      }, new com.tencent.mm.plugin.appbrand.p.a.a()
      {
        public final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
        {
          AppMethodBeat.i(199122);
          Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", new Object[] { paramJSONObject, paramAnonymousWxaPkgLoadProgress.toString() });
          a.a.a(localj, paramString, "progressUpdate", paramJSONObject, paramAnonymousWxaPkgLoadProgress.progress, paramAnonymousWxaPkgLoadProgress.nHs, paramAnonymousWxaPkgLoadProgress.nHt);
          AppMethodBeat.o(199122);
        }
      });
      AppMethodBeat.o(182227);
      return;
    }
    catch (IllegalAccessError parame)
    {
      Log.printErrStackTrace("MicroMsg.JsApiCreateLoadSubPackageTask", parame, "loadModule(%s)", new Object[] { paramJSONObject });
      a(localj, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
    }
  }
  
  public final String aBF()
  {
    return "loadTaskId";
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(139893);
    Object localObject = new StringBuilder();
    c.cbO();
    localObject = c.cbN();
    AppMethodBeat.o(139893);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a
 * JD-Core Version:    0.7.0.1
 */