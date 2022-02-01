package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.a;
import d.g.a.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
final class g$c<T>
  implements d.a<Object>
{
  g$c(b paramb) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(148038);
    if ((paramObject instanceof Exception)) {
      ad.e("Luggage.FULL.CgiPhoneNumber", "CgiUpdateUserPhone " + ((Exception)paramObject).getMessage());
    }
    paramObject = this.giT;
    if (paramObject != null)
    {
      paramObject.invoke(null);
      AppMethodBeat.o(148038);
      return;
    }
    AppMethodBeat.o(148038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.g.c
 * JD-Core Version:    0.7.0.1
 */