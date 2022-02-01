package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.dqi;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class a
  extends k<aur>
{
  private final String TAG;
  private final JSONObject ttQ;
  private final JSONObject tuL;
  private auq uku;
  private final a ukv;
  
  public a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, aut paramaut, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246295);
    this.ukv = parama;
    this.TAG = "Finder.CgiFinderAcceptLiveMic";
    this.uku = new auq();
    this.ttQ = new JSONObject();
    this.tuL = new JSONObject();
    this.uku.hyH = paramLong1;
    parama = this.uku;
    am localam = am.tuw;
    parama.LBM = am.cXY();
    this.uku.object_id = paramLong2;
    this.uku.object_nonce_id = paramString;
    this.uku.LFp = com.tencent.mm.bw.b.cD(paramArrayOfByte);
    this.uku.LAt = z.aUg();
    this.uku.scene = paramInt;
    this.uku.uio = paramaut;
    this.tuL.put("liveId", paramLong1);
    this.tuL.put("objectId", paramLong2);
    this.tuL.put("username", this.uku.LAt);
    paramString = new d.a();
    paramString.c((com.tencent.mm.bw.a)this.uku);
    paramArrayOfByte = new aur();
    paramArrayOfByte.setBaseResponse(new BaseResponse());
    paramArrayOfByte.getBaseResponse().ErrMsg = new dqi();
    paramString.d((com.tencent.mm.bw.a)paramArrayOfByte);
    paramString.MB("/cgi-bin/micromsg-bin/finderliveacceptmicwithaudience");
    paramString.sG(6852);
    c(paramString.aXF());
    AppMethodBeat.o(246295);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aur paramaur);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */