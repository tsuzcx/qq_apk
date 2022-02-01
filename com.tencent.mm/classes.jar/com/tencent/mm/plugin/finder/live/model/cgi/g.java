package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends o<bgg>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private final a CIX;
  private bgf CIY;
  private final String TAG;
  
  public g(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, bdm parambdm, a parama)
  {
    AppMethodBeat.i(360298);
    this.CIX = parama;
    this.TAG = "Finder.CgiFinderCloseLiveMic";
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CIY = new bgf();
    this.CIY.mMJ = paramLong1;
    parama = this.CIY;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CIY.object_id = paramLong2;
    this.CIY.object_nonce_id = paramString;
    this.CIY.YIZ = z.bAW();
    this.CIY.scene = paramInt;
    this.CIY.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CIY.CER = parambdm;
    this.ABH.put("liveId", paramLong1);
    this.ABH.put("objectId", paramLong2);
    this.ABH.put("scene", this.CIY.scene);
    this.ABH.put("username", this.CIY.YIZ);
    paramString = new c.a();
    paramString.otE = ((a)this.CIY);
    paramArrayOfByte = new bgg();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/finderliveclosemicwithaudience";
    paramString.funcId = 4142;
    paramString = paramString.bEF();
    Log.i(this.TAG, "liveId:" + this.CIY.mMJ + " objectId:" + this.CIY.object_id + " objectNonceId:" + this.CIY.object_nonce_id + " scene:" + this.CIY.scene);
    c(paramString);
    AppMethodBeat.o(360298);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bgg parambgg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.g
 * JD-Core Version:    0.7.0.1
 */