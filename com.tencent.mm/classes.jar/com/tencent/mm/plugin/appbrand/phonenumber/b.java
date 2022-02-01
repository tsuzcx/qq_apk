package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCode;", "", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getCode", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final String appId;
  private final String code;
  private final String hRk;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(148020);
    this.appId = paramString1;
    this.hRk = paramString2;
    this.code = paramString3;
    AppMethodBeat.o(148020);
  }
  
  private static final ah a(kotlin.g.a.b paramb, acd paramacd)
  {
    AppMethodBeat.i(318959);
    if (paramb == null)
    {
      AppMethodBeat.o(318959);
      return null;
    }
    paramb.invoke(paramacd);
    paramb = ah.aiuX;
    AppMethodBeat.o(318959);
    return paramb;
  }
  
  private static final void f(kotlin.g.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(318965);
    if ((paramObject instanceof Exception)) {
      Log.e("Luggage.FULL.CgiPhoneNumber", s.X("CgiCheckVerifyCode ", ((Exception)paramObject).getMessage()));
    }
    if (paramb != null) {
      paramb.invoke(null);
    }
    AppMethodBeat.o(318965);
  }
  
  public final void Z(kotlin.g.a.b<? super acd, ah> paramb)
  {
    AppMethodBeat.i(148019);
    acc localacc = new acc();
    localacc.appid = this.appId;
    localacc.hRk = this.hRk;
    localacc.VJo = this.code;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.T(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", (a)localacc, acd.class).c(new b..ExternalSyntheticLambda0(paramb)).a(new b..ExternalSyntheticLambda1(paramb));
    AppMethodBeat.o(148019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.b
 * JD-Core Version:    0.7.0.1
 */