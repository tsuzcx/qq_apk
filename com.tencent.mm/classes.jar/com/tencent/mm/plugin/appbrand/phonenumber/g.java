package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f;
import a.f.a.a;
import a.f.a.r;
import a.f.b.t;
import a.f.b.v;
import a.j.k;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.cnk;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/CgiUpdateUserPhone;", "", "appId", "", "mobile", "type", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "rr$delegate", "Lkotlin/Lazy;", "run", "", "callback", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "errType", "errCode", "errMsg", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "resp", "Companion", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g.a iCK;
  private final f iCD;
  
  static
  {
    AppMethodBeat.i(134784);
    eOJ = new k[] { (k)v.a(new t(v.aG(g.class), "rr", "getRr()Lcom/tencent/mm/modelbase/CommReqResp;")) };
    iCK = new g.a((byte)0);
    AppMethodBeat.o(134784);
  }
  
  public g(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(134783);
    this.iCD = a.g.j((a)new g.b(paramString1, paramString2, paramInt));
    AppMethodBeat.o(134783);
  }
  
  public final void a(r<? super Integer, ? super Integer, ? super String, ? super cnk, y> paramr)
  {
    AppMethodBeat.i(143938);
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)this.iCD.getValue(), (b.a)new g.c(paramr));
    AppMethodBeat.o(143938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.g
 * JD-Core Version:    0.7.0.1
 */