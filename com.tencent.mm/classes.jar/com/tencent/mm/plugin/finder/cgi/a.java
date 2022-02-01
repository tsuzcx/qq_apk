package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.live.b.l.k;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.gy;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiAudienceSendCommentToReserveGame;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/AudienceSendCommentToReserveGameResponse;", "feedId", "", "liveId", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "comment_msg", "", "finderUsername", "(JJLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getComment_msg", "()Ljava/lang/String;", "getFeedId", "()J", "getFinderUsername", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "request", "Lcom/tencent/mm/protocal/protobuf/AudienceSendCommentToReserveGameRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class a
  extends c<gy>
{
  private final String TAG;
  private final long feedId;
  private final String finderUsername;
  private final long liveId;
  private gx xaj;
  private final b xak;
  private final String xal;
  
  public a(long paramLong1, long paramLong2, b paramb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(276980);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.xak = paramb;
    this.xal = paramString1;
    this.finderUsername = paramString2;
    this.TAG = "Finder.CgiAudienceSendCommentToReserveGame";
    this.xaj = new gx();
    paramb = this.xaj;
    paramString1 = ao.xcj;
    paramb.RLM = ao.dnO();
    this.xaj.object_id = this.feedId;
    this.xaj.klE = this.liveId;
    this.xaj.RLO = this.xak;
    this.xaj.xal = this.xal;
    this.xaj.RLN = this.finderUsername;
    paramb = this.xaj;
    paramString1 = l.k.kuV;
    paramb.scene = l.k.aNW();
    paramb = new d.a();
    paramb.c((com.tencent.mm.cd.a)this.xaj);
    paramString1 = new gy();
    paramString1.setBaseResponse(new jh());
    paramString1.getBaseResponse().Tef = new eaf();
    paramb.d((com.tencent.mm.cd.a)paramString1);
    paramb.TW("/cgi-bin/micromsg-bin/audiencesendcommenttoreservegame");
    paramb.vD(4226);
    c(paramb.bgN());
    Log.i(this.TAG, "init feedId:" + this.feedId + ", liveId:" + this.liveId + ", comment_msg:" + this.xal + ", liveCookies size:" + this.xak.UH.length);
    AppMethodBeat.o(276980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a
 * JD-Core Version:    0.7.0.1
 */