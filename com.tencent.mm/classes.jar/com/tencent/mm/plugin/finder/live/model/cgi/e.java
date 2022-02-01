package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends o<atn>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private final a CIT;
  private atm CIU;
  private final String TAG;
  
  public e(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, bdm parambdm, a parama)
  {
    AppMethodBeat.i(360313);
    this.CIT = parama;
    this.TAG = "Finder.CgiFinderApplyLiveMicPk";
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CIU = new atm();
    this.CIU.mMJ = paramLong1;
    parama = this.CIU;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CIU.object_id = paramLong2;
    this.CIU.object_nonce_id = paramString;
    this.CIU.YIZ = z.bAW();
    this.CIU.scene = paramInt;
    this.CIU.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CIU.CER = parambdm;
    this.ABH.put("liveId", paramLong1);
    this.ABH.put("objectId", paramLong2);
    this.ABH.put("username", this.CIU.YIZ);
    Log.i(this.TAG, "apply live id:" + paramLong1 + " objectId:" + paramLong2 + " objectNonceId:" + paramString);
    paramString = new c.a();
    paramString.otE = ((a)this.CIU);
    paramArrayOfByte = new atn();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/finderapplylivemic";
    paramString.funcId = 3917;
    c(paramString.bEF());
    AppMethodBeat.o(360313);
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMicPk$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderApplyLiveMicResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, atn paramatn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.e
 * JD-Core Version:    0.7.0.1
 */