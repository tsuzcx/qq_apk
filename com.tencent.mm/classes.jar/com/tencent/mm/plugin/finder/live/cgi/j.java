package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveFanClubMember;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetFanClubMembersResponse;", "cookies", "Lcom/tencent/mm/protobuf/ByteString;", "liveId", "", "objectId", "lastBuff", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protobuf/ByteString;JJLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetFanClubMembersRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveGetFanClubMembersRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends c<bhr>
{
  private final bhq Cvr;
  private final String TAG;
  
  public j(b paramb1, long paramLong1, long paramLong2, b paramb2, int paramInt)
  {
    super(null);
    AppMethodBeat.i(351175);
    this.TAG = "CgiFinderLiveFanClubMember";
    this.Cvr = new bhq();
    bhq localbhq = this.Cvr;
    bi localbi = bi.ABn;
    localbhq.YIY = bi.dVu();
    this.Cvr.YIZ = z.bAW();
    this.Cvr.YJa = paramb1;
    this.Cvr.mMJ = paramLong1;
    this.Cvr.object_id = paramLong2;
    this.Cvr.ZEQ = paramb2;
    this.Cvr.scene = paramInt;
    paramb1 = new c.a();
    paramb1.otE = ((a)this.Cvr);
    paramb2 = new bhr();
    paramb2.setBaseResponse(new kd());
    paramb2.getBaseResponse().akjO = new etl();
    paramb1.otF = ((a)paramb2);
    paramb1.uri = "/cgi-bin/micromsg-bin/finderlivegetfanclubmembers";
    paramb1.funcId = 6282;
    c(paramb1.bEF());
    Log.i(this.TAG, "init " + this.Cvr.YIZ + ',' + this.Cvr.YJa + ',' + this.Cvr.mMJ + ',' + this.Cvr.object_id + ',' + this.Cvr.ZEQ + ',' + this.Cvr.scene);
    AppMethodBeat.o(351175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.j
 * JD-Core Version:    0.7.0.1
 */