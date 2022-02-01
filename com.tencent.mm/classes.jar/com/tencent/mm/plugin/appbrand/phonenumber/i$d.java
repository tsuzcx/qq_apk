package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;
import d.l;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic$verifyPhoneNumber$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "luggage-wechat-full-sdk_release"})
public final class i$d
  implements aa.b
{
  i$d(m paramm) {}
  
  public final void a(boolean paramBoolean, Map<String, String> paramMap)
  {
    AppMethodBeat.i(186863);
    k.h(paramMap, "result");
    this.ljP.n(Boolean.valueOf(paramBoolean), paramMap);
    AppMethodBeat.o(186863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i.d
 * JD-Core Version:    0.7.0.1
 */