package com.tencent.d.a.a.a.c;

import com.tencent.mm.am.b;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bui;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService;", "Lcom/tencent/mm/kernel/service/IService;", "createCgiFinderGetLiveMsg", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "liveCookies", "", "liveId", "", "objectId", "nonceId", "scene", "", "offline", "", "clientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "reqVisitorRoleType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "uniqueId", "callback", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "seiData", "curBox", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "IGetLiveMsgCallBack", "IGetLiveMsgOffsetCallBack", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract b<azp> a(atz paramatz, String paramString1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString2, int paramInt1, boolean paramBoolean, bgc parambgc, int paramInt2, bui parambui, String paramString3, b paramb, String paramString4, bfv parambfv, bma parambma);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "reqVisitorRoleType", "uniqueId", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2, azp paramazp, int paramInt3, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.a.a.c.a
 * JD-Core Version:    0.7.0.1
 */