package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberCore;", "", "()V", "sPhoneNumberLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "getSPhoneNumberLogic", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "setSPhoneNumberLogic", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;)V", "logic", "luggage-wechat-full-sdk_release"})
public final class u
{
  private static n nAd;
  public static final u nAe;
  
  static
  {
    AppMethodBeat.i(148122);
    nAe = new u();
    AppMethodBeat.o(148122);
  }
  
  public static void a(n paramn)
  {
    nAd = paramn;
  }
  
  public static n bTz()
  {
    AppMethodBeat.i(148121);
    if (nAd == null)
    {
      localn = (n)new i();
      AppMethodBeat.o(148121);
      return localn;
    }
    n localn = nAd;
    if (localn == null) {
      p.hyc();
    }
    AppMethodBeat.o(148121);
    return localn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.u
 * JD-Core Version:    0.7.0.1
 */