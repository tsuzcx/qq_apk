package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAudienceOpFanClub;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceOpFanClubResponse;", "opCode", "", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "liveId", "", "objectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protobuf/ByteString;JJLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getOpCode", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceOpFanClubRequest;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceOpFanClubRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends c<bfj>
{
  private final b Ayh;
  private final bfi Cvl;
  private final String TAG;
  private final int hHC;
  
  public f(int paramInt, b paramb, long paramLong1, long paramLong2)
  {
    super(null);
    AppMethodBeat.i(351135);
    this.hHC = paramInt;
    this.Ayh = paramb;
    this.TAG = "CgiFinderLiveAudienceOpFanClub";
    this.Cvl = new bfi();
    paramb = this.Cvl;
    Object localObject = bi.ABn;
    paramb.YIY = bi.dVu();
    this.Cvl.YIZ = z.bAW();
    this.Cvl.ZlE = this.hHC;
    this.Cvl.YJa = this.Ayh;
    this.Cvl.mMJ = paramLong1;
    this.Cvl.object_id = paramLong2;
    paramb = new c.a();
    paramb.otE = ((a)this.Cvl);
    localObject = new bfj();
    ((bfj)localObject).setBaseResponse(new kd());
    ((bfj)localObject).getBaseResponse().akjO = new etl();
    paramb.otF = ((a)localObject);
    paramb.uri = "/cgi-bin/micromsg-bin/finderliveaudienceopfanclub";
    paramb.funcId = 4143;
    c(paramb.bEF());
    Log.i(this.TAG, "init " + this.Cvl.YIZ + ',' + this.Cvl.ZlE + ',' + this.Cvl.YJa + ',' + this.Cvl.mMJ + ',' + this.Cvl.object_id);
    AppMethodBeat.o(351135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.f
 * JD-Core Version:    0.7.0.1
 */