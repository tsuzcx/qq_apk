package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.eyf;
import com.tencent.mm.protocal.protobuf.eyg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCodeWxaPhone;", "", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getMobile", "run", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "Lkotlin/ParameterName;", "name", "resp", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private final String appId;
  private final String hRk;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148036);
    this.appId = paramString1;
    this.hRk = paramString2;
    AppMethodBeat.o(148036);
  }
  
  private static final ah a(b paramb, eyg parameyg)
  {
    AppMethodBeat.i(318940);
    if (paramb == null)
    {
      AppMethodBeat.o(318940);
      return null;
    }
    paramb.invoke(parameyg);
    paramb = ah.aiuX;
    AppMethodBeat.o(318940);
    return paramb;
  }
  
  private static final void f(b paramb, Object paramObject)
  {
    AppMethodBeat.i(318950);
    if ((paramObject instanceof Exception)) {
      Log.e("Luggage.FULL.CgiPhoneNumber", s.X("CgiSendVerifyCodeWxaPhone ", ((Exception)paramObject).getMessage()));
    }
    if (paramb != null) {
      paramb.invoke(null);
    }
    AppMethodBeat.o(318950);
  }
  
  public final void Z(b<? super eyg, ah> paramb)
  {
    AppMethodBeat.i(148035);
    eyf localeyf = new eyf();
    localeyf.appid = this.appId;
    localeyf.hRk = this.hRk;
    ((com.tencent.mm.plugin.appbrand.networking.c)e.T(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/sendverifycode", (a)localeyf, eyg.class).c(new f..ExternalSyntheticLambda0(paramb)).a(new f..ExternalSyntheticLambda1(paramb));
    AppMethodBeat.o(148035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.f
 * JD-Core Version:    0.7.0.1
 */