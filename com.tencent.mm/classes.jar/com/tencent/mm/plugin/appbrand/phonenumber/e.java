package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCode;", "", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class e
{
  private final String appId;
  private final String dzn;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148032);
    this.appId = paramString1;
    this.dzn = paramString2;
    AppMethodBeat.o(148032);
  }
  
  public final void y(d.g.a.b<? super dan, z> paramb)
  {
    AppMethodBeat.i(148031);
    dam localdam = new dam();
    localdam.duW = this.appId;
    localdam.dzn = this.dzn;
    ((com.tencent.mm.plugin.appbrand.networking.b)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.networking.b.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", (com.tencent.mm.bx.a)localdam, dan.class).c((com.tencent.mm.vending.c.a)new a(paramb)).a((d.a)new e.b(paramb));
    AppMethodBeat.o(148031);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(d.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.e
 * JD-Core Version:    0.7.0.1
 */