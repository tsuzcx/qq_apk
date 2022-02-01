package com.tencent.mm.plugin.finder.live.model.commentitem;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.protocal.protobuf.bke;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemSys;", "Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemSysInfo;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "genIFinderLiveMsg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "msgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends w
{
  public v(a parama)
  {
    super(parama);
    AppMethodBeat.i(359877);
    AppMethodBeat.o(359877);
  }
  
  public final aq a(bke parambke)
  {
    AppMethodBeat.i(359885);
    s.u(parambke, "msg");
    parambke = (aq)new am(parambke);
    AppMethodBeat.o(359885);
    return parambke;
  }
  
  public final int eiV()
  {
    return 10001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.v
 * JD-Core Version:    0.7.0.1
 */