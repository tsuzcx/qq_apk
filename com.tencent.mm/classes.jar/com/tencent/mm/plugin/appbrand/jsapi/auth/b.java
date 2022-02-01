package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements c
{
  private static final HashMap<String, b> lFh;
  private static final c lFi;
  @Deprecated
  public static final a lFj;
  private final LinkedBlockingQueue<h> lFe;
  private final AtomicInteger lFf;
  private final int lFg;
  
  static
  {
    AppMethodBeat.i(50440);
    lFj = new a((byte)0);
    lFh = new HashMap();
    lFi = (c)b.lFk;
    AppMethodBeat.o(50440);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(50439);
    this.lFg = paramInt;
    this.lFe = new LinkedBlockingQueue();
    this.lFf = new AtomicInteger(0);
    AppMethodBeat.o(50439);
  }
  
  public static final c U(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50443);
    paramAppBrandRuntime = a.U(paramAppBrandRuntime);
    AppMethodBeat.o(50443);
    return paramAppBrandRuntime;
  }
  
  private final void a(h paramh)
  {
    AppMethodBeat.i(183053);
    for (;;)
    {
      if (this.lFf.incrementAndGet() <= this.lFg)
      {
        Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "schedule " + paramh.getKey());
        paramh.run();
        AppMethodBeat.o(183053);
        return;
      }
      this.lFe.offer(paramh);
      if (this.lFf.decrementAndGet() >= this.lFg)
      {
        AppMethodBeat.o(183053);
        return;
      }
      paramh = (h)this.lFe.poll();
      if (paramh == null)
      {
        AppMethodBeat.o(183053);
        return;
      }
    }
  }
  
  public final void a(final i parami, final d paramd, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(230069);
    p.h(parami, "api");
    p.h(paramd, "component");
    p.h(paramJSONObject, "data");
    final String str = "name[" + parami.getName() + "], callbackId[" + paramInt + "], appId[" + paramd.getAppId() + ']';
    parami = new c(this, paramd, parami, paramJSONObject, paramInt, str);
    Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch ".concat(String.valueOf(str)));
    paramJSONObject.put("queueLength", this.lFe.size());
    a((h)parami);
    AppMethodBeat.o(230069);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wechat-full-sdk_release"})
  static final class a
  {
    public static c U(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(50434);
      if (paramAppBrandRuntime == null)
      {
        paramAppBrandRuntime = b.bEF();
        AppMethodBeat.o(50434);
        return paramAppBrandRuntime;
      }
      synchronized (b.bEG())
      {
        b.bEH();
        b localb = (b)b.bEG().get(paramAppBrandRuntime.getAppId());
        if (localb != null)
        {
          paramAppBrandRuntime = (c)localb;
          AppMethodBeat.o(50434);
          return paramAppBrandRuntime;
        }
        paramAppBrandRuntime = (c)((kotlin.g.a.a)new a(paramAppBrandRuntime)).invoke();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<b>
    {
      a(AppBrandRuntime paramAppBrandRuntime)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"})
  static final class b
    implements c
  {
    public static final b lFk;
    
    static
    {
      AppMethodBeat.i(50431);
      lFk = new b();
      AppMethodBeat.o(50431);
    }
    
    public final void a(i parami, d paramd, JSONObject paramJSONObject, int paramInt)
    {
      AppMethodBeat.i(230068);
      p.h(parami, "api");
      p.h(paramd, "component");
      p.h(paramJSONObject, "data");
      b.bEH();
      Log.e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + parami.getName() + "], callbackId[" + paramInt + "], appId[" + paramd.getAppId() + ']');
      AppMethodBeat.o(230068);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
  public static final class c
    implements h
  {
    c(d paramd, i parami, JSONObject paramJSONObject, int paramInt, String paramString) {}
    
    public final String getKey()
    {
      return str;
    }
    
    public final void run()
    {
      AppMethodBeat.i(50436);
      if (paramd.isRunning())
      {
        parami.a(paramd, paramJSONObject, paramInt, (e)new a((e)new a(this)));
        AppMethodBeat.o(50436);
        return;
      }
      b.a(this.lFn);
      AppMethodBeat.o(50436);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onAuthResult"})
    static final class a
      implements e
    {
      a(b.c paramc) {}
      
      public final void bEE()
      {
        AppMethodBeat.i(50435);
        b.bEH();
        Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "execute() done, " + this.lFr.$key);
        b.a(this.lFr.lFn);
        AppMethodBeat.o(50435);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.b
 * JD-Core Version:    0.7.0.1
 */