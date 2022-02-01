package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.bjb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "winnerInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;)V", "getWinnerInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  implements cc
{
  public final bjb EDj;
  
  public aw(bjb parambjb)
  {
    AppMethodBeat.i(331878);
    this.EDj = parambjb;
    AppMethodBeat.o(331878);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(331896);
    s.u(paramk, "obj");
    if ((paramk instanceof bjb)) {}
    for (paramk = (bjb)paramk; (paramk != null) && (s.p(paramk.username, this.EDj.username)) && (s.p(paramk.nickname, this.EDj.nickname)); paramk = null)
    {
      AppMethodBeat.o(331896);
      return 0;
    }
    AppMethodBeat.o(331896);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(331882);
    long l = hashCode();
    AppMethodBeat.o(331882);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(331888);
    int i = aw.class.hashCode();
    AppMethodBeat.o(331888);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.aw
 * JD-Core Version:    0.7.0.1
 */