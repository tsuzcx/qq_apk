package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.live.b.l.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveJoinGameTeamPrepare;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveJoinGameTeamPrepareResponse;", "feedId", "", "liveId", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "nonceId", "", "(JJLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "TAG", "getFeedId", "()J", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "getNonceId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveJoinGameTeamPrepareRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class w
  extends c<bae>
{
  private final String TAG;
  private final long feedId;
  private final long liveId;
  private final String nonceId;
  private final b xak;
  private bad xbj;
  
  public w(long paramLong1, long paramLong2, b paramb, String paramString)
  {
    super(null);
    AppMethodBeat.i(267379);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.xak = paramb;
    this.nonceId = paramString;
    this.TAG = "Finder.CgiFinderLiveJoinGameTeamPrepare";
    this.xbj = new bad();
    paramb = this.xbj;
    paramString = ao.xcj;
    paramb.RLM = ao.dnO();
    this.xbj.object_id = this.feedId;
    this.xbj.klE = this.liveId;
    this.xbj.RLO = this.xak;
    this.xbj.object_nonce_id = this.nonceId;
    this.xbj.RLN = z.bdh();
    paramb = this.xbj;
    paramString = l.k.kuV;
    paramb.scene = l.k.aNW();
    paramb = new d.a();
    paramb.c((a)this.xbj);
    paramString = new bae();
    paramString.setBaseResponse(new jh());
    paramString.getBaseResponse().Tef = new eaf();
    paramb.d((a)paramString);
    paramb.TW("/cgi-bin/micromsg-bin/finderlivejoingameteamprepare");
    paramb.vD(6235);
    c(paramb.bgN());
    Log.i(this.TAG, "init feedId:" + this.feedId + ", liveId:" + this.liveId + ", nonceId:" + this.nonceId + ", liveCookies size:" + this.xak.UH.length);
    AppMethodBeat.o(267379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.w
 * JD-Core Version:    0.7.0.1
 */