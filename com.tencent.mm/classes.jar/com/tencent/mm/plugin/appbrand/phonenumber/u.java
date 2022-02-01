package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberCore;", "", "()V", "sPhoneNumberLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "getSPhoneNumberLogic", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "setSPhoneNumberLogic", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;)V", "logic", "luggage-wechat-full-sdk_release"})
public final class u
{
  private static n mku;
  public static final u mkv;
  
  static
  {
    AppMethodBeat.i(148122);
    mkv = new u();
    AppMethodBeat.o(148122);
  }
  
  public static void a(n paramn)
  {
    mku = paramn;
  }
  
  public static n bwy()
  {
    AppMethodBeat.i(148121);
    if (mku == null)
    {
      localn = (n)new i();
      AppMethodBeat.o(148121);
      return localn;
    }
    n localn = mku;
    if (localn == null) {
      p.gfZ();
    }
    AppMethodBeat.o(148121);
    return localn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.u
 * JD-Core Version:    0.7.0.1
 */