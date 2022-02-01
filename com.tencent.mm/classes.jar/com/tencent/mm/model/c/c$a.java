package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$ClientProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "UIN", "", "getUIN", "()I", "UIN$delegate", "Lkotlin/Lazy;", "provideUIN", "plugin-abtest_release"})
final class c$a
  implements c.d
{
  private final f iHk;
  
  public c$a()
  {
    AppMethodBeat.i(153171);
    this.iHk = g.ah((a)a.iHl);
    AppMethodBeat.o(153171);
  }
  
  public final int aXs()
  {
    AppMethodBeat.i(153170);
    int i = ((Number)this.iHk.getValue()).intValue();
    AppMethodBeat.o(153170);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<Integer>
  {
    public static final a iHl;
    
    static
    {
      AppMethodBeat.i(153168);
      iHl = new a();
      AppMethodBeat.o(153168);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.c.a
 * JD-Core Version:    0.7.0.1
 */