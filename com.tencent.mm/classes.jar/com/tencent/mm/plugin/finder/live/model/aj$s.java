package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.g.a;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$release$2", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj$s
  implements g.a
{
  public final void a(int paramInt1, int paramInt2, String paramString, bgg parambgg)
  {
    AppMethodBeat.i(359762);
    s.u(parambgg, "resp");
    Log.i("Finder.FinderLiveService", "closeLinkMic when release live. errCode:" + paramInt2 + ", errType:" + paramInt1);
    AppMethodBeat.o(359762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.aj.s
 * JD-Core Version:    0.7.0.1
 */