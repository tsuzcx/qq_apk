package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.a;
import d.g.a.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
final class c$b<T>
  implements d.a<Object>
{
  c$b(b paramb) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(148022);
    if ((paramObject instanceof Exception)) {
      ad.e("Luggage.FULL.CgiPhoneNumber", "CgiCheckVerifyCodeWxaPhone " + ((Exception)paramObject).getMessage());
    }
    paramObject = this.giT;
    if (paramObject != null)
    {
      paramObject.invoke(null);
      AppMethodBeat.o(148022);
      return;
    }
    AppMethodBeat.o(148022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.c.b
 * JD-Core Version:    0.7.0.1
 */