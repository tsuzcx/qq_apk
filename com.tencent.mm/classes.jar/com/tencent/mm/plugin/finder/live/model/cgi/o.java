package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.awy;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAcceptBattle;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptBattleResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptBattleRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class o
  extends n<awy>
{
  private final String TAG;
  private awx yji;
  
  public o(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, axe paramaxe)
  {
    AppMethodBeat.i(288610);
    this.TAG = "Finder.CgiFinderLiveAcceptBattle";
    this.yji = new awx();
    this.yji.klE = paramLong1;
    awx localawx = this.yji;
    ao localao = ao.xcj;
    localawx.RLM = ao.dnO();
    this.yji.object_id = paramLong2;
    this.yji.object_nonce_id = paramString;
    this.yji.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yji.RLN = z.bdh();
    this.yji.scene = paramInt;
    this.yji.yet = paramaxe;
    paramString = new d.a();
    paramString.c((a)this.yji);
    paramArrayOfByte = new awy();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/finderliveacceptbattle");
    paramString.vD(5804);
    paramString = paramString.bgN();
    Log.i(this.TAG, "liveId:" + this.yji.klE + " objectId:" + this.yji.object_id + " nonceId:" + this.yji.object_nonce_id + " username:" + this.yji.RLN + " scene:" + this.yji.scene);
    c(paramString);
    AppMethodBeat.o(288610);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveAcceptBattle$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptBattleResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, awy paramawy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.o
 * JD-Core Version:    0.7.0.1
 */