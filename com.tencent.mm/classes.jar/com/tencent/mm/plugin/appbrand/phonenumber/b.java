package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f;
import a.f.a.a;
import a.f.a.r;
import a.f.b.t;
import a.f.b.v;
import a.g;
import a.j.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.tg;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiCheckVerifyCode;", "", "appId", "", "mobile", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "rr$delegate", "Lkotlin/Lazy;", "run", "", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "errMsg", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "resp", "plugin-appbrand-integration_release"})
public final class b
{
  private final f iCD;
  
  static
  {
    AppMethodBeat.i(143917);
    eOJ = new k[] { (k)v.a(new t(v.aG(b.class), "rr", "getRr()Lcom/tencent/mm/modelbase/CommReqResp;")) };
    AppMethodBeat.o(143917);
  }
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(134777);
    this.iCD = g.j((a)new b.a(paramString1, paramString2, paramString3));
    AppMethodBeat.o(134777);
  }
  
  public final void a(r<? super Integer, ? super Integer, ? super String, ? super tg, y> paramr)
  {
    AppMethodBeat.i(143918);
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)this.iCD.getValue(), (com.tencent.mm.ipcinvoker.wx_extension.b.a)new b.b(paramr));
    AppMethodBeat.o(143918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.b
 * JD-Core Version:    0.7.0.1
 */