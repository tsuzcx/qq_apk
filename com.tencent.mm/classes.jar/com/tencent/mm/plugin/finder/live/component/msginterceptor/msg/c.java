package com.tencent.mm.plugin.finder.live.component.msginterceptor.msg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.g;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.protocal.protobuf.bke;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/msg/LiveTopMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "dealWithMsgListOnEmpty", "", "extraFilter", "appMsg", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends g
{
  public c(a parama)
  {
    super(parama);
    AppMethodBeat.i(353079);
    AppMethodBeat.o(353079);
  }
  
  public final void ap(LinkedList<bke> paramLinkedList)
  {
    AppMethodBeat.i(353114);
    s.u(paramLinkedList, "msgList");
    ((l)eji().business(l.class)).EgG.clear();
    ((l)eji().business(l.class)).EgG.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(353114);
  }
  
  public final boolean b(bke parambke)
  {
    AppMethodBeat.i(353102);
    s.u(parambke, "appMsg");
    if (!((e)eji().business(e.class)).EdZ.contains(parambke.ZTp))
    {
      AppMethodBeat.o(353102);
      return true;
    }
    AppMethodBeat.o(353102);
    return false;
  }
  
  public final int[] ejj()
  {
    return new int[] { 10017 };
  }
  
  public final boolean ejk()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.msg.c
 * JD-Core Version:    0.7.0.1
 */