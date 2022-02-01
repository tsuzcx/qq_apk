package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bhu;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.aa;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@e(com.tencent.mm.plugin.appbrand.a.c.class)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue;", "Lcom/tencent/mm/kernel/service/IService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "memoryQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "timeoutOpTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "applyDiff", "", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "newList", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "applyDiff$plugin_appbrand_integration_release", "deserializeFromDisk", "", "modelClient2Server", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "clientUse", "onRegister", "onUnregister", "push", "op", "reason", "Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "serializeToDisk", "triggerRequest", "writeBackQueue", "queue", "Companion", "OnModifiedCallback", "plugin-appbrand-integration_release"})
public final class c
  implements com.tencent.mm.kernel.c.a, b
{
  public static final a jug;
  private final LinkedList<dco> jue;
  private final au juf;
  
  static
  {
    AppMethodBeat.i(50237);
    jug = new a((byte)0);
    AppMethodBeat.o(50237);
  }
  
  public c()
  {
    AppMethodBeat.i(50236);
    this.jue = new LinkedList();
    this.juf = new au(Looper.getMainLooper(), (au.a)new d(this), false);
    AppMethodBeat.o(50236);
  }
  
  public final void a(final ab.b paramb)
  {
    AppMethodBeat.i(50235);
    k.h(paramb, "reason");
    ac.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason = " + paramb.name());
    this.juf.stopTimer();
    final LinkedList localLinkedList2 = new LinkedList();
    synchronized (this.jue)
    {
      localLinkedList2.addAll((Collection)this.jue);
      this.jue.clear();
      y localy = y.KTp;
      if (!localLinkedList2.isEmpty()) {
        break label187;
      }
      ac.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + paramb.intValue + "], queue empty");
      if (paramb == ab.b.jvR)
      {
        paramb = ag.jvX;
        ag.a.a(2, 0, (ag.b)new e(), 2);
        AppMethodBeat.o(50235);
        return;
      }
    }
    if (paramb == ab.b.jvS)
    {
      paramb = ag.jvX;
      ag.a.a(2, 0, null, 6);
    }
    AppMethodBeat.o(50235);
    return;
    label187:
    ac.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + paramb.intValue + "], queue_size=" + localLinkedList2.size());
    new ab((List)localLinkedList2, paramb.intValue).aBB().j((com.tencent.mm.vending.c.a)new f(this, paramb, localLinkedList2));
    AppMethodBeat.o(50235);
  }
  
  public final void a(dco paramdco, ab.b paramb)
  {
    AppMethodBeat.i(50233);
    k.h(paramdco, "op");
    k.h(paramb, "reason");
    synchronized (this.jue)
    {
      this.jue.addLast(paramdco);
      paramdco = y.KTp;
      switch (d.cfA[paramb.ordinal()])
      {
      default: 
        a(paramb);
        AppMethodBeat.o(50233);
        return;
      }
    }
    this.juf.Ah(30000L);
    AppMethodBeat.o(50233);
  }
  
  public final boolean a(final android.support.v7.h.c.b paramb, List<? extends LocalUsageInfo> arg2, final List<? extends LocalUsageInfo> paramList2, final b paramb1)
  {
    AppMethodBeat.i(50232);
    k.h(paramb, "diff");
    k.h(???, "oldList");
    k.h(paramList2, "newList");
    final ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)???);
    final PInt localPInt = new PInt(0);
    synchronized (this.jue)
    {
      paramb.a((d)new c(this, paramb, localPInt, paramList2, paramb1, localArrayList));
      paramb = y.KTp;
      if (localPInt.value > 0)
      {
        AppMethodBeat.o(50232);
        return true;
      }
    }
    AppMethodBeat.o(50232);
    return false;
  }
  
  public final void ahM()
  {
    AppMethodBeat.i(50230);
    ??? = j.aVG().get("AppBrandCollectionModifyQueue");
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
        j.aVG().clear("AppBrandCollectionModifyQueue");
        try
        {
          dy localdy = new dy();
          localdy.parseFrom((byte[])???);
          synchronized (this.jue)
          {
            this.jue.addAll((Collection)localdy.fBS);
            AppMethodBeat.o(50230);
            return;
          }
          AppMethodBeat.o(50230);
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "deserializeFromDisk, read kv failed, e = ".concat(String.valueOf(localException)));
        }
      }
      return;
      AppMethodBeat.o(50230);
      return;
    }
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(50231);
    dy localdy = new dy();
    synchronized (this.jue)
    {
      localdy.fBS.addAll((Collection)this.jue);
      if (localdy.fBS.isEmpty()) {}
    }
    AppMethodBeat.o(50231);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$Companion;", "", "()V", "MODIFY_TIMEOUT_INTERVAL", "", "SERIALIZE_KEY", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void b(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void c(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void d(LocalUsageInfo paramLocalUsageInfo);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$applyDiff$1$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"})
  public static final class c
    implements d
  {
    c(c paramc, android.support.v7.h.c.b paramb, PInt paramPInt, List paramList, c.b paramb1, ArrayList paramArrayList) {}
    
    public final void E(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(50222);
      Object localObject1 = localPInt;
      ((PInt)localObject1).value += paramInt2;
      ac.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onInserted position=" + paramInt1 + " count=" + paramInt2);
      label78:
      Object localObject2;
      if (paramInt1 + paramInt2 == paramList2.size())
      {
        localObject1 = null;
        paramInt2 = paramInt1 + paramInt2 - 1;
        if (paramInt1 > paramInt2) {
          break label216;
        }
        localObject2 = (LocalUsageInfo)paramList2.get(paramInt1);
        if (paramInt1 != 0) {
          break label196;
        }
      }
      label196:
      for (LocalUsageInfo localLocalUsageInfo = null;; localLocalUsageInfo = (LocalUsageInfo)paramList2.get(paramInt1 - 1))
      {
        Object localObject3 = paramb1;
        if (localObject3 != null) {
          ((c.b)localObject3).b((LocalUsageInfo)localObject2);
        }
        localObject3 = this.juh;
        ab.a locala = ab.jvO;
        localObject2 = c.a((LocalUsageInfo)localObject2);
        if (localObject2 == null) {
          k.fOy();
        }
        c.a((c)localObject3, ab.a.a((dcn)localObject2, c.a(localLocalUsageInfo), c.a((LocalUsageInfo)localObject1)));
        if (paramInt1 == paramInt2) {
          break label216;
        }
        paramInt1 += 1;
        break label78;
        localObject1 = (LocalUsageInfo)paramList2.get(paramInt1 + paramInt2);
        break;
      }
      label216:
      AppMethodBeat.o(50222);
    }
    
    public final void F(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(50223);
      Object localObject1 = localPInt;
      ((PInt)localObject1).value += paramInt2;
      ac.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onRemoved position=" + paramInt1 + " count=" + paramInt2);
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
            k.g(localObject1, "info");
            ((c.b)localObject2).d((LocalUsageInfo)localObject1);
          }
          localObject2 = this.juh;
          ab.a locala = ab.jvO;
          localObject1 = c.a((LocalUsageInfo)localObject1);
          if (localObject1 == null) {
            k.fOy();
          }
          c.a((c)localObject2, ab.a.a((dcn)localObject1));
          if (paramInt2 == i) {
            break;
          }
          paramInt2 += 1;
        }
      }
      AppMethodBeat.o(50223);
    }
    
    public final void G(int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(50224);
      Object localObject1 = localPInt;
      ((PInt)localObject1).value += 1;
      ac.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + paramInt1 + " to " + paramInt2);
      localObject1 = (LocalUsageInfo)localArrayList.remove(paramInt1);
      localArrayList.add(paramInt2, localObject1);
      localObject1 = localArrayList.get(paramInt2);
      k.g(localObject1, "tempList[toPosition]");
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
        localObject4 = this.juh;
        localObject5 = ab.jvO;
        localObject3 = c.a((LocalUsageInfo)localObject3);
        if (localObject3 == null) {
          k.fOy();
        }
        localObject1 = c.a((LocalUsageInfo)localObject1);
        localObject2 = c.a((LocalUsageInfo)localObject2);
        k.h(localObject3, "self");
        if (!ab.a.aZb()) {
          break label266;
        }
        if ((localObject1 == null) && (localObject2 == null)) {
          break label261;
        }
      }
      label261:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((!aa.KTq) || (paramInt1 != 0)) {
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
      Object localObject5 = new dco();
      ((dco)localObject5).FMi = ((dcn)localObject3);
      ((dco)localObject5).FMl = 3;
      ((dco)localObject5).FMj = ((dcn)localObject1);
      ((dco)localObject5).FMk = ((dcn)localObject2);
      c.a((c)localObject4, (dco)localObject5);
      AppMethodBeat.o(50224);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class d
    implements au.a
  {
    d(c paramc) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(50225);
      this.juh.a(ab.b.jvQ);
      AppMethodBeat.o(50225);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$triggerRequest$1", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "doNotifyManually", "", "onCgiBack", "back", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
  public static final class e
    implements ag.b
  {
    private static void aYo()
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
    
    public final void aYn()
    {
      AppMethodBeat.i(50226);
      aYo();
      AppMethodBeat.o(50226);
    }
    
    public final void c(com.tencent.mm.ak.c.a<bhu> parama)
    {
      AppMethodBeat.i(180435);
      if (!com.tencent.mm.plugin.appbrand.o.a.d(parama)) {
        aYo();
      }
      AppMethodBeat.o(180435);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "kotlin.jvm.PlatformType", "call"})
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