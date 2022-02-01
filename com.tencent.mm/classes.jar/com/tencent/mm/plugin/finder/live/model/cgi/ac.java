package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.a.t;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject;", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLive;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "username", "", "callback", "Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/findersdk/api/ICgiFinderLiveGetLastObjectCallback;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectRequest;", "requestExt", "Lorg/json/JSONObject;", "resultExt", "actionExt", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends o<azf>
{
  private final JSONObject AAn;
  private final JSONObject ABH;
  private t CJQ;
  private aze CJR;
  private final String TAG;
  
  public ac(String paramString, t paramt)
  {
    AppMethodBeat.i(360227);
    this.TAG = "Finder.CgiFinderLiveGetLastObject";
    this.AAn = new JSONObject();
    this.ABH = new JSONObject();
    this.CJQ = paramt;
    this.CJR = new aze();
    this.CJR.Azl = paramString;
    paramt = this.CJR;
    bi localbi = bi.ABn;
    paramt.ZEc = bi.dVu();
    this.ABH.put("username", paramString);
    paramString = new c.a();
    paramString.otE = ((a)this.CJR);
    paramt = new azf();
    paramt.setBaseResponse(new kd());
    paramt.getBaseResponse().akjO = new etl();
    paramString.otF = ((a)paramt);
    paramString.uri = "/cgi-bin/micromsg-bin/findergetlatestliveobject";
    paramString.funcId = 6482;
    c(paramString.bEF());
    Log.i(this.TAG, s.X("CgiFinderLiveGetLastObject init username:", this.CJR.Azl));
    AppMethodBeat.o(360227);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ac
 * JD-Core Version:    0.7.0.1
 */