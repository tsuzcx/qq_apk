package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;

public final class g
  implements b<f>
{
  protected f pGs;
  public final a pGt;
  
  public g()
  {
    this(new f());
    AppMethodBeat.i(63332);
    AppMethodBeat.o(63332);
  }
  
  private g(f paramf)
  {
    AppMethodBeat.i(63333);
    this.pGt = new a();
    this.pGs = paramf;
    AppMethodBeat.o(63333);
  }
  
  public final f bVj()
  {
    return this.pGs;
  }
  
  public final class a
    implements e<Void, Void>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.g
 * JD-Core Version:    0.7.0.1
 */