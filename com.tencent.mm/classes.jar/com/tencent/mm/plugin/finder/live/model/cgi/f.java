package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.aqs;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "liveId", "", "finderUsername", "", "objectId", "nonceId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "(JLjava/lang/String;JLjava/lang/String;ILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class f
  extends n<aqs>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private a yiT;
  private aqr yiU;
  
  public f(long paramLong1, String paramString1, long paramLong2, String paramString2, int paramInt, a parama)
  {
    AppMethodBeat.i(282398);
    this.TAG = "Finder.CgiFinderCloseLive";
    this.yiT = parama;
    this.yiU = new aqr();
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yiU.liveId = paramLong1;
    this.yiU.finderUsername = paramString1;
    this.yiU.xbk = paramLong2;
    this.yiU.SDS = paramString2;
    this.yiU.scene = paramInt;
    this.xcu.put("liveId", paramLong1);
    this.xcu.put("objectId", paramLong2);
    this.xbw.put("username", this.yiU.finderUsername);
    this.xcu.put("scene", paramInt);
    paramString1 = new d.a();
    paramString1.c((a)this.yiU);
    paramString2 = new aqs();
    paramString2.setBaseResponse(new jh());
    paramString2.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramString2);
    paramString1.TW("/cgi-bin/micromsg-bin/findercloselive");
    paramString1.vD(857);
    c(paramString1.bgN());
    Log.i(this.TAG, "CgiFinderCloseLive init liveId:" + this.yiU.liveId + ", username:" + this.yiU.finderUsername + ",objectId:" + this.yiU.xbk + ",nonceId:" + this.yiU.SDS + ",scene:" + this.yiU.scene);
    AppMethodBeat.o(282398);
  }
  
  public final b dnF()
  {
    return b.BvU;
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aqs paramaqs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.f
 * JD-Core Version:    0.7.0.1
 */