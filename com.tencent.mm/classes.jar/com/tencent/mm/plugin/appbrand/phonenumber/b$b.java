package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
final class b$b<T>
  implements d.a<Object>
{
  b$b(b paramb) {}
  
  public final void cn(Object paramObject)
  {
    AppMethodBeat.i(148018);
    if ((paramObject instanceof Exception)) {
      Log.e("Luggage.FULL.CgiPhoneNumber", "CgiCheckVerifyCode " + ((Exception)paramObject).getMessage());
    }
    paramObject = this.gWe;
    if (paramObject != null)
    {
      paramObject.invoke(null);
      AppMethodBeat.o(148018);
      return;
    }
    AppMethodBeat.o(148018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.b.b
 * JD-Core Version:    0.7.0.1
 */