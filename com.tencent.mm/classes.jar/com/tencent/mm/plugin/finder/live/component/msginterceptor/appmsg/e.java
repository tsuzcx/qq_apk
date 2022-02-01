package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bey;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.bdm;>;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveCheerInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "dealWithMsgList", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.f
{
  public e(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353308);
    AppMethodBeat.o(353308);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    String str = null;
    AppMethodBeat.i(353323);
    s.u(paramLinkedList, "msgList");
    Object localObject1 = aj.CGT;
    com.tencent.mm.plugin.finder.live.viewmodel.data.business.e locale = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
    Object localObject2;
    if (locale != null)
    {
      s.u(paramLinkedList, "remoteLiveAppMsg");
      localObject2 = ((Iterable)paramLinkedList).iterator();
      if (((Iterator)localObject2).hasNext()) {
        break label212;
      }
      paramLinkedList = null;
    }
    for (;;)
    {
      paramLinkedList = (bdm)paramLinkedList;
      if (paramLinkedList != null)
      {
        localObject2 = paramLinkedList.ZNY;
        if (localObject2 != null)
        {
          Log.i(locale.TAG, s.X("localCheerInfo:", locale.EdA));
          if (locale.EdA.EeR == 0)
          {
            localObject1 = new bey();
            paramLinkedList = (com.tencent.mm.bx.a)localObject1;
            localObject2 = ((b)localObject2).toByteArray();
          }
        }
      }
      try
      {
        paramLinkedList.parseFrom((byte[])localObject2);
        Log.i(locale.TAG, s.X("remoteCheerInfo:", com.tencent.mm.ae.f.dg(localObject1)));
        paramLinkedList = ((bey)localObject1).ZMZ;
        if (paramLinkedList == null)
        {
          paramLinkedList = null;
          localObject2 = ((bey)localObject1).ZMZ;
          if (localObject2 != null) {
            break label313;
          }
          localObject1 = ((bey)localObject1).ZMZ;
          if (localObject1 != null) {
            break label323;
          }
          i = 0;
          locale.a(paramLinkedList, str, i);
          AppMethodBeat.o(353323);
          return;
          label212:
          paramLinkedList = ((Iterator)localObject2).next();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          long l1 = ((bdm)paramLinkedList).seq;
          localObject1 = ((Iterator)localObject2).next();
          long l2 = ((bdm)localObject1).seq;
          if (l1 >= l2) {
            break label335;
          }
          l1 = l2;
          paramLinkedList = (LinkedList<bdm>)localObject1;
          if (((Iterator)localObject2).hasNext()) {
            break label332;
          }
        }
      }
      catch (Exception paramLinkedList)
      {
        label313:
        label323:
        label332:
        label335:
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramLinkedList });
          continue;
          paramLinkedList = paramLinkedList.ZNH;
          continue;
          str = ((bfz)localObject2).ZPK;
          continue;
          int i = ((bfz)localObject1).lTH;
          continue;
        }
      }
    }
  }
  
  public final int[] ejj()
  {
    return new int[] { 20038 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.e
 * JD-Core Version:    0.7.0.1
 */