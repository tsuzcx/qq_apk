package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.vending.g.d.a;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCode;", "", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getCode", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class b
{
  private final String appId;
  private final String code;
  private final String dSf;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(148020);
    this.appId = paramString1;
    this.dSf = paramString2;
    this.code = paramString3;
    AppMethodBeat.o(148020);
  }
  
  public final void y(kotlin.g.a.b<? super zz, x> paramb)
  {
    AppMethodBeat.i(148019);
    zy localzy = new zy();
    localzy.dNI = this.appId;
    localzy.dSf = this.dSf;
    localzy.IaW = this.code;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", (com.tencent.mm.bw.a)localzy, zz.class).c((com.tencent.mm.vending.c.a)new a(paramb)).a((d.a)new b.b(paramb));
    AppMethodBeat.o(148019);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(kotlin.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.b
 * JD-Core Version:    0.7.0.1
 */