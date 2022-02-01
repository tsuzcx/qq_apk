package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_PK", "PK_WAITING", "PK_LINKING", "plugin-core_release"})
public enum h$g
{
  static
  {
    AppMethodBeat.i(198277);
    g localg1 = new g("NO_PK", 0);
    kne = localg1;
    g localg2 = new g("PK_WAITING", 1);
    knf = localg2;
    g localg3 = new g("PK_LINKING", 2);
    kng = localg3;
    knh = new g[] { localg1, localg2, localg3 };
    AppMethodBeat.o(198277);
  }
  
  private h$g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.h.g
 * JD-Core Version:    0.7.0.1
 */