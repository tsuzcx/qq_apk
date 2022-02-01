package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.d.a.a.a.b.b.g;
import com.tencent.d.a.a.a.b.b.g.a;
import com.tencent.d.a.a.a.b.b.h;
import com.tencent.d.a.a.a.b.b.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.i;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveEventMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends f
{
  public g(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353269);
    AppMethodBeat.o(353269);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(353285);
    s.u(paramLinkedList, "msgList");
    paramLinkedList = (bdm)p.oN((List)paramLinkedList);
    bev localbev = new bev();
    if (paramLinkedList != null)
    {
      if (paramLinkedList.ZNY == null) {
        break label192;
      }
      i = 1;
      if (i == 0) {
        break label197;
      }
      label53:
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.ZNY;
        if (paramLinkedList != null) {
          break label202;
        }
        paramLinkedList = null;
        label68:
        localbev.parseFrom(paramLinkedList);
      }
    }
    paramLinkedList = (n)eji().business(n.class);
    s.u(localbev, "syncEventInfo");
    int i = localbev.mIY;
    Object localObject3 = b.g.ahoC;
    if (i == b.g.a.jWh())
    {
      i = localbev.ZPe;
      localObject3 = b.h.ahoF;
      if (i == b.h.a.jWi())
      {
        localObject1 = localbev.ZPg;
        if (localObject1 != null) {
          d.uiThread((kotlin.g.a.a)new n.h(paramLinkedList, ((dcf)localObject1).Zmx));
        }
        localObject1 = n.TAG;
        paramLinkedList = localbev.ZPg;
        if (paramLinkedList == null) {}
        for (paramLinkedList = (LinkedList<bdm>)localObject2;; paramLinkedList = Long.valueOf(paramLinkedList.Zmx))
        {
          Log.i((String)localObject1, s.X("update torcherCount:", paramLinkedList));
          AppMethodBeat.o(353285);
          return;
          label192:
          i = 0;
          break;
          label197:
          paramLinkedList = null;
          break label53;
          label202:
          paramLinkedList = paramLinkedList.toByteArray();
          break label68;
        }
      }
      localObject2 = b.h.ahoF;
      if (i == b.h.a.jWj())
      {
        localObject2 = localbev.ZPg;
        if (localObject2 != null) {
          d.uiThread((kotlin.g.a.a)new n.i(paramLinkedList, ((dcf)localObject2).Zmx));
        }
        localObject2 = n.TAG;
        paramLinkedList = localbev.ZPg;
        if (paramLinkedList != null) {
          break label298;
        }
      }
    }
    label298:
    for (paramLinkedList = (LinkedList<bdm>)localObject1;; paramLinkedList = Long.valueOf(paramLinkedList.Zmx))
    {
      Log.i((String)localObject2, s.X("update isStart:", paramLinkedList));
      AppMethodBeat.o(353285);
      return;
    }
  }
  
  public final int[] ejj()
  {
    return new int[] { 20061 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.g
 * JD-Core Version:    0.7.0.1
 */