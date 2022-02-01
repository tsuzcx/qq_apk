package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.d.a.a.a.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.live.model.cgi.o;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderGetLiveMsg;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "finderUsername", "", "liveCookies", "", "liveId", "", "objectId", "nonceId", "scene", "", "offline", "", "clientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "reqVisitorRoleType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "uniqueId", "callback", "Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;", "seiData", "curBox", "Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;", "liveReportObj", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;Ljava/lang/String;[BJJLjava/lang/String;IZLcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;Lcom/tencent/plugin/finder/live/api/service/ILiveCgiFactoryService$IGetLiveMsgCallBack;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveBoxId;Lcom/tencent/mm/protocal/protobuf/FinderLiveReportBaseInfo;)V", "TAG", "getReqVisitorRoleType", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgReq;", "getUniqueId", "()Ljava/lang/String;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends o<azp>
{
  private final int CuT;
  private a.b CuU;
  private azo CuV;
  private final String TAG;
  private final String hTs;
  
  public b(atz paramatz, String paramString1, byte[] paramArrayOfByte, long paramLong1, long paramLong2, String paramString2, int paramInt1, boolean paramBoolean, bgc parambgc, int paramInt2, bui parambui, String paramString3, a.b paramb, String paramString4, bfv parambfv, bma parambma)
  {
    super(parambui);
    AppMethodBeat.i(371260);
    this.CuT = paramInt2;
    this.hTs = paramString3;
    this.TAG = "Finder.CgiFinderGetLiveMsg";
    this.CuU = paramb;
    this.CuV = new azo();
    this.CuV.ZEc = paramatz;
    this.CuV.finderUsername = paramString1;
    this.CuV.Ayh = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CuV.liveId = paramLong1;
    this.CuV.hKN = paramLong2;
    this.CuV.object_nonce_id = paramString2;
    this.CuV.scene = paramInt1;
    this.CuV.LXS = paramBoolean;
    this.CuV.ZJI = parambgc;
    this.CuV.ZJM = parambfv;
    this.CuV.ZIR = parambma;
    if (paramString4 != null)
    {
      this.CuV.ZJJ = com.tencent.mm.bx.b.bsj(paramString4);
      paramatz = bi.ABn;
      bi.a(this.CuV.ZEc, p.listOf(new r(Integer.valueOf(parambui.AJo), Long.valueOf(paramLong2))));
      paramatz = new c.a();
      paramatz.otE = ((a)this.CuV);
      paramString1 = new azp();
      paramString1.setBaseResponse(new kd());
      paramString1.getBaseResponse().akjO = new etl();
      paramatz.otF = ((a)paramString1);
      paramatz.uri = "/cgi-bin/micromsg-bin/findergetlivemsg";
      paramatz.funcId = 3976;
      paramatz.longPolling = true;
      paramatz.longPollingTimeout = 25000;
      c(paramatz.bEF());
      paramatz = this.TAG;
      paramString1 = new StringBuilder("CgiFinderGetLiveMsg init ").append(this.CuV.liveId).append(',').append(this.CuV.finderUsername).append(',').append(this.CuV.scene).append(",liveCookies is null:");
      if (this.CuV.Ayh != null) {
        break label468;
      }
    }
    label468:
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i(paramatz, paramBoolean + ",reqVisitorRoleType:" + this.CuT + ", request.offline:" + this.CuV.LXS + ", uniqueId:" + this.hTs);
      AppMethodBeat.o(371260);
      return;
      Log.e(this.TAG, "ljd live sei is empty");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.b
 * JD-Core Version:    0.7.0.1
 */