package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$MMProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "provideUIN", "", "plugin-abtest_release"})
final class c$b
  implements c.d
{
  public final int aXs()
  {
    AppMethodBeat.i(153172);
    p.g(g.aAf(), "MMKernel.account()");
    int i = a.getUin();
    AppMethodBeat.o(153172);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.c.b
 * JD-Core Version:    0.7.0.1
 */