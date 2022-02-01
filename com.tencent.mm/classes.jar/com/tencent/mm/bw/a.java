package com.tencent.mm.bw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.api.j;
import com.tencent.mm.kernel.h;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/processor/BaseFunctionMsgItemProcessor;", "Lcom/tencent/mm/processor/IFunctionMsgItemProcessor;", "()V", "fetchInternal", "", "item", "Lkotlin/Pair;", "Lcom/tencent/mm/api/FunctionMsgItem;", "Lcom/tencent/mm/processor/OnNetSceneBackListener;", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  implements d
{
  public void k(r<? extends j, ? extends e> paramr)
  {
    AppMethodBeat.i(236126);
    kotlin.g.b.s.u(paramr, "item");
    paramr = new com.tencent.mm.bh.a((j)paramr.bsC, (e)paramr.bsD);
    h.aZW().a((p)paramr, 0);
    AppMethodBeat.o(236126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bw.a
 * JD-Core Version:    0.7.0.1
 */