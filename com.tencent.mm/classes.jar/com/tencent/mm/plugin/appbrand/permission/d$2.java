package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;

final class d$2
  implements a<Void, axr>
{
  d$2(d paramd, int paramInt, String paramString) {}
  
  private Void a(axr paramaxr)
  {
    AppMethodBeat.i(156377);
    if ((paramaxr.xmS.csV == 0) && (1 == this.iBw))
    {
      ab.i("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s  scope=%s", new Object[] { d.a(this.iBv), d.b(this.iBv), this.iBx });
      d.aKs().put(d.a(this.iBv), d.b(this.iBv));
    }
    AppMethodBeat.o(156377);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d.2
 * JD-Core Version:    0.7.0.1
 */