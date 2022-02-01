package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.cgi.h.a;
import com.tencent.mm.protocal.protobuf.bgb;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderLiveVisitorRoleUIC$showBottomSheet$2$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveClearAliasRole$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClearAliasRoleResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n$e
  implements h.a
{
  n$e(n paramn) {}
  
  public final void Oz(int paramInt)
  {
    AppMethodBeat.i(356549);
    d.uiThread((a)new a(paramInt, this.DZQ));
    AppMethodBeat.o(356549);
  }
  
  public final void a(bgb parambgb)
  {
    AppMethodBeat.i(356545);
    s.u(parambgb, "resp");
    d.uiThread((a)new b(this.DZQ));
    AppMethodBeat.o(356545);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(int paramInt, n paramn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.n.e
 * JD-Core Version:    0.7.0.1
 */