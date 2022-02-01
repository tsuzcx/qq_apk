package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.protocal.protobuf.cls;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends com.tencent.mm.plugin.appbrand.networking.a<cls>
{
  public static final a lMV;
  private final clr lMU;
  private final b rr;
  
  static
  {
    AppMethodBeat.i(50809);
    lMV = new a((byte)0);
    AppMethodBeat.o(50809);
  }
  
  public e(clr paramclr)
  {
    super(paramclr.duW, paramclr.username);
    AppMethodBeat.i(50808);
    this.lMU = paramclr;
    paramclr = new b.a();
    paramclr.Dl("/cgi-bin/mmbiz-bin/wxaapp/pregetwxadownloadurl");
    paramclr.oP(1189);
    paramclr.c((com.tencent.mm.bx.a)this.lMU);
    paramclr.d((com.tencent.mm.bx.a)new cls());
    paramclr = paramclr.aDC();
    p.g(paramclr, "rrb.buildInstance()");
    this.rr = paramclr;
    c(this.rr);
    AppMethodBeat.o(50808);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "appId", "oldAppVersion", "", "path", "isSupportWithoutLib", "", "userName", "supportedEncryptVersion", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.e
 * JD-Core Version:    0.7.0.1
 */