package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.apj;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderAcceptLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderAcceptLiveMicRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class b
  extends n<apj>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private api yiL;
  private final a yiM;
  
  public b(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, axe paramaxe, a parama)
  {
    AppMethodBeat.i(269555);
    this.yiM = parama;
    this.TAG = "Finder.CgiFinderAcceptLiveMicPk";
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yiL = new api();
    this.yiL.klE = paramLong1;
    parama = this.yiL;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yiL.object_id = paramLong2;
    this.yiL.object_nonce_id = paramString;
    this.yiL.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yiL.RLN = z.bdh();
    this.yiL.scene = paramInt;
    this.yiL.yet = paramaxe;
    this.xcu.put("liveId", paramLong1);
    this.xcu.put("objectId", paramLong2);
    this.xcu.put("username", this.yiL.RLN);
    paramString = new d.a();
    paramString.c((a)this.yiL);
    paramArrayOfByte = new apj();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/finderacceptlivemic");
    paramString.vD(3936);
    c(paramString.bgN());
    AppMethodBeat.o(269555);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderAcceptLiveMicResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, apj paramapj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */