package com.tencent.mm.plugin.comm.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/comm/kvstat/KvSessionId;", "", "(Ljava/lang/String;I)V", "MomentsTogetherHistoryBrowsing", "SnsUserBehaviourInfo", "MomentsTogetherTailActionFeed", "MomentsTogetherTailActionTimeline", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  static
  {
    AppMethodBeat.i(260536);
    xeN = new b("MomentsTogetherHistoryBrowsing", 0);
    xeO = new b("SnsUserBehaviourInfo", 1);
    xeP = new b("MomentsTogetherTailActionFeed", 2);
    xeQ = new b("MomentsTogetherTailActionTimeline", 3);
    xeR = new b[] { xeN, xeO, xeP, xeQ };
    AppMethodBeat.o(260536);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.comm.b.b
 * JD-Core Version:    0.7.0.1
 */