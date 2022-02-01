package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import java.util.List;

public class b
  implements com.tencent.mm.vending.c.b<a>
{
  protected a iUd;
  public final a iUe;
  
  public b()
  {
    this(new a());
    AppMethodBeat.i(63436);
    AppMethodBeat.o(63436);
  }
  
  private b(a parama)
  {
    AppMethodBeat.i(63437);
    this.iUe = new a();
    this.iUd = parama;
    AppMethodBeat.o(63437);
  }
  
  public final class a
    implements e<d<List, String, Boolean>, com.tencent.mm.vending.j.c<Boolean, Integer>>
  {
    public a() {}
    
    public final String Wr()
    {
      return "Vending.ANY";
    }
    
    public final com.tencent.mm.vending.g.c<d<List, String, Boolean>> m(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(63434);
      com.tencent.mm.vending.g.c localc = g.L(Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt)).c(this);
      AppMethodBeat.o(63434);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.b
 * JD-Core Version:    0.7.0.1
 */