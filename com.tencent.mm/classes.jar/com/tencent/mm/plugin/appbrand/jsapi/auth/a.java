package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "mConcurrentMaxCount", "", "(I)V", "mInFlightTasks", "Ljava/util/concurrent/atomic/AtomicInteger;", "mTaskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/mm/sdk/thread/runnable/KeyRunnable;", "cleanup", "", "dispatch", "task", "dispatchNext", "execute", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "data", "Lorg/json/JSONObject;", "callbackId", "schedule", "Companion", "plugin-appbrand-integration_release"})
public final class a
  implements b
{
  private static final HashMap<String, a> hCY;
  private static final b hCZ;
  @Deprecated
  public static final a.a hDa;
  private final LinkedBlockingQueue<com.tencent.mm.sdk.g.d.b> hCV;
  private final AtomicInteger hCW;
  private final int hCX;
  
  static
  {
    AppMethodBeat.i(134653);
    hDa = new a.a((byte)0);
    hCY = new HashMap();
    hCZ = (b)a.b.hDb;
    AppMethodBeat.o(134653);
  }
  
  public a(int paramInt)
  {
    AppMethodBeat.i(134652);
    this.hCX = paramInt;
    this.hCV = new LinkedBlockingQueue();
    this.hCW = new AtomicInteger(0);
    AppMethodBeat.o(134652);
  }
  
  private final void a(com.tencent.mm.sdk.g.d.b paramb)
  {
    AppMethodBeat.i(134651);
    for (;;)
    {
      if (this.hCW.incrementAndGet() <= this.hCX)
      {
        ab.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "schedule " + paramb.getKey());
        paramb.run();
        AppMethodBeat.o(134651);
        return;
      }
      this.hCV.offer(paramb);
      if (this.hCW.decrementAndGet() >= this.hCX)
      {
        AppMethodBeat.o(134651);
        return;
      }
      paramb = (com.tencent.mm.sdk.g.d.b)this.hCV.poll();
      if (paramb == null)
      {
        AppMethodBeat.o(134651);
        return;
      }
    }
  }
  
  public static final b x(i parami)
  {
    AppMethodBeat.i(134656);
    parami = a.a.x(parami);
    AppMethodBeat.o(134656);
    return parami;
  }
  
  public final void a(f paramf, h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(134650);
    j.q(paramf, "api");
    j.q(paramh, "component");
    j.q(paramJSONObject, "data");
    String str = "name[" + paramf.getName() + "], callbackId[" + paramInt + "], appId[" + paramh.getAppId() + ']';
    paramf = new a.c(this, paramh, paramf, paramJSONObject, paramInt, str);
    ab.d("MicroMsg.AppBrandAuthJSAPIConcurrentQueue", "dispatch ".concat(String.valueOf(str)));
    a((com.tencent.mm.sdk.g.d.b)paramf);
    AppMethodBeat.o(134650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.a
 * JD-Core Version:    0.7.0.1
 */