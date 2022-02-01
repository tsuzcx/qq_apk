package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLikeLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveResp;", "finderBaseRequest", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "liveCookie", "", "liveId", "", "count", "", "objectId", "scene", "nonceId", "", "finderUsername", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;[BJIJILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getCount", "()I", "getLiveId", "()J", "getObjectId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeLiveReq;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class m
  extends n<awt>
{
  private final String TAG;
  private final int count;
  private final long liveId;
  private final long xbk;
  private aws yjg;
  
  public m(aqe paramaqe, byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2, String paramString1, String paramString2, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(280138);
    this.liveId = paramLong1;
    this.count = paramInt;
    this.xbk = paramLong2;
    this.TAG = "Finder.CgiFinderLikeLive";
    this.yjg = new aws();
    this.yjg.RLM = paramaqe;
    this.yjg.klE = this.liveId;
    this.yjg.RLO = b.cU(paramArrayOfByte);
    this.yjg.object_id = this.xbk;
    this.yjg.seq = 0L;
    this.yjg.SJr = 0;
    paramaqe = this.yjg;
    paramArrayOfByte = aj.AGc;
    paramaqe.SJs = aj.eet();
    this.yjg.count = this.count;
    this.yjg.scene = 1;
    this.yjg.object_nonce_id = paramString1;
    this.yjg.RLN = paramString2;
    paramaqe = ao.xcj;
    paramaqe = this.yjg.RLM;
    boolean bool;
    if (parambid != null)
    {
      paramInt = parambid.fGo;
      ao.a(paramaqe, j.listOf(new o(Integer.valueOf(paramInt), Long.valueOf(this.xbk))));
      paramaqe = new d.a();
      paramaqe.c((a)this.yjg);
      paramArrayOfByte = new awt();
      paramArrayOfByte.setBaseResponse(new jh());
      paramArrayOfByte.getBaseResponse().Tef = new eaf();
      paramaqe.d((a)paramArrayOfByte);
      paramaqe.TW("/cgi-bin/micromsg-bin/finderlikelive");
      paramaqe.vD(564);
      c(paramaqe.bgN());
      paramArrayOfByte = this.TAG;
      paramaqe = new StringBuilder("[likeInfo]like live id:").append(this.liveId).append(" objectId:").append(this.xbk).append(" count:").append(this.count).append(",finder_username is empty:");
      if (this.yjg.RLN != null) {
        break label430;
      }
      bool = true;
      label372:
      paramString1 = paramaqe.append(bool).append(",live_identity:");
      paramaqe = this.yjg.RLM;
      if (paramaqe == null) {
        break label436;
      }
    }
    label430:
    label436:
    for (paramaqe = Integer.valueOf(paramaqe.SDv);; paramaqe = null)
    {
      Log.i(paramArrayOfByte, paramaqe);
      AppMethodBeat.o(280138);
      return;
      paramInt = 0;
      break;
      bool = false;
      break label372;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.m
 * JD-Core Version:    0.7.0.1
 */