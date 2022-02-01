package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ao.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLCardUpdateMgr;", "", "()V", "STATE_IDLE", "", "STATE_UPDATING", "TAG", "", "isUpdateCardOpen", "", "()Z", "isUpdateCardOpen$delegate", "Lkotlin/Lazy;", "mgrState", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMgrState", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setMgrState", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "setQueue", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getSetQueue", "()Ljava/util/HashSet;", "updateQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "getUpdateQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "addUpdateQueue", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkUpdate", "tryUpdate", "plugin-brandservice_release"})
public final class j
{
  private static final HashSet<Long> sDA;
  private static final kotlin.f sDB;
  public static final j sDC;
  private static AtomicInteger sDy;
  private static final ConcurrentLinkedDeque<ph> sDz;
  
  static
  {
    AppMethodBeat.i(266943);
    sDC = new j();
    sDy = new AtomicInteger(2);
    sDz = new ConcurrentLinkedDeque();
    sDA = new HashSet();
    sDB = kotlin.g.ar((kotlin.g.a.a)a.sDD);
    AppMethodBeat.o(266943);
  }
  
  public static AtomicInteger cAp()
  {
    return sDy;
  }
  
  public static HashSet<Long> cAq()
  {
    return sDA;
  }
  
  private final void cAr()
  {
    AppMethodBeat.i(266942);
    if (sDz.size() <= 0)
    {
      Log.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate size <= 0");
      AppMethodBeat.o(266942);
      return;
    }
    try
    {
      int i = sDy.get();
      if (i == 1) {
        return;
      }
      sDy.set(1);
      Object localObject1 = x.aazN;
      localObject1 = new d.a();
      ((d.a)localObject1).c((com.tencent.mm.cd.a)new pi());
      ((d.a)localObject1).d((com.tencent.mm.cd.a)new pj());
      ((d.a)localObject1).TW("/cgi-bin/mmbiz-bin/timeline/bizrecommendarticle");
      ((d.a)localObject1).vD(1084);
      localObject1 = ((d.a)localObject1).bgN();
      localObject2 = ((d)localObject1).bhX();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendArticleReq");
        AppMethodBeat.o(266942);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      AppMethodBeat.o(266942);
    }
    Object localObject2 = (pi)localObject2;
    ((pi)localObject2).RXP = ((ph)sDz.removeFirst());
    Log.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate msgId = " + ((pi)localObject2).RXP.RXN);
    com.tencent.mm.an.aa.a(locald, (aa.a)b.sDE);
    AppMethodBeat.o(266942);
  }
  
  public static final boolean k(z paramz)
  {
    int i = 0;
    AppMethodBeat.i(266941);
    p.k(paramz, "info");
    if ((paramz.hwL() == null) || (!paramz.hwB()))
    {
      AppMethodBeat.o(266941);
      return false;
    }
    switch (paramz.hwL().style)
    {
    default: 
      AppMethodBeat.o(266941);
      return false;
    case 101: 
    case 102: 
    case 103: 
      Log.i("MicroMsg.BizTLCardUpdateMgr", "checkUpdate msgId = " + paramz.field_msgId);
      j localj = sDC;
      p.k(paramz, "info");
      Object localObject;
      if ((((Boolean)sDB.getValue()).booleanValue()) && (paramz.hwB()) && (((b)h.ae(b.class)).a(b.a.vAG, 1) != 0))
      {
        eqg localeqg = paramz.hwL();
        if (localeqg == null) {
          break label276;
        }
        localObject = localeqg.UsD;
        if ((localObject != null) && (localeqg.UsF != null) && (!Util.isNullOrNil((List)localeqg.UsF.RVd)))
        {
          p.k(localeqg, "$this$isExpire");
          int j = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
          if (Math.abs(System.currentTimeMillis() - localeqg.lastUpdateTime) / 1000L > j) {
            i = 1;
          }
          if (i != 0) {
            break label281;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(266941);
        return true;
        label276:
        localObject = null;
        break;
        try
        {
          label281:
          if (!sDA.contains(Long.valueOf(paramz.field_msgId)))
          {
            localObject = k.l(paramz);
            sDA.add(Long.valueOf(((ph)localObject).RXN));
            sDz.add(localObject);
            Log.i("MicroMsg.BizTLCardUpdateMgr", "addUpdateQueue msgId = " + paramz.field_msgId + ", queue size = " + sDz.size());
          }
          paramz = x.aazN;
          localj.cAr();
        }
        finally
        {
          AppMethodBeat.o(266941);
        }
      }
    }
    AppMethodBeat.o(266941);
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final a sDD;
    
    static
    {
      AppMethodBeat.i(266026);
      sDD = new a();
      AppMethodBeat.o(266026);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    public static final b sDE;
    
    static
    {
      AppMethodBeat.i(266917);
      sDE = new b();
      AppMethodBeat.o(266917);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, final com.tencent.mm.an.q paramq)
    {
      Object localObject = null;
      AppMethodBeat.i(266916);
      p.k(paramd, "rr");
      p.k(paramq, "scene");
      paramString = j.sDC;
      j.cAp().set(2);
      j.a(j.sDC);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(266916);
        return 0;
      }
      paramq = paramd.bhY();
      paramString = paramq;
      if (!(paramq instanceof pj)) {
        paramString = null;
      }
      paramq = (pj)paramString;
      if (paramq == null)
      {
        AppMethodBeat.o(266916);
        return 0;
      }
      paramString = paramd.bhX();
      if (!(paramString instanceof pi)) {
        paramString = localObject;
      }
      for (;;)
      {
        paramString = (pi)paramString;
        if (paramString == null)
        {
          AppMethodBeat.o(266916);
          return 0;
        }
        if (paramString.RXP.RXN != paramq.RXQ.RXN)
        {
          AppMethodBeat.o(266916);
          return 0;
        }
        paramString = af.bjB().Uw(paramString.RXP.RXN);
        if (paramString == null)
        {
          AppMethodBeat.o(266916);
          return 0;
        }
        if ((paramq.RXQ == null) || (Util.isNullOrNil((List)paramq.RXQ.RVd)))
        {
          AppMethodBeat.o(266916);
          return 0;
        }
        paramd = j.sDC;
        j.cAq().remove(Long.valueOf(paramString.field_msgId));
        MultiProcessMMKV.getSingleMMKV("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramq.RTQ));
        Log.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate success msgId = " + paramString.field_msgId);
        com.tencent.mm.cw.g.ijP().h((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {}).b((com.tencent.mm.vending.c.a)new j.b.2(paramString));
        AppMethodBeat.o(266916);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.j
 * JD-Core Version:    0.7.0.1
 */