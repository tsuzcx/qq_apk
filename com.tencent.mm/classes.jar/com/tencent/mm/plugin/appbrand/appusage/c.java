package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.el;
import com.tencent.mm.protocal.protobuf.emh;
import com.tencent.mm.protocal.protobuf.emi;
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
import kotlin.z;

@e(gf=com.tencent.mm.plugin.appbrand.api.c.class)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue;", "Lcom/tencent/mm/kernel/service/IService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "memoryQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "timeoutOpTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "applyDiff", "", "diff", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "newList", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "applyDiff$plugin_appbrand_integration_release", "deserializeFromDisk", "", "modelClient2Server", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "clientUse", "onRegister", "onUnregister", "push", "op", "reason", "Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "serializeToDisk", "triggerRequest", "writeBackQueue", "queue", "Companion", "OnModifiedCallback", "plugin-appbrand-integration_release"})
public final class c
  implements com.tencent.mm.kernel.c.a, b
{
  public static final a nOn;
  private final LinkedList<emi> nOl;
  private final MTimerHandler nOm;
  
  static
  {
    AppMethodBeat.i(50237);
    nOn = new a((byte)0);
    AppMethodBeat.o(50237);
  }
  
  public c()
  {
    AppMethodBeat.i(50236);
    this.nOl = new LinkedList();
    this.nOm = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack)new d(this), false);
    AppMethodBeat.o(50236);
  }
  
  public final void a(final aa.b paramb)
  {
    AppMethodBeat.i(50235);
    p.k(paramb, "reason");
    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason = " + paramb.name());
    this.nOm.stopTimer();
    final LinkedList localLinkedList2 = new LinkedList();
    synchronized (this.nOl)
    {
      localLinkedList2.addAll((Collection)this.nOl);
      this.nOl.clear();
      x localx = x.aazN;
      if (!localLinkedList2.isEmpty()) {
        break label187;
      }
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + paramb.intValue + "], queue empty");
      if (paramb == aa.b.nPY)
      {
        paramb = af.nQe;
        af.a.a(2, 0, (af.b)new e(), 2);
        AppMethodBeat.o(50235);
        return;
      }
    }
    if (paramb == aa.b.nPZ)
    {
      paramb = af.nQe;
      af.a.a(2, 0, null, 6);
    }
    AppMethodBeat.o(50235);
    return;
    label187:
    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + paramb.intValue + "], queue_size=" + localLinkedList2.size());
    new aa((List)localLinkedList2, paramb.intValue).bhW().j((com.tencent.mm.vending.c.a)new f(this, paramb, localLinkedList2));
    AppMethodBeat.o(50235);
  }
  
  public final void a(emi paramemi, aa.b paramb)
  {
    AppMethodBeat.i(50233);
    p.k(paramemi, "op");
    p.k(paramb, "reason");
    synchronized (this.nOl)
    {
      this.nOl.addLast(paramemi);
      paramemi = x.aazN;
      switch (d.$EnumSwitchMapping$0[paramb.ordinal()])
      {
      default: 
        a(paramb);
        AppMethodBeat.o(50233);
        return;
      }
    }
    this.nOm.startTimer(30000L);
    AppMethodBeat.o(50233);
  }
  
  public final boolean a(final h.b paramb, final List<? extends LocalUsageInfo> paramList1, final List<? extends LocalUsageInfo> paramList2, final b paramb1)
  {
    AppMethodBeat.i(267597);
    p.k(paramb, "diff");
    p.k(paramList1, "oldList");
    p.k(paramList2, "newList");
    final ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList1);
    final PInt localPInt = new PInt(0);
    synchronized (this.nOl)
    {
      paramb.a((s)new c(this, paramb, localPInt, paramList1, paramList2, paramb1, localArrayList));
      paramb = x.aazN;
      if (localPInt.value > 0)
      {
        AppMethodBeat.o(267597);
        return true;
      }
    }
    AppMethodBeat.o(267597);
    return false;
  }
  
  public final void aIF()
  {
    AppMethodBeat.i(50230);
    ??? = m.bFU().get("AppBrandCollectionModifyQueue");
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
        m.bFU().clear("AppBrandCollectionModifyQueue");
        try
        {
          el localel = new el();
          localel.parseFrom((byte[])???);
          synchronized (this.nOl)
          {
            this.nOl.addAll((Collection)localel.jmy);
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
  
  public final void aIG()
  {
    AppMethodBeat.i(50231);
    el localel = new el();
    synchronized (this.nOl)
    {
      localel.jmy.addAll((Collection)this.nOl);
      if (localel.jmy.isEmpty()) {}
    }
    AppMethodBeat.o(50231);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$Companion;", "", "()V", "MODIFY_TIMEOUT_INTERVAL", "", "SERIALIZE_KEY", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void b(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void c(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void d(LocalUsageInfo paramLocalUsageInfo);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$applyDiff$1$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"})
  public static final class c
    implements s
  {
    c(c paramc, h.b paramb, PInt paramPInt, List paramList1, List paramList2, c.b paramb1, ArrayList paramArrayList) {}
    
    public final void W(int paramInt1, int paramInt2)
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
          localObject4 = this.nOo;
          aa.a locala = aa.nPV;
          localObject3 = c.a((LocalUsageInfo)localObject3);
          if (localObject3 == null) {
            p.iCn();
          }
          c.a((c)localObject4, aa.a.a((emh)localObject3, c.a((LocalUsageInfo)localObject2), c.a((LocalUsageInfo)localObject1)));
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
              Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", ((LocalUsageInfo)localObject3).nickname + ':' + ((LocalUsageInfo)localObject3).cBU);
            }
            Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "print new list:" + paramList2.size());
            localObject2 = ((Iterable)paramList2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (LocalUsageInfo)((Iterator)localObject2).next();
              Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", ((LocalUsageInfo)localObject3).nickname + ':' + ((LocalUsageInfo)localObject3).cBU);
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
    
    public final void ac(int paramInt1, int paramInt2)
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
            p.j(localObject1, "info");
            ((c.b)localObject2).d((LocalUsageInfo)localObject1);
          }
          localObject2 = this.nOo;
          aa.a locala = aa.nPV;
          localObject1 = c.a((LocalUsageInfo)localObject1);
          if (localObject1 == null) {
            p.iCn();
          }
          c.a((c)localObject2, aa.a.a((emh)localObject1));
          if (paramInt2 == i) {
            break;
          }
          paramInt2 += 1;
        }
      }
      AppMethodBeat.o(50223);
    }
    
    public final void ad(int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(50224);
      Object localObject1 = localPInt;
      ((PInt)localObject1).value += 1;
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + paramInt1 + " to " + paramInt2);
      localObject1 = (LocalUsageInfo)localArrayList.remove(paramInt1);
      localArrayList.add(paramInt2, localObject1);
      localObject1 = localArrayList.get(paramInt2);
      p.j(localObject1, "tempList[toPosition]");
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
        localObject4 = this.nOo;
        localObject5 = aa.nPV;
        localObject3 = c.a((LocalUsageInfo)localObject3);
        if (localObject3 == null) {
          p.iCn();
        }
        localObject1 = c.a((LocalUsageInfo)localObject1);
        localObject2 = c.a((LocalUsageInfo)localObject2);
        p.k(localObject3, "self");
        if (!aa.a.bJH()) {
          break label266;
        }
        if ((localObject1 == null) && (localObject2 == null)) {
          break label261;
        }
      }
      label261:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((!z.aazO) || (paramInt1 != 0)) {
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
      Object localObject5 = new emi();
      ((emi)localObject5).UoT = ((emh)localObject3);
      ((emi)localObject5).UoW = 3;
      ((emi)localObject5).UoU = ((emh)localObject1);
      ((emi)localObject5).UoV = ((emh)localObject2);
      c.a((c)localObject4, (emi)localObject5);
      AppMethodBeat.o(50224);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class d
    implements MTimerHandler.CallBack
  {
    d(c paramc) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(50225);
      this.nOo.a(aa.b.nPX);
      AppMethodBeat.o(50225);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$triggerRequest$1", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "doNotifyManually", "", "onCgiBack", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"})
  public static final class e
    implements af.b
  {
    private static void bIV()
    {
      AppMethodBeat.i(50228);
      u localu = (u)m.W(u.class);
      if (localu != null)
      {
        localu.doNotify("batch", 3, null);
        AppMethodBeat.o(50228);
        return;
      }
      AppMethodBeat.o(50228);
    }
    
    public final void b(com.tencent.mm.an.c.a<chf> parama)
    {
      AppMethodBeat.i(180435);
      if (!com.tencent.mm.plugin.appbrand.r.a.d(parama)) {
        bIV();
      }
      AppMethodBeat.o(180435);
    }
    
    public final void bIU()
    {
      AppMethodBeat.i(50226);
      bIV();
      AppMethodBeat.o(50226);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class f<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    f(c paramc, aa.b paramb, LinkedList paramLinkedList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.c
 * JD-Core Version:    0.7.0.1
 */