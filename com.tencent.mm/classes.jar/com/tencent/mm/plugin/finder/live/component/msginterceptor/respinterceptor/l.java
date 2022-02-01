package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.m;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgRespSpeedInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "intercept", "", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends e
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  
  public l(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(353201);
    this.CBK = parama;
    AppMethodBeat.o(353201);
  }
  
  public final boolean a(a.a parama)
  {
    AppMethodBeat.i(353219);
    s.u(parama, "respWrapper");
    azp localazp = parama.CBm;
    Object localObject2;
    boolean bool1;
    label101:
    Object localObject1;
    if (localazp != null)
    {
      localObject2 = new StringBuilder("isHistory:").append(localazp.ZKd).append(", getConfig:");
      parama = localazp.ZKc;
      if (parama != null) {
        break label275;
      }
      parama = "";
      Log.i("LiveMsgRespSpeedInterceptor", parama + ",msgsize:" + localazp.PmC.size());
      parama = localazp.ZKc;
      if (parama != null) {
        break label295;
      }
      bool1 = true;
      localObject1 = (m)this.CBK.business(m.class);
      parama = localazp.ZKc;
      localObject2 = d.FAy;
      if ((!((Boolean)d.eXw().bmg()).booleanValue()) && (parama != null)) {
        break label328;
      }
      parama = ((m)localObject1).EgS;
      label151:
      if (parama != null)
      {
        if (!m.b(parama)) {
          break label331;
        }
        label162:
        if (parama != null)
        {
          if (!m.a(parama, ((m)localObject1).EgR)) {
            ((m)localObject1).EgR = parama;
          }
          parama = ah.aiuX;
        }
      }
      parama = (m)this.CBK.business(m.class);
      localObject1 = localazp.PmC;
      s.s(localObject1, "it.msgList");
      localObject2 = localazp.ZJV;
      s.s(localObject2, "it.app_msg_list");
      if (localazp.ZKd != 1) {
        break label336;
      }
    }
    label275:
    label295:
    label328:
    label331:
    label336:
    for (boolean bool2 = true;; bool2 = false)
    {
      parama.a((LinkedList)localObject1, (LinkedList)localObject2, bool2);
      if (!bool1) {
        ((m)this.CBK.business(m.class)).ezh();
      }
      AppMethodBeat.o(353219);
      return true;
      localObject1 = f.dh(parama);
      parama = (a.a)localObject1;
      if (localObject1 != null) {
        break;
      }
      parama = "";
      break;
      localObject1 = (m)this.CBK.business(m.class);
      s.u(parama, "other");
      bool1 = m.a(parama, ((m)localObject1).EgR);
      break label101;
      break label151;
      parama = null;
      break label162;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.l
 * JD-Core Version:    0.7.0.1
 */