package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public final class n
  implements b<m>
{
  protected m pGT;
  public final a pGU;
  public final c pGV;
  public final b pGW;
  
  public n()
  {
    this(new m());
    AppMethodBeat.i(63368);
    AppMethodBeat.o(63368);
  }
  
  private n(m paramm)
  {
    AppMethodBeat.i(63369);
    this.pGU = new a();
    this.pGV = new c();
    this.pGW = new b();
    this.pGT = paramm;
    AppMethodBeat.o(63369);
  }
  
  public final m bVn()
  {
    return this.pGT;
  }
  
  public final class a
    implements e<Boolean, c<Integer, Map<String, Object>>>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<d<Boolean, String, Long>, Map<String, Object>>
  {
    public b() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class c
    implements e<d<Boolean, String, Long>, Map<String, Object>>
  {
    public c() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.n
 * JD-Core Version:    0.7.0.1
 */