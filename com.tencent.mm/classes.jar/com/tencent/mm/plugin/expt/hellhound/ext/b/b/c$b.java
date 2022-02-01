package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$PageReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPOSURE", "INOUT", "INOUT_WITHOUT_78EVENT", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum c$b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(300633);
    zHb = new b("EXPOSURE", 0, 0);
    zHc = new b("INOUT", 1, 1);
    zHd = new b("INOUT_WITHOUT_78EVENT", 2, 2);
    zHe = new b[] { zHb, zHc, zHd };
    AppMethodBeat.o(300633);
  }
  
  private c$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b
 * JD-Core Version:    0.7.0.1
 */