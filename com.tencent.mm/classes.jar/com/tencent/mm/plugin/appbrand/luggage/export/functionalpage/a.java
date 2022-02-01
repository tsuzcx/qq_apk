package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.cw.f;
import com.tencent.mm.protocal.protobuf.fpk;
import com.tencent.mm.protocal.protobuf.fpl;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/WxaRuntimeUpdateDeeplinkInfoResp;", "ticket", "", "status", "", "respData", "(Ljava/lang/String;ILjava/lang/String;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends c<fpl>
{
  public static final a qaE;
  private final String fAo;
  private final String qaD;
  private final int status;
  
  static
  {
    AppMethodBeat.i(277841);
    qaE = new a((byte)0);
    AppMethodBeat.o(277841);
  }
  
  private a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(277840);
    this.fAo = paramString1;
    this.status = 3;
    this.qaD = paramString2;
    paramString2 = new d.a();
    fpk localfpk = new fpk();
    localfpk.status = this.status;
    paramString1 = this.qaD;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = b.bss(paramString1))
    {
      localfpk.UNf = paramString1;
      localfpk.UNg = this.fAo;
      paramString2.c((com.tencent.mm.cd.a)localfpk);
      paramString2.d((com.tencent.mm.cd.a)new fpl());
      paramString2.vD(2889);
      paramString2.TW("/cgi-bin/mmbiz-bin/wxaruntime/updatedeeplinkinfo");
      c(paramString2.bgN());
      AppMethodBeat.o(277840);
      return;
    }
  }
  
  public final f<c.a<fpl>> bhW()
  {
    AppMethodBeat.i(277838);
    Log.i("MicroMsg.CgiRuntimeUpdateDeepLinkInfo", "run() ticket:" + this.fAo + " status:" + this.status + ", cgiHash[" + hashCode() + ']');
    f localf = super.bhW();
    p.j(localf, "super.run()");
    AppMethodBeat.o(277838);
    return localf;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo$Companion;", "", "()V", "STATUS_CONSUMED", "", "STATUS_EXPIRED", "STATUS_FINISHED", "STATUS_INITIAL", "TAG", "", "confirm", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/CgiRuntimeUpdateDeepLinkInfo;", "ticket", "respData", "consume", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a ez(String paramString1, String paramString2)
    {
      AppMethodBeat.i(281195);
      p.k(paramString1, "ticket");
      paramString1 = new a(paramString1, paramString2, (byte)0);
      AppMethodBeat.o(281195);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a
 * JD-Core Version:    0.7.0.1
 */