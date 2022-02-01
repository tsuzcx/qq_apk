package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public final class m
  implements b<l>
{
  protected l hZW;
  public final a hZX;
  public final b hZY;
  
  public m()
  {
    this(new l());
    AppMethodBeat.i(63368);
    AppMethodBeat.o(63368);
  }
  
  private m(l paraml)
  {
    AppMethodBeat.i(63369);
    this.hZX = new a();
    this.hZY = new b();
    this.hZW = paraml;
    AppMethodBeat.o(63369);
  }
  
  public final l aHj()
  {
    return this.hZW;
  }
  
  public final class a
    implements e<Boolean, c<Integer, Map<String, Object>>>
  {
    public a() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
  
  public final class b
    implements e<d<Boolean, String, Long>, Map<String, Object>>
  {
    public b() {}
    
    public final String Tg()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.m
 * JD-Core Version:    0.7.0.1
 */