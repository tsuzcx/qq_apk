package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "liveId", "", "objectId", "rewardProductId", "", "rewardProductCount", "", "username", "wecoin", "requestId", "comboId", "sendGiftTargetUserName", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "sessionBuffer", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "(JJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardRequest;", "requestExt", "Lorg/json/JSONObject;", "actionExt", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ai
  extends n<bce>
{
  private final String TAG;
  private final JSONObject xcu;
  private bcd ykb;
  private final a ykc;
  
  public ai(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, bid parambid, String paramString6, a parama)
  {
    AppMethodBeat.i(267309);
    this.ykc = parama;
    this.TAG = "Finder.CgiFinderLiveReward";
    this.xcu = new JSONObject();
    this.ykb = new bcd();
    int i = paramInt2 * paramInt1;
    parama = this.ykb;
    ao localao = ao.xcj;
    parama.RLM = ao.a(parambid);
    this.ykb.klE = paramLong1;
    this.ykb.object_id = paramLong2;
    this.ykb.SKd = paramString1;
    this.ykb.SKo = paramInt1;
    this.ykb.SKp = i;
    this.ykb.RLN = paramString2;
    this.ykb.request_id = paramString3;
    this.ykb.SKg = paramString4;
    this.ykb.SNG = paramString5;
    this.ykb.SHp = paramString6;
    this.xcu.put("reward_product_id", this.ykb.SKd);
    this.xcu.put("reward_product_count", this.ykb.SKo);
    paramString4 = this.TAG;
    paramString2 = new StringBuilder("liveId:").append(paramLong1).append(" objectId:").append(paramLong2).append(" rewardProductId:").append(paramString1).append(" rewardProductCount:").append(paramInt1).append(" fromUser:").append(paramString2).append(" toUser:").append(paramString5).append(" requestId:").append(paramString3).append(" wecoin:").append(paramInt2).append(",amountPrice:").append(i).append(",live_identity:");
    paramString1 = this.ykb.RLM;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.SDv);; paramString1 = null)
    {
      Log.i(paramString4, paramString1);
      d.Jcm.jq(540999695, 7);
      paramString1 = new d.a();
      paramString1.c((a)this.ykb);
      paramString2 = new bce();
      paramString2.setBaseResponse(new jh());
      paramString2.getBaseResponse().Tef = new eaf();
      paramString1.d((a)paramString2);
      paramString1.TW("/cgi-bin/micromsg-bin/finderlivereward");
      paramString1.vD(5891);
      c(paramString1.bgN());
      AppMethodBeat.o(267309);
      return;
    }
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bce parambce);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ai
 * JD-Core Version:    0.7.0.1
 */