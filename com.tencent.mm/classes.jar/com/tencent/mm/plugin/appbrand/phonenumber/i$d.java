package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic$verifyPhoneNumber$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "luggage-wechat-full-sdk_release"})
public final class i$d
  implements aa.b
{
  i$d(m paramm) {}
  
  public final void a(boolean paramBoolean, Map<String, String> paramMap)
  {
    AppMethodBeat.i(230136);
    p.h(paramMap, "result");
    this.nzd.invoke(Boolean.valueOf(paramBoolean), paramMap);
    AppMethodBeat.o(230136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i.d
 * JD-Core Version:    0.7.0.1
 */