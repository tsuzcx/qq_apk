package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$PageReportType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "EXPOSURE", "INOUT", "INOUT_WITHOUT_78EVENT", "plugin-expt_release"})
public enum c$b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(220928);
    b localb1 = new b("EXPOSURE", 0, 0);
    sFb = localb1;
    b localb2 = new b("INOUT", 1, 1);
    sFc = localb2;
    b localb3 = new b("INOUT_WITHOUT_78EVENT", 2, 2);
    sFd = localb3;
    sFe = new b[] { localb1, localb2, localb3 };
    AppMethodBeat.o(220928);
  }
  
  private c$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b
 * JD-Core Version:    0.7.0.1
 */