package com.tencent.mm.plugin.finder.live.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.u.a;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveLinkInviteAnchorWidget$loadRecommendInfo$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCandidate$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMicCandidateListResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj$c
  implements u.a
{
  public aj$c(aj paramaj) {}
  
  public final void a(azn paramazn)
  {
    AppMethodBeat.i(362338);
    s.u(paramazn, "resp");
    Log.i(aj.access$getTAG$cp(), s.X("doGetMicCandidateList resp.contacts:", Integer.valueOf(paramazn.ZJH.size())));
    aj.c(this.Erj).clear();
    if (paramazn.ZJH != null) {
      aj.c(this.Erj).addAll((Collection)paramazn.ZJH);
    }
    AppMethodBeat.o(362338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.aj.c
 * JD-Core Version:    0.7.0.1
 */