package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLivePushOrCancelPromote;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAnchorSendPromoteInfoResponse;", "objectId", "", "liveId", "item", "Lcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoAnchor;", "(JJLcom/tencent/mm/protocal/protobuf/FinderLivePromoteInfoAnchor;)V", "TAG", "", "getLiveId", "()J", "getObjectId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAnchorSendPromoteInfoRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends c<bdl>
{
  private bdk CvD;
  private final String TAG;
  private final long hKN;
  private final long liveId;
  
  public s(long paramLong1, long paramLong2, bkv parambkv)
  {
    super(null);
    AppMethodBeat.i(351148);
    this.hKN = paramLong1;
    this.liveId = paramLong2;
    this.TAG = "Finder.CgiFinderLivePushOrCancelPromote";
    this.CvD = new bdk();
    Object localObject1 = this.CvD;
    Object localObject2 = bi.ABn;
    ((bdk)localObject1).YIY = bi.dVu();
    this.CvD.object_id = this.hKN;
    this.CvD.mMJ = this.liveId;
    this.CvD.YIZ = z.bAW();
    this.CvD.ZNV = parambkv.id;
    localObject1 = this.CvD;
    if (parambkv.ZTV) {}
    for (int i = 2;; i = 1)
    {
      ((bdk)localObject1).scene = i;
      localObject1 = new c.a();
      ((c.a)localObject1).otE = ((a)this.CvD);
      localObject2 = new bdl();
      ((bdl)localObject2).setBaseResponse(new kd());
      ((bdl)localObject2).getBaseResponse().akjO = new etl();
      ((c.a)localObject1).otF = ((a)localObject2);
      ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/finderliveanchorsendpromoteinfo";
      ((c.a)localObject1).funcId = 5970;
      c(((c.a)localObject1).bEF());
      Log.i(this.TAG, "init liveId:" + this.liveId + ", objectId:" + this.hKN + "}, promoteId:" + parambkv.id + ", scene:" + this.CvD.scene);
      AppMethodBeat.o(351148);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.s
 * JD-Core Version:    0.7.0.1
 */