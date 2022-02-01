package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.vending.g.d.a;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCode;", "", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getCode", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class b
{
  private final String appId;
  private final String code;
  private final String dAs;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(148020);
    this.appId = paramString1;
    this.dAs = paramString2;
    this.code = paramString3;
    AppMethodBeat.o(148020);
  }
  
  public final void y(d.g.a.b<? super yl, z> paramb)
  {
    AppMethodBeat.i(148019);
    yk localyk = new yk();
    localyk.dwb = this.appId;
    localyk.dAs = this.dAs;
    localyk.DrK = this.code;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.K(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", (com.tencent.mm.bw.a)localyk, yl.class).c((com.tencent.mm.vending.c.a)new a(paramb)).a((d.a)new b.b(paramb));
    AppMethodBeat.o(148019);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(d.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.b
 * JD-Core Version:    0.7.0.1
 */