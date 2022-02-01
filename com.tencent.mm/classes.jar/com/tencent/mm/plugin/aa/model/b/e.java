package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import java.util.Map;

public class e
  implements b<d>
{
  protected d iXd;
  public final b iXe;
  public final c iXf;
  public final a iXg;
  
  public e()
  {
    this(new d());
    AppMethodBeat.i(63451);
    AppMethodBeat.o(63451);
  }
  
  private e(d paramd)
  {
    AppMethodBeat.i(63452);
    this.iXe = new b();
    this.iXf = new c();
    this.iXg = new a();
    this.iXd = paramd;
    AppMethodBeat.o(63452);
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<com.tencent.mm.plugin.aa.model.e, Void>
  {
    public a() {}
    
    public final String Wz()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements com.tencent.mm.vending.h.e<Boolean, com.tencent.mm.vending.j.c<Integer, Map<String, Object>>>
  {
    public b() {}
    
    public final String Wz()
    {
      return "Vending.LOGIC";
    }
    
    public final com.tencent.mm.vending.g.c<Boolean> d(int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(63447);
      paramMap = g.L(Integer.valueOf(paramInt), paramMap).c(this);
      AppMethodBeat.o(63447);
      return paramMap;
    }
  }
  
  public final class c
    implements com.tencent.mm.vending.h.e<com.tencent.mm.vending.j.d<Boolean, String, Long>, Map<String, Object>>
  {
    public c() {}
    
    public final com.tencent.mm.vending.g.c<com.tencent.mm.vending.j.d<Boolean, String, Long>> E(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(63449);
      paramMap = g.ej(paramMap).c(this);
      AppMethodBeat.o(63449);
      return paramMap;
    }
    
    public final String Wz()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.b.e
 * JD-Core Version:    0.7.0.1
 */