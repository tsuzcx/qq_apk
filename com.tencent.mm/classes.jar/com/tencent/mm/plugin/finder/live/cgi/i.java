package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.live.b.l.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.protocal.protobuf.azo;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveGetGameTeamInfo;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetGameTeamInfoResponse;", "feedId", "", "liveId", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "nonceId", "", "(JJLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;)V", "TAG", "getFeedId", "()J", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "getNonceId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetGameTeamInfoRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class i
  extends c<azo>
{
  private final String TAG;
  private final long feedId;
  private final long liveId;
  private final String nonceId;
  private azn xYb;
  private final b xak;
  
  public i(long paramLong1, long paramLong2, b paramb, String paramString)
  {
    super(null);
    AppMethodBeat.i(286576);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.xak = paramb;
    this.nonceId = paramString;
    this.TAG = "Finder.CgiFinderLiveGetGameTeamInfo";
    this.xYb = new azn();
    paramb = this.xYb;
    paramString = ao.xcj;
    paramb.RLM = ao.dnO();
    this.xYb.object_id = this.feedId;
    this.xYb.klE = this.liveId;
    this.xYb.RLO = this.xak;
    this.xYb.object_nonce_id = this.nonceId;
    this.xYb.RLN = z.bdh();
    paramb = this.xYb;
    paramString = l.k.kuV;
    paramb.scene = l.k.aNW();
    paramb = new d.a();
    paramb.c((a)this.xYb);
    paramString = new azo();
    paramString.setBaseResponse(new jh());
    paramString.getBaseResponse().Tef = new eaf();
    paramb.d((a)paramString);
    paramb.TW("/cgi-bin/micromsg-bin/finderlivegetgameteaminfo");
    paramb.vD(4159);
    c(paramb.bgN());
    Log.i(this.TAG, "init feedId:" + this.feedId + ", liveId:" + this.liveId + ", nonceId:" + this.nonceId + ", liveCookies size:" + this.xak.UH.length);
    AppMethodBeat.o(286576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.i
 * JD-Core Version:    0.7.0.1
 */