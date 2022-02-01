package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberCore;", "", "()V", "sPhoneNumberLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "getSPhoneNumberLogic", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "setSPhoneNumberLogic", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;)V", "logic", "luggage-wechat-full-sdk_release"})
public final class u
{
  private static n mpr;
  public static final u mps;
  
  static
  {
    AppMethodBeat.i(148122);
    mps = new u();
    AppMethodBeat.o(148122);
  }
  
  public static void a(n paramn)
  {
    mpr = paramn;
  }
  
  public static n bxp()
  {
    AppMethodBeat.i(148121);
    if (mpr == null)
    {
      localn = (n)new i();
      AppMethodBeat.o(148121);
      return localn;
    }
    n localn = mpr;
    if (localn == null) {
      p.gkB();
    }
    AppMethodBeat.o(148121);
    return localn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.u
 * JD-Core Version:    0.7.0.1
 */