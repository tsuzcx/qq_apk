package com.tencent.mm.plugin.expt.hellhound.ext.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/MatchState;", "", "(Ljava/lang/String;I)V", "MATCH_INVALIDATE", "MATCH_PAGE_RESUME", "MATCH_PAGE_FINISH", "MATCH_PAGE_SLIENCE_POP_STACK", "MATCH_PAGE_8_EVENT", "MATCH_PAGE_MM_PROCESS_RESTEART", "MATCH_PAGE_SESSION_CLOSE", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum f
{
  static
  {
    AppMethodBeat.i(122588);
    zJZ = new f("MATCH_INVALIDATE", 0);
    zKa = new f("MATCH_PAGE_RESUME", 1);
    zKb = new f("MATCH_PAGE_FINISH", 2);
    zKc = new f("MATCH_PAGE_SLIENCE_POP_STACK", 3);
    zKd = new f("MATCH_PAGE_8_EVENT", 4);
    zKe = new f("MATCH_PAGE_MM_PROCESS_RESTEART", 5);
    zKf = new f("MATCH_PAGE_SESSION_CLOSE", 6);
    zKg = new f[] { zJZ, zKa, zKb, zKc, zKd, zKe, zKf };
    AppMethodBeat.o(122588);
  }
  
  private f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.d.f
 * JD-Core Version:    0.7.0.1
 */