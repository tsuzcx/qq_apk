package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.k;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  extends c<bcs>
{
  private static long AyQ;
  public static final a AzG;
  private long AyP;
  private bcr AzE;
  private final k AzH;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(165171);
    AzG = new a((byte)0);
    AppMethodBeat.o(165171);
  }
  
  public ad(k paramk, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336286);
    this.AzH = paramk;
    this.TAG = "Finder.CgiFinderLikeFeed";
    this.AyP = cn.bDv();
    long l;
    if (this.AyP < AyQ)
    {
      l = AyQ;
      AyQ = 1L + l;
      this.AyP = l;
    }
    AyQ = this.AyP;
    this.AzE = new bcr();
    paramk = this.AzE;
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eQI())
    {
      l = 0L;
      paramk.hKN = l;
      this.AzE.objectNonceId = this.AzH.objectNonceId;
      this.AzE.AyP = this.AyP;
      this.AzE.username = com.tencent.mm.model.z.bAW();
      this.AzE.scene = this.AzH.scene;
      paramk = this.AzE;
      if (!this.AzH.GaB) {
        break label745;
      }
      i = 3;
      label175:
      paramk.opType = i;
      paramk = this.AzE;
      if (!this.AzH.Gdb) {
        break label750;
      }
      i = 1;
      label197:
      paramk.Dom = i;
      paramk = this.AzE;
      localObject = bi.ABn;
      paramk.CJv = bi.a(parambui);
      paramk = this.AzE;
      localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      l = this.AzH.feedId;
      localObject = this.AzE.CJv;
      if (localObject != null) {
        break label755;
      }
      i = 0;
      label255:
      paramk.sessionBuffer = com.tencent.mm.plugin.finder.report.z.p(l, i);
      paramk = bi.ABn;
      paramk = this.AzE.CJv;
      localObject = this.AzE.CJv;
      if (localObject != null) {
        break label764;
      }
    }
    label745:
    label750:
    label755:
    label764:
    for (int i = j;; i = ((atz)localObject).scene)
    {
      bi.a(paramk, p.listOf(new r(Integer.valueOf(i), Long.valueOf(this.AzH.feedId))), parambui);
      if (this.AzE.opType == 3)
      {
        paramk = new gdd();
        paramk.acaW = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQo("ce_feed_like"));
        paramk.acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
        parambui = this.AzE.CJv;
        if (parambui != null) {
          parambui.ZEq = new b(paramk.toByteArray());
        }
        com.tencent.mm.plugin.secinforeport.a.d.Pmb.kY(540999691, 5);
      }
      Log.i(this.TAG, "likeId:" + this.AyP + " objectId:" + this.AzE.hKN + " opType:" + this.AzE.opType + " likeId:" + this.AzE.AyP + " username:" + this.AzE.username + " action:" + this.AzH.GaB + ", private:" + this.AzH.Gdb);
      paramk = new c.a();
      paramk.otE = ((a)this.AzE);
      parambui = new bcs();
      parambui.setBaseResponse(new kd());
      parambui.getBaseResponse().akjO = new etl();
      paramk.otF = ((a)parambui);
      paramk.uri = "/cgi-bin/micromsg-bin/finderlike";
      paramk.funcId = 3710;
      c(paramk.bEF());
      Log.i(this.TAG, "likeId:" + this.AyP + " CgiFinderLikeComment init " + this.AzE.hKN + " and userName " + this.AzH.GcF.getUserName() + " nickname " + this.AzH.GcF.getNickName() + " totalCount:" + this.AzH.GcF.getLikeCount());
      AppMethodBeat.o(336286);
      return;
      l = this.AzH.feedId;
      break;
      i = 4;
      break label175;
      i = 0;
      break label197;
      i = ((atz)localObject).scene;
      break label255;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ad
 * JD-Core Version:    0.7.0.1
 */