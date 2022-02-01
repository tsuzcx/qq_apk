package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "liveId", "", "objectId", "nonceId", "", "durationMin", "", "desc", "attendType", "attendWording", "opType", "winnerCnt", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "(JJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;IILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder_release"})
public final class v
  extends n<azc>
{
  private static final int yjx = 0;
  private static final int yjy = 1;
  public static final b yjz;
  private final String TAG;
  private azb yjv;
  private a yjw;
  
  static
  {
    AppMethodBeat.i(272752);
    yjz = new b((byte)0);
    yjy = 1;
    AppMethodBeat.o(272752);
  }
  
  public v(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, a parama)
  {
    AppMethodBeat.i(272751);
    this.yjw = parama;
    this.TAG = "CgiFinderLiveCreateLottery";
    this.yjv = new azb();
    this.yjv.liveId = paramLong1;
    this.yjv.xbk = paramLong2;
    this.yjv.SKW = d.Nb(paramString1);
    this.yjv.SKX = (paramInt1 * 60);
    this.yjv.SKY = paramString2;
    paramString2 = this.yjv;
    parama = new baj();
    parama.SMp = paramInt2;
    parama.SMq = paramString3;
    paramString2.SKZ = parama;
    this.yjv.SLa = paramInt4;
    this.yjv.opType = paramInt3;
    paramString2 = this.yjv;
    paramString3 = ao.xcj;
    paramString2.SDi = ao.dnO();
    this.yjv.nonceId = paramString1;
    paramString1 = new d.a();
    paramString1.c((a)this.yjv);
    paramString2 = new azc();
    paramString2.setBaseResponse(new jh());
    paramString2.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramString2);
    paramString1.TW("/cgi-bin/micromsg-bin/finderlivecreatelottery");
    paramString1.vD(6645);
    c(paramString1.bgN());
    paramString2 = this.TAG;
    paramString3 = new StringBuilder("FinderLiveLottery,init liveId:").append(this.yjv.liveId).append(",objectId:").append(this.yjv.xbk).append(",nonceId:").append(this.yjv.nonceId).append(",lotteryDuration:").append(this.yjv.SKX).append(",lotteryDescription:").append(this.yjv.SKY).append(",lotteryAttendType:");
    paramString1 = this.yjv.SKZ;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.SMp);
      paramString3 = paramString3.append(paramString1).append(",attendWording:");
      paramString1 = this.yjv.SKZ;
      if (paramString1 == null) {
        break label493;
      }
    }
    label493:
    for (paramString1 = paramString1.SMq;; paramString1 = null)
    {
      Log.i(paramString2, paramString1 + ",lotteryWinnerCnt:" + this.yjv.SLa + ",opType:" + this.yjv.opType);
      AppMethodBeat.o(272751);
      return;
      paramString1 = null;
      break;
    }
  }
  
  public final b dnF()
  {
    return b.BvU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, azc paramazc);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$Companion;", "", "()V", "CANCEL_LOTERRY", "", "getCANCEL_LOTERRY", "()I", "CREATE_LOTERRY", "getCREATE_LOTERRY", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.v
 * JD-Core Version:    0.7.0.1
 */