package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandAdWorkerHolder;", "Lcom/tencent/mm/plugin/appbrand/AppBrandWorkerContainer$AdWorkerCreateWatcher;", "()V", "adWorkerCreatedListeners", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandAdWorkerHolder$Listener;", "createCost", "Lkotlin/Pair;", "", "<set-?>", "jsInjectCost", "getJsInjectCost", "()J", "startInjectJsTimestamp", "getStartInjectJsTimestamp", "workerCreateFailErrorMsg", "", "workerEngine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "workerEngineGuard", "", "destroy", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getAdWorkerCreateWatcher", "getAdWorkerExecutable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "notifyListener", "", "listener", "obtainWorkerAsync", "onCreated", "adWorkerInfo", "Lcom/tencent/mm/plugin/appbrand/worker/AppBrandWorkerInfo;", "onJsInjectDone", "startInject", "cost", "storeWorker", "updateInjectCost", "Companion", "Listener", "luggage-wxa-app_release"})
public final class b
  implements ab.a
{
  public static final b.a nst;
  final List<b> nsm;
  m nsn;
  String nso;
  kotlin.o<Long, Long> nsp;
  private final byte[] nsq;
  public long nsr;
  public long nss;
  
  static
  {
    AppMethodBeat.i(244338);
    nst = new b.a((byte)0);
    AppMethodBeat.o(244338);
  }
  
  public b()
  {
    AppMethodBeat.i(244337);
    this.nsm = ((List)new ArrayList());
    this.nsp = new kotlin.o(Long.valueOf(-1L), Long.valueOf(-1L));
    this.nsq = new byte[] { 0 };
    this.nsr = -1L;
    this.nss = -1L;
    AppMethodBeat.o(244337);
  }
  
  private final boolean b(b paramb)
  {
    int i = 0;
    AppMethodBeat.i(244335);
    for (;;)
    {
      synchronized (this.nsq)
      {
        Object localObject;
        if (this.nsn == null)
        {
          localObject = this.nso;
          if (localObject == null)
          {
            AppMethodBeat.o(244335);
            return false;
          }
        }
        if (this.nsn == null)
        {
          localObject = (CharSequence)this.nso;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {
            break label159;
          }
          if (i == 0)
          {
            Log.i("MicroMsg.AppBrandAdWorkerHolder", "[obtainWorkerAsync]  workerEngine had created, but fail for[" + this.nso + "], trigger listener");
            paramb.a(null, null);
            AppMethodBeat.o(244335);
            return true;
          }
        }
        Log.i("MicroMsg.AppBrandAdWorkerHolder", "[obtainWorkerAsync]  workerEngine had created,trigger listener");
        paramb.a(bBJ(), this.nsp);
      }
      label159:
      i = 1;
    }
  }
  
  private final com.tencent.mm.plugin.appbrand.m.o bBJ()
  {
    AppMethodBeat.i(244333);
    synchronized (this.nsq)
    {
      m localm = this.nsn;
      if (localm == null)
      {
        AppMethodBeat.o(244333);
        return null;
      }
      ??? = a.nsj;
      ??? = this.nsn;
      if (??? == null) {
        p.iCn();
      }
      ??? = a.a.b((m)???);
      AppMethodBeat.o(244333);
      return ???;
    }
  }
  
  public final void E(long paramLong1, long paramLong2)
  {
    this.nsr = paramLong1;
    this.nss = paramLong2;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.ah.b arg1)
  {
    AppMethodBeat.i(244332);
    p.k(???, "adWorkerInfo");
    Object localObject3;
    synchronized (this.nsq)
    {
      localObject3 = this.nsn;
      if (localObject3 != null)
      {
        AppMethodBeat.o(244332);
        return;
      }
      this.nsn = ???.nsn;
      this.nsp = ???.rGX;
      this.nso = ???.rGY;
      this.nss = ???.nss;
      this.nsr = ???.nxY;
      ??? = x.aazN;
      Log.i("MicroMsg.AppBrandAdWorkerHolder", "[storeWorker]  CreatedListeners size=" + this.nsm.size());
      ??? = (List)new ArrayList();
    }
    synchronized (this.nsm)
    {
      ((List)???).addAll((Collection)this.nsm);
      this.nsm.clear();
      localObject3 = x.aazN;
      ??? = ((List)???).iterator();
      while (???.hasNext())
      {
        b((b)???.next());
        continue;
        ??? = finally;
        AppMethodBeat.o(244332);
        throw ???;
      }
    }
    AppMethodBeat.o(244332);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(244334);
    p.k(paramb, "listener");
    if (b(paramb))
    {
      AppMethodBeat.o(244334);
      return true;
    }
    synchronized (this.nsm)
    {
      this.nsm.add(paramb);
      AppMethodBeat.o(244334);
      return false;
    }
  }
  
  public final void b(com.tencent.mm.plugin.appbrand.ah.b paramb)
  {
    AppMethodBeat.i(244336);
    p.k(paramb, "adWorkerInfo");
    Log.i("MicroMsg.AppBrandAdWorkerHolder", "AdWorker created. store to holder  cost=" + paramb.rGX);
    a(paramb);
    AppMethodBeat.o(244336);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandAdWorkerHolder$Listener;", "", "onObtained", "", "executable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "createCost", "Lkotlin/Pair;", "", "errorMsg", "", "luggage-wxa-app_release"})
  public static abstract interface b
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.m.o paramo, kotlin.o<Long, Long> paramo1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b
 * JD-Core Version:    0.7.0.1
 */