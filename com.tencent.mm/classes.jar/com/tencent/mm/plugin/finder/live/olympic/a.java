package com.tencent.mm.plugin.finder.live.olympic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/CgiFinderUserPageInOlympic;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPageResponse;", "username", "", "(Ljava/lang/String;)V", "TAG", "isLoadMore", "", "()Z", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUserPageRequest;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.findersdk.b.c<FinderUserPageResponse>
{
  private byn AAB;
  private final Integer AAE;
  private final String TAG;
  private com.tencent.mm.am.c rr;
  
  public a(String paramString)
  {
    super(null);
    AppMethodBeat.i(360504);
    this.TAG = "Finder.CgiFinderUserPageInOlympic";
    this.AAB = new byn();
    this.AAE = Integer.valueOf(0);
    this.AAB.username = paramString;
    this.AAB.firstPageMD5 = "";
    this.AAB.YIZ = z.bAW();
    Object localObject1 = this.AAB;
    Object localObject2 = bi.ABn;
    ((byn)localObject1).CJv = bi.a(null);
    localObject1 = this.AAB.CJv;
    if (localObject1 != null) {
      ((atz)localObject1).scene = 0;
    }
    localObject1 = this.AAB;
    localObject2 = bi.ABn;
    ((byn)localObject1).ZDQ = bi.bTZ();
    localObject1 = new c.a();
    ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)this.AAB);
    localObject2 = new FinderUserPageResponse();
    ((FinderUserPageResponse)localObject2).setBaseResponse(new kd());
    ((FinderUserPageResponse)localObject2).getBaseResponse().akjO = new etl();
    ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)localObject2);
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderuserpage";
    ((c.a)localObject1).funcId = 3736;
    localObject1 = ((c.a)localObject1).bEF();
    s.s(localObject1, "builder.buildInstance()");
    this.rr = ((com.tencent.mm.am.c)localObject1);
    c(this.rr);
    Log.i(this.TAG, s.X("init username:", paramString));
    AppMethodBeat.o(360504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.a
 * JD-Core Version:    0.7.0.1
 */