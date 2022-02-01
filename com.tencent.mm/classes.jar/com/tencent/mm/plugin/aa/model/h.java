package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.j.c;

public final class h
  implements b<g>
{
  protected g iSO;
  public final a iSP;
  
  public h()
  {
    this(new g());
    AppMethodBeat.i(63336);
    AppMethodBeat.o(63336);
  }
  
  private h(g paramg)
  {
    AppMethodBeat.i(63337);
    this.iSP = new a();
    this.iSO = paramg;
    AppMethodBeat.o(63337);
  }
  
  public final g aRg()
  {
    return this.iSO;
  }
  
  public final class a
    implements com.tencent.mm.vending.h.e<c<String, String>, com.tencent.mm.vending.j.e<String, Long, Integer, String>>
  {
    public a() {}
    
    public final String Wr()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.h
 * JD-Core Version:    0.7.0.1
 */