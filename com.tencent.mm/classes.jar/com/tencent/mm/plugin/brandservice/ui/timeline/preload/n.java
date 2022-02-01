package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fh;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"DELAY_TIME", "", "getBuffSize", "", "", "getContent", "hasContent", "", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "plugin-brandservice_release"})
public final class n
{
  public static final boolean b(fh paramfh)
  {
    AppMethodBeat.i(6725);
    p.k(paramfh, "$this$hasContent");
    m localm = m.sNg;
    boolean bool = c.c(m.cCk(), c.a(paramfh));
    AppMethodBeat.o(6725);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.n
 * JD-Core Version:    0.7.0.1
 */