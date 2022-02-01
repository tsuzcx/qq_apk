package com.tencent.mm.plugin.finder.video.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "", "TAG", "", "(Ljava/lang/String;)V", "getTAG", "()Ljava/lang/String;", "setTAG", "count", "", "getCount", "()I", "setCount", "(I)V", "currentTimeConsuming", "", "getCurrentTimeConsuming", "()J", "setCurrentTimeConsuming", "(J)V", "totalTimeConsuming", "getTotalTimeConsuming", "setTotalTimeConsuming", "statistic", "", "timeConsuming", "plugin-finder_release"})
public final class a
{
  public long ASU;
  public long ASV;
  public String TAG;
  public int count;
  
  public a(String paramString)
  {
    AppMethodBeat.i(231417);
    this.TAG = paramString;
    AppMethodBeat.o(231417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.statistics.a
 * JD-Core Version:    0.7.0.1
 */