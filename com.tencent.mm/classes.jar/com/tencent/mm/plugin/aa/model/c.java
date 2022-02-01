package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public final class c
  implements com.tencent.mm.vending.c.b<b>
{
  protected b jSj;
  public final a jSk;
  
  public c()
  {
    this(new b());
    AppMethodBeat.i(63321);
    AppMethodBeat.o(63321);
  }
  
  private c(b paramb)
  {
    AppMethodBeat.i(63322);
    this.jSk = new a();
    this.jSj = paramb;
    AppMethodBeat.o(63322);
  }
  
  public final b bmb()
  {
    return this.jSj;
  }
  
  public final class a
    implements e<y, f<String, Integer, String, String, Integer>>
  {
    public a() {}
    
    public final String akn()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.c
 * JD-Core Version:    0.7.0.1
 */