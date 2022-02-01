package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public final class d
  implements b<c>
{
  protected c pGf;
  public final a pGg;
  
  public d()
  {
    this(new c());
    AppMethodBeat.i(63321);
    AppMethodBeat.o(63321);
  }
  
  private d(c paramc)
  {
    AppMethodBeat.i(63322);
    this.pGg = new a();
    this.pGf = paramc;
    AppMethodBeat.o(63322);
  }
  
  public final c bVc()
  {
    return this.pGf;
  }
  
  public final class a
    implements e<z, f<String, Integer, String, String, Integer>>
  {
    public a() {}
    
    public final String aKh()
    {
      return "Vending.LOGIC";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.d
 * JD-Core Version:    0.7.0.1
 */