package com.tencent.mm.plugin.finder.live.component.msginterceptor.msg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.g;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.k;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/msg/LiveMsgCommentBanInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "legalMsgType", "", "updateLiveMsgCommentState", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends g
{
  public b(a parama)
  {
    super(parama);
    AppMethodBeat.i(353099);
    AppMethodBeat.o(353099);
  }
  
  public final void ap(LinkedList<bke> paramLinkedList)
  {
    AppMethodBeat.i(353125);
    s.u(paramLinkedList, "msgList");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    if (paramLinkedList.hasNext())
    {
      bke localbke = (bke)paramLinkedList.next();
      switch (localbke.type)
      {
      }
      for (;;)
      {
        break;
        i = localbke.type;
        ((e)eji().business(e.class)).Ecs = true;
        break;
        i = localbke.type;
        ((e)eji().business(e.class)).Ecs = false;
      }
    }
    if (i == 10007) {
      ((k)h.ax(k.class)).bUG();
    }
    Log.i("MMFinder.LiveMsgSlice", s.X("updateLiveMsg commentType:", Integer.valueOf(i)));
    AppMethodBeat.o(353125);
  }
  
  public final int[] ejj()
  {
    return new int[] { 10008, 10007 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.msg.b
 * JD-Core Version:    0.7.0.1
 */