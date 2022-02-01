package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetPromoteInfoList;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAnchorGetPromoteInfoListResponse;", "objectId", "", "liveId", "(JJ)V", "TAG", "", "getLiveId", "()J", "getObjectId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAnchorGetPromoteInfoListRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends c<bde>
{
  private bdd Cvx;
  private final String TAG;
  private final long hKN;
  private final long liveId;
  
  public o(long paramLong1, long paramLong2)
  {
    super(null);
    AppMethodBeat.i(351191);
    this.hKN = paramLong1;
    this.liveId = paramLong2;
    this.TAG = "Finder.CgiFinderLiveGetPromoteInfoList";
    this.Cvx = new bdd();
    Object localObject1 = this.Cvx;
    Object localObject2 = bi.ABn;
    ((bdd)localObject1).YIY = bi.dVu();
    this.Cvx.object_id = this.hKN;
    this.Cvx.mMJ = this.liveId;
    this.Cvx.YIZ = z.bAW();
    localObject1 = new c.a();
    ((c.a)localObject1).otE = ((a)this.Cvx);
    localObject2 = new bde();
    ((bde)localObject2).setBaseResponse(new kd());
    ((bde)localObject2).getBaseResponse().akjO = new etl();
    ((c.a)localObject1).otF = ((a)localObject2);
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderliveanchorgetpromoteinfolist";
    ((c.a)localObject1).funcId = 5250;
    c(((c.a)localObject1).bEF());
    Log.i(this.TAG, "init liveId:" + this.liveId + ", objectId:" + this.hKN + '}');
    AppMethodBeat.o(351191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.o
 * JD-Core Version:    0.7.0.1
 */