package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.h;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "invokeContext", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsInvokeContext;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "schedule", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c
{
  @Deprecated
  private static final HashMap<String, b> rEC;
  @Deprecated
  private static final c rED;
  private static final a rEy;
  private final LinkedBlockingQueue<h> rEA;
  private final AtomicInteger rEB;
  private final int rEz;
  
  static
  {
    AppMethodBeat.i(50440);
    rEy = new a((byte)0);
    rEC = new HashMap();
    rED = b..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(50440);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(50439);
    this.rEz = paramInt;
    this.rEA = new LinkedBlockingQueue();
    this.rEB = new AtomicInteger(0);
    AppMethodBeat.o(50439);
  }
  
  private static final void a(j paramj, dh paramdh)
  {
    AppMethodBeat.i(326880);
    s.u(paramj, "api");
    s.u(paramdh, "$dstr$_u24__u24$component$_u24__u24$_u24__u24$callbackId");
    g localg = (g)paramdh.rBv;
    int i = paramdh.ror;
    Log.e("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dummy execute name[" + paramj.getName() + "], callbackId[" + i + "], appId[" + localg.getAppId() + ']');
    AppMethodBeat.o(326880);
  }
  
  private final void a(h paramh)
  {
    AppMethodBeat.i(183053);
    for (;;)
    {
      if (this.rEB.incrementAndGet() <= this.rEz)
      {
        Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", s.X("schedule ", paramh.getKey()));
        paramh.run();
        AppMethodBeat.o(183053);
        return;
      }
      this.rEA.offer(paramh);
      if (this.rEB.decrementAndGet() >= this.rEz)
      {
        AppMethodBeat.o(183053);
        return;
      }
      paramh = (h)this.rEA.poll();
      if (paramh == null)
      {
        AppMethodBeat.o(183053);
        return;
      }
    }
  }
  
  public static final c ac(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50443);
    paramAppBrandRuntime = a.ac(paramAppBrandRuntime);
    AppMethodBeat.o(50443);
    return paramAppBrandRuntime;
  }
  
  public final void execute(final j paramj, final dh<g> paramdh)
  {
    AppMethodBeat.i(326899);
    s.u(paramj, "api");
    s.u(paramdh, "invokeContext");
    g localg = (g)paramdh.rBv;
    JSONObject localJSONObject = paramdh.rmi;
    int i = paramdh.ror;
    final String str = "name[" + paramj.getName() + "], callbackId[" + i + "], appId[" + localg.getAppId() + ']';
    paramj = new b(localg, paramj, paramdh, this, str);
    Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", s.X("dispatch ", str));
    localJSONObject.put("queueLength", this.rEA.size());
    a((h)paramj);
    AppMethodBeat.o(326899);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    private static final void a(AppBrandRuntime paramAppBrandRuntime, String arg1, com.tencent.mm.plugin.appbrand.b.b paramb)
    {
      AppMethodBeat.i(326938);
      if (paramb == com.tencent.mm.plugin.appbrand.b.b.qKz) {
        synchronized (b.cqm())
        {
          paramAppBrandRuntime = (b)b.cqm().remove(paramAppBrandRuntime.mAppId);
          if (paramAppBrandRuntime != null)
          {
            b.a(paramAppBrandRuntime);
            paramAppBrandRuntime = ah.aiuX;
          }
          AppMethodBeat.o(326938);
          return;
        }
      }
      AppMethodBeat.o(326938);
    }
    
    public static c ac(AppBrandRuntime paramAppBrandRuntime)
    {
      int i = 10;
      AppMethodBeat.i(50434);
      if (paramAppBrandRuntime == null)
      {
        paramAppBrandRuntime = b.cql();
        AppMethodBeat.o(50434);
        return paramAppBrandRuntime;
      }
      for (;;)
      {
        Object localObject;
        synchronized (b.cqm())
        {
          b localb = (b)b.cqm().get(paramAppBrandRuntime.mAppId);
          localObject = localb;
          if (localb == null)
          {
            localObject = paramAppBrandRuntime.asG();
            if ((localObject instanceof AppBrandSysConfigLU))
            {
              localObject = (AppBrandSysConfigLU)localObject;
              break label155;
              localObject = new b(i);
              b.cqm().put(paramAppBrandRuntime.mAppId, localObject);
              paramAppBrandRuntime.qsB.a(new b.a..ExternalSyntheticLambda0(paramAppBrandRuntime));
            }
          }
          else
          {
            paramAppBrandRuntime = (c)localObject;
            AppMethodBeat.o(50434);
            return paramAppBrandRuntime;
          }
          localObject = null;
          break label155;
          localObject = ((AppBrandSysConfigLU)localObject).eqf;
          if (localObject == null) {
            continue;
          }
          i = ((AppBrandGlobalSystemConfig)localObject).qXm;
        }
        label155:
        if (localObject != null) {}
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements h
  {
    b(g paramg, j paramj, dh<g> paramdh, b paramb, String paramString) {}
    
    private static final void a(String paramString, b paramb)
    {
      AppMethodBeat.i(326928);
      s.u(paramString, "$key");
      s.u(paramb, "this$0");
      Log.i("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", s.X("execute() done, ", paramString));
      b.b(paramb);
      AppMethodBeat.o(326928);
    }
    
    public final String getKey()
    {
      return str;
    }
    
    public final void run()
    {
      AppMethodBeat.i(50436);
      if (this.rEE.isRunning())
      {
        paramj.a(paramdh, (e)new a(new b.b..ExternalSyntheticLambda0(str, jdField_this)));
        AppMethodBeat.o(50436);
        return;
      }
      b.b(jdField_this);
      AppMethodBeat.o(50436);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.b
 * JD-Core Version:    0.7.0.1
 */