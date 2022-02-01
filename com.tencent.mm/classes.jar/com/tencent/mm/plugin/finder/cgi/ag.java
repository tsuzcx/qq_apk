package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.protocal.protobuf.bit;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveJoinGameTeamPrepare;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveJoinGameTeamPrepareResponse;", "feedId", "", "liveId", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "nonceId", "", "(JJLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "TAG", "getFeedId", "()J", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "getNonceId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveJoinGameTeamPrepareRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends c<bit>
{
  private final b Ayh;
  private bis AzN;
  private final String TAG;
  private final long feedId;
  private final long liveId;
  private final String nonceId;
  
  public ag(long paramLong1, long paramLong2, b paramb, String paramString)
  {
    super(null);
    AppMethodBeat.i(336267);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.Ayh = paramb;
    this.nonceId = paramString;
    this.TAG = "Finder.CgiFinderLiveJoinGameTeamPrepare";
    this.AzN = new bis();
    paramb = this.AzN;
    paramString = bi.ABn;
    paramb.YIY = bi.dVu();
    this.AzN.object_id = this.feedId;
    this.AzN.mMJ = this.liveId;
    this.AzN.YJa = this.Ayh;
    this.AzN.object_nonce_id = this.nonceId;
    this.AzN.YIZ = z.bAW();
    paramb = this.AzN;
    paramString = l.k.mYO;
    paramb.scene = l.k.bhH();
    paramb = new c.a();
    paramb.otE = ((a)this.AzN);
    paramString = new bit();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    paramb.otF = ((a)paramString);
    paramb.uri = "/cgi-bin/micromsg-bin/finderlivejoingameteamprepare";
    paramb.funcId = 6235;
    c(paramb.bEF());
    Log.i(this.TAG, "init feedId:" + this.feedId + ", liveId:" + this.liveId + ", nonceId:" + this.nonceId + ", liveCookies size:" + this.Ayh.Op.length);
    AppMethodBeat.o(336267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ag
 * JD-Core Version:    0.7.0.1
 */