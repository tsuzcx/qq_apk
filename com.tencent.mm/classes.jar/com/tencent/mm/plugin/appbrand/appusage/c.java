package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fhe;
import com.tencent.mm.protocal.protobuf.fhf;
import com.tencent.mm.protocal.protobuf.fss;
import com.tencent.mm.protocal.protobuf.gjx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.ak;
import kotlin.g.b.s;

@e(Dr=com.tencent.mm.plugin.appbrand.api.c.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue;", "Lcom/tencent/mm/kernel/service/IService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "memoryQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "timeoutOpTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "applyDiff", "", "diff", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "oldList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "newList", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "applyDiff$plugin_appbrand_integration_release", "copyQueueDescription", "", "copyQueue", "deserializeFromDisk", "modelClient2Server", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "clientUse", "onRegister", "onUnregister", "push", "op", "reason", "Lcom/tencent/mm/plugin/appbrand/appusage/CgiUpdateWxaStarRecord$UpdateReason;", "serializeToDisk", "triggerRequest", "writeBackQueue", "queue", "Companion", "OnModifiedCallback", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.kernel.c.a, b
{
  public static final c.a qOi;
  private final LinkedList<fhf> qOj;
  private final MTimerHandler qOk;
  
  static
  {
    AppMethodBeat.i(50237);
    qOi = new c.a((byte)0);
    AppMethodBeat.o(50237);
  }
  
  public c()
  {
    AppMethodBeat.i(50236);
    this.qOj = new LinkedList();
    this.qOk = new MTimerHandler(Looper.getMainLooper(), new c..ExternalSyntheticLambda0(this), false);
    AppMethodBeat.o(50236);
  }
  
  private static final ah a(z.b paramb, c paramc, LinkedList paramLinkedList, b.a parama)
  {
    AppMethodBeat.i(319348);
    s.u(paramb, "$reason");
    s.u(paramc, "this$0");
    s.u(paramLinkedList, "$copyQueue");
    StringBuilder localStringBuilder = new StringBuilder("updateWxaStarRecord, onResponse reason=[").append(paramb.qDL).append("], cgi=[");
    if (parama == null) {}
    for (String str = "null";; str = String.format(Locale.US, "%d %d %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg }))
    {
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", str + ']');
      if (com.tencent.mm.plugin.appbrand.s.a.d(parama)) {
        break;
      }
      paramc.cR((List)paramLinkedList);
      paramb = ah.aiuX;
      AppMethodBeat.o(319348);
      return paramb;
    }
    if (((fss)parama.ott).ZiP == null)
    {
      Log.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + paramb.qDL + "] NULL wxa_resp");
      paramb = ah.aiuX;
      AppMethodBeat.o(319348);
      return paramb;
    }
    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "updateWxaStarRecord, onResponse reason=[" + paramb.qDL + "], ErrCode=" + ((fss)parama.ott).ZiP.ytv);
    if (((fss)parama.ott).ZiP.ytv != 0)
    {
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "jacob updateWxaStarRecord fail due to errcode = " + ((fss)parama.ott).ZiP.ytv + ", errMsg = " + ((fss)parama.ott).ZiP.ytw);
      if ((((fss)parama.ott).ZiP.ytv == -2) && (BuildInfo.IS_FLAVOR_RED))
      {
        paramb = new Exception("updateWxaStarRecord with incorrect params");
        AppMethodBeat.o(319348);
        throw paramb;
      }
    }
    switch (((fss)parama.ott).ZiP.ytv)
    {
    default: 
      paramb = ae.qPW;
      ae.a.a(0, 0, null, 7);
    }
    for (;;)
    {
      paramb = ah.aiuX;
      AppMethodBeat.o(319348);
      return paramb;
      paramc.cR((List)paramLinkedList);
    }
  }
  
  private static final boolean a(c paramc)
  {
    AppMethodBeat.i(319345);
    s.u(paramc, "this$0");
    paramc.a(z.b.qPP);
    AppMethodBeat.o(319345);
    return false;
  }
  
  private final void cR(List<? extends fhf> paramList)
  {
    AppMethodBeat.i(319343);
    if (!paramList.isEmpty()) {
      synchronized (this.qOj)
      {
        this.qOj.addAll(0, (Collection)paramList);
        AppMethodBeat.o(319343);
        return;
      }
    }
    AppMethodBeat.o(319343);
  }
  
  private static void y(LinkedList<fhf> paramLinkedList)
  {
    AppMethodBeat.i(319340);
    s.u(paramLinkedList, "copyQueue");
    if (!BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(319340);
      return;
    }
    Iterator localIterator = paramLinkedList.iterator();
    paramLinkedList = "";
    if (localIterator.hasNext())
    {
      fhf localfhf = (fhf)localIterator.next();
      paramLinkedList = paramLinkedList + "self oper " + localfhf.abHU + "self sence" + localfhf.scene;
      StringBuilder localStringBuilder = new StringBuilder().append(paramLinkedList).append("self info ");
      paramLinkedList = localfhf.abHR;
      if (paramLinkedList == null)
      {
        paramLinkedList = null;
        label124:
        localStringBuilder = localStringBuilder.append(paramLinkedList).append(' ');
        paramLinkedList = localfhf.abHR;
        if (paramLinkedList != null) {
          break label301;
        }
        paramLinkedList = null;
        label146:
        paramLinkedList = paramLinkedList + ' ';
        localStringBuilder = new StringBuilder().append(paramLinkedList).append("prev info ");
        paramLinkedList = localfhf.abHS;
        if (paramLinkedList != null) {
          break label312;
        }
        paramLinkedList = null;
        label189:
        localStringBuilder = localStringBuilder.append(paramLinkedList).append(' ');
        paramLinkedList = localfhf.abHS;
        if (paramLinkedList != null) {
          break label320;
        }
        paramLinkedList = null;
        label211:
        paramLinkedList = paramLinkedList + ' ';
        localStringBuilder = new StringBuilder().append(paramLinkedList).append("next info ");
        paramLinkedList = localfhf.abHT;
        if (paramLinkedList != null) {
          break label331;
        }
        paramLinkedList = null;
        label254:
        localStringBuilder = localStringBuilder.append(paramLinkedList).append(' ');
        paramLinkedList = localfhf.abHT;
        if (paramLinkedList != null) {
          break label339;
        }
      }
      label301:
      label312:
      label320:
      label331:
      label339:
      for (paramLinkedList = null;; paramLinkedList = Integer.valueOf(paramLinkedList.Tqb))
      {
        paramLinkedList = paramLinkedList + ' ';
        break;
        paramLinkedList = paramLinkedList.username;
        break label124;
        paramLinkedList = Integer.valueOf(paramLinkedList.Tqb);
        break label146;
        paramLinkedList = paramLinkedList.username;
        break label189;
        paramLinkedList = Integer.valueOf(paramLinkedList.Tqb);
        break label211;
        paramLinkedList = paramLinkedList.username;
        break label254;
      }
    }
    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", s.X("jacob queue ", paramLinkedList));
    AppMethodBeat.o(319340);
  }
  
  public final void a(z.b paramb)
  {
    AppMethodBeat.i(50235);
    s.u(paramb, "reason");
    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", s.X("triggerRequest reason = ", paramb.name()));
    this.qOk.stopTimer();
    LinkedList localLinkedList2 = new LinkedList();
    synchronized (this.qOj)
    {
      localLinkedList2.addAll((Collection)this.qOj);
      this.qOj.clear();
      ah localah = ah.aiuX;
      y(localLinkedList2);
      if (!localLinkedList2.isEmpty()) {
        break label189;
      }
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "triggerRequest reason=[" + paramb.qDL + "], queue empty");
      if (paramb == z.b.qPQ)
      {
        paramb = ae.qPW;
        ae.a.a(2, 0, (ae.b)new e(), 2);
        AppMethodBeat.o(50235);
        return;
      }
    }
    if (paramb == z.b.qPR)
    {
      paramb = ae.qPW;
      ae.a.a(2, 0, null, 6);
    }
    AppMethodBeat.o(50235);
    return;
    label189:
    Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "run cgi reason=[" + paramb.qDL + "], queue_size=" + localLinkedList2.size());
    new z((List)localLinkedList2, paramb.qDL).bFJ().j(new c..ExternalSyntheticLambda1(paramb, this, localLinkedList2));
    AppMethodBeat.o(50235);
  }
  
  public final void a(fhf paramfhf, z.b paramb)
  {
    AppMethodBeat.i(50233);
    s.u(paramfhf, "op");
    s.u(paramb, "reason");
    synchronized (this.qOj)
    {
      this.qOj.addLast(paramfhf);
      paramfhf = ah.aiuX;
      if (c.$EnumSwitchMapping$0[paramb.ordinal()] == 1)
      {
        this.qOk.startTimer(30000L);
        AppMethodBeat.o(50233);
        return;
      }
    }
    a(paramb);
    AppMethodBeat.o(50233);
  }
  
  public final boolean a(g.b paramb, final List<? extends LocalUsageInfo> paramList1, final List<? extends LocalUsageInfo> paramList2, final b paramb1)
  {
    AppMethodBeat.i(319360);
    s.u(paramb, "diff");
    s.u(paramList1, "oldList");
    s.u(paramList2, "newList");
    final ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)paramList1);
    PInt localPInt = new PInt(0);
    synchronized (this.qOj)
    {
      paramb.a((q)new d(localPInt, paramList1, paramList2, paramb1, this, localArrayList));
      paramb = ah.aiuX;
      if (localPInt.value > 0)
      {
        AppMethodBeat.o(319360);
        return true;
      }
    }
    AppMethodBeat.o(319360);
    return false;
  }
  
  public final void bbB()
  {
    AppMethodBeat.i(50230);
    ??? = n.cfr().get("AppBrandCollectionModifyQueue");
    if (??? != null) {
      if (???.length != 0) {
        break label120;
      }
    }
    label120:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        n.cfr().clear("AppBrandCollectionModifyQueue");
        try
        {
          Object localObject2 = new ff();
          ((ff)localObject2).parseFrom((byte[])???);
          synchronized (this.qOj)
          {
            this.qOj.addAll((Collection)((ff)localObject2).lPK);
            localObject2 = ah.aiuX;
            AppMethodBeat.o(50230);
            return;
          }
          AppMethodBeat.o(50230);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrandCollectionModifyQueue[collection]", s.X("deserializeFromDisk, read kv failed, e = ", localException));
        }
      }
      return;
    }
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(50231);
    ff localff = new ff();
    synchronized (this.qOj)
    {
      localff.lPK.addAll((Collection)this.qOj);
      if (localff.lPK.isEmpty()) {}
    }
    AppMethodBeat.o(50231);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void b(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void c(LocalUsageInfo paramLocalUsageInfo);
    
    public abstract void d(LocalUsageInfo paramLocalUsageInfo);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$applyDiff$1$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements q
  {
    d(PInt paramPInt, List<? extends LocalUsageInfo> paramList1, List<? extends LocalUsageInfo> paramList2, c.b paramb, c paramc, ArrayList<LocalUsageInfo> paramArrayList) {}
    
    public final void aR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(319314);
      Object localObject1 = this.qOl;
      ((PInt)localObject1).value += paramInt2;
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onInserted position=" + paramInt1 + " count=" + paramInt2 + "  oldList.size=" + paramList1.size() + "  newList.size=" + paramList2.size());
      if (paramInt1 + paramInt2 == paramList2.size())
      {
        localObject1 = null;
        paramInt2 = paramInt1 + paramInt2 - 1;
        if (paramInt1 > paramInt2) {}
      }
      for (;;)
      {
        Object localObject3 = (LocalUsageInfo)paramList2.get(paramInt1);
        if (paramInt1 == 0) {}
        for (Object localObject2 = null;; localObject2 = (LocalUsageInfo)paramList2.get(paramInt1 - 1)) {
          for (;;)
          {
            Object localObject4 = paramb1;
            if (localObject4 != null) {
              ((c.b)localObject4).b((LocalUsageInfo)localObject3);
            }
            localObject4 = jdField_this;
            z.a locala = z.qPM;
            localObject3 = c.a((LocalUsageInfo)localObject3);
            s.checkNotNull(localObject3);
            c.a((c)localObject4, z.a.a((fhe)localObject3, c.a((LocalUsageInfo)localObject2), c.a((LocalUsageInfo)localObject1)));
            if (paramInt1 != paramInt2) {
              break label448;
            }
            AppMethodBeat.o(319314);
            return;
            try
            {
              localObject1 = (LocalUsageInfo)paramList2.get(paramInt1 + paramInt2);
            }
            catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
            {
              Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", s.X("print old list:", Integer.valueOf(paramList1.size())));
              localObject2 = ((Iterable)paramList1).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (LocalUsageInfo)((Iterator)localObject2).next();
                Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", ((LocalUsageInfo)localObject3).nickname + ':' + ((LocalUsageInfo)localObject3).euz);
              }
              Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", s.X("print new list:", Integer.valueOf(paramList2.size())));
              localObject2 = ((Iterable)paramList2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (LocalUsageInfo)((Iterator)localObject2).next();
                Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", ((LocalUsageInfo)localObject3).nickname + ':' + ((LocalUsageInfo)localObject3).euz);
              }
              AppMethodBeat.o(319314);
              throw localIndexOutOfBoundsException;
            }
          }
        }
        label448:
        paramInt1 += 1;
      }
    }
    
    public final void aS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(319316);
      Object localObject1 = this.qOl;
      ((PInt)localObject1).value += paramInt2;
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onRemoved position=" + paramInt1 + " count=" + paramInt2);
      int i = paramInt1 + paramInt2 - 1;
      if (paramInt1 <= i) {
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        Object localObject3 = localArrayList.remove(paramInt1);
        Object localObject2 = paramb1;
        localObject1 = jdField_this;
        localObject3 = (LocalUsageInfo)localObject3;
        if (localObject2 != null)
        {
          s.s(localObject3, "info");
          ((c.b)localObject2).d((LocalUsageInfo)localObject3);
        }
        localObject2 = z.qPM;
        localObject2 = c.a((LocalUsageInfo)localObject3);
        s.checkNotNull(localObject2);
        c.a((c)localObject1, z.a.a((fhe)localObject2));
        if (paramInt2 == i)
        {
          AppMethodBeat.o(319316);
          return;
        }
        paramInt2 += 1;
      }
    }
    
    public final void aW(int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(319322);
      Object localObject1 = this.qOl;
      ((PInt)localObject1).value += 1;
      Log.i("MicroMsg.AppBrandCollectionModifyQueue[collection]", "applyDiff, onMoved from " + paramInt1 + " to " + paramInt2);
      localObject1 = localArrayList.remove(paramInt1);
      localArrayList.add(paramInt2, (LocalUsageInfo)localObject1);
      localObject1 = localArrayList.get(paramInt2);
      s.s(localObject1, "tempList[toPosition]");
      Object localObject3 = (LocalUsageInfo)localObject1;
      label114:
      Object localObject4;
      if (paramInt2 == 0)
      {
        localObject1 = null;
        if (paramInt2 + 1 != localArrayList.size()) {
          break label241;
        }
        localObject4 = paramb1;
        if (localObject4 != null) {
          ((c.b)localObject4).c((LocalUsageInfo)localObject3);
        }
        localObject4 = jdField_this;
        localObject5 = z.qPM;
        localObject3 = c.a((LocalUsageInfo)localObject3);
        s.checkNotNull(localObject3);
        localObject1 = c.a((LocalUsageInfo)localObject1);
        localObject2 = c.a((LocalUsageInfo)localObject2);
        s.u(localObject3, "self");
        if (!z.a.cjk()) {
          break label264;
        }
        if ((localObject1 == null) && (localObject2 == null)) {
          break label259;
        }
      }
      label259:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if ((!ak.aiuY) || (paramInt1 != 0)) {
          break label264;
        }
        localObject1 = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(319322);
        throw ((Throwable)localObject1);
        localObject1 = (LocalUsageInfo)localArrayList.get(paramInt2 - 1);
        break;
        label241:
        localObject2 = (LocalUsageInfo)localArrayList.get(paramInt2 + 1);
        break label114;
      }
      label264:
      Object localObject5 = new fhf();
      ((fhf)localObject5).abHR = ((fhe)localObject3);
      ((fhf)localObject5).abHU = 3;
      ((fhf)localObject5).abHS = ((fhe)localObject1);
      ((fhf)localObject5).abHT = ((fhe)localObject2);
      c.a((c)localObject4, (fhf)localObject5);
      AppMethodBeat.o(319322);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$triggerRequest$1", "Lcom/tencent/mm/plugin/appbrand/appusage/FetchStarListLogic$IFetchStartListCallback;", "doNotifyManually", "", "onCgiBack", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWxaUsageRecordResponse;", "onHitFrequencyLimit", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements ae.b
  {
    private static void ciz()
    {
      AppMethodBeat.i(50228);
      t localt = (t)n.ag(t.class);
      if (localt != null) {
        localt.doNotify("batch", 3, null);
      }
      AppMethodBeat.o(50228);
    }
    
    public final void b(b.a<cxg> parama)
    {
      AppMethodBeat.i(180435);
      if (!com.tencent.mm.plugin.appbrand.s.a.d(parama)) {
        ciz();
      }
      AppMethodBeat.o(180435);
    }
    
    public final void ciy()
    {
      AppMethodBeat.i(50226);
      ciz();
      AppMethodBeat.o(50226);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.c
 * JD-Core Version:    0.7.0.1
 */