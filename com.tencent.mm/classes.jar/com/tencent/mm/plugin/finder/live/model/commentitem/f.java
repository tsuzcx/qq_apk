package com.tencent.mm.plugin.finder.live.model.commentitem;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.protocal.protobuf.bke;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemBanComment;", "Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemSysInfo;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "genIFinderLiveMsg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "msgType", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends w
{
  public f(a parama)
  {
    super(parama);
    AppMethodBeat.i(359929);
    AppMethodBeat.o(359929);
  }
  
  public final aq a(bke parambke)
  {
    AppMethodBeat.i(359939);
    s.u(parambke, "msg");
    parambke = (aq)new am(parambke);
    AppMethodBeat.o(359939);
    return parambke;
  }
  
  public final int eiV()
  {
    return 10006;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.f
 * JD-Core Version:    0.7.0.1
 */