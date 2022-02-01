package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "scene", "", "finderUsername", "", "liveId", "", "objectId", "liveCookie", "", "nonceId", "lotteryId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "(ILjava/lang/String;JJ[BLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;)V", "pullType", "getPullType", "()I", "setPullType", "(I)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class x
  extends n<azs>
{
  private final String TAG;
  public int pullType;
  private azr yjC;
  private a yjD;
  
  public x(int paramInt, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, String paramString2, String paramString3, b paramb, a parama)
  {
    AppMethodBeat.i(229839);
    this.yjD = parama;
    this.TAG = "CgiFinderLiveGetLotteryRecord";
    this.yjC = new azr();
    this.yjC.finderUsername = paramString1;
    this.yjC.liveId = paramLong1;
    this.yjC.xbk = paramLong2;
    this.yjC.SKW = d.Nb(paramString2);
    this.yjC.xHT = paramString3;
    this.yjC.lastBuffer = paramb;
    paramString1 = this.yjC;
    paramString3 = ao.xcj;
    paramString1.SDi = ao.dnO();
    this.yjC.jDI = paramString2;
    this.yjC.RLO = b.cU(paramArrayOfByte);
    this.yjC.scene = paramInt;
    paramString1 = new d.a();
    paramString1.c((a)this.yjC);
    paramArrayOfByte = new azs();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramArrayOfByte);
    paramString1.TW("/cgi-bin/micromsg-bin/finderlivegetlotteryrecord");
    paramString1.vD(5258);
    c(paramString1.bgN());
    Log.i(this.TAG, "init scene:" + this.yjC.scene + ",finderUsername:" + this.yjC.finderUsername + ",liveId:" + this.yjC.liveId + ",objectId:" + this.yjC.xbk + ",objectNonceId:" + this.yjC.jDI + ",lotteryId:" + this.yjC.xHT + ",lastBuffer:" + this.yjC.lastBuffer + ",live_cookies:" + this.yjC.RLO);
    AppMethodBeat.o(229839);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, azs paramazs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.x
 * JD-Core Version:    0.7.0.1
 */