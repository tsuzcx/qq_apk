package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "liveId", "", "objectId", "rewardProductId", "", "rewardProductCount", "", "username", "wecoin", "requestId", "comboId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "(JJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class v
  extends k<axc>
{
  private final String TAG;
  private axb ulp;
  private final a ulq;
  
  public v(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246342);
    this.ulq = parama;
    this.TAG = "Finder.CgiFinderLiveReward";
    this.ulp = new axb();
    int i = paramInt2 * paramInt1;
    parama = this.ulp;
    am localam = am.tuw;
    parama.LBM = am.cXY();
    this.ulp.hyH = paramLong1;
    this.ulp.object_id = paramLong2;
    this.ulp.LFM = paramString1;
    this.ulp.LFQ = paramInt1;
    this.ulp.LFR = i;
    this.ulp.LAt = paramString2;
    this.ulp.request_id = paramString3;
    this.ulp.LFP = paramString4;
    Log.i(this.TAG, "liveId:" + paramLong1 + " objectId:" + paramLong2 + " rewardProductId:" + paramString1 + " rewardProductCount:" + paramInt1 + " to:" + paramString2 + " requestId:" + paramString3 + " wecoin:" + paramInt2 + ",amountPrice:" + i);
    paramString1 = new d.a();
    paramString1.c((a)this.ulp);
    paramString2 = new axc();
    paramString2.setBaseResponse(new BaseResponse());
    paramString2.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramString2);
    paramString1.MB("/cgi-bin/micromsg-bin/finderlivereward");
    paramString1.sG(5891);
    c(paramString1.aXF());
    AppMethodBeat.o(246342);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveReward$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, axc paramaxc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.v
 * JD-Core Version:    0.7.0.1
 */