package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.protocal.protobuf.cbr;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "call", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends c<cbr>
{
  public static final a kOd;
  private final cbq kOc;
  private final b rr;
  
  static
  {
    AppMethodBeat.i(50809);
    kOd = new a((byte)0);
    AppMethodBeat.o(50809);
  }
  
  public e(cbq paramcbq)
  {
    AppMethodBeat.i(50808);
    this.kOc = paramcbq;
    paramcbq = new b.a();
    paramcbq.wg("/cgi-bin/mmbiz-bin/wxaapp/pregetwxadownloadurl");
    paramcbq.nB(1189);
    paramcbq.c((a)this.kOc);
    paramcbq.d((a)new cbr());
    paramcbq = paramcbq.atI();
    k.g(paramcbq, "rrb.buildInstance()");
    this.rr = paramcbq;
    c(this.rr);
    AppMethodBeat.o(50808);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo$Companion;", "", "()V", "TAG", "", "createRequest", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "appId", "oldAppVersion", "", "path", "isSupportWithoutLib", "", "userName", "supportedEncryptVersion", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.e
 * JD-Core Version:    0.7.0.1
 */