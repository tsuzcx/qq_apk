package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.f;

public final class h
  implements b<g>
{
  protected g mJO;
  public final a mJP;
  
  public h()
  {
    this(new g());
    AppMethodBeat.i(63336);
    AppMethodBeat.o(63336);
  }
  
  private h(g paramg)
  {
    AppMethodBeat.i(63337);
    this.mJP = new a();
    this.mJO = paramg;
    AppMethodBeat.o(63337);
  }
  
  public final g bws()
  {
    return this.mJO;
  }
  
  public final class a
    implements e<c<String, String>, f<String, Long, Integer, String, String>>
  {
    public a() {}
    
    public final String aqj()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.h
 * JD-Core Version:    0.7.0.1
 */