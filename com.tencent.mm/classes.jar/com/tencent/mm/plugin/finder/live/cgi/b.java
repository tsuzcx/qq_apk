package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.c.a.a.a.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.live.model.cgi.n;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderGetLiveMsg;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "liveCookies", "", "liveId", "", "objectId", "nonceId", "scene", "", "offline", "", "clientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "reqVisitorRoleType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "callback", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;[BJJLjava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;)V", "TAG", "getReqVisitorRoleType", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"})
public final class b
  extends n<auv>
{
  private final String TAG;
  private a.b xXN;
  private auu xXO;
  private final int xXP;
  
  public b(aqe paramaqe, String paramString1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString2, int paramInt1, boolean paramBoolean, ayv paramayv, int paramInt2, bid parambid, a.b paramb)
  {
    super(parambid);
    AppMethodBeat.i(233965);
    this.xXP = paramInt2;
    this.TAG = "Finder.CgiFinderGetLiveMsg";
    this.xXN = paramb;
    this.xXO = new auu();
    this.xXO.SDi = paramaqe;
    this.xXO.finderUsername = paramString1;
    this.xXO.xak = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.xXO.liveId = paramLong1;
    this.xXO.xbk = paramLong2;
    this.xXO.object_nonce_id = paramString2;
    this.xXO.scene = paramInt1;
    this.xXO.Gch = paramBoolean;
    this.xXO.SGQ = paramayv;
    paramaqe = ao.xcj;
    ao.a(this.xXO.SDi, j.listOf(new o(Integer.valueOf(parambid.xkX), Long.valueOf(paramLong2))));
    paramaqe = new d.a();
    paramaqe.c((a)this.xXO);
    paramString1 = new auv();
    paramString1.setBaseResponse(new jh());
    paramString1.getBaseResponse().Tef = new eaf();
    paramaqe.d((a)paramString1);
    paramaqe.TW("/cgi-bin/micromsg-bin/findergetlivemsg");
    paramaqe.vD(3976);
    paramaqe.bia();
    paramaqe.bib();
    c(paramaqe.bgN());
    paramaqe = this.TAG;
    paramString1 = new StringBuilder("CgiFinderGetLiveMsg init ").append(this.xXO.liveId).append(',').append(this.xXO.finderUsername).append(',').append(this.xXO.scene).append(",liveCookies is null:");
    if (this.xXO.xak == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i(paramaqe, paramBoolean + ",reqVisitorRoleType:" + this.xXP);
      AppMethodBeat.o(233965);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.b
 * JD-Core Version:    0.7.0.1
 */