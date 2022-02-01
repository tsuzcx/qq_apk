package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.a.b;
import com.tencent.mm.protocal.protobuf.bdw;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "liveId", "", "objectId", "nonceId", "", "callback", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "(JJLjava/lang/String;Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveReq;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class an
  extends n<bdx>
{
  private final String TAG;
  private final JSONObject xbw;
  private final JSONObject xcu;
  private a ykk;
  private bdw ykl;
  
  public an(long paramLong1, long paramLong2, String paramString, a parama)
  {
    AppMethodBeat.i(283854);
    this.TAG = "Finder.CgiFinderManualCloseLive";
    this.ykk = parama;
    this.ykl = new bdw();
    this.xbw = new JSONObject();
    this.xcu = new JSONObject();
    this.ykl.klE = paramLong1;
    this.ykl.RLN = z.bdh();
    this.ykl.object_id = paramLong2;
    this.ykl.object_nonce_id = paramString;
    this.xbw.put("liveId", paramLong1);
    this.xbw.put("username", this.ykl.RLN);
    this.xbw.put("object_id", paramLong2);
    paramString = new d.a();
    paramString.c((a)this.ykl);
    parama = new bdx();
    parama.setBaseResponse(new jh());
    parama.getBaseResponse().Tef = new eaf();
    paramString.d((a)parama);
    paramString.TW("/cgi-bin/micromsg-bin/findermanualcloselive");
    paramString.vD(5857);
    c(paramString.bgN());
    Log.i(this.TAG, "CgiFinderManualCloseLive init liveId:" + this.ykl.klE + ", objectId:" + this.ykl.object_id + ", nonceId:" + this.ykl.object_nonce_id + ", finderUsername:" + this.ykl.RLN);
    AppMethodBeat.o(283854);
  }
  
  public final b dnF()
  {
    return b.BvU;
  }
  
  public final JSONObject dnI()
  {
    return this.xcu;
  }
  
  public final JSONObject dnJ()
  {
    return this.xbw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderManualCloseLive$CallBack;", "", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderManualCloseLiveResp;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, bdx parambdx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.an
 * JD-Core Version:    0.7.0.1
 */