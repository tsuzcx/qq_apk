package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFavReq;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends c<axf>
{
  public static final a AyN;
  private static long AyQ;
  private axe AyO;
  private long AyP;
  private final com.tencent.mm.plugin.finder.upload.action.b Ayu;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(336340);
    AyN = new a((byte)0);
    AppMethodBeat.o(336340);
  }
  
  public m(com.tencent.mm.plugin.finder.upload.action.b paramb, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336333);
    this.Ayu = paramb;
    this.TAG = "Finder.CgiFinderFavFeed";
    this.AyP = cn.bDv();
    long l;
    if (this.AyP < AyQ)
    {
      l = AyQ;
      AyQ = 1L + l;
      this.AyP = l;
    }
    AyQ = this.AyP;
    this.AyO = new axe();
    paramb = this.AyO;
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eQI())
    {
      l = 0L;
      paramb.hKN = l;
      this.AyO.objectNonceId = this.Ayu.objectNonceId;
      this.AyO.Acx = this.AyP;
      this.AyO.finderUsername = com.tencent.mm.model.z.bAW();
      paramb = this.AyO;
      if (!this.Ayu.GcG) {
        break label703;
      }
      i = 1;
      label161:
      paramb.hYl = i;
      paramb = this.AyO;
      localObject = bi.ABn;
      paramb.ZEc = bi.a(parambui);
      paramb = this.AyO;
      localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      l = this.Ayu.feedId;
      if (parambui != null) {
        break label708;
      }
      i = 0;
      label209:
      paramb.sessionBuffer = com.tencent.mm.plugin.finder.report.z.p(l, i);
      this.AyO.ZFJ = this.Ayu.source;
      paramb = bi.ABn;
      paramb = this.AyO.ZEc;
      if (parambui != null) {
        break label716;
      }
    }
    label703:
    label708:
    label716:
    for (int i = j;; i = parambui.AJo)
    {
      bi.a(paramb, p.listOf(new r(Integer.valueOf(i), Long.valueOf(this.Ayu.feedId))), parambui);
      if (this.AyO.hYl == 1)
      {
        paramb = new gdd();
        paramb.acaW = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQo("ce_feed_fav"));
        paramb.acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
        parambui = this.AyO.ZEc;
        if (parambui != null) {
          parambui.ZEq = new com.tencent.mm.bx.b(paramb.toByteArray());
        }
        paramb = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
        com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999701);
      }
      Log.i(this.TAG, "likeId:" + this.AyP + " objectId:" + this.AyO.hKN + " opType:" + this.AyO.hYl + " likeId:" + this.AyO.Acx + " username:" + this.AyO.finderUsername + " action:" + this.Ayu.GcG + " source:" + this.Ayu.source);
      paramb = new c.a();
      paramb.otE = ((a)this.AyO);
      parambui = new axf();
      parambui.setBaseResponse(new kd());
      parambui.getBaseResponse().akjO = new etl();
      paramb.otF = ((a)parambui);
      paramb.uri = "/cgi-bin/micromsg-bin/finderfav";
      paramb.funcId = 3715;
      c(paramb.bEF());
      Log.i(this.TAG, "likeId:" + this.AyP + " CgiFinderLikeComment init " + this.AyO.hKN + " and userName " + this.Ayu.GcF.getUserName() + " nickname " + this.Ayu.GcF.getNickName() + " totalCount:" + this.Ayu.GcF.getLikeCount());
      AppMethodBeat.o(336333);
      return;
      l = this.Ayu.feedId;
      break;
      i = 2;
      break label161;
      i = parambui.AJo;
      break label209;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.m
 * JD-Core Version:    0.7.0.1
 */