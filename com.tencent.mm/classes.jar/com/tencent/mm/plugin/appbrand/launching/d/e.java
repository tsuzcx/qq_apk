package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.protocal.protobuf.cgt;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "call", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends c<cgt>
{
  public static final a lpC;
  private final cgs lpB;
  private final b rr;
  
  static
  {
    AppMethodBeat.i(50809);
    lpC = new a((byte)0);
    AppMethodBeat.o(50809);
  }
  
  public e(cgs paramcgs)
  {
    AppMethodBeat.i(50808);
    this.lpB = paramcgs;
    paramcgs = new b.a();
    paramcgs.Am("/cgi-bin/mmbiz-bin/wxaapp/pregetwxadownloadurl");
    paramcgs.op(1189);
    paramcgs.c((a)this.lpB);
    paramcgs.d((a)new cgt());
    paramcgs = paramcgs.aAz();
    k.g(paramcgs, "rrb.buildInstance()");
    this.rr = paramcgs;
    c(this.rr);
    AppMethodBeat.o(50808);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "appId", "oldAppVersion", "", "path", "isSupportWithoutLib", "", "userName", "supportedEncryptVersion", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.e
 * JD-Core Version:    0.7.0.1
 */