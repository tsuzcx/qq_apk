package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aue;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "liveId", "", "liveCookies", "", "finderUsername", "", "objectId", "role", "", "nonceId", "sessionBuffer", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive$CallBack;", "(J[BLjava/lang/String;JILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class i
  extends k<auf>
{
  private final String TAG;
  private final JSONObject ttQ;
  private final JSONObject tuL;
  private a ukK;
  private aue ukL;
  
  public i(long paramLong1, byte[] paramArrayOfByte, String paramString1, long paramLong2, int paramInt, String paramString2, String paramString3, a parama)
  {
    super((byte)0);
    AppMethodBeat.i(246315);
    this.TAG = "Finder.CgiFinderJoinLive";
    this.ukK = parama;
    this.ukL = new aue();
    this.ttQ = new JSONObject();
    this.tuL = new JSONObject();
    parama = this.ukL;
    am localam = am.tuw;
    parama.LAI = am.cXY();
    this.ukL.liveId = paramLong1;
    this.ukL.LDx = com.tencent.mm.bw.b.cD(paramArrayOfByte);
    this.ukL.finderUsername = paramString1;
    this.ukL.hFK = paramLong2;
    this.ukL.scene = paramInt;
    this.ukL.object_nonce_id = paramString2;
    this.ukL.LER = paramString3;
    this.tuL.put("liveId", paramLong1);
    this.tuL.put("finderUsername", paramString1);
    this.tuL.put("objectId", paramLong2);
    this.tuL.put("scene", paramInt);
    paramArrayOfByte = new d.a();
    paramArrayOfByte.c((a)this.ukL);
    paramString1 = new auf();
    paramString1.setBaseResponse(new BaseResponse());
    paramString1.getBaseResponse().ErrMsg = new dqi();
    paramArrayOfByte.d((a)paramString1);
    paramArrayOfByte.MB("/cgi-bin/micromsg-bin/finderjoinlive");
    paramArrayOfByte.sG(3539);
    c(paramArrayOfByte.aXF());
    paramArrayOfByte = this.TAG;
    paramString1 = new StringBuilder("CgiFinderJoinLive init ").append(this.ukL.liveId).append(',').append(this.ukL.finderUsername).append(',').append(this.ukL.scene).append(",liveCookies is null:");
    if (this.ukL.LDx == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(paramArrayOfByte, bool + ", sessionBuffer:" + this.ukL.LER);
      AppMethodBeat.o(246315);
      return;
    }
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderJoinLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, auf paramauf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.i
 * JD-Core Version:    0.7.0.1
 */