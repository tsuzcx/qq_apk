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
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.bzm;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiSendVerifyCode;", "", "appId", "", "mobile", "(Ljava/lang/String;Ljava/lang/String;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "rr$delegate", "Lkotlin/Lazy;", "run", "", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "errMsg", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "resp", "plugin-appbrand-integration_release"})
public final class e
{
  private final f iCD;
  
  static
  {
    AppMethodBeat.i(143930);
    eOJ = new k[] { (k)v.a(new t(v.aG(e.class), "rr", "getRr()Lcom/tencent/mm/modelbase/CommReqResp;")) };
    AppMethodBeat.o(143930);
  }
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134781);
    this.iCD = g.j((a)new e.a(paramString1, paramString2));
    AppMethodBeat.o(134781);
  }
  
  public final void a(r<? super Integer, ? super Integer, ? super String, ? super bzm, y> paramr)
  {
    AppMethodBeat.i(143931);
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)this.iCD.getValue(), (b.a)new e.b(paramr));
    AppMethodBeat.o(143931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.e
 * JD-Core Version:    0.7.0.1
 */