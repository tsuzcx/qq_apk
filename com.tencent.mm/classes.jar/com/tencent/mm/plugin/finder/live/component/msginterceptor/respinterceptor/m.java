package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.protocal.protobuf.azp;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgTemplateInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "handleTemplateInfo", "", "appMsgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTemplateInfo;", "intercept", "", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.e
{
  private final a CBK;
  private final String TAG;
  
  public m(a parama)
  {
    AppMethodBeat.i(353174);
    this.CBK = parama;
    this.TAG = "LiveMsgTemplateInfoInterceptor";
    AppMethodBeat.o(353174);
  }
  
  public final boolean a(a.a parama)
  {
    AppMethodBeat.i(353181);
    s.u(parama, "respWrapper");
    parama = parama.CBm;
    if (parama == null) {}
    for (parama = null;; parama = parama.ZJW)
    {
      com.tencent.mm.plugin.finder.live.model.e locale = com.tencent.mm.plugin.finder.live.model.e.CEd;
      com.tencent.mm.plugin.finder.live.model.e.a(this.CBK, parama);
      AppMethodBeat.o(353181);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.m
 * JD-Core Version:    0.7.0.1
 */