package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderAcceptLiveMicResponse;", "liveId", "", "objectId", "objectNonceId", "", "liveCookie", "", "scene", "", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "(JJLjava/lang/String;[BILcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;)V", "TAG", "getCallback", "()Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderAcceptLiveMicPk$CallBack;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderAcceptLiveMicRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends o<atc>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private final b.a CIN;
  private atb CIO;
  private final String TAG;
  
  public b(long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte, int paramInt, bdm parambdm, b.a parama)
  {
    AppMethodBeat.i(360308);
    this.CIN = parama;
    this.TAG = "Finder.CgiFinderAcceptLiveMicPk";
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CIO = new atb();
    this.CIO.mMJ = paramLong1;
    parama = this.CIO;
    bi localbi = bi.ABn;
    parama.YIY = bi.dVu();
    this.CIO.object_id = paramLong2;
    this.CIO.object_nonce_id = paramString;
    this.CIO.YJa = com.tencent.mm.bx.b.cX(paramArrayOfByte);
    this.CIO.YIZ = z.bAW();
    this.CIO.scene = paramInt;
    this.CIO.CER = parambdm;
    this.ABH.put("liveId", paramLong1);
    this.ABH.put("objectId", paramLong2);
    this.ABH.put("username", this.CIO.YIZ);
    paramString = new c.a();
    paramString.otE = ((a)this.CIO);
    paramArrayOfByte = new atc();
    paramArrayOfByte.setBaseResponse(new kd());
    paramArrayOfByte.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramArrayOfByte);
    paramString.uri = "/cgi-bin/micromsg-bin/finderacceptlivemic";
    paramString.funcId = 3936;
    c(paramString.bEF());
    AppMethodBeat.o(360308);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */