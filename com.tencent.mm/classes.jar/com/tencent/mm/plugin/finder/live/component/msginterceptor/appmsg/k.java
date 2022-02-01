package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.l;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveHighLightCheerAppMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "dealWithMsgListOnEmpty", "", "extraFilter", "appMsg", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends f
{
  private final String TAG;
  
  public k(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353279);
    this.TAG = "LiveHighLightCheerAppMsgInterceptor";
    AppMethodBeat.o(353279);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353299);
    s.u(paramLinkedList, "msgList");
    ((l)eji().business(l.class)).EgH.clear();
    ((l)eji().business(l.class)).EgH.addAll((Collection)paramLinkedList);
    Log.i(this.TAG, s.X("handleHighLightCheerMsg roomData.business(LiveCommonSlice::class.java).highLightCheerList:", Integer.valueOf(((l)eji().business(l.class)).EgH.size())));
    AppMethodBeat.o(353299);
  }
  
  public final boolean b(bdm parambdm)
  {
    Object localObject1 = null;
    AppMethodBeat.i(353292);
    s.u(parambdm, "appMsg");
    Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    parambdm = parambdm.ZOb;
    if (parambdm == null) {
      parambdm = localObject1;
    }
    while (!com.tencent.mm.plugin.finder.live.utils.a.axR(parambdm))
    {
      AppMethodBeat.o(353292);
      return true;
      localObject2 = parambdm.contact;
      parambdm = localObject1;
      if (localObject2 != null) {
        parambdm = ((FinderContact)localObject2).username;
      }
    }
    AppMethodBeat.o(353292);
    return false;
  }
  
  public final int[] ejj()
  {
    return new int[] { 20006 };
  }
  
  public final boolean ejk()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.k
 * JD-Core Version:    0.7.0.1
 */