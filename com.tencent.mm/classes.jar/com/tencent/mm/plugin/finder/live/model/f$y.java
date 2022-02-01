package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.ao.a;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/FinderLiveAssistant$receiveCoupon$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReceiveCoupon$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReceiveCouponResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$y
  implements ao.a
{
  f$y(MMActivity paramMMActivity, m<? super Boolean, ? super blp, ah> paramm, boolean paramBoolean) {}
  
  public final void a(final int paramInt1, final int paramInt2, final blp paramblp)
  {
    AppMethodBeat.i(359566);
    s.u(paramblp, "resp");
    d.uiThread((a)new a(this.pjG, paramInt1, paramInt2, this.tGw, paramblp, this.CEI));
    AppMethodBeat.o(359566);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(MMActivity paramMMActivity, int paramInt1, int paramInt2, m<? super Boolean, ? super blp, ah> paramm, blp paramblp, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.f.y
 * JD-Core Version:    0.7.0.1
 */