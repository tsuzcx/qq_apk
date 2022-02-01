package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.protocal.protobuf.dse;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateRuntimeQrcodeResponse;", "uuid", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.ak.a<dse>
{
  public static final a lSP;
  
  static
  {
    AppMethodBeat.i(50857);
    lSP = new a((byte)0);
    AppMethodBeat.o(50857);
  }
  
  private b(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(50856);
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    dsd localdsd = new dsd();
    localdsd.uuid = paramString1;
    localdsd.status = paramInt;
    localdsd.HYA = paramString2;
    locala.c((com.tencent.mm.bw.a)localdsd);
    locala.d((com.tencent.mm.bw.a)new dse());
    locala.oS(2578);
    locala.DN("/cgi-bin/mmbiz-bin/wxabusiness/updateruntimeqrcode");
    c(locala.aDS());
    AppMethodBeat.o(50856);
  }
  
  public static final b SK(String paramString)
  {
    AppMethodBeat.i(50858);
    p.h(paramString, "uuid");
    paramString = new b(paramString, 4);
    AppMethodBeat.o(50858);
    return paramString;
  }
  
  public static final b SL(String paramString)
  {
    AppMethodBeat.i(50859);
    p.h(paramString, "uuid");
    paramString = new b(paramString, 1);
    AppMethodBeat.o(50859);
    return paramString;
  }
  
  public static final b dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50860);
    p.h(paramString1, "uuid");
    p.h(paramString2, "respData");
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(50860);
    return paramString1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode$Companion;", "", "()V", "CANCELLED", "", "CONFIRMED", "SCANNED", "TAG", "", "cancel", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "uuid", "confirm", "respData", "scanned", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b
 * JD-Core Version:    0.7.0.1
 */