package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.gmk;
import com.tencent.mm.protocal.protobuf.gml;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeUpdateDeeplinkInfoResp;", "ticket", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.am.b<gml>
{
  public static final a tfJ;
  private final String hFb;
  private final int status;
  private final String tfK;
  
  static
  {
    AppMethodBeat.i(320013);
    tfJ = new a((byte)0);
    AppMethodBeat.o(320013);
  }
  
  private a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320002);
    this.hFb = paramString1;
    this.status = 3;
    this.tfK = paramString2;
    paramString2 = new c.a();
    gmk localgmk = new gmk();
    localgmk.status = this.status;
    paramString1 = this.tfK;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = com.tencent.mm.bx.b.bsj(paramString1))
    {
      localgmk.achz = paramString1;
      localgmk.achA = this.hFb;
      paramString1 = ah.aiuX;
      paramString2.otE = ((com.tencent.mm.bx.a)localgmk);
      paramString2.otF = ((com.tencent.mm.bx.a)new gml());
      paramString2.funcId = 2889;
      paramString2.uri = "/cgi-bin/mmbiz-bin/wxaruntime/updatedeeplinkinfo";
      paramString1 = ah.aiuX;
      c(paramString2.bEF());
      AppMethodBeat.o(320002);
      return;
    }
  }
  
  public final f<b.a<gml>> bFJ()
  {
    AppMethodBeat.i(320019);
    Log.i("MicroMsg.CgiRuntimeUpdateDeepLinkInfo", "run() ticket:" + this.hFb + " status:" + this.status + ", cgiHash[" + hashCode() + ']');
    f localf = super.bFJ();
    s.s(localf, "super.run()");
    AppMethodBeat.o(320019);
    return localf;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo$Companion;", "", "()V", "STATUS_CONSUMED", "", "STATUS_EXPIRED", "STATUS_FINISHED", "STATUS_INITIAL", "TAG", "", "confirm", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "ticket", "respData", "consume", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a eQ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(319913);
      s.u(paramString1, "ticket");
      paramString1 = new a(paramString1, paramString2, (byte)0);
      AppMethodBeat.o(319913);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a
 * JD-Core Version:    0.7.0.1
 */