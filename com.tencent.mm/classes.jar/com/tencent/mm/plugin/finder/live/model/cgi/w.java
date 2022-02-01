package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.aun;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "username", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class w
  extends n<aun>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private a yjA;
  private aum yjB;
  
  public w(String paramString, a parama)
  {
    AppMethodBeat.i(288572);
    this.TAG = "Finder.CgiFinderLiveGetLastObject";
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.yjA = parama;
    this.yjB = new aum();
    this.yjB.SDn = paramString;
    parama = this.yjB;
    ao localao = ao.xcj;
    parama.SDi = ao.dnO();
    this.xcu.put("username", paramString);
    paramString = new d.a();
    paramString.c((a)this.yjB);
    parama = new aun();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramString.d((a)parama);
    paramString.TW("/cgi-bin/micromsg-bin/findergetlatestliveobject");
    paramString.vD(6482);
    c(paramString.bgN());
    Log.i(this.TAG, "CgiFinderLiveGetLastObject init username:" + this.yjB.SDn);
    AppMethodBeat.o(288572);
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, aun paramaun);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.w
 * JD-Core Version:    0.7.0.1
 */