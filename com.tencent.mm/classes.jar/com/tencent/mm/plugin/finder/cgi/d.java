package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.k;
import com.tencent.mm.plugin.finder.upload.action.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class d
  extends an<ajo>
{
  private static long qos;
  public static final a qot;
  private final String TAG;
  private ajn qoq;
  private final f qor;
  
  static
  {
    AppMethodBeat.i(165168);
    qot = new a((byte)0);
    AppMethodBeat.o(165168);
  }
  
  public d(f paramf, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197255);
    this.qor = paramf;
    this.TAG = "Finder.CgiFinderLikeComment";
    long l2 = ce.asR();
    long l1 = l2;
    if (l2 < qos)
    {
      l1 = qos;
      qos = 1L + l1;
    }
    qos = l1;
    this.qoq = new ajn();
    paramf = this.qoq;
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cpa())
    {
      l2 = 0L;
      paramf.objectId = l2;
      this.qoq.objectNonceId = this.qor.objectNonceId;
      this.qoq.commentId = this.qor.qRY.field_actionInfo.Dkk.commentId;
      this.qoq.qou = l1;
      if (this.qor.scene == 1) {
        this.qoq.username = u.aqO();
      }
      paramf = this.qoq;
      localObject = am.KJy;
      paramf.Dkw = am.a(paramdzp);
      this.qoq.scene = this.qor.scene;
      paramf = this.qoq;
      if (!this.qor.qRK) {
        break label413;
      }
    }
    label413:
    for (int i = 1;; i = 2)
    {
      paramf.opType = i;
      paramf = this.qoq;
      paramdzp = com.tencent.mm.plugin.finder.report.b.qFq;
      paramf.sessionBuffer = com.tencent.mm.plugin.finder.report.b.am(this.qor.feedId, this.qoq.Dkw.scene);
      paramf = new b.a();
      paramf.c((a)this.qoq);
      paramdzp = new ajo();
      paramdzp.setBaseResponse(new BaseResponse());
      paramdzp.getBaseResponse().ErrMsg = new cmf();
      paramf.d((a)paramdzp);
      paramf.wg("/cgi-bin/micromsg-bin/finderlike");
      paramf.nB(3710);
      c(paramf.atI());
      ad.i(this.TAG, "CgiFinderLikeComment init " + this.qoq.objectId + " and userName " + this.qoq.username + " comment:" + this.qor.qRY);
      AppMethodBeat.o(197255);
      return;
      l2 = this.qor.feedId;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment$Companion;", "", "()V", "GlobalLikeCommentId", "", "getGlobalLikeCommentId", "()J", "setGlobalLikeCommentId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.d
 * JD-Core Version:    0.7.0.1
 */