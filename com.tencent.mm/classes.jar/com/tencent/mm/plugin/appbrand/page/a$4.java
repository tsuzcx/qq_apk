package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.d.a;
import com.tencent.mm.plugin.appbrand.s.g;

final class a$4
  extends au
{
  a$4(a parama, v paramv, ab paramab)
  {
    super(paramv, paramab);
  }
  
  public final void a(d.a parama, int paramInt)
  {
    AppMethodBeat.i(140861);
    super.a(parama, paramInt);
    if (this.iuH.iuF != null) {
      this.iuH.iuF.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(140861);
  }
  
  public final void cO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140860);
    int i = g.bA(paramString2, -1);
    a(d.a.Et(paramString1), i);
    AppMethodBeat.o(140860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.4
 * JD-Core Version:    0.7.0.1
 */