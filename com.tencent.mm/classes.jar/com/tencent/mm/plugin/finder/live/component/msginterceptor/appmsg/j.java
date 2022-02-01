package com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.f;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.util.s.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bdm;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlin.m.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveGiftMsgInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveAppMsgInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "trySyncGift", "", "checkFirstLiveReward", "", "roomData", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "checkGiftResourceExist", "id", "dealWithMsgList", "msgList", "Ljava/util/LinkedList;", "filterGiftMsg", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "isMySelfLiveMsg", "scene", "liveMsg", "legalMsgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends f
{
  boolean CBQ;
  final String TAG;
  
  public j(a parama)
  {
    super(parama);
    AppMethodBeat.i(353281);
    this.TAG = "LiveGiftMsgInterceptor";
    AppMethodBeat.o(353281);
  }
  
  public final void ap(LinkedList<bdm> paramLinkedList)
  {
    AppMethodBeat.i(353294);
    kotlin.g.b.s.u(paramLinkedList, "msgList");
    com.tencent.mm.plugin.finder.live.util.s locals = ((e)eji().business(e.class)).Ecl;
    final a locala = eji();
    locals.addAll((Collection)k.e(k.d(k.a(p.A((Iterable)paramLinkedList), (b)new a(this)), (b)new b(this, locala))));
    AppMethodBeat.o(353294);
  }
  
  public final int[] ejj()
  {
    return new int[] { 20009 };
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<bdm, Boolean>
  {
    a(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<bdm, s.b>
  {
    b(j paramj, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.j
 * JD-Core Version:    0.7.0.1
 */