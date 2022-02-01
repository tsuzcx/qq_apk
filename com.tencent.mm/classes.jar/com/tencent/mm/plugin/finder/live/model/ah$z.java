package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.g.a;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/FinderLiveService$release$2", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder_release"})
public final class ah$z
  implements g.a
{
  public final void a(int paramInt1, int paramInt2, String paramString, ayz paramayz)
  {
    AppMethodBeat.i(289263);
    p.k(paramayz, "resp");
    Log.i("Finder.FinderLiveService", "closeLinkMic when release live. errCode:" + paramInt2 + ", errType:" + paramInt1);
    AppMethodBeat.o(289263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ah.z
 * JD-Core Version:    0.7.0.1
 */