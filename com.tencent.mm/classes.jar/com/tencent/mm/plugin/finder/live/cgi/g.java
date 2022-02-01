package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetAuthorization;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationResponse;", "appid", "", "scene", "", "ticket", "opType", "(Ljava/lang/String;ILjava/lang/String;I)V", "TAG", "getAppid", "()Ljava/lang/String;", "getOpType", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetAuthorizationRequest;", "getScene", "getTicket", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class g
  extends c<azk>
{
  private final String TAG;
  private final String appid;
  private final String fAo;
  private final int opType;
  private final int scene;
  private azj tJJ;
  
  public g(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(288762);
    this.appid = paramString1;
    this.scene = paramInt1;
    this.fAo = paramString2;
    this.opType = paramInt2;
    this.TAG = "Finder.CgiFinderLiveGetAuthorization";
    this.tJJ = new azj();
    paramString1 = this.tJJ;
    paramString2 = ao.xcj;
    paramString1.RLM = ao.dnO();
    this.tJJ.RLN = z.bdh();
    this.tJJ.SLk = q.auM();
    this.tJJ.fAo = this.fAo;
    this.tJJ.app_id = this.appid;
    this.tJJ.scene = this.scene;
    this.tJJ.SLl = this.opType;
    paramString1 = new d.a();
    paramString1.c((a)this.tJJ);
    paramString2 = new azk();
    paramString2.setBaseResponse(new jh());
    paramString2.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramString2);
    paramString1.TW("/cgi-bin/micromsg-bin/finderlivegetauthorization");
    paramString1.vD(4261);
    c(paramString1.bgN());
    Log.i(this.TAG, "init " + this.appid + ", " + this.scene);
    AppMethodBeat.o(288762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.g
 * JD-Core Version:    0.7.0.1
 */