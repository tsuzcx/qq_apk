package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public final class c
  implements com.tencent.mm.vending.c.b<b>
{
  protected b iVp;
  public final a iVq;
  
  public c()
  {
    this(new b());
    AppMethodBeat.i(63321);
    AppMethodBeat.o(63321);
  }
  
  private c(b paramb)
  {
    AppMethodBeat.i(63322);
    this.iVq = new a();
    this.iVp = paramb;
    AppMethodBeat.o(63322);
  }
  
  public final b aRx()
  {
    return this.iVp;
  }
  
  public final class a
    implements e<w, f<String, Integer, String, String, Integer>>
  {
    public a() {}
    
    public final String Wz()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.c
 * JD-Core Version:    0.7.0.1
 */