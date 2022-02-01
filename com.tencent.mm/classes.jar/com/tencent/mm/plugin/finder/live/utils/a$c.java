package com.tencent.mm.plugin.finder.live.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.c;
import com.tencent.mm.plugin.finder.live.model.cgi.t.a;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.bfr;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/utils/FinderLiveUtil$prepareAnchorMusicInfo$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveBatchGetMusicInfo$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBatchGetMusicInfoResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
  implements t.a
{
  a$c(a parama) {}
  
  public final void a(int paramInt1, int paramInt2, bfr parambfr)
  {
    AppMethodBeat.i(351032);
    s.u(parambfr, "resp");
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      ((e)this.BxA.business(e.class)).Eee.a(parambfr);
    }
    AppMethodBeat.o(351032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.a.c
 * JD-Core Version:    0.7.0.1
 */