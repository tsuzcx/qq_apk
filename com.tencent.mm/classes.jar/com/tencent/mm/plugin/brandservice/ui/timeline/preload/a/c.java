package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.webkit.ValueCallback;
import com.tencent.e.i;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aw.f.d;
import com.tencent.mm.plugin.aw.f.i;
import com.tencent.mm.plugin.aw.f.j;
import com.tencent.mm.plugin.aw.g.b;
import com.tencent.mm.plugin.aw.g.o;
import com.tencent.mm.plugin.ax.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GameWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "clientContextReport", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "contextName", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "jsContext", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "jsContextInited", "", "createBizJsContext", "type", "", "url", "onCompleted", "Lkotlin/Function1;", "", "dispatchEvent", "event", "data", "Lorg/json/JSONObject;", "appId", "initJsContext", "onJsContextInited", "callback", "Lkotlin/Function0;", "onUrlExposed", "Companion", "GamePrefetcherClientContextImpl", "plugin-brandservice_release"})
public final class c
  extends d
{
  private static boolean sPX;
  public static final a sPY;
  private final String contextName;
  String mpE;
  private com.tencent.mm.plugin.appbrand.m.g sPT;
  private boolean sPU;
  private final com.tencent.mm.plugin.aw.g sPV;
  private final com.tencent.mm.plugin.aw.f sPW;
  
  static
  {
    AppMethodBeat.i(258219);
    sPY = new a((byte)0);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzQ, 0);
    if ((i == 1) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {}
    for (boolean bool = true;; bool = false)
    {
      sPX = bool;
      Log.i("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "initGameWebPrefetcherJsEngineInterceptor config: " + i + ", open: " + sPX);
      AppMethodBeat.o(258219);
      return;
    }
  }
  
  public c()
  {
    AppMethodBeat.i(258218);
    this.sPV = new com.tencent.mm.plugin.aw.g();
    this.sPW = new com.tencent.mm.plugin.aw.f(1696L, f.j.PwG);
    this.mpE = "__Game_Prefetcher_FakeAppId";
    this.contextName = "GameWebPrefetcher";
    AppMethodBeat.o(258218);
  }
  
  private static void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(258217);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a.a.sQi;
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a.a.getBridge();
    if (localObject != null)
    {
      ((o)localObject).b(paramString, paramJSONObject);
      AppMethodBeat.o(258217);
      return;
    }
    AppMethodBeat.o(258217);
  }
  
  /* Error */
  public final boolean g(final String paramString, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    // Byte code:
    //   0: ldc_w 324
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ldc_w 325
    //   10: invokestatic 331	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 333	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPT	Lcom/tencent/mm/plugin/appbrand/m/g;
    //   17: ifnonnull +377 -> 394
    //   20: aload_0
    //   21: aload_0
    //   22: invokevirtual 337	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:gQb	()Lcom/tencent/mm/plugin/aw/c;
    //   25: invokevirtual 343	com/tencent/mm/plugin/aw/c:bYV	()Lcom/tencent/mm/plugin/appbrand/m/g;
    //   28: putfield 333	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPT	Lcom/tencent/mm/plugin/appbrand/m/g;
    //   31: ldc 118
    //   33: ldc_w 345
    //   36: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 333	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPT	Lcom/tencent/mm/plugin/appbrand/m/g;
    //   43: ifnonnull +29 -> 72
    //   46: ldc 118
    //   48: ldc_w 347
    //   51: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_2
    //   55: getstatic 356	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   58: invokeinterface 361 2 0
    //   63: pop
    //   64: ldc_w 324
    //   67: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iconst_1
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 333	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPT	Lcom/tencent/mm/plugin/appbrand/m/g;
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull -14 -> 64
    //   81: new 363	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a
    //   84: dup
    //   85: new 11	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$b
    //   88: dup
    //   89: invokespecial 364	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$b:<init>	()V
    //   92: checkcast 366	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/b
    //   95: invokespecial 369	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/a/b;)V
    //   98: astore 4
    //   100: aload_0
    //   101: getfield 333	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPT	Lcom/tencent/mm/plugin/appbrand/m/g;
    //   104: astore 5
    //   106: aload 5
    //   108: ifnonnull +6 -> 114
    //   111: invokestatic 372	kotlin/g/b/p:iCn	()V
    //   114: aload 4
    //   116: aload 5
    //   118: checkcast 374	com/tencent/mm/plugin/appbrand/m/i
    //   121: invokevirtual 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a:h	(Lcom/tencent/mm/plugin/appbrand/m/i;)V
    //   124: aload_0
    //   125: getfield 156	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPV	Lcom/tencent/mm/plugin/aw/g;
    //   128: new 380	com/tencent/mm/plugin/aw/g$c
    //   131: dup
    //   132: invokespecial 381	com/tencent/mm/plugin/aw/g$c:<init>	()V
    //   135: checkcast 383	com/tencent/mm/plugin/aw/g$o
    //   138: invokevirtual 386	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   141: aload_0
    //   142: getfield 171	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPW	Lcom/tencent/mm/plugin/aw/f;
    //   145: new 388	com/tencent/mm/plugin/aw/f$g
    //   148: dup
    //   149: invokespecial 389	com/tencent/mm/plugin/aw/f$g:<init>	()V
    //   152: checkcast 391	com/tencent/mm/plugin/aw/f$i
    //   155: invokevirtual 394	com/tencent/mm/plugin/aw/f:a	(Lcom/tencent/mm/plugin/aw/f$i;)V
    //   158: aload_3
    //   159: new 16	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$d
    //   162: dup
    //   163: aload_3
    //   164: aload_0
    //   165: aload_2
    //   166: aload_1
    //   167: invokespecial 397	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$d:<init>	(Lcom/tencent/mm/plugin/appbrand/m/g;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c;Lkotlin/g/a/b;Ljava/lang/String;)V
    //   170: checkcast 399	com/tencent/mm/plugin/appbrand/m/h
    //   173: invokeinterface 405 2 0
    //   178: aload_0
    //   179: getfield 175	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:mpE	Ljava/lang/String;
    //   182: aload_0
    //   183: getfield 179	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:contextName	Ljava/lang/String;
    //   186: invokestatic 410	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a/a/b:fz	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_0
    //   190: getfield 333	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPT	Lcom/tencent/mm/plugin/appbrand/m/g;
    //   193: astore_3
    //   194: aload_3
    //   195: ifnonnull +6 -> 201
    //   198: invokestatic 372	kotlin/g/b/p:iCn	()V
    //   201: aload_3
    //   202: aload_1
    //   203: new 18	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$e
    //   206: dup
    //   207: aload_0
    //   208: aload_2
    //   209: aload_1
    //   210: invokespecial 413	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$e:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c;Lkotlin/g/a/b;Ljava/lang/String;)V
    //   213: checkcast 415	kotlin/g/a/m
    //   216: aload_0
    //   217: getfield 171	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPW	Lcom/tencent/mm/plugin/aw/f;
    //   220: invokestatic 418	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a/a/b:a	(Lcom/tencent/mm/plugin/appbrand/m/g;Ljava/lang/String;Lkotlin/g/a/m;Lcom/tencent/mm/plugin/aw/f;)V
    //   223: aload_0
    //   224: getfield 156	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPV	Lcom/tencent/mm/plugin/aw/g;
    //   227: new 420	com/tencent/mm/plugin/aw/g$d
    //   230: dup
    //   231: invokespecial 421	com/tencent/mm/plugin/aw/g$d:<init>	()V
    //   234: checkcast 383	com/tencent/mm/plugin/aw/g$o
    //   237: invokevirtual 386	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   240: aload_0
    //   241: getfield 171	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPW	Lcom/tencent/mm/plugin/aw/f;
    //   244: new 423	com/tencent/mm/plugin/aw/f$h
    //   247: dup
    //   248: invokespecial 424	com/tencent/mm/plugin/aw/f$h:<init>	()V
    //   251: checkcast 391	com/tencent/mm/plugin/aw/f$i
    //   254: invokevirtual 394	com/tencent/mm/plugin/aw/f:a	(Lcom/tencent/mm/plugin/aw/f$i;)V
    //   257: goto -193 -> 64
    //   260: astore_1
    //   261: aload_0
    //   262: getfield 156	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPV	Lcom/tencent/mm/plugin/aw/g;
    //   265: new 426	com/tencent/mm/plugin/aw/g$a
    //   268: dup
    //   269: invokespecial 427	com/tencent/mm/plugin/aw/g$a:<init>	()V
    //   272: checkcast 383	com/tencent/mm/plugin/aw/g$o
    //   275: invokevirtual 386	com/tencent/mm/plugin/aw/g:a	(Lcom/tencent/mm/plugin/aw/g$o;)V
    //   278: aload_0
    //   279: getfield 171	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPW	Lcom/tencent/mm/plugin/aw/f;
    //   282: new 429	com/tencent/mm/plugin/aw/f$b
    //   285: dup
    //   286: invokespecial 430	com/tencent/mm/plugin/aw/f$b:<init>	()V
    //   289: checkcast 391	com/tencent/mm/plugin/aw/f$i
    //   292: invokevirtual 394	com/tencent/mm/plugin/aw/f:a	(Lcom/tencent/mm/plugin/aw/f$i;)V
    //   295: getstatic 436	com/tencent/mm/plugin/webcanvas/l:PuB	Lcom/tencent/mm/plugin/webcanvas/l;
    //   298: astore_3
    //   299: aload_0
    //   300: getfield 175	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:mpE	Ljava/lang/String;
    //   303: aload_0
    //   304: getfield 179	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:contextName	Ljava/lang/String;
    //   307: aload_1
    //   308: invokevirtual 439	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   311: invokestatic 443	com/tencent/mm/plugin/webcanvas/l:aU	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_2
    //   315: getstatic 356	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   318: invokeinterface 361 2 0
    //   323: pop
    //   324: goto -260 -> 64
    //   327: astore_3
    //   328: ldc 118
    //   330: aload_3
    //   331: checkcast 445	java/lang/Throwable
    //   334: ldc_w 446
    //   337: iconst_0
    //   338: anewarray 269	java/lang/Object
    //   341: invokestatic 450	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: aload_0
    //   345: getfield 171	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:sPW	Lcom/tencent/mm/plugin/aw/f;
    //   348: new 452	com/tencent/mm/plugin/aw/f$c
    //   351: dup
    //   352: invokespecial 453	com/tencent/mm/plugin/aw/f$c:<init>	()V
    //   355: checkcast 391	com/tencent/mm/plugin/aw/f$i
    //   358: invokevirtual 394	com/tencent/mm/plugin/aw/f:a	(Lcom/tencent/mm/plugin/aw/f$i;)V
    //   361: getstatic 436	com/tencent/mm/plugin/webcanvas/l:PuB	Lcom/tencent/mm/plugin/webcanvas/l;
    //   364: astore 4
    //   366: aload_0
    //   367: getfield 175	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:mpE	Ljava/lang/String;
    //   370: aload_0
    //   371: getfield 179	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:contextName	Ljava/lang/String;
    //   374: aload_3
    //   375: invokevirtual 439	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   378: invokestatic 443	com/tencent/mm/plugin/webcanvas/l:aU	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   381: aload_2
    //   382: getstatic 356	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   385: invokeinterface 361 2 0
    //   390: pop
    //   391: goto -213 -> 178
    //   394: aload_2
    //   395: getstatic 456	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   398: invokeinterface 361 2 0
    //   403: pop
    //   404: goto -340 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	c
    //   0	407	1	paramString	String
    //   0	407	2	paramb	kotlin.g.a.b<? super Boolean, x>
    //   76	223	3	localObject1	Object
    //   327	48	3	localException	java.lang.Exception
    //   98	267	4	localObject2	Object
    //   104	13	5	localg	com.tencent.mm.plugin.appbrand.m.g
    // Exception table:
    //   from	to	target	type
    //   81	106	260	java/lang/Exception
    //   111	114	260	java/lang/Exception
    //   114	158	260	java/lang/Exception
    //   178	194	260	java/lang/Exception
    //   198	201	260	java/lang/Exception
    //   201	257	260	java/lang/Exception
    //   328	391	260	java/lang/Exception
    //   158	178	327	java/lang/Exception
  }
  
  public final boolean o(String paramString1, final String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(258216);
    p.k(paramString3, "event");
    paramString1 = (CharSequence)paramString1;
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(258216);
      return false;
    }
    if ((paramString2 != null) && (!UrlExKt.isGameCenterUrl(paramString2)))
    {
      AppMethodBeat.o(258216);
      return false;
    }
    if (!this.sPU)
    {
      Log.e("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "dispatchEvent jsContext not init url: " + paramString2 + ", event: " + paramString3);
      AppMethodBeat.o(258216);
      return false;
    }
    Log.v("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] dispatchEvent event: %s, data: %s", new Object[] { paramString3, paramString4 });
    if (p.h(paramString3, "urlExposed"))
    {
      paramString1 = (kotlin.g.a.a)new c(this, paramString2);
      com.tencent.e.h.ZvG.d((Runnable)new c.a.a(paramString1), "MicroMsg.GameWebPrefetcherJsEngineInterceptor");
      AppMethodBeat.o(258216);
      return true;
    }
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    dispatchEvent(paramString3, new JSONObject(paramString1));
    AppMethodBeat.o(258216);
    return true;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GameWebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "EVENT_URL_EXPOSED", "", "TAG", "openGameCenterPrefetch", "", "buildUrlExposedData", "Lorg/json/JSONObject;", "url", "runTask", "", "runnable", "Lkotlin/Function0;", "plugin-brandservice_release"})
  public static final class a
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(kotlin.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(266111);
        this.sPZ.invoke();
        AppMethodBeat.o(266111);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GameWebPrefetcherJsEngineInterceptor$GamePrefetcherClientContextImpl;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GamePrefetcherClientContext;", "()V", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "error", "msg", "log", "postMessage", "plugin-brandservice_release"})
  static final class b
    implements b
  {
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(266223);
      p.k(paramString1, "eventType");
      p.k(paramString2, "event");
      AppMethodBeat.o(266223);
    }
    
    public final void error(String paramString)
    {
      AppMethodBeat.i(266222);
      if (paramString == null)
      {
        AppMethodBeat.o(266222);
        return;
      }
      Log.e("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] js console error: %s", new Object[] { paramString });
      AppMethodBeat.o(266222);
    }
    
    public final void log(String paramString)
    {
      AppMethodBeat.i(266221);
      if (paramString == null)
      {
        AppMethodBeat.o(266221);
        return;
      }
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] js console log: %s", new Object[] { paramString });
      }
      AppMethodBeat.o(266221);
    }
    
    public final void postMessage(String paramString)
    {
      AppMethodBeat.i(266220);
      Log.i("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] postMessage ignore msg: %s", new Object[] { paramString });
      AppMethodBeat.o(266220);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(c paramc, String paramString)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "message", "", "kotlin.jvm.PlatformType", "stackTrace", "handleException", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GameWebPrefetcherJsEngineInterceptor$initJsContext$1$1"})
  static final class d
    implements com.tencent.mm.plugin.appbrand.m.h
  {
    d(com.tencent.mm.plugin.appbrand.m.g paramg, c paramc, kotlin.g.a.b paramb, String paramString) {}
    
    public final void A(String paramString1, String paramString2)
    {
      AppMethodBeat.i(266598);
      Log.e("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] handleException, message : %s\n, stackTrace : %s", new Object[] { paramString1, paramString2 });
      Object localObject1 = "exception : " + paramString1 + " ; stack : " + paramString2;
      Object localObject2 = af.aaBG;
      localObject1 = String.format("try {WxGameJsCoreBridge.invokeError(\"%s\");} catch(e) {console.log(e);}", Arrays.copyOf(new Object[] { org.apache.commons.b.f.bIi((String)localObject1) }, 1));
      p.j(localObject1, "java.lang.String.format(format, *args)");
      Log.i("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] handleException, js = %s", new Object[] { localObject1 });
      this.sKo.evaluateJavascript((String)localObject1, null);
      localObject1 = c.a(jdField_this);
      localObject2 = new g.b();
      com.tencent.mm.plugin.webcanvas.l locall = com.tencent.mm.plugin.webcanvas.l.PuB;
      com.tencent.mm.plugin.webcanvas.l.aU(jdField_this.mpE, c.b(jdField_this), paramString1 + '\t' + paramString2);
      ((com.tencent.mm.plugin.aw.g)localObject1).a((g.o)localObject2);
      c.c(jdField_this).a((f.i)new f.d());
      AppMethodBeat.o(266598);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "url", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GameWebPrefetcherJsEngineInterceptor$initJsContext$1$2"})
  static final class e
    extends q
    implements m<Boolean, String, x>
  {
    e(c paramc, kotlin.g.a.b paramb, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c
 * JD-Core Version:    0.7.0.1
 */