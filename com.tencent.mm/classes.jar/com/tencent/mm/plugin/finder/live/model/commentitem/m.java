package com.tencent.mm.plugin.finder.live.model.commentitem;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.protocal.protobuf.bdm;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemLiveDesc;", "Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemAnnoucement;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "genIFinderLiveMsg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends b
{
  public m(a parama)
  {
    super(parama);
    AppMethodBeat.i(359883);
    AppMethodBeat.o(359883);
  }
  
  public final aq a(bdm parambdm)
  {
    AppMethodBeat.i(359894);
    s.u(parambdm, "msg");
    parambdm = (aq)new com.tencent.mm.plugin.finder.live.model.m(parambdm);
    AppMethodBeat.o(359894);
    return parambdm;
  }
  
  public final int eiV()
  {
    return 20036;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.m
 * JD-Core Version:    0.7.0.1
 */