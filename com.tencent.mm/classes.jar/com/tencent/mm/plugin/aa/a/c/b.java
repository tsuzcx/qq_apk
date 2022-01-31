package com.tencent.mm.plugin.aa.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import java.util.List;

public class b
  implements com.tencent.mm.vending.c.b<a>
{
  protected a goN;
  public final a goO;
  
  public b()
  {
    this(new a());
    AppMethodBeat.i(40679);
    AppMethodBeat.o(40679);
  }
  
  private b(a parama)
  {
    AppMethodBeat.i(40680);
    this.goO = new a();
    this.goN = parama;
    AppMethodBeat.o(40680);
  }
  
  public final class a
    implements e<d<List, String, Boolean>, com.tencent.mm.vending.j.c<Boolean, Integer>>
  {
    public a() {}
    
    public final String HY()
    {
      return "Vending.ANY";
    }
    
    public final com.tencent.mm.vending.g.c<d<List, String, Boolean>> i(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(40677);
      com.tencent.mm.vending.g.c localc = f.A(Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt)).c(this);
      AppMethodBeat.o(40677);
      return localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.c.b
 * JD-Core Version:    0.7.0.1
 */