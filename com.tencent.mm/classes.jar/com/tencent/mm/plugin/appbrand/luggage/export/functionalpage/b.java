package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.cnb;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateRuntimeQrcodeResponse;", "uuid", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.ai.a<cnb>
{
  public static final b.a iow;
  
  static
  {
    AppMethodBeat.i(134728);
    iow = new b.a((byte)0);
    AppMethodBeat.o(134728);
  }
  
  private b(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(134727);
    com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
    cna localcna = new cna();
    localcna.eAx = paramString1;
    localcna.status = paramInt;
    localcna.xWu = paramString2;
    locala.a((com.tencent.mm.bv.a)localcna);
    locala.b((com.tencent.mm.bv.a)new cnb());
    locala.kT(2578);
    locala.rl("/cgi-bin/mmbiz-bin/wxabusiness/updateruntimeqrcode");
    a(locala.ado());
    AppMethodBeat.o(134727);
  }
  
  public static final b Dt(String paramString)
  {
    AppMethodBeat.i(134729);
    j.q(paramString, "uuid");
    paramString = new b(paramString, 4);
    AppMethodBeat.o(134729);
    return paramString;
  }
  
  public static final b Du(String paramString)
  {
    AppMethodBeat.i(134730);
    j.q(paramString, "uuid");
    paramString = new b(paramString, 1);
    AppMethodBeat.o(134730);
    return paramString;
  }
  
  public static final b cB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134731);
    j.q(paramString1, "uuid");
    j.q(paramString2, "respData");
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(134731);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b
 * JD-Core Version:    0.7.0.1
 */