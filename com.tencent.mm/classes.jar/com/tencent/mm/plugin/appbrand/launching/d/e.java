package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.cmm;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends com.tencent.mm.plugin.appbrand.networking.b<cmm>
{
  public static final a lRw;
  private final cml lRv;
  private final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(50809);
    lRw = new a((byte)0);
    AppMethodBeat.o(50809);
  }
  
  public e(cml paramcml)
  {
    super(paramcml.dwb, paramcml.username);
    AppMethodBeat.i(50808);
    this.lRv = paramcml;
    paramcml = new b.a();
    paramcml.DN("/cgi-bin/mmbiz-bin/wxaapp/pregetwxadownloadurl");
    paramcml.oS(1189);
    paramcml.c((a)this.lRv);
    paramcml.d((a)new cmm());
    paramcml = paramcml.aDS();
    p.g(paramcml, "rrb.buildInstance()");
    this.rr = paramcml;
    c(this.rr);
    AppMethodBeat.o(50808);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "appId", "oldAppVersion", "", "path", "isSupportWithoutLib", "", "userName", "supportedEncryptVersion", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.e
 * JD-Core Version:    0.7.0.1
 */