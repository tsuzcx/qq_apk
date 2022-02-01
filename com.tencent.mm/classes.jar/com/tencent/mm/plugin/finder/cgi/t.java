package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class t
  extends c<awv>
{
  private static long xbc;
  public static final a xbd;
  private final String TAG;
  private awu xba;
  private final com.tencent.mm.plugin.finder.upload.action.n xbb;
  
  static
  {
    AppMethodBeat.i(165168);
    xbd = new a((byte)0);
    AppMethodBeat.o(165168);
  }
  
  public t(com.tencent.mm.plugin.finder.upload.action.n paramn, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(284937);
    this.xbb = paramn;
    this.TAG = "Finder.CgiFinderLikeComment";
    long l2 = cm.bfD();
    long l1 = l2;
    if (l2 < xbc)
    {
      l1 = xbc;
      xbc = 1L + l1;
    }
    xbc = l1;
    this.xba = new awu();
    paramn = this.xba;
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (com.tencent.mm.plugin.finder.storage.d.dSu())
    {
      l2 = 0L;
      paramn.xbk = l2;
      this.xba.objectNonceId = this.xbb.objectNonceId;
      this.xba.commentId = this.xbb.ACo.dYY().commentId;
      this.xba.xaG = l1;
      if (this.xbb.scene == 1) {
        this.xba.username = z.bdh();
      }
      paramn = this.xba;
      localObject = ao.xcj;
      paramn.yjp = ao.a(parambid);
      this.xba.scene = this.xbb.scene;
      paramn = this.xba;
      if (!this.xbb.ACe) {
        break label507;
      }
      i = 1;
      label214:
      paramn.opType = i;
      paramn = this.xba;
      parambid = com.tencent.mm.plugin.finder.report.n.zWF;
      l1 = this.xbb.feedId;
      parambid = this.xba.yjp;
      if (parambid == null) {
        break label512;
      }
    }
    label512:
    for (int i = parambid.scene;; i = 0)
    {
      paramn.sessionBuffer = com.tencent.mm.plugin.finder.report.n.N(l1, i);
      paramn = ao.xcj;
      paramn = this.xba.yjp;
      parambid = this.xba.yjp;
      i = j;
      if (parambid != null) {
        i = parambid.scene;
      }
      ao.a(paramn, j.listOf(new o(Integer.valueOf(i), Long.valueOf(this.xbb.feedId))));
      if (this.xba.opType == 1) {
        com.tencent.mm.plugin.secinforeport.a.d.Jcm.jq(540999690, 4);
      }
      paramn = new d.a();
      paramn.c((a)this.xba);
      parambid = new awv();
      parambid.setBaseResponse(new jh());
      parambid.getBaseResponse().Tef = new eaf();
      paramn.d((a)parambid);
      paramn.TW("/cgi-bin/micromsg-bin/finderlike");
      paramn.vD(3710);
      c(paramn.bgN());
      Log.i(this.TAG, "CgiFinderLikeComment init " + this.xba.xbk + " and userName " + this.xba.username + " comment:" + this.xbb.ACo);
      AppMethodBeat.o(284937);
      return;
      l2 = this.xbb.feedId;
      break;
      label507:
      i = 2;
      break label214;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment$Companion;", "", "()V", "GlobalLikeCommentId", "", "getGlobalLikeCommentId", "()J", "setGlobalLikeCommentId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.t
 * JD-Core Version:    0.7.0.1
 */