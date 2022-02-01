package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.protocal.protobuf.bdm;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveApplaudInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends f
{
  public d(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353309);
    AppMethodBeat.o(353309);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353320);
    s.u(paramLinkedList, "msgList");
    paramLinkedList = aj.CGT;
    paramLinkedList = aj.elk();
    if (paramLinkedList != null) {
      b.b.a((b)paramLinkedList, b.c.nes);
    }
    paramLinkedList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramLinkedList = aj.CGT;
      paramLinkedList = aj.elk();
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.getContext();
        if (paramLinkedList != null)
        {
          com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          com.tencent.mm.plugin.finder.live.utils.a.gF(paramLinkedList);
        }
      }
    }
    AppMethodBeat.o(353320);
  }
  
  public final int[] ejj()
  {
    return new int[] { 20041 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.d
 * JD-Core Version:    0.7.0.1
 */