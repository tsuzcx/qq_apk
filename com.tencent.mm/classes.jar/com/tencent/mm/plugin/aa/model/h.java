package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.f;

public final class h
  implements b<g>
{
  protected g jSB;
  public final a jSC;
  
  public h()
  {
    this(new g());
    AppMethodBeat.i(63336);
    AppMethodBeat.o(63336);
  }
  
  private h(g paramg)
  {
    AppMethodBeat.i(63337);
    this.jSC = new a();
    this.jSB = paramg;
    AppMethodBeat.o(63337);
  }
  
  public final g bmk()
  {
    return this.jSB;
  }
  
  public final class a
    implements e<c<String, String>, f<String, Long, Integer, String, String>>
  {
    public a() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.h
 * JD-Core Version:    0.7.0.1
 */