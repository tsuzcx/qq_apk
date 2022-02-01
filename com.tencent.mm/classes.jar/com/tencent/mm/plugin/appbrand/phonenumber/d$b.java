package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.a;
import d.g.a.r;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
final class d$b<T>
  implements d.a<Object>
{
  d$b(r paramr) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(148025);
    ad.e("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber fail");
    if ((paramObject instanceof Exception)) {
      ad.e("Luggage.FULL.CgiPhoneNumber", "CgiGetAllPhone " + ((Exception)paramObject).getMessage());
    }
    paramObject = this.mjb;
    if (paramObject != null)
    {
      paramObject.a(Boolean.FALSE, "cgi fail", null, null);
      AppMethodBeat.o(148025);
      return;
    }
    AppMethodBeat.o(148025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d.b
 * JD-Core Version:    0.7.0.1
 */