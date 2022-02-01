package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$FinderPullType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PULL_TYPE_ENTER", "PULL_TYPE_TOP", "PULL_TYPE_BOTTOM", "PULL_TYPE_PRE_FETCH", "PULL_TYPE_REFRESH", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum m$c
{
  final int value;
  
  static
  {
    AppMethodBeat.i(300567);
    zIj = new c("PULL_TYPE_ENTER", 0, 0);
    zIk = new c("PULL_TYPE_TOP", 1, 1);
    zIl = new c("PULL_TYPE_BOTTOM", 2, 2);
    zIm = new c("PULL_TYPE_PRE_FETCH", 3, 3);
    zIn = new c("PULL_TYPE_REFRESH", 4, 4);
    zIo = new c[] { zIj, zIk, zIl, zIm, zIn };
    AppMethodBeat.o(300567);
  }
  
  private m$c(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.m.c
 * JD-Core Version:    0.7.0.1
 */