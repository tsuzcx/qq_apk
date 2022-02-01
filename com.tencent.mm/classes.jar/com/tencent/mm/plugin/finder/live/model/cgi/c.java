package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "liveId", "", "finderUsername", "", "objectId", "nonceId", "scene", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "(JLjava/lang/String;JLjava/lang/String;ILcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class c
  extends k<ape>
{
  private final String TAG;
  private final JSONObject ttQ;
  private final JSONObject tuL;
  private a uky;
  private apd ukz;
  
  public c(long paramLong1, String paramString1, long paramLong2, String paramString2, int paramInt, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246299);
    this.TAG = "Finder.CgiFinderCloseLive";
    this.uky = parama;
    this.ukz = new apd();
    this.ttQ = new JSONObject();
    this.tuL = new JSONObject();
    this.ukz.liveId = paramLong1;
    this.ukz.finderUsername = paramString1;
    this.ukz.hFK = paramLong2;
    this.ukz.LBj = paramString2;
    this.ukz.scene = paramInt;
    this.tuL.put("liveId", paramLong1);
    this.tuL.put("objectId", paramLong2);
    this.ttQ.put("username", this.ukz.finderUsername);
    this.tuL.put("scene", paramInt);
    paramString1 = new d.a();
    paramString1.c((a)this.ukz);
    paramString2 = new ape();
    paramString2.setBaseResponse(new BaseResponse());
    paramString2.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramString2);
    paramString1.MB("/cgi-bin/micromsg-bin/findercloselive");
    paramString1.sG(857);
    c(paramString1.aXF());
    Log.i(this.TAG, "CgiFinderCloseLive init liveId:" + this.ukz.liveId + ", username:" + this.ukz.finderUsername + ",objectId:" + this.ukz.hFK + ",nonceId:" + this.ukz.LBj + ",scene:" + this.ukz.scene);
    AppMethodBeat.o(246299);
  }
  
  public final b cXS()
  {
    return b.tye;
  }
  
  public final JSONObject cXV()
  {
    return this.tuL;
  }
  
  public final JSONObject cXW()
  {
    return this.ttQ;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, ape paramape);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */