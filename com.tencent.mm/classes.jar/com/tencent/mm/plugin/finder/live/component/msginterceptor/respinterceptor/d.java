package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgQosReportInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "checkQosReport", "", "curLiveData", "intercept", "", "resp", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.e
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final String TAG;
  
  public d(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(353177);
    this.CBK = parama;
    this.TAG = "LiveMsgQosReportIntercetor";
    AppMethodBeat.o(353177);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a parama)
  {
    AppMethodBeat.i(353192);
    s.u(parama, "resp");
    parama = this.CBK;
    Object localObject1 = aj.CGT;
    Object localObject2;
    if ((aj.bUB()) && (parama != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EdD))
    {
      localObject1 = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().key();
      localObject2 = aj.CGT;
      parama = ((f)parama.business(f.class)).liveInfo.ZRP;
      if (parama != null) {
        break label158;
      }
    }
    label158:
    for (parama = null;; parama = parama.ZSX)
    {
      aj.a(parama);
      parama = com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().key();
      if (!Util.isEqual((String)localObject1, parama))
      {
        localObject2 = aj.CGT;
        localObject2 = aj.getLiveCore();
        if (localObject2 != null) {
          ((com.tencent.mm.live.core.core.trtc.a)localObject2).bfa();
        }
      }
      Log.i(this.TAG, "check update sdk param while heartbeating, beforeKey:" + localObject1 + " afterKey:" + parama);
      AppMethodBeat.o(353192);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.d
 * JD-Core Version:    0.7.0.1
 */