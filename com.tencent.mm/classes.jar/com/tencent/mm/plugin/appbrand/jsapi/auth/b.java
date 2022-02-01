package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.y;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements c
{
  private static final HashMap<String, b> kcZ;
  private static final c kda;
  @Deprecated
  public static final a kdb;
  private final LinkedBlockingQueue<com.tencent.e.i.h> kcW;
  private final AtomicInteger kcX;
  private final int kcY;
  
  static
  {
    AppMethodBeat.i(50440);
    kdb = new a((byte)0);
    kcZ = new HashMap();
    kda = (c)b.kdc;
    AppMethodBeat.o(50440);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(50439);
    this.kcY = paramInt;
    this.kcW = new LinkedBlockingQueue();
    this.kcX = new AtomicInteger(0);
    AppMethodBeat.o(50439);
  }
  
  private final void a(com.tencent.e.i.h paramh)
  {
    AppMethodBeat.i(183053);
    for (;;)
    {
      if (this.kcX.incrementAndGet() <= this.kcY)
      {
        ac.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "schedule " + paramh.getKey());
        paramh.run();
        AppMethodBeat.o(183053);
        return;
      }
      this.kcW.offer(paramh);
      if (this.kcX.decrementAndGet() >= this.kcY)
      {
        AppMethodBeat.o(183053);
        return;
      }
      paramh = (com.tencent.e.i.h)this.kcW.poll();
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
    ac.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch ".concat(String.valueOf(str)));
    a((com.tencent.e.i.h)paramh);
    AppMethodBeat.o(50437);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wechat-full-sdk_release"})
  static final class a
  {
    public static c aa(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(50434);
      if (paramAppBrandRuntime == null)
      {
        paramAppBrandRuntime = b.bff();
        AppMethodBeat.o(50434);
        return paramAppBrandRuntime;
      }
      synchronized (b.bfg())
      {
        b.bfh();
        b localb = (b)b.bfg().get(paramAppBrandRuntime.getAppId());
        if (localb != null)
        {
          paramAppBrandRuntime = (c)localb;
          AppMethodBeat.o(50434);
          return paramAppBrandRuntime;
        }
        paramAppBrandRuntime = (c)((d.g.a.a)new a(paramAppBrandRuntime)).invoke();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"})
  static final class b
    implements c
  {
    public static final b kdc;
    
    static
    {
      AppMethodBeat.i(50431);
      kdc = new b();
      AppMethodBeat.o(50431);
    }
    
    public final void a(h paramh, com.tencent.mm.plugin.appbrand.jsapi.h paramh1, JSONObject paramJSONObject, int paramInt)
    {
      AppMethodBeat.i(50430);
      k.h(paramh, "api");
      k.h(paramh1, "component");
      k.h(paramJSONObject, "data");
      b.bfh();
      ac.e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + paramh.getName() + "], callbackId[" + paramInt + "], appId[" + paramh1.getAppId() + ']');
      AppMethodBeat.o(50430);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
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
      b.a(this.kdf);
      AppMethodBeat.o(50436);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onAuthResult"})
    static final class a
      implements e
    {
      a(b.c paramc) {}
      
      public final void bfe()
      {
        AppMethodBeat.i(50435);
        b.bfh();
        ac.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "execute() done, " + this.kdk.kdj);
        b.a(this.kdk.kdf);
        AppMethodBeat.o(50435);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.b
 * JD-Core Version:    0.7.0.1
 */