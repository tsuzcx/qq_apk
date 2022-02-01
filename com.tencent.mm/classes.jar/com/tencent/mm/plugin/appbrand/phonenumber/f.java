package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import d.g.a.b;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCodeWxaPhone;", "", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"})
public final class f
{
  private final String appId;
  private final String dnz;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148036);
    this.appId = paramString1;
    this.dnz = paramString2;
    AppMethodBeat.o(148036);
  }
  
  public final void x(b<? super cvb, y> paramb)
  {
    AppMethodBeat.i(148035);
    cva localcva = new cva();
    localcva.djj = this.appId;
    localcva.dnz = this.dnz;
    ((com.tencent.mm.plugin.appbrand.networking.a)e.K(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", (com.tencent.mm.bw.a)localcva, cvb.class).c((com.tencent.mm.vending.c.a)new a(paramb)).a((d.a)new b(paramb));
    AppMethodBeat.o(148035);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;)Lkotlin/Unit;"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(b paramb) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements d.a<Object>
  {
    b(b paramb) {}
    
    public final void cc(Object paramObject)
    {
      AppMethodBeat.i(148034);
      if ((paramObject instanceof Exception)) {
        ac.e("Luggage.FULL.CgiPhoneNumber", "CgiSendVerifyCodeWxaPhone " + ((Exception)paramObject).getMessage());
      }
      paramObject = this.fPt;
      if (paramObject != null)
      {
        paramObject.ay(null);
        AppMethodBeat.o(148034);
        return;
      }
      AppMethodBeat.o(148034);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.f
 * JD-Core Version:    0.7.0.1
 */