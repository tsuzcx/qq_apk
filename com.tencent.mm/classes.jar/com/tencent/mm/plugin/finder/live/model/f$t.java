package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.ak.a;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bkd;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$modeShopShelf$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveModifyShopShelf$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$t
  implements ak.a
{
  f$t(q<? super Boolean, ? super String, ? super bkd, ah> paramq, auw paramauw, f paramf) {}
  
  public final void a(int paramInt1, final int paramInt2, final String paramString, final bkd parambkd)
  {
    AppMethodBeat.i(359583);
    s.u(parambkd, "resp");
    d.uiThread((a)new a(paramInt1, paramInt2, this.vSY, parambkd, paramString, this.CEF, this.CEm));
    AppMethodBeat.o(359583);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(int paramInt1, int paramInt2, q<? super Boolean, ? super String, ? super bkd, ah> paramq, bkd parambkd, String paramString, auw paramauw, f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f.t
 * JD-Core Version:    0.7.0.1
 */