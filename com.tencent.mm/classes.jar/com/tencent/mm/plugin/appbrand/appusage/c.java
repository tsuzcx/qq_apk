package com.tencent.mm.plugin.appbrand.appusage;

import a.f.b.j;
import a.l;
import a.y;
import android.os.Looper;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue;", "Lcom/tencent/mm/kernel/service/IService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "memoryQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "timeoutOpTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "applyDiff", "", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "newList", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "applyDiff$plugin_appbrand_integration_release", "deserializeFromDisk", "", "modelClient2Server", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "clientUse", "onRegister", "onUnregister", "push", "op", "reason", "Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "serializeToDisk", "triggerRequest", "writeBackQueue", "queue", "Companion", "OnModifiedCallback", "plugin-appbrand-integration_release"})
@e(com.tencent.mm.plugin.appbrand.a.c.class)
public final class c
  implements com.tencent.mm.kernel.c.a, b
{
  public static final c.a haK;
  private final LinkedList<cgc> haI;
  private final ap haJ;
  
  static
  {
    AppMethodBeat.i(134503);
    haK = new c.a((byte)0);
    AppMethodBeat.o(134503);
  }
  
  public c()
  {
    AppMethodBeat.i(134502);
    this.haI = new LinkedList();
    this.haJ = new ap(Looper.getMainLooper(), (ap.a)new c.d(this), false);
    AppMethodBeat.o(134502);
  }
  
  public final void a(z.b paramb)
  {
    AppMethodBeat.i(134501);
    j.q(paramb, "reason");
    ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason = " + paramb.name());
    this.haJ.stopTimer();
    LinkedList localLinkedList2 = new LinkedList();
    synchronized (this.haI)
    {
      localLinkedList2.addAll((Collection)this.haI);
      this.haI.clear();
      y localy = y.BMg;
      if (localLinkedList2.isEmpty())
      {
        ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + paramb.intValue + "], queue empty");
        if ((paramb == z.b.hcA) || (paramb == z.b.hcB))
        {
          paramb = ae.hcG;
          ae.a.cV(2, 2);
        }
        AppMethodBeat.o(134501);
        return;
      }
    }
    ab.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + paramb.intValue + "], queue_size=" + localLinkedList2.size());
    new z((List)localLinkedList2, paramb.intValue).adl().j((com.tencent.mm.vending.c.a)new c.e(this, paramb, localLinkedList2));
    AppMethodBeat.o(134501);
  }
  
  public final void a(cgc paramcgc, z.b paramb)
  {
    AppMethodBeat.i(134499);
    j.q(paramcgc, "op");
    j.q(paramb, "reason");
    synchronized (this.haI)
    {
      this.haI.addLast(paramcgc);
      paramcgc = y.BMg;
      switch (d.bLo[paramb.ordinal()])
      {
      default: 
        a(paramb);
        AppMethodBeat.o(134499);
        return;
      }
    }
    this.haJ.nP(30000L);
    AppMethodBeat.o(134499);
  }
  
  public final boolean a(android.support.v7.h.c.b paramb, List<? extends LocalUsageInfo> arg2, List<? extends LocalUsageInfo> paramList2, c.b paramb1)
  {
    AppMethodBeat.i(134498);
    j.q(paramb, "diff");
    j.q(???, "oldList");
    j.q(paramList2, "newList");
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)???);
    PInt localPInt = new PInt(0);
    synchronized (this.haI)
    {
      paramb.a((d)new c.c(this, paramb, localPInt, paramList2, paramb1, localArrayList));
      paramb = y.BMg;
      if (localPInt.value > 0)
      {
        AppMethodBeat.o(134498);
        return true;
      }
    }
    AppMethodBeat.o(134498);
    return false;
  }
  
  public final void xM()
  {
    AppMethodBeat.i(134496);
    ??? = g.auQ().get("AppBrandCollectionModifyQueue");
    if (??? != null) {
      if (???.length != 0) {
        break label126;
      }
    }
    label126:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        g.auQ().clear("AppBrandCollectionModifyQueue");
        try
        {
          dk localdk = new dk();
          localdk.parseFrom((byte[])???);
          synchronized (this.haI)
          {
            this.haI.addAll((Collection)localdk.elu);
            AppMethodBeat.o(134496);
            return;
          }
          AppMethodBeat.o(134496);
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "deserializeFromDisk, read kv failed, e = ".concat(String.valueOf(localException)));
        }
      }
      return;
      AppMethodBeat.o(134496);
      return;
    }
  }
  
  public final void xN()
  {
    AppMethodBeat.i(134497);
    dk localdk = new dk();
    synchronized (this.haI)
    {
      localdk.elu.addAll((Collection)this.haI);
      if (localdk.elu.isEmpty()) {}
    }
    AppMethodBeat.o(134497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.c
 * JD-Core Version:    0.7.0.1
 */