package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLuckyMoneyRewardNotify;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketRewardNotifyResponse;", "liveId", "", "objectId", "nonceId", "", "liveCookie", "", "sendId", "(JJLjava/lang/String;[BLjava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketRewardNotifyRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class am
  extends n<bbz>
{
  private final String TAG;
  private bby ykj;
  
  public am(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(291667);
    this.TAG = "Finder.CgiFinderLuckyMoneyRewardNotify";
    this.ykj = new bby();
    bby localbby = this.ykj;
    ao localao = ao.xcj;
    localbby.RLM = ao.dnO();
    this.ykj.klE = paramLong1;
    this.ykj.object_id = paramLong2;
    this.ykj.object_nonce_id = paramString1;
    this.ykj.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.ykj.SKs = paramString2;
    paramString1 = new d.a();
    paramString1.c((a)this.ykj);
    paramArrayOfByte = new bbz();
    paramArrayOfByte.setBaseResponse(new jh());
    paramString1.d((a)paramArrayOfByte);
    paramString1.TW("/cgi-bin/micromsg-bin/finderliveredpacketrewardnotify");
    paramString1.vD(6671);
    c(paramString1.bgN());
    Log.i(this.TAG, "CgiFinderLuckyMoneyRewardNotify init liveId:" + this.ykj.klE + " sendId:" + this.ykj.SKs);
    AppMethodBeat.o(291667);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.am
 * JD-Core Version:    0.7.0.1
 */