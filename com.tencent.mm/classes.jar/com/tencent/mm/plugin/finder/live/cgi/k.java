package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bhg;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetAuthorization;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;", "appid", "", "scene", "", "ticket", "opType", "(Ljava/lang/String;ILjava/lang/String;I)V", "TAG", "getAppid", "()Ljava/lang/String;", "getOpType", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationRequest;", "getScene", "getTicket", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends c<bhh>
{
  private final String TAG;
  private final String appid;
  private final String hFb;
  private final int opType;
  private final int scene;
  private bhg wNg;
  
  public k(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(351172);
    this.appid = paramString1;
    this.scene = paramInt1;
    this.hFb = paramString2;
    this.opType = paramInt2;
    this.TAG = "Finder.CgiFinderLiveGetAuthorization";
    this.wNg = new bhg();
    paramString1 = this.wNg;
    paramString2 = bi.ABn;
    paramString1.YIY = bi.dVu();
    this.wNg.YIZ = z.bAW();
    this.wNg.ZQS = q.aPg();
    this.wNg.hFb = this.hFb;
    this.wNg.app_id = this.appid;
    this.wNg.scene = this.scene;
    this.wNg.YAN = this.opType;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.wNg);
    paramString2 = new bhh();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderlivegetauthorization";
    paramString1.funcId = 4261;
    c(paramString1.bEF());
    Log.i(this.TAG, "init " + this.appid + ", " + this.scene);
    AppMethodBeat.o(351172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.k
 * JD-Core Version:    0.7.0.1
 */