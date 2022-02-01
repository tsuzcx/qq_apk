package com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.brandservice.api.TransferRequestInfo;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.dew;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/request/ExtTransferRequester;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/request/BaseTransferRequester;", "tokenManager", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/ITransferRequestTokenManager;)V", "getRequest", "Lcom/tencent/mm/modelbase/CommReqResp;", "transferRequestInfo", "Lcom/tencent/mm/plugin/brandservice/api/TransferRequestInfo;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/JsApiResponse;", "rr", "tag", "", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final a vWp;
  
  static
  {
    AppMethodBeat.i(303055);
    vWp = new a((byte)0);
    AppMethodBeat.o(303055);
  }
  
  public b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a parama)
  {
    super(parama);
    AppMethodBeat.i(303050);
    AppMethodBeat.o(303050);
  }
  
  protected final c b(TransferRequestInfo paramTransferRequestInfo)
  {
    AppMethodBeat.i(303059);
    s.u(paramTransferRequestInfo, "transferRequestInfo");
    cyd localcyd = new cyd();
    localcyd.YAb = paramTransferRequestInfo.url;
    localcyd.aaDg = paramTransferRequestInfo.vBk;
    localcyd.scope = paramTransferRequestInfo.scope;
    localcyd.aaDf = paramTransferRequestInfo.vBm;
    localcyd.aaDi = 400;
    dev localdev = paramTransferRequestInfo.vBl;
    paramTransferRequestInfo = localdev;
    if (localdev == null) {
      paramTransferRequestInfo = new dev();
    }
    localcyd.aaDh = paramTransferRequestInfo;
    paramTransferRequestInfo = new c.a();
    paramTransferRequestInfo.otE = ((com.tencent.mm.bx.a)localcyd);
    paramTransferRequestInfo.otF = ((com.tencent.mm.bx.a)new cye());
    paramTransferRequestInfo.uri = "/cgi-bin/micromsg-bin/h5exttransfer";
    paramTransferRequestInfo.funcId = 6673;
    paramTransferRequestInfo.otG = 0;
    paramTransferRequestInfo.respCmdId = 0;
    paramTransferRequestInfo = paramTransferRequestInfo.bEF();
    s.s(paramTransferRequestInfo, "Builder().apply {\n      …        }.buildInstance()");
    AppMethodBeat.o(303059);
    return paramTransferRequestInfo;
  }
  
  protected final String dgV()
  {
    return "h5ExtTransfer";
  }
  
  protected final dew g(c paramc)
  {
    AppMethodBeat.i(303063);
    if (paramc == null)
    {
      paramc = null;
      if (!(paramc instanceof cye)) {
        break label45;
      }
    }
    label45:
    for (paramc = (cye)paramc;; paramc = null)
    {
      if (paramc != null) {
        break label50;
      }
      AppMethodBeat.o(303063);
      return null;
      paramc = c.c.b(paramc.otC);
      break;
    }
    label50:
    paramc = paramc.aaDj;
    AppMethodBeat.o(303063);
    return paramc;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/transfer/request/ExtTransferRequester$Companion;", "", "()V", "TAG", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.a.b
 * JD-Core Version:    0.7.0.1
 */