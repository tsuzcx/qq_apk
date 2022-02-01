package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.model.g;
import com.tencent.mm.live.model.p;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgCheckCloseInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "()V", "TAG", "", "checkLiveClose", "", "curLiveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "intercept", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.e
{
  private final String TAG = "LiveMsgCheckCloseInterceptor";
  
  public final boolean a(a.a parama)
  {
    AppMethodBeat.i(353220);
    s.u(parama, "respWrapper");
    Object localObject = parama.CBm;
    if (localObject == null)
    {
      parama = null;
      if (parama == null)
      {
        AppMethodBeat.o(353220);
        return false;
      }
    }
    else
    {
      parama = aj.CGT;
      parama = aj.elr();
      int i;
      if (parama == null)
      {
        Log.w(this.TAG, "checkLiveClose return by curLiveData == null");
        i = 0;
        if (i != 0) {
          break label182;
        }
      }
      label182:
      for (bool = true;; bool = false)
      {
        parama = Boolean.valueOf(bool);
        break;
        if (((azp)localObject).ZJP == 1) {}
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            Log.i(this.TAG, "get live msg close live!");
            ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).sk(true);
            localObject = aj.CGT;
            localObject = aj.getLiveCore();
            if (localObject != null) {
              ((com.tencent.mm.live.core.core.trtc.a)localObject).ta(4);
            }
            localObject = p.mZf;
            localObject = p.bhS();
            if (localObject != null) {
              ((g)localObject).onCloseLive(new com.tencent.mm.live.model.e(((f)parama.business(f.class)).liveInfo.liveId));
            }
          }
          break;
        }
      }
    }
    boolean bool = parama.booleanValue();
    AppMethodBeat.o(353220);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.a
 * JD-Core Version:    0.7.0.1
 */