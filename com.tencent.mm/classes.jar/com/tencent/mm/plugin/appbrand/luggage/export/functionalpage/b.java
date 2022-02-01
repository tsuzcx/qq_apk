package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.drg;
import com.tencent.mm.protocal.protobuf.drh;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateRuntimeQrcodeResponse;", "uuid", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.al.a<drh>
{
  public static final a lOo;
  
  static
  {
    AppMethodBeat.i(50857);
    lOo = new a((byte)0);
    AppMethodBeat.o(50857);
  }
  
  private b(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(50856);
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    drg localdrg = new drg();
    localdrg.uuid = paramString1;
    localdrg.status = paramInt;
    localdrg.HEN = paramString2;
    locala.c((com.tencent.mm.bx.a)localdrg);
    locala.d((com.tencent.mm.bx.a)new drh());
    locala.oP(2578);
    locala.Dl("/cgi-bin/mmbiz-bin/wxabusiness/updateruntimeqrcode");
    c(locala.aDC());
    AppMethodBeat.o(50856);
  }
  
  public static final b Sb(String paramString)
  {
    AppMethodBeat.i(50858);
    p.h(paramString, "uuid");
    paramString = new b(paramString, 4);
    AppMethodBeat.o(50858);
    return paramString;
  }
  
  public static final b Sc(String paramString)
  {
    AppMethodBeat.i(50859);
    p.h(paramString, "uuid");
    paramString = new b(paramString, 1);
    AppMethodBeat.o(50859);
    return paramString;
  }
  
  public static final b dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50860);
    p.h(paramString1, "uuid");
    p.h(paramString2, "respData");
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(50860);
    return paramString1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode$Companion;", "", "()V", "CANCELLED", "", "CONFIRMED", "SCANNED", "TAG", "", "cancel", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "uuid", "confirm", "respData", "scanned", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b
 * JD-Core Version:    0.7.0.1
 */