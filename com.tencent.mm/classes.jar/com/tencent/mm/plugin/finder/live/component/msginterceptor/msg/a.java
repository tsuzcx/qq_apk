package com.tencent.mm.plugin.finder.live.component.msginterceptor.msg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.g;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/msg/LiveMsgBulletInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "dealWithMsgListOnEmpty", "", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends g
{
  private final String TAG;
  
  public a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353078);
    this.TAG = "LiveMsgBulletInterceptor";
    AppMethodBeat.o(353078);
  }
  
  public final void ap(LinkedList<bke> paramLinkedList)
  {
    AppMethodBeat.i(353113);
    s.u(paramLinkedList, "msgList");
    ((l)eji().business(l.class)).EgF.clear();
    Object localObject1 = ((l)eji().business(l.class)).EgF;
    Object localObject2 = (Iterable)paramLinkedList;
    paramLinkedList = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramLinkedList.add(new am((bke)((Iterator)localObject2).next()));
    }
    ((List)localObject1).addAll((Collection)paramLinkedList);
    paramLinkedList = aw.Gjk;
    if ((aw.bgV()) && (((l)eji().business(l.class)).EgF.size() > 0))
    {
      paramLinkedList = this.TAG;
      localObject1 = new StringBuilder("handleBulletMsg size:").append(((l)eji().business(l.class)).EgF.size()).append(',');
      localObject2 = ((l)eji().business(l.class)).EgF;
      s.s(localObject2, "liveContext.business(\n  …ss.java).bulletCommetList");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((aq)((Iterator)localObject3).next()).eky());
      }
      Log.i(paramLinkedList, (List)localObject2);
    }
    AppMethodBeat.o(353113);
  }
  
  public final int[] ejj()
  {
    return new int[] { 10012, 10005 };
  }
  
  public final boolean ejk()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.msg.a
 * JD-Core Version:    0.7.0.1
 */