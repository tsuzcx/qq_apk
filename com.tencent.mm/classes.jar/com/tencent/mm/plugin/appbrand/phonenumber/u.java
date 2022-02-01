package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberCore;", "", "()V", "sPhoneNumberLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "getSPhoneNumberLogic", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "setSPhoneNumberLogic", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;)V", "logic", "luggage-wechat-full-sdk_release"})
public final class u
{
  private static n lkM;
  public static final u lkN;
  
  static
  {
    AppMethodBeat.i(148122);
    lkN = new u();
    AppMethodBeat.o(148122);
  }
  
  public static void a(n paramn)
  {
    lkM = paramn;
  }
  
  public static n blE()
  {
    AppMethodBeat.i(148121);
    if (lkM == null)
    {
      localn = (n)new i();
      AppMethodBeat.o(148121);
      return localn;
    }
    n localn = lkM;
    if (localn == null) {
      k.fvU();
    }
    AppMethodBeat.o(148121);
    return localn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.u
 * JD-Core Version:    0.7.0.1
 */