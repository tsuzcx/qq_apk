package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveOlympicCloseShowReserveGuideLogic;", "", "()V", "TAG", "", "shouldShowReserveGuide", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
{
  public static final ad CGB;
  
  static
  {
    AppMethodBeat.i(359226);
    CGB = new ad();
    AppMethodBeat.o(359226);
  }
  
  public static boolean ekZ()
  {
    AppMethodBeat.i(359213);
    int i = h.baE().ban().getInt(at.a.adeV, 0);
    Log.i("Finder.FinderLiveOlympicCloseShowReserveGuideLogic", s.X("shouldShowReserveGuide guideCnt:", Integer.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(359213);
      return false;
    }
    h.baE().ban().set(at.a.adeV, Integer.valueOf(i + 1));
    AppMethodBeat.o(359213);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ad
 * JD-Core Version:    0.7.0.1
 */