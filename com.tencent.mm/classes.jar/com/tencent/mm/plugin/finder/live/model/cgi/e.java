package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.apt;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class e
  extends n<apt>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private aps yiR;
  private final a yiS;
  
  public e(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, axe paramaxe, a parama)
  {
    AppMethodBeat.i(286690);
    this.yiS = parama;
    this.TAG = "Finder.CgiFinderApplyLiveMicPk";
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yiR = new aps();
    this.yiR.klE = paramLong1;
    parama = this.yiR;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yiR.object_id = paramLong2;
    this.yiR.object_nonce_id = paramString;
    this.yiR.RLN = z.bdh();
    this.yiR.scene = paramInt;
    this.yiR.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yiR.yet = paramaxe;
    this.xcu.put("liveId", paramLong1);
    this.xcu.put("objectId", paramLong2);
    this.xcu.put("username", this.yiR.RLN);
    Log.i(this.TAG, "apply live id:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString);
    paramString = new d.a();
    paramString.c((a)this.yiR);
    paramArrayOfByte = new apt();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/finderapplylivemic");
    paramString.vD(3917);
    c(paramString.bgN());
    AppMethodBeat.o(286690);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, apt paramapt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.e
 * JD-Core Version:    0.7.0.1
 */