package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.model.ab;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveGameJumpMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends f
{
  public h(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353280);
    AppMethodBeat.o(353280);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353295);
    s.u(paramLinkedList, "msgList");
    paramLinkedList = (bdm)p.oN((List)paramLinkedList);
    Object localObject;
    com.tencent.mm.plugin.finder.live.model.context.a locala;
    if (paramLinkedList != null)
    {
      localObject = ab.CGy;
      locala = eji();
      localObject = (com.tencent.mm.bx.a)new cbs();
      paramLinkedList = paramLinkedList.ZNY;
      if (paramLinkedList != null) {
        break label79;
      }
    }
    for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramLinkedList);
        paramLinkedList = (LinkedList<bdm>)localObject;
      }
      catch (Exception paramLinkedList)
      {
        for (;;)
        {
          label79:
          Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
          paramLinkedList = null;
        }
      }
      ab.a(locala, (cbs)paramLinkedList);
      AppMethodBeat.o(353295);
      return;
    }
  }
  
  public final int[] ejj()
  {
    return new int[] { 20040 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.h
 * JD-Core Version:    0.7.0.1
 */