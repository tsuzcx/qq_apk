package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.model.af;
import com.tencent.mm.plugin.finder.live.model.af.c;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveProductReplayUpdateInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends f
{
  final String TAG;
  
  public p(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353251);
    this.TAG = "LiveProductReplayUpdateInterceptor";
    AppMethodBeat.o(353251);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(353271);
    s.u(paramLinkedList, "msgList");
    paramLinkedList = (bdm)kotlin.a.p.oN((List)paramLinkedList);
    if (paramLinkedList != null)
    {
      localObject2 = (com.tencent.mm.bx.a)new diu();
      paramLinkedList = paramLinkedList.ZNY;
      if (paramLinkedList != null) {
        break label184;
      }
    }
    for (paramLinkedList = null;; paramLinkedList = paramLinkedList.toByteArray())
    {
      try
      {
        ((com.tencent.mm.bx.a)localObject2).parseFrom(paramLinkedList);
        paramLinkedList = (LinkedList<bdm>)localObject2;
      }
      catch (Exception paramLinkedList)
      {
        for (;;)
        {
          bxc localbxc;
          label184:
          Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
          paramLinkedList = null;
          continue;
          paramLinkedList = paramLinkedList.hOG;
          continue;
          long l = ((diu)localObject2).DVk;
        }
      }
      localObject2 = (diu)paramLinkedList;
      if (localObject2 != null)
      {
        localbxc = new bxc();
        localbxc.DVk = ((diu)localObject2).DVk;
        paramLinkedList = aj.CGT;
        paramLinkedList = (e)aj.business(e.class);
        if (paramLinkedList != null) {
          break;
        }
        paramLinkedList = localObject1;
        localbxc.ZRn = paramLinkedList;
        paramLinkedList = this.TAG;
        if (localObject2 != null) {
          break label221;
        }
        l = 0L;
        Log.i(paramLinkedList, s.X("start SyncGoods ", Long.valueOf(l)));
        paramLinkedList = aj.CGT;
        aj.elm().a(((diu)localObject2).aaNC, (com.tencent.mm.bx.a)localbxc, (af.c)new a(this, (diu)localObject2, bxd.class));
      }
      AppMethodBeat.o(353271);
      return;
    }
  }
  
  public final int[] ejj()
  {
    return new int[] { 20054 };
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveProductReplayUpdateInterceptor$dealWithMsgList$1$1$1", "Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$PollingEventCallback;", "Lcom/tencent/mm/protocal/protobuf/FinderSyncProductInfoResp;", "onPollingSuccess", "", "result", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends af.c<bxd>
  {
    a(p paramp, diu paramdiu, Class<bxd> paramClass)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      public static final a CBW;
      
      static
      {
        AppMethodBeat.i(353247);
        CBW = new a();
        AppMethodBeat.o(353247);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.p
 * JD-Core Version:    0.7.0.1
 */