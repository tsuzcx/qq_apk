package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.g.d.a;
import d.g.a.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
final class e$b<T>
  implements d.a<Object>
{
  e$b(b paramb) {}
  
  public final void ce(Object paramObject)
  {
    AppMethodBeat.i(148030);
    if ((paramObject instanceof Exception)) {
      ae.e("Luggage.FULL.CgiPhoneNumber", "CgiSendVerifyCode " + ((Exception)paramObject).getMessage());
    }
    paramObject = this.gll;
    if (paramObject != null)
    {
      paramObject.invoke(null);
      AppMethodBeat.o(148030);
      return;
    }
    AppMethodBeat.o(148030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.e.b
 * JD-Core Version:    0.7.0.1
 */