package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCodeWxaPhone;", "", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getCode", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private final String appId;
  private final String code;
  private final String hRk;
  
  public c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(148023);
    this.appId = paramString1;
    this.hRk = paramString2;
    this.code = paramString3;
    AppMethodBeat.o(148023);
  }
  
  private static final ah a(b paramb, acd paramacd)
  {
    AppMethodBeat.i(318938);
    if (paramb == null)
    {
      AppMethodBeat.o(318938);
      return null;
    }
    paramb.invoke(paramacd);
    paramb = ah.aiuX;
    AppMethodBeat.o(318938);
    return paramb;
  }
  
  private static final void f(b paramb, Object paramObject)
  {
    AppMethodBeat.i(318945);
    if ((paramObject instanceof Exception)) {
      Log.e("Luggage.FULL.CgiPhoneNumber", s.X("CgiCheckVerifyCodeWxaPhone ", ((Exception)paramObject).getMessage()));
    }
    if (paramb != null) {
      paramb.invoke(null);
    }
    AppMethodBeat.o(318945);
  }
  
  public final void Z(b<? super acd, ah> paramb)
  {
    AppMethodBeat.i(318966);
    acc localacc = new acc();
    localacc.appid = this.appId;
    localacc.hRk = this.hRk;
    localacc.VJo = this.code;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.T(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", (a)localacc, acd.class).c(new c..ExternalSyntheticLambda0(paramb)).a(new c..ExternalSyntheticLambda1(paramb));
    AppMethodBeat.o(318966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.c
 * JD-Core Version:    0.7.0.1
 */