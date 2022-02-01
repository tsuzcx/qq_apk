package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;
import kotlin.g.a.r;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
final class d$b<T>
  implements d.a<Object>
{
  d$b(r paramr) {}
  
  public final void cn(Object paramObject)
  {
    AppMethodBeat.i(148025);
    Log.e("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber fail");
    if ((paramObject instanceof Exception)) {
      Log.e("Luggage.FULL.CgiPhoneNumber", "CgiGetAllPhone " + ((Exception)paramObject).getMessage());
    }
    paramObject = this.nyK;
    if (paramObject != null)
    {
      paramObject.invoke(Boolean.FALSE, "cgi fail", null, null);
      AppMethodBeat.o(148025);
      return;
    }
    AppMethodBeat.o(148025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d.b
 * JD-Core Version:    0.7.0.1
 */