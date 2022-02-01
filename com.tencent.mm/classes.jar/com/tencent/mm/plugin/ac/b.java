package com.tencent.mm.plugin.ac;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.IJSRuntime.Config;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.q;
import d.l;
import d.o;
import d.u;
import d.z;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandNodeJSBasedJsEngine;", "()V", "contextJson", "Lcom/tencent/mm/json/JSONObject;", "kotlin.jvm.PlatformType", "getContextJson", "()Lcom/tencent/mm/json/JSONObject;", "contextJson$delegate", "Lkotlin/Lazy;", "contextMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "engineMap", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "getEngineReporter", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "meta", "getMeta", "meta$delegate", "version", "getVersion", "()I", "version$delegate", "wxaPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "getWxaPkg", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)Lcom/tencent/mm/json/JSONObject;", "(Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;)I", "config", "", "configClient", "context", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "name", "appId", "bizPkg", "type", "cb", "Lkotlin/Function1;", "createJSRuntime", "Lcom/tencent/mm/appbrand/v8/IJSRuntime;", "Lcom/tencent/mm/appbrand/v8/IJSRuntime$Config;", "getCacheCategory", "path", "onError", "contextId", "message", "stackTrace", "readFile", "setup", "clientReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "cache", "", "Companion", "webview-sdk_release"})
public abstract class b
  extends x
{
  public static final b.a DzW = new b.a((byte)0);
  private static final String TAG = "MicroMsg.WebJsEngine";
  private final d.f DzT = d.g.O((d.g.a.a)new d(this));
  private final d.f DzU = d.g.O((d.g.a.a)new c(this));
  private final HashMap<String, Integer> DzV = new HashMap();
  private final d.f okr = d.g.O((d.g.a.a)new h(this));
  private final HashMap<String, Integer> olL = new HashMap();
  
  /* Error */
  private static String a(com.tencent.mm.plugin.appbrand.appcache.p paramp, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokeinterface 146 2 0
    //   9: checkcast 148	java/io/Closeable
    //   12: astore_3
    //   13: aload_3
    //   14: checkcast 150	java/io/InputStream
    //   17: astore_0
    //   18: aload_0
    //   19: ldc 152
    //   21: invokestatic 158	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   24: new 160	java/lang/String
    //   27: dup
    //   28: aload_0
    //   29: invokestatic 166	d/f/a:X	(Ljava/io/InputStream;)[B
    //   32: getstatic 172	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   35: invokespecial 175	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   38: astore_0
    //   39: aload_3
    //   40: aconst_null
    //   41: invokestatic 180	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   44: aload_0
    //   45: areturn
    //   46: astore_1
    //   47: aload_1
    //   48: athrow
    //   49: astore_0
    //   50: aload_3
    //   51: aload_1
    //   52: invokestatic 180	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
  
  public static int b(com.tencent.mm.plugin.appbrand.appcache.p paramp)
  {
    d.g.b.p.h(paramp, "$this$version");
    return c(paramp).optInt("version");
  }
  
  protected static i c(com.tencent.mm.plugin.appbrand.appcache.p paramp)
  {
    d.g.b.p.h(paramp, "$this$meta");
    return new i(a(paramp, "/meta.json"));
  }
  
  private final i eLA()
  {
    return (i)this.DzU.getValue();
  }
  
  private static String kB(String paramString1, String paramString2)
  {
    return paramString1 + ':' + URLEncoder.encode(paramString2);
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
      eKW().a((g.o)new g.c());
      bqi().b(paramg, "NativeGlobal");
      Object localObject = eLA().wO("client");
      paramString3 = c(paramp).wO("client").wO(paramString3);
      paramString3 = u.S(Long.valueOf(paramString3.getLong("idKey")), paramString3.getString("path"));
      long l = ((Number)paramString3.first).longValue();
      String str = (String)paramString3.second;
      paramString3 = new f(l, f.j.DAu);
      try
      {
        paramString3.a((f.i)new f.g());
        a(this, (i)localObject, paramg, paramString3, false, paramString1, paramString2, 36);
        try
        {
          d.g.b.p.g(str, "path");
          localObject = a(paramp, str);
          paramg.a(new URL("https://ws/usr/" + paramString2 + '/' + str), kB(paramString2, str), String.valueOf(b(paramp)), 0, (String)localObject, (ValueCallback)new d(paramb));
          ad.d(TAG, "biz loaded:" + str + " to " + paramString1);
          paramString3.a((f.i)new f.h());
          eKW().a((g.o)new g.d());
          return;
        }
        catch (Exception paramg)
        {
          paramString3.a((f.i)new f.f());
          paramp = com.tencent.mm.plugin.webcanvas.f.DyX;
          com.tencent.mm.plugin.webcanvas.f.B(new Object[] { paramString2, paramString1, paramg.getMessage() });
          ad.printErrStackTrace(TAG, (Throwable)paramg, "read client context script", new Object[0]);
          throw ((Throwable)paramg);
        }
        eKW().a((g.o)new g.a());
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
      paramp.a((f.i)new f.b());
    }
    paramp = com.tencent.mm.plugin.webcanvas.f.DyX;
    com.tencent.mm.plugin.webcanvas.f.B(new Object[] { paramString2, paramString1, paramg.getMessage() });
    ad.printErrStackTrace(TAG, (Throwable)paramg, "config engineContext err", new Object[0]);
  }
  
  public final void cxZ()
  {
    eKW().a((g.o)new g.i());
    Object localObject1 = eLA();
    try
    {
      eKW().a((g.o)new g.m());
      Object localObject2 = ((i)localObject1).wO("main");
      com.tencent.mm.plugin.appbrand.jsruntime.g localg = bqi();
      d.g.b.p.g(localg, "mainJsContext");
      a(this, (i)localObject2, localg, new f(((i)localObject2).getLong("idKey"), f.j.DAs), true, null, null, 56);
      eKW().a((g.o)new g.n());
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        eKW().a((g.o)new g.g());
        localObject1 = ((i)localObject1).wM("engine");
        if (localObject1 != null) {
          com.tencent.mm.plugin.webview.k.a.a((com.tencent.mm.ac.f)localObject1, (d.g.a.m)new b(this));
        }
        eKW().a((g.o)new g.h());
        eKW().a((g.o)new g.j());
        return;
      }
      catch (Exception localException2)
      {
        eKW().a((g.o)new g.e());
        ad.printErrStackTrace(TAG, (Throwable)localException2, "config engineContext err", new Object[0]);
        localObject2 = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.B(new Object[] { "wxfedb0854e2b1820d", "engine", localException2.getMessage() });
      }
      localException1 = localException1;
      eKW().a((g.o)new g.k());
      ad.printErrStackTrace(TAG, (Throwable)localException1, "config mainContext err", new Object[0]);
      localObject2 = com.tencent.mm.plugin.webcanvas.f.DyX;
      com.tencent.mm.plugin.webcanvas.f.B(new Object[] { "wxfedb0854e2b1820d", "main", localException1.getMessage() });
      return;
    }
  }
  
  protected abstract g eKW();
  
  protected abstract com.tencent.mm.plugin.appbrand.appcache.p eKX();
  
  public final IJSRuntime g(IJSRuntime.Config paramConfig)
  {
    IJSRuntime.Config localConfig = paramConfig;
    if (paramConfig == null)
    {
      localConfig = new IJSRuntime.Config();
      paramConfig = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.arM() + "webservice/codecache");
      if (!paramConfig.exists()) {
        paramConfig.mkdirs();
      }
      localConfig.cXH = paramConfig.getPath();
    }
    return super.g(localConfig);
  }
  
  protected abstract void g(int paramInt, String paramString1, String paramString2, String paramString3);
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke", "com/tencent/mm/plugin/webjsengine/WebJsEngine$config$1$2"})
  static final class b
    extends q
    implements d.g.a.m<Integer, com.tencent.mm.ac.f, z>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<i>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/json/JSONObject;", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<i>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/webjsengine/WebJsEngine$setup$1$1"})
  static final class e
    implements h
  {
    e(com.tencent.mm.plugin.appbrand.jsruntime.g paramg, b paramb, String paramString1, f paramf, String paramString2, String paramString3) {}
    
    public final void u(String paramString1, String paramString2)
    {
      AppMethodBeat.i(214180);
      ad.e(b.access$getTAG$cp(), "JsException[" + this.DzZ + "]:" + paramString1 + '\n' + paramString2);
      this.DAa.a((f.i)new f.d());
      g localg = this.DzX.eKW();
      Object localObject = this.DAa.DAr;
      com.tencent.mm.plugin.webcanvas.f localf;
      switch (c.cpQ[localObject.ordinal()])
      {
      default: 
        paramString1 = new d.m();
        AppMethodBeat.o(214180);
        throw paramString1;
      case 1: 
        localObject = new g.l();
        localf = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.B(new Object[] { this.mgK, this.laq, paramString1 });
        localObject = (g.o)localObject;
      }
      for (;;)
      {
        localg.a((g.o)localObject);
        this.DzX.g(this.DzY.bqh(), this.laq, paramString1, paramString2);
        AppMethodBeat.o(214180);
        return;
        localObject = new g.f();
        localf = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.B(new Object[] { this.mgK, this.laq, paramString1 });
        localObject = (g.o)localObject;
        continue;
        localObject = new g.b();
        localf = com.tencent.mm.plugin.webcanvas.f.DyX;
        com.tencent.mm.plugin.webcanvas.f.B(new Object[] { this.mgK, this.laq, paramString1 });
        localObject = (g.o)localObject;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webjsengine/WebJsEngine$setup$1$2", "", "error", "", "objects", "", "([Ljava/lang/Object;)V", "info", "log", "webview-sdk_release"})
  public static final class f
  {
    f(b paramb, String paramString1, f paramf, String paramString2, String paramString3) {}
    
    @JavascriptInterface
    public final void error(Object... paramVarArgs)
    {
      AppMethodBeat.i(214183);
      d.g.b.p.h(paramVarArgs, "objects");
      ad.e(b.access$getTAG$cp(), "JsError[" + this.DzZ + "]:" + d.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(214183);
    }
    
    @JavascriptInterface
    public final void info(Object... paramVarArgs)
    {
      AppMethodBeat.i(214182);
      d.g.b.p.h(paramVarArgs, "objects");
      ad.i(b.access$getTAG$cp(), "JsInfo[" + this.DzZ + "]:" + d.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(214182);
    }
    
    @JavascriptInterface
    public final void log(Object... paramVarArgs)
    {
      AppMethodBeat.i(214181);
      d.g.b.p.h(paramVarArgs, "objects");
      ad.d(b.access$getTAG$cp(), "JsLog[" + this.DzZ + "]:" + d.a.e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
      AppMethodBeat.o(214181);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "i", "", "jsonArray", "Lcom/tencent/mm/json/JSONArray;", "invoke"})
  static final class g
    extends q
    implements d.g.a.m<Integer, com.tencent.mm.ac.f, z>
  {
    g(b paramb, com.tencent.mm.plugin.appbrand.jsruntime.g paramg, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<Integer>
  {
    h(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.b
 * JD-Core Version:    0.7.0.1
 */