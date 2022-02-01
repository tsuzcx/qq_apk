package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dbh;
import com.tencent.mm.vending.g.d.a;
import d.g.a.b;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCode;", "", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class e
{
  private final String appId;
  private final String dAs;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148032);
    this.appId = paramString1;
    this.dAs = paramString2;
    AppMethodBeat.o(148032);
  }
  
  public final void y(b<? super dbh, z> paramb)
  {
    AppMethodBeat.i(148031);
    dbg localdbg = new dbg();
    localdbg.dwb = this.appId;
    localdbg.dAs = this.dAs;
    ((com.tencent.mm.plugin.appbrand.networking.c)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/sendverifycode", (com.tencent.mm.bw.a)localdbg, dbh.class).c((com.tencent.mm.vending.c.a)new a(paramb)).a((d.a)new e.b(paramb));
    AppMethodBeat.o(148031);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.e
 * JD-Core Version:    0.7.0.1
 */