package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends o<bcx>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private final a CIL;
  private bcw CIM;
  private final String TAG;
  
  public a(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, bdm parambdm, a parama)
  {
    AppMethodBeat.i(360309);
    this.CIL = parama;
    this.TAG = "Finder.CgiFinderAcceptLiveMic";
    this.CIM = new bcw();
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CIM.mMJ = paramLong1;
    parama = this.CIM;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CIM.object_id = paramLong2;
    this.CIM.object_nonce_id = paramString;
    this.CIM.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CIM.YIZ = z.bAW();
    this.CIM.scene = paramInt;
    this.CIM.CER = parambdm;
    this.ABH.put("liveId", paramLong1);
    this.ABH.put("objectId", paramLong2);
    this.ABH.put("username", this.CIM.YIZ);
    paramString = new c.a();
    paramString.otE = ((com.tencent.mm.bx.a)this.CIM);
    paramArrayOfByte = new bcx();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((com.tencent.mm.bx.a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/finderliveacceptmicwithaudience";
    paramString.funcId = 6852;
    c(paramString.bEF());
    AppMethodBeat.o(360309);
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  public final JSONObject dVk()
  {
    return this.ABH;
  }
  
  public final JSONObject dVl()
  {
    return this.AAn;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAcceptMicWithAudienceResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bcx parambcx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.a
 * JD-Core Version:    0.7.0.1
 */