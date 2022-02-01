package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.p.a.b;
import com.tencent.mm.plugin.appbrand.p.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends b
{
  public static final int CTRL_INDEX = 467;
  public static final String NAME = "createLoadSubPackageTask";
  
  private static void a(f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230539);
    a.a(paramf, paramString1, "fail", paramString2);
    AppMethodBeat.o(230539);
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
    if ((localObject == null) || (((AppBrandRuntime)localObject).isDestroyed()))
    {
      Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
      a(localk, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    localObject = ((AppBrandRuntime)localObject).kAI;
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
      a(localk, paramString, paramJSONObject);
      AppMethodBeat.o(182227);
      return;
    }
    if ((!((com.tencent.mm.plugin.appbrand.p.a)localObject).bPn()) && (!paramJSONObject.equals("__APP__")))
    {
      Log.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
      a(localk, paramString, paramJSONObject);
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
          Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s, with appId[%s] moduleName[%s]", new Object[] { paramAnonymousd.toString(), paramf, paramJSONObject });
          switch (a.3.mfu[paramAnonymousd.ordinal()])
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
      }, new com.tencent.mm.plugin.appbrand.p.a.a()
      {
        public final void b(com.tencent.mm.plugin.appbrand.p.c paramAnonymousc)
        {
          AppMethodBeat.i(139889);
          Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", new Object[] { paramJSONObject, paramAnonymousc.toString() });
          a.a.a(localk, paramString, "progressUpdate", paramJSONObject, paramAnonymousc.getProgress(), paramAnonymousc.bww(), paramAnonymousc.getTotalLength());
          AppMethodBeat.o(139889);
        }
      });
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
  
  public final String auJ()
  {
    return "loadTaskId";
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(139893);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.s.c.bPx();
    localObject = com.tencent.mm.plugin.appbrand.s.c.bPw();
    AppMethodBeat.o(139893);
    return localObject;
  }
  
  public static final class a
    extends s
  {
    public static final int CTRL_INDEX = 468;
    public static final String NAME = "onLoadSubPackageTaskStateChange";
    
    static void a(f paramf, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(139891);
      a(paramf, paramString1, paramString2, paramString3, -1, -1L, -1L);
      AppMethodBeat.o(139891);
    }
    
    static void a(f paramf, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(139892);
      Log.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      HashMap localHashMap = new HashMap();
      localHashMap.put("taskId", paramString1);
      localHashMap.put("state", paramString2);
      localHashMap.put("moduleName", paramString3);
      if (paramInt >= 0) {
        localHashMap.put("progress", Integer.valueOf(paramInt));
      }
      if (paramLong1 >= 0L) {
        localHashMap.put("totalBytesWritten", Long.valueOf(paramLong1));
      }
      if (paramLong2 >= 0L) {
        localHashMap.put("totalBytesExpectedToWrite", Long.valueOf(paramLong2));
      }
      paramString1 = new JSONObject(localHashMap).toString();
      new a().g(paramf).Zg(paramString1).bEo();
      AppMethodBeat.o(139892);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a
 * JD-Core Version:    0.7.0.1
 */