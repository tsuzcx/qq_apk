package com.tencent.mm.plugin.finder.video.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "", "TAG", "", "(Ljava/lang/String;)V", "getTAG", "()Ljava/lang/String;", "setTAG", "count", "", "getCount", "()I", "setCount", "(I)V", "currentTimeConsuming", "", "getCurrentTimeConsuming", "()J", "setCurrentTimeConsuming", "(J)V", "totalTimeConsuming", "getTotalTimeConsuming", "setTotalTimeConsuming", "statistic", "", "timeConsuming", "plugin-finder_release"})
public final class a
{
  public String TAG;
  public int count;
  public long wiM;
  public long wiN;
  
  public a(String paramString)
  {
    AppMethodBeat.i(254546);
    this.TAG = paramString;
    AppMethodBeat.o(254546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.statistics.a
 * JD-Core Version:    0.7.0.1
 */