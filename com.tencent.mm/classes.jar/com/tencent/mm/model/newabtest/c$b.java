package com.tencent.mm.model.newabtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$MMProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "provideUIN", "", "plugin-abtest_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c$b
  implements c.d
{
  public final int bEr()
  {
    AppMethodBeat.i(153172);
    h.baC();
    int i = b.getUin();
    AppMethodBeat.o(153172);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.newabtest.c.b
 * JD-Core Version:    0.7.0.1
 */