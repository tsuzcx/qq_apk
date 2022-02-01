package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bhb;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGamePopScene;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGamePopSceneResponse;", "scene", "", "(I)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGamePopSceneRequest;", "getScene", "()I", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends c<bhc>
{
  private bhb CJL;
  private final String TAG;
  private final int scene;
  
  public z()
  {
    super(null);
    AppMethodBeat.i(360279);
    this.scene = 1;
    this.TAG = "Finder.CgiFinderLiveGamePopScene";
    this.CJL = new bhb();
    Object localObject1 = this.CJL;
    Object localObject2 = bi.ABn;
    ((bhb)localObject1).YIY = bi.a(this.Auc);
    this.CJL.scene = this.scene;
    localObject1 = new c.a();
    ((c.a)localObject1).otE = ((a)this.CJL);
    localObject2 = new bhc();
    ((bhc)localObject2).setBaseResponse(new kd());
    ((bhc)localObject2).getBaseResponse().akjO = new etl();
    ((c.a)localObject1).otF = ((a)localObject2);
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderlivegamepopscene";
    ((c.a)localObject1).funcId = 6965;
    c(((c.a)localObject1).bEF());
    Log.i(this.TAG, s.X("init scene:", Integer.valueOf(this.scene)));
    AppMethodBeat.o(360279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.z
 * JD-Core Version:    0.7.0.1
 */