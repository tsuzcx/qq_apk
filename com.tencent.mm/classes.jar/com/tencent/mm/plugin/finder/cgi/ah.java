package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFavReq;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class ah
  extends an<dyo>
{
  public static final a KJn;
  private static long qow;
  private dyn KJl;
  private final g KJm;
  private final String TAG;
  private long qou;
  
  static
  {
    AppMethodBeat.i(197249);
    KJn = new a((byte)0);
    AppMethodBeat.o(197249);
  }
  
  public ah(g paramg, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197248);
    this.KJm = paramg;
    this.TAG = "Finder.CgiFinderFavFeed";
    this.qou = ce.asR();
    long l;
    if (this.qou < qow)
    {
      l = qow;
      qow = 1L + l;
      this.qou = l;
    }
    qow = this.qou;
    this.KJl = new dyn();
    paramg = this.KJl;
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cpa())
    {
      l = 0L;
      paramg.objectId = l;
      this.KJl.objectNonceId = this.KJm.objectNonceId;
      this.KJl.pZL = this.qou;
      this.KJl.finderUsername = u.aqO();
      paramg = this.KJl;
      if (!this.KJm.Lak) {
        break label519;
      }
      i = 1;
      label158:
      paramg.dvW = i;
      paramg = this.KJl;
      localObject = am.KJy;
      paramg.DlF = am.a(paramdzp);
      paramg = this.KJl;
      localObject = com.tencent.mm.plugin.finder.report.b.qFq;
      l = this.KJm.feedId;
      if (paramdzp == null) {
        break label524;
      }
    }
    label519:
    label524:
    for (int i = paramdzp.qqE;; i = 0)
    {
      paramg.sessionBuffer = com.tencent.mm.plugin.finder.report.b.am(l, i);
      ad.i(this.TAG, "likeId:" + this.qou + " objectId:" + this.KJl.objectId + " opType:" + this.KJl.dvW + " likeId:" + this.KJl.pZL + " username:" + this.KJl.finderUsername + " action:" + this.KJm.Lak);
      paramg = new b.a();
      paramg.c((a)this.KJl);
      paramdzp = new dyo();
      paramdzp.setBaseResponse(new BaseResponse());
      paramdzp.getBaseResponse().ErrMsg = new cmf();
      paramg.d((a)paramdzp);
      paramg.wg("/cgi-bin/micromsg-bin/finderfav");
      paramg.nB(3715);
      c(paramg.atI());
      ad.i(this.TAG, "likeId:" + this.qou + " CgiFinderLikeComment init " + this.KJl.objectId + " and userName " + this.KJm.qRJ.getUserName() + " nickname " + this.KJm.qRJ.getNickName() + " totalCount:" + this.KJm.qRJ.getLikeCount());
      AppMethodBeat.o(197248);
      return;
      l = this.KJm.feedId;
      break;
      i = 2;
      break label158;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ah
 * JD-Core Version:    0.7.0.1
 */