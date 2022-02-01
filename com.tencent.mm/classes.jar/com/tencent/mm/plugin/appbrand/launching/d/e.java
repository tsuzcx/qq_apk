package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends b<ddz>
{
  public static final a mYF;
  private final ddy mYE;
  private final d rr;
  
  static
  {
    AppMethodBeat.i(50809);
    mYF = new a((byte)0);
    AppMethodBeat.o(50809);
  }
  
  public e(ddy paramddy)
  {
    super(paramddy.dNI, paramddy.username);
    AppMethodBeat.i(50808);
    this.mYE = paramddy;
    paramddy = new d.a();
    paramddy.MB("/cgi-bin/mmbiz-bin/wxaapp/pregetwxadownloadurl");
    paramddy.sG(1189);
    paramddy.c((a)this.mYE);
    paramddy.d((a)new ddz());
    paramddy = paramddy.aXF();
    p.g(paramddy, "rrb.buildInstance()");
    this.rr = paramddy;
    c(this.rr);
    AppMethodBeat.o(50808);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "appId", "oldAppVersion", "", "path", "isSupportWithoutLib", "", "userName", "supportedEncryptVersion", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.e
 * JD-Core Version:    0.7.0.1
 */