package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "scene", "", "finderUsername", "", "liveId", "", "objectId", "liveCookie", "", "nonceId", "lotteryId", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "(ILjava/lang/String;JJ[BLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class o
  extends k<avy>
{
  private final String TAG;
  private avx ukZ;
  private a ula;
  
  public o(int paramInt, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, String paramString2, String paramString3, b paramb, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246326);
    this.ula = parama;
    this.TAG = "CgiFinderLiveGetLotteryRecord";
    this.ukZ = new avx();
    this.ukZ.finderUsername = paramString1;
    this.ukZ.liveId = paramLong1;
    this.ukZ.hFK = paramLong2;
    this.ukZ.LGk = d.Ga(paramString2);
    this.ukZ.tWb = paramString3;
    this.ukZ.lastBuffer = paramb;
    paramString1 = this.ukZ;
    paramString3 = am.tuw;
    paramString1.LAI = am.cXY();
    this.ukZ.LGs = paramString2;
    this.ukZ.LFp = b.cD(paramArrayOfByte);
    this.ukZ.scene = paramInt;
    paramString1 = new d.a();
    paramString1.c((a)this.ukZ);
    paramArrayOfByte = new avy();
    paramArrayOfByte.setBaseResponse(new BaseResponse());
    paramArrayOfByte.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramArrayOfByte);
    paramString1.MB("/cgi-bin/micromsg-bin/finderlivegetlotteryrecord");
    paramString1.sG(5258);
    c(paramString1.aXF());
    Log.i(this.TAG, "init scene:" + this.ukZ.scene + ",finderUsername:" + this.ukZ.finderUsername + ",liveId:" + this.ukZ.liveId + ",objectId:" + this.ukZ.hFK + ",objectNonceId:" + this.ukZ.LGs + ",lotteryId:" + this.ukZ.tWb + ",lastBuffer:" + this.ukZ.lastBuffer + ",live_cookies:" + this.ukZ.LFp);
    AppMethodBeat.o(246326);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, avy paramavy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.o
 * JD-Core Version:    0.7.0.1
 */