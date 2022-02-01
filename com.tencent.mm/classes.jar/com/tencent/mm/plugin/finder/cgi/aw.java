package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderliveGetTeamupGiftPrepare;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetTeamupGiftPrepareResponse;", "feedId", "", "liveId", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "nonceId", "", "reddotId", "(JJLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getFeedId", "()J", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "getNonceId", "()Ljava/lang/String;", "getReddotId", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetTeamupGiftPrepareRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends c<bij>
{
  private final String AAN;
  private bii AAO;
  private final b Ayh;
  private final String TAG;
  private final long feedId;
  private final long liveId;
  private final String nonceId;
  
  public aw(long paramLong1, long paramLong2, b paramb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(336184);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.Ayh = paramb;
    this.nonceId = paramString1;
    this.AAN = paramString2;
    this.TAG = "Finder.CgiFinderliveGetTeamupGiftPrepare";
    this.AAO = new bii();
    paramb = this.AAO;
    paramString1 = bi.ABn;
    paramb.YIY = bi.dVu();
    this.AAO.object_id = this.feedId;
    this.AAO.mMJ = this.liveId;
    this.AAO.YJa = this.Ayh;
    this.AAO.object_nonce_id = this.nonceId;
    paramString2 = this.AAO;
    paramString1 = this.AAN;
    paramb = paramString1;
    if (paramString1 == null) {
      paramb = "";
    }
    paramString2.ZQJ = paramb;
    this.AAO.YIZ = z.bAW();
    paramb = this.AAO;
    paramString1 = l.k.mYO;
    paramb.scene = l.k.bhH();
    paramb = new c.a();
    paramb.otE = ((a)this.AAO);
    paramString1 = new bij();
    paramString1.setBaseResponse(new kd());
    paramString1.getBaseResponse().akjO = new etl();
    paramb.otF = ((a)paramString1);
    paramb.uri = "/cgi-bin/micromsg-bin/finderlivegetteamupgiftprepare";
    paramb.funcId = 6863;
    c(paramb.bEF());
    Log.i(this.TAG, "init feedId:" + this.feedId + ", liveId:" + this.liveId + ", object_nonce_id:" + this.nonceId + ", reddot_id:" + this.AAN);
    AppMethodBeat.o(336184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aw
 * JD-Core Version:    0.7.0.1
 */