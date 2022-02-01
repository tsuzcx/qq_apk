package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"DELAY_TIME", "", "getBuffSize", "", "", "getContent", "hasContent", "", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "plugin-brandservice_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final boolean b(gb paramgb)
  {
    AppMethodBeat.i(6725);
    s.u(paramgb, "<this>");
    m localm = m.vSK;
    boolean bool = c.c(m.dfw(), c.a(paramgb));
    AppMethodBeat.o(6725);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.n
 * JD-Core Version:    0.7.0.1
 */