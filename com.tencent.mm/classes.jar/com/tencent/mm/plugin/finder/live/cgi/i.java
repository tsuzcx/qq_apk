package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bgu;
import com.tencent.mm.protocal.protobuf.bgv;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveFanClubGetIntimacy;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubGetIntimacyResp;", "anchorFinderUserName", "", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "liveId", "", "objectId", "username", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;JJLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubGetIntimacyReq;", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveFanClubGetIntimacyReq;", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends c<bgv>
{
  private final bgu Cvq;
  private final String TAG;
  
  public i(String paramString1, b paramb, long paramLong1, long paramLong2, String paramString2)
  {
    super(null);
    AppMethodBeat.i(351131);
    this.TAG = "CgiFinderLiveFanClubGetIntimacy";
    this.Cvq = new bgu();
    bgu localbgu = this.Cvq;
    bi localbi = bi.ABn;
    localbgu.YIY = bi.dVu();
    this.Cvq.ZKq = paramString1;
    this.Cvq.YJa = paramb;
    this.Cvq.mMJ = paramLong1;
    this.Cvq.object_id = paramLong2;
    this.Cvq.YIZ = paramString2;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.Cvq);
    paramb = new bgv();
    paramb.setBaseResponse(new kd());
    paramb.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramb);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderlivefanclubgetintimacy";
    paramString1.funcId = 5985;
    c(paramString1.bEF());
    Log.i(this.TAG, "init " + this.Cvq.ZKq + ',' + this.Cvq.YJa + ',' + this.Cvq.mMJ + ',' + this.Cvq.object_id);
    AppMethodBeat.o(351131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.i
 * JD-Core Version:    0.7.0.1
 */