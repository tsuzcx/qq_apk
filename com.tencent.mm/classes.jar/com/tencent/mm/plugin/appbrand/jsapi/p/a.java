package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.a.d;
import com.tencent.mm.plugin.appbrand.t.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a
  extends b
{
  public static final int CTRL_INDEX = 467;
  public static final String NAME = "createLoadSubPackageTask";
  
  private static void a(f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(325621);
    a.a.a(paramf, paramString1, "fail", paramString2);
    AppMethodBeat.o(325621);
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(182227);
    final k localk = (k)paramf;
    paramf = paramf.getAppId();
    paramJSONObject = paramJSONObject.optString("moduleName");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
      a(localk, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    Object localObject = localk.getRuntime();
    if ((localObject == null) || (((AppBrandRuntime)localObject).qsE.get()))
    {
      Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
      a(localk, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    localObject = ((AppBrandRuntime)localObject).qsC;
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
      a(localk, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    if ((!((com.tencent.mm.plugin.appbrand.q.a)localObject).cBX()) && (!paramJSONObject.equals("__APP__")))
    {
      Log.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
      a(localk, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    try
    {
      ((com.tencent.mm.plugin.appbrand.q.a)localObject).a(paramJSONObject, new a.b()new a.2
      {
        public final void onLoadResult(a.d paramAnonymousd)
        {
          AppMethodBeat.i(139888);
          Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s, with appId[%s] moduleName[%s]", new Object[] { paramAnonymousd.toString(), paramf, paramJSONObject });
          switch (a.3.siN[paramAnonymousd.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(139888);
            return;
            a.a.a(localk, paramString, "success", paramJSONObject);
            AppMethodBeat.o(139888);
            return;
            a.a.a(localk, paramString, "fail", paramJSONObject);
            AppMethodBeat.o(139888);
            return;
            Log.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
            a.a.a(localk, paramString, "fail", paramJSONObject);
          }
        }
      }, new a.2(this, paramJSONObject, localk, paramString), false);
      AppMethodBeat.o(182227);
      return;
    }
    catch (IllegalAccessError paramf)
    {
      Log.printErrStackTrace("MicroMsg.JsApiCreateLoadSubPackageTask", paramf, "loadModule(%s)", new Object[] { paramJSONObject });
      a(localk, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
    }
  }
  
  public final String aUD()
  {
    return "loadTaskId";
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(139893);
    Object localObject = new StringBuilder();
    c.cCh();
    localObject = c.cCg();
    AppMethodBeat.o(139893);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a
 * JD-Core Version:    0.7.0.1
 */