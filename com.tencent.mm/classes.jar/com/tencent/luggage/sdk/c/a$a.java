package com.tencent.luggage.sdk.c;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k.a.b;
import com.tencent.mm.plugin.appbrand.k.a.c;

public final class a$a
  extends a.c
{
  private final b bEZ;
  
  private a$a(b paramb)
  {
    this.bEZ = paramb;
  }
  
  public final void a(String paramString, boolean paramBoolean, a.b paramb, com.tencent.mm.plugin.appbrand.k.a.a parama)
  {
    AppMethodBeat.i(140793);
    ((c)this.bEZ.ws()).bT("__APP__");
    super.a(paramString, paramBoolean, paramb, parama);
    AppMethodBeat.o(140793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.sdk.c.a.a
 * JD-Core Version:    0.7.0.1
 */