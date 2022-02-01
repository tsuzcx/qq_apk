package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "liveId", "", "finderUsername", "", "objectId", "nonceId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "(JLjava/lang/String;JLjava/lang/String;ILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends o<auv>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private a CIV;
  private auu CIW;
  private final String TAG;
  
  public f(long paramLong1, String paramString1, long paramLong2, String paramString2, int paramInt, a parama)
  {
    AppMethodBeat.i(360296);
    this.TAG = "Finder.CgiFinderCloseLive";
    this.CIV = parama;
    this.CIW = new auu();
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CIW.liveId = paramLong1;
    this.CIW.finderUsername = paramString1;
    this.CIW.hKN = paramLong2;
    this.CIW.ZFi = paramString2;
    this.CIW.scene = paramInt;
    this.ABH.put("liveId", paramLong1);
    this.ABH.put("objectId", paramLong2);
    this.AAn.put("username", this.CIW.finderUsername);
    this.ABH.put("scene", paramInt);
    paramString1 = new c.a();
    paramString1.otE = ((a)this.CIW);
    paramString2 = new auv();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/findercloselive";
    paramString1.funcId = 857;
    c(paramString1.bEF());
    Log.i(this.TAG, "CgiFinderCloseLive init liveId:" + this.CIW.liveId + ", username:" + this.CIW.finderUsername + ",objectId:" + this.CIW.hKN + ",nonceId:" + this.CIW.ZFi + ",scene:" + this.CIW.scene);
    AppMethodBeat.o(360296);
  }
  
  public final b dVi()
  {
    return b.Hde;
  }
  
  public final JSONObject dVk()
  {
    return this.ABH;
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, auv paramauv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.f
 * JD-Core Version:    0.7.0.1
 */