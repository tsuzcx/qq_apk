package com.tencent.mm.plugin.finder.video.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/statistics/ConsumingStatistics;", "", "TAG", "", "(Ljava/lang/String;)V", "getTAG", "()Ljava/lang/String;", "setTAG", "count", "", "getCount", "()I", "setCount", "(I)V", "currentTimeConsuming", "", "getCurrentTimeConsuming", "()J", "setCurrentTimeConsuming", "(J)V", "totalTimeConsuming", "getTotalTimeConsuming", "setTotalTimeConsuming", "statistic", "", "timeConsuming", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public long GuT;
  public long GuU;
  public String TAG;
  public int count;
  
  public a(String paramString)
  {
    AppMethodBeat.i(335052);
    this.TAG = paramString;
    AppMethodBeat.o(335052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.statistics.a
 * JD-Core Version:    0.7.0.1
 */