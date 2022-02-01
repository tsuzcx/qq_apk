package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.f;

public final class i
  implements b<h>
{
  protected h pGw;
  public final a pGx;
  
  public i()
  {
    this(new h());
    AppMethodBeat.i(63336);
    AppMethodBeat.o(63336);
  }
  
  private i(h paramh)
  {
    AppMethodBeat.i(63337);
    this.pGx = new a();
    this.pGw = paramh;
    AppMethodBeat.o(63337);
  }
  
  public final h bVk()
  {
    return this.pGw;
  }
  
  public final class a
    implements e<c<String, String>, f<String, Long, Integer, String, String>>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.i
 * JD-Core Version:    0.7.0.1
 */