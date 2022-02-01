package com.tencent.mm.plugin.expt.hellhound.core.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/HellMultiProcessSeqGenerator;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a qQR;
  
  static
  {
    AppMethodBeat.i(122555);
    qQR = new a((byte)0);
    AppMethodBeat.o(122555);
  }
  
  public static final void cnK()
  {
    AppMethodBeat.i(122556);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.cnC())
    {
      a.CQ(0);
      a.CQ(1);
    }
    AppMethodBeat.o(122556);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/component/HellMultiProcessSeqGenerator$Companion;", "", "()V", "MMKV_KEY_HELL_MULTIPROCESEQ", "", "SESSION_FLOW_TYPE", "", "SESSION_FRONTTIME_TYPE", "TAG", "getSeqAfterIncrement", "", "type", "resetAllSeq", "", "writeback", "seq", "plugin-expt_release"})
  public static final class a
  {
    static void CQ(int paramInt)
    {
      AppMethodBeat.i(122554);
      try
      {
        b.adQ("hell_mlprocseq_".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(122554);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellMultiProcessSeqGenerator", (Throwable)localException, "HellMultiProcessSeqGenerator.writeback", new Object[0]);
        AppMethodBeat.o(122554);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.a.a
 * JD-Core Version:    0.7.0.1
 */