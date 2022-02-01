package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import android.webkit.ValueCallback;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.ay.d.d;
import com.tencent.mm.plugin.ay.d.i;
import com.tencent.mm.plugin.ay.d.j;
import com.tencent.mm.plugin.ay.e;
import com.tencent.mm.plugin.ay.e.b;
import com.tencent.mm.plugin.ay.e.o;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.webcanvas.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GameWebPrefetcherJsEngineInterceptor;", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "clientContextReport", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "contextName", "engineReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineReporter;", "jsContext", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "jsContextInited", "", "createBizJsContext", "type", "", "url", "onCompleted", "Lkotlin/Function1;", "", "dispatchEvent", "event", "data", "Lorg/json/JSONObject;", "appId", "initJsContext", "onJsContextInited", "callback", "Lkotlin/Function0;", "onUrlExposed", "Companion", "GamePrefetcherClientContextImpl", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.az.d
{
  public static final a vVi;
  private static boolean vVo;
  private String pjl;
  private g vVj;
  private boolean vVk;
  private final e vVl;
  private final com.tencent.mm.plugin.ay.d vVm;
  private final String vVn;
  
  static
  {
    AppMethodBeat.i(303201);
    vVi = new a((byte)0);
    vVo = true;
    Log.i("MicroMsg.GameWebPrefetcherJsEngineInterceptor", s.X("initGameWebPrefetcherJsEngineInterceptor open: ", Boolean.valueOf(vVo)));
    AppMethodBeat.o(303201);
  }
  
  public c()
  {
    AppMethodBeat.i(303134);
    this.vVl = new e();
    this.vVm = new com.tencent.mm.plugin.ay.d(1696L, d.j.WmQ);
    this.pjl = "__Game_Prefetcher_FakeAppId";
    this.vVn = "GameWebPrefetcher";
    AppMethodBeat.o(303134);
  }
  
  private static final void a(g paramg, c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(303166);
    s.u(paramg, "$this_apply");
    s.u(paramc, "this$0");
    Log.e("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] handleException, message : %s\n, stackTrace : %s", new Object[] { paramString1, paramString2 });
    Object localObject1 = "exception : " + paramString1 + " ; stack : " + paramString2;
    Object localObject2 = am.aixg;
    localObject1 = String.format("try {WxGameJsCoreBridge.invokeError(\"%s\");} catch(e) {console.log(e);}", Arrays.copyOf(new Object[] { org.apache.commons.c.h.bLc((String)localObject1) }, 1));
    s.s(localObject1, "java.lang.String.format(format, *args)");
    Log.i("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] handleException, js = %s", new Object[] { localObject1 });
    paramg.evaluateJavascript((String)localObject1, null);
    paramg = paramc.vVl;
    localObject1 = new e.b();
    localObject2 = j.WkY;
    j.bn(paramc.pjl, paramc.vVn, paramString1 + '\t' + paramString2);
    paramString1 = ah.aiuX;
    paramg.a((e.o)localObject1);
    paramc.vVm.a((d.i)new d.d());
    AppMethodBeat.o(303166);
  }
  
  private static void n(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(303145);
    Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a.a.vVy;
    localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a.a.getBridge();
    if (localObject != null) {
      ((o)localObject).b(paramString, paramJSONObject);
    }
    AppMethodBeat.o(303145);
  }
  
  /* Error */
  public final boolean l(String paramString, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    // Byte code:
    //   0: ldc_w 405
    //   3: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: ldc_w 406
    //   10: invokestatic 159	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 408	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVj	Lcom/tencent/mm/plugin/appbrand/n/g;
    //   17: ifnonnull +368 -> 385
    //   20: aload_0
    //   21: aload_0
    //   22: invokevirtual 412	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:ips	()Lcom/tencent/mm/plugin/ay/c;
    //   25: getfield 418	com/tencent/mm/plugin/appbrand/n/a:sSV	Lcom/tencent/mm/plugin/appbrand/n/e;
    //   28: invokevirtual 424	com/tencent/mm/plugin/appbrand/n/e:czj	()Lcom/tencent/mm/plugin/appbrand/n/g;
    //   31: putfield 408	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVj	Lcom/tencent/mm/plugin/appbrand/n/g;
    //   34: ldc 102
    //   36: ldc_w 426
    //   39: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 408	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVj	Lcom/tencent/mm/plugin/appbrand/n/g;
    //   46: ifnonnull +29 -> 75
    //   49: ldc 102
    //   51: ldc_w 428
    //   54: invokestatic 430	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_2
    //   58: getstatic 434	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   61: invokeinterface 439 2 0
    //   66: pop
    //   67: ldc_w 405
    //   70: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_1
    //   74: ireturn
    //   75: aload_0
    //   76: getfield 408	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVj	Lcom/tencent/mm/plugin/appbrand/n/g;
    //   79: astore_3
    //   80: aload_3
    //   81: ifnull -14 -> 67
    //   84: new 441	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a
    //   87: dup
    //   88: new 9	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$b
    //   91: dup
    //   92: invokespecial 442	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$b:<init>	()V
    //   95: checkcast 444	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/b
    //   98: invokespecial 447	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/a/b;)V
    //   101: astore 4
    //   103: aload_0
    //   104: getfield 408	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVj	Lcom/tencent/mm/plugin/appbrand/n/g;
    //   107: astore 5
    //   109: aload 5
    //   111: invokestatic 451	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   114: aload 4
    //   116: aload 5
    //   118: checkcast 453	com/tencent/mm/plugin/appbrand/n/i
    //   121: invokevirtual 456	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a:l	(Lcom/tencent/mm/plugin/appbrand/n/i;)V
    //   124: aload_0
    //   125: getfield 129	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVl	Lcom/tencent/mm/plugin/ay/e;
    //   128: new 458	com/tencent/mm/plugin/ay/e$c
    //   131: dup
    //   132: invokespecial 459	com/tencent/mm/plugin/ay/e$c:<init>	()V
    //   135: checkcast 253	com/tencent/mm/plugin/ay/e$o
    //   138: invokevirtual 256	com/tencent/mm/plugin/ay/e:a	(Lcom/tencent/mm/plugin/ay/e$o;)V
    //   141: aload_0
    //   142: getfield 144	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVm	Lcom/tencent/mm/plugin/ay/d;
    //   145: new 461	com/tencent/mm/plugin/ay/d$g
    //   148: dup
    //   149: invokespecial 462	com/tencent/mm/plugin/ay/d$g:<init>	()V
    //   152: checkcast 261	com/tencent/mm/plugin/ay/d$i
    //   155: invokevirtual 264	com/tencent/mm/plugin/ay/d:a	(Lcom/tencent/mm/plugin/ay/d$i;)V
    //   158: aload_3
    //   159: new 464	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$$ExternalSyntheticLambda0
    //   162: dup
    //   163: aload_3
    //   164: aload_0
    //   165: invokespecial 467	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/appbrand/n/g;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c;)V
    //   168: invokeinterface 471 2 0
    //   173: aload_0
    //   174: getfield 148	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:pjl	Ljava/lang/String;
    //   177: aload_0
    //   178: getfield 152	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVn	Ljava/lang/String;
    //   181: invokestatic 476	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a/a/b:fZ	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload_0
    //   185: getfield 408	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVj	Lcom/tencent/mm/plugin/appbrand/n/g;
    //   188: astore_3
    //   189: aload_3
    //   190: invokestatic 451	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   193: aload_3
    //   194: aload_1
    //   195: new 14	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$d
    //   198: dup
    //   199: aload_0
    //   200: aload_2
    //   201: invokespecial 479	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c$d:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c;Lkotlin/g/a/b;)V
    //   204: checkcast 481	kotlin/g/a/m
    //   207: aload_0
    //   208: getfield 144	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVm	Lcom/tencent/mm/plugin/ay/d;
    //   211: invokestatic 484	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/a/a/b:a	(Lcom/tencent/mm/plugin/appbrand/n/g;Ljava/lang/String;Lkotlin/g/a/m;Lcom/tencent/mm/plugin/ay/d;)V
    //   214: aload_0
    //   215: getfield 129	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVl	Lcom/tencent/mm/plugin/ay/e;
    //   218: new 486	com/tencent/mm/plugin/ay/e$d
    //   221: dup
    //   222: invokespecial 487	com/tencent/mm/plugin/ay/e$d:<init>	()V
    //   225: checkcast 253	com/tencent/mm/plugin/ay/e$o
    //   228: invokevirtual 256	com/tencent/mm/plugin/ay/e:a	(Lcom/tencent/mm/plugin/ay/e$o;)V
    //   231: aload_0
    //   232: getfield 144	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVm	Lcom/tencent/mm/plugin/ay/d;
    //   235: new 489	com/tencent/mm/plugin/ay/d$h
    //   238: dup
    //   239: invokespecial 490	com/tencent/mm/plugin/ay/d$h:<init>	()V
    //   242: checkcast 261	com/tencent/mm/plugin/ay/d$i
    //   245: invokevirtual 264	com/tencent/mm/plugin/ay/d:a	(Lcom/tencent/mm/plugin/ay/d$i;)V
    //   248: goto -181 -> 67
    //   251: astore_1
    //   252: aload_0
    //   253: getfield 129	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVl	Lcom/tencent/mm/plugin/ay/e;
    //   256: new 492	com/tencent/mm/plugin/ay/e$a
    //   259: dup
    //   260: invokespecial 493	com/tencent/mm/plugin/ay/e$a:<init>	()V
    //   263: checkcast 253	com/tencent/mm/plugin/ay/e$o
    //   266: invokevirtual 256	com/tencent/mm/plugin/ay/e:a	(Lcom/tencent/mm/plugin/ay/e$o;)V
    //   269: aload_0
    //   270: getfield 144	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVm	Lcom/tencent/mm/plugin/ay/d;
    //   273: new 495	com/tencent/mm/plugin/ay/d$b
    //   276: dup
    //   277: invokespecial 496	com/tencent/mm/plugin/ay/d$b:<init>	()V
    //   280: checkcast 261	com/tencent/mm/plugin/ay/d$i
    //   283: invokevirtual 264	com/tencent/mm/plugin/ay/d:a	(Lcom/tencent/mm/plugin/ay/d$i;)V
    //   286: getstatic 237	com/tencent/mm/plugin/webcanvas/j:WkY	Lcom/tencent/mm/plugin/webcanvas/j;
    //   289: astore_3
    //   290: aload_0
    //   291: getfield 148	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:pjl	Ljava/lang/String;
    //   294: aload_0
    //   295: getfield 152	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVn	Ljava/lang/String;
    //   298: aload_1
    //   299: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   302: invokestatic 245	com/tencent/mm/plugin/webcanvas/j:bn	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_2
    //   306: getstatic 434	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   309: invokeinterface 439 2 0
    //   314: pop
    //   315: goto -248 -> 67
    //   318: astore_3
    //   319: ldc 102
    //   321: aload_3
    //   322: checkcast 501	java/lang/Throwable
    //   325: ldc_w 502
    //   328: iconst_0
    //   329: anewarray 165	java/lang/Object
    //   332: invokestatic 506	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: aload_0
    //   336: getfield 144	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVm	Lcom/tencent/mm/plugin/ay/d;
    //   339: new 508	com/tencent/mm/plugin/ay/d$c
    //   342: dup
    //   343: invokespecial 509	com/tencent/mm/plugin/ay/d$c:<init>	()V
    //   346: checkcast 261	com/tencent/mm/plugin/ay/d$i
    //   349: invokevirtual 264	com/tencent/mm/plugin/ay/d:a	(Lcom/tencent/mm/plugin/ay/d$i;)V
    //   352: getstatic 237	com/tencent/mm/plugin/webcanvas/j:WkY	Lcom/tencent/mm/plugin/webcanvas/j;
    //   355: astore 4
    //   357: aload_0
    //   358: getfield 148	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:pjl	Ljava/lang/String;
    //   361: aload_0
    //   362: getfield 152	com/tencent/mm/plugin/brandservice/ui/timeline/preload/a/c:vVn	Ljava/lang/String;
    //   365: aload_3
    //   366: invokevirtual 499	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   369: invokestatic 245	com/tencent/mm/plugin/webcanvas/j:bn	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_2
    //   373: getstatic 434	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   376: invokeinterface 439 2 0
    //   381: pop
    //   382: goto -209 -> 173
    //   385: aload_2
    //   386: getstatic 512	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   389: invokeinterface 439 2 0
    //   394: pop
    //   395: goto -328 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	c
    //   0	398	1	paramString	String
    //   0	398	2	paramb	kotlin.g.a.b<? super Boolean, ah>
    //   79	211	3	localObject1	Object
    //   318	48	3	localException	java.lang.Exception
    //   101	255	4	localObject2	Object
    //   107	10	5	localg	g
    // Exception table:
    //   from	to	target	type
    //   84	158	251	java/lang/Exception
    //   173	248	251	java/lang/Exception
    //   319	382	251	java/lang/Exception
    //   158	173	318	java/lang/Exception
  }
  
  public final boolean o(String paramString1, final String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(303227);
    s.u(paramString3, "event");
    paramString1 = (CharSequence)paramString1;
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(303227);
      return false;
    }
    if ((paramString2 != null) && (!UrlExKt.isGameCenterUrl(paramString2))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(303227);
      return false;
    }
    if (!this.vVk)
    {
      Log.e("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "dispatchEvent jsContext not init url: " + paramString2 + ", event: " + paramString3);
      AppMethodBeat.o(303227);
      return false;
    }
    Log.v("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] dispatchEvent event: %s, data: %s", new Object[] { paramString3, paramString4 });
    if (s.p(paramString3, "urlExposed"))
    {
      a.aE((kotlin.g.a.a)new c(this, paramString2));
      AppMethodBeat.o(303227);
      return true;
    }
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    n(paramString3, new JSONObject(paramString1));
    AppMethodBeat.o(303227);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GameWebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "EVENT_URL_EXPOSED", "", "TAG", "openGameCenterPrefetch", "", "buildUrlExposedData", "Lorg/json/JSONObject;", "url", "runTask", "", "runnable", "Lkotlin/Function0;", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static void aE(kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(303126);
      com.tencent.threadpool.h.ahAA.g(new c.a..ExternalSyntheticLambda0(parama), "MicroMsg.GameWebPrefetcherJsEngineInterceptor");
      AppMethodBeat.o(303126);
    }
    
    private static final void aF(kotlin.g.a.a parama)
    {
      AppMethodBeat.i(303132);
      s.u(parama, "$runnable");
      parama.invoke();
      AppMethodBeat.o(303132);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GameWebPrefetcherJsEngineInterceptor$GamePrefetcherClientContextImpl;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/GamePrefetcherClientContext;", "()V", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "error", "msg", "log", "postMessage", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements b
  {
    public final void b(String paramString1, String paramString2, ValueCallback<String> paramValueCallback)
    {
      AppMethodBeat.i(303135);
      s.u(paramString1, "eventType");
      s.u(paramString2, "event");
      AppMethodBeat.o(303135);
    }
    
    public final void error(String paramString)
    {
      AppMethodBeat.i(303130);
      if (paramString == null)
      {
        AppMethodBeat.o(303130);
        return;
      }
      Log.e("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] js console error: %s", new Object[] { paramString });
      AppMethodBeat.o(303130);
    }
    
    public final void log(String paramString)
    {
      AppMethodBeat.i(303125);
      if (paramString == null)
      {
        AppMethodBeat.o(303125);
        return;
      }
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] js console log: %s", new Object[] { paramString });
      }
      AppMethodBeat.o(303125);
    }
    
    public final void postMessage(String paramString)
    {
      AppMethodBeat.i(303117);
      Log.i("MicroMsg.GameWebPrefetcherJsEngineInterceptor", "[game-web-prefetch] postMessage ignore msg: %s", new Object[] { paramString });
      AppMethodBeat.o(303117);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(c paramc, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "url", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Boolean, String, ah>
  {
    d(c paramc, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.c
 * JD-Core Version:    0.7.0.1
 */