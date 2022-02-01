package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "liveId", "", "objectId", "nonceId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "(JJLjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class x
  extends k<ayd>
{
  private final String TAG;
  private final JSONObject ttQ;
  private final JSONObject tuL;
  private a uls;
  private ayc ult;
  
  public x(long paramLong1, long paramLong2, String paramString, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246346);
    this.TAG = "Finder.CgiFinderManualCloseLive";
    this.uls = parama;
    this.ult = new ayc();
    this.ttQ = new JSONObject();
    this.tuL = new JSONObject();
    this.ult.hyH = paramLong1;
    this.ult.LAt = z.aUg();
    this.ult.object_id = paramLong2;
    this.ult.object_nonce_id = paramString;
    this.ttQ.put("liveId", paramLong1);
    this.ttQ.put("username", this.ult.LAt);
    this.ttQ.put("object_id", paramLong2);
    paramString = new d.a();
    paramString.c((a)this.ult);
    parama = new ayd();
    parama.setBaseResponse(new BaseResponse());
    parama.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)parama);
    paramString.MB("/cgi-bin/micromsg-bin/findermanualcloselive");
    paramString.sG(5857);
    c(paramString.aXF());
    Log.i(this.TAG, "CgiFinderManualCloseLive init liveId:" + this.ult.hyH + ", objectId:" + this.ult.object_id + ", nonceId:" + this.ult.object_nonce_id + ", finderUsername:" + this.ult.LAt);
    AppMethodBeat.o(246346);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, ayd paramayd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.x
 * JD-Core Version:    0.7.0.1
 */