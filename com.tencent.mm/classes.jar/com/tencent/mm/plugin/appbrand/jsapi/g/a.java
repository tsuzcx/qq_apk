package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n.a.b;
import com.tencent.mm.plugin.appbrand.n.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.j.c
{
  public static final int CTRL_INDEX = 467;
  public static final String NAME = "createLoadSubPackageTask";
  String imk = "";
  String kAp = "";
  long mTotalSize = -1L;
  
  private void t(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(139895);
    a.a(paramc, this.imk, "fail", this.kAp);
    AppMethodBeat.o(139895);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final String paramString)
  {
    AppMethodBeat.i(182227);
    paramString = (h)paramc;
    paramc = paramc.getAppId();
    this.kAp = paramJSONObject.optString("moduleName");
    if (bs.isNullOrNil(this.kAp))
    {
      ac.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: null or nil moduleName");
      t(paramString);
      AppMethodBeat.o(182227);
      return;
    }
    paramJSONObject = paramString.getRuntime();
    if ((paramJSONObject == null) || (paramJSONObject.isDestroyed()))
    {
      ac.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: runtime is not in valid state!");
      t(paramString);
      AppMethodBeat.o(182227);
      return;
    }
    paramJSONObject = paramJSONObject.jdL;
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: modularizingHelper null!");
      t(paramString);
      AppMethodBeat.o(182227);
      return;
    }
    if ((!paramJSONObject.bpc()) && (!this.kAp.equals("__APP__")))
    {
      ac.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: not support modularizing but still called JsApiCreateLoadSubPackageTask");
      t(paramString);
      AppMethodBeat.o(182227);
      return;
    }
    try
    {
      paramJSONObject.a(this.kAp, new a.b()new com.tencent.mm.plugin.appbrand.n.a.a
      {
        public final void a(a.d paramAnonymousd)
        {
          AppMethodBeat.i(139888);
          ac.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s, with appId[%s] moduleName[%s]", new Object[] { paramAnonymousd.toString(), paramc, a.this.kAp });
          switch (a.3.kAr[paramAnonymousd.ordinal()])
          {
          }
          for (;;)
          {
            AppMethodBeat.o(139888);
            return;
            a.a.a(paramString, a.this.imk, "success", a.this.kAp);
            AppMethodBeat.o(139888);
            return;
            a.a.a(paramString, a.this.imk, "fail", a.this.kAp);
            AppMethodBeat.o(139888);
            return;
            ac.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
            a.a.a(paramString, a.this.imk, "fail", a.this.kAp);
          }
        }
      }, new com.tencent.mm.plugin.appbrand.n.a.a()
      {
        public final void b(com.tencent.mm.plugin.appbrand.n.c paramAnonymousc)
        {
          AppMethodBeat.i(139889);
          ac.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: module name: %s progress: %s", new Object[] { a.this.kAp, paramAnonymousc.toString() });
          a.this.mTotalSize = paramAnonymousc.aXm();
          a.a.a(paramString, a.this.imk, "progressUpdate", a.this.kAp, paramAnonymousc.getProgress(), paramAnonymousc.aXl(), paramAnonymousc.aXm());
          AppMethodBeat.o(139889);
        }
      });
      AppMethodBeat.o(182227);
      return;
    }
    catch (IllegalAccessError paramc)
    {
      ac.printErrStackTrace("MicroMsg.JsApiCreateLoadSubPackageTask", paramc, "loadModule(%s)", new Object[] { this.kAp });
      t(paramString);
      AppMethodBeat.o(182227);
    }
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(139893);
    if (bs.isNullOrNil(this.imk))
    {
      localObject = new StringBuilder();
      com.tencent.mm.plugin.appbrand.p.c.bpg();
      this.imk = com.tencent.mm.plugin.appbrand.p.c.bpf();
    }
    Object localObject = this.imk;
    AppMethodBeat.o(139893);
    return localObject;
  }
  
  public final String acf()
  {
    return "loadTaskId";
  }
  
  public static final class a
    extends p
  {
    public static final int CTRL_INDEX = 468;
    public static final String NAME = "onLoadSubPackageTaskStateChange";
    
    static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(139891);
      a(paramc, paramString1, paramString2, paramString3, -1, -1L, -1L);
      AppMethodBeat.o(139891);
    }
    
    static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(139892);
      ac.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: formatEventCallback taskId: %s, state: %s, progress: %d, currentWritten: %d, totalWritten: %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
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
      new a().g(paramc).LN(paramString1).beN();
      AppMethodBeat.o(139892);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a
 * JD-Core Version:    0.7.0.1
 */