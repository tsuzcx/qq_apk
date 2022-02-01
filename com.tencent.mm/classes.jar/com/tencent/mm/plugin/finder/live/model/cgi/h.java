package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveMicRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class h
  extends n<aqq>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private aqp yiX;
  private final a yiY;
  
  public h(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, axe paramaxe, a parama)
  {
    AppMethodBeat.i(275168);
    this.yiY = parama;
    this.TAG = "Finder.CgiFinderCloseLiveMicPk";
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yiX = new aqp();
    this.yiX.klE = paramLong1;
    parama = this.yiX;
    ao localao = ao.xcj;
    parama.RLM = ao.dnO();
    this.yiX.object_id = paramLong2;
    this.yiX.object_nonce_id = paramString;
    this.yiX.RLN = z.bdh();
    this.yiX.scene = paramInt;
    this.yiX.RLO = com.tencent.mm.cd.b.cU(paramArrayOfByte);
    this.yiX.yet = paramaxe;
    this.xcu.put("liveId", paramLong1);
    this.xcu.put("objectId", paramLong2);
    this.xcu.put("scene", this.yiX.scene);
    this.xcu.put("username", this.yiX.RLN);
    paramString = new d.a();
    paramString.c((a)this.yiX);
    paramArrayOfByte = new aqq();
    paramArrayOfByte.setBaseResponse(new jh());
    paramArrayOfByte.getBaseResponse().Tef = new eaf();
    paramString.d((a)paramArrayOfByte);
    paramString.TW("/cgi-bin/micromsg-bin/findercloselivemic");
    paramString.vD(3582);
    paramString = paramString.bgN();
    Log.i(this.TAG, "liveId:" + this.yiX.klE + " objectId:" + this.yiX.object_id + " objectNonceId:" + this.yiX.object_nonce_id + " scene:" + this.yiX.scene);
    c(paramString);
    AppMethodBeat.o(275168);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveMicResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aqq paramaqq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */