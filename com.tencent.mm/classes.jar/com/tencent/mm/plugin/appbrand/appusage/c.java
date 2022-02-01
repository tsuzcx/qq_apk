package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.protocal.protobuf.ech;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@e(com.tencent.mm.plugin.appbrand.api.c.class)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue;", "Lcom/tencent/mm/kernel/service/IService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "memoryQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "timeoutOpTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "applyDiff", "", "diff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "newList", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "applyDiff$plugin_appbrand_integration_release", "deserializeFromDisk", "", "modelClient2Server", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "clientUse", "onRegister", "onUnregister", "push", "op", "reason", "Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "serializeToDisk", "triggerRequest", "writeBackQueue", "queue", "Companion", "OnModifiedCallback", "plugin-appbrand-integration_release"})
public final class c
  implements com.tencent.mm.kernel.c.a, b
{
  public static final a kUa;
  private final LinkedList<ech> kTY;
  private final MTimerHandler kTZ;
  
  static
  {
    AppMethodBeat.i(50237);
    kUa = new a((byte)0);
    AppMethodBeat.o(50237);
  }
  
  public c()
  {
    AppMethodBeat.i(50236);
    this.kTY = new LinkedList();
    this.kTZ = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new d(this), false);
    AppMethodBeat.o(50236);
  }
  
  public final void a(final aa.b paramb)
  {
    AppMethodBeat.i(50235);
    p.h(paramb, "reason");
    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason = " + paramb.name());
    this.kTZ.stopTimer();
    final LinkedList localLinkedList2 = new LinkedList();
    synchronized (this.kTY)
    {
      localLinkedList2.addAll((Collection)this.kTY);
      this.kTY.clear();
      x localx = x.SXb;
      if (!localLinkedList2.isEmpty()) {
        break label187;
      }
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + paramb.intValue + "], queue empty");
      if (paramb == aa.b.kVL)
      {
        paramb = af.kVR;
        af.a.a(2, 0, (af.b)new e(), 2);
        AppMethodBeat.o(50235);
        return;
      }
    }
    if (paramb == aa.b.kVM)
    {
      paramb = af.kVR;
      af.a.a(2, 0, null, 6);
    }
    AppMethodBeat.o(50235);
    return;
    label187:
    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + paramb.intValue + "], queue_size=" + localLinkedList2.size());
    new aa((List)localLinkedList2, paramb.intValue).aYI().j((com.tencent.mm.vending.c.a)new f(this, paramb, localLinkedList2));
    AppMethodBeat.o(50235);
  }
  
  public final void a(ech paramech, aa.b paramb)
  {
    AppMethodBeat.i(50233);
    p.h(paramech, "op");
    p.h(paramb, "reason");
    synchronized (this.kTY)
    {
      this.kTY.addLast(paramech);
      paramech = x.SXb;
      switch (d.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        a(paramb);
        AppMethodBeat.o(50233);
        return;
      }
    }
    this.kTZ.startTimer(30000L);
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
    synchronized (this.kTY)
    {
      paramb.a((d)new c(this, paramb, localPInt, paramList1, paramList2, paramb1, localArrayList));
      paramb = x.SXb;
      if (localPInt.value > 0)
      {
        AppMethodBeat.o(50232);
        return true;
      }
    }
    AppMethodBeat.o(50232);
    return false;
  }
  
  public final void aBc()
  {
    AppMethodBeat.i(50230);
    ??? = n.buP().get("AppBrandCollectionModifyQueue");
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
        n.buP().clear("AppBrandCollectionModifyQueue");
        try
        {
          eo localeo = new eo();
          localeo.parseFrom((byte[])???);
          synchronized (this.kTY)
          {
            this.kTY.addAll((Collection)localeo.gCs);
            AppMethodBeat.o(50230);
            return;
          }
          AppMethodBeat.o(50230);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "deserializeFromDisk, read kv failed, e = ".concat(String.valueOf(localException)));
        }
      }
      return;
      AppMethodBeat.o(50230);
      return;
    }
  }
  
  public final void aBd()
  {
    AppMethodBeat.i(50231);
    eo localeo = new eo();
    synchronized (this.kTY)
    {
      localeo.gCs.addAll((Collection)this.kTY);
      if (localeo.gCs.isEmpty()) {}
    }
    AppMethodBeat.o(50231);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$Companion;", "", "()V", "MODIFY_TIMEOUT_INTERVAL", "", "SERIALIZE_KEY", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void b(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void c(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void d(LocalUsageInfo paramLocalUsageInfo);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$applyDiff$1$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"})
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
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onInserted position=" + paramInt1 + " count=" + paramInt2 + "  oldList.size=" + paramList1.size() + "  newList.size=" + paramList2.size());
      Object localObject3;
      if (paramInt1 + paramInt2 == paramList2.size())
      {
        localObject1 = null;
        paramInt2 = paramInt1 + paramInt2 - 1;
        if (paramInt1 > paramInt2) {
          break label471;
        }
        localObject3 = (LocalUsageInfo)paramList2.get(paramInt1);
        if (paramInt1 != 0) {
          break label451;
        }
      }
      label451:
      for (Object localObject2 = null;; localObject2 = (LocalUsageInfo)paramList2.get(paramInt1 - 1)) {
        for (;;)
        {
          Object localObject4 = paramb1;
          if (localObject4 != null) {
            ((c.b)localObject4).b((LocalUsageInfo)localObject3);
          }
          localObject4 = this.kUb;
          aa.a locala = aa.kVI;
          localObject3 = c.a((LocalUsageInfo)localObject3);
          if (localObject3 == null) {
            p.hyc();
          }
          c.a((c)localObject4, aa.a.a((ecg)localObject3, c.a((LocalUsageInfo)localObject2), c.a((LocalUsageInfo)localObject1)));
          if (paramInt1 == paramInt2) {
            break label471;
          }
          paramInt1 += 1;
          break;
          try
          {
            localObject1 = (LocalUsageInfo)paramList2.get(paramInt1 + paramInt2);
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "print old list:" + paramList1.size());
            localObject2 = ((Iterable)paramList1).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (LocalUsageInfo)((Iterator)localObject2).next();
              Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", ((LocalUsageInfo)localObject3).nickname + ':' + ((LocalUsageInfo)localObject3).iOo);
            }
            Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "print new list:" + paramList2.size());
            localObject2 = ((Iterable)paramList2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (LocalUsageInfo)((Iterator)localObject2).next();
              Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", ((LocalUsageInfo)localObject3).nickname + ':' + ((LocalUsageInfo)localObject3).iOo);
            }
            Throwable localThrowable = (Throwable)localIndexOutOfBoundsException;
            AppMethodBeat.o(50222);
            throw localThrowable;
          }
        }
      }
      label471:
      AppMethodBeat.o(50222);
    }
    
    public final void k(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(50223);
      Object localObject1 = localPInt;
      ((PInt)localObject1).value += paramInt2;
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onRemoved position=" + paramInt1 + " count=" + paramInt2);
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
          localObject2 = this.kUb;
          aa.a locala = aa.kVI;
          localObject1 = c.a((LocalUsageInfo)localObject1);
          if (localObject1 == null) {
            p.hyc();
          }
          c.a((c)localObject2, aa.a.a((ecg)localObject1));
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
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + paramInt1 + " to " + paramInt2);
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
        localObject4 = this.kUb;
        localObject5 = aa.kVI;
        localObject3 = c.a((LocalUsageInfo)localObject3);
        if (localObject3 == null) {
          p.hyc();
        }
        localObject1 = c.a((LocalUsageInfo)localObject1);
        localObject2 = c.a((LocalUsageInfo)localObject2);
        p.h(localObject3, "self");
        if (!aa.a.byt()) {
          break label266;
        }
        if ((localObject1 == null) && (localObject2 == null)) {
          break label261;
        }
      }
      label261:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((!kotlin.aa.SXc) || (paramInt1 != 0)) {
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
      Object localObject5 = new ech();
      ((ech)localObject5).Ncw = ((ecg)localObject3);
      ((ech)localObject5).Ncz = 3;
      ((ech)localObject5).Ncx = ((ecg)localObject1);
      ((ech)localObject5).Ncy = ((ecg)localObject2);
      c.a((c)localObject4, (ech)localObject5);
      AppMethodBeat.o(50224);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class d
    implements MTimerHandler.CallBack
  {
    d(c paramc) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(50225);
      this.kUb.a(aa.b.kVK);
      AppMethodBeat.o(50225);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$triggerRequest$1", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "doNotifyManually", "", "onCgiBack", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
  public static final class e
    implements af.b
  {
    private static void bxF()
    {
      AppMethodBeat.i(50228);
      u localu = (u)n.W(u.class);
      if (localu != null)
      {
        localu.doNotify("batch", 3, null);
        AppMethodBeat.o(50228);
        return;
      }
      AppMethodBeat.o(50228);
    }
    
    public final void b(com.tencent.mm.ak.c.a<bzl> parama)
    {
      AppMethodBeat.i(180435);
      if (!com.tencent.mm.plugin.appbrand.r.a.d(parama)) {
        bxF();
      }
      AppMethodBeat.o(180435);
    }
    
    public final void bxE()
    {
      AppMethodBeat.i(50226);
      bxF();
      AppMethodBeat.o(50226);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(c paramc, aa.b paramb, LinkedList paramLinkedList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.c
 * JD-Core Version:    0.7.0.1
 */