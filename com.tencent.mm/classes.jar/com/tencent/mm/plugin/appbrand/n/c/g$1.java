package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.plugin.appbrand.permission.d.c;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  implements d.c
{
  g$1(g paramg, c paramc, String paramString) {}
  
  public final void Ec(String paramString)
  {
    AppMethodBeat.i(102199);
    ab.e("Luggage.NodeJS.RequireUserAuth", "onDeny apiName[%s], reason[%s]", new Object[] { this.bEa, paramString });
    g.a(this.iup, 2);
    AppMethodBeat.o(102199);
  }
  
  public final void aID()
  {
    AppMethodBeat.i(102198);
    g.a(this.iup, 1);
    AppMethodBeat.o(102198);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(102200);
    g.a(this.iup, 3);
    AppMethodBeat.o(102200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c.g.1
 * JD-Core Version:    0.7.0.1
 */