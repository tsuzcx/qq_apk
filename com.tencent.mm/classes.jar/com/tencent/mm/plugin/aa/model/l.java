package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.j.d;

public final class l
  implements b<k>
{
  protected k pGA;
  public final b pGB;
  public final a pGC;
  
  public l()
  {
    this(new k());
    AppMethodBeat.i(63361);
    AppMethodBeat.o(63361);
  }
  
  private l(k paramk)
  {
    AppMethodBeat.i(63362);
    this.pGB = new b();
    this.pGC = new a();
    this.pGA = paramk;
    AppMethodBeat.o(63362);
  }
  
  public final k bVm()
  {
    return this.pGA;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<Boolean, d<String, Integer, String>>
  {
    public b() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.l
 * JD-Core Version:    0.7.0.1
 */