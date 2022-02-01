package com.tencent.mm.plugin.finder.live.component.msginterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.e;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.g;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.i;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.l;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.m;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bke;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveMsgRespChain;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/IBusiness;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "liveContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "commentMsgInterceptor", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveCommentMsgInterceptor;", "getCommentMsgInterceptor", "()Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveCommentMsgInterceptor;", "commentMsgInterceptor$delegate", "Lkotlin/Lazy;", "respChain", "", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IFinderLiveMsgRespInterceptor;", "getRespChain", "()Ljava/util/List;", "dealWithCommentMsg", "", "msgList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "appMsgList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "dealWithResp", "", "cgiResp", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends com.tencent.mm.plugin.finder.live.viewmodel.data.business.c<com.tencent.mm.plugin.finder.live.model.context.a>
{
  private final kotlin.j CBH;
  private final List<h> CBI;
  
  public d(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(353167);
    this.CBH = kotlin.k.cm((kotlin.g.a.a)new a(parama));
    this.CBI = p.listOf(new h[] { (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.precheck.a(), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.precheck.c(parama), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.precheck.b(), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.k(parama), (h)new g(parama), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.f(), (h)new i(), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.h(parama), (h)new m(parama), (h)new l(parama), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.j(parama), (h)new e(parama), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.f(parama), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.c(), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.a(), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.d(parama), (h)new com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.b(parama) });
    AppMethodBeat.o(353167);
  }
  
  public boolean a(a parama)
  {
    AppMethodBeat.i(353185);
    s.u(parama, "cgiResp");
    boolean bool1 = false;
    Iterator localIterator = ejh().iterator();
    while (localIterator.hasNext())
    {
      boolean bool2 = ((h)localIterator.next()).b(parama);
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(353185);
    return bool1;
  }
  
  public final void e(LinkedList<bke> paramLinkedList, LinkedList<bdm> paramLinkedList1)
  {
    AppMethodBeat.i(353176);
    s.u(paramLinkedList, "msgList");
    s.u(paramLinkedList1, "appMsgList");
    com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.f localf = (com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.f)this.CBH.getValue();
    azp localazp = new azp();
    localazp.PmC = paramLinkedList;
    localazp.ZJV = paramLinkedList1;
    paramLinkedList = ah.aiuX;
    localf.a(new a.a(localazp));
    AppMethodBeat.o(353176);
  }
  
  public List<h> ejh()
  {
    return this.CBI;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/appmsg/LiveCommentMsgInterceptor;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.live.component.msginterceptor.appmsg.f>
  {
    a(com.tencent.mm.plugin.finder.live.model.context.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.d
 * JD-Core Version:    0.7.0.1
 */