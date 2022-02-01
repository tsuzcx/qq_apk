package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.bca;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "sdkUserId", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "(JJLjava/lang/String;[BILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class ag
  extends n<bcb>
{
  private final String TAG;
  private bca yjV;
  private final a yjW;
  
  public ag(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, a parama)
  {
    AppMethodBeat.i(281085);
    this.yjW = parama;
    this.TAG = "Finder.CgiFinderLiveRefreshMic";
    this.yjV = new bca();
    this.yjV.klE = paramLong1;
    parama = this.yjV;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yjV.object_id = paramLong2;
    this.yjV.object_nonce_id = paramString1;
    this.yjV.RLN = z.bdh();
    this.yjV.scene = paramInt;
    this.yjV.RLO = b.cU(paramArrayOfByte);
    this.yjV.SnB = paramString2;
    paramString1 = new d.a();
    paramString1.c((a)this.yjV);
    paramArrayOfByte = new bcb();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramArrayOfByte);
    paramString1.TW("/cgi-bin/micromsg-bin/finderliverefreshmicwithaudience");
    paramString1.vD(4180);
    paramString1 = paramString1.bgN();
    Log.i(this.TAG, "liveId:" + this.yjV.klE + " objectId:" + this.yjV.object_id + " objectNonceId:" + this.yjV.object_nonce_id + " scene:" + this.yjV.scene + " mic_sdk_user_id:" + this.yjV.SnB);
    c(paramString1);
    AppMethodBeat.o(281085);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveRefreshMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRefreshMicWithAudienceResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void b(int paramInt1, int paramInt2, bcb parambcb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ag
 * JD-Core Version:    0.7.0.1
 */