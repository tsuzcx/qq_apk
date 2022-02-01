package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCloseBattle;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseBattleResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseBattleRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class t
  extends n<ayx>
{
  private final String TAG;
  private ayw yjr;
  
  public t(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, axe paramaxe)
  {
    AppMethodBeat.i(280350);
    this.TAG = "Finder.CgiFinderLiveCloseBattle";
    this.yjr = new ayw();
    this.yjr.klE = paramLong1;
    ayw localayw = this.yjr;
    ao localao = ao.xcj;
    localayw.RLM = ao.dnO();
    this.yjr.object_id = paramLong2;
    this.yjr.object_nonce_id = paramString;
    this.yjr.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yjr.RLN = z.bdh();
    this.yjr.scene = paramInt;
    this.yjr.yet = paramaxe;
    paramString = new d.a();
    paramString.c((a)this.yjr);
    paramArrayOfByte = new ayx();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/finderliveclosebattle");
    paramString.vD(4262);
    paramString = paramString.bgN();
    Log.i(this.TAG, "liveId:" + this.yjr.klE + " objectId:" + this.yjr.object_id + " nonceId:" + this.yjr.object_nonce_id + " username:" + this.yjr.RLN + " scene:" + this.yjr.scene);
    c(paramString);
    AppMethodBeat.o(280350);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCloseBattle$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseBattleResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, ayx paramayx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.t
 * JD-Core Version:    0.7.0.1
 */