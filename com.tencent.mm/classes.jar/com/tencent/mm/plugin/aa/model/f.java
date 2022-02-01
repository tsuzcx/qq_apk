package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;

public final class f
  implements b<e>
{
  protected e jSx;
  public final a jSy;
  
  public f()
  {
    this(new e());
    AppMethodBeat.i(63332);
    AppMethodBeat.o(63332);
  }
  
  private f(e parame)
  {
    AppMethodBeat.i(63333);
    this.jSy = new a();
    this.jSx = parame;
    AppMethodBeat.o(63333);
  }
  
  public final e bmj()
  {
    return this.jSx;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<Void, Void>
  {
    public a() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.f
 * JD-Core Version:    0.7.0.1
 */