package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.utils.t;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetUserGameConfig;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetUserGameConfigResponse;", "appid", "", "scene", "", "(Ljava/lang/String;I)V", "TAG", "getAppid", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetUserGameConfigRequest;", "getScene", "()I", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends c<bil>
{
  private bik Cvy;
  private final String TAG;
  private final String appid;
  private final int scene;
  
  public p(String paramString, int paramInt)
  {
    super(null);
    AppMethodBeat.i(351176);
    this.appid = paramString;
    this.scene = paramInt;
    this.TAG = "Finder.CgiFinderLiveGetUserGameConfig";
    this.Cvy = new bik();
    paramString = this.Cvy;
    Object localObject = bi.ABn;
    paramString.YIY = bi.dVu();
    this.Cvy.YIZ = z.bAW();
    this.Cvy.app_id = this.appid;
    this.Cvy.scene = this.scene;
    paramString = this.Cvy;
    localObject = t.GgN;
    paramString.ZRz = t.feU();
    paramString = new c.a();
    paramString.otE = ((a)this.Cvy);
    localObject = new bil();
    ((bil)localObject).setBaseResponse(new kd());
    ((bil)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/finderlivegetusergameconfig";
    paramString.funcId = 5274;
    c(paramString.bEF());
    Log.i(this.TAG, "init " + this.appid + ", " + this.scene);
    AppMethodBeat.o(351176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.p
 * JD-Core Version:    0.7.0.1
 */