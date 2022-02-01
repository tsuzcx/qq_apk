package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.upload.action.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.asp;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFavReq;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class l
  extends c<asq>
{
  private static long xaH;
  public static final a xaI;
  private final String TAG;
  private asp xaF;
  private long xaG;
  private final b xaq;
  
  static
  {
    AppMethodBeat.i(274325);
    xaI = new a((byte)0);
    AppMethodBeat.o(274325);
  }
  
  public l(b paramb, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(274324);
    this.xaq = paramb;
    this.TAG = "Finder.CgiFinderFavFeed";
    this.xaG = cm.bfD();
    long l;
    if (this.xaG < xaH)
    {
      l = xaH;
      xaH = 1L + l;
      this.xaG = l;
    }
    xaH = this.xaG;
    this.xaF = new asp();
    paramb = this.xaF;
    Object localObject = d.AjH;
    if (d.dSu())
    {
      l = 0L;
      paramb.xbk = l;
      this.xaF.objectNonceId = this.xaq.objectNonceId;
      this.xaF.wGo = this.xaG;
      this.xaF.finderUsername = z.bdh();
      paramb = this.xaF;
      if (!this.xaq.ABw) {
        break label575;
      }
      i = 1;
      label161:
      paramb.fSo = i;
      paramb = this.xaF;
      localObject = ao.xcj;
      paramb.SDi = ao.a(parambid);
      paramb = this.xaF;
      localObject = n.zWF;
      l = this.xaq.feedId;
      if (parambid == null) {
        break label580;
      }
    }
    label575:
    label580:
    for (int i = parambid.xkX;; i = 0)
    {
      paramb.sessionBuffer = n.N(l, i);
      paramb = ao.xcj;
      paramb = this.xaF.SDi;
      i = j;
      if (parambid != null) {
        i = parambid.xkX;
      }
      ao.a(paramb, j.listOf(new o(Integer.valueOf(i), Long.valueOf(this.xaq.feedId))));
      Log.i(this.TAG, "likeId:" + this.xaG + " objectId:" + this.xaF.xbk + " opType:" + this.xaF.fSo + " likeId:" + this.xaF.wGo + " username:" + this.xaF.finderUsername + " action:" + this.xaq.ABw);
      paramb = new d.a();
      paramb.c((a)this.xaF);
      parambid = new asq();
      parambid.setBaseResponse(new jh());
      parambid.getBaseResponse().Tef = new eaf();
      paramb.d((a)parambid);
      paramb.TW("/cgi-bin/micromsg-bin/finderfav");
      paramb.vD(3715);
      c(paramb.bgN());
      Log.i(this.TAG, "likeId:" + this.xaG + " CgiFinderLikeComment init " + this.xaF.xbk + " and userName " + this.xaq.ABv.getUserName() + " nickname " + this.xaq.ABv.getNickName() + " totalCount:" + this.xaq.ABv.getLikeCount());
      AppMethodBeat.o(274324);
      return;
      l = this.xaq.feedId;
      break;
      i = 2;
      break label161;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.l
 * JD-Core Version:    0.7.0.1
 */