package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCode;", "", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getCode", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class b
{
  private final String appId;
  private final String code;
  private final String dnz;
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(148020);
    this.appId = paramString1;
    this.dnz = paramString2;
    this.code = paramString3;
    AppMethodBeat.o(148020);
  }
  
  public final void x(d.g.a.b<? super wj, y> paramb)
  {
    AppMethodBeat.i(148019);
    wi localwi = new wi();
    localwi.djj = this.appId;
    localwi.dnz = this.dnz;
    localwi.BzM = this.code;
    ((com.tencent.mm.plugin.appbrand.networking.a)e.K(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp/customphone/checkverifycode", (com.tencent.mm.bw.a)localwi, wj.class).c((com.tencent.mm.vending.c.a)new a(paramb)).a((d.a)new b(paramb));
    AppMethodBeat.o(148019);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(d.g.a.b paramb) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements d.a<Object>
  {
    b(d.g.a.b paramb) {}
    
    public final void cc(Object paramObject)
    {
      AppMethodBeat.i(148018);
      if ((paramObject instanceof Exception)) {
        ac.e("Luggage.FULL.CgiPhoneNumber", "CgiCheckVerifyCode " + ((Exception)paramObject).getMessage());
      }
      paramObject = this.fPt;
      if (paramObject != null)
      {
        paramObject.ay(null);
        AppMethodBeat.o(148018);
        return;
      }
      AppMethodBeat.o(148018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.b
 * JD-Core Version:    0.7.0.1
 */