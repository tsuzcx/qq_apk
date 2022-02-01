package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveGameTeamMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "handleGameTeamMsg", "roomData", "remoteLiveAppMsg", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends f
{
  private final String TAG;
  
  public i(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353277);
    this.TAG = "LiveGameTeamMsgInterceptor";
    AppMethodBeat.o(353277);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    Object localObject4 = null;
    AppMethodBeat.i(353304);
    s.u(paramLinkedList, "msgList");
    com.tencent.mm.plugin.finder.live.model.context.a locala = eji();
    Object localObject1 = (List)paramLinkedList;
    localObject3 = ((List)localObject1).listIterator(((List)localObject1).size());
    label77:
    label81:
    Object localObject6;
    if (((ListIterator)localObject3).hasPrevious())
    {
      localObject1 = ((ListIterator)localObject3).previous();
      if (((bdm)localObject1).msg_type == 20023)
      {
        i = 1;
        if (i == 0) {
          break label1051;
        }
        localObject6 = (bdm)localObject1;
        if (localObject6 != null)
        {
          localObject3 = (com.tencent.mm.bx.a)new beg();
          localObject1 = ((bdm)localObject6).ZNY;
          if (localObject1 != null) {
            break label1059;
          }
        }
      }
    }
    for (localObject1 = null;; localObject1 = ((b)localObject1).toByteArray())
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject5;
          label1051:
          label1059:
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          localObject2 = null;
          continue;
          localObject2 = Integer.valueOf(((beg)localObject5).ZOK);
          continue;
          localObject2 = Integer.valueOf(((beg)localObject5).ZOL);
          continue;
          localObject2 = ((beg)localObject5).title;
          continue;
          localObject2 = ((beg)localObject5).ZOJ;
          continue;
          localObject2 = ((beg)localObject5).ZOI;
          continue;
          boolean bool = false;
          continue;
          localObject2 = ((bhf)localObject2).ZQG;
          continue;
          continue;
          i = ((cbp)localObject3).aakY;
          continue;
          localObject3 = ((cbp)localObject3).ZUh;
          continue;
          i = ((cbp)localObject3).aakR;
          continue;
          i = ((cbp)localObject3).aakT;
          continue;
          i = 0;
          continue;
          paramLinkedList = null;
          continue;
          paramLinkedList = paramLinkedList.toByteArray();
        }
      }
      localObject5 = (beg)localObject1;
      localObject3 = this.TAG;
      localObject6 = new StringBuilder("gameteam lastMsg, seq:").append(((bdm)localObject6).seq).append(", gameLiveTeamUpInfo in_team_up:");
      if (localObject5 != null) {
        break label1094;
      }
      localObject1 = null;
      localObject6 = ((StringBuilder)localObject6).append(localObject1).append(", is_team_full:");
      if (localObject5 != null) {
        break label1107;
      }
      localObject1 = null;
      localObject6 = ((StringBuilder)localObject6).append(localObject1).append(", title:");
      if (localObject5 != null) {
        break label1120;
      }
      localObject1 = null;
      localObject6 = ((StringBuilder)localObject6).append(localObject1).append(", rank:");
      if (localObject5 != null) {
        break label1130;
      }
      localObject1 = null;
      localObject6 = ((StringBuilder)localObject6).append(localObject1).append(", member:");
      if (localObject5 != null) {
        break label1140;
      }
      localObject1 = null;
      Log.i((String)localObject3, localObject1);
      if (localObject5 != null)
      {
        if (((e)locala.business(e.class)).Edg == null)
        {
          ((e)locala.business(e.class)).b(new bhf());
          localObject1 = ((e)locala.business(e.class)).Edg;
          if (localObject1 != null) {
            ((bhf)localObject1).ZQE = "";
          }
        }
        localObject6 = ((e)locala.business(e.class)).Edg;
        if (localObject6 != null)
        {
          localObject3 = ((beg)localObject5).title;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          ((bhf)localObject6).title = ((String)localObject1);
        }
        localObject6 = ((e)locala.business(e.class)).Edg;
        if (localObject6 != null)
        {
          localObject3 = ((beg)localObject5).ZOJ;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          ((bhf)localObject6).ZOJ = ((String)localObject1);
        }
        localObject6 = ((e)locala.business(e.class)).Edg;
        if (localObject6 != null)
        {
          localObject3 = ((beg)localObject5).ZOI;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          ((bhf)localObject6).ZQD = ((String)localObject1);
        }
        localObject1 = ((e)locala.business(e.class)).Edg;
        if (localObject1 != null) {
          ((bhf)localObject1).ZOK = ((beg)localObject5).ZOK;
        }
        localObject1 = (e)locala.business(e.class);
        if (((beg)localObject5).ZOL != 1) {
          break label1150;
        }
        bool = true;
        ((e)localObject1).Edi = bool;
        localObject1 = ((e)locala.business(e.class)).Edg;
        if (localObject1 != null) {
          ((bhf)localObject1).Edd = ((beg)localObject5).Edd;
        }
        localObject6 = ((e)locala.business(e.class)).Edg;
        if (localObject6 != null)
        {
          localObject3 = ((beg)localObject5).Ede;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          ((bhf)localObject6).Ede = ((String)localObject1);
        }
        localObject1 = ((e)locala.business(e.class)).Edg;
        if (localObject1 != null) {
          break label1155;
        }
        localObject1 = null;
        if (localObject1 != null) {
          break label1165;
        }
        localObject1 = new cbo();
        localObject3 = ((beg)localObject5).ZOM;
        if (localObject3 != null) {
          break label1168;
        }
        i = 0;
        ((cbo)localObject1).aakX = i;
        localObject3 = ((beg)localObject5).ZOM;
        if (localObject3 != null) {
          break label1177;
        }
        localObject3 = null;
        ((cbo)localObject1).ZUh = ((String)localObject3);
        localObject3 = ((beg)localObject5).ZOM;
        if (localObject3 != null) {
          break label1187;
        }
        i = 0;
        ((cbo)localObject1).aakR = i;
        localObject3 = ((beg)localObject5).ZOM;
        if (localObject3 != null) {
          break label1196;
        }
        i = 0;
        ((cbo)localObject1).aakT = i;
        localObject3 = ((e)locala.business(e.class)).Edg;
        if (localObject3 != null) {
          ((bhf)localObject3).ZQG = ((cbo)localObject1);
        }
        ((e)locala.business(e.class)).Edh = true;
      }
      paramLinkedList = (List)paramLinkedList;
      localObject1 = paramLinkedList.listIterator(paramLinkedList.size());
      do
      {
        if (!((ListIterator)localObject1).hasPrevious()) {
          break label1210;
        }
        paramLinkedList = ((ListIterator)localObject1).previous();
        if (((bdm)paramLinkedList).msg_type != 20033) {
          break;
        }
        i = 1;
      } while (i == 0);
      localObject3 = (bdm)paramLinkedList;
      if (localObject3 != null)
      {
        localObject1 = (com.tencent.mm.bx.a)new bee();
        paramLinkedList = ((bdm)localObject3).ZNY;
        if (paramLinkedList != null) {
          break label1215;
        }
        paramLinkedList = null;
      }
      try
      {
        ((com.tencent.mm.bx.a)localObject1).parseFrom(paramLinkedList);
        paramLinkedList = (LinkedList<bdm>)localObject1;
      }
      catch (Exception paramLinkedList)
      {
        for (;;)
        {
          Object localObject2;
          Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
          paramLinkedList = null;
          continue;
          paramLinkedList = ((bee)localObject2).AzS;
          continue;
          paramLinkedList = ((bee)localObject2).title;
          continue;
          paramLinkedList = ((bee)localObject2).wsz;
          continue;
          paramLinkedList = ((bee)localObject2).wording;
        }
      }
      localObject1 = (bee)paramLinkedList;
      localObject5 = this.TAG;
      localObject6 = new StringBuilder("gameInvite lastMsg, seq:").append(((bdm)localObject3).seq).append(", gameLiveInviteInfo  invitation_id:");
      if (localObject1 != null) {
        break label1245;
      }
      paramLinkedList = null;
      localObject6 = ((StringBuilder)localObject6).append(paramLinkedList).append(", title:");
      if (localObject1 != null) {
        break label1254;
      }
      paramLinkedList = null;
      localObject6 = ((StringBuilder)localObject6).append(paramLinkedList).append(", sub_title:");
      if (localObject1 != null) {
        break label1263;
      }
      paramLinkedList = null;
      localObject6 = ((StringBuilder)localObject6).append(paramLinkedList).append(", wording:");
      if (localObject1 != null) {
        break label1272;
      }
      paramLinkedList = localObject4;
      Log.i((String)localObject5, paramLinkedList);
      if (localObject1 != null)
      {
        ((e)locala.business(e.class)).Edk = ((bee)localObject1);
        ((e)locala.business(e.class)).Edl = ((bdm)localObject3).seq;
      }
      AppMethodBeat.o(353304);
      return;
      i = 0;
      break label77;
      break;
      localObject1 = null;
      break label81;
    }
  }
  
  public final int[] ejj()
  {
    return new int[] { 20023, 20033 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.i
 * JD-Core Version:    0.7.0.1
 */