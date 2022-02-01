package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.aa.a;
import com.tencent.mm.protocal.protobuf.bhl;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$getCouponList$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetCouponList$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetCouponListResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$m
  implements aa.a
{
  f$m(f paramf, m<? super Boolean, ? super bhl, ah> paramm) {}
  
  public final void a(int paramInt1, final int paramInt2, final bhl parambhl)
  {
    AppMethodBeat.i(359626);
    s.u(parambhl, "resp");
    d.uiThread((a)new a(paramInt1, paramInt2, this.CEm, this.tGw, parambhl));
    AppMethodBeat.o(359626);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(int paramInt1, int paramInt2, f paramf, m<? super Boolean, ? super bhl, ah> paramm, bhl parambhl)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f.m
 * JD-Core Version:    0.7.0.1
 */