package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.d.a.a.a.c.a;
import com.tencent.d.a.a.a.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/LiveCgiFactoryService;", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService;", "()V", "createCgiFinderGetLiveMsg", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "liveCookies", "", "liveId", "", "objectId", "nonceId", "scene", "", "offline", "", "clientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "reqVisitorRoleType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "uniqueId", "callback", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "seiData", "curBox", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  implements a
{
  public final com.tencent.mm.am.b<azp> a(atz paramatz, String paramString1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString2, int paramInt1, boolean paramBoolean, bgc parambgc, int paramInt2, bui parambui, String paramString3, a.b paramb, String paramString4, bfv parambfv, bma parambma)
  {
    AppMethodBeat.i(371258);
    s.u(paramatz, "finderBaseRequest");
    s.u(paramString2, "nonceId");
    s.u(parambui, "contextObj");
    s.u(paramb, "callback");
    paramatz = (com.tencent.mm.am.b)new b(paramatz, paramString1, paramArrayOfByte, paramLong1, paramLong2, paramString2, paramInt1, paramBoolean, parambgc, paramInt2, parambui, paramString3, paramb, paramString4, parambfv, parambma);
    AppMethodBeat.o(371258);
    return paramatz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.y
 * JD-Core Version:    0.7.0.1
 */