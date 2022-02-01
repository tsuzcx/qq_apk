package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dga;
import com.tencent.mm.protocal.protobuf.dgb;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateRuntimeQrcodeResponse;", "uuid", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.al.a<dgb>
{
  public static final a kPq;
  
  static
  {
    AppMethodBeat.i(50857);
    kPq = new a((byte)0);
    AppMethodBeat.o(50857);
  }
  
  private b(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(50856);
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    dga localdga = new dga();
    localdga.uuid = paramString1;
    localdga.status = paramInt;
    localdga.EwX = paramString2;
    locala.c((com.tencent.mm.bx.a)localdga);
    locala.d((com.tencent.mm.bx.a)new dgb());
    locala.nB(2578);
    locala.wg("/cgi-bin/mmbiz-bin/wxabusiness/updateruntimeqrcode");
    c(locala.atI());
    AppMethodBeat.o(50856);
  }
  
  public static final b Kv(String paramString)
  {
    AppMethodBeat.i(50858);
    k.h(paramString, "uuid");
    paramString = new b(paramString, 4);
    AppMethodBeat.o(50858);
    return paramString;
  }
  
  public static final b Kw(String paramString)
  {
    AppMethodBeat.i(50859);
    k.h(paramString, "uuid");
    paramString = new b(paramString, 1);
    AppMethodBeat.o(50859);
    return paramString;
  }
  
  public static final b dz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50860);
    k.h(paramString1, "uuid");
    k.h(paramString2, "respData");
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(50860);
    return paramString1;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode$Companion;", "", "()V", "CANCELLED", "", "CONFIRMED", "SCANNED", "TAG", "", "cancel", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "uuid", "confirm", "respData", "scanned", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b
 * JD-Core Version:    0.7.0.1
 */