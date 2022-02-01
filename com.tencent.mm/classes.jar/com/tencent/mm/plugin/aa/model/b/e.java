package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import java.util.Map;

public class e
  implements b<d>
{
  protected d iaX;
  public final b iaY;
  public final c iaZ;
  public final a iba;
  
  public e()
  {
    this(new d());
    AppMethodBeat.i(63451);
    AppMethodBeat.o(63451);
  }
  
  private e(d paramd)
  {
    AppMethodBeat.i(63452);
    this.iaY = new b();
    this.iaZ = new c();
    this.iba = new a();
    this.iaX = paramd;
    AppMethodBeat.o(63452);
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<com.tencent.mm.plugin.aa.model.e, Void>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<Boolean, com.tencent.mm.vending.j.c<Integer, Map<String, Object>>>
  {
    public b() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<Boolean> c(int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(63447);
      paramMap = g.J(Integer.valueOf(paramInt), paramMap).c(this);
      AppMethodBeat.o(63447);
      return paramMap;
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<com.tencent.mm.vending.j.d<Boolean, String, Long>, Map<String, Object>>
  {
    public c() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<com.tencent.mm.vending.j.d<Boolean, String, Long>> y(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(63449);
      paramMap = g.ee(paramMap).c(this);
      AppMethodBeat.o(63449);
      return paramMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.e
 * JD-Core Version:    0.7.0.1
 */