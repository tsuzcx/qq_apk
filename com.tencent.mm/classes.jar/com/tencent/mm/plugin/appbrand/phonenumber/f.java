package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCodeWxaPhone;", "", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class f
{
  private final String appId;
  private final String dzn;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148036);
    this.appId = paramString1;
    this.dzn = paramString2;
    AppMethodBeat.o(148036);
  }
  
  public final void y(d.g.a.b<? super dan, z> paramb)
  {
    AppMethodBeat.i(148035);
    dam localdam = new dam();
    localdam.duW = this.appId;
    localdam.dzn = this.dzn;
    ((com.tencent.mm.plugin.appbrand.networking.b)e.K(com.tencent.mm.plugin.appbrand.networking.b.class)).a("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", (com.tencent.mm.bx.a)localdam, dan.class).c((com.tencent.mm.vending.c.a)new a(paramb)).a((d.a)new f.b(paramb));
    AppMethodBeat.o(148035);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(d.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.f
 * JD-Core Version:    0.7.0.1
 */