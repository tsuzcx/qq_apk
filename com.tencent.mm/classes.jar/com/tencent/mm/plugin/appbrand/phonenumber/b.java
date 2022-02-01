package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.vending.g.d.a;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCode;", "", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getCode", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class b
{
  private final String appId;
  private final String code;
  private final String fLC;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(148020);
    this.appId = paramString1;
    this.fLC = paramString2;
    this.code = paramString3;
    AppMethodBeat.o(148020);
  }
  
  public final void y(kotlin.g.a.b<? super aad, x> paramb)
  {
    AppMethodBeat.i(148019);
    aac localaac = new aac();
    localaac.appid = this.appId;
    localaac.fLC = this.fLC;
    localaac.OTh = this.code;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.K(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", (com.tencent.mm.cd.a)localaac, aad.class).c((com.tencent.mm.vending.c.a)new b.a(paramb)).a((d.a)new b.b(paramb));
    AppMethodBeat.o(148019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.b
 * JD-Core Version:    0.7.0.1
 */