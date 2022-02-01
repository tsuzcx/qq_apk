package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "liveId", "", "objectId", "rewardProductId", "", "rewardProductCount", "", "username", "wecoin", "requestId", "comboId", "sendGiftTargetUserName", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "sessionBuffer", "rewardType", "rewardExtInfo", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "(JJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/String;ILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardRequest;", "requestExt", "Lorg/json/JSONObject;", "actionExt", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
  extends o<bmf>
{
  public static final ar.b CKv;
  private final JSONObject ABH;
  private final a CKw;
  private bme CKx;
  
  static
  {
    AppMethodBeat.i(360216);
    CKv = new ar.b((byte)0);
    AppMethodBeat.o(360216);
  }
  
  public ar(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, bui parambui, String paramString6, int paramInt3, b paramb, a parama)
  {
    AppMethodBeat.i(360212);
    this.CKw = parama;
    this.ABH = new JSONObject();
    this.CKx = new bme();
    int i = paramInt2 * paramInt1;
    parama = this.CKx;
    bi localbi = bi.ABn;
    parama.YIY = bi.a(parambui);
    this.CKx.mMJ = paramLong1;
    this.CKx.object_id = paramLong2;
    this.CKx.ZOC = paramString1;
    this.CKx.ZOS = paramInt1;
    this.CKx.ZOT = i;
    this.CKx.YIZ = paramString2;
    this.CKx.request_id = paramString3;
    this.CKx.ZOF = paramString4;
    this.CKx.ZUW = paramString5;
    this.CKx.ZJK = paramString6;
    this.CKx.ZKO = paramInt3;
    this.CKx.ZRb = paramb;
    this.ABH.put("reward_product_id", this.CKx.ZOC);
    this.ABH.put("reward_product_count", this.CKx.ZOS);
    paramString4 = new StringBuilder();
    paramString2 = paramString4.append("liveId:").append(paramLong1).append(" objectId:").append(paramLong2).append(" rewardProductId:").append(paramString1).append(" rewardProductCount:").append(paramInt1).append(" fromUser:").append(paramString2).append(" toUser:").append(paramString5).append(" requestId:").append(paramString3).append(" wecoin:").append(paramInt2).append(",amountPrice:").append(i).append(", reward_type:").append(paramInt3).append(",reward_ext_info:");
    if (paramb == null)
    {
      paramString1 = null;
      paramString2.append(paramString1).append(",live_identity:");
      paramString1 = this.CKx.YIY;
      if (paramString1 != null) {
        break label503;
      }
    }
    label503:
    for (paramString1 = null;; paramString1 = Integer.valueOf(paramString1.ZEt))
    {
      paramString4.append(paramString1);
      Log.i("Finder.CgiFinderLiveReward", paramString4.toString());
      d.Pmb.kY(540999695, 7);
      paramString1 = new c.a();
      paramString1.otE = ((a)this.CKx);
      paramString2 = new bmf();
      paramString2.setBaseResponse(new kd());
      paramString2.getBaseResponse().akjO = new etl();
      paramString1.otF = ((a)paramString2);
      paramString1.uri = "/cgi-bin/micromsg-bin/finderlivereward";
      paramString1.funcId = 5891;
      c(paramString1.bEF());
      AppMethodBeat.o(360212);
      return;
      paramString1 = paramb.ZV();
      break;
    }
  }
  
  public final JSONObject dVk()
  {
    return this.ABH;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bmf parambmf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ar
 * JD-Core Version:    0.7.0.1
 */