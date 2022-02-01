package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.c.a.a.a.c.a;
import com.tencent.c.a.a.a.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/LiveCgiFactoryService;", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService;", "()V", "createCgiFinderGetLiveMsg", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "liveCookies", "", "liveId", "", "objectId", "nonceId", "scene", "", "offline", "", "clientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "reqVisitorRoleType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "callback", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "plugin-finder-live_release"})
public final class o
  implements a
{
  public final c<auv> a(aqe paramaqe, String paramString1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString2, int paramInt1, boolean paramBoolean, ayv paramayv, int paramInt2, bid parambid, a.b paramb)
  {
    AppMethodBeat.i(233517);
    p.k(paramaqe, "finderBaseRequest");
    p.k(paramString2, "nonceId");
    p.k(parambid, "contextObj");
    p.k(paramb, "callback");
    paramaqe = (c)new b(paramaqe, paramString1, paramArrayOfByte, paramLong1, paramLong2, paramString2, paramInt1, paramBoolean, paramayv, paramInt2, parambid, paramb);
    AppMethodBeat.o(233517);
    return paramaqe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.o
 * JD-Core Version:    0.7.0.1
 */