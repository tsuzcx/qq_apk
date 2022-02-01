package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyMicWithAudienceRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class b
  extends k<avg>
{
  private final String TAG;
  private final JSONObject ttQ;
  private final JSONObject tuL;
  private avf ukw;
  private final a ukx;
  
  public b(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, aut paramaut, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246297);
    this.ukx = parama;
    this.TAG = "Finder.CgiFinderApplyLiveMic";
    this.ukw = new avf();
    this.ttQ = new JSONObject();
    this.tuL = new JSONObject();
    this.ukw.hyH = paramLong1;
    parama = this.ukw;
    am localam = am.tuw;
    parama.LBM = am.cXY();
    this.ukw.object_id = paramLong2;
    this.ukw.object_nonce_id = paramString;
    this.ukw.LAt = z.aUg();
    this.ukw.scene = paramInt;
    this.ukw.LFp = com.tencent.mm.bw.b.cD(paramArrayOfByte);
    this.ukw.uio = paramaut;
    this.tuL.put("liveId", paramLong1);
    this.tuL.put("objectId", paramLong2);
    this.tuL.put("username", this.ukw.LAt);
    Log.i(this.TAG, "apply live id:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString);
    paramString = new d.a();
    paramString.c((a)this.ukw);
    paramArrayOfByte = new avg();
    paramArrayOfByte.setBaseResponse(new BaseResponse());
    paramArrayOfByte.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)paramArrayOfByte);
    paramString.MB("/cgi-bin/micromsg-bin/finderliveapplymicwithaudience");
    paramString.sG(5227);
    c(paramString.aXF());
    AppMethodBeat.o(246297);
  }
  
  public final com.tencent.mm.plugin.finder.cgi.report.b cXS()
  {
    return com.tencent.mm.plugin.finder.cgi.report.b.tye;
  }
  
  public final JSONObject cXV()
  {
    return this.tuL;
  }
  
  public final JSONObject cXW()
  {
    return this.ttQ;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyMicWithAudienceResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void onCgiBack(int paramInt1, int paramInt2, String paramString, avg paramavg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */