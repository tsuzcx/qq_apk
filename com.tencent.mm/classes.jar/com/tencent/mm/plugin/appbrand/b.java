package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandAdWorkerHolder;", "Lcom/tencent/mm/plugin/appbrand/AppBrandWorkerContainer$AdWorkerCreateWatcher;", "()V", "adWorkerCreatedListeners", "", "Lcom/tencent/mm/plugin/appbrand/Listener;", "createCost", "Lkotlin/Pair;", "", "<set-?>", "jsInjectCost", "getJsInjectCost", "()J", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "service", "getService", "()Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "startInjectJsTimestamp", "getStartInjectJsTimestamp", "wokrerCreateInterruptor", "Lcom/tencent/mm/plugin/appbrand/WokrerCreateInterruptor;", "getWokrerCreateInterruptor", "()Lcom/tencent/mm/plugin/appbrand/WokrerCreateInterruptor;", "setWokrerCreateInterruptor", "(Lcom/tencent/mm/plugin/appbrand/WokrerCreateInterruptor;)V", "workerCreateFailErrorMsg", "", "workerEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "workerEngineGuard", "", "destroy", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getAdWorkerCreateWatcher", "getAdWorkerExecutable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "isInterrupt", "", "notifyListener", "listener", "obtainWorkerAsync", "onCreated", "adWorkerInfo", "Lcom/tencent/mm/plugin/appbrand/worker/AppBrandWorkerInfo;", "onJsInjectDone", "startInject", "cost", "storeWorker", "updateInjectCost", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements af.a
{
  public static final b.a qqP;
  final List<as> qqQ;
  private final byte[] qqR;
  m qqS;
  String qqT;
  r<Long, Long> qqU;
  public y qqV;
  public long qqW;
  public long qqX;
  bn qqY;
  
  static
  {
    AppMethodBeat.i(316803);
    qqP = new b.a((byte)0);
    AppMethodBeat.o(316803);
  }
  
  public b()
  {
    AppMethodBeat.i(316796);
    this.qqQ = ((List)new ArrayList());
    this.qqR = new byte[] { 0 };
    this.qqU = new r(Long.valueOf(-1L), Long.valueOf(-1L));
    this.qqW = -1L;
    this.qqX = -1L;
    AppMethodBeat.o(316796);
  }
  
  private final boolean b(as paramas)
  {
    int i = 0;
    AppMethodBeat.i(316799);
    for (;;)
    {
      synchronized (this.qqR)
      {
        Object localObject;
        if (this.qqS == null)
        {
          localObject = this.qqT;
          if (localObject == null)
          {
            AppMethodBeat.o(316799);
            return false;
          }
        }
        if (this.qqS == null)
        {
          localObject = (CharSequence)this.qqT;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {
            break label183;
          }
          if (i == 0)
          {
            Log.i("MicroMsg.AppBrandAdWorkerHolder", "[obtainWorkerAsync]  workerEngine had created, but fail for[" + this.qqT + "], trigger listener");
            paramas.a(null, new r(Long.valueOf(-1L), Long.valueOf(-1L)), this.qqT);
            AppMethodBeat.o(316799);
            return true;
          }
        }
        Log.i("MicroMsg.AppBrandAdWorkerHolder", "[obtainWorkerAsync]  workerEngine had created,trigger listener");
        paramas.a(cbd(), this.qqU, "");
      }
      label183:
      i = 1;
    }
  }
  
  private final o cbd()
  {
    AppMethodBeat.i(316797);
    synchronized (this.qqR)
    {
      m localm = this.qqS;
      if (localm == null)
      {
        AppMethodBeat.o(316797);
        return null;
      }
      ??? = a.qqO;
      ??? = this.qqS;
      s.checkNotNull(???);
      ??? = a.a.g((m)???);
      AppMethodBeat.o(316797);
      return ???;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.ai.b arg1)
  {
    AppMethodBeat.i(316806);
    s.u(???, "adWorkerInfo");
    Object localObject3;
    synchronized (this.qqR)
    {
      localObject3 = this.qqS;
      if (localObject3 != null)
      {
        AppMethodBeat.o(316806);
        return;
      }
      this.qqS = ???.qqS;
      this.qqU = ???.uSm;
      this.qqT = ???.uSn;
      this.qqX = ???.qqX;
      this.qqW = ???.qxn;
      this.qqV = ???.qqV;
      ??? = ah.aiuX;
      Log.i("MicroMsg.AppBrandAdWorkerHolder", s.X("[storeWorker]  CreatedListeners size=", Integer.valueOf(this.qqQ.size())));
      ??? = (List)new ArrayList();
    }
    synchronized (this.qqQ)
    {
      ((List)???).addAll((Collection)this.qqQ);
      this.qqQ.clear();
      localObject3 = ah.aiuX;
      ??? = ((List)???).iterator();
      while (???.hasNext())
      {
        b((as)???.next());
        continue;
        ??? = finally;
        AppMethodBeat.o(316806);
        throw ???;
      }
    }
    AppMethodBeat.o(316806);
  }
  
  public final boolean a(as paramas)
  {
    AppMethodBeat.i(316809);
    s.u(paramas, "listener");
    if (b(paramas))
    {
      AppMethodBeat.o(316809);
      return true;
    }
    synchronized (this.qqQ)
    {
      this.qqQ.add(paramas);
      AppMethodBeat.o(316809);
      return false;
    }
  }
  
  public final void ab(long paramLong1, long paramLong2)
  {
    this.qqW = paramLong1;
    this.qqX = paramLong2;
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.ai.b paramb)
  {
    AppMethodBeat.i(316812);
    s.u(paramb, "adWorkerInfo");
    Log.i("MicroMsg.AppBrandAdWorkerHolder", s.X("AdWorker created. store to holder, ", paramb));
    Object localObject1 = MultiProcessMMKV.getMMKV("paramsCache").decodeString("paramsCache", null);
    Object localObject2 = paramb.qqV;
    s.checkNotNull(localObject2);
    localObject2 = ((y)localObject2).cbl();
    s.checkNotNull(localObject2);
    localObject2 = String.valueOf(((ICommLibReader)localObject2).cfG());
    if ((localObject1 == null) || (!n.U((String)localObject1, (String)localObject2, false)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("#@#");
      ((StringBuilder)localObject1).append(paramb.rRQ);
      Log.i("MicroMsg.AppBrandAdWorkerHolder", "[createWXLibWorker]  params=" + paramb + ".params");
      MultiProcessMMKV.getMMKV("paramsCache").clear();
      MultiProcessMMKV.getMMKV("paramsCache").encode("paramsCache", ((StringBuilder)localObject1).toString());
    }
    a(paramb);
    AppMethodBeat.o(316812);
  }
  
  public final boolean cbe()
  {
    AppMethodBeat.i(316818);
    if (this.qqY == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrandAdWorkerHolder", s.X("wokrerCreateInterruptor == null:  ", Boolean.valueOf(bool)));
      if (this.qqY != null) {
        break;
      }
      AppMethodBeat.o(316818);
      return false;
    }
    bn localbn = this.qqY;
    s.checkNotNull(localbn);
    bool = localbn.cbe();
    AppMethodBeat.o(316818);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b
 * JD-Core Version:    0.7.0.1
 */