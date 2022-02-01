package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements c
{
  private static final HashMap<String, b> jCD;
  private static final c jCE;
  @Deprecated
  public static final a jCF;
  private final LinkedBlockingQueue<com.tencent.e.i.h> jCA;
  private final AtomicInteger jCB;
  private final int jCC;
  
  static
  {
    AppMethodBeat.i(50440);
    jCF = new a((byte)0);
    jCD = new HashMap();
    jCE = (c)b.jCG;
    AppMethodBeat.o(50440);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(50439);
    this.jCC = paramInt;
    this.jCA = new LinkedBlockingQueue();
    this.jCB = new AtomicInteger(0);
    AppMethodBeat.o(50439);
  }
  
  private final void a(com.tencent.e.i.h paramh)
  {
    AppMethodBeat.i(183053);
    for (;;)
    {
      if (this.jCB.incrementAndGet() <= this.jCC)
      {
        ad.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "schedule " + paramh.getKey());
        paramh.run();
        AppMethodBeat.o(183053);
        return;
      }
      this.jCA.offer(paramh);
      if (this.jCB.decrementAndGet() >= this.jCC)
      {
        AppMethodBeat.o(183053);
        return;
      }
      paramh = (com.tencent.e.i.h)this.jCA.poll();
      if (paramh == null)
      {
        AppMethodBeat.o(183053);
        return;
      }
    }
  }
  
  public static final c aa(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50443);
    paramAppBrandRuntime = a.aa(paramAppBrandRuntime);
    AppMethodBeat.o(50443);
    return paramAppBrandRuntime;
  }
  
  public final void a(final h paramh, final com.tencent.mm.plugin.appbrand.jsapi.h paramh1, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(50437);
    k.h(paramh, "api");
    k.h(paramh1, "component");
    k.h(paramJSONObject, "data");
    final String str = "name[" + paramh.getName() + "], callbackId[" + paramInt + "], appId[" + paramh1.getAppId() + ']';
    paramh = new c(this, paramh1, paramh, paramJSONObject, paramInt, str);
    ad.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch ".concat(String.valueOf(str)));
    a((com.tencent.e.i.h)paramh);
    AppMethodBeat.o(50437);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wechat-full-sdk_release"})
  static final class a
  {
    public static c aa(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(50434);
      if (paramAppBrandRuntime == null)
      {
        paramAppBrandRuntime = b.aYi();
        AppMethodBeat.o(50434);
        return paramAppBrandRuntime;
      }
      synchronized (b.aYj())
      {
        b.aYk();
        b localb = (b)b.aYj().get(paramAppBrandRuntime.getAppId());
        if (localb != null)
        {
          paramAppBrandRuntime = (c)localb;
          AppMethodBeat.o(50434);
          return paramAppBrandRuntime;
        }
        paramAppBrandRuntime = (c)((d.g.a.a)new a(paramAppBrandRuntime)).invoke();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<b>
    {
      a(AppBrandRuntime paramAppBrandRuntime)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"})
  static final class b
    implements c
  {
    public static final b jCG;
    
    static
    {
      AppMethodBeat.i(50431);
      jCG = new b();
      AppMethodBeat.o(50431);
    }
    
    public final void a(h paramh, com.tencent.mm.plugin.appbrand.jsapi.h paramh1, JSONObject paramJSONObject, int paramInt)
    {
      AppMethodBeat.i(50430);
      k.h(paramh, "api");
      k.h(paramh1, "component");
      k.h(paramJSONObject, "data");
      b.aYk();
      ad.e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + paramh.getName() + "], callbackId[" + paramInt + "], appId[" + paramh1.getAppId() + ']');
      AppMethodBeat.o(50430);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
  public static final class c
    implements com.tencent.e.i.h
  {
    c(com.tencent.mm.plugin.appbrand.jsapi.h paramh, h paramh1, JSONObject paramJSONObject, int paramInt, String paramString) {}
    
    public final String getKey()
    {
      return str;
    }
    
    public final void run()
    {
      AppMethodBeat.i(50436);
      if (paramh1.isRunning())
      {
        paramh.a(paramh1, paramJSONObject, paramInt, (e)new a((e)new a(this)));
        AppMethodBeat.o(50436);
        return;
      }
      b.a(this.jCJ);
      AppMethodBeat.o(50436);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onAuthResult"})
    static final class a
      implements e
    {
      a(b.c paramc) {}
      
      public final void aYh()
      {
        AppMethodBeat.i(50435);
        b.aYk();
        ad.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "execute() done, " + this.jCO.jCN);
        b.a(this.jCO.jCJ);
        AppMethodBeat.o(50435);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.b
 * JD-Core Version:    0.7.0.1
 */