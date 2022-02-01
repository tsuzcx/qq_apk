package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.networking.b;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/CgiPreGetPkgDownloadInfo;", "Lcom/tencent/mm/plugin/appbrand/networking/AppBrandCgiWithSpeedReport;", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlResponse;", "req", "Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;)V", "getReq", "()Lcom/tencent/mm/protocal/protobuf/PreGetDownloadUrlRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getRr", "()Lcom/tencent/mm/modelbase/CommReqResp;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends b<ege>
{
  public static final e.a tdQ;
  private final c rr;
  private final egd tdR;
  
  static
  {
    AppMethodBeat.i(50809);
    tdQ = new e.a((byte)0);
    AppMethodBeat.o(50809);
  }
  
  public e(egd paramegd)
  {
    super(paramegd.appid, paramegd.username);
    AppMethodBeat.i(50808);
    this.tdR = paramegd;
    paramegd = new c.a();
    paramegd.uri = "/cgi-bin/mmbiz-bin/wxaapp/pregetwxadownloadurl";
    paramegd.funcId = 1189;
    paramegd.otE = ((a)this.tdR);
    paramegd.otF = ((a)new ege());
    paramegd = paramegd.bEF();
    s.s(paramegd, "rrb.buildInstance()");
    this.rr = paramegd;
    c(this.rr);
    AppMethodBeat.o(50808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.e
 * JD-Core Version:    0.7.0.1
 */