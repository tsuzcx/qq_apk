package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.cn.f;
import com.tencent.mm.protocal.protobuf.ehz;
import com.tencent.mm.protocal.protobuf.eia;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeUpdateDeeplinkInfoResp;", "ticket", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.al.a<eia>
{
  public static final a lOn;
  private final String dpf;
  private final String lOm;
  private final int status;
  
  static
  {
    AppMethodBeat.i(189352);
    lOn = new a((byte)0);
    AppMethodBeat.o(189352);
  }
  
  private a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189351);
    this.dpf = paramString1;
    this.status = 3;
    this.lOm = paramString2;
    paramString2 = new b.a();
    ehz localehz = new ehz();
    localehz.status = this.status;
    paramString1 = this.lOm;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = b.aNZ(paramString1))
    {
      localehz.HSu = paramString1;
      localehz.HSv = this.dpf;
      paramString2.c((com.tencent.mm.bx.a)localehz);
      paramString2.d((com.tencent.mm.bx.a)new eia());
      paramString2.oP(2889);
      paramString2.Dl("/cgi-bin/mmbiz-bin/wxaruntime/updatedeeplinkinfo");
      c(paramString2.aDC());
      AppMethodBeat.o(189351);
      return;
    }
  }
  
  public final f<com.tencent.mm.al.a.a<eia>> aED()
  {
    AppMethodBeat.i(189349);
    ad.i("MicroMsg.CgiRuntimeUpdateDeepLinkInfo", "run() ticket:" + this.dpf + " status:" + this.status + ", cgiHash[" + hashCode() + ']');
    f localf = super.aED();
    p.g(localf, "super.run()");
    AppMethodBeat.o(189349);
    return localf;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo$Companion;", "", "()V", "STATUS_CONSUMED", "", "STATUS_EXPIRED", "STATUS_FINISHED", "STATUS_INITIAL", "TAG", "", "confirm", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "ticket", "respData", "consume", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a dS(String paramString1, String paramString2)
    {
      AppMethodBeat.i(189348);
      p.h(paramString1, "ticket");
      paramString1 = new a(paramString1, paramString2, (byte)0);
      AppMethodBeat.o(189348);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a
 * JD-Core Version:    0.7.0.1
 */