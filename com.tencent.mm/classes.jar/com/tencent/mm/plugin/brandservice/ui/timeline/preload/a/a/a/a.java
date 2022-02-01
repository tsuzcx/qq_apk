package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.webkit.ValueCallback;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.bridge.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.av.i;
import com.tencent.mm.plugin.av.i.a;
import com.tencent.mm.plugin.aw.f;
import com.tencent.mm.plugin.aw.f.f;
import com.tencent.mm.plugin.aw.f.i;
import com.tencent.mm.plugin.webview.k.h;
import com.tencent.mm.plugin.webview.k.h.a;
import com.tencent.mm.plugin.wepkg.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import java.util.Arrays;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.g.b.q;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.br;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/adapter/GamePrefetchJsCoreAdapter;", "Lcom/tencent/luggage/container/LuggageJsCoreInterface;", "()V", "GAME_CENTER_JSCORE_JS", "", "TAG", "bizAppId", "contextName", "jsContext", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "luggageBridge", "Lcom/tencent/luggage/bridge/LuggageBridge;", "addJavascriptInterface", "", "obj", "", "name", "attach", "appId", "destroy", "evaluateJavascript", "script", "resultCallback", "Landroid/webkit/ValueCallback;", "evaluateJavascriptSync", "callback", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBridge", "getContext", "Landroid/content/Context;", "getUserAgent", "init", "context", "url", "initCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "success", "contextReporter", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngineContextReporter;", "initSystemInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectInitScript", "plugin-brandservice_release"})
public final class a
  implements com.tencent.luggage.d.g
{
  private static String contextName;
  private static String mpE;
  private static com.tencent.mm.plugin.appbrand.m.g sPT;
  private static o sQh;
  public static final a sQi;
  
  static
  {
    AppMethodBeat.i(264483);
    sQi = new a();
    mpE = "";
    contextName = "";
    AppMethodBeat.o(264483);
  }
  
  public static final void a(com.tencent.mm.plugin.appbrand.m.g paramg, final String paramString, final m<? super Boolean, ? super String, x> paramm, f paramf)
  {
    AppMethodBeat.i(264476);
    kotlin.g.b.p.k(paramg, "context");
    kotlin.g.b.p.k(paramm, "initCallback");
    kotlin.g.b.p.k(paramf, "contextReporter");
    Log.i("MicroMsg.GamePrefetchJsCoreAdapter", "alvinluo initGameJsPrefetchJsCore");
    sPT = paramg;
    sQh = new o((s)sQi);
    kotlinx.coroutines.g.b((ak)br.abxo, null, (m)new c(paramf, paramm, paramString, null), 3);
    AppMethodBeat.o(264476);
  }
  
  public static final void fz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264475);
    kotlin.g.b.p.k(paramString1, "appId");
    kotlin.g.b.p.k(paramString2, "contextName");
    mpE = paramString1;
    contextName = paramString2;
    AppMethodBeat.o(264475);
  }
  
  public static o getBridge()
  {
    return sQh;
  }
  
  public final void NV() {}
  
  public final void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(264477);
    com.tencent.mm.plugin.appbrand.m.g localg = sPT;
    if (localg != null)
    {
      localg.addJavascriptInterface(paramObject, paramString);
      AppMethodBeat.o(264477);
      return;
    }
    AppMethodBeat.o(264477);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(264482);
    sQh = null;
    com.tencent.mm.plugin.appbrand.m.g localg = sPT;
    if (localg != null)
    {
      localg.destroy();
      AppMethodBeat.o(264482);
      return;
    }
    AppMethodBeat.o(264482);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(264478);
    com.tencent.mm.plugin.appbrand.m.g localg = sPT;
    if (localg != null)
    {
      localg.evaluateJavascript(paramString, paramValueCallback);
      AppMethodBeat.o(264478);
      return;
    }
    AppMethodBeat.o(264478);
  }
  
  public final Context getContext()
  {
    return null;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(264481);
    Object localObject1 = MMApplicationContext.getContext();
    Object localObject2 = h.QAa;
    localObject2 = h.a.hcr();
    i.a locala = i.Pvp;
    localObject1 = com.tencent.mm.plugin.appbrand.ac.p.a((Context)localObject1, (String)localObject2, (p.a)i.a.gPE());
    Log.d("MicroMsg.GamePrefetchJsCoreAdapter", "[game-web-prefetch] userAgent=".concat(String.valueOf(localObject1)));
    AppMethodBeat.o(264481);
    return localObject1;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/game/jsapi/adapter/GamePrefetchJsCoreAdapter$evaluateJavascriptSync$3$1"})
  static final class a<T>
    implements ValueCallback<String>
  {
    a(kotlin.d.d paramd, String paramString, kotlin.g.a.b paramb) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final b sQk;
    
    static
    {
      AppMethodBeat.i(260733);
      sQk = new b();
      AppMethodBeat.o(260733);
    }
    
    b()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    c(f paramf, m paramm, String paramString, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(258486);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new c(this.sQl, paramm, paramString, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(258486);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(258488);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(258488);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(258483);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(258483);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
      }
      try
      {
        localObject1 = a.sQi;
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = a.c("var global = this; var self = this;", this);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(258483);
          return locala;
          localObject1 = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject1;
        }
        localObject1 = a.sQi;
        localObject1 = com.tencent.mm.plugin.appbrand.ac.d.anc("LuggageBridge.js");
        kotlin.g.b.p.j(localObject1, "AppBrandIOUtil.getAssetA…tring(\"LuggageBridge.js\")");
        localObject2 = (kotlin.g.a.b)1.sQn;
        this.L$0 = paramObject;
        this.label = 2;
        localObject1 = a.a((String)localObject1, (kotlin.g.a.b)localObject2, this);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(258483);
          return locala;
          localObject1 = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject1;
        }
        localObject1 = a.sQi;
        localObject1 = com.tencent.mm.plugin.appbrand.ac.d.anc("luggage_mm_adapter.js");
        kotlin.g.b.p.j(localObject1, "AppBrandIOUtil.getAssetA…(\"luggage_mm_adapter.js\")");
        localObject2 = (kotlin.g.a.b)2.sQo;
        this.L$0 = paramObject;
        this.label = 3;
        localObject1 = a.a((String)localObject1, (kotlin.g.a.b)localObject2, this);
        if (localObject1 == locala)
        {
          AppMethodBeat.o(258483);
          return locala;
          localObject1 = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject1;
        }
        localObject1 = a.sQi;
        this.L$0 = paramObject;
        this.label = 4;
        Object localObject3 = ax.au(MMApplicationContext.getContext());
        int i = ((Point)localObject3).y;
        int j = ax.ew(MMApplicationContext.getContext());
        int k = ax.getStatusBarHeight(MMApplicationContext.getContext());
        int m = ax.aB(MMApplicationContext.getContext());
        float f = com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext());
        localObject1 = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        localObject2 = com.tencent.mm.plugin.appbrand.ac.d.anc("game_jscore_system_info.js");
        Object localObject4 = af.aaBG;
        kotlin.g.b.p.j(localObject2, "systemInfoFormat");
        int n = ((Point)localObject3).x;
        int i1 = ((Point)localObject3).x;
        int i2 = ((Point)localObject3).y;
        localObject3 = Build.BRAND;
        localObject4 = Build.MODEL;
        Object localObject5 = af.aaBG;
        localObject5 = String.format("0x%08X", Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.RAD) }, 1));
        kotlin.g.b.p.j(localObject5, "java.lang.String.format(format, *args)");
        localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { String.valueOf(n), String.valueOf(i - j - k - m), String.valueOf(i1), String.valueOf(i2), String.valueOf(f), localObject1, localObject3, localObject4, localObject5, "Android-" + Build.VERSION.SDK_INT, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), Boolean.valueOf(ar.isDarkMode()) }, 12));
        kotlin.g.b.p.j(localObject1, "java.lang.String.format(format, *args)");
        localObject2 = a.a((String)localObject1, (kotlin.g.a.b)a.d.sQs, this);
        localObject1 = localObject2;
        if (localObject2 != kotlin.d.a.a.aaAA) {
          localObject1 = x.aazN;
        }
        if (localObject1 == locala)
        {
          AppMethodBeat.o(258483);
          return locala;
          localObject1 = (ak)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          paramObject = localObject1;
        }
        localObject1 = a.sQi;
        localObject1 = (kotlin.g.a.b)3.sQp;
        this.L$0 = paramObject;
        this.label = 5;
        paramObject = a.a("SystemInfo.launchScene = 0;", (kotlin.g.a.b)localObject1, this);
        if (paramObject != locala) {
          break label694;
        }
        AppMethodBeat.o(258483);
        return locala;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.GamePrefetchJsCoreAdapter", (Throwable)paramObject, "[game-web-prefetch] inject luggage excpetion", new Object[0]);
          this.sQl.a((f.i)new f.f());
          Object localObject1 = com.tencent.mm.plugin.webcanvas.l.PuB;
          localObject1 = a.sQi;
          localObject1 = a.cDk();
          Object localObject2 = a.sQi;
          com.tencent.mm.plugin.webcanvas.l.aU((String)localObject1, a.cDl(), paramObject.getMessage());
          paramm.invoke(Boolean.FALSE, paramString);
        }
      }
      ResultKt.throwOnFailure(paramObject);
      label694:
      com.tencent.mm.plugin.wepkg.b.a((b.a)new b.a()
      {
        public final void aqk(String paramAnonymousString)
        {
          AppMethodBeat.i(267024);
          com.tencent.mm.plugin.wepkg.b.destroy();
          Object localObject = (CharSequence)paramAnonymousString;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
          for (int i = 1;; i = 0)
          {
            if ((i != 0) || (BuildInfo.DEBUG)) {
              paramAnonymousString = com.tencent.mm.plugin.appbrand.ac.d.anc("gamecenter_jscore.js");
            }
            try
            {
              a.sQi.evaluateJavascript(paramAnonymousString, (ValueCallback)new ValueCallback() {});
              AppMethodBeat.o(267024);
              return;
            }
            catch (Exception paramAnonymousString)
            {
              Log.printErrStackTrace("MicroMsg.GamePrefetchJsCoreAdapter", (Throwable)paramAnonymousString, "[game-web-prefetch] inject gamecenter_jscore.js excpetion", new Object[0]);
              this.sQq.sQl.a((f.i)new f.f());
              localObject = com.tencent.mm.plugin.webcanvas.l.PuB;
              localObject = a.sQi;
              localObject = a.cDk();
              a locala = a.sQi;
              com.tencent.mm.plugin.webcanvas.l.aU((String)localObject, a.cDl(), paramAnonymousString.getMessage());
              this.sQq.sQm.invoke(Boolean.FALSE, this.sQq.piM);
              AppMethodBeat.o(267024);
            }
          }
        }
      });
      paramObject = x.aazN;
      AppMethodBeat.o(258483);
      return paramObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<String, x>
  {
    public static final d sQs;
    
    static
    {
      AppMethodBeat.i(266967);
      sQs = new d();
      AppMethodBeat.o(266967);
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