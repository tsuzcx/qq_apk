package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.d;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.m;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bin;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bnp;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAppMsgManager;", "", "()V", "TAG", "", "updateTemplateInfo", "", "roomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "appMsgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTemplateInfo;", "fromJoinLive", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e CEd;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(359338);
    CEd = new e();
    TAG = "FinderLiveAppMsgManager";
    AppMethodBeat.o(359338);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<bnp> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(359323);
    s.u(parama, "roomData");
    StringBuilder localStringBuilder1 = new StringBuilder("updateTemplateInfo(fromJoinLive:" + paramBoolean + "):");
    LinkedList localLinkedList3 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    label146:
    label166:
    label173:
    label313:
    label828:
    label1216:
    if (paramLinkedList != null)
    {
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      int j = 0;
      label86:
      if (localIterator.hasNext())
      {
        paramLinkedList = localIterator.next();
        if (j < 0) {
          p.kkW();
        }
        Object localObject2 = (bnp)paramLinkedList;
        Object localObject1 = new StringBuilder("(").append(j).append(")[msgType:");
        boolean bool;
        if (localObject2 == null)
        {
          paramLinkedList = null;
          localObject1 = ((StringBuilder)localObject1).append(paramLinkedList).append(",payload is empty:");
          if (localObject2 != null) {
            break label313;
          }
          paramLinkedList = null;
          if (paramLinkedList != null) {
            break label322;
          }
          bool = true;
          localObject1 = ((StringBuilder)localObject1).append(bool).append(",versionWording:");
          if (localObject2 != null) {
            break label328;
          }
        }
        for (paramLinkedList = null;; paramLinkedList = ((bnp)localObject2).ZWo)
        {
          localStringBuilder1.append(paramLinkedList + ",seq:" + ((bnp)localObject2).oUj + "}] ");
          if (localObject2 != null) {}
          switch (((bnp)localObject2).infoType)
          {
          case 30005: 
          default: 
            paramLinkedList = ah.aiuX;
            paramLinkedList = ah.aiuX;
            paramLinkedList = ah.aiuX;
            j += 1;
            break label86;
            paramLinkedList = Integer.valueOf(((bnp)localObject2).infoType);
            break label146;
            paramLinkedList = ((bnp)localObject2).ZWn;
            break label166;
            bool = false;
            break label173;
          }
        }
        localObject1 = (com.tencent.mm.bx.a)new bjc();
        paramLinkedList = ((bnp)localObject2).ZWn;
        if (paramLinkedList == null) {}
        for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<bnp>)localObject1;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
              continue;
              paramLinkedList = ((bjc)localObject2).id;
              continue;
              paramLinkedList = paramLinkedList.Bhm;
              if (paramLinkedList == null)
              {
                i = 2147483647;
              }
              else
              {
                i = paramLinkedList.CWC;
                continue;
                paramLinkedList = paramLinkedList.Bhm;
                if (paramLinkedList == null)
                {
                  paramLinkedList = null;
                }
                else
                {
                  paramLinkedList = paramLinkedList.id;
                  continue;
                  if (d.a(localLinkedList3, (kotlin.g.a.b)new a((bjc)localObject2))) {
                    Log.i(TAG, "updateTemplateInfo remove the last same item id:" + ((bjc)localObject2).id + '!');
                  }
                  localLinkedList3.add(localObject2);
                  continue;
                  localObject3 = TAG;
                  StringBuilder localStringBuilder2 = new StringBuilder("updateTemplateInfo ");
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  Log.e((String)localObject3, f.dg(localObject1) + " fail," + paramLinkedList + " have show!");
                }
              }
            }
          }
          localObject2 = (bjc)paramLinkedList;
          if (localObject2 != null) {
            break label531;
          }
          paramLinkedList = null;
          if ((paramLinkedList == null) || (((k)parama.business(k.class)).ayv(paramLinkedList))) {
            break label647;
          }
          paramLinkedList = ((k)parama.business(k.class)).Egp;
          if (paramLinkedList != null) {
            break label540;
          }
          i = 2147483647;
          paramLinkedList = ((k)parama.business(k.class)).Egp;
          if (paramLinkedList != null) {
            break label563;
          }
          paramLinkedList = null;
          if ((!s.p(((bjc)localObject2).id, paramLinkedList)) || (((bjc)localObject2).CWC <= i)) {
            break label585;
          }
          Log.i(TAG, "updateTemplateInfo drop the old time lottteryInfo:" + f.dg(localObject2) + '!');
          paramLinkedList = ah.aiuX;
          break;
        }
        Object localObject3;
        localObject1 = (com.tencent.mm.bx.a)new bls();
        paramLinkedList = ((bnp)localObject2).ZWn;
        if (paramLinkedList == null) {}
        for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<bnp>)localObject1;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
              continue;
              Log.i(TAG, "updateTemplateInfo redPackInfo is null!");
            }
          }
          paramLinkedList = (bls)paramLinkedList;
          if (paramLinkedList == null) {
            break label828;
          }
          Log.i(TAG, "updateTemplateInfo redPackInfo:" + f.dg(paramLinkedList) + '!');
          localLinkedList2.add(paramLinkedList);
          paramLinkedList = ah.aiuX;
          break;
        }
        localObject1 = (com.tencent.mm.bx.a)new bfs();
        paramLinkedList = ((bnp)localObject2).ZWn;
        if (paramLinkedList == null) {}
        for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<bnp>)localObject1;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
              continue;
              paramLinkedList = ((bfs)localObject1).ZPA;
              continue;
              paramLinkedList = Long.valueOf(((bfs)localObject1).ZOv);
              continue;
              paramLinkedList = Integer.valueOf(((bfs)localObject1).status);
              continue;
              paramLinkedList = Integer.valueOf(((bfs)localObject1).ZPB);
              continue;
              paramLinkedList = Integer.valueOf(((bfs)localObject1).result);
              continue;
              paramLinkedList = ((bfs)localObject1).ZPC;
              if (paramLinkedList == null) {
                paramLinkedList = null;
              } else {
                paramLinkedList = Integer.valueOf(paramLinkedList.size());
              }
            }
          }
          localObject1 = (bfs)paramLinkedList;
          localObject2 = TAG;
          localObject3 = new StringBuilder("updateTemplateInfo battleInfo:[");
          if (localObject1 != null) {
            break label1195;
          }
          paramLinkedList = null;
          localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
          if (localObject1 != null) {
            break label1204;
          }
          paramLinkedList = null;
          localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
          if (localObject1 != null) {
            break label1216;
          }
          paramLinkedList = null;
          localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
          if (localObject1 != null) {
            break label1228;
          }
          paramLinkedList = null;
          localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
          if (localObject1 != null) {
            break label1240;
          }
          paramLinkedList = null;
          localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
          if (localObject1 != null) {
            break label1252;
          }
          paramLinkedList = null;
          Log.i((String)localObject2, paramLinkedList + ']');
          if (localObject1 == null) {
            break;
          }
          Log.i(TAG, s.X("updateTemplateInfo curBattleInfo:", ((j)parama.business(j.class)).EfK));
          paramLinkedList = ((j)parama.business(j.class)).EfK;
          if (paramLinkedList == null) {
            break;
          }
          if ((paramLinkedList.CEW != 3) && (Util.isEqual(paramLinkedList.CES, ((bfs)localObject1).ZPA)))
          {
            if (paramLinkedList.CEU - ((bfs)localObject1).ZPB >= 3) {
              paramLinkedList.CEU = ((bfs)localObject1).ZPB;
            }
            paramLinkedList.CEV = ((bfs)localObject1).result;
            localObject1 = ((bfs)localObject1).ZPC;
            s.s(localObject1, "battleInfo.player_info");
            paramLinkedList.gr((List)localObject1);
          }
          paramLinkedList = ah.aiuX;
          paramLinkedList = ah.aiuX;
          break;
        }
        label1240:
        label1252:
        localObject1 = (com.tencent.mm.bx.a)new bct();
        paramLinkedList = ((bnp)localObject2).ZWn;
        if (paramLinkedList == null) {}
        for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<bnp>)localObject1;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
              continue;
              paramLinkedList = ((bct)localObject1).title;
              continue;
              paramLinkedList = ((bct)localObject1).wording;
            }
          }
          localObject1 = (bct)paramLinkedList;
          localObject2 = TAG;
          localObject3 = new StringBuilder("updateTemplateInfo pageInfo: ");
          if (localObject1 != null) {
            break label1458;
          }
          paramLinkedList = null;
          localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
          if (localObject1 != null) {
            break label1467;
          }
          paramLinkedList = null;
          Log.i((String)localObject2, paramLinkedList);
          if (localObject1 == null) {
            break;
          }
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efl = ((bct)localObject1).title;
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efm = ((bct)localObject1).wording;
          paramLinkedList = ah.aiuX;
          paramLinkedList = ah.aiuX;
          break;
        }
        localObject1 = (com.tencent.mm.bx.a)new bin();
        paramLinkedList = ((bnp)localObject2).ZWn;
        if (paramLinkedList == null) {}
        for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<bnp>)localObject1;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
              continue;
              paramLinkedList = ((bin)localObject2).ZRa;
              continue;
              paramLinkedList = Integer.valueOf(((bin)localObject2).ZRL);
            }
          }
          localObject2 = (bin)paramLinkedList;
          localObject1 = TAG;
          localObject3 = new StringBuilder("updateTemplateInfo giftInfo: package_id=");
          if (localObject2 != null) {
            break label1756;
          }
          paramLinkedList = null;
          localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", remain_time=");
          if (localObject2 != null) {
            break label1765;
          }
          paramLinkedList = null;
          Log.i((String)localObject1, paramLinkedList);
          if (localObject2 == null) {
            break;
          }
          localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class);
          Log.i("AllowanceGiftSlice", "#updateAllowanceInfo package_id=" + ((bin)localObject2).ZRa + " remain_time=" + Integer.valueOf(((bin)localObject2).ZRL));
          if (!s.p(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).Ecb, ((bin)localObject2).ZRa))
          {
            localObject1 = ((bin)localObject2).ZRa;
            paramLinkedList = (LinkedList<bnp>)localObject1;
            if (localObject1 == null) {
              paramLinkedList = "";
            }
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).Ecc = paramLinkedList;
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).Ecd = (((bin)localObject2).ZRL * 1000 + System.currentTimeMillis());
          }
          if (ah.aiuX == null)
          {
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).Ecc = "";
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject3).Ecd = -1L;
          }
          paramLinkedList = ah.aiuX;
          paramLinkedList = ah.aiuX;
          break;
        }
        label1756:
        label1765:
        localObject1 = (com.tencent.mm.bx.a)new bmw();
        paramLinkedList = ((bnp)localObject2).ZWn;
        if (paramLinkedList == null) {}
        for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
        {
          try
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
            paramLinkedList = (LinkedList<bnp>)localObject1;
          }
          catch (Exception paramLinkedList)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
              paramLinkedList = null;
            }
          }
          paramLinkedList = (bmw)paramLinkedList;
          if (paramLinkedList != null) {
            localLinkedList1.add(paramLinkedList);
          }
          paramLinkedList = ah.aiuX;
          break;
        }
      }
      label322:
      label328:
      label585:
      label1228:
      paramLinkedList = ah.aiuX;
    }
    label531:
    label540:
    label563:
    label1204:
    label1467:
    Log.i(TAG, localStringBuilder1.toString());
    label647:
    label1195:
    label1458:
    if (localLinkedList3.size() > 0) {
      ((k)parama.business(k.class)).c(localLinkedList3, paramBoolean);
    }
    if (((Collection)localLinkedList2).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        paramLinkedList = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        s.u(localLinkedList2, "liveMsgRedPacketInfoList");
        d.uiThread((kotlin.g.a.a)new e.d(paramLinkedList, localLinkedList2, paramBoolean));
      }
      if (!((Collection)localLinkedList1).isEmpty()) {
        break label2021;
      }
    }
    label2021:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        s.u(localLinkedList1, "remoteFastCommentInfoList");
        d.uiThread((kotlin.g.a.a)new e.c(parama, localLinkedList1));
      }
      AppMethodBeat.o(359323);
      return;
      i = 0;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<bjc, Boolean>
  {
    a(bjc parambjc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.e
 * JD-Core Version:    0.7.0.1
 */