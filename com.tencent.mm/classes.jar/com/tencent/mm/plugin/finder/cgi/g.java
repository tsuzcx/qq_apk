package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.upload.action.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class g
  extends r<alq>
{
  private static long qWX;
  public static final a qWY;
  private final String TAG;
  private alp qWV;
  private final i qWW;
  
  static
  {
    AppMethodBeat.i(165168);
    qWY = new a((byte)0);
    AppMethodBeat.o(165168);
  }
  
  public g(i parami, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201108);
    this.qWW = parami;
    this.TAG = "Finder.CgiFinderLikeComment";
    long l2 = ce.azI();
    long l1 = l2;
    if (l2 < qWX)
    {
      l1 = qWX;
      qWX = 1L + l1;
    }
    qWX = l1;
    this.qWV = new alp();
    parami = this.qWV;
    Object localObject = b.rCU;
    if (b.cyx())
    {
      l2 = 0L;
      parami.qXP = l2;
      this.qWV.objectNonceId = this.qWW.objectNonceId;
      this.qWV.commentId = this.qWW.rOg.field_actionInfo.EDq.commentId;
      this.qWV.qWK = l1;
      if (this.qWW.scene == 1) {
        this.qWV.username = u.axE();
      }
      parami = this.qWV;
      localObject = q.qXH;
      parami.EDL = q.a(paramanm);
      this.qWV.scene = this.qWW.scene;
      parami = this.qWV;
      if (!this.qWW.rNX) {
        break label413;
      }
    }
    label413:
    for (int i = 1;; i = 2)
    {
      parami.opType = i;
      parami = this.qWV;
      paramanm = d.rxr;
      parami.sessionBuffer = d.G(this.qWW.dig, this.qWV.EDL.scene);
      parami = new b.a();
      parami.c((a)this.qWV);
      paramanm = new alq();
      paramanm.setBaseResponse(new BaseResponse());
      paramanm.getBaseResponse().ErrMsg = new crm();
      parami.d((a)paramanm);
      parami.Am("/cgi-bin/micromsg-bin/finderlike");
      parami.op(3710);
      c(parami.aAz());
      ac.i(this.TAG, "CgiFinderLikeComment init " + this.qWV.qXP + " and userName " + this.qWV.username + " comment:" + this.qWW.rOg);
      AppMethodBeat.o(201108);
      return;
      l2 = this.qWW.dig;
      break;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment$Companion;", "", "()V", "GlobalLikeCommentId", "", "getGlobalLikeCommentId", "()J", "setGlobalLikeCommentId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.g
 * JD-Core Version:    0.7.0.1
 */