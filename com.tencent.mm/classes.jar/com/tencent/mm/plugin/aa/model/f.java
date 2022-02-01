package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;

public final class f
  implements b<e>
{
  protected e iSK;
  public final a iSL;
  
  public f()
  {
    this(new e());
    AppMethodBeat.i(63332);
    AppMethodBeat.o(63332);
  }
  
  private f(e parame)
  {
    AppMethodBeat.i(63333);
    this.iSL = new a();
    this.iSK = parame;
    AppMethodBeat.o(63333);
  }
  
  public final e aRf()
  {
    return this.iSK;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<Void, Void>
  {
    public a() {}
    
    public final String Wr()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.f
 * JD-Core Version:    0.7.0.1
 */