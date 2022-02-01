package com.tencent.mm.model.newabtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$ClientProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "UIN", "", "getUIN", "()I", "UIN$delegate", "Lkotlin/Lazy;", "provideUIN", "plugin-abtest_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c$a
  implements c.d
{
  private final j ooK;
  
  public c$a()
  {
    AppMethodBeat.i(153171);
    this.ooK = k.cm((a)a.ooL);
    AppMethodBeat.o(153171);
  }
  
  public final int bEr()
  {
    AppMethodBeat.i(153170);
    int i = ((Number)this.ooK.getValue()).intValue();
    AppMethodBeat.o(153170);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Integer>
  {
    public static final a ooL;
    
    static
    {
      AppMethodBeat.i(153168);
      ooL = new a();
      AppMethodBeat.o(153168);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.newabtest.c.a
 * JD-Core Version:    0.7.0.1
 */