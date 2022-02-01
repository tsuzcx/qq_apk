package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.blt;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLuckyMoneyRewardNotify;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketRewardNotifyResponse;", "liveId", "", "objectId", "nonceId", "", "liveCookie", "", "sendId", "(JJLjava/lang/String;[BLjava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRedPacketRewardNotifyRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  extends o<blu>
{
  private blt CKJ;
  private final String TAG;
  
  public ax(long paramLong1, long paramLong2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(360215);
    this.TAG = "Finder.CgiFinderLuckyMoneyRewardNotify";
    this.CKJ = new blt();
    blt localblt = this.CKJ;
    bi localbi = bi.ABn;
    localblt.YIY = bi.dVu();
    this.CKJ.mMJ = paramLong1;
    this.CKJ.object_id = paramLong2;
    this.CKJ.object_nonce_id = paramString1;
    this.CKJ.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CKJ.ZOX = paramString2;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CKJ);
    paramArrayOfByte = new blu();
    paramArrayOfByte.setBaseResponse(new kd());
    paramString1.otF = ((a)paramArrayOfByte);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderliveredpacketrewardnotify";
    paramString1.funcId = 6671;
    c(paramString1.bEF());
    Log.i(this.TAG, "CgiFinderLuckyMoneyRewardNotify init liveId:" + this.CKJ.mMJ + " sendId:" + this.CKJ.ZOX);
    AppMethodBeat.o(360215);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ax
 * JD-Core Version:    0.7.0.1
 */