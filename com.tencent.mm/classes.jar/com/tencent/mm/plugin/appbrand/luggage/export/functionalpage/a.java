package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.co.f;
import com.tencent.mm.protocal.protobuf.fej;
import com.tencent.mm.protocal.protobuf.fek;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeUpdateDeeplinkInfoResp;", "ticket", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends c<fek>
{
  public static final a nap;
  private final String dHx;
  private final String nao;
  private final int status;
  
  static
  {
    AppMethodBeat.i(228831);
    nap = new a((byte)0);
    AppMethodBeat.o(228831);
  }
  
  private a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228830);
    this.dHx = paramString1;
    this.status = 3;
    this.nao = paramString2;
    paramString2 = new d.a();
    fej localfej = new fej();
    localfej.status = this.status;
    paramString1 = this.nao;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = b.bfZ(paramString1))
    {
      localfej.NzD = paramString1;
      localfej.NzE = this.dHx;
      paramString2.c((com.tencent.mm.bw.a)localfej);
      paramString2.d((com.tencent.mm.bw.a)new fek());
      paramString2.sG(2889);
      paramString2.MB("/cgi-bin/mmbiz-bin/wxaruntime/updatedeeplinkinfo");
      c(paramString2.aXF());
      AppMethodBeat.o(228830);
      return;
    }
  }
  
  public final f<c.a<fek>> aYI()
  {
    AppMethodBeat.i(228828);
    Log.i("MicroMsg.CgiRuntimeUpdateDeepLinkInfo", "run() ticket:" + this.dHx + " status:" + this.status + ", cgiHash[" + hashCode() + ']');
    f localf = super.aYI();
    p.g(localf, "super.run()");
    AppMethodBeat.o(228828);
    return localf;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo$Companion;", "", "()V", "STATUS_CONSUMED", "", "STATUS_EXPIRED", "STATUS_FINISHED", "STATUS_INITIAL", "TAG", "", "confirm", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "ticket", "respData", "consume", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a el(String paramString1, String paramString2)
    {
      AppMethodBeat.i(228827);
      p.h(paramString1, "ticket");
      paramString1 = new a(paramString1, paramString2, (byte)0);
      AppMethodBeat.o(228827);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a
 * JD-Core Version:    0.7.0.1
 */