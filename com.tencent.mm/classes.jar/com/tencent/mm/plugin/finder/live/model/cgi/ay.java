package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "liveId", "", "objectId", "nonceId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "(JJLjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
  extends o<bov>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private a CKK;
  private bou CKL;
  private final String TAG;
  
  public ay(long paramLong1, long paramLong2, String paramString, a parama)
  {
    AppMethodBeat.i(360223);
    this.TAG = "Finder.CgiFinderManualCloseLive";
    this.CKK = parama;
    this.CKL = new bou();
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CKL.mMJ = paramLong1;
    this.CKL.YIZ = z.bAW();
    this.CKL.object_id = paramLong2;
    this.CKL.object_nonce_id = paramString;
    this.AAn.put("liveId", paramLong1);
    this.AAn.put("username", this.CKL.YIZ);
    this.AAn.put("object_id", paramLong2);
    paramString = new c.a();
    paramString.otE = ((a)this.CKL);
    parama = new bov();
    parama.setBaseResponse(new kd());
    parama.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)parama);
    paramString.uri = "/cgi-bin/micromsg-bin/findermanualcloselive";
    paramString.funcId = 5857;
    c(paramString.bEF());
    Log.i(this.TAG, "CgiFinderManualCloseLive init liveId:" + this.CKL.mMJ + ", objectId:" + this.CKL.object_id + ", nonceId:" + this.CKL.object_nonce_id + ", finderUsername:" + this.CKL.YIZ);
    AppMethodBeat.o(360223);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bov parambov);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ay
 * JD-Core Version:    0.7.0.1
 */