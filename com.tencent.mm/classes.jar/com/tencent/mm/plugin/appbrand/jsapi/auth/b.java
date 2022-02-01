package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
  implements c
{
  private static final c kxA;
  @Deprecated
  public static final a kxB;
  private static final HashMap<String, b> kxz;
  private final LinkedBlockingQueue<h> kxw;
  private final AtomicInteger kxx;
  private final int kxy;
  
  static
  {
    AppMethodBeat.i(50440);
    kxB = new a((byte)0);
    kxz = new HashMap();
    kxA = (c)b.kxC;
    AppMethodBeat.o(50440);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(50439);
    this.kxy = paramInt;
    this.kxw = new LinkedBlockingQueue();
    this.kxx = new AtomicInteger(0);
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
      if (this.kxx.incrementAndGet() <= this.kxy)
      {
        ad.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "schedule " + paramh.getKey());
        paramh.run();
        AppMethodBeat.o(183053);
        return;
      }
      this.kxw.offer(paramh);
      if (this.kxx.decrementAndGet() >= this.kxy)
      {
        AppMethodBeat.o(183053);
        return;
      }
      paramh = (h)this.kxw.poll();
      if (paramh == null)
      {
        AppMethodBeat.o(183053);
        return;
      }
    }
  }
  
  public final void a(final i parami, final d paramd, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(192345);
    p.h(parami, "api");
    p.h(paramd, "component");
    p.h(paramJSONObject, "data");
    final String str = "name[" + parami.getName() + "], callbackId[" + paramInt + "], appId[" + paramd.getAppId() + ']';
    parami = new c(this, paramd, parami, paramJSONObject, paramInt, str);
    ad.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch ".concat(String.valueOf(str)));
    a((h)parami);
    AppMethodBeat.o(192345);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wechat-full-sdk_release"})
  static final class a
  {
    public static c U(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(50434);
      if (paramAppBrandRuntime == null)
      {
        paramAppBrandRuntime = b.biI();
        AppMethodBeat.o(50434);
        return paramAppBrandRuntime;
      }
      synchronized (b.biJ())
      {
        b.biK();
        b localb = (b)b.biJ().get(paramAppBrandRuntime.getAppId());
        if (localb != null)
        {
          paramAppBrandRuntime = (c)localb;
          AppMethodBeat.o(50434);
          return paramAppBrandRuntime;
        }
        paramAppBrandRuntime = (c)((d.g.a.a)new a(paramAppBrandRuntime)).invoke();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1"})
    static final class a
      extends q
      implements d.g.a.a<b>
    {
      a(AppBrandRuntime paramAppBrandRuntime)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "execute"})
  static final class b
    implements c
  {
    public static final b kxC;
    
    static
    {
      AppMethodBeat.i(50431);
      kxC = new b();
      AppMethodBeat.o(50431);
    }
    
    public final void a(i parami, d paramd, JSONObject paramJSONObject, int paramInt)
    {
      AppMethodBeat.i(192344);
      p.h(parami, "api");
      p.h(paramd, "component");
      p.h(paramJSONObject, "data");
      b.biK();
      ad.e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + parami.getName() + "], callbackId[" + paramInt + "], appId[" + paramd.getAppId() + ']');
      AppMethodBeat.o(192344);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
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
      b.a(this.kxF);
      AppMethodBeat.o(50436);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onAuthResult"})
    static final class a
      implements e
    {
      a(b.c paramc) {}
      
      public final void biH()
      {
        AppMethodBeat.i(50435);
        b.biK();
        ad.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "execute() done, " + this.kxK.kxJ);
        b.a(this.kxK.kxF);
        AppMethodBeat.o(50435);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.b
 * JD-Core Version:    0.7.0.1
 */