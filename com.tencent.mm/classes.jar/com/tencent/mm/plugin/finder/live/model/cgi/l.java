package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.o;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "role", "", "nonceId", "sessionBuffer", "shareUserName", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "joinType", "joinLiveTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;", "(J[BLjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILcom/tencent/mm/protocal/protobuf/FinderJoinLiveTabTipsInfo;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class l
  extends n<awj>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private awi yjf;
  
  private l(long paramLong1, byte[] paramArrayOfByte, String paramString1, long paramLong2, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, bid parambid, int paramInt3, awk paramawk)
  {
    super(parambid);
    AppMethodBeat.i(270476);
    this.TAG = "Finder.CgiFinderJoinLive";
    this.yjf = new awi();
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    awi localawi = this.yjf;
    ao localao = ao.xcj;
    localawi.SDi = ao.a(parambid);
    this.yjf.liveId = paramLong1;
    this.yjf.xak = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yjf.finderUsername = paramString1;
    this.yjf.xbk = paramLong2;
    this.yjf.scene = paramInt1;
    this.yjf.object_nonce_id = paramString2;
    this.yjf.SHp = paramString3;
    this.yjf.SIM = paramInt3;
    this.yjf.SIN = paramString4;
    this.yjf.fUN = paramInt2;
    this.yjf.SIP = paramawk;
    this.xcu.put("liveId", paramLong1);
    this.xcu.put("finderUsername", paramString1);
    this.xcu.put("objectId", paramLong2);
    this.xcu.put("scene", paramInt1);
    this.xcu.put("joinType", paramInt3);
    paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = (c)paramArrayOfByte.business(c.class);
      if (paramArrayOfByte != null)
      {
        paramString1 = this.xcu;
        p.k(paramString1, "json");
        paramString1.put("_cLiveId", paramArrayOfByte.xbk);
        paramString1.put("_liveInfo", paramArrayOfByte.kiv);
      }
    }
    paramArrayOfByte = ao.xcj;
    paramArrayOfByte = this.yjf.SDi;
    label411:
    boolean bool;
    if (parambid != null)
    {
      paramInt2 = parambid.xkX;
      ao.a(paramArrayOfByte, j.listOf(new o(Integer.valueOf(paramInt2), Long.valueOf(paramLong2))));
      if (paramInt1 == 2)
      {
        paramArrayOfByte = d.Jcm;
        d.asyncReportFinderSecurityInfoThroughCgi(540999693);
      }
      paramString1 = this.TAG;
      paramString2 = new StringBuilder("living context: ");
      paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      paramArrayOfByte = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      if (paramArrayOfByte == null) {
        break label685;
      }
      paramArrayOfByte = (c)paramArrayOfByte.business(c.class);
      if (paramArrayOfByte == null) {
        break label685;
      }
      paramArrayOfByte = paramArrayOfByte.info();
      Log.i(paramString1, paramArrayOfByte);
      paramArrayOfByte = new d.a();
      paramArrayOfByte.c((com.tencent.mm.cd.a)this.yjf);
      paramString1 = new awj();
      paramString1.setBaseResponse(new jh());
      paramString1.getBaseResponse().Tef = new eaf();
      paramArrayOfByte.d((com.tencent.mm.cd.a)paramString1);
      paramArrayOfByte.TW("/cgi-bin/micromsg-bin/finderjoinlive");
      paramArrayOfByte.vD(3539);
      c(paramArrayOfByte.bgN());
      paramString1 = this.TAG;
      paramArrayOfByte = new StringBuilder("CgiFinderJoinLive init ").append(this.yjf.liveId).append(',').append(this.yjf.finderUsername).append(',').append(this.yjf.scene).append(",liveCookies is null:");
      if (this.yjf.xak != null) {
        break label690;
      }
      bool = true;
      label588:
      paramString2 = paramArrayOfByte.append(bool).append(',').append(" sessionBuffer:").append(this.yjf.SHp).append(", joinType:").append(this.yjf.SIM).append(" contextId:");
      paramArrayOfByte = this.yjf.SDi.SDu;
      if (paramArrayOfByte == null) {
        break label696;
      }
    }
    label685:
    label690:
    label696:
    for (paramArrayOfByte = paramArrayOfByte.wmL;; paramArrayOfByte = null)
    {
      Log.i(paramString1, paramArrayOfByte);
      AppMethodBeat.o(270476);
      return;
      paramInt2 = 0;
      break;
      paramArrayOfByte = null;
      break label411;
      bool = false;
      break label588;
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.l
 * JD-Core Version:    0.7.0.1
 */