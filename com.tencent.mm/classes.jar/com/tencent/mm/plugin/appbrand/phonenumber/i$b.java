package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic$verifyPhoneNumber$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$b
  implements aa.b
{
  i$b(m<? super Boolean, ? super Map<String, String>, ah> paramm) {}
  
  public final void a(boolean paramBoolean, Map<String, String> paramMap)
  {
    AppMethodBeat.i(319039);
    s.u(paramMap, "result");
    this.tGw.invoke(Boolean.valueOf(paramBoolean), paramMap);
    AppMethodBeat.o(319039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i.b
 * JD-Core Version:    0.7.0.1
 */