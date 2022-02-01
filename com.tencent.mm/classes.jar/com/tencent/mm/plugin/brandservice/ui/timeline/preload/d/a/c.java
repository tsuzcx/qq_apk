package com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dew;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/request/WebTransferRequester;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/request/BaseTransferRequester;", "tokenManager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;)V", "getRequest", "Lcom/tencent/mm/modelbase/CommReqResp;", "transferRequestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "rr", "tag", "", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final a vWq;
  
  static
  {
    AppMethodBeat.i(303056);
    vWq = new a((byte)0);
    AppMethodBeat.o(303056);
  }
  
  public c(com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a parama)
  {
    super(parama);
    AppMethodBeat.i(303053);
    AppMethodBeat.o(303053);
  }
  
  protected final com.tencent.mm.am.c b(TransferRequestInfo paramTransferRequestInfo)
  {
    AppMethodBeat.i(303061);
    s.u(paramTransferRequestInfo, "transferRequestInfo");
    cyg localcyg = new cyg();
    localcyg.YAb = paramTransferRequestInfo.url;
    localcyg.aaDg = paramTransferRequestInfo.vBk;
    localcyg.scope = paramTransferRequestInfo.scope;
    localcyg.aaDf = paramTransferRequestInfo.vBm;
    localcyg.aaDi = 400;
    dev localdev = paramTransferRequestInfo.vBl;
    paramTransferRequestInfo = localdev;
    if (localdev == null) {
      paramTransferRequestInfo = new dev();
    }
    localcyg.aaDh = paramTransferRequestInfo;
    paramTransferRequestInfo = new com.tencent.mm.am.c.a();
    paramTransferRequestInfo.otE = ((com.tencent.mm.bx.a)localcyg);
    paramTransferRequestInfo.otF = ((com.tencent.mm.bx.a)new cyh());
    paramTransferRequestInfo.uri = "/cgi-bin/micromsg-bin/h5webtransfer";
    paramTransferRequestInfo.funcId = 6601;
    paramTransferRequestInfo.otG = 0;
    paramTransferRequestInfo.respCmdId = 0;
    paramTransferRequestInfo = paramTransferRequestInfo.bEF();
    s.s(paramTransferRequestInfo, "Builder().apply {\n      …        }.buildInstance()");
    AppMethodBeat.o(303061);
    return paramTransferRequestInfo;
  }
  
  protected final String dgV()
  {
    return "h5WebTransfer";
  }
  
  protected final dew g(com.tencent.mm.am.c paramc)
  {
    AppMethodBeat.i(303066);
    if (paramc == null)
    {
      paramc = null;
      if (!(paramc instanceof cyh)) {
        break label45;
      }
    }
    label45:
    for (paramc = (cyh)paramc;; paramc = null)
    {
      if (paramc != null) {
        break label50;
      }
      AppMethodBeat.o(303066);
      return null;
      paramc = c.c.b(paramc.otC);
      break;
    }
    label50:
    paramc = paramc.aaDj;
    AppMethodBeat.o(303066);
    return paramc;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/request/WebTransferRequester$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a.c
 * JD-Core Version:    0.7.0.1
 */