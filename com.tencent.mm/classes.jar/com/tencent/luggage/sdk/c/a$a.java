package com.tencent.luggage.sdk.c;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.a.b;
import com.tencent.mm.plugin.appbrand.m.a.c;

public final class a$a
  extends a.c
{
  private final d cpk;
  
  private a$a(d paramd)
  {
    this.cpk = paramd;
  }
  
  public final void a(String paramString, a.b paramb)
  {
    AppMethodBeat.i(169443);
    ((c)this.cpk.Ey()).cU("__APP__");
    super.a(paramString, paramb);
    AppMethodBeat.o(169443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.c.a.a
 * JD-Core Version:    0.7.0.1
 */