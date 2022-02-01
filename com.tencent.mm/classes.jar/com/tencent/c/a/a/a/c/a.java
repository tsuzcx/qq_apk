package com.tencent.c.a.a.a.c;

import com.tencent.mm.an.c;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.bid;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService;", "Lcom/tencent/mm/kernel/service/IService;", "createCgiFinderGetLiveMsg", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "liveCookies", "", "liveId", "", "objectId", "nonceId", "scene", "", "offline", "", "clientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "reqVisitorRoleType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "callback", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "IGetLiveMsgCallBack", "plugin-finder-live-api_release"})
public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract c<auv> a(aqe paramaqe, String paramString1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString2, int paramInt1, boolean paramBoolean, ayv paramayv, int paramInt2, bid parambid, b paramb);
  
  @l(iBK={1, 1, 16})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "reqVisitorRoleType", "plugin-finder-live-api_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, auv paramauv, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */