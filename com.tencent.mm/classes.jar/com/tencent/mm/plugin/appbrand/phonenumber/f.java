package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.vending.g.d.a;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCodeWxaPhone;", "", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class f
{
  private final String appId;
  private final String dSf;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148036);
    this.appId = paramString1;
    this.dSf = paramString2;
    AppMethodBeat.o(148036);
  }
  
  public final void y(b<? super dul, x> paramb)
  {
    AppMethodBeat.i(148035);
    duk localduk = new duk();
    localduk.dNI = this.appId;
    localduk.dSf = this.dSf;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", (com.tencent.mm.bw.a)localduk, dul.class).c((com.tencent.mm.vending.c.a)new a(paramb)).a((d.a)new f.b(paramb));
    AppMethodBeat.o(148035);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.f
 * JD-Core Version:    0.7.0.1
 */