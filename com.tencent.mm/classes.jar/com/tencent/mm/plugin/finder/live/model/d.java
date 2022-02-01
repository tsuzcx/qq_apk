package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.d;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.aye;
import com.tencent.mm.protocal.protobuf.ayr;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.protocal.protobuf.bdb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.axe;>;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdb;>;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAppMsgManager;", "", "()V", "TAG", "", "chooseAlertInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "info1", "info2", "handleAlertMsg", "", "roomData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "appMsgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "updateTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTemplateInfo;", "fromJoinLive", "", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "FinderLiveAppMsgManager";
  public static final d ydx;
  
  static
  {
    AppMethodBeat.i(289441);
    ydx = new d();
    TAG = "FinderLiveAppMsgManager";
    AppMethodBeat.o(289441);
  }
  
  private static bbe a(bbe parambbe1, bbe parambbe2)
  {
    switch (parambbe1.type)
    {
    }
    do
    {
      do
      {
        return parambbe1;
      } while ((parambbe2.type != 20011) && (parambbe2.type != 20007));
      return parambbe2;
    } while (parambbe2.type != 20007);
    return parambbe2;
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<axe> paramLinkedList)
  {
    AppMethodBeat.i(289437);
    p.k(parama, "roomData");
    StringBuilder localStringBuilder1 = new StringBuilder("handleAlertMsg:");
    int i;
    label41:
    Object localObject1;
    int j;
    Object localObject4;
    label116:
    label378:
    StringBuilder localStringBuilder2;
    if (paramLinkedList != null)
    {
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      i = 0;
      paramLinkedList = null;
      localObject1 = paramLinkedList;
      if (!localIterator.hasNext()) {
        break label702;
      }
      localObject1 = localIterator.next();
      j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      localObject4 = (axe)localObject1;
      localObject3 = new StringBuilder("(").append(i).append(")[msgType:");
      label145:
      boolean bool;
      if (localObject4 != null)
      {
        localObject1 = Integer.valueOf(((axe)localObject4).msg_type);
        localObject3 = ((StringBuilder)localObject3).append(((Integer)localObject1).intValue()).append(",payload is empty:");
        if (localObject4 == null) {
          break label323;
        }
        localObject1 = ((axe)localObject4).SJE;
        if (localObject1 != null) {
          break label329;
        }
        bool = true;
        label153:
        localObject3 = ((StringBuilder)localObject3).append(bool).append(",fromUser:");
        if (localObject4 == null) {
          break label335;
        }
        localObject1 = ((axe)localObject4).SJH;
        if (localObject1 == null) {
          break label335;
        }
        localObject1 = ((aza)localObject1).contact;
        if (localObject1 == null) {
          break label335;
        }
        localObject1 = ((FinderContact)localObject1).nickname;
        label203:
        localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(",toUser:");
        if (localObject4 == null) {
          break label341;
        }
        localObject1 = ((axe)localObject4).SJC;
        if (localObject1 == null) {
          break label341;
        }
        localObject1 = ((aza)localObject1).contact;
        if (localObject1 == null) {
          break label341;
        }
      }
      label312:
      label323:
      label329:
      label335:
      label341:
      for (localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
      {
        localStringBuilder1.append((String)localObject1 + "] ");
        if (localObject4 != null) {}
        switch (((axe)localObject4).msg_type)
        {
        default: 
          i = j;
          break label41;
          localObject1 = null;
          break label116;
          localObject1 = null;
          break label145;
          bool = false;
          break label153;
          localObject1 = null;
          break label203;
        }
      }
      localObject3 = (com.tencent.mm.cd.a)new aye();
      localObject1 = ((axe)localObject4).SJE;
      if (localObject1 != null) {
        localObject1 = ((com.tencent.mm.cd.b)localObject1).toByteArray();
      }
      try
      {
        ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = localObject3;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          localObject2 = null;
          continue;
          localObject2 = null;
        }
      }
      localObject1 = (aye)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((aye)localObject1).SJV;
        localObject4 = TAG;
        localStringBuilder2 = new StringBuilder("parseMsgBoxInfo:");
        if (localObject1 != null) {
          break label758;
        }
      }
    }
    label555:
    bbe localbbe;
    label702:
    label748:
    label758:
    for (Object localObject3 = "";; localObject3 = localbbe)
    {
      Log.i((String)localObject4, com.tencent.mm.ae.g.bN(localObject3));
      if (paramLinkedList == null)
      {
        i = j;
        paramLinkedList = (LinkedList<axe>)localObject1;
        break;
        localObject1 = null;
        break label378;
      }
      Object localObject2;
      if (localObject2 != null)
      {
        if (paramLinkedList == null) {
          p.iCn();
        }
        paramLinkedList = a(paramLinkedList, (bbe)localObject2);
      }
      for (;;)
      {
        i = j;
        break;
        localObject3 = (com.tencent.mm.cd.a)new axi();
        localObject2 = ((axe)localObject4).SJE;
        if (localObject2 != null) {
          localObject2 = ((com.tencent.mm.cd.b)localObject2).toByteArray();
        }
        try
        {
          ((com.tencent.mm.cd.a)localObject3).parseFrom((byte[])localObject2);
          localObject2 = localObject3;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException2 });
            localbbe = null;
            continue;
            localbbe = null;
          }
        }
        localObject2 = (axi)localObject2;
        if (localObject2 != null)
        {
          localObject2 = ((axi)localObject2).SJV;
          localObject4 = TAG;
          localStringBuilder2 = new StringBuilder("parseMsgBoxInfo:");
          if (localObject2 != null) {
            break label748;
          }
        }
        for (localObject3 = "";; localObject3 = localbbe)
        {
          Log.i((String)localObject4, com.tencent.mm.ae.g.bN(localObject3));
          if (paramLinkedList == null)
          {
            i = j;
            paramLinkedList = (LinkedList<axe>)localObject2;
            break;
            localObject2 = null;
            break label555;
          }
          if (localbbe == null) {
            break label312;
          }
          if (paramLinkedList == null) {
            p.iCn();
          }
          paramLinkedList = a(paramLinkedList, localbbe);
          break label312;
          localbbe = null;
          if (localbbe != null) {
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.d((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class), localbbe));
          }
          Log.i(TAG, localStringBuilder1.toString());
          AppMethodBeat.o(289437);
          return;
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, LinkedList<bdb> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(289439);
    p.k(parama, "roomData");
    StringBuilder localStringBuilder1 = new StringBuilder("updateTemplateInfo(fromJoinLive:" + paramBoolean + "):");
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    label146:
    label173:
    label302:
    if (paramLinkedList != null)
    {
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      i = 0;
      label180:
      label1223:
      for (;;)
      {
        label76:
        if (localIterator.hasNext())
        {
          paramLinkedList = localIterator.next();
          int j = i + 1;
          if (i < 0) {
            j.iBO();
          }
          Object localObject2 = (bdb)paramLinkedList;
          Object localObject1 = new StringBuilder("(").append(i).append(")[msgType:");
          boolean bool;
          if (localObject2 != null)
          {
            paramLinkedList = Integer.valueOf(((bdb)localObject2).infoType);
            localObject1 = ((StringBuilder)localObject1).append(paramLinkedList.intValue()).append(",payload is empty:");
            if (localObject2 == null) {
              break label291;
            }
            paramLinkedList = ((bdb)localObject2).SOn;
            if (paramLinkedList != null) {
              break label296;
            }
            bool = true;
            localObject1 = ((StringBuilder)localObject1).append(bool).append(",versionWording:");
            if (localObject2 == null) {
              break label302;
            }
          }
          for (paramLinkedList = ((bdb)localObject2).SOo;; paramLinkedList = null)
          {
            localStringBuilder1.append(paramLinkedList + ",seq:" + ((bdb)localObject2).mbp + "}] ");
            if (localObject2 != null) {}
            switch (((bdb)localObject2).infoType)
            {
            default: 
              i = j;
              break label76;
              paramLinkedList = null;
              break label146;
              paramLinkedList = null;
              break label173;
              bool = false;
              break label180;
            }
          }
          localObject1 = (com.tencent.mm.cd.a)new bal();
          paramLinkedList = ((bdb)localObject2).SOn;
          if (paramLinkedList != null) {}
          for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null)
          {
            try
            {
              ((com.tencent.mm.cd.a)localObject1).parseFrom(paramLinkedList);
              paramLinkedList = (LinkedList<bdb>)localObject1;
            }
            catch (Exception paramLinkedList)
            {
              for (;;)
              {
                Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
                paramLinkedList = null;
                continue;
                paramLinkedList = null;
                continue;
                i = 2147483647;
                continue;
                paramLinkedList = null;
              }
              if (!com.tencent.mm.ae.d.a(localLinkedList2, (kotlin.g.a.b)new a((bal)localObject2))) {
                break label600;
              }
              Log.i(TAG, "updateTemplateInfo remove the last same item id:" + ((bal)localObject2).id + '!');
              localLinkedList2.add(localObject2);
              i = j;
            }
            localObject2 = (bal)paramLinkedList;
            if (localObject2 == null) {
              break label531;
            }
            paramLinkedList = ((bal)localObject2).id;
            if ((paramLinkedList == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class)).aDd(paramLinkedList))) {
              break label614;
            }
            paramLinkedList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class)).zic;
            if (paramLinkedList == null) {
              break label536;
            }
            paramLinkedList = paramLinkedList.xHW;
            if (paramLinkedList == null) {
              break label536;
            }
            i = paramLinkedList.ynN;
            paramLinkedList = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class)).zic;
            if (paramLinkedList == null) {
              break label543;
            }
            paramLinkedList = paramLinkedList.xHW;
            if (paramLinkedList == null) {
              break label543;
            }
            paramLinkedList = paramLinkedList.id;
            if ((!p.h(((bal)localObject2).id, paramLinkedList)) || (((bal)localObject2).ynN <= i)) {
              break label548;
            }
            Log.i(TAG, "updateTemplateInfo drop the old time lottteryInfo:" + com.tencent.mm.ae.g.bN(localObject2) + '!');
            i = j;
            break;
          }
          label600:
          continue;
          label614:
          Object localObject3 = TAG;
          StringBuilder localStringBuilder2 = new StringBuilder("updateTemplateInfo ");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          Log.e((String)localObject3, com.tencent.mm.ae.g.bN(localObject1) + " fail," + paramLinkedList + " have show!");
          i = j;
          continue;
          localObject1 = (com.tencent.mm.cd.a)new bbx();
          paramLinkedList = ((bdb)localObject2).SOn;
          if (paramLinkedList != null) {}
          for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null)
          {
            try
            {
              ((com.tencent.mm.cd.a)localObject1).parseFrom(paramLinkedList);
              paramLinkedList = (LinkedList<bdb>)localObject1;
            }
            catch (Exception paramLinkedList)
            {
              for (;;)
              {
                Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
                paramLinkedList = null;
              }
              Log.i(TAG, "updateTemplateInfo redPackInfo is null!");
              i = j;
            }
            paramLinkedList = (bbx)paramLinkedList;
            if (paramLinkedList == null) {
              break label800;
            }
            Log.i(TAG, "updateTemplateInfo redPackInfo:" + com.tencent.mm.ae.g.bN(paramLinkedList) + '!');
            localLinkedList1.add(paramLinkedList);
            i = j;
            break;
          }
          continue;
          localObject1 = (com.tencent.mm.cd.a)new ayr();
          paramLinkedList = ((bdb)localObject2).SOn;
          if (paramLinkedList != null) {}
          for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null)
          {
            try
            {
              ((com.tencent.mm.cd.a)localObject1).parseFrom(paramLinkedList);
              paramLinkedList = (LinkedList<bdb>)localObject1;
            }
            catch (Exception paramLinkedList)
            {
              for (;;)
              {
                Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
                paramLinkedList = null;
                continue;
                paramLinkedList = null;
                continue;
                paramLinkedList = null;
                continue;
                paramLinkedList = null;
                continue;
                paramLinkedList = null;
                continue;
                paramLinkedList = null;
                continue;
                paramLinkedList = null;
              }
              i = j;
            }
            localObject1 = (ayr)paramLinkedList;
            localObject2 = TAG;
            localObject3 = new StringBuilder("updateTemplateInfo battleInfo:[");
            if (localObject1 == null) {
              break label1223;
            }
            paramLinkedList = ((ayr)localObject1).SKH;
            localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
            if (localObject1 == null) {
              break label1228;
            }
            paramLinkedList = Long.valueOf(((ayr)localObject1).SJY);
            localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
            if (localObject1 == null) {
              break label1233;
            }
            paramLinkedList = Integer.valueOf(((ayr)localObject1).status);
            localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
            if (localObject1 == null) {
              break label1238;
            }
            paramLinkedList = Integer.valueOf(((ayr)localObject1).SKI);
            localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
            if (localObject1 == null) {
              break label1243;
            }
            paramLinkedList = Integer.valueOf(((ayr)localObject1).result);
            localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
            if (localObject1 == null) {
              break label1248;
            }
            paramLinkedList = ((ayr)localObject1).SKJ;
            if (paramLinkedList == null) {
              break label1248;
            }
            paramLinkedList = Integer.valueOf(paramLinkedList.size());
            Log.i((String)localObject2, paramLinkedList + ']');
            if (localObject1 == null) {
              break label1259;
            }
            Log.i(TAG, "updateTemplateInfo curBattleInfo:" + ((f)parama.business(f.class)).zhz);
            paramLinkedList = ((f)parama.business(f.class)).zhz;
            if (paramLinkedList == null) {
              break label1253;
            }
            if ((paramLinkedList.yey != 3) && (Util.isEqual(paramLinkedList.yeu, ((ayr)localObject1).SKH)))
            {
              if (paramLinkedList.yew - ((ayr)localObject1).SKI >= 3) {
                paramLinkedList.yew = ((ayr)localObject1).SKI;
              }
              paramLinkedList.yex = ((ayr)localObject1).result;
              localObject1 = ((ayr)localObject1).SKJ;
              p.j(localObject1, "battleInfo.player_info");
              paramLinkedList.en((List)localObject1);
            }
            i = j;
            break;
          }
          label1228:
          label1233:
          label1238:
          label1243:
          label1248:
          label1253:
          continue;
          label1259:
          i = j;
          continue;
          localObject1 = (com.tencent.mm.cd.a)new aww();
          paramLinkedList = ((bdb)localObject2).SOn;
          if (paramLinkedList != null) {}
          for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null)
          {
            try
            {
              ((com.tencent.mm.cd.a)localObject1).parseFrom(paramLinkedList);
              paramLinkedList = (LinkedList<bdb>)localObject1;
            }
            catch (Exception paramLinkedList)
            {
              for (;;)
              {
                Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
                paramLinkedList = null;
                continue;
                paramLinkedList = null;
                continue;
                paramLinkedList = null;
              }
            }
            localObject1 = (aww)paramLinkedList;
            localObject2 = TAG;
            localObject3 = new StringBuilder("updateTemplateInfo pageInfo: ");
            if (localObject1 == null) {
              break label1448;
            }
            paramLinkedList = ((aww)localObject1).title;
            localObject3 = ((StringBuilder)localObject3).append(paramLinkedList).append(", ");
            if (localObject1 == null) {
              break label1453;
            }
            paramLinkedList = ((aww)localObject1).wording;
            Log.i((String)localObject2, paramLinkedList);
            if (localObject1 == null) {
              break label280;
            }
            ((e)parama.business(e.class)).zhc = ((aww)localObject1).title;
            ((e)parama.business(e.class)).zhd = ((aww)localObject1).wording;
            i = j;
            break;
          }
        }
      }
    }
    label280:
    label291:
    label296:
    label1448:
    label1453:
    Log.i(TAG, localStringBuilder1.toString());
    label531:
    label536:
    label543:
    label548:
    if (localLinkedList2.size() > 0) {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.g)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.g.class)).c(localLinkedList2, paramBoolean);
    }
    label800:
    if (((Collection)localLinkedList1).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        parama = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
        p.k(localLinkedList1, "liveMsgRedPacketInfoList");
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.b(parama, localLinkedList1, paramBoolean));
      }
      AppMethodBeat.o(289439);
      return;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<bal, Boolean>
  {
    a(bal parambal)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.d
 * JD-Core Version:    0.7.0.1
 */