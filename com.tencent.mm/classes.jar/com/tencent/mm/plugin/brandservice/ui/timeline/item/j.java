package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pk;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.protocal.protobuf.pn;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLCardUpdateMgr;", "", "()V", "STATE_IDLE", "", "STATE_UPDATING", "TAG", "", "isUpdateCardOpen", "", "()Z", "isUpdateCardOpen$delegate", "Lkotlin/Lazy;", "mgrState", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMgrState", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setMgrState", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "setQueue", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getSetQueue", "()Ljava/util/HashSet;", "updateQueue", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "getUpdateQueue", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "addUpdateQueue", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "checkUpdate", "tryUpdate", "plugin-brandservice_release"})
public final class j
{
  private static AtomicInteger pul;
  private static final ConcurrentLinkedDeque<pl> pum;
  private static final HashSet<Long> pun;
  private static final kotlin.f puo;
  public static final j pup;
  
  static
  {
    AppMethodBeat.i(195293);
    pup = new j();
    pul = new AtomicInteger(2);
    pum = new ConcurrentLinkedDeque();
    pun = new HashSet();
    puo = kotlin.g.ah((kotlin.g.a.a)a.puq);
    AppMethodBeat.o(195293);
  }
  
  public static AtomicInteger cmI()
  {
    return pul;
  }
  
  public static HashSet<Long> cmJ()
  {
    return pun;
  }
  
  private final void cmK()
  {
    AppMethodBeat.i(195292);
    if (pum.size() <= 0)
    {
      Log.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate size <= 0");
      AppMethodBeat.o(195292);
      return;
    }
    try
    {
      int i = pul.get();
      if (i == 1) {
        return;
      }
      pul.set(1);
      Object localObject1 = x.SXb;
      localObject1 = new d.a();
      ((d.a)localObject1).c((com.tencent.mm.bw.a)new pm());
      ((d.a)localObject1).d((com.tencent.mm.bw.a)new pn());
      ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/timeline/bizrecommendarticle");
      ((d.a)localObject1).sG(1084);
      localObject1 = ((d.a)localObject1).aXF();
      localObject2 = ((d)localObject1).aYJ();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizRecommendArticleReq");
        AppMethodBeat.o(195292);
        throw ((Throwable)localObject1);
      }
    }
    finally
    {
      AppMethodBeat.o(195292);
    }
    Object localObject2 = (pm)localObject2;
    ((pm)localObject2).KWB = ((pl)pum.removeFirst());
    Log.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate msgId = " + ((pm)localObject2).KWB.KWz);
    com.tencent.mm.ak.aa.a(locald, (aa.a)b.pur);
    AppMethodBeat.o(195292);
  }
  
  public static final boolean k(z paramz)
  {
    int i = 0;
    AppMethodBeat.i(195291);
    p.h(paramz, "info");
    if ((paramz.gAD() == null) || (!paramz.gAu()))
    {
      AppMethodBeat.o(195291);
      return false;
    }
    switch (paramz.gAD().style)
    {
    default: 
      AppMethodBeat.o(195291);
      return false;
    case 101: 
    case 102: 
    case 103: 
      Log.i("MicroMsg.BizTLCardUpdateMgr", "checkUpdate msgId = " + paramz.field_msgId);
      j localj = pup;
      p.h(paramz, "info");
      Object localObject;
      if ((((Boolean)puo.getValue()).booleanValue()) && (paramz.gAu()) && (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rUb, 1) != 0))
      {
        ege localege = paramz.gAD();
        if (localege == null) {
          break label276;
        }
        localObject = localege.NfY;
        if ((localObject != null) && (localege.Nga != null) && (!Util.isNullOrNil((List)localege.Nga.KUf)))
        {
          p.h(localege, "$this$isExpire");
          int j = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
          if (Math.abs(System.currentTimeMillis() - localege.lastUpdateTime) / 1000L > j) {
            i = 1;
          }
          if (i != 0) {
            break label281;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(195291);
        return true;
        label276:
        localObject = null;
        break;
        try
        {
          label281:
          if (!pun.contains(Long.valueOf(paramz.field_msgId)))
          {
            localObject = k.l(paramz);
            pun.add(Long.valueOf(((pl)localObject).KWz));
            pum.add(localObject);
            Log.i("MicroMsg.BizTLCardUpdateMgr", "addUpdateQueue msgId = " + paramz.field_msgId + ", queue size = " + pum.size());
          }
          paramz = x.SXb;
          localj.cmK();
        }
        finally
        {
          AppMethodBeat.o(195291);
        }
      }
    }
    AppMethodBeat.o(195291);
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    public static final a puq;
    
    static
    {
      AppMethodBeat.i(195286);
      puq = new a();
      AppMethodBeat.o(195286);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class b
    implements aa.a
  {
    public static final b pur;
    
    static
    {
      AppMethodBeat.i(195290);
      pur = new b();
      AppMethodBeat.o(195290);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, final com.tencent.mm.ak.q paramq)
    {
      Object localObject = null;
      AppMethodBeat.i(195289);
      p.h(paramd, "rr");
      p.h(paramq, "scene");
      paramString = j.pup;
      j.cmI().set(2);
      j.a(j.pup);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(195289);
        return 0;
      }
      paramq = paramd.aYK();
      paramString = paramq;
      if (!(paramq instanceof pn)) {
        paramString = null;
      }
      paramq = (pn)paramString;
      if (paramq == null)
      {
        AppMethodBeat.o(195289);
        return 0;
      }
      paramString = paramd.aYJ();
      if (!(paramString instanceof pm)) {
        paramString = localObject;
      }
      for (;;)
      {
        paramString = (pm)paramString;
        if (paramString == null)
        {
          AppMethodBeat.o(195289);
          return 0;
        }
        if (paramString.KWB.KWz != paramq.KWC.KWz)
        {
          AppMethodBeat.o(195289);
          return 0;
        }
        paramString = ag.ban().MM(paramString.KWB.KWz);
        if (paramString == null)
        {
          AppMethodBeat.o(195289);
          return 0;
        }
        if ((paramq.KWC == null) || (Util.isNullOrNil((List)paramq.KWC.KUf)))
        {
          AppMethodBeat.o(195289);
          return 0;
        }
        paramd = j.pup;
        j.cmJ().remove(Long.valueOf(paramString.field_msgId));
        MultiProcessMMKV.getSingleMMKV("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, paramq.KSO));
        Log.i("MicroMsg.BizTLCardUpdateMgr", "tryUpdate success msgId = " + paramString.field_msgId);
        com.tencent.mm.co.g.hio().h((com.tencent.mm.vending.c.a)new com.tencent.mm.vending.c.a() {}).b((com.tencent.mm.vending.c.a)new j.b.2(paramString));
        AppMethodBeat.o(195289);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.j
 * JD-Core Version:    0.7.0.1
 */