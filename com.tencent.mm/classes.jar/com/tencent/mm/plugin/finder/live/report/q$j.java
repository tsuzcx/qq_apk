package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$BookLiveSrc;", "", "source", "", "(Ljava/lang/String;II)V", "getSource", "()I", "PROFILE", "PROFILE_RIGHT_CORNER", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum q$j
{
  final int source;
  
  static
  {
    AppMethodBeat.i(351552);
    DsU = new j("PROFILE", 0, 1);
    DsV = new j("PROFILE_RIGHT_CORNER", 1, 2);
    DsW = new j[] { DsU, DsV };
    AppMethodBeat.o(351552);
  }
  
  private q$j(int paramInt)
  {
    this.source = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.q.j
 * JD-Core Version:    0.7.0.1
 */