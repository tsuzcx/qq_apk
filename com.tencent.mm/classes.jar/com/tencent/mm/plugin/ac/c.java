package com.tencent.mm.plugin.ac;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import d.l;
import d.o;
import d.u;
import d.z;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "()V", "contextJson", "Lcom/tencent/mm/json/JSONObject;", "kotlin.jvm.PlatformType", "getContextJson", "()Lcom/tencent/mm/json/JSONObject;", "contextJson$delegate", "Lkotlin/Lazy;", "contextMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "engineMap", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "initStartTime", "", "getInitStartTime", "()J", "meta", "getMeta", "meta$delegate", "version", "getVersion", "()I", "version$delegate", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)Lcom/tencent/mm/json/JSONObject;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "config", "", "cb", "Lkotlin/Function1;", "configClient", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "name", "appId", "bizPkg", "type", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "getCacheCategory", "path", "onError", "contextId", "message", "stackTrace", "readFile", "setup", "clientReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "cache", "", "Companion", "webview-sdk_release"})
public abstract class c
  extends x
{
  public static final c.a DRV = new c.a((byte)0);
  private static final String TAG = "MicroMsg.WebJsEngine";
  private final d.f DRR;
  private final d.f DRS;
  private final d.f DRT;
  private final HashMap<String, Integer> DRU;
  protected final long gDi;
  private final HashMap<String, Integer> orC;
  
  public c()
  {
    long l = System.currentTimeMillis();
    ae.d(TAG, "performance: initStartTime");
    this.gDi = l;
    this.orC = new HashMap();
    this.DRR = d.g.O((d.g.a.a)new c.d(this));
    this.DRS = d.g.O((d.g.a.a)new c.c(this));
    this.DRT = d.g.O((d.g.a.a)new c.h(this));
    this.DRU = new HashMap();
  }
  
  /* Error */
  private static String a(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokeinterface 164 2 0
    //   9: checkcast 166	java/io/Closeable
    //   12: astore_3
    //   13: aload_3
    //   14: checkcast 168	java/io/InputStream
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 170
    //   21: invokestatic 176	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   24: new 178	java/lang/String
    //   27: dup
    //   28: aload_0
    //   29: invokestatic 184	d/f/a:X	(Ljava/io/InputStream;)[B
    //   32: getstatic 190	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   35: invokespecial 193	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   38: astore_0
    //   39: aload_3
    //   40: aconst_null
    //   41: invokestatic 198	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_1
    //   47: aload_1
    //   48: athrow
    //   49: astore_0
    //   50: aload_3
    //   51: aload_1
    //   52: invokestatic 198	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   55: aload_0
    //   56: athrow
    //   57: astore_0
    //   58: aload_2
    //   59: astore_1
    //   60: goto -10 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramp	com.tencent.mm.plugin.appbrand.appcache.p
    //   0	63	1	paramString	String
    //   1	58	2	localObject	Object
    //   12	39	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   13	39	46	java/lang/Throwable
    //   47	49	49	finally
    //   13	39	57	finally
  }
  
  private final void a(com.tencent.mm.ab.i parami, final com.tencent.mm.plugin.appbrand.jsruntime.g paramg, final h paramh, boolean paramBoolean, final String paramString1, final String paramString2, d.g.a.b<? super String, z> paramb)
  {
    str1 = paramString1 + " :" + paramg.bqQ();
    try
    {
      paramg.setJsExceptionHandler((com.tencent.mm.plugin.appbrand.jsruntime.h)new e(paramg, this, str1, paramh, paramString2, paramString1));
      paramg.addJavascriptInterface(new c.f(this, str1, paramh, paramString2, paramString1), "console");
      Object localObject;
      URL localURL;
      String str2;
      int i;
      String str3;
      for (;;) {}
    }
    catch (Exception parami)
    {
      try
      {
        if (parami.has("dependencies"))
        {
          localObject = parami.xv("dependencies");
          if (localObject != null) {
            com.tencent.mm.plugin.webview.k.a.a((com.tencent.mm.ab.f)localObject, (d.g.a.m)new g(this, paramg, str1));
          }
        }
      }
      catch (Exception parami)
      {
        paramh.a((h.i)new h.a());
        paramg = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.aP(paramString2, paramString1, parami.getMessage());
        ae.printErrStackTrace(TAG, (Throwable)parami, "context setup dependencies ".concat(String.valueOf(str1)), new Object[0]);
        throw ((Throwable)parami);
      }
      try
      {
        localObject = parami.getString("path");
        localURL = new URL("https://ws/lib/".concat(String.valueOf(localObject)));
        d.g.b.p.g(localObject, "path");
        str2 = kI("base", (String)localObject);
        i = ((Number)this.DRT.getValue()).intValue();
        str3 = a(eOF(), (String)localObject);
        if (paramb == null) {
          break label497;
        }
        paramb = new e(paramb);
        paramg.a(localURL, str2, String.valueOf(i), 0, str3, (ValueCallback)paramb);
        if (paramBoolean)
        {
          paramb = (Map)this.orC;
          parami = parami.getString("name");
          d.g.b.p.g(parami, "getString(\"name\")");
          paramb.put(parami, Integer.valueOf(paramg.bqQ()));
        }
        ae.i(TAG, "client setup succ " + str1 + " from " + (String)localObject);
        return;
      }
      catch (Exception parami)
      {
        paramh.a((h.i)new h.e());
        paramg = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.aP(paramString2, paramString1, parami.getMessage());
        ae.printErrStackTrace(TAG, (Throwable)parami, "context setup inject script ".concat(String.valueOf(str1)), new Object[0]);
        throw ((Throwable)parami);
      }
      parami = parami;
      paramh.a((h.i)new h.c());
      ae.printErrStackTrace(TAG, (Throwable)parami, "context setup jsapi ".concat(String.valueOf(str1)), new Object[0]);
      paramg = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.aP(paramString2, paramString1, parami.getMessage());
      throw ((Throwable)parami);
    }
  }
  
  public static int b(com.tencent.mm.plugin.appbrand.appcache.p paramp)
  {
    d.g.b.p.h(paramp, "$this$version");
    return c(paramp).optInt("version");
  }
  
  protected static com.tencent.mm.ab.i c(com.tencent.mm.plugin.appbrand.appcache.p paramp)
  {
    d.g.b.p.h(paramp, "$this$meta");
    return new com.tencent.mm.ab.i(a(paramp, "/meta.json"));
  }
  
  private final com.tencent.mm.ab.i ePj()
  {
    return (com.tencent.mm.ab.i)this.DRS.getValue();
  }
  
  private static String kI(String paramString1, String paramString2)
  {
    return paramString1 + ':' + URLEncoder.encode(paramString2);
  }
  
  public final void G(final d.g.a.b<? super String, z> paramb)
  {
    eOE().a((i.o)new i.i());
    localObject = ePj();
    try
    {
      eOE().a((i.o)new i.m());
      com.tencent.mm.ab.i locali = ((com.tencent.mm.ab.i)localObject).xx("main");
      com.tencent.mm.plugin.appbrand.jsruntime.g localg = bqR();
      d.g.b.p.g(localg, "mainJsContext");
      h localh = new h(locali.getLong("idKey"), h.j.DSp);
      String str = locali.optString("name");
      d.g.b.p.g(str, "optString(\"name\")");
      a(locali, localg, localh, true, str, "wxfedb0854e2b1820d", paramb);
      eOE().a((i.o)new i.n());
      return;
    }
    catch (Exception paramb)
    {
      try
      {
        eOE().a((i.o)new i.g());
        localObject = ((com.tencent.mm.ab.i)localObject).xv("engine");
        if (localObject != null) {
          com.tencent.mm.plugin.webview.k.a.a((com.tencent.mm.ab.f)localObject, (d.g.a.m)new b(this, paramb));
        }
        eOE().a((i.o)new i.h());
        eOE().a((i.o)new i.j());
        return;
      }
      catch (Exception paramb)
      {
        eOE().a((i.o)new i.e());
        ae.printErrStackTrace(TAG, (Throwable)paramb, "config engineContext err", new Object[0]);
        localObject = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.aP("wxfedb0854e2b1820d", "engine", paramb.getMessage());
      }
      paramb = paramb;
      eOE().a((i.o)new i.k());
      ae.printErrStackTrace(TAG, (Throwable)paramb, "config mainContext err", new Object[0]);
      localObject = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.aP("wxfedb0854e2b1820d", "main", paramb.getMessage());
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString3, d.g.a.b<? super String, z> paramb)
  {
    d.g.b.p.h(paramg, "context");
    d.g.b.p.h(paramString1, "name");
    d.g.b.p.h(paramString2, "appId");
    d.g.b.p.h(paramp, "bizPkg");
    d.g.b.p.h(paramString3, "type");
    try
    {
      eOE().a((i.o)new i.c());
      bqR().b(paramg, "NativeGlobal");
      Object localObject = ePj().xx("client");
      paramString3 = c(paramp).xx("client").xx(paramString3);
      paramString3 = u.R(Long.valueOf(paramString3.getLong("idKey")), paramString3.getString("path"));
      long l = ((Number)paramString3.first).longValue();
      String str = (String)paramString3.second;
      paramString3 = new h(l, h.j.DSr);
      try
      {
        paramString3.a((h.i)new h.g());
        a(this, (com.tencent.mm.ab.i)localObject, paramg, paramString3, false, paramString1, paramString2, 36);
        try
        {
          d.g.b.p.g(str, "path");
          localObject = a(paramp, str);
          paramg.a(new URL("https://ws/usr/" + paramString2 + '/' + str), kI(paramString2, str), String.valueOf(b(paramp)), 0, (String)localObject, (ValueCallback)new f(paramb));
          ae.d(TAG, "biz loaded:" + str + " to " + paramString1);
          paramString3.a((h.i)new h.h());
          eOE().a((i.o)new i.d());
          return;
        }
        catch (Exception paramg)
        {
          paramString3.a((h.i)new h.f());
          paramp = com.tencent.mm.plugin.webcanvas.g.DQG;
          com.tencent.mm.plugin.webcanvas.g.aP(paramString2, paramString1, paramg.getMessage());
          ae.printErrStackTrace(TAG, (Throwable)paramg, "read client context script", new Object[0]);
          throw ((Throwable)paramg);
        }
        eOE().a((i.o)new i.a());
      }
      catch (Exception paramg)
      {
        paramp = paramString3;
      }
    }
    catch (Exception paramg)
    {
      for (;;)
      {
        paramp = null;
      }
    }
    if (paramp != null) {
      paramp.a((h.i)new h.b());
    }
    paramp = com.tencent.mm.plugin.webcanvas.g.DQG;
    com.tencent.mm.plugin.webcanvas.g.aP(paramString2, paramString1, paramg.getMessage());
    ae.printErrStackTrace(TAG, (Throwable)paramg, "configClient engineContext err", new Object[0]);
  }
  
  protected abstract i eOE();
  
  protected abstract com.tencent.mm.plugin.appbrand.appcache.p eOF();
  
  public final IJSRuntime g(IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = new IJSRuntime.Config();
    }
    ae.d(TAG, "createJSRuntime");
    paramConfig = new k(com.tencent.mm.loader.j.b.asb() + "webservice/codecache");
    if (!paramConfig.exists()) {
      paramConfig.mkdirs();
    }
    localConfig.cYF = paramConfig.getPath();
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzW, false))
    {
      ae.d(TAG, "use code cache");
      if (com.tencent.mm.compatible.deviceinfo.q.is64BitRuntime()) {
        paramConfig = d.VF("wxa_library/v8_snapshot64.bin");
      }
    }
    for (;;)
    {
      localConfig.cYG = paramConfig;
      return super.g(localConfig);
      paramConfig = d.VF("wxa_library/v8_snapshot.bin");
      continue;
      paramConfig = null;
    }
  }
  
  protected abstract void g(int paramInt, String paramString1, String paramString2, String paramString3);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke", "com/tencent/mm/plugin/webjsengine/WebJsEngine$config$1$2"})
  static final class b
    extends d.g.b.q
    implements d.g.a.m<Integer, com.tencent.mm.ab.f, z>
  {
    b(c paramc, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webjsengine/WebJsEngine$setup$1$1"})
  static final class e
    implements com.tencent.mm.plugin.appbrand.jsruntime.h
  {
    e(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, c paramc, String paramString1, h paramh, String paramString2, String paramString3) {}
    
    public final void u(String paramString1, String paramString2)
    {
      AppMethodBeat.i(214020);
      ae.e(c.access$getTAG$cp(), "JsException[" + str1 + "]:" + paramString1 + '\n' + paramString2);
      paramh.a((h.i)new h.d());
      i locali = jdField_this.eOE();
      Object localObject = paramh.DSo;
      com.tencent.mm.plugin.webcanvas.g localg;
      switch (d.cqt[localObject.ordinal()])
      {
      default: 
        paramString1 = new d.m();
        AppMethodBeat.o(214020);
        throw paramString1;
      case 1: 
        localObject = new i.l();
        localg = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.aP(paramString2, paramString1, paramString1 + '\t' + paramString2);
        localObject = (i.o)localObject;
      }
      for (;;)
      {
        locali.a((i.o)localObject);
        jdField_this.g(this.DRY.bqQ(), paramString1, paramString1, paramString2);
        AppMethodBeat.o(214020);
        return;
        localObject = new i.f();
        localg = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.aP(paramString2, paramString1, paramString1 + '\t' + paramString2);
        localObject = (i.o)localObject;
        continue;
        localObject = new i.b();
        localg = com.tencent.mm.plugin.webcanvas.g.DQG;
        com.tencent.mm.plugin.webcanvas.g.aP(paramString2, paramString1, paramString1 + '\t' + paramString2);
        localObject = (i.o)localObject;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.m<Integer, com.tencent.mm.ab.f, z>
  {
    g(c paramc, com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.c
 * JD-Core Version:    0.7.0.1
 */