package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "liveId", "", "objectId", "nonceId", "", "durationMin", "", "desc", "attendType", "attendWording", "opType", "winnerCnt", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "(JJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;IILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "setCallback", "(Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder_release"})
public final class m
  extends k<avp>
{
  private static final int ukU = 0;
  private static final int ukV = 1;
  public static final b ukW;
  private final String TAG;
  private avo ukS;
  private a ukT;
  
  static
  {
    AppMethodBeat.i(246322);
    ukW = new b((byte)0);
    ukV = 1;
    AppMethodBeat.o(246322);
  }
  
  public m(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246321);
    this.ukT = parama;
    this.TAG = "CgiFinderLiveCreateLottery";
    this.ukS = new avo();
    this.ukS.liveId = paramLong1;
    this.ukS.hFK = paramLong2;
    this.ukS.LGk = d.Ga(paramString1);
    this.ukS.LGl = (paramInt1 * 60);
    this.ukS.LGm = paramString2;
    paramString2 = this.ukS;
    parama = new awg();
    parama.LGY = paramInt2;
    parama.LGZ = paramString3;
    paramString2.LGn = parama;
    this.ukS.LGo = paramInt4;
    this.ukS.opType = paramInt3;
    paramString2 = this.ukS;
    paramString3 = am.tuw;
    paramString2.LAI = am.cXY();
    this.ukS.hwg = paramString1;
    paramString1 = new d.a();
    paramString1.c((a)this.ukS);
    paramString2 = new avp();
    paramString2.setBaseResponse(new BaseResponse());
    paramString2.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramString2);
    paramString1.MB("/cgi-bin/micromsg-bin/finderlivecreatelottery");
    paramString1.sG(6645);
    c(paramString1.aXF());
    paramString2 = this.TAG;
    paramString3 = new StringBuilder("FinderLiveLottery,init liveId:").append(this.ukS.liveId).append(",objectId:").append(this.ukS.hFK).append(",nonceId:").append(this.ukS.hwg).append(",lotteryDuration:").append(this.ukS.LGl).append(",lotteryDescription:").append(this.ukS.LGm).append(",lotteryAttendType:");
    paramString1 = this.ukS.LGn;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.LGY);
      paramString3 = paramString3.append(paramString1).append(",attendWording:");
      paramString1 = this.ukS.LGn;
      if (paramString1 == null) {
        break label494;
      }
    }
    label494:
    for (paramString1 = paramString1.LGZ;; paramString1 = null)
    {
      Log.i(paramString2, paramString1 + ",lotteryWinnerCnt:" + this.ukS.LGo + ",opType:" + this.ukS.opType);
      AppMethodBeat.o(246321);
      return;
      paramString1 = null;
      break;
    }
  }
  
  public final b cXS()
  {
    return b.tye;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, avp paramavp);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$Companion;", "", "()V", "CANCEL_LOTERRY", "", "getCANCEL_LOTERRY", "()I", "CREATE_LOTERRY", "getCREATE_LOTERRY", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.m
 * JD-Core Version:    0.7.0.1
 */