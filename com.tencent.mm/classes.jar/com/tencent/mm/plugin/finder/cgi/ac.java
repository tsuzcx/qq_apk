package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.upload.action.n;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends c<bcs>
{
  public static final ac.a AzC;
  private static long AzF;
  private final n AzD;
  private bcr AzE;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(165168);
    AzC = new ac.a((byte)0);
    AppMethodBeat.o(165168);
  }
  
  public ac(n paramn, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336280);
    this.AzD = paramn;
    this.TAG = "Finder.CgiFinderLikeComment";
    long l2 = cn.bDv();
    long l1 = l2;
    if (l2 < AzF)
    {
      l1 = AzF;
      AzF = 1L + l1;
    }
    AzF = l1;
    this.AzE = new bcr();
    paramn = this.AzE;
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eQI())
    {
      l2 = 0L;
      paramn.hKN = l2;
      this.AzE.objectNonceId = this.AzD.objectNonceId;
      this.AzE.commentId = this.AzD.Gdp.eZI().commentId;
      this.AzE.AyP = l1;
      if (this.AzD.scene == 1) {
        this.AzE.username = com.tencent.mm.model.z.bAW();
      }
      paramn = this.AzE;
      localObject = bi.ABn;
      paramn.CJv = bi.a(parambui);
      this.AzE.scene = this.AzD.scene;
      paramn = this.AzE;
      if (!this.AzD.GaB) {
        break label505;
      }
      i = 1;
      label214:
      paramn.opType = i;
      paramn = this.AzE;
      localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      l1 = this.AzD.feedId;
      localObject = this.AzE.CJv;
      if (localObject != null) {
        break label510;
      }
      i = 0;
      label254:
      paramn.sessionBuffer = com.tencent.mm.plugin.finder.report.z.p(l1, i);
      paramn = bi.ABn;
      paramn = this.AzE.CJv;
      localObject = this.AzE.CJv;
      if (localObject != null) {
        break label519;
      }
    }
    label519:
    for (int i = j;; i = ((atz)localObject).scene)
    {
      bi.a(paramn, p.listOf(new r(Integer.valueOf(i), Long.valueOf(this.AzD.feedId))), parambui);
      if (this.AzE.opType == 1) {
        com.tencent.mm.plugin.secinforeport.a.d.Pmb.kY(540999690, 4);
      }
      paramn = new c.a();
      paramn.otE = ((a)this.AzE);
      parambui = new bcs();
      parambui.setBaseResponse(new kd());
      parambui.getBaseResponse().akjO = new etl();
      paramn.otF = ((a)parambui);
      paramn.uri = "/cgi-bin/micromsg-bin/finderlike";
      paramn.funcId = 3710;
      c(paramn.bEF());
      Log.i(this.TAG, "CgiFinderLikeComment init " + this.AzE.hKN + " and userName " + this.AzE.username + " comment:" + this.AzD.Gdp);
      AppMethodBeat.o(336280);
      return;
      l2 = this.AzD.feedId;
      break;
      label505:
      i = 2;
      break label214;
      label510:
      i = ((atz)localObject).scene;
      break label254;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ac
 * JD-Core Version:    0.7.0.1
 */