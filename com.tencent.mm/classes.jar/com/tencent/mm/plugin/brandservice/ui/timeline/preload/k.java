package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eu;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"DELAY_TIME", "", "getBuffSize", "", "", "getContent", "hasContent", "", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "plugin-brandservice_release"})
public final class k
{
  public static final boolean b(eu parameu)
  {
    AppMethodBeat.i(6725);
    d.g.b.k.h(parameu, "$this$hasContent");
    j localj = j.ned;
    boolean bool = b.c(j.bDK(), b.a(parameu));
    AppMethodBeat.o(6725);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.k
 * JD-Core Version:    0.7.0.1
 */