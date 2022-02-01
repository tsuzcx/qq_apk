package com.tencent.luggage.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a.b;
import com.tencent.mm.plugin.appbrand.n.a.c;

public final class a$a
  extends a.c
{
  private final com.tencent.luggage.sdk.d.c ceP;
  
  private a$a(com.tencent.luggage.sdk.d.c paramc)
  {
    this.ceP = paramc;
  }
  
  public final void a(String paramString, a.b paramb)
  {
    AppMethodBeat.i(169443);
    ((com.tencent.luggage.sdk.b.a.c.c)this.ceP.CX()).bY("__APP__");
    super.a(paramString, paramb);
    AppMethodBeat.o(169443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.c.a.a
 * JD-Core Version:    0.7.0.1
 */