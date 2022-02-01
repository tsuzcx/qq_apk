package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
final class f$b<T>
  implements d.a<Object>
{
  f$b(b paramb) {}
  
  public final void cm(Object paramObject)
  {
    AppMethodBeat.i(148034);
    if ((paramObject instanceof Exception)) {
      Log.e("Luggage.FULL.CgiPhoneNumber", "CgiSendVerifyCodeWxaPhone " + ((Exception)paramObject).getMessage());
    }
    paramObject = this.jFa;
    if (paramObject != null)
    {
      paramObject.invoke(null);
      AppMethodBeat.o(148034);
      return;
    }
    AppMethodBeat.o(148034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.f.b
 * JD-Core Version:    0.7.0.1
 */