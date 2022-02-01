package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.j.d;

public final class k
  implements b<j>
{
  protected j hZE;
  public final b hZF;
  public final a hZG;
  
  public k()
  {
    this(new j());
    AppMethodBeat.i(63361);
    AppMethodBeat.o(63361);
  }
  
  private k(j paramj)
  {
    AppMethodBeat.i(63362);
    this.hZF = new b();
    this.hZG = new a();
    this.hZE = paramj;
    AppMethodBeat.o(63362);
  }
  
  public final j aHi()
  {
    return this.hZE;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<Boolean, d<String, Integer, String>>
  {
    public b() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.k
 * JD-Core Version:    0.7.0.1
 */