package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveRespondGameInvitation;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRespondGameInvitationResponse;", "feedId", "", "liveId", "nonceId", "", "invitation_id", "opType", "", "(JJLjava/lang/String;Ljava/lang/String;I)V", "TAG", "getFeedId", "()J", "getInvitation_id", "()Ljava/lang/String;", "getLiveId", "getNonceId", "getOpType", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRespondGameInvitationRequest;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  extends c<bmc>
{
  private final String AzS;
  private bmb AzT;
  private final String TAG;
  private final long feedId;
  private final long liveId;
  private final String nonceId;
  private final int opType;
  
  public ai(long paramLong1, long paramLong2, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(336228);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.nonceId = paramString1;
    this.AzS = paramString2;
    this.opType = paramInt;
    this.TAG = "Finder.CgiFinderLiveRespondGameInvitation";
    this.AzT = new bmb();
    paramString1 = this.AzT;
    paramString2 = bi.ABn;
    paramString1.YIY = bi.dVu();
    this.AzT.object_id = this.feedId;
    this.AzT.mMJ = this.liveId;
    this.AzT.object_nonce_id = this.nonceId;
    this.AzT.AzS = this.AzS;
    this.AzT.YAN = this.opType;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.AzT);
    paramString2 = new bmc();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderliverespondgameinvitation";
    paramString1.funcId = 6625;
    c(paramString1.bEF());
    Log.i(this.TAG, "init feedId:" + this.feedId + ", liveId:" + this.liveId + ", object_nonce_id:" + this.nonceId + ", linvitation_id:" + this.AzS);
    AppMethodBeat.o(336228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ai
 * JD-Core Version:    0.7.0.1
 */