package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.j.d;

public final class k
  implements b<j>
{
  protected j jSF;
  public final b jSG;
  public final a jSH;
  
  public k()
  {
    this(new j());
    AppMethodBeat.i(63361);
    AppMethodBeat.o(63361);
  }
  
  private k(j paramj)
  {
    AppMethodBeat.i(63362);
    this.jSG = new b();
    this.jSH = new a();
    this.jSF = paramj;
    AppMethodBeat.o(63362);
  }
  
  public final j bmm()
  {
    return this.jSF;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>>
  {
    public a() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<Boolean, d<String, Integer, String>>
  {
    public b() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.k
 * JD-Core Version:    0.7.0.1
 */