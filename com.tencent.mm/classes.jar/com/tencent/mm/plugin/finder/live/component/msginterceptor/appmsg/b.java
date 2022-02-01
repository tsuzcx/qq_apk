package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bdw;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveAnchorCanApplaudInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f
{
  public b(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353305);
    AppMethodBeat.o(353305);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353315);
    s.u(paramLinkedList, "msgList");
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      AppMethodBeat.o(353315);
      return;
    }
    paramLinkedList = (bdm)p.oL((List)paramLinkedList);
    localObject = new bdw();
    int i;
    if (paramLinkedList != null)
    {
      if (paramLinkedList.ZNY == null) {
        break label120;
      }
      i = 1;
      if (i == 0) {
        break label125;
      }
      label63:
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.ZNY;
        if (paramLinkedList != null) {
          break label130;
        }
      }
    }
    label130:
    for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
    {
      ((bdw)localObject).parseFrom(paramLinkedList);
      if (((bdw)localObject).ZOB == 2)
      {
        paramLinkedList = aj.CGT;
        paramLinkedList = aj.elk();
        if (paramLinkedList != null) {
          b.b.a((com.tencent.mm.live.b.b)paramLinkedList, b.c.neu);
        }
      }
      AppMethodBeat.o(353315);
      return;
      label120:
      i = 0;
      break;
      label125:
      paramLinkedList = null;
      break label63;
    }
  }
  
  public final int[] ejj()
  {
    return new int[] { 20045 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.b
 * JD-Core Version:    0.7.0.1
 */