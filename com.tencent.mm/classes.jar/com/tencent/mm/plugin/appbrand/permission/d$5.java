package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;

final class d$5
  implements a<Void, axt>
{
  d$5(d paramd) {}
  
  private Void b(axt paramaxt)
  {
    AppMethodBeat.i(156380);
    try
    {
      d.a(this.iBv, paramaxt);
      AppMethodBeat.o(156380);
      return null;
    }
    catch (Exception paramaxt)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth appId = %s, e = %s", new Object[] { d.a(this.iBv), paramaxt });
        f.dQn().cK(paramaxt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d.5
 * JD-Core Version:    0.7.0.1
 */