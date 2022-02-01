package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.ec;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import d.ac;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@e(com.tencent.mm.plugin.appbrand.api.c.class)
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue;", "Lcom/tencent/mm/kernel/service/IService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "memoryQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "timeoutOpTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "applyDiff", "", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "newList", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "applyDiff$plugin_appbrand_integration_release", "deserializeFromDisk", "", "modelClient2Server", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "clientUse", "onRegister", "onUnregister", "push", "op", "reason", "Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "serializeToDisk", "triggerRequest", "writeBackQueue", "queue", "Companion", "OnModifiedCallback", "plugin-appbrand-integration_release"})
public final class c
  implements com.tencent.mm.kernel.c.a, b
{
  public static final a jRq;
  private final LinkedList<diw> jRo;
  private final aw jRp;
  
  static
  {
    AppMethodBeat.i(50237);
    jRq = new a((byte)0);
    AppMethodBeat.o(50237);
  }
  
  public c()
  {
    AppMethodBeat.i(50236);
    this.jRo = new LinkedList();
    this.jRp = new aw(Looper.getMainLooper(), (aw.a)new d(this), false);
    AppMethodBeat.o(50236);
  }
  
  public final void a(final ab.b paramb)
  {
    AppMethodBeat.i(50235);
    p.h(paramb, "reason");
    ae.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason = " + paramb.name());
    this.jRp.stopTimer();
    final LinkedList localLinkedList2 = new LinkedList();
    synchronized (this.jRo)
    {
      localLinkedList2.addAll((Collection)this.jRo);
      this.jRo.clear();
      z localz = z.Nhr;
      if (!localLinkedList2.isEmpty()) {
        break label187;
      }
      ae.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + paramb.intValue + "], queue empty");
      if (paramb == ab.b.jTd)
      {
        paramb = ag.jTj;
        ag.a.a(2, 0, (ag.b)new e(), 2);
        AppMethodBeat.o(50235);
        return;
      }
    }
    if (paramb == ab.b.jTe)
    {
      paramb = ag.jTj;
      ag.a.a(2, 0, null, 6);
    }
    AppMethodBeat.o(50235);
    return;
    label187:
    ae.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + paramb.intValue + "], queue_size=" + localLinkedList2.size());
    new ab((List)localLinkedList2, paramb.intValue).aET().j((com.tencent.mm.vending.c.a)new f(this, paramb, localLinkedList2));
    AppMethodBeat.o(50235);
  }
  
  public final void a(diw paramdiw, ab.b paramb)
  {
    AppMethodBeat.i(50233);
    p.h(paramdiw, "op");
    p.h(paramb, "reason");
    synchronized (this.jRo)
    {
      this.jRo.addLast(paramdiw);
      paramdiw = z.Nhr;
      switch (d.cqt[paramb.ordinal()])
      {
      default: 
        a(paramb);
        AppMethodBeat.o(50233);
        return;
      }
    }
    this.jRp.Dv(30000L);
    AppMethodBeat.o(50233);
  }
  
  public final boolean a(final android.support.v7.h.c.b paramb, final List<? extends LocalUsageInfo> paramList1, final List<? extends LocalUsageInfo> paramList2, final b paramb1)
  {
    AppMethodBeat.i(50232);
    p.h(paramb, "diff");
    p.h(paramList1, "oldList");
    p.h(paramList2, "newList");
    final ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList1);
    final PInt localPInt = new PInt(0);
    synchronized (this.jRo)
    {
      paramb.a((d)new c(this, paramb, localPInt, paramList1, paramList2, paramb1, localArrayList));
      paramb = z.Nhr;
      if (localPInt.value > 0)
      {
        AppMethodBeat.o(50232);
        return true;
      }
    }
    AppMethodBeat.o(50232);
    return false;
  }
  
  public final void akM()
  {
    AppMethodBeat.i(50230);
    ??? = j.aZy().get("AppBrandCollectionModifyQueue");
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
        j.aZy().clear("AppBrandCollectionModifyQueue");
        try
        {
          ec localec = new ec();
          localec.parseFrom((byte[])???);
          synchronized (this.jRo)
          {
            this.jRo.addAll((Collection)localec.fXm);
            AppMethodBeat.o(50230);
            return;
          }
          AppMethodBeat.o(50230);
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "deserializeFromDisk, read kv failed, e = ".concat(String.valueOf(localException)));
        }
      }
      return;
      AppMethodBeat.o(50230);
      return;
    }
  }
  
  public final void akN()
  {
    AppMethodBeat.i(50231);
    ec localec = new ec();
    synchronized (this.jRo)
    {
      localec.fXm.addAll((Collection)this.jRo);
      if (localec.fXm.isEmpty()) {}
    }
    AppMethodBeat.o(50231);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$Companion;", "", "()V", "MODIFY_TIMEOUT_INTERVAL", "", "SERIALIZE_KEY", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void b(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void c(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void d(LocalUsageInfo paramLocalUsageInfo);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$applyDiff$1$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"})
  public static final class c
    implements d
  {
    c(c paramc, android.support.v7.h.c.b paramb, PInt paramPInt, List paramList1, List paramList2, c.b paramb1, ArrayList paramArrayList) {}
    
    public final void c(int paramInt1, int paramInt2, Object paramObject) {}
    
    public final void f(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(50222);
      Object localObject1 = localPInt;
      ((PInt)localObject1).value += paramInt2;
      ae.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onInserted position=" + paramInt1 + " count=" + paramInt2 + "  oldList.size=" + paramList1.size() + "  newList.size=" + paramList2.size());
      label112:
      Object localObject2;
      if (paramInt1 + paramInt2 == paramList2.size())
      {
        localObject1 = null;
        paramInt2 = paramInt1 + paramInt2 - 1;
        if (paramInt1 > paramInt2) {
          break label250;
        }
        localObject2 = (LocalUsageInfo)paramList2.get(paramInt1);
        if (paramInt1 != 0) {
          break label230;
        }
      }
      label230:
      for (LocalUsageInfo localLocalUsageInfo = null;; localLocalUsageInfo = (LocalUsageInfo)paramList2.get(paramInt1 - 1))
      {
        Object localObject3 = paramb1;
        if (localObject3 != null) {
          ((c.b)localObject3).b((LocalUsageInfo)localObject2);
        }
        localObject3 = this.jRr;
        ab.a locala = ab.jTa;
        localObject2 = c.a((LocalUsageInfo)localObject2);
        if (localObject2 == null) {
          p.gkB();
        }
        c.a((c)localObject3, ab.a.a((div)localObject2, c.a(localLocalUsageInfo), c.a((LocalUsageInfo)localObject1)));
        if (paramInt1 == paramInt2) {
          break label250;
        }
        paramInt1 += 1;
        break label112;
        localObject1 = (LocalUsageInfo)paramList2.get(paramInt1 + paramInt2);
        break;
      }
      label250:
      AppMethodBeat.o(50222);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(50223);
      Object localObject1 = localPInt;
      ((PInt)localObject1).value += paramInt2;
      ae.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onRemoved position=" + paramInt1 + " count=" + paramInt2);
      int i = paramInt1 + paramInt2 - 1;
      if (paramInt1 <= i)
      {
        paramInt2 = paramInt1;
        for (;;)
        {
          localObject1 = (LocalUsageInfo)localArrayList.remove(paramInt1);
          Object localObject2 = paramb1;
          if (localObject2 != null)
          {
            p.g(localObject1, "info");
            ((c.b)localObject2).d((LocalUsageInfo)localObject1);
          }
          localObject2 = this.jRr;
          ab.a locala = ab.jTa;
          localObject1 = c.a((LocalUsageInfo)localObject1);
          if (localObject1 == null) {
            p.gkB();
          }
          c.a((c)localObject2, ab.a.a((div)localObject1));
          if (paramInt2 == i) {
            break;
          }
          paramInt2 += 1;
        }
      }
      AppMethodBeat.o(50223);
    }
    
    public final void l(int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(50224);
      Object localObject1 = localPInt;
      ((PInt)localObject1).value += 1;
      ae.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + paramInt1 + " to " + paramInt2);
      localObject1 = (LocalUsageInfo)localArrayList.remove(paramInt1);
      localArrayList.add(paramInt2, localObject1);
      localObject1 = localArrayList.get(paramInt2);
      p.g(localObject1, "tempList[toPosition]");
      Object localObject3 = (LocalUsageInfo)localObject1;
      label114:
      Object localObject4;
      if (paramInt2 == 0)
      {
        localObject1 = null;
        if (paramInt2 + 1 != localArrayList.size()) {
          break label243;
        }
        localObject4 = paramb1;
        if (localObject4 != null) {
          ((c.b)localObject4).c((LocalUsageInfo)localObject3);
        }
        localObject4 = this.jRr;
        localObject5 = ab.jTa;
        localObject3 = c.a((LocalUsageInfo)localObject3);
        if (localObject3 == null) {
          p.gkB();
        }
        localObject1 = c.a((LocalUsageInfo)localObject1);
        localObject2 = c.a((LocalUsageInfo)localObject2);
        p.h(localObject3, "self");
        if (!ab.a.bde()) {
          break label266;
        }
        if ((localObject1 == null) && (localObject2 == null)) {
          break label261;
        }
      }
      label261:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((!ac.Nhs) || (paramInt1 != 0)) {
          break label266;
        }
        localObject1 = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(50224);
        throw ((Throwable)localObject1);
        localObject1 = (LocalUsageInfo)localArrayList.get(paramInt2 - 1);
        break;
        label243:
        localObject2 = (LocalUsageInfo)localArrayList.get(paramInt2 + 1);
        break label114;
      }
      label266:
      Object localObject5 = new diw();
      ((diw)localObject5).HQz = ((div)localObject3);
      ((diw)localObject5).HQC = 3;
      ((diw)localObject5).HQA = ((div)localObject1);
      ((diw)localObject5).HQB = ((div)localObject2);
      c.a((c)localObject4, (diw)localObject5);
      AppMethodBeat.o(50224);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onTimerExpired"})
  static final class d
    implements aw.a
  {
    d(c paramc) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(50225);
      this.jRr.a(ab.b.jTc);
      AppMethodBeat.o(50225);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$triggerRequest$1", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "doNotifyManually", "", "onCgiBack", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
  public static final class e
    implements ag.b
  {
    private static void bcq()
    {
      AppMethodBeat.i(50228);
      u localu = (u)j.T(u.class);
      if (localu != null)
      {
        localu.doNotify("batch", 3, null);
        AppMethodBeat.o(50228);
        return;
      }
      AppMethodBeat.o(50228);
    }
    
    public final void bcp()
    {
      AppMethodBeat.i(50226);
      bcq();
      AppMethodBeat.o(50226);
    }
    
    public final void c(a.a<bmu> parama)
    {
      AppMethodBeat.i(180435);
      if (!com.tencent.mm.plugin.appbrand.n.a.e(parama)) {
        bcq();
      }
      AppMethodBeat.o(180435);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(c paramc, ab.b paramb, LinkedList paramLinkedList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.c
 * JD-Core Version:    0.7.0.1
 */