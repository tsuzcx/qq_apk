package com.tencent.luggage.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.a.c;

public final class a$a
  extends a.c
{
  private final com.tencent.luggage.sdk.e.d etN;
  
  private a$a(com.tencent.luggage.sdk.e.d paramd)
  {
    this.etN = paramd;
  }
  
  public final void a(String paramString, a.b paramb)
  {
    AppMethodBeat.i(169443);
    ((com.tencent.luggage.sdk.b.a.d.d)this.etN.ari()).eV("__APP__");
    super.a(paramString, paramb);
    AppMethodBeat.o(169443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.a.a
 * JD-Core Version:    0.7.0.1
 */