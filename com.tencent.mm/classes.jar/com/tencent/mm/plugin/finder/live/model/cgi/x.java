package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "params", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLotteryParams;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLotteryParams;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends o<bgj>
{
  public static final b CJC;
  private static final int CJF = 0;
  private static final int CJG;
  private a CJD;
  private bgi CJE;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(360247);
    CJC = new b((byte)0);
    CJG = 1;
    AppMethodBeat.o(360247);
  }
  
  public x(y paramy, a parama)
  {
    AppMethodBeat.i(360231);
    this.CJD = parama;
    this.TAG = "CgiFinderLiveCreateLottery";
    this.CJE = new bgi();
    this.CJE.liveId = paramy.liveId;
    this.CJE.hKN = paramy.hKN;
    this.CJE.ZPX = d.FK(paramy.nonceId);
    this.CJE.ZPY = (paramy.CJH * 60);
    this.CJE.ZPZ = paramy.desc;
    parama = this.CJE;
    Object localObject2 = new bja();
    ((bja)localObject2).ZSK = paramy.CJI;
    ((bja)localObject2).CJJ = paramy.CJJ;
    Object localObject3 = ah.aiuX;
    parama.ZQa = ((bja)localObject2);
    this.CJE.ZQb = paramy.Czn;
    this.CJE.opType = paramy.opType;
    parama = this.CJE;
    localObject2 = bi.ABn;
    localObject2 = bi.dVu();
    localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
      ((atz)localObject2).ZEt = 3;
    }
    localObject3 = ah.aiuX;
    parama.ZEc = ((atz)localObject2);
    this.CJE.nonceId = paramy.nonceId;
    this.CJE.CJK = paramy.CJK;
    this.CJE.YJa = paramy.Ayh;
    paramy = new c.a();
    paramy.otE = ((com.tencent.mm.bx.a)this.CJE);
    parama = new bgj();
    parama.setBaseResponse(new kd());
    parama.getBaseResponse().akjO = new etl();
    paramy.otF = ((com.tencent.mm.bx.a)parama);
    paramy.uri = "/cgi-bin/micromsg-bin/finderlivecreatelottery";
    paramy.funcId = 6645;
    c(paramy.bEF());
    parama = this.TAG;
    localObject2 = new StringBuilder("FinderLiveLottery,init liveId:").append(this.CJE.liveId).append(",objectId:").append(this.CJE.hKN).append(",nonceId:").append(this.CJE.nonceId).append(",lotteryDuration:").append(this.CJE.ZPY).append(",lotteryDescription:").append(this.CJE.ZPZ).append(",lotteryAttendType:");
    paramy = this.CJE.ZQa;
    if (paramy == null)
    {
      paramy = null;
      localObject2 = ((StringBuilder)localObject2).append(paramy).append(",attendWording:");
      paramy = this.CJE.ZQa;
      if (paramy != null) {
        break label546;
      }
    }
    label546:
    for (paramy = localObject1;; paramy = paramy.CJJ)
    {
      Log.i(parama, paramy + ",lotteryWinnerCnt:" + this.CJE.ZQb + ",opType:" + this.CJE.opType + ",setting_flag:" + this.CJE.CJK);
      AppMethodBeat.o(360231);
      return;
      paramy = Integer.valueOf(paramy.ZSK);
      break;
    }
  }
  
  public final b dVi()
  {
    return b.Hde;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bgj parambgj);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$Companion;", "", "()V", "CANCEL_LOTERRY", "", "getCANCEL_LOTERRY", "()I", "CREATE_LOTERRY", "getCREATE_LOTERRY", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.x
 * JD-Core Version:    0.7.0.1
 */