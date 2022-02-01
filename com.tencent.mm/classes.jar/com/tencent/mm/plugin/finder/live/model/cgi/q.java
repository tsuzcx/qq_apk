package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveApplyBattle;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyBattleResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyBattleRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends o<bfb>
{
  private bfa CJo;
  private final String TAG;
  
  public q(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, bdm parambdm)
  {
    AppMethodBeat.i(360256);
    this.TAG = "Finder.CgiFinderLiveApplyBattle";
    this.CJo = new bfa();
    this.CJo.mMJ = paramLong1;
    bfa localbfa = this.CJo;
    bi localbi = bi.ABn;
    localbfa.YIY = bi.dVu();
    this.CJo.object_id = paramLong2;
    this.CJo.object_nonce_id = paramString;
    this.CJo.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CJo.YIZ = z.bAW();
    this.CJo.scene = paramInt;
    this.CJo.CER = parambdm;
    paramString = new c.a();
    paramString.otE = ((a)this.CJo);
    paramArrayOfByte = new bfb();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/finderliveapplybattle";
    paramString.funcId = 5817;
    paramString = paramString.bEF();
    Log.i(this.TAG, "liveId:" + this.CJo.mMJ + " objectId:" + this.CJo.object_id + " nonceId:" + this.CJo.object_nonce_id + " username:" + this.CJo.YIZ + " scene:" + this.CJo.scene);
    c(paramString);
    AppMethodBeat.o(360256);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveApplyBattle$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyBattleResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bfb parambfb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.q
 * JD-Core Version:    0.7.0.1
 */