package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.emb;
import com.tencent.mm.protocal.protobuf.emc;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateRuntimeQrcodeResponse;", "uuid", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-appbrand-integration_release"})
public final class b
  extends c<emc>
{
  public static final a naq;
  
  static
  {
    AppMethodBeat.i(50857);
    naq = new a((byte)0);
    AppMethodBeat.o(50857);
  }
  
  private b(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(50856);
    d.a locala = new d.a();
    emb localemb = new emb();
    localemb.uuid = paramString1;
    localemb.status = paramInt;
    localemb.NkH = paramString2;
    locala.c((a)localemb);
    locala.d((a)new emc());
    locala.sG(2578);
    locala.MB("/cgi-bin/mmbiz-bin/wxabusiness/updateruntimeqrcode");
    c(locala.aXF());
    AppMethodBeat.o(50856);
  }
  
  public static final b acs(String paramString)
  {
    AppMethodBeat.i(50858);
    p.h(paramString, "uuid");
    paramString = new b(paramString, 4);
    AppMethodBeat.o(50858);
    return paramString;
  }
  
  public static final b act(String paramString)
  {
    AppMethodBeat.i(50859);
    p.h(paramString, "uuid");
    paramString = new b(paramString, 1);
    AppMethodBeat.o(50859);
    return paramString;
  }
  
  public static final b em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50860);
    p.h(paramString1, "uuid");
    p.h(paramString2, "respData");
    paramString1 = new b(paramString1, paramString2);
    AppMethodBeat.o(50860);
    return paramString1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode$Companion;", "", "()V", "CANCELLED", "", "CONFIRMED", "SCANNED", "TAG", "", "cancel", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiUpdateRuntimeQrcode;", "uuid", "confirm", "respData", "scanned", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.b
 * JD-Core Version:    0.7.0.1
 */