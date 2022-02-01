package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.view.convert.i;
import com.tencent.mm.plugin.finder.live.view.convert.j;
import com.tencent.mm.plugin.finder.live.view.convert.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bec;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveProductOrCouponAppMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "filterPromoteProductOrCoupon", "roomData", "remoteAppMsg", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends f
{
  private final String TAG;
  
  public o(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353260);
    this.TAG = "LiveProductOrCuponAppMsgInterceptor";
    AppMethodBeat.o(353260);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353300);
    s.u(paramLinkedList, "msgList");
    Object localObject6 = eji();
    Object localObject1 = (List)paramLinkedList;
    Object localObject5 = ((List)localObject1).listIterator(((List)localObject1).size());
    int i;
    if (((ListIterator)localObject5).hasPrevious())
    {
      localObject1 = ((ListIterator)localObject5).previous();
      if (((bdm)localObject1).msg_type == 20025)
      {
        i = 1;
        label74:
        if (i == 0) {
          break label802;
        }
        label78:
        localObject7 = (bdm)localObject1;
        if (localObject7 != null) {
          break label810;
        }
        localObject1 = null;
        label93:
        if (localObject1 == null) {
          break label854;
        }
        localObject5 = (com.tencent.mm.bx.a)new beq();
        localObject1 = ((bdm)localObject7).ZNY;
        if (localObject1 != null) {
          break label820;
        }
        localObject1 = null;
      }
    }
    try
    {
      label125:
      ((com.tencent.mm.bx.a)localObject5).parseFrom((byte[])localObject1);
      localObject1 = localObject5;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { localException1 });
        localObject2 = null;
      }
    }
    localObject1 = (beq)localObject1;
    label156:
    Object localObject8;
    Object localObject9;
    if (localObject1 != null)
    {
      localObject1 = ((beq)localObject1).ZLN;
      if (localObject1 != null)
      {
        localObject5 = ((q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject6).business(q.class)).Eie;
        localObject7 = this.TAG;
        localObject8 = new StringBuilder("filterPromoteProduct remotePromoting:").append(((bzc)localObject1).title).append(",localPromoting:");
        localObject9 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        Log.i((String)localObject7, com.tencent.mm.plugin.finder.live.view.convert.a.ewb());
        if (((localObject5 instanceof k)) && (((k)localObject5).DVk == ((bzc)localObject1).DVk)) {
          break label860;
        }
        i = 1;
        label254:
        if ((localObject5 == null) || (((bzc)localObject1).DVr != 0) || (i == 0)) {
          break label865;
        }
        localObject7 = this.TAG;
        localObject1 = new StringBuilder("filterPromoteProduct remote productId:").append(((bzc)localObject1).DVk).append(" promoting:").append(((bzc)localObject1).DVr).append(", local productId:").append(((cc)localObject5).bZA()).append(" promoting:");
        localObject5 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        Log.i((String)localObject7, com.tencent.mm.plugin.finder.live.view.convert.a.ewc());
        localObject1 = ah.aiuX;
      }
      label355:
      localObject1 = (List)paramLinkedList;
      localObject5 = ((List)localObject1).listIterator(((List)localObject1).size());
      label377:
      if (!((ListIterator)localObject5).hasPrevious()) {
        break label989;
      }
      localObject1 = ((ListIterator)localObject5).previous();
      localObject7 = (bdm)localObject1;
      if ((((bdm)localObject7).msg_type != 20021) && (((bdm)localObject7).msg_type != 20022)) {
        break label984;
      }
      i = 1;
      label427:
      if (i == 0) {
        break label987;
      }
      label431:
      localObject1 = (bdm)localObject1;
      if ((localObject1 == null) || (((bdm)localObject1).msg_type != 20021)) {
        break label995;
      }
      i = 1;
      label456:
      if (i == 0) {
        break label1044;
      }
      localObject5 = (com.tencent.mm.bx.a)new bep();
      localObject1 = ((bdm)localObject1).ZNY;
      if (localObject1 != null) {
        break label1000;
      }
      localObject1 = null;
    }
    try
    {
      label487:
      ((com.tencent.mm.bx.a)localObject5).parseFrom((byte[])localObject1);
      localObject1 = localObject5;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        label514:
        label612:
        label748:
        Log.printDebugStack("safeParser", "", new Object[] { localException2 });
        label713:
        label854:
        label860:
        label865:
        label995:
        label1000:
        localObject3 = null;
        label802:
        label810:
        label820:
        label984:
        label987:
        label989:
        continue;
        localObject3 = ((bep)localObject3).ZOG;
      }
    }
    localObject1 = (bep)localObject1;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null)
      {
        localObject5 = ((q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject6).business(q.class)).Eie;
        localObject7 = this.TAG;
        localObject8 = new StringBuilder("ad filterPromoteProduct remotePromoting:").append(((bmt)localObject1).title).append(",localPromoting:");
        localObject9 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        Log.i((String)localObject7, com.tencent.mm.plugin.finder.live.view.convert.a.ewb());
        if (((localObject5 instanceof i)) && (((i)localObject5).DUP == ((bmt)localObject1).DUP)) {
          break label1172;
        }
        i = 1;
        if ((localObject5 == null) || (((bmt)localObject1).Caa != 0) || (i == 0)) {
          break label1177;
        }
        localObject7 = this.TAG;
        localObject1 = new StringBuilder("ad filterPromoteProduct remote productId:").append(((bmt)localObject1).DUP).append(" promoting:").append(((bmt)localObject1).Caa).append(", local productId:").append(((cc)localObject5).bZA()).append(" promoting:");
        localObject5 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        Log.i((String)localObject7, com.tencent.mm.plugin.finder.live.view.convert.a.ewc());
        localObject1 = ah.aiuX;
      }
      localObject5 = new LinkedHashMap();
      localObject1 = (Iterable)paramLinkedList;
      paramLinkedList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
    }
    label1166:
    label1299:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label1301;
      }
      localObject7 = ((Iterator)localObject1).next();
      if (((bdm)localObject7).msg_type == 20037) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1299;
        }
        paramLinkedList.add(localObject7);
        break label748;
        i = 0;
        break label74;
        break;
        localObject1 = null;
        break label78;
        localObject1 = ((bdm)localObject7).ZNY;
        break label93;
        localObject1 = ((b)localObject1).toByteArray();
        break label125;
        Object localObject2 = null;
        break label156;
        i = 0;
        break label254;
        localObject5 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        localObject8 = com.tencent.mm.plugin.finder.live.view.convert.a.b((bzc)localObject2);
        localObject2 = aj.CGT;
        localObject2 = aj.elk();
        if (localObject2 == null) {
          break label355;
        }
        localObject5 = b.c.ndO;
        localObject7 = new Bundle();
        localObject9 = new bla();
        ((bla)localObject9).type = 5;
        ((bla)localObject9).ZTU = new b(((com.tencent.mm.bx.a)((k)localObject8).DVj).toByteArray());
        localObject8 = ah.aiuX;
        ((Bundle)localObject7).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject9).toByteArray());
        localObject8 = ah.aiuX;
        ((com.tencent.mm.plugin.finder.live.view.a)localObject2).statusChange((b.c)localObject5, (Bundle)localObject7);
        localObject2 = ah.aiuX;
        break label355;
        i = 0;
        break label427;
        break label377;
        localObject2 = null;
        break label431;
        i = 0;
        break label456;
        localObject2 = ((b)localObject2).toByteArray();
        break label487;
        label1044:
        if ((localObject3 != null) && (((bdm)localObject3).msg_type == 20022))
        {
          i = 1;
          label1062:
          if (i == 0) {
            break label1166;
          }
          localObject5 = (com.tencent.mm.bx.a)new bec();
          localObject3 = ((bdm)localObject3).ZNY;
          if (localObject3 != null) {
            break label1132;
          }
        }
        for (Object localObject3 = null;; localObject3 = ((b)localObject3).toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject5).parseFrom((byte[])localObject3);
            localObject3 = localObject5;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              label1132:
              Log.printDebugStack("safeParser", "", new Object[] { localException3 });
              localObject4 = null;
            }
          }
          localObject3 = (bec)localObject3;
          if (localObject3 == null) {
            break label1166;
          }
          localObject3 = ((bec)localObject3).ZOG;
          break;
          i = 0;
          break label1062;
        }
        localObject4 = null;
        break label514;
        label1172:
        i = 0;
        break label612;
        label1177:
        localObject5 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        localObject8 = com.tencent.mm.plugin.finder.live.view.convert.a.a((bmt)localObject4);
        localObject4 = aj.CGT;
        localObject4 = aj.elk();
        if (localObject4 == null) {
          break label713;
        }
        localObject5 = b.c.ndO;
        localObject7 = new Bundle();
        localObject9 = new bla();
        ((bla)localObject9).type = 4;
        ((bla)localObject9).ZTU = new b(((com.tencent.mm.bx.a)((i)localObject8).DUO).toByteArray());
        localObject8 = ah.aiuX;
        ((Bundle)localObject7).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject9).toByteArray());
        localObject8 = ah.aiuX;
        ((com.tencent.mm.plugin.finder.live.view.a)localObject4).statusChange((b.c)localObject5, (Bundle)localObject7);
        localObject4 = ah.aiuX;
        break label713;
      }
    }
    label1301:
    Object localObject7 = ((Iterable)paramLinkedList).iterator();
    label1366:
    label1381:
    boolean bool;
    if (((Iterator)localObject7).hasNext())
    {
      paramLinkedList = (bdm)((Iterator)localObject7).next();
      if (paramLinkedList.ZNY != null)
      {
        localObject4 = (com.tencent.mm.bx.a)new bei();
        paramLinkedList = paramLinkedList.ZNY;
        if (paramLinkedList == null) {
          paramLinkedList = null;
        }
        try
        {
          ((com.tencent.mm.bx.a)localObject4).parseFrom(paramLinkedList);
          paramLinkedList = (LinkedList<bdm>)localObject4;
        }
        catch (Exception paramLinkedList)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
            paramLinkedList = null;
          }
        }
        paramLinkedList = (bei)paramLinkedList;
        if (paramLinkedList == null) {
          break label1473;
        }
        localObject4 = paramLinkedList.ZOP;
        if (localObject4 != null) {
          break label1475;
        }
      }
      for (paramLinkedList = null;; paramLinkedList = null)
      {
        if (paramLinkedList != null)
        {
          localObject4 = paramLinkedList.mdN;
          if (localObject4 != null)
          {
            ((LinkedHashMap)localObject5).put(localObject4, paramLinkedList);
            paramLinkedList = ah.aiuX;
            paramLinkedList = ah.aiuX;
          }
        }
        paramLinkedList = ah.aiuX;
        paramLinkedList = ah.aiuX;
        break;
        paramLinkedList = paramLinkedList.toByteArray();
        break label1366;
        paramLinkedList = null;
        break label1381;
        label1473:
        break;
        label1475:
        localObject8 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        localObject4 = com.tencent.mm.plugin.finder.live.view.convert.a.a((bvo)localObject4);
        if (localObject4 != null) {
          break label1497;
        }
      }
      label1497:
      if (paramLinkedList.ZOQ <= 0) {}
      for (bool = true;; bool = false)
      {
        ((j)localObject4).DVc = bool;
        paramLinkedList = ah.aiuX;
        paramLinkedList = (LinkedList<bdm>)localObject4;
        break;
      }
    }
    Object localObject4 = ((q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject6).business(q.class)).Eie;
    paramLinkedList = ((LinkedHashMap)localObject5).values();
    s.s(paramLinkedList, "stockIdToCouponItem.values");
    localObject6 = p.m((Iterable)paramLinkedList).iterator();
    while (((Iterator)localObject6).hasNext())
    {
      localObject5 = (j)((Iterator)localObject6).next();
      Log.i(this.TAG, "coupon filterPromoteProduct " + ((j)localObject5).DVc + " remotePromoting:" + localObject5 + ",localPromoting:" + localObject4);
      if (!((j)localObject5).DVc)
      {
        if (localObject4 == null)
        {
          bool = true;
          label1655:
          if (!bool) {
            break label1797;
          }
          localObject7 = ((j)localObject5).mdN;
          paramLinkedList = (j)localObject4;
          if (paramLinkedList != null) {
            break label1799;
          }
        }
        label1797:
        label1799:
        for (paramLinkedList = null;; paramLinkedList = paramLinkedList.mdN)
        {
          if (!s.p(localObject7, paramLinkedList)) {
            break label1805;
          }
          paramLinkedList = aj.CGT;
          paramLinkedList = aj.elk();
          if (paramLinkedList == null) {
            break;
          }
          localObject7 = b.c.ndO;
          localObject8 = new Bundle();
          localObject9 = new bla();
          ((bla)localObject9).type = 6;
          ((bla)localObject9).ZTU = new b(((com.tencent.mm.bx.a)((j)localObject5).DUV).toByteArray());
          localObject5 = ah.aiuX;
          ((Bundle)localObject8).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject9).toByteArray());
          localObject5 = ah.aiuX;
          paramLinkedList.statusChange((b.c)localObject7, (Bundle)localObject8);
          paramLinkedList = ah.aiuX;
          break;
          bool = localObject4 instanceof j;
          break label1655;
          break;
        }
      }
      else
      {
        label1805:
        paramLinkedList = aj.CGT;
        paramLinkedList = aj.elk();
        if (paramLinkedList != null)
        {
          localObject4 = b.c.ndO;
          localObject6 = new Bundle();
          localObject7 = new bla();
          ((bla)localObject7).type = 6;
          ((bla)localObject7).ZTU = new b(((com.tencent.mm.bx.a)((j)localObject5).DUV).toByteArray());
          localObject5 = ah.aiuX;
          ((Bundle)localObject6).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject7).toByteArray());
          localObject5 = ah.aiuX;
          paramLinkedList.statusChange((b.c)localObject4, (Bundle)localObject6);
          paramLinkedList = ah.aiuX;
        }
      }
    }
    AppMethodBeat.o(353300);
  }
  
  public final int[] ejj()
  {
    return new int[] { 20025, 20021, 20022, 20037 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.o
 * JD-Core Version:    0.7.0.1
 */