package com.tencent.mm.plugin.finder.live.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.s.a;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$loadRecommendInfo$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMicCandidateListResponse;", "plugin-finder_release"})
public final class u$d
  implements s.a
{
  public final void a(aut paramaut)
  {
    AppMethodBeat.i(242587);
    p.k(paramaut, "resp");
    Log.i(u.access$getTAG$cp(), "doGetMicCandidateList resp.contacts:" + paramaut.SGP.size());
    u.a(this.zoE).clear();
    if (paramaut.SGP != null) {
      u.a(this.zoE).addAll((Collection)paramaut.SGP);
    }
    AppMethodBeat.o(242587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.u.d
 * JD-Core Version:    0.7.0.1
 */