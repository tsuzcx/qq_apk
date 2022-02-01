package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class g
  extends n<ayz>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private ayy yiV;
  private final a yiW;
  
  public g(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, axe paramaxe, a parama)
  {
    AppMethodBeat.i(259963);
    this.yiW = parama;
    this.TAG = "Finder.CgiFinderCloseLiveMic";
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yiV = new ayy();
    this.yiV.klE = paramLong1;
    parama = this.yiV;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yiV.object_id = paramLong2;
    this.yiV.object_nonce_id = paramString;
    this.yiV.RLN = z.bdh();
    this.yiV.scene = paramInt;
    this.yiV.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yiV.yet = paramaxe;
    this.xcu.put("liveId", paramLong1);
    this.xcu.put("objectId", paramLong2);
    this.xcu.put("scene", this.yiV.scene);
    this.xcu.put("username", this.yiV.RLN);
    paramString = new d.a();
    paramString.c((a)this.yiV);
    paramArrayOfByte = new ayz();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/finderliveclosemicwithaudience");
    paramString.vD(4142);
    paramString = paramString.bgN();
    Log.i(this.TAG, "liveId:" + this.yiV.klE + " objectId:" + this.yiV.object_id + " objectNonceId:" + this.yiV.object_nonce_id + " scene:" + this.yiV.scene);
    c(paramString);
    AppMethodBeat.o(259963);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, ayz paramayz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.g
 * JD-Core Version:    0.7.0.1
 */