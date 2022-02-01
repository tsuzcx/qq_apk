package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "", "cache", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "averageCache", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;Ljava/util/ArrayList;)V", "average", "getAverage", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverage", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "level", "getLevel", "()Ljava/util/ArrayList;", "setLevel", "(Ljava/util/ArrayList;)V", "realtime", "getRealtime", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtime", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  boolean ABD;
  i DJF;
  e DJG;
  ArrayList<i> DJH;
  
  public aa(i parami, e parame, ArrayList<i> paramArrayList)
  {
    AppMethodBeat.i(351257);
    this.ABD = true;
    this.DJF = parami;
    this.DJG = parame;
    this.DJH = paramArrayList;
    AppMethodBeat.o(351257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.aa
 * JD-Core Version:    0.7.0.1
 */