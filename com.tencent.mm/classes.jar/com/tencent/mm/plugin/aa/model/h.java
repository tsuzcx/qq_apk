package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.j.c;

public final class h
  implements b<g>
{
  protected g hZB;
  public final a hZC;
  
  public h()
  {
    this(new g());
    AppMethodBeat.i(63336);
    AppMethodBeat.o(63336);
  }
  
  private h(g paramg)
  {
    AppMethodBeat.i(63337);
    this.hZC = new a();
    this.hZB = paramg;
    AppMethodBeat.o(63337);
  }
  
  public final g aHg()
  {
    return this.hZB;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<c<String, String>, com.tencent.mm.vending.j.e<String, Long, Integer, String>>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.h
 * JD-Core Version:    0.7.0.1
 */