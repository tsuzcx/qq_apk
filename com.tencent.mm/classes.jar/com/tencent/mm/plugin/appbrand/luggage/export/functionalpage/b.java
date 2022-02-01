package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateRuntimeQrcodeResponse;", "uuid", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.ak.a<dlq>
{
  public static final a lqP;
  
  static
  {
    AppMethodBeat.i(50857);
    lqP = new a((byte)0);
    AppMethodBeat.o(50857);
  }
  
  private b(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(50856);
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    dlp localdlp = new dlp();
    localdlp.uuid = paramString1;
    localdlp.status = paramInt;
    localdlp.FTZ = paramString2;
    locala.c((com.tencent.mm.bw.a)localdlp);
    locala.d((com.tencent.mm.bw.a)new dlq());
    locala.op(2578);
    locala.Am("/cgi-bin/mmbiz-bin/wxabusiness/updateruntimeqrcode");
    c(locala.aAz());
    AppMethodBeat.o(50856);
  }
  
  public static final b OC(String paramString)
  {
    AppMethodBeat.i(50858);
    k.h(paramString, "uuid");
    paramString = new b(paramString, 4);
    AppMethodBeat.o(50858);
    return paramString;
  }
  
  public static final b OD(String paramString)
  {
    AppMethodBeat.i(50859);
    k.h(paramString, "uuid");
    paramString = new b(paramString, 1);
    AppMethodBeat.o(50859);
    return paramString;
  }
  
  public static final b dL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50860);
    k.h(paramString1, "uuid");
    k.h(paramString2, "respData");
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(50860);
    return paramString1;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode$Companion;", "", "()V", "CANCELLED", "", "CONFIRMED", "SCANNED", "TAG", "", "cancel", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "uuid", "confirm", "respData", "scanned", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b
 * JD-Core Version:    0.7.0.1
 */