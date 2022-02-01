package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/WidthStatisticsCache;", "", "()V", "realtimeCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getRealtimeCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtimeCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  private i DIh;
  
  public ah()
  {
    AppMethodBeat.i(351214);
    this.DIh = new i("Width", 0, 6);
    AppMethodBeat.o(351214);
  }
  
  public final aa euo()
  {
    AppMethodBeat.i(351223);
    aa localaa = new aa(this.DIh, null, null);
    AppMethodBeat.o(351223);
    return localaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.ah
 * JD-Core Version:    0.7.0.1
 */