package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.protocal.protobuf.bht;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetGameTeamInfo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetGameTeamInfoResponse;", "feedId", "", "liveId", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "nonceId", "", "(JJLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "TAG", "getFeedId", "()J", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "getNonceId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetGameTeamInfoRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends c<bht>
{
  private final b Ayh;
  private bhs Cvv;
  private final String TAG;
  private final long feedId;
  private final long liveId;
  private final String nonceId;
  
  public m(long paramLong1, long paramLong2, b paramb, String paramString)
  {
    super(null);
    AppMethodBeat.i(351170);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.Ayh = paramb;
    this.nonceId = paramString;
    this.TAG = "Finder.CgiFinderLiveGetGameTeamInfo";
    this.Cvv = new bhs();
    paramb = this.Cvv;
    paramString = bi.ABn;
    paramb.YIY = bi.dVu();
    this.Cvv.object_id = this.feedId;
    this.Cvv.mMJ = this.liveId;
    this.Cvv.YJa = this.Ayh;
    this.Cvv.object_nonce_id = this.nonceId;
    this.Cvv.YIZ = z.bAW();
    paramb = this.Cvv;
    paramString = l.k.mYO;
    paramb.scene = l.k.bhH();
    paramb = new c.a();
    paramb.otE = ((a)this.Cvv);
    paramString = new bht();
    paramString.setBaseResponse(new kd());
    paramString.getBaseResponse().akjO = new etl();
    paramb.otF = ((a)paramString);
    paramb.uri = "/cgi-bin/micromsg-bin/finderlivegetgameteaminfo";
    paramb.funcId = 4159;
    c(paramb.bEF());
    Log.i(this.TAG, "init feedId:" + this.feedId + ", liveId:" + this.liveId + ", nonceId:" + this.nonceId + ", liveCookies size:" + this.Ayh.Op.length);
    AppMethodBeat.o(351170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.m
 * JD-Core Version:    0.7.0.1
 */