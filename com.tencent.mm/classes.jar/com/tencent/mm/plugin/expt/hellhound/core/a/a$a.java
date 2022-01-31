package com.tencent.mm.plugin.expt.hellhound.core.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/HellMultiProcessSeqGenerator$Companion;", "", "()V", "MMKV_KEY_HELL_MULTIPROCESEQ", "", "SESSION_FLOW_TYPE", "", "SESSION_FRONTTIME_TYPE", "TAG", "getSeqAfterIncrement", "", "type", "resetAllSeq", "", "writeback", "seq", "plugin-expt_release"})
public final class a$a
{
  static void vl(int paramInt)
  {
    AppMethodBeat.i(152470);
    try
    {
      b.Mg("hell_mlprocseq_".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(152470);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("HellMultiProcessSeqGenerator", (Throwable)localException, "habbyge-mali, HellMultiProcessSeqGenerator.writeback", new Object[0]);
      AppMethodBeat.o(152470);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a.a
 * JD-Core Version:    0.7.0.1
 */