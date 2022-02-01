package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.cm.f;
import com.tencent.mm.protocal.protobuf.ejq;
import com.tencent.mm.protocal.protobuf.ejr;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeUpdateDeeplinkInfoResp;", "ticket", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.ak.a<ejr>
{
  public static final a lSO;
  private final String dqk;
  private final String lSN;
  private final int status;
  
  static
  {
    AppMethodBeat.i(223612);
    lSO = new a((byte)0);
    AppMethodBeat.o(223612);
  }
  
  private a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223611);
    this.dqk = paramString1;
    this.status = 3;
    this.lSN = paramString2;
    paramString2 = new b.a();
    ejq localejq = new ejq();
    localejq.status = this.status;
    paramString1 = this.lSN;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = b.aPw(paramString1))
    {
      localejq.ImB = paramString1;
      localejq.ImC = this.dqk;
      paramString2.c((com.tencent.mm.bw.a)localejq);
      paramString2.d((com.tencent.mm.bw.a)new ejr());
      paramString2.oS(2889);
      paramString2.DN("/cgi-bin/mmbiz-bin/wxaruntime/updatedeeplinkinfo");
      c(paramString2.aDS());
      AppMethodBeat.o(223611);
      return;
    }
  }
  
  public final f<com.tencent.mm.ak.a.a<ejr>> aET()
  {
    AppMethodBeat.i(223609);
    ae.i("MicroMsg.CgiRuntimeUpdateDeepLinkInfo", "run() ticket:" + this.dqk + " status:" + this.status + ", cgiHash[" + hashCode() + ']');
    f localf = super.aET();
    p.g(localf, "super.run()");
    AppMethodBeat.o(223609);
    return localf;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo$Companion;", "", "()V", "STATUS_CONSUMED", "", "STATUS_EXPIRED", "STATUS_FINISHED", "STATUS_INITIAL", "TAG", "", "confirm", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "ticket", "respData", "consume", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a dU(String paramString1, String paramString2)
    {
      AppMethodBeat.i(223608);
      p.h(paramString1, "ticket");
      paramString1 = new a(paramString1, paramString2, (byte)0);
      AppMethodBeat.o(223608);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a
 * JD-Core Version:    0.7.0.1
 */