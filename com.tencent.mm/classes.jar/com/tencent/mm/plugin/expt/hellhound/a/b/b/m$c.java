package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$FinderPullType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PULL_TYPE_ENTER", "PULL_TYPE_TOP", "PULL_TYPE_BOTTOM", "PULL_TYPE_PRE_FETCH", "PULL_TYPE_REFRESH", "plugin-expt_release"})
public enum m$c
{
  final int value;
  
  static
  {
    AppMethodBeat.i(252102);
    c localc1 = new c("PULL_TYPE_ENTER", 0, 0);
    wme = localc1;
    c localc2 = new c("PULL_TYPE_TOP", 1, 1);
    wmf = localc2;
    c localc3 = new c("PULL_TYPE_BOTTOM", 2, 2);
    wmg = localc3;
    c localc4 = new c("PULL_TYPE_PRE_FETCH", 3, 3);
    wmh = localc4;
    c localc5 = new c("PULL_TYPE_REFRESH", 4, 4);
    wmi = localc5;
    wmj = new c[] { localc1, localc2, localc3, localc4, localc5 };
    AppMethodBeat.o(252102);
  }
  
  private m$c(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.m.c
 * JD-Core Version:    0.7.0.1
 */