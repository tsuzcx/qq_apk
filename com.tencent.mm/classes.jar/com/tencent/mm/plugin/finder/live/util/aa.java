package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/VideoBitrateStatisticsCache;", "", "()V", "VideoBitrateCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getVideoBitrateCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setVideoBitrateCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageVideoBitrateCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageVideoBitrateCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageVideoBitrateCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class aa
{
  private ArrayList<i> uvW;
  private i uxw;
  private e uxx;
  
  public aa()
  {
    AppMethodBeat.i(247307);
    this.uxw = new i("VideoBitrate", 0, 6);
    this.uxx = new e("AverageVideoBitrate", 14);
    this.uvW = new ArrayList();
    AppMethodBeat.o(247307);
  }
  
  public final w did()
  {
    AppMethodBeat.i(247306);
    this.uvW.add(new i("BadVideoBitrate", 300, 4));
    this.uvW.add(new i("NormalVideoBitrate", 1800, 4));
    this.uvW.add(new i("GoodVideoBitrate", 2147483647, 4));
    w localw = new w(this.uxw, this.uxx, this.uvW);
    AppMethodBeat.o(247306);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.aa
 * JD-Core Version:    0.7.0.1
 */