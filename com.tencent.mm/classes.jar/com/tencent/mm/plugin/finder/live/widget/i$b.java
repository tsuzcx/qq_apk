package com.tencent.mm.plugin.finder.live.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.k;
import com.tencent.mm.protocal.protobuf.bib;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$showCard$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$b
  implements ad.a
{
  i$b(i parami) {}
  
  public final void a(int paramInt1, int paramInt2, bib parambib)
  {
    AppMethodBeat.i(361260);
    s.u(parambib, "resp");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ((k)this.ElY.CwG.business(k.class)).a(parambib.Bhm);
      ((k)this.ElY.CwG.business(k.class)).d(parambib);
    }
    b.b.a(this.ElY.nfT, b.c.neo);
    parambib = this.ElY.nfT;
    b.c localc = b.c.nem;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", false);
    ah localah = ah.aiuX;
    parambib.statusChange(localc, localBundle);
    AppMethodBeat.o(361260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.i.b
 * JD-Core Version:    0.7.0.1
 */