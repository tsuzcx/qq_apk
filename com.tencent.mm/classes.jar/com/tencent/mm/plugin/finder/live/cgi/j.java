package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetUserGameConfig;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetUserGameConfigResponse;", "appid", "", "scene", "", "(Ljava/lang/String;I)V", "TAG", "getAppid", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetUserGameConfigRequest;", "getScene", "()I", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class j
  extends c<baa>
{
  private final String TAG;
  private final String appid;
  private final int scene;
  private azz xYc;
  
  public j(String paramString, int paramInt)
  {
    super(null);
    AppMethodBeat.i(287157);
    this.appid = paramString;
    this.scene = paramInt;
    this.TAG = "Finder.CgiFinderLiveGetUserGameConfig";
    this.xYc = new azz();
    paramString = this.xYc;
    Object localObject = ao.xcj;
    paramString.RLM = ao.dnO();
    this.xYc.RLN = z.bdh();
    this.xYc.app_id = this.appid;
    this.xYc.scene = this.scene;
    paramString = this.xYc;
    localObject = p.ADF;
    paramString.SLA = p.ecZ();
    paramString = new d.a();
    paramString.c((a)this.xYc);
    localObject = new baa();
    ((baa)localObject).setBaseResponse(new jh());
    ((baa)localObject).getBaseResponse().Tef = new eaf();
    paramString.d((a)localObject);
    paramString.TW("/cgi-bin/micromsg-bin/finderlivegetusergameconfig");
    paramString.vD(5274);
    c(paramString.bgN());
    Log.i(this.TAG, "init " + this.appid + ", " + this.scene);
    AppMethodBeat.o(287157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.j
 * JD-Core Version:    0.7.0.1
 */