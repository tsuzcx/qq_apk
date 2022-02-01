package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.ag.a;
import com.tencent.mm.protocal.protobuf.bir;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$issueCoupon$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveIssueCoupon$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveIssueCouponResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$s
  implements ag.a
{
  f$s(m<? super Boolean, ? super bir, ah> paramm) {}
  
  public final void a(int paramInt1, final int paramInt2, final bir parambir)
  {
    AppMethodBeat.i(359578);
    s.u(parambir, "resp");
    d.uiThread((a)new a(paramInt1, paramInt2, this.tGw, parambir));
    AppMethodBeat.o(359578);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(int paramInt1, int paramInt2, m<? super Boolean, ? super bir, ah> paramm, bir parambir)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f.s
 * JD-Core Version:    0.7.0.1
 */