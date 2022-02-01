package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class a
  extends n<axa>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private awz yiJ;
  private final a yiK;
  
  public a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, axe paramaxe, a parama)
  {
    AppMethodBeat.i(290673);
    this.yiK = parama;
    this.TAG = "Finder.CgiFinderAcceptLiveMic";
    this.yiJ = new awz();
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yiJ.klE = paramLong1;
    parama = this.yiJ;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yiJ.object_id = paramLong2;
    this.yiJ.object_nonce_id = paramString;
    this.yiJ.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yiJ.RLN = z.bdh();
    this.yiJ.scene = paramInt;
    this.yiJ.yet = paramaxe;
    this.xcu.put("liveId", paramLong1);
    this.xcu.put("objectId", paramLong2);
    this.xcu.put("username", this.yiJ.RLN);
    paramString = new d.a();
    paramString.c((com.tencent.mm.cd.a)this.yiJ);
    paramArrayOfByte = new axa();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((com.tencent.mm.cd.a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/finderliveacceptmicwithaudience");
    paramString.vD(6852);
    c(paramString.bgN());
    AppMethodBeat.o(290673);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, axa paramaxa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */