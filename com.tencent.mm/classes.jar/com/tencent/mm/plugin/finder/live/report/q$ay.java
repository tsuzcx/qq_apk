package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$Live_Enter_Type;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "ORDINARY_LAUNCH_UI", "INNER_NOTICE_TIME_LAUNCH_UI", "RETURN_LIVE_ROOM", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum q$ay
{
  final int type;
  
  static
  {
    AppMethodBeat.i(351670);
    DAj = new ay("ORDINARY_LAUNCH_UI", 0, 1);
    DAk = new ay("INNER_NOTICE_TIME_LAUNCH_UI", 1, 2);
    DAl = new ay("RETURN_LIVE_ROOM", 2, 3);
    DAm = new ay[] { DAj, DAk, DAl };
    AppMethodBeat.o(351670);
  }
  
  private q$ay(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.q.ay
 * JD-Core Version:    0.7.0.1
 */