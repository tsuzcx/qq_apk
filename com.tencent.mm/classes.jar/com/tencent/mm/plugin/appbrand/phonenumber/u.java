package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberCore;", "", "()V", "sPhoneNumberLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "getSPhoneNumberLogic", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "setSPhoneNumberLogic", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;)V", "logic", "luggage-wechat-full-sdk_release"})
public final class u
{
  private static n lKE;
  public static final u lKF;
  
  static
  {
    AppMethodBeat.i(148122);
    lKF = new u();
    AppMethodBeat.o(148122);
  }
  
  public static void a(n paramn)
  {
    lKE = paramn;
  }
  
  public static n bst()
  {
    AppMethodBeat.i(148121);
    if (lKE == null)
    {
      localn = (n)new i();
      AppMethodBeat.o(148121);
      return localn;
    }
    n localn = lKE;
    if (localn == null) {
      k.fOy();
    }
    AppMethodBeat.o(148121);
    return localn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.u
 * JD-Core Version:    0.7.0.1
 */