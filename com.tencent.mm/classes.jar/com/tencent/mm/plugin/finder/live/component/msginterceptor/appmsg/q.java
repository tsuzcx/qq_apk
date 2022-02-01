package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LivePromoteInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.f
{
  private final String TAG;
  
  public q(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353268);
    this.TAG = "LivePromoteInfoInterceptor";
    AppMethodBeat.o(353268);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(353284);
    s.u(paramLinkedList, "msgList");
    paramLinkedList = (bdm)p.oN((List)paramLinkedList);
    Object localObject2 = new bla();
    int i;
    if (paramLinkedList != null)
    {
      if (paramLinkedList.ZNY == null) {
        break label226;
      }
      i = 1;
      if (i == 0) {
        break label231;
      }
      label50:
      if (paramLinkedList != null)
      {
        paramLinkedList = paramLinkedList.ZNY;
        if (paramLinkedList != null) {
          break label236;
        }
        paramLinkedList = null;
        label65:
        ((bla)localObject2).parseFrom(paramLinkedList);
      }
    }
    Log.i(this.TAG, s.X("recive promote msg: ", com.tencent.mm.ae.f.dg(localObject2)));
    if ((((bla)localObject2).cancel == 1) || ((((bla)localObject2).ZTU != null) && (((bla)localObject2).cancel == 0)))
    {
      i = 1;
      label116:
      if (i == 0) {
        break label249;
      }
      paramLinkedList = (LinkedList<bdm>)localObject2;
      label123:
      if (paramLinkedList == null) {
        break label298;
      }
      paramLinkedList = aj.CGT;
      paramLinkedList = aj.getLiveCore();
      if (paramLinkedList == null) {
        break label254;
      }
      paramLinkedList = paramLinkedList.mRB;
      if ((paramLinkedList == null) || (paramLinkedList.bep() != true)) {
        break label254;
      }
      i = 1;
      label158:
      if (i == 0) {
        break label266;
      }
      paramLinkedList = aj.CGT;
      localObject1 = aj.elk();
      if (localObject1 == null) {
        break label298;
      }
      if (((bla)localObject2).cancel != 1) {
        break label259;
      }
    }
    Object localObject3;
    label259:
    for (paramLinkedList = b.c.ndQ;; paramLinkedList = b.c.ndO)
    {
      localObject3 = new Bundle();
      ((Bundle)localObject3).putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((bla)localObject2).toByteArray());
      localObject2 = ah.aiuX;
      ((com.tencent.mm.plugin.finder.live.view.a)localObject1).statusChange(paramLinkedList, (Bundle)localObject3);
      AppMethodBeat.o(353284);
      return;
      label226:
      i = 0;
      break;
      label231:
      paramLinkedList = null;
      break label50;
      label236:
      paramLinkedList = paramLinkedList.toByteArray();
      break label65;
      i = 0;
      break label116;
      label249:
      paramLinkedList = null;
      break label123;
      label254:
      i = 0;
      break label158;
    }
    label266:
    if (((bla)localObject2).cancel == 1)
    {
      paramLinkedList = aj.CGT;
      paramLinkedList = aj.elk();
      if (paramLinkedList == null)
      {
        paramLinkedList = null;
        if (paramLinkedList == null) {}
      }
    }
    label417:
    label419:
    for (;;)
    {
      paramLinkedList.d((cc)localObject1);
      for (;;)
      {
        label298:
        AppMethodBeat.o(353284);
        return;
        paramLinkedList = paramLinkedList.getBuContext();
        if (paramLinkedList == null)
        {
          paramLinkedList = null;
          break;
        }
        paramLinkedList = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramLinkedList.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
        break;
        paramLinkedList = aj.CGT;
        paramLinkedList = aj.elk();
        if (paramLinkedList == null) {
          paramLinkedList = null;
        }
        for (;;)
        {
          if (paramLinkedList == null) {
            break label417;
          }
          localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          localObject2 = ((bla)localObject2).toByteArray();
          s.s(localObject2, "info.toByteArray()");
          localObject2 = com.tencent.mm.plugin.finder.live.utils.a.bU((byte[])localObject2);
          if (!(localObject2 instanceof cc)) {
            break label419;
          }
          localObject1 = (cc)localObject2;
          break;
          paramLinkedList = paramLinkedList.getBuContext();
          if (paramLinkedList == null) {
            paramLinkedList = null;
          } else {
            paramLinkedList = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramLinkedList.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
          }
        }
      }
    }
  }
  
  public final int[] ejj()
  {
    return new int[] { 20051 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.q
 * JD-Core Version:    0.7.0.1
 */