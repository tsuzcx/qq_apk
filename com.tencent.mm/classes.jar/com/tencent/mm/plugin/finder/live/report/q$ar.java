package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$LinkType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "INVALIDATE", "AUDIO", "VIDEO", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum q$ar
{
  final int type;
  
  static
  {
    AppMethodBeat.i(351687);
    Dzi = new ar("INVALIDATE", 0, 0);
    Dzj = new ar("AUDIO", 1, 1);
    Dzk = new ar("VIDEO", 2, 2);
    Dzl = new ar[] { Dzi, Dzj, Dzk };
    AppMethodBeat.o(351687);
  }
  
  private q$ar(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.q.ar
 * JD-Core Version:    0.7.0.1
 */