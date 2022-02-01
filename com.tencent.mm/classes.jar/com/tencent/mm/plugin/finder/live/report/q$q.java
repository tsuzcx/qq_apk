package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$CoverType2;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "LIVE_COVER_DEFAULT", "LIVE_COVER_FRONT_CAMERA", "LIVE_COVER_ALBUM", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum q$q
{
  public final int type;
  
  static
  {
    AppMethodBeat.i(351539);
    Dua = new q("LIVE_COVER_DEFAULT", 0, 0);
    Dub = new q("LIVE_COVER_FRONT_CAMERA", 1, 6);
    Duc = new q("LIVE_COVER_ALBUM", 2, 8);
    Dud = new q[] { Dua, Dub, Duc };
    AppMethodBeat.o(351539);
  }
  
  private q$q(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.q.q
 * JD-Core Version:    0.7.0.1
 */