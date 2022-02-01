package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$ShareType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "SINGLE_CHAT", "GROUP_CHAT", "SNS", "JSAPI", "plugin-expt_release"})
public enum c$c
{
  final int type;
  
  static
  {
    AppMethodBeat.i(251438);
    c localc1 = new c("SINGLE_CHAT", 0, 1);
    wla = localc1;
    c localc2 = new c("GROUP_CHAT", 1, 2);
    wlb = localc2;
    c localc3 = new c("SNS", 2, 3);
    wlc = localc3;
    c localc4 = new c("JSAPI", 3, 4);
    wld = localc4;
    wle = new c[] { localc1, localc2, localc3, localc4 };
    AppMethodBeat.o(251438);
  }
  
  private c$c(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.c.c
 * JD-Core Version:    0.7.0.1
 */