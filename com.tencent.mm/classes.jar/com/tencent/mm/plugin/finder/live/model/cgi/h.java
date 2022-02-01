package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveMicRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends o<aut>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private final a CIZ;
  private aus CJa;
  private final String TAG;
  
  public h(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, bdm parambdm, a parama)
  {
    AppMethodBeat.i(360337);
    this.CIZ = parama;
    this.TAG = "Finder.CgiFinderCloseLiveMicPk";
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CJa = new aus();
    this.CJa.mMJ = paramLong1;
    parama = this.CJa;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CJa.object_id = paramLong2;
    this.CJa.object_nonce_id = paramString;
    this.CJa.YIZ = z.bAW();
    this.CJa.scene = paramInt;
    this.CJa.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CJa.CER = parambdm;
    this.ABH.put("liveId", paramLong1);
    this.ABH.put("objectId", paramLong2);
    this.ABH.put("scene", this.CJa.scene);
    this.ABH.put("username", this.CJa.YIZ);
    paramString = new c.a();
    paramString.otE = ((a)this.CJa);
    paramArrayOfByte = new aut();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/findercloselivemic";
    paramString.funcId = 3582;
    paramString = paramString.bEF();
    Log.i(this.TAG, "liveId:" + this.CJa.mMJ + " objectId:" + this.CJa.object_id + " objectNonceId:" + this.CJa.object_nonce_id + " scene:" + this.CJa.scene);
    c(paramString);
    AppMethodBeat.o(360337);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMicPk$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCloseLiveMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, aut paramaut);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.h
 * JD-Core Version:    0.7.0.1
 */