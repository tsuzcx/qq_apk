package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusResponse;", "liveId", "", "objectId", "status", "", "finderUserName", "", "liveStatus", "micFlag", "Lcom/tencent/mm/protocal/protobuf/MicSetting;", "gameTeamSetting", "Lcom/tencent/mm/protocal/protobuf/GameJoinTeamSetting;", "lotterySetting", "Lcom/tencent/mm/protocal/protobuf/LiveLotterySetting;", "opFlag", "callback", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "(JJILjava/lang/String;ILcom/tencent/mm/protocal/protobuf/MicSetting;Lcom/tencent/mm/protocal/protobuf/GameJoinTeamSetting;Lcom/tencent/mm/protocal/protobuf/LiveLotterySetting;JLcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;)V", "TAG", "anchorStatus", "getGameTeamSetting", "()Lcom/tencent/mm/protocal/protobuf/GameJoinTeamSetting;", "getLotterySetting", "()Lcom/tencent/mm/protocal/protobuf/LiveLotterySetting;", "micSetting", "getOpFlag", "()J", "request", "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c<bvg>
{
  public static final b CuZ;
  private static final long Cvg = 0L;
  private static final long Cvh;
  private static final int Cvi;
  private static final int Cvj;
  private static final int Cvk;
  private final cbm Cva;
  private final diq Cvb;
  private final long Cvc;
  private a Cvd;
  private bvf Cve;
  private dom Cvf;
  private final String TAG;
  private int anchorStatus;
  
  static
  {
    AppMethodBeat.i(351146);
    CuZ = new b((byte)0);
    Cvh = Cvg ^ 0xFFFFFFFF;
    Cvi = 1;
    Cvj = 2;
    Cvk = 4;
    AppMethodBeat.o(351146);
  }
  
  private e(long paramLong1, long paramLong2, int paramInt1, String paramString, int paramInt2, dom paramdom, cbm paramcbm, diq paramdiq, long paramLong3, a parama)
  {
    AppMethodBeat.i(351128);
    this.Cva = paramcbm;
    this.Cvb = paramdiq;
    this.Cvc = paramLong3;
    this.TAG = "Finder.CgiFinderLiveAnchorStatus";
    this.Cvd = parama;
    this.Cve = new bvf();
    this.anchorStatus = paramInt1;
    this.Cvf = paramdom;
    this.Cve.liveId = paramLong1;
    this.Cve.hKN = paramLong2;
    this.Cve.finderUsername = paramString;
    paramString = this.Cve;
    paramdom = bi.ABn;
    paramString.ZEc = bi.dVu();
    this.Cve.liveStatus = paramInt2;
    paramString = new dih();
    paramString.aaNh = paramInt1;
    paramString.aaNg = cn.bDv();
    if (this.Cvf != null)
    {
      paramString.ZFK = this.Cvf;
      this.Cve.aacN |= Cvj;
    }
    if (this.Cva != null)
    {
      paramString.aaNi = this.Cva;
      this.Cve.aacN |= Cvi;
    }
    if (this.Cvb != null)
    {
      paramString.ZFL = this.Cvb;
      this.Cve.aacN |= Cvk;
    }
    this.Cve.ZQg = b.cX(paramString.toByteArray());
    this.Cve.aacM = this.Cvc;
    Log.i(this.TAG, s.X("opFlag:", d.hF(this.Cvc)));
    paramString = new c.a();
    paramString.otE = ((a)this.Cve);
    paramdom = new bvg();
    paramdom.setBaseResponse(new kd());
    paramdom.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramdom);
    paramString.uri = "/cgi-bin/micromsg-bin/findersetanchorstatus";
    paramString.funcId = 6443;
    c(paramString.bEF());
    paramdom = this.TAG;
    paramcbm = new StringBuilder("init ").append(this.Cve.liveId).append(',').append(this.Cve.finderUsername).append(',').append(this.anchorStatus).append(',');
    paramString = this.Cvf;
    if (paramString == null)
    {
      paramString = null;
      paramcbm = paramcbm.append(paramString).append(",LiveLotterySetting:[");
      paramString = this.Cvb;
      if (paramString != null) {
        break label645;
      }
      paramString = null;
      label493:
      paramcbm = paramcbm.append(paramString).append(',');
      paramString = this.Cvb;
      if (paramString != null) {
        break label658;
      }
      paramString = null;
      label521:
      paramcbm = paramcbm.append(paramString).append("],GameTeamSetting:[");
      paramString = this.Cva;
      if (paramString != null) {
        break label671;
      }
      paramString = null;
      label550:
      paramcbm = paramcbm.append(paramString).append(',');
      paramString = this.Cva;
      if (paramString != null) {
        break label702;
      }
      paramString = null;
      label578:
      paramcbm = paramcbm.append(paramString).append(',');
      paramString = this.Cva;
      if (paramString != null) {
        break label733;
      }
    }
    label645:
    label658:
    label671:
    label702:
    label733:
    for (paramString = null;; paramString = Integer.valueOf(paramString.aakL))
    {
      Log.i(paramdom, paramString + ']');
      AppMethodBeat.o(351128);
      return;
      paramString = Long.valueOf(paramString.CJK);
      break;
      paramString = Integer.valueOf(paramString.BBE);
      break label493;
      paramString = Long.valueOf(paramString.CJK);
      break label521;
      paramString = paramString.ZGd;
      if (paramString == null)
      {
        paramString = null;
        break label550;
      }
      paramString = Integer.valueOf(paramString.aalq);
      break label550;
      paramString = paramString.ZGd;
      if (paramString == null)
      {
        paramString = null;
        break label578;
      }
      paramString = Integer.valueOf(paramString.aalp);
      break label578;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onFailWithResponse", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderSetAnchorStatusResponse;", "onSuccess", "micSettingFlag", "", "onSuccessWithResponse", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(bvg parambvg);
    
    public abstract void am(int paramInt, long paramLong);
    
    public abstract void b(int paramInt1, int paramInt2, String paramString, int paramInt3);
    
    public abstract void eho();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$Companion;", "", "()V", "OP_FLAG_ALL", "", "getOP_FLAG_ALL", "()J", "OP_FLAG_NONE", "getOP_FLAG_NONE", "OpFlag_GameJoinTeamSetting", "", "getOpFlag_GameJoinTeamSetting", "()I", "OpFlag_LiveLotterySetting", "getOpFlag_LiveLotterySetting", "OpFlag_MicSetting", "getOpFlag_MicSetting", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.e
 * JD-Core Version:    0.7.0.1
 */