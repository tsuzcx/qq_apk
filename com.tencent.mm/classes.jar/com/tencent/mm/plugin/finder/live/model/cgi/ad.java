package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "scene", "", "finderUsername", "", "liveId", "", "objectId", "liveCookie", "", "nonceId", "lotteryId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "(ILjava/lang/String;JJ[BLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends o<bib>
{
  private ad.a CJS;
  private bia CJT;
  private final String TAG;
  public int pullType;
  
  public ad(int paramInt, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, String paramString2, String paramString3, b paramb)
  {
    AppMethodBeat.i(360238);
    this.CJS = null;
    this.TAG = "CgiFinderLiveGetLotteryRecord";
    this.CJT = new bia();
    this.CJT.finderUsername = paramString1;
    this.CJT.liveId = paramLong1;
    this.CJT.hKN = paramLong2;
    this.CJT.ZPX = d.FK(paramString2);
    this.CJT.Bhk = paramString3;
    this.CJT.lastBuffer = paramb;
    paramString1 = this.CJT;
    paramString3 = bi.ABn;
    paramString1.ZEc = bi.dVu();
    this.CJT.mdD = paramString2;
    this.CJT.YJa = b.cX(paramArrayOfByte);
    this.CJT.scene = paramInt;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CJT);
    paramArrayOfByte = new bib();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramArrayOfByte);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderlivegetlotteryrecord";
    paramString1.funcId = 5258;
    c(paramString1.bEF());
    Log.i(this.TAG, "init scene:" + this.CJT.scene + ",finderUsername:" + this.CJT.finderUsername + ",liveId:" + this.CJT.liveId + ",objectId:" + this.CJT.hKN + ",objectNonceId:" + this.CJT.mdD + ",lotteryId:" + this.CJT.Bhk + ",lastBuffer:" + this.CJT.lastBuffer + ",live_cookies:" + this.CJT.YJa);
    AppMethodBeat.o(360238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ad
 * JD-Core Version:    0.7.0.1
 */