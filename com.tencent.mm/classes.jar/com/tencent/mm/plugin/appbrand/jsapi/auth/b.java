package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements c
{
  private static final HashMap<String, b> oAI;
  private static final c oAJ;
  @Deprecated
  public static final a oAK;
  private final LinkedBlockingQueue<h> oAF;
  private final AtomicInteger oAG;
  private final int oAH;
  
  static
  {
    AppMethodBeat.i(50440);
    oAK = new a((byte)0);
    oAI = new HashMap();
    oAJ = (c)b.oAL;
    AppMethodBeat.o(50440);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(50439);
    this.oAH = paramInt;
    this.oAF = new LinkedBlockingQueue();
    this.oAG = new AtomicInteger(0);
    AppMethodBeat.o(50439);
  }
  
  public static final c V(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50443);
    paramAppBrandRuntime = a.V(paramAppBrandRuntime);
    AppMethodBeat.o(50443);
    return paramAppBrandRuntime;
  }
  
  private final void a(h paramh)
  {
    AppMethodBeat.i(183053);
    for (;;)
    {
      if (this.oAG.incrementAndGet() <= this.oAH)
      {
        Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "schedule " + paramh.getKey());
        paramh.run();
        AppMethodBeat.o(183053);
        return;
      }
      this.oAF.offer(paramh);
      if (this.oAG.decrementAndGet() >= this.oAH)
      {
        AppMethodBeat.o(183053);
        return;
      }
      paramh = (h)this.oAF.poll();
      if (paramh == null)
      {
        AppMethodBeat.o(183053);
        return;
      }
    }
  }
  
  public final void a(final i parami, final g paramg, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(250300);
    p.k(parami, "api");
    p.k(paramg, "component");
    p.k(paramJSONObject, "data");
    final String str = "name[" + parami.getName() + "], callbackId[" + paramInt + "], appId[" + paramg.getAppId() + ']';
    parami = new c(this, paramg, parami, paramJSONObject, paramInt, str);
    Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch ".concat(String.valueOf(str)));
    paramJSONObject.put("queueLength", this.oAF.size());
    a((h)parami);
    AppMethodBeat.o(250300);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wechat-full-sdk_release"})
  static final class a
  {
    public static c V(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(50434);
      if (paramAppBrandRuntime == null)
      {
        paramAppBrandRuntime = b.bQf();
        AppMethodBeat.o(50434);
        return paramAppBrandRuntime;
      }
      synchronized (b.bQg())
      {
        b.bQh();
        b localb = (b)b.bQg().get(paramAppBrandRuntime.getAppId());
        if (localb != null)
        {
          paramAppBrandRuntime = (c)localb;
          AppMethodBeat.o(50434);
          return paramAppBrandRuntime;
        }
        paramAppBrandRuntime = (c)((kotlin.g.a.a)new a(paramAppBrandRuntime)).invoke();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"})
  static final class b
    implements c
  {
    public static final b oAL;
    
    static
    {
      AppMethodBeat.i(50431);
      oAL = new b();
      AppMethodBeat.o(50431);
    }
    
    public final void a(i parami, g paramg, JSONObject paramJSONObject, int paramInt)
    {
      AppMethodBeat.i(234401);
      p.k(parami, "api");
      p.k(paramg, "component");
      p.k(paramJSONObject, "data");
      b.bQh();
      Log.e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + parami.getName() + "], callbackId[" + paramInt + "], appId[" + paramg.getAppId() + ']');
      AppMethodBeat.o(234401);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
  public static final class c
    implements h
  {
    c(g paramg, i parami, JSONObject paramJSONObject, int paramInt, String paramString) {}
    
    public final String getKey()
    {
      return str;
    }
    
    public final void run()
    {
      AppMethodBeat.i(50436);
      if (paramg.isRunning())
      {
        parami.a(paramg, paramJSONObject, paramInt, (e)new a((e)new a(this)));
        AppMethodBeat.o(50436);
        return;
      }
      b.a(this.oAO);
      AppMethodBeat.o(50436);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onAuthResult"})
    static final class a
      implements e
    {
      a(b.c paramc) {}
      
      public final void bQe()
      {
        AppMethodBeat.i(50435);
        b.bQh();
        Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "execute() done, " + this.oAS.$key);
        b.a(this.oAS.oAO);
        AppMethodBeat.o(50435);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.b
 * JD-Core Version:    0.7.0.1
 */