package com.tencent.mm.live.core.core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/LiveStatus$PKLinkMicStatus;", "", "(Ljava/lang/String;I)V", "NO_PK", "PK_WAITING", "PK_LINKING", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum i$g
{
  static
  {
    AppMethodBeat.i(247964);
    mOn = new g("NO_PK", 0);
    mOo = new g("PK_WAITING", 1);
    mOp = new g("PK_LINKING", 2);
    mOq = new g[] { mOn, mOo, mOp };
    AppMethodBeat.o(247964);
  }
  
  private i$g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.i.g
 * JD-Core Version:    0.7.0.1
 */