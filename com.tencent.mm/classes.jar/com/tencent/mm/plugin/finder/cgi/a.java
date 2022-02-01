package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.hr;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiAudienceSendCommentToReserveGame;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/AudienceSendCommentToReserveGameResponse;", "feedId", "", "liveId", "liveCookies", "Lcom/tencent/mm/protobuf/ByteString;", "comment_msg", "", "finderUsername", "(JJLcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getComment_msg", "()Ljava/lang/String;", "getFeedId", "()J", "getFinderUsername", "getLiveCookies", "()Lcom/tencent/mm/protobuf/ByteString;", "getLiveId", "request", "Lcom/tencent/mm/protocal/protobuf/AudienceSendCommentToReserveGameRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<hs>
{
  private final b Ayh;
  private final String Ayi;
  private hr Ayj;
  private final String TAG;
  private final long feedId;
  private final String finderUsername;
  private final long liveId;
  
  public a(long paramLong1, long paramLong2, b paramb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(336301);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.Ayh = paramb;
    this.Ayi = paramString1;
    this.finderUsername = paramString2;
    this.TAG = "Finder.CgiAudienceSendCommentToReserveGame";
    this.Ayj = new hr();
    paramb = this.Ayj;
    paramString1 = bi.ABn;
    paramb.YIY = bi.dVu();
    this.Ayj.object_id = this.feedId;
    this.Ayj.mMJ = this.liveId;
    this.Ayj.YJa = this.Ayh;
    this.Ayj.Ayi = this.Ayi;
    this.Ayj.YIZ = this.finderUsername;
    paramb = this.Ayj;
    paramString1 = l.k.mYO;
    paramb.scene = l.k.bhH();
    paramb = new c.a();
    paramb.otE = ((com.tencent.mm.bx.a)this.Ayj);
    paramString1 = new hs();
    paramString1.setBaseResponse(new kd());
    paramString1.getBaseResponse().akjO = new etl();
    paramb.otF = ((com.tencent.mm.bx.a)paramString1);
    paramb.uri = "/cgi-bin/micromsg-bin/audiencesendcommenttoreservegame";
    paramb.funcId = 4226;
    c(paramb.bEF());
    Log.i(this.TAG, "init feedId:" + this.feedId + ", liveId:" + this.liveId + ", comment_msg:" + this.Ayi + ", liveCookies size:" + this.Ayh.Op.length);
    AppMethodBeat.o(336301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a
 * JD-Core Version:    0.7.0.1
 */