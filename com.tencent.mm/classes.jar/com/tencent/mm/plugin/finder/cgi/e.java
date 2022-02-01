package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class e
  extends an<ajo>
{
  private static long qow;
  public static final a qox;
  private final String TAG;
  private ajn qoq;
  private long qou;
  private final c qov;
  
  static
  {
    AppMethodBeat.i(165171);
    qox = new a((byte)0);
    AppMethodBeat.o(165171);
  }
  
  public e(c paramc, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197256);
    this.qov = paramc;
    this.TAG = "Finder.CgiFinderLikeFeed";
    this.qou = ce.asR();
    long l;
    if (this.qou < qow)
    {
      l = qow;
      qow = 1L + l;
      this.qou = l;
    }
    qow = this.qou;
    this.qoq = new ajn();
    paramc = this.qoq;
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cpa())
    {
      l = 0L;
      paramc.objectId = l;
      this.qoq.objectNonceId = this.qov.objectNonceId;
      this.qoq.qou = this.qou;
      this.qoq.username = u.aqO();
      this.qoq.scene = this.qov.scene;
      paramc = this.qoq;
      if (!this.qov.qRK) {
        break label528;
      }
    }
    label528:
    for (int i = 3;; i = 4)
    {
      paramc.opType = i;
      paramc = this.qoq;
      localObject = am.KJy;
      paramc.Dkw = am.a(paramdzp);
      paramc = this.qoq;
      paramdzp = com.tencent.mm.plugin.finder.report.b.qFq;
      paramc.sessionBuffer = com.tencent.mm.plugin.finder.report.b.am(this.qov.feedId, this.qoq.Dkw.scene);
      ad.i(this.TAG, "likeId:" + this.qou + " objectId:" + this.qoq.objectId + " opType:" + this.qoq.opType + " likeId:" + this.qoq.qou + " username:" + this.qoq.username + " action:" + this.qov.qRK);
      paramc = new b.a();
      paramc.c((a)this.qoq);
      paramdzp = new ajo();
      paramdzp.setBaseResponse(new BaseResponse());
      paramdzp.getBaseResponse().ErrMsg = new cmf();
      paramc.d((a)paramdzp);
      paramc.wg("/cgi-bin/micromsg-bin/finderlike");
      paramc.nB(3710);
      c(paramc.atI());
      ad.i(this.TAG, "likeId:" + this.qou + " CgiFinderLikeComment init " + this.qoq.objectId + " and userName " + this.qov.qRJ.getUserName() + " nickname " + this.qov.qRJ.getNickName() + " totalCount:" + this.qov.qRJ.getLikeCount());
      AppMethodBeat.o(197256);
      return;
      l = this.qov.feedId;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.e
 * JD-Core Version:    0.7.0.1
 */