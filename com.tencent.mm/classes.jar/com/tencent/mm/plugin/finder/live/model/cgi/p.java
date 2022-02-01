package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.ayf;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveApplyBattle;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyBattleResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyBattleRequest;", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class p
  extends n<ayg>
{
  private final String TAG;
  private ayf yjj;
  
  public p(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, axe paramaxe)
  {
    AppMethodBeat.i(285469);
    this.TAG = "Finder.CgiFinderLiveApplyBattle";
    this.yjj = new ayf();
    this.yjj.klE = paramLong1;
    ayf localayf = this.yjj;
    ao localao = ao.xcj;
    localayf.RLM = ao.dnO();
    this.yjj.object_id = paramLong2;
    this.yjj.object_nonce_id = paramString;
    this.yjj.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yjj.RLN = z.bdh();
    this.yjj.scene = paramInt;
    this.yjj.yet = paramaxe;
    paramString = new d.a();
    paramString.c((a)this.yjj);
    paramArrayOfByte = new ayg();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/finderliveapplybattle");
    paramString.vD(5817);
    paramString = paramString.bgN();
    Log.i(this.TAG, "liveId:" + this.yjj.klE + " objectId:" + this.yjj.object_id + " nonceId:" + this.yjj.object_nonce_id + " username:" + this.yjj.RLN + " scene:" + this.yjj.scene);
    c(paramString);
    AppMethodBeat.o(285469);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveApplyBattle$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyBattleResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, ayg paramayg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.p
 * JD-Core Version:    0.7.0.1
 */