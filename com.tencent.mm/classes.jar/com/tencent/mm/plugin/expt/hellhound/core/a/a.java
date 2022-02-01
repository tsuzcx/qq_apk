package com.tencent.mm.plugin.expt.hellhound.core.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/HellMultiProcessSeqGenerator;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a zBc;
  
  static
  {
    AppMethodBeat.i(122555);
    zBc = new a((byte)0);
    AppMethodBeat.o(122555);
  }
  
  public static final void dIZ()
  {
    AppMethodBeat.i(122556);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
    {
      a.Ly(0);
      a.Ly(1);
    }
    AppMethodBeat.o(122556);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/HellMultiProcessSeqGenerator$Companion;", "", "()V", "MMKV_KEY_HELL_MULTIPROCESEQ", "", "SESSION_FLOW_TYPE", "", "SESSION_FRONTTIME_TYPE", "TAG", "getSeqAfterIncrement", "", "type", "resetAllSeq", "", "writeback", "seq", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static void Ly(int paramInt)
    {
      AppMethodBeat.i(122554);
      try
      {
        b.are(s.X("hell_mlprocseq_", Integer.valueOf(paramInt)));
        AppMethodBeat.o(122554);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellMultiProcessSeqGenerator", (Throwable)localException, "HellMultiProcessSeqGenerator.writeback", new Object[0]);
        AppMethodBeat.o(122554);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a
 * JD-Core Version:    0.7.0.1
 */