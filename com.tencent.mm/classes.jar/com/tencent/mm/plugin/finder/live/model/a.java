package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.viewmodel.g.j;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.aut;>;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.axl;>;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveAppMsgManager;", "", "()V", "TAG", "", "chooseAlertInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsgBoxInfo;", "info1", "info2", "updateAppMsg", "", "roomData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "appMsgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "updateTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTemplateInfo;", "fromJoinLive", "", "plugin-finder_release"})
public final class a
{
  private static final String TAG = "FinderLiveAppMsgManager";
  public static final a uhJ;
  
  static
  {
    AppMethodBeat.i(245996);
    uhJ = new a();
    TAG = "FinderLiveAppMsgManager";
    AppMethodBeat.o(245996);
  }
  
  private static awr a(awr paramawr1, awr paramawr2)
  {
    switch (paramawr1.type)
    {
    }
    do
    {
      do
      {
        return paramawr1;
      } while ((paramawr2.type != 20011) && (paramawr2.type != 20007));
      return paramawr2;
    } while (paramawr2.type != 20007);
    return paramawr2;
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, LinkedList<aut> paramLinkedList)
  {
    AppMethodBeat.i(245993);
    p.h(paramg, "roomData");
    StringBuilder localStringBuilder1 = new StringBuilder("updateAppMsg:");
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
        j.hxH();
      }
      localObject4 = (aut)localObject1;
      localObject3 = new StringBuilder("(").append(i).append(")[msgType:");
      label145:
      boolean bool;
      if (localObject4 != null)
      {
        localObject1 = Integer.valueOf(((aut)localObject4).ybm);
        localObject3 = ((StringBuilder)localObject3).append(((Integer)localObject1).intValue()).append(",payload is empty:");
        if (localObject4 == null) {
          break label323;
        }
        localObject1 = ((aut)localObject4).LFB;
        if (localObject1 != null) {
          break label329;
        }
        bool = true;
        label153:
        localObject3 = ((StringBuilder)localObject3).append(bool).append(",fromUser:");
        if (localObject4 == null) {
          break label335;
        }
        localObject1 = ((aut)localObject4).LFE;
        if (localObject1 == null) {
          break label335;
        }
        localObject1 = ((avn)localObject1).contact;
        if (localObject1 == null) {
          break label335;
        }
        localObject1 = ((FinderContact)localObject1).nickname;
        label203:
        localObject3 = ((StringBuilder)localObject3).append((String)localObject1).append(",toUser:");
        if (localObject4 == null) {
          break label341;
        }
        localObject1 = ((aut)localObject4).LFz;
        if (localObject1 == null) {
          break label341;
        }
        localObject1 = ((avn)localObject1).contact;
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
        switch (((aut)localObject4).ybm)
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
      localObject3 = (com.tencent.mm.bw.a)new ave();
      localObject1 = ((aut)localObject4).LFB;
      if (localObject1 != null) {
        localObject1 = ((com.tencent.mm.bw.b)localObject1).toByteArray();
      }
      try
      {
        ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
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
      localObject1 = (ave)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((ave)localObject1).LFK;
        localObject4 = TAG;
        localStringBuilder2 = new StringBuilder("parseMsgBoxInfo:");
        if (localObject1 != null) {
          break label750;
        }
      }
    }
    label555:
    awr localawr;
    label702:
    label740:
    label750:
    for (Object localObject3 = "";; localObject3 = localawr)
    {
      Log.i((String)localObject4, com.tencent.mm.ac.g.bN(localObject3));
      if (paramLinkedList == null)
      {
        i = j;
        paramLinkedList = (LinkedList<aut>)localObject1;
        break;
        localObject1 = null;
        break label378;
      }
      Object localObject2;
      if (localObject2 != null)
      {
        if (paramLinkedList == null) {
          p.hyc();
        }
        paramLinkedList = a(paramLinkedList, (awr)localObject2);
      }
      for (;;)
      {
        i = j;
        break;
        localObject3 = (com.tencent.mm.bw.a)new auv();
        localObject2 = ((aut)localObject4).LFB;
        if (localObject2 != null) {
          localObject2 = ((com.tencent.mm.bw.b)localObject2).toByteArray();
        }
        try
        {
          ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject2);
          localObject2 = localObject3;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException2 });
            localawr = null;
            continue;
            localawr = null;
          }
        }
        localObject2 = (auv)localObject2;
        if (localObject2 != null)
        {
          localObject2 = ((auv)localObject2).LFK;
          localObject4 = TAG;
          localStringBuilder2 = new StringBuilder("parseMsgBoxInfo:");
          if (localObject2 != null) {
            break label740;
          }
        }
        for (localObject3 = "";; localObject3 = localawr)
        {
          Log.i((String)localObject4, com.tencent.mm.ac.g.bN(localObject3));
          if (paramLinkedList == null)
          {
            i = j;
            paramLinkedList = (LinkedList<aut>)localObject2;
            break;
            localObject2 = null;
            break label555;
          }
          if (localawr == null) {
            break label312;
          }
          if (paramLinkedList == null) {
            p.hyc();
          }
          paramLinkedList = a(paramLinkedList, localawr);
          break label312;
          localawr = null;
          if (localawr != null) {
            d.h((kotlin.g.a.a)new g.j(paramg, localawr));
          }
          Log.i(TAG, localStringBuilder1.toString());
          AppMethodBeat.o(245993);
          return;
        }
      }
    }
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, LinkedList<axl> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(245994);
    p.h(paramg, "roomData");
    StringBuilder localStringBuilder1 = new StringBuilder("updateTemplateInfo(fromJoinLive:" + paramBoolean + "):");
    LinkedList localLinkedList = new LinkedList();
    if (paramLinkedList != null)
    {
      Iterator localIterator = ((Iterable)paramLinkedList).iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        paramLinkedList = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.hxH();
        }
        Object localObject2 = (axl)paramLinkedList;
        Object localObject1 = new StringBuilder("(").append(i).append(")[msgType:");
        label137:
        label164:
        boolean bool;
        if (localObject2 != null)
        {
          paramLinkedList = Integer.valueOf(((axl)localObject2).infoType);
          localObject1 = ((StringBuilder)localObject1).append(paramLinkedList.intValue()).append(",payload is empty:");
          if (localObject2 == null) {
            break label271;
          }
          paramLinkedList = ((axl)localObject2).LHW;
          if (paramLinkedList != null) {
            break label276;
          }
          bool = true;
          label171:
          localObject1 = ((StringBuilder)localObject1).append(bool).append(",versionWording:");
          if (localObject2 == null) {
            break label282;
          }
          paramLinkedList = ((axl)localObject2).LHX;
          label196:
          localStringBuilder1.append(paramLinkedList + ",seq:" + ((axl)localObject2).jlm + "}] ");
          if (localObject2 != null) {
            switch (((axl)localObject2).infoType)
            {
            }
          }
        }
        for (;;)
        {
          i = j;
          break;
          paramLinkedList = null;
          break label137;
          label271:
          paramLinkedList = null;
          break label164;
          label276:
          bool = false;
          break label171;
          label282:
          paramLinkedList = null;
          break label196;
          localObject1 = (com.tencent.mm.bw.a)new awi();
          paramLinkedList = ((axl)localObject2).LHW;
          if (paramLinkedList != null) {}
          for (paramLinkedList = paramLinkedList.toByteArray();; paramLinkedList = null)
          {
            try
            {
              ((com.tencent.mm.bw.a)localObject1).parseFrom(paramLinkedList);
              paramLinkedList = (LinkedList<axl>)localObject1;
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
              if (!d.a(localLinkedList, (kotlin.g.a.b)new a((awi)localObject2))) {
                break label553;
              }
              Log.i(TAG, "updateTemplateInfo remove the last same item id:" + ((awi)localObject2).id + '!');
              localLinkedList.add(localObject2);
              i = j;
            }
            localObject2 = (awi)paramLinkedList;
            if (localObject2 == null) {
              break label484;
            }
            paramLinkedList = ((awi)localObject2).id;
            if ((paramLinkedList == null) || (paramg.atX(paramLinkedList))) {
              break label567;
            }
            paramLinkedList = paramg.uEa;
            if (paramLinkedList == null) {
              break label489;
            }
            paramLinkedList = paramLinkedList.tWe;
            if (paramLinkedList == null) {
              break label489;
            }
            i = paramLinkedList.LHb;
            paramLinkedList = paramg.uEa;
            if (paramLinkedList == null) {
              break label496;
            }
            paramLinkedList = paramLinkedList.tWe;
            if (paramLinkedList == null) {
              break label496;
            }
            paramLinkedList = paramLinkedList.id;
            if ((!p.j(((awi)localObject2).id, paramLinkedList)) || (((awi)localObject2).LHb <= i)) {
              break label501;
            }
            Log.i(TAG, "updateTemplateInfo drop the old time lottteryInfo:" + com.tencent.mm.ac.g.bN(localObject2) + '!');
            i = j;
            break;
          }
          label484:
          label489:
          label496:
          label501:
          break;
          label553:
          label567:
          String str = TAG;
          StringBuilder localStringBuilder2 = new StringBuilder("updateTemplateInfo ");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          Log.e(str, com.tencent.mm.ac.g.bN(localObject1) + " fail," + paramLinkedList + " have show!");
        }
      }
    }
    Log.i(TAG, localStringBuilder1.toString());
    if (localLinkedList.size() > 0) {
      paramg.b(localLinkedList, paramBoolean);
    }
    AppMethodBeat.o(245994);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<awi, Boolean>
  {
    a(awi paramawi)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.a
 * JD-Core Version:    0.7.0.1
 */