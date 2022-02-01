package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "Chat", "Timeline", "PERSIONAL_STATE_SHARE_SUCC", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum q$ch
{
  final int type;
  
  static
  {
    AppMethodBeat.i(351917);
    DFy = new ch("Chat", 0, 1);
    DFz = new ch("Timeline", 1, 2);
    DFA = new ch("PERSIONAL_STATE_SHARE_SUCC", 2, 5);
    DFB = new ch[] { DFy, DFz, DFA };
    AppMethodBeat.o(351917);
  }
  
  private q$ch(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.q.ch
 * JD-Core Version:    0.7.0.1
 */