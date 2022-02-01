package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.r;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.ax.i;
import com.tencent.mm.plugin.ax.i.a;
import com.tencent.mm.plugin.ay.d.f;
import com.tencent.mm.plugin.ay.d.i;
import com.tencent.mm.plugin.webview.k.j.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/adapter/GamePrefetchJsCoreAdapter;", "Lcom/tencent/luggage/container/LuggageJsCoreInterface;", "()V", "GAME_CENTER_JSCORE_JS", "", "TAG", "bizAppId", "contextName", "jsContext", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "luggageBridge", "Lcom/tencent/luggage/bridge/LuggageBridge;", "addJavascriptInterface", "", "obj", "", "name", "attach", "appId", "destroy", "evaluateJavascript", "script", "resultCallback", "Landroid/webkit/ValueCallback;", "evaluateJavascriptSync", "callback", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBridge", "getContext", "Landroid/content/Context;", "getUserAgent", "init", "context", "url", "initCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "success", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "initSystemInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectInitScript", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.luggage.d.g
{
  private static String pjl;
  private static com.tencent.mm.plugin.appbrand.n.g vVj;
  private static String vVn;
  public static final a vVy;
  private static o vVz;
  
  static
  {
    AppMethodBeat.i(303205);
    vVy = new a();
    pjl = "";
    vVn = "";
    AppMethodBeat.o(303205);
  }
  
  public static final void a(com.tencent.mm.plugin.appbrand.n.g paramg, final String paramString, final m<? super Boolean, ? super String, ah> paramm, com.tencent.mm.plugin.ay.d paramd)
  {
    AppMethodBeat.i(303177);
    kotlin.g.b.s.u(paramg, "context");
    kotlin.g.b.s.u(paramm, "initCallback");
    kotlin.g.b.s.u(paramd, "contextReporter");
    Log.i("MicroMsg.GamePrefetchJsCoreAdapter", "alvinluo initGameJsPrefetchJsCore");
    vVj = paramg;
    vVz = new o((com.tencent.luggage.bridge.s)vVy);
    kotlinx.coroutines.j.a((aq)bu.ajwo, null, null, (m)new c(paramd, paramm, paramString, null), 3);
    AppMethodBeat.o(303177);
  }
  
  private static Object e(String paramString, kotlin.g.a.b<? super String, ah> paramb, kotlin.d.d<? super String> paramd)
  {
    AppMethodBeat.i(303188);
    h localh = new h(kotlin.d.a.b.au(paramd));
    final kotlin.d.d locald = (kotlin.d.d)localh;
    com.tencent.mm.plugin.appbrand.n.g localg = vVj;
    if (localg != null) {
      localg.evaluateJavascript(paramString, (ValueCallback)new b(paramb, locald));
    }
    paramString = localh.kli();
    if (paramString == kotlin.d.a.a.aiwj) {
      kotlin.g.b.s.u(paramd, "frame");
    }
    AppMethodBeat.o(303188);
    return paramString;
  }
  
  public static final void fZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(303169);
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "contextName");
    pjl = paramString1;
    vVn = paramString2;
    AppMethodBeat.o(303169);
  }
  
  public static o getBridge()
  {
    return vVz;
  }
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(303208);
    com.tencent.mm.plugin.appbrand.n.g localg = vVj;
    if (localg != null) {
      localg.addJavascriptInterface(paramObject, paramString);
    }
    AppMethodBeat.o(303208);
  }
  
  public final void aof() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(303234);
    vVz = null;
    com.tencent.mm.plugin.appbrand.n.g localg = vVj;
    if (localg != null) {
      localg.destroy();
    }
    AppMethodBeat.o(303234);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(303211);
    com.tencent.mm.plugin.appbrand.n.g localg = vVj;
    if (localg != null) {
      localg.evaluateJavascript(paramString, paramValueCallback);
    }
    AppMethodBeat.o(303211);
  }
  
  public final Context getContext()
  {
    return null;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(303222);
    Object localObject1 = MMApplicationContext.getContext();
    Object localObject2 = com.tencent.mm.plugin.webview.k.j.Xta;
    localObject2 = j.a.iCS();
    i.a locala = i.WlJ;
    localObject1 = r.a((Context)localObject1, (String)localObject2, (r.a)i.a.ioY());
    Log.d("MicroMsg.GamePrefetchJsCoreAdapter", kotlin.g.b.s.X("[game-web-prefetch] userAgent=", localObject1));
    AppMethodBeat.o(303222);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    public static final a vVA;
    
    static
    {
      AppMethodBeat.i(303157);
      vVA = new a();
      AppMethodBeat.o(303157);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b<T>
    implements ValueCallback
  {
    b(kotlin.g.a.b<? super String, ah> paramb, kotlin.d.d<? super String> paramd) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(com.tencent.mm.plugin.ay.d paramd, m<? super Boolean, ? super String, ah> paramm, String paramString, kotlin.d.d<? super c> paramd1)
    {
      super(paramd1);
    }
    
    private static final void a(com.tencent.mm.plugin.ay.d paramd, m paramm, String paramString1, String paramString2)
    {
      AppMethodBeat.i(303175);
      com.tencent.mm.plugin.wepkg.b.destroy();
      Object localObject = (CharSequence)paramString2;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if ((i != 0) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
        {
          paramString2 = com.tencent.mm.plugin.brandservice.a.vAp;
          localObject = MultiProcessMMKV.getSingleMMKV("brandService").decodeString("GameCenterJsPath");
          paramString2 = (String)localObject;
          if (localObject == null) {
            paramString2 = "";
          }
          if (((CharSequence)paramString2).length() <= 0) {
            break label129;
          }
          i = 1;
          label91:
          if (i == 0) {
            break label135;
          }
        }
      }
      for (paramString2 = y.bEn(paramString2);; paramString2 = com.tencent.mm.plugin.appbrand.af.d.ags("gamecenter_jscore.js"))
      {
        try
        {
          a.vVy.evaluateJavascript(paramString2, new a.c..ExternalSyntheticLambda0(paramm, paramString1));
          AppMethodBeat.o(303175);
          return;
        }
        catch (Exception paramString2)
        {
          label129:
          label135:
          Log.printErrStackTrace("MicroMsg.GamePrefetchJsCoreAdapter", (Throwable)paramString2, "[game-web-prefetch] inject gamecenter_jscore.js excpetion", new Object[0]);
          paramd.a((d.i)new d.f());
          paramd = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.bn(a.dgJ(), a.dgK(), paramString2.getMessage());
          paramm.invoke(Boolean.FALSE, paramString1);
          AppMethodBeat.o(303175);
        }
        i = 0;
        break;
        i = 0;
        break label91;
      }
    }
    
    private static final void a(m paramm, String paramString1, String paramString2)
    {
      AppMethodBeat.i(303162);
      Log.d("MicroMsg.GamePrefetchJsCoreAdapter", kotlin.g.b.s.X("[game-web-prefetch] initJsContext inject gamecenter_jscore.js result: ", paramString2));
      paramm.invoke(Boolean.TRUE, paramString1);
      AppMethodBeat.o(303162);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(303195);
      paramObject = (kotlin.d.d)new c(this.vVB, paramm, paramString, paramd);
      AppMethodBeat.o(303195);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(303192);
      localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(303192);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = a.vVy;
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        paramObject = a.k("var global = this; var self = this;", paramObject);
        if (paramObject == localObject1)
        {
          AppMethodBeat.o(303192);
          return localObject1;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = a.vVy;
        paramObject = com.tencent.mm.plugin.appbrand.af.d.ags("LuggageBridge.js");
        kotlin.g.b.s.s(paramObject, "getAssetAsString(\"LuggageBridge.js\")");
        Object localObject2 = (kotlin.g.a.b)1.vVD;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 2;
        paramObject = a.f(paramObject, (kotlin.g.a.b)localObject2, locald);
        if (paramObject == localObject1)
        {
          AppMethodBeat.o(303192);
          return localObject1;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = a.vVy;
        paramObject = com.tencent.mm.plugin.appbrand.af.d.ags("luggage_mm_adapter.js");
        kotlin.g.b.s.s(paramObject, "getAssetAsString(\"luggage_mm_adapter.js\")");
        localObject2 = (kotlin.g.a.b)2.vVE;
        locald = (kotlin.d.d)this;
        this.label = 3;
        paramObject = a.f(paramObject, (kotlin.g.a.b)localObject2, locald);
        if (paramObject == localObject1)
        {
          AppMethodBeat.o(303192);
          return localObject1;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = a.vVy;
        paramObject = (kotlin.d.d)this;
        this.label = 4;
        paramObject = a.W(paramObject);
        if (paramObject == localObject1)
        {
          AppMethodBeat.o(303192);
          return localObject1;
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = a.vVy;
        paramObject = (kotlin.g.a.b)3.vVF;
        localObject2 = (kotlin.d.d)this;
        this.label = 5;
        paramObject = a.f("SystemInfo.launchScene = 0;", paramObject, (kotlin.d.d)localObject2);
        if (paramObject != localObject1) {
          break label312;
        }
        AppMethodBeat.o(303192);
        return localObject1;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.GamePrefetchJsCoreAdapter", (Throwable)paramObject, "[game-web-prefetch] inject luggage excpetion", new Object[0]);
          this.vVB.a((d.i)new d.f());
          localObject1 = com.tencent.mm.plugin.webcanvas.j.WkY;
          com.tencent.mm.plugin.webcanvas.j.bn(a.dgJ(), a.dgK(), paramObject.getMessage());
          paramm.invoke(Boolean.FALSE, paramString);
        }
      }
      ResultKt.throwOnFailure(paramObject);
      label312:
      com.tencent.mm.plugin.wepkg.b.a(new a.c..ExternalSyntheticLambda1(this.vVB, paramm, paramString));
      paramObject = ah.aiuX;
      AppMethodBeat.o(303192);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    public static final d vVG;
    
    static
    {
      AppMethodBeat.i(303167);
      vVG = new d();
      AppMethodBeat.o(303167);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */