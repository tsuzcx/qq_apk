package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.k;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class u
  extends c<awv>
{
  private static long xaH;
  public static final a xbf;
  private final String TAG;
  private long xaG;
  private awu xba;
  private final k xbe;
  
  static
  {
    AppMethodBeat.i(165171);
    xbf = new a((byte)0);
    AppMethodBeat.o(165171);
  }
  
  public u(k paramk, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(270382);
    this.xbe = paramk;
    this.TAG = "Finder.CgiFinderLikeFeed";
    this.xaG = cm.bfD();
    long l;
    if (this.xaG < xaH)
    {
      l = xaH;
      xaH = 1L + l;
      this.xaG = l;
    }
    xaH = this.xaG;
    this.xba = new awu();
    paramk = this.xba;
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (com.tencent.mm.plugin.finder.storage.d.dSu())
    {
      l = 0L;
      paramk.xbk = l;
      this.xba.objectNonceId = this.xbe.objectNonceId;
      this.xba.xaG = this.xaG;
      this.xba.username = z.bdh();
      this.xba.scene = this.xbe.scene;
      paramk = this.xba;
      if (!this.xbe.ACe) {
        break label661;
      }
      i = 3;
      label175:
      paramk.opType = i;
      paramk = this.xba;
      if (!this.xbe.ABX) {
        break label666;
      }
      i = 1;
      label197:
      paramk.yBs = i;
      paramk = this.xba;
      localObject = ao.xcj;
      paramk.yjp = ao.a(parambid);
      paramk = this.xba;
      parambid = n.zWF;
      l = this.xbe.feedId;
      parambid = this.xba.yjp;
      if (parambid == null) {
        break label671;
      }
    }
    label661:
    label666:
    label671:
    for (int i = parambid.scene;; i = 0)
    {
      paramk.sessionBuffer = n.N(l, i);
      paramk = ao.xcj;
      paramk = this.xba.yjp;
      parambid = this.xba.yjp;
      i = j;
      if (parambid != null) {
        i = parambid.scene;
      }
      ao.a(paramk, j.listOf(new o(Integer.valueOf(i), Long.valueOf(this.xbe.feedId))));
      if (this.xba.opType == 3) {
        com.tencent.mm.plugin.secinforeport.a.d.Jcm.jq(540999691, 5);
      }
      Log.i(this.TAG, "likeId:" + this.xaG + " objectId:" + this.xba.xbk + " opType:" + this.xba.opType + " likeId:" + this.xba.xaG + " username:" + this.xba.username + " action:" + this.xbe.ACe + ", private:" + this.xbe.ABX);
      paramk = new d.a();
      paramk.c((a)this.xba);
      parambid = new awv();
      parambid.setBaseResponse(new jh());
      parambid.getBaseResponse().Tef = new eaf();
      paramk.d((a)parambid);
      paramk.TW("/cgi-bin/micromsg-bin/finderlike");
      paramk.vD(3710);
      c(paramk.bgN());
      Log.i(this.TAG, "likeId:" + this.xaG + " CgiFinderLikeComment init " + this.xba.xbk + " and userName " + this.xbe.ABv.getUserName() + " nickname " + this.xbe.ABv.getNickName() + " totalCount:" + this.xbe.ABv.getLikeCount());
      AppMethodBeat.o(270382);
      return;
      l = this.xbe.feedId;
      break;
      i = 4;
      break label175;
      i = 0;
      break label197;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.u
 * JD-Core Version:    0.7.0.1
 */